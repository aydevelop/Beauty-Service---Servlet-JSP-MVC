package com.epam.jt.name.database;

import com.epam.jt.name.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GeneralDaoDao<Category> {
    private final String SQL_READ_All = "SELECT * FROM category";
    private final String SQL_READ_BY_ID = "SELECT * FROM category WHERE id=?";


    @Override
    public List<Category> queryAll() {
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

    @Override
    public Category findById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Category element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(long id, Category element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Category getCategory(ResultSet rs) throws SQLException {
        Category item = new Category();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("name"));
        return item;
    }
}
