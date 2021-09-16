<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="title" value="Order Create" scope="page"/>
<%@ include file="/WEB-INF/fragment/header.jspf" %>
<%@ page import="com.epam.beautyservice.model.Service" %>


<form action="/user/order-create" method="post">
    <input type="hidden" name="service-id" value="${service.id}">
    <h1>Create Order ....</h1>
    <div>${service.name_ua}</div>
    <div>${service.price}</div>
    <div>${service.description_ua}</div>

    <% Service service = (Service) request.getAttribute("service"); %>
    <% String locale = (String) request.getSession().getAttribute("defaultLocale"); %>
    <%= service.getName(locale) %>

    <br/>
    <hr>
    <br/>

    <select name="master-id">
        <c:forEach items="${masters}" var="master">
            <option value="${master.id}">${master.first_name} ${master.last_name}</option>
        </c:forEach>
    </select>

    <br/>
    <br/>
    <button style="padding: 10px 40px" type="submit">Take Service</button>
</form>

<%@include file="../../fragment/footer.jspf" %>
