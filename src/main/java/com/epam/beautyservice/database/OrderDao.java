package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.Order;
import com.epam.beautyservice.model.Service;
import com.epam.beautyservice.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements GeneralDao<Order> {
    private static final String SQL_READ_All = "SELECT * FROM `order`";
    private static final String SQL_READ_BY_ID = "SELECT * FROM `order` WHERE `order`.id = ?";
    private static final String SQL_READ_All_WITH_USER_SERVICE = "SELECT `order`.*, service.*, " +
            "client.email AS client_email, client.first_name AS 'client_first_name', client.last_name AS 'client_last_name', " +
            "master.email AS master_email, master.first_name AS 'master_first_name', master.last_name AS 'master_last_name', category.* FROM `order` " +
            " LEFT JOIN user AS client ON client.id = `order`.client_id" +
            " LEFT JOIN user AS master ON master.id = `order`.master_id" +
            " LEFT JOIN service ON service.id = `order`.service_id" +
            " LEFT JOIN category ON category.id = service.category_id";

    @Override
    public List<Order> query(String sql) {
        List<Order> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                list.add(getOrder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Order> queryAll() {
        return query(SQL_READ_All);
    }

    public List<Order> queryAllWithUserService() {
        return query(SQL_READ_All_WITH_USER_SERVICE);
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            PreparedStatement pstmt = con.prepareStatement(SQL_READ_BY_ID);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                order = getOrder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    @Override
    public void create(Order element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(long id, Order element) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        try {

            order.setId(rs.getLong("id"));

            order.setDataTime(rs.getString("data_time"));
            order.setStatus(rs.getString("status"));

            order.setFeedbackText(rs.getString("feedback_text"));
            order.setFeedbackRating(rs.getString("feedback_rating"));

            //boolean checkClient = doesColumnExist(rs, "client_email", "client_first_name", "client_last_name");
            //if (checkClient) {
            User client = new User();
            client.setEmail(rs.getString(17));
            client.setFirst_name(rs.getString(18));
            client.setLast_name(rs.getString(19));
            order.setClient(client);
            //}

            //boolean checkMaster = doesColumnExist(rs, "master_email", "master_first_name", "master_last_name");
            //if (checkMaster) {
            User master = new User();
            master.setEmail(rs.getString(20));
            master.setFirst_name(rs.getString(21));
            master.setLast_name(rs.getString(22));
            order.setMaster(master);
            //}

            //boolean checkService = doesColumnExist(rs, "name_ua", "description_ua");
            //if (checkMaster) {
            Service service = new Service();
            service.setName_ua(rs.getString(10));
            service.setDescription_ua(rs.getString(14));
            order.setService(service);
            order.setCategory(rs.getString(24));

            int stop = 1010;
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }
}