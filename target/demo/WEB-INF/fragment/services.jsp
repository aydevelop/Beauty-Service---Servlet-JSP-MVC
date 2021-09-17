<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${services.size() != 0}">
    <h3> Total Services: ${total} </h3>
</c:if>
<div class="category">
    <c:if test="${services.size() == 0}">
        <h3>There are no services found.</h3>
    </c:if>

    <c:forEach items="${services}" var="service">
        <div class="category-item" style="position: relative">
            <div>
                    ${service.getName(defaultLocale)}
            </div>
            <a href="/user/order-create?id=${service.id}">Take Service</a>
        </div>
    </c:forEach>
</div>

<div style="border: 1px solid black; padding: 10px">
    <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
            <c:when test="${currentPage eq i}">
                <li style="color: red; font-weight: bold" class="page-item active"><a class="page-link">
                        ${i} <span class="sr-only">(current)</span></a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link"
                                         href="/home?currentPage=${i}">${i}</a>
                </li>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</div>