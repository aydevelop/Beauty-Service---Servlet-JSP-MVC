<%@ include file="/WEB-INF/view/base.jspf" %>
<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Edit Order"/>
</jsp:include>

<div>${order.service.name_ua}</div>
<div>${order.service.description_ua}</div>
<div>${order.category}</div>
<div>${order.client.first_name} ${order.client.last_name}</div>
<div>${order.client.email}</div>
<div>${order.master.first_name} ${order.master.last_name}</div>
<div>${order.master.email}</div>

<%@include file="../footer.jsp" %>