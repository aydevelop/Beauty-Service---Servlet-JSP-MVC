package com.epam.jt.name.model;

import java.util.Date;

public class Order extends Entity {
    private static final long serialVersionUID = 2322302708945348585L;
    private static Date dataTime;
    private static boolean isPaid;
    private static boolean isCanceled;
    private static boolean isDone;
    private static String feedbackText;
    private static String feedbackRating;
    private static int serviceId;
    private static int clientId;
}
