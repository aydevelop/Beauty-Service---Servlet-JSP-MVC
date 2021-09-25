package com.epam.beautyservice.database;

import com.epam.beautyservice.database.base.ExtraMapper;
import com.epam.beautyservice.database.base.GeneralDao;
import com.epam.beautyservice.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao implements GeneralDao<Order> {
    private static final String SQL_READ_All = "SELECT * FROM `order`";
    private static final String SQL_READ_BY_ID = "SELECT * FROM `order` WHERE `order`.id = ?";
    private static final String SQL_READ_All_WITH_USER_SERVICE = "SELECT `order`.*, service.*, slot.*," +
            "client.email AS client_email, client.first_name AS 'client_first_name', client.last_name AS 'client_last_name', " +
            "master.email AS master_email, master.first_name AS 'master_first_name', master.last_name AS 'master_last_name', category.* FROM `order` " +
            " LEFT JOIN user AS client ON client.id = `order`.client_id" +
            " LEFT JOIN user AS master ON master.id = `order`.master_id" +
            " LEFT JOIN service ON service.id = `order`.service_id" +
            " LEFT JOIN category ON category.id = service.category_id" +
            " LEFT JOIN slot ON slot.id = order.slot_id";

    private static final String SQL_EDIT = "UPDATE `order` SET date=?, status=?, feedback_text = ?, feedback_rating = ?, slot_id = ? where id=?";
    private static final String SQL_CREATE = "INSERT INTO `order` (date, client_id, master_id, service_id) VALUES (?, ?, ?, ?)";

    @Override
    public List<Order> query(String sql, ExtraMapper<Order> mapper) {
        List<Order> list = new ArrayList<>();

        try (Connection con = manager.getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Order order = getOrder(rs);
                if (mapper != null) {
                    mapper.map(order, rs);
                }
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<Order> queryAll() {
        return query(SQL_READ_All, null);
    }

    public List<Order> queryAllWithUserServiceAndSlot() {
        return query(SQL_READ_All_WITH_USER_SERVICE, (order, rs) -> {
            User client = new User();
            client.setEmail(rs.getString(20));
            client.setFirst_name(rs.getString(21));
            client.setLast_name(rs.getString(22));
            order.setClient(client);

            User master = new User();
            master.setEmail(rs.getString(23));
            master.setFirst_name(rs.getString(24));
            master.setLast_name(rs.getString(25));
            order.setMaster(master);

            Service service = new Service();
            service.setName_ua(rs.getString(11));
            service.setName_en(rs.getString(12));
            order.setService(service);

            Category category = new Category();
            category.setName_ua(rs.getString(27));
            category.setName_en(rs.getString(28));
            order.setCategory(category);

            Slot slot = new Slot();
            slot.setName(rs.getString(19));
            order.setSlot(slot);
        });
    }

    @Override
    public Order findById(long id) {
        Order order = new Order();

        try (Connection con = manager.getConnection()) {
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
    public void create(Order order) {
        try (Connection con = manager.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(SQL_CREATE);
            int k = 1;
            pstmt.setString(k++, order.getDate());
            pstmt.setInt(k++, order.getClientId());
            pstmt.setInt(k++, order.getMasterId());
            pstmt.setInt(k++, order.getServiceId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void edit(long id, Order order) {
        try (Connection con = manager.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement(SQL_EDIT);
            int k = 1;

            pstmt.setString(k++, order.getDate());
            pstmt.setString(k++, order.getStatus());
            pstmt.setString(k++, order.getFeedbackText());
            pstmt.setString(k++, order.getFeedbackRating());
            pstmt.setLong(k++, order.getSlotId());
            pstmt.setLong(k++, order.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Order getOrder(ResultSet rs) throws SQLException {
        Order order = new Order();
        try {
            order.setId(rs.getLong("id"));
            order.setDate(rs.getString("date"));
            order.setStatus(rs.getString("status"));
            order.setFeedbackText(rs.getString("feedback_text"));
            order.setFeedbackRating(rs.getString("feedback_rating"));
            order.setSlotId(rs.getInt("slot_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }
}