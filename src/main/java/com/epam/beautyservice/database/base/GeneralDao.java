package com.epam.beautyservice.database.base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface GeneralDao<T> {
    final DBManager manager = DBManager.getInstance();

    List<T> query(String sql);

    T findById(long id);

    void create(T element);

    void edit(long id, T element);

    default void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    default void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    default boolean doesColumnExist(ResultSet rs, String... columns) throws SQLException {
        List<String> all = new ArrayList<>();

        ResultSetMetaData meta = rs.getMetaData();
        int numCol = meta.getColumnCount();
        for (int i = 1; i <= numCol; i++) {
            all.add(meta.getColumnName(i));
        }
        

        for (String item : columns) {
            if (!all.contains(item)) {
                return false;
            }
        }

        return true;
    }
}
