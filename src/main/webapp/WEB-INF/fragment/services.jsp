<%@ include file="/WEB-INF/fragment/base.jspf" %>

<c:if test="${services.size() > 0}">
    <div style="display: flex; justify-content: space-between">
        <div style="margin-left: 20px; position: relative; top: 3px">
            <c:if test="${total != 0}">
                <span style="font-size: 20px; font-weight: bold"><fmt:message key="totals_services"/>: ${total} </span>
            </c:if>
        </div>
        <div style="display: flex">
            <span style="font-size: 22px; margin-right: 15px">
                <fmt:message key="per_page"/>:
            </span>
            <select style="font-size: 22px" class="form-control" id="recordsPerPage" name="recordsPerPage">
                <c:forEach begin="1" end="${recordsPerPageAll}" var="i">
                    <c:choose>
                        <c:when test="${recordsPerPage eq i}">
                            <option value="${i}" selected>${i}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${i}">${i}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
    </div>
</c:if>
<c:if test="${services.size() == 0}">
    <div style="text-align: center; font-size: 18px; margin: 50px; margin-top: 5px"><h3><fmt:message
            key="not_found"/></h3></div>
</c:if>
<div class="category">
    <c:forEach items="${services}" var="service">
        <div class="category-item">
            <div>
                    ${service.getName(defaultLocale)}
            </div>
            <div style="position: absolute; bottom: 0px; width: 100%">
                <div style="display: flex; flex-direction: row; justify-content: space-between; margin: 30px">
                    <div style="font-weight: bold">
                        $ ${service.getPrice()}
                    </div>
                    <div>
                        <a href="/user/order-create?id=${service.id}"><fmt:message key="sign_up"/></a>
                    </div>
                </div>
            </div>
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