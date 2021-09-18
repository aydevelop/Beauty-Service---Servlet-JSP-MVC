<%@tag pageEncoding="UTF-8" %>
<%@ attribute name="size" required="true" %>
<%@ attribute name="bold" required="false" %>

<div style="font-size: ${size}px; ${bold ? 'font-weight : bold' : ''}">
    <jsp:doBody/>
</div>