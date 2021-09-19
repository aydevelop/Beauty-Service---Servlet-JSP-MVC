package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.ExtraMapper;
import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GeneralDao<User> {
    private static final String SQL_READ_All = "SELECT * FROM user";
    private static final String SQL_READ = "SELECT * FROM user WHERE id=?";
    private static final String SQL_READ_BY_EMAIL = "SELECT * FROM user LEFT JOIN role ON role.id = user.role_id WHERE email=?";
    private static final String SQL_READ_MASTER = "SELECT * FROM user LEFT JOIN role ON role.id = user.role_id WHERE role.name = 'master'";
    private static final String SQL_READ_MASTER_BY_SERVICE = "SELECT user.* FROM user_service LEFT JOIN user ON user.id = user_service.master_id WHERE user_service.service_id=?";
    
    private static final String SQL_READ_WITH_RATING = "SELECT user.*, SUM(`order`.feedback_rating) FROM user " +
            "LEFT JOIN `order` ON `order`.master_id = user.id " +
            "GROUP BY user.email " +
            "ORDER BY `order`.feedback_rating DESC";

    private static final String SQL_EDIT_LANG = "UPDATE user SET lang=? where id=?";
    private static final String SQL_CREATE = "INSERT INTO user (email, password, first_name, last_name, role_id) VALUES (?, ?, ?, ?, 2)";

    @Override
    public List<User> query(String sql, ExtraMapper<User> mapper) {
        List<User> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                User user = getUser(rs);
                if (mapper != null) {
                    mapper.map(user, rs);
                }
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    public List<User> queryAll() {
        return query(SQL_READ_MASTER, null);
    }

    public List<User> findAllByService(long id) {
        List<User> users = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(SQL_READ_MASTER_BY_SERVICE);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                users.add(getUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findById(long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(User user) {
        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(SQL_CREATE);
            int k = 1;
            pstmt.setString(k++, user.getEmail());
            pstmt.setString(k++, user.getPassword());
            pstmt.setString(k++, user.getFirst_name());
            pstmt.setString(k++, user.getLast_name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(long id, User element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editLang(long id, String lang) {
        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(SQL_EDIT_LANG);
            pstmt.setString(1, lang);
            pstmt.setLong(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> queryMaster() {
        return query(SQL_READ_All, null);
    }

    public User findUserByEmail(String email) {
        User user = new User();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(SQL_READ_BY_EMAIL);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = getUser(rs);
                user.setRole(rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> queryAllWithRating() {
        return query(SQL_READ_WITH_RATING, (user, rs) -> {
            user.setRating(rs.getInt(8));
        });
    }

    private User getUser(ResultSet rs) throws SQLException {
        User item = new User();
        item.setId(rs.getLong("id"));
        item.setEmail(rs.getString("email"));
        item.setPassword(rs.getString("password"));
        item.setFirst_name(rs.getString("first_name"));
        item.setLast_name(rs.getString("last_name"));
        item.setRole_id(rs.getInt("role_id"));
        item.setLang(rs.getString("lang"));
        item.setRating(5);
        return item;
    }
}
