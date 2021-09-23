<%@ include file="/WEB-INF/fragment/base.jspf" %>
<c:set var="pre_title" value='home' scope="session"/>
<%@ include file="/WEB-INF/fragment/fmt.jspf" %>
<%@ include file="/WEB-INF/fragment/header.jspf" %>

<div style="margin-top: 30px; margin-left: 40px; text-align: left; font-weight: normal; font-size: 30px">
    <div><fmt:message key="services"/></div>
</div>
<div style="display: flex; flex-direction: row">
    <div id="filters"
         style="font-size: 18px; width: 240px; border: 1px solid black; border-radius: 20px; margin-right: 20px; padding-left: 20px; padding-right: 10px; padding-top:20px; margin-top: 10px">
        <fmt:message key="categories"/>
        <div id="filter-category">
            <c:forEach items="${categories}" var="category">
                <div style="margin-top: 10px; cursor: pointer">
                    <div>
                        <input style="cursor: pointer" type="checkbox" id="ct-${category.name_ua}"
                               name="category-id"
                               value="${category.id}">
                        <label for="ct-${category.name_ua}" style="cursor: pointer; user-select: none;">
                                ${category.getName(defaultLocale)}
                        </label>
                    </div>
                </div>
            </c:forEach>
        </div>
        <br/>
        <fmt:message key="masters"/>
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

<div style="margin-top: 10px; text-align: left; font-weight: normal; font-size: 30px; position: relative; bottom: -40px; z-index: -100">
    <div><fmt:message key="masters"/></div>
</div>
<div style="text-align: right; font-size: 22px; height: 30px">
    <fmt:message key="order_by"/>:
    <select id="master_select" style="font-size: 22px">
        <option value="rating"><fmt:message key="rating"/></option>
        <option value="first_name"><fmt:message key="first_name"/></option>
        <option value="last_name"><fmt:message key="last_name"/></option>
    </select>
</div>

<div id="masters-list">
    <%@ include file="/WEB-INF/fragment/masters.jsp" %>
</div>

<div>
</div>

<%@ include file="/WEB-INF/fragment/footer.jspf" %>