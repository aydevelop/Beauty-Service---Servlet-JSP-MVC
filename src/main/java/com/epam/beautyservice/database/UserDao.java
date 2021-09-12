package com.epam.beautyservice.database;

import com.epam.beautyservice.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GeneralDao<User> {
    private static final String SQL_READ_All = "SELECT * FROM user";
    private static final String SQL_READ = "SELECT * FROM user WHERE id=?";
    private static final String SQL_READ_MASTER = "SELECT * FROM user WHERE role_id=4";
    private static final String SQL_READ_WITH_RATING = "SELECT * FROM user" +
            " LEFT JOIN user_service ON user_service.master_id = user.id" +
            " LEFT JOIN `order` AS ord ON ord.user_service_id = user_service.id ";

    @Override
    public List<User> queryAll() {
        List<User> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_READ_All);

            while (rs.next()) {
                list.add(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public User findById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(User element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(long id, User element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<User> queryMaster() {
        List<User> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_READ_MASTER);

            while (rs.next()) {
                list.add(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<User> queryAllWithRating() {
        List<User> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_READ_WITH_RATING);

            while (rs.next()) {
                list.add(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User item = new User();
        item.setId(rs.getLong("id"));
        item.setEmail(rs.getString("email"));
        item.setPassword(rs.getString("password"));
        item.setFirst_name(rs.getString("first_name"));
        item.setLast_name(rs.getString("last_name"));
        item.setRole_id(rs.getInt("role_id"));
        item.setRating(rs.getInt("feedback_rating"));
        return item;
    }


}
