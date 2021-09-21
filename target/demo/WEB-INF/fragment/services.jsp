<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${services.size() > 0}">
    <div style="display: flex; justify-content: space-between">
        <div>
            <c:if test="${total != 0}">
                <h3> <fmt:message key="totals_services"/>: ${total} </h3>
            </c:if>
        </div>
        <div>
        <span style="font-size: 22px; margin-left: 200px">
            <fmt:message key="per_page"/>:
        </span>
            <select style="font-size: 22px" class="form-control" id="recordsPerPage" name="recordsPerPage">
                <option value="3" <c:if test="${recordsPerPage == '3'}">selected</c:if>>3</option>
                <option value="2" <c:if test="${recordsPerPage == '2'}">selected</c:if>>2</option>
                <option value="1" <c:if test="${recordsPerPage == '1'}">selected</c:if>>1</option>
            </select>
        </div>
    </div>
</c:if>
<c:if test="${services.size() == 0}">
    <div style="text-align: center; font-size: 18px; margin: 50px; margin-top: 5px"><h3>There are no services found.</h3></div>
</c:if>
<div class="category">
    <c:forEach items="${services}" var="service">
        <div class="category-item" style="position: relative">
            <div>
                    ${service.getName(defaultLocale)}
            </div>
            <a href="/user/order-create?id=${service.id}"><fmt:message key="sign_up"/></a>
        </div>
    </c:forEach>
</div>

<div id="pagination"
     style="padding: 6px; font-size: 22px; margin-top: 30px; text-align: center">
    <c:if test="${noOfPages > 1}">
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <span style="font-weight: bold" class="page-item active">
                        <a style="color: red; margin-left: 20px" class="page-link">[${i}]</a>
                    </span>
                </c:when>
                <c:otherwise>
                    <span class="page-item">&nbsp;&nbsp;&nbsp;
                        <a onclick="return false;" data-index="${i}" class="page-link">[${i}]</a>
                    </span>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:if>
</div>

<script>

    $(function () {
        $('#pagination a').on('click', function () {
            let index = $(this).data('index');
            filter(index);
            return false;
        });
    });
</script>