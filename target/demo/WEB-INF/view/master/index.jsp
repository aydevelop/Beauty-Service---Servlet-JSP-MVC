<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="title" value="Master Page" scope="page"/>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div style="text-align: center">
    <h2>
        Master Orders
    </h2>
</div>

<div style="margin-bottom: 50px">
</div>
<div>
    <table cellspacing="20">
        <tr>
            <th width="100px">date-time</th>
            <th></th>
            <th>name_ua</th>
            <th>description_ua</th>
            <th>category</th>
            <th>client_name</th>
            <th>client_email</th>
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
                <td width="150">
                    <c:if test="${order.status != 'is_done'}">
                        <form method="post" action="/master/order-done">
                            <input type="hidden" name="id" value="${order.id}">
                            <button type="submit"><b>MARK AS DONE </b></button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<%--    <button style="background-color: darksalmon; color: white; padding: 10px 50px">Save....</button>--%>


<%@include file="../../fragment/footer.jspf" %>