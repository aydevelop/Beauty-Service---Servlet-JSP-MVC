<%@ include file="/WEB-INF/fragment/base.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div class="feedback">
    <h2>
        Feedback
    </h2>
    <form style="width: 500px" method="post" action="/user/order-feedback">
        <input type="hidden" name="id" value="${id}">
        <textarea name="feedback" cols="60" rows="5"></textarea>
        <div>
            <select name="grade">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
        </div>
        <div>
            <button type="submit">Send</button>
        </div>
    </form>
</div>

<%@include file="../../fragment/footer.jspf" %>
