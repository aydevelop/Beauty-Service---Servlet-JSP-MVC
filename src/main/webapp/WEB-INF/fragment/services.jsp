<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="display: flex; justify-content: space-between">
    <div>
        <c:if test="${total != 0}">
            <h3> Total Services: ${total} </h3>
        </c:if>
    </div>
    <div>
        <span style="font-size: 22px">
            Per page:
        </span>
        <select style="font-size: 22px" class="form-control" id="recordsPerPage" name="recordsPerPage">
            <option value="3" <c:if test="${recordsPerPage == '3'}">selected</c:if>>3</option>
            <option value="2" <c:if test="${recordsPerPage == '2'}">selected</c:if>>2</option>
            <option value="1" <c:if test="${recordsPerPage == '1'}">selected</c:if>>1</option>
        </select>
    </div>
</div>

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

<div id="pagination"
     style="border: 1px solid black; padding: 10px; font-size: 22px">
    <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
            <c:when test="${currentPage eq i}">
                <span style="color: red; font-weight: bold" class="page-item active">&nbsp;&nbsp;&nbsp;<a
                        class="page-link">
                        [${i}]</span></a>
                </span>
            </c:when>
            <c:otherwise>
                <span class="page-item">&nbsp;&nbsp;&nbsp;<a onclick="return false;" data-index="${i}"
                                                             class="page-link">[${i}]</a>
                </span>
            </c:otherwise>
        </c:choose>
    </c:forEach>
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