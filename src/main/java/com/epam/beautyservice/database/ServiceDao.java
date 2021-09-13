package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.ExtraMapper;
import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements GeneralDao<Service> {
    private static final String SQL_READ_All = "SELECT * FROM service";
    private static final String SQL_READ = "SELECT * FROM service WHERE id=?";
    private static final String SQL_READ_All_WITH_CATEGORY = "SELECT * FROM service JOIN category  ON service.category_id = category.id";

    @Override
    public List<Service> query(String sql, ExtraMapper<Service> mapper) {
        List<Service> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL_READ_All);

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

    @Override
    public Service findById(long id) {
        return null;
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
        item.setCategoryId(rs.getInt("category_id"));
        return item;
    }
}
