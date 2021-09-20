package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.ExtraMapper;
import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements GeneralDao<Service> {
    private static final String SQL_READ_All = "SELECT * FROM service";
    private static final String SQL_READ = "SELECT * FROM service WHERE id=?";
    private static final String SQL_READ_BY_ID = "SELECT * FROM service WHERE service.id = ?";
    private static final String SQL_READ_All_WITH_MASTER_AND_CATEGORY = "SELECT service.*, category.name_ua, category.name_en, GROUP_CONCAT(user_service.master_id) " +
            " FROM service LEFT JOIN category ON service.category_id = category.id" +
            " LEFT JOIN user_service ON user_service.service_id = service.id" +
            " GROUP BY service.id";

    @Override
    public List<Service> query(String sql, ExtraMapper<Service> mapper) {
        List<Service> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Service service = getService(rs);
                if (mapper != null) {
                    mapper.map(service, rs);
                }
                list.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Service> queryAll() {
        return query(SQL_READ_All, null);
    }

    public List<Service> queryAllWithMasterAndCategory() {
        return query(SQL_READ_All_WITH_MASTER_AND_CATEGORY, (service, st) -> {
            service.setCategoryId(st.getString(8));
            service.setMasterIds(st.getString(11));
        });
    }

    @Override
    public Service findById(long id) {
        Service service = new Service();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(SQL_READ_BY_ID);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                service = getService(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return service;
    }

    @Override
    public void create(Service element) {

    }

    @Override
    public void edit(long id, Service element) {

    }

    private Service getService(ResultSet rs) throws SQLException {
        Service item = new Service();
        item.setId(rs.getLong("id"));
        item.setName_ua(rs.getString("name_ua"));
        item.setName_en(rs.getString("name_en"));
        item.setPrice(rs.getDouble("price"));
        item.setImage(rs.getString("image"));
        item.setDescription_ua(rs.getString("description_ua"));
        item.setDescription_en(rs.getString("description_en"));
        item.setCategoryId(rs.getString("category_id"));
        return item;
    }
}
