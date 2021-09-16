<%@ include file="/WEB-INF/fragment/base.jspf" %>

<div class="category">
    <c:if test="${services.size() == 0}">
        There are no services found.
    </c:if>
    <c:forEach items="${services}" var="service">
        <div class="category-item" style="position: relative">


                <%--            <div>--%>
                <%--                    ${service.getName(defaultLocale)}--%>
                <%--            </div>--%>
            <a href="/user/order-create?id=${service.id}">Take Service</a>
        </div>
    </c:forEach>
</div>