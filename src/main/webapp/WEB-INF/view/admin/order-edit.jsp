<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="title" value="Edit Orders" scope="page"/>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<form method="post" action="/admin/order-edit">
    <div style="text-align: center">
        <h1>
            <div>${order.date}</div>
        </h1>
        <select style="margin-top: 15px; margin-bottom: 15px; font-size: 20px" name="slot-id">
        <c:forEach items="${slots}" var="slot">
            <option ${order.slotId == slot.id ? "selected" : ""}  value="${slot.id}">${slot.name}</option>
        </c:forEach>
    </select>
    </div>
    <input type="hidden" name="id" value="${param["id"]}">
    <div style="text-align: center">


        <div style="font-size: 30px; margin: 20px 0px">
            <select name='status' style="height: 25px; font-size: 20px; margin: 30px 0px">
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
        <button type="submit" style="background-color: darksalmon; color: white; padding: 10px 50px">Save....</button>
    </div>
</form>

<%@include file="../../fragment/footer.jspf" %>