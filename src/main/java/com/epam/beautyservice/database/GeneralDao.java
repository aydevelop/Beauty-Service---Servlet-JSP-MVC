package com.epam.beautyservice.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GeneralDao<T> {
    final DBManager manager = DBManager.getInstance();

    List<T> queryAll();

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
}
