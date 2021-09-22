<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="pre_title" value='order' scope="session"/>
<%@ include file="/WEB-INF/fragment/fmt.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>
<%@ page import="com.epam.beautyservice.model.Service" %>


<form action="/user/order-create" method="post">
    <input type="hidden" name="service-id" value="${service.id}">
    <div style="font-size: 22px; margin: 50px; text-align: center">
        <h3 style="margin-bottom: 15px"><fmt:message key="order"/></h3>
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
        <fmt:message key="master"/>: <select style="margin-bottom: 15px; font-size: 20px" name="master-id">
        <c:forEach items="${masters}" var="master">
            <option value="${master.id}">${master.first_name} ${master.last_name}</option>
        </c:forEach>
    </select>
        <hr>
        <fmt:message key="timeslot"/>: <select style="margin-top: 15px; margin-bottom: 15px; font-size: 20px"
                                               name="slot-id">
        <c:forEach items="${slots}" var="slot">
            <option value="${slot.id}">${slot.name}</option>
        </c:forEach>
    </select>
        <br>
        <p><fmt:message key="date"/>: <input style="font-size: 18px" autocomplete="off" type="text" name="date"
                                             id="datepicker"></p>
        <br/>
        <hr>
        <br/>
        <br/>
        <button style="padding: 10px 40px" type="submit"><fmt:message key="sign_up"/></button>
    </div>
</form>

<script>
    $(function () {
        $("#datepicker").datepicker({minDate: new Date(), dateFormat: 'yy-mm-dd'});
    });
</script>

<%@include file="../../fragment/footer.jspf" %>
