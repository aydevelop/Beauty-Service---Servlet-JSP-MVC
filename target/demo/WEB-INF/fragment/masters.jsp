<%@ include file="/WEB-INF/fragment/base.jspf" %>

<c:forEach items="${masters}" var="master">
    <div class="category-item" style="height: auto">
        <div><img style="max-width: 110px" src="/image/master/${master.id}.png"></div>
        <div>${master.email}</div>
        <div>${master.first_name} ${master.last_name}</div>
        <div class="rating"><fmt:message key="rating"/>: ${master.rating}</div>
    </div>
</c:forEach>