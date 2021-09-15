<c:if test="${sessionScope.message != null}">
    <div style="font-size: 30px; background-color: linen; text-align: center; padding-top: 40px; position: absolute; right: 0; bottom: 0; width: 300px; height: 120px; border: 2px solid black">
        ABC
            ${sessionScope.message}
    </div>
    <c:remove var="message" scope="session"/>
</c:if>