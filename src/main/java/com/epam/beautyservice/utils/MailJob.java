package com.epam.beautyservice.utils;

import com.epam.beautyservice.database.OrderDao;
import com.epam.beautyservice.database.base.UnitOfWork;
import com.epam.beautyservice.model.Order;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class MailJob implements Runnable {
    UnitOfWork db = new UnitOfWork();

    @Override
    public void run() {
        OrderDao orderDao = db.getOrders();
        List<Order> orders = orderDao.queryAll();
        orders = orders.stream().filter(q -> q.getFeedbackRating() == null).collect(Collectors.toList());

        LocalDate currentDate = LocalDate.now();
        LocalDate currentDateMinus1Days = currentDate.minusDays(1);

        for (Order item : orders) {
            LocalDate orderCreationDate = LocalDate.parse(item.getDate());
            if (currentDateMinus1Days.isAfter(orderCreationDate)) {
                sendEmail("http://localhost:8080/user/order-feedback?id=" + item.getId());
                item.setFeedbackRating("0");
                db.getOrders().edit(item.getId(), item);
            }
        }
    }


    public void sendEmail(String url) {
        String to = "beautyservice@gmail.com";
        String from = "toaddress@gmail.com";
        String host = "smtp.mailtrap.io";
        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "2525");
        properties.put("mail.smtp.ssl.enable", "no");
        properties.put("mail.smtp.tls.enable", "yes");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("5bdf2e41b0e0af", "a113d5c4463443");
            }
        });

        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("It is possible to leave a review ");

            // Now set the actual message
            message.setText(url);

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        int stop = 101;
    }
}
