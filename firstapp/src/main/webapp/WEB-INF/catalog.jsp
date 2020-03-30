<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<%@ include file="/WEB-INF/jspf/menu.jspf" %>

<h1>Это каталог товаров</h1>

<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="prod" items="${requestScope.products}">
        <tr>
            <td>
                <c:out value="${prod.id}"/>
            </td>
            <td>
                <c:out value="${prod.title}"/>
            </td>
            <td>
                <c:out value="${prod.price}"/>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>