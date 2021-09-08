package com.epam.jt.name.database.dao;

import com.epam.jt.name.database.DBManager;

public class BaseDao {
    protected final DBManager manager;

    public BaseDao() {
        manager = DBManager.getInstance();
    }
    
}
