<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="title" value="Order Create" scope="page"/>
<%@ include file="/WEB-INF/fragment/header.jspf" %>
<%@ page import="com.epam.beautyservice.model.Service" %>


<form action="/user/order-create" method="post">
    <input type="hidden" name="service-id" value="${service.id}">
    <div style="font-size: 22px; margin: 50px; text-align: center">
        <h3 style="margin-bottom: 15px">Create Order</h3>
        <hr/>
        <div style="margin-top: 15px">
            <% Service service = (Service) request.getAttribute("service"); %>
            <% String locale = (String) request.getSession().getAttribute("defaultLocale"); %>
            <%= service.getName(locale) %>
        </div>
        <div style="margin-top: 15px">$ ${service.price}</div>
        <br/>
        <hr>
        <br/>
        Master: <select style="margin-bottom: 15px; font-size: 20px" name="master-id">
        <c:forEach items="${masters}" var="master">
            <option value="${master.id}">${master.first_name} ${master.last_name}</option>
        </c:forEach>
    </select>
        <hr>
        Slot: <select style="margin-top: 15px; margin-bottom: 15px; font-size: 20px" name="slot-id">
        <c:forEach items="${slots}" var="slot">
            <option value="${slot.id}">${slot.name}</option>
        </c:forEach>
    </select>
        <br>
        <p>Date: <input type="text" name="date" id="datepicker"></p>
        <br/>
        <hr>
        <br/>
        <br/>
        <button style="padding: 10px 40px" type="submit">Take Service</button>
    </div>
</form>

<script>
    $(function () {
        $("#datepicker").datepicker({minDate: new Date(), dateFormat: 'yy-mm-dd'});
    });
</script>

<%@include file="../../fragment/footer.jspf" %>
