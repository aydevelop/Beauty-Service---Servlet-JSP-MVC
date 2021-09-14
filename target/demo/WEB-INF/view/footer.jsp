</div>
<div class="footer"
     style="border: 1px solid black; background-color: darksalmon; height: 40px; padding-top: 25px; font-size: 20px; margin-top: 20px">
    footer
    <div>
        <fmt:message key="home.services"/>
        <div><fmt:message key="home.master"/></div>
    </div>
</div>

<c:if test="${sessionScope.message != null}">
    <div style="font-size: 30px; background-color: linen; text-align: center; padding-top: 40px; position: absolute; right: 0; bottom: 0; width: 300px; height: 120px; border: 2px solid black">
            ${sessionScope.message}
    </div>
    <c:remove var="message" scope="session"/>
</c:if>

<c:if test="${sessionScope.error != null}">
    <div style="color: red; font-size: 30px; background-color: linen; text-align: center; padding-top: 40px; position: absolute; right: 0; bottom: 0; width: 300px; height: 120px; border: 2px solid black">
            ${sessionScope.error}
    </div>

    <c:remove var="error" scope="session"/>
</c:if>


</body>
</html>