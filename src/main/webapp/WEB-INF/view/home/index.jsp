<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="title" value="Home Page" scope="page"/>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div style="margin-top: 30px; margin-left: 40px; text-align: left; font-weight: normal; font-size: 30px">
    <div><fmt:message key="home.services"/></div>
</div>
<div style="display: flex; flex-direction: row">
    <div id="filters"
         style="width: 340px; border: 1px solid black; margin-right: 20px; padding-left: 20px; padding-right: 10px; padding-top:20px; margin-top: 10px">
        <fmt:message key="home.categories"/>
        <div id="filter-category">
            <c:forEach items="${categories}" var="category">
                <div style="margin-top: 10px; cursor: pointer">
                    <div>
                        <input style="cursor: pointer" type="checkbox" id="ct-${category.name}"
                               name="category-id"
                               value="${category.id}">
                        <label for="ct-${category.name}" style="cursor: pointer; user-select: none;">
                                ${category.name}
                        </label>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br/>
        <fmt:message key="home.masters"/>
        <div id="filter-master">
            <c:forEach items="${masters}" var="master">
                <div style="margin-top: 10px">
                    <div>
                        <input style="cursor: pointer" type="checkbox" id="ms-${master.id}"
                               name="master-id"
                               value="${master.id}">
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

    <div id="services-list">
        <%@ include file="/WEB-INF/fragment/services.jsp" %>
    </div>
</div>

<div style=" margin-left: 40px; margin-top: 30px; text-align: left; font-weight: normal; font-size: 30px; position: relative; bottom: -25px">
    <div><fmt:message key="home.masters"/></div>
</div>
<div style="text-align: right; margin-right: 10%; font-size: 22px; height: 50px">
    Order By:
    <select id="master_select" style="height: 50px; font-size: 22px">
        <option style="font-size: 22px" value="rating">Rating</option>
        <option style="font-size: 22px" value="first_name">First Name</option>
        <option style="font-size: 22px" value="last_name">Last Name</option>
    </select>
</div>

<div id="masters-list">
    <%@ include file="/WEB-INF/fragment/masters.jsp" %>
</div>

<div>
</div>

<%@ include file="/WEB-INF/fragment/footer.jspf" %>