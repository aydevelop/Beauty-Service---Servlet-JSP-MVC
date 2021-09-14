<%@ include file="/WEB-INF/view/base.jspf" %>
<jsp:include page="../header.jsp">
    <jsp:param name="title" value="All Orders"/>
</jsp:include>

<form action="/admin/orders2" method="post">
    <div style="margin-bottom: 50px">
        <h1>Administrator .....</h1>
    </div>
    <div>
        <table cellspacing="20">
            <tr>
                <th width="100px">date-time</th>
                <th>status</th>
                <th>name_ua</th>
                <th>description_ua</th>
                <th>category</th>
                <th>client_name</th>
                <th>client_email</th>
                <th>master_name</th>
                <th>master_email</th>
                <th></th>
            </tr>
            <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.dataTime}</td>
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
                            <%--                        <select name='status-${order.id}'>--%>
                            <%--                            <option value="is_canceled"--%>
                            <%--                                    <c:if test="${order.status == 'is_canceled'}">--%>
                            <%--                                        selected--%>
                            <%--                                    </c:if>>--%>
                            <%--                                Is Canceled--%>
                            <%--                            </option>--%>
                            <%--                            <option value="is_paid"--%>
                            <%--                                    <c:if test="${order.status == 'is_paid'}">--%>
                            <%--                                        selected--%>
                            <%--                                    </c:if>>--%>
                            <%--                                Is Paid--%>
                            <%--                            </option>--%>
                            <%--                            <option value="is_done"--%>
                            <%--                                    <c:if test="${order.status == 'is_done'}">--%>
                            <%--                                        selected--%>
                            <%--                                    </c:if>>--%>
                            <%--                                Is Done--%>
                            <%--                            </option>--%>
                            <%--                        </select>--%>
                    </td>
                    <td>${order.service.name_ua}</td>
                    <td>${order.service.description_ua}</td>
                    <td>${order.category}</td>
                    <td>${order.client.first_name} ${order.client.last_name}</td>
                    <td>${order.client.email}</td>
                    <td>${order.master.first_name} ${order.master.last_name}</td>
                    <td>${order.master.email}</td>
                    <td><a href="/admin/order-edit?id=${order.id}"><b>EDIT</b></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <%--    <button style="background-color: darksalmon; color: white; padding: 10px 50px">Save....</button>--%>
</form>

<%@include file="../footer.jsp" %>