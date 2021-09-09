package com.epam.jt.name.database;

import com.epam.jt.name.model.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao {
    private static final String SQL_READ_All = "SELECT * FROM service";
    private static final String SQL_READ = "SELECT * FROM service WHERE id=?";

    public List<Service> findAll() {
        List<Service> list = new ArrayList<Service>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBManager.getInstance().getConnection();
            st = con.createStatement();
            rs = st.executeQuery(SQL_READ);

            while (rs.next()) {
                list.add(getService(rs));
            }

            con.commit();
        } catch (SQLException e) {
            rollback(con);
        } finally {
            close(con);
        }

        return list;
    }

    public Service find(int id) {
        List<Service> items = findAll();

        for (Service item : items) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    private Service getService(ResultSet rs) throws SQLException {
        Service item = new Service();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("name"));
        item.setPrice(rs.getDouble("price"));
        item.setImage(rs.getString("image"));
        item.setDescriptionEn(rs.getString("description_en"));
        item.setDescriptionUa(rs.getString("description_ua"));
        item.setCategoryId(rs.getInt("category_id"));
        item.setMasterId(rs.getInt("master_id"));
        return item;
    }

    private void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
