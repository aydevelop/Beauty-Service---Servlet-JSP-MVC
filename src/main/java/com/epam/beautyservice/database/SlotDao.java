package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.ExtraMapper;
import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.Slot;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SlotDao implements GeneralDao<Slot> {
    private static final String SQL_READ_All = "SELECT * FROM slot";

    @Override
    public List<Slot> query(String sql, ExtraMapper<Slot> mapper) {
        List<Slot> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Slot slot = getSlot(rs);
                if (mapper != null) {
                    mapper.map(slot, rs);
                }
                list.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Slot> queryAll() {
        return query(SQL_READ_All, null);
    }

    @Override
    public Slot findById(long id) {
        return null;
    }

    @Override
    public void create(Slot element) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void edit(long id, Slot element) {
        throw new UnsupportedOperationException("Not supported");
    }

    private Slot getSlot(ResultSet rs) throws SQLException {
        Slot item = new Slot();
        item.setId(rs.getLong("id"));
        item.setName(rs.getString("slot"));
        return item;
    }
}
