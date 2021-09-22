<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="pre_title" value='order' scope="session"/>
<%@ include file="/WEB-INF/fragment/fmt.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<form method="post" action="/admin/order-edit">
    <div style="margin-top: 40px; text-align: center">
        <div style="margin-bottom: 40px">
            <h1>
                <fmt:message key="order"/>
            </h1>
        </div>
        <div style="font-size: 20px; font-weight: bold"><fmt:message key="timeslot"/>:</div>
        <select style="margin-top: 15px; font-size: 20px" name="slot-id">
            <c:forEach items="${slots}" var="slot">
                <option ${order.slotId == slot.id ? "selected" : ""} value="${slot.id}">${slot.name}</option>
            </c:forEach>
        </select>
    </div>
    <div>
        <input type="hidden" name="id" value="${param["id"]}">
    </div>
    <div style="text-align: center">


        <div style="font-size: 30px; margin: 20px 0px">
            <div style="font-size: 20px; font-weight: bold"><fmt:message key="status"/>:</div>
            <select name='status' style="height: 25px; font-size: 20px; margin: 10px 0px 30px">
                <option value="is_canceled"
                        <c:if test="${order.status == 'is_canceled'}">
                            selected
                        </c:if>>
                    Is Canceled
                </option>
                <option value="is_paid"
                        <c:if test="${order.status == 'is_paid'}">
                            selected
                        </c:if>>
                    Is Paid
                </option>
                <option value="is_done"
                        <c:if test="${order.status == 'is_done'}">
                            selected
                        </c:if>>
                    Is Done
                </option>
            </select>
        </div>
        <button type="submit" style="background-color: darksalmon; color: white; padding: 10px 50px"><fmt:message
                key="save"/></button>
    </div>
</form>

<%@include file="../../fragment/footer.jspf" %>