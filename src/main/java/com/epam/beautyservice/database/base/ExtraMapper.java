package com.epam.beautyservice.database.base;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ExtraMapper<T> {
    void map(T t, ResultSet rs) throws SQLException;
}
