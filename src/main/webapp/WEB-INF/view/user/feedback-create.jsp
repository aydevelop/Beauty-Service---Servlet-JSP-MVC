<%@ include file="/WEB-INF/fragment/base.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div class="feedback">
    <h1>
        <fmt:message key="feedback"/>
    </h1>
    <form style="margin-top: 20px; width: 500px" method="post" action="/user/order-feedback">
        <input type="hidden" name="id" value="${id}">
        <textarea name="feedback" cols="60" rows="5"></textarea>
        <div>
            <select style="margin-top: 24px; font-size: 18px; padding: 1px 15px" name="grade">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </div>
        <div style="margin-top: 20px">
            <button type="submit"><fmt:message key="save"/></button>
        </div>
    </form>
</div>

<%@include file="../../fragment/footer.jspf" %>
