package com.epam.jt.name.database.dao;

import com.epam.jt.name.database.DBManager;
import com.epam.jt.name.database.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String SQL_READ_All = "SELECT * FROM user";
    private static final String SQL_READ = "SELECT * FROM user WHERE id=?";

    public List<User> findAll() {
        List<User> list = new ArrayList<User>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = DBManager.getInstance().getConnection();
            st = con.createStatement();
            rs = st.executeQuery(SQL_READ);

            while (rs.next()) {
                list.add(getUser(rs));
            }

            con.commit();
        } catch (SQLException e) {
            rollback(con);
        } finally {
            close(con);
        }

        return list;
    }

    public User find(int id) {
        List<User> items = findAll();

        for (User item : items) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User item = new User();
        item.setId(rs.getLong("id"));
        item.setLogin(rs.getString("login"));
        item.setEmail(rs.getString("password"));
        item.setPassword(rs.getString("first_name"));
        item.setFirst_name(rs.getString("last_name"));
        item.setLast_name(rs.getString("last_name"));
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
