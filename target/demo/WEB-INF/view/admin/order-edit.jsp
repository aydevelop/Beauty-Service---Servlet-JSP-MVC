<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="title" value="Edit Orders" scope="page"/>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<form method="post" action="/admin/order-edit">
    <div style="text-align: center">
        <h1>
            <div>${order.dataTime}</div>
        </h1>
        <select name="datatime" style="height: 25px; font-size: 20px; margin: 30px 0px 0px">
            <option>8:00</option>
            <option>9:00</option>
            <option>10:00</option>
            <option>11:00</option>
            <option>12:00</option>
            <option>13:00</option>
            <option>14:00</option>
            <option>15:00</option>
            <option>16:00</option>
            <option>17:00</option>
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