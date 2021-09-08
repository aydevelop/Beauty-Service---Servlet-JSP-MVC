package com.epam.jt.name.database.dao;

import com.epam.jt.name.database.entity.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao extends BaseDao {
    private final String SQL_READ_All = "SELECT * FROM category";
    private final String SQL_READ_BY_ID = "SELECT * FROM category WHERE id=?";


    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_READ_All);

            while (rs.next()) {
                list.add(getCategory(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private Category getCategory(ResultSet rs) throws SQLException {
        Category item = new Category();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("name"));
        return item;
    }

}
