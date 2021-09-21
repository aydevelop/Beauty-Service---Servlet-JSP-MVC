<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="pre_title" value='orders' scope="session"/>
<%@ include file="/WEB-INF/fragment/fmt.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div style="margin-top: 50px; margin-bottom: 50px;text-align: center">
    <h2>
        <fmt:message key="orders"/>
    </h2>
</div>

<div style="margin-bottom: 50px">
</div>
<div>
    <table cellspacing="20">
        <tr>
            <th></th>
            <th width="100px"><fmt:message key="date"/></th>
            <th width="100px"><fmt:message key="timeslot"/></th>
            <th><fmt:message key="status"/></th>
            <th><fmt:message key="service"/></th>
            <th><fmt:message key="category"/></th>
            <th><fmt:message key="client_name"/></th>
            <th><fmt:message key="client_email"/></th>
            <th></th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}: </td>
                <td>${order.date}</td>
                <td>${order.slot.name}</td>
                <td width="80">
                    <c:choose>
                        <c:when test="${order.status == 'is_canceled'}">
                            <p>Is-Canceled</p>
                        </c:when>
                        <c:when test="${order.status == 'is_paid'}">
                            <p>Is-Paid</p>
                        </c:when>
                        <c:otherwise>
                            <p>Is-Done</p>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${order.service.getName(defaultLocale)}</td>
                <td>${order.category.getName(defaultLocale)}</td>
                <td>${order.client.first_name} ${order.client.last_name}</td>
                <td>${order.client.email}</td>
                <td width="150">
                    <c:if test="${order.status != 'is_done'}">
                        <form method="post" action="/master/order-done">
                            <input type="hidden" name="id" value="${order.id}">
                            <button style="padding: 1px" type="submit"><b><fmt:message key="mark_as_done"/></b></button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--    <button style="background-color: darksalmon; color: white; padding: 10px 50px">Save....</button>--%>


<%@include file="../../fragment/footer.jspf" %>