<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div style="margin-top: 30px; margin-left: 40px; text-align: left; font-weight: normal; font-size: 30px">
    <div><fmt:message key="home.services"/></div>
</div>
<div style="display: flex; flex-direction: row">
    <div class="filters"
         style="width: 340px; border: 1px solid black; margin-right: 20px; padding-left: 20px; padding-right: 10px; padding-top:20px; margin-top: 10px">
        <fmt:message key="home.categories"/>
        <div>
            <c:forEach items="${categories}" var="category">
                <div style="margin-top: 10px; cursor: pointer">
                    <div>
                        <input style="cursor: pointer" type="checkbox" id="ct-${category.name}"
                               name="ct-${category.name}"
                               value="ct-${category.name}">
                        <label for="ct-${category.name}" style="cursor: pointer; user-select: none;">
                                ${category.name}
                        </label>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br/>
        <fmt:message key="home.masters"/>
        <div>
            <c:forEach items="${masters}" var="master">
                <div style="margin-top: 10px">
                    <div>
                        <input style="cursor: pointer" type="checkbox" id="ms-${master.id}"
                               name="ms-${master.id}"
                               value="ms-${master.id}">
                        <label for="ms-${master.id}" style="cursor: pointer; user-select: none;">
                                ${master.first_name} ${master.last_name}
                        </label>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br/>
        <br/>
    </div>
    <div class="category">
        <c:if test="${services.size() == 0}">
            There are no services found.
        </c:if>
        <c:forEach items="${services}" var="service">
            <div class="category-item" style="position: relative">

                <div>
                        ${service.getName(defaultLocale)}
                </div>
                    <%--                <form method="post" action="/user/order-create">--%>
                    <%--                    <input type="hidden" name="id" value="${service.id}">--%>
                    <%--                    <div style="font-size: 22px; position: absolute; right: 5px; bottom: 5px">--%>
                    <%--                        <select name="datetime" style="height: 25px; font-size: 20px; margin: 30px 20px 0px">--%>
                    <%--                            <option>8:00</option>--%>
                    <%--                            <option>9:00</option>--%>
                    <%--                            <option>10:00</option>--%>
                    <%--                            <option>11:00</option>--%>
                    <%--                            <option>12:00</option>--%>
                    <%--                            <option>13:00</option>--%>
                    <%--                            <option>14:00</option>--%>
                    <%--                            <option>15:00</option>--%>
                    <%--                            <option>16:00</option>--%>
                    <%--                            <option>17:00</option>--%>
                    <%--                        </select>--%>
                    <%--                        <button style="height: 30px" type="submit">Take service</button>--%>
                    <%--                    </div>--%>
                    <%--                </form>--%>

                <a href="/user/order-create?id=${service.id}">Take Service</a>
            </div>
        </c:forEach>
    </div>
</div>

<div style=" margin-left: 40px; margin-top: 30px; text-align: left; font-weight: normal; font-size: 30px; position: relative; bottom: -25px">
    <div><fmt:message key="home.masters"/></div>
</div>
<div style="text-align: right; margin-right: 10%; font-size: 22px">
    Order By:
    <select id="master_select" style="height: 30px">
        <option value="name">Name</option>
        <option value="rating">Rating</option>
    </select>
</div>
<div style="text-align: center; margin-top: 10px; margin-bottom: 30px; display: flex; flex-direction: row; flex-wrap: wrap">

    <c:forEach items="${masters}" var="master">
        <div class="category-item" style="height: auto">
            <div><img src="https://via.placeholder.com/150"></div>
            <div>${master.email}</div>
            <div>${master.first_name} ${master.last_name}</div>
        </div>
    </c:forEach>
</div>
<div>

</div>

<%@include file="/WEB-INF/fragment/footer.jspf" %>