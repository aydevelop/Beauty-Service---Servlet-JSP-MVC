<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="text-align: center; margin-top: 10px; margin-bottom: 30px; display: flex; flex-direction: row; flex-wrap: wrap">

    <c:forEach items="${masters}" var="master">
        <div class="category-item" style="height: auto">
            <div><img src="https://via.placeholder.com/150"></div>
            <div>${master.email}</div>
            <div>${master.first_name} ${master.last_name}</div>
            <div>Rating: ${master.rating}</div>
        </div>
    </c:forEach>
</div>