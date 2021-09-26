<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="pre_title" value='orders' scope="session"/>
<%@ include file="/WEB-INF/fragment/fmt.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>


<h2 style="margin-top: 50px; margin-bottom: 50px;text-align: center">
    <fmt:message key="orders"/>
</h2>
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
            <th><fmt:message key="master_name"/></th>
            <th><fmt:message key="master_email"/></th>
            <th></th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}:</td>
                <td>${order.date}</td>
                <td>${order.slot.name}</td>
                <td width="80">
                    <c:choose>
                        <c:when test="${order.status == 'is_canceled'}">
                            <p>Canceled</p>
                        </c:when>
                        <c:when test="${order.status == 'is_new'}">
                            <p>New</p>
                        </c:when>
                        <c:when test="${order.status == 'is_paid'}">
                            <p>Paid</p>
                        </c:when>
                        <c:otherwise>
                            <p>Done</p>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${order.service.getName(defaultLocale)}</td>
                <td>${order.category.getName(defaultLocale)}</td>
                <td>${order.client.first_name} ${order.client.last_name}</td>
                <td>${order.client.email}</td>
                <td>${order.master.first_name} ${order.master.last_name}</td>
                <td>${order.master.email}</td>
                <td>
                    <button style="padding: 5px; min-width: 100px" type="button">
                        <a style="color: white; text-decoration: none" href="/admin/order-edit?id=${order.id}">
                            <b><fmt:message key="edit"/></b>
                        </a>
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>


<%@include file="../../fragment/footer.jspf" %>