<%@ include file="/WEB-INF/view/base.jspf" %>
<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Master Orders"/>
</jsp:include>

<form action="/user/order-create" method="post">
    <input type="hidden" name="service-id" value="${service.id}">
    <h1>Create Order ....</h1>
    <div>${service.name_ua}</div>
    <div>${service.price}</div>
    <div>${service.description_ua}</div>

    <br/>
    <hr>
    <br/>

    <select name="master-id">
        <c:forEach items="${masters}" var="master">
            <option value="${master.id}">${master.first_name} ${master.last_name}</option>
        </c:forEach>
    </select>

    <br/>
    <br/>
    <button style="padding: 20px 30px" type="submit">Take Service</button>
</form>

<%@include file="../footer.jsp" %>
