package com.epam.jt.name.database;

import java.util.List;

public interface GeneralDaoDao<T> {
    final DBManager manager = DBManager.getInstance();

    List<T> queryAll();

    T findById(long id);

    void create(T element);

    void edit(long id, T element);
}
