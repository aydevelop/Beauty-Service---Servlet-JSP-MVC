package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.ExtraMapper;
import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GeneralDao<Category> {
    private static final String SQL_READ_All = "SELECT * FROM category";

    @Override
    public List<Category> query(String sql, ExtraMapper<Category> mapper) {
        List<Category> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Category category = getCategory(rs);
                if (mapper != null) {
                    mapper.map(category, rs);
                }
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<Category> queryAll() {
        return query(SQL_READ_All, null);
    }

    @Override
    public Category findById(long id) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void create(Category element) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void edit(long id, Category element) {
        throw new UnsupportedOperationException("Not supported");
    }

    private Category getCategory(ResultSet rs) throws SQLException {
        Category item = new Category();
        item.setId(rs.getLong("id"));
        item.setName_ua(rs.getString("name_ua"));
        item.setName_en(rs.getString("name_en"));
        return item;
    }
}
