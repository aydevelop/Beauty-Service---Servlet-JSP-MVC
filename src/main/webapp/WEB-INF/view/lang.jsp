<div class="lang" style="margin-left: 50px; border: 2px solid black; padding: 10px; display: inline-block">
    <small>LANG: </small>
    <c:forEach var="locale" items="${locales}">
        <a style="font-size: 25px" href="/home/lang-change?lang=${locale}">${locale}</a>
    </c:forEach>
</div>