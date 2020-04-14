<%--
  Created by IntelliJ IDEA.
  User: vuanh
  Date: 2020-04-09
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/customers?action=create">Create new customer</a>
</p>
<div>
    <form method="get" action="${pageContext.request.contextPath}/customers">
        <select name="country">
<c:forEach items='${requestScope["countries"]}' var="country">
    <option value="${country.getId()}">${country.getName()}</option>
</c:forEach>
        </select>
        <button type="submit" name="action" value="search">Tìm kiếm</button>
    </form>
</div>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Country</td>
    </tr>

    //lặp
    <c:forEach items='${requestScope["danhsach"]}' var="khachhang">
        <tr>
            <td>${khachhang.getName()}</td>
            <td>${khachhang.getEmail()}</td>
            <td>${khachhang.getAddress()}</td>
            <td>${khachhang.getCountry_name()}</td>
        </tr>

    </c:forEach>


</table>
</body>
</html>
</body>
</html>
