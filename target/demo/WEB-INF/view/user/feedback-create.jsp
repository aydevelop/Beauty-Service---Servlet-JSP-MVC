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
            <button type="submit">Send</button>
        </div>
    </form>
</div>

<%@include file="../../fragment/footer.jspf" %>
