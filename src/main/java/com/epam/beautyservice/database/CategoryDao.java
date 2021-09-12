package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GeneralDao<Category> {
    private final String SQL_READ_All = "SELECT * FROM category";
    private final String SQL_READ_BY_ID = "SELECT * FROM category WHERE id=?";

    @Override
    public List<Category> query(String sql) {
        List<Category> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(getCategory(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<Category> queryAll() {
        return query(SQL_READ_All);
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
