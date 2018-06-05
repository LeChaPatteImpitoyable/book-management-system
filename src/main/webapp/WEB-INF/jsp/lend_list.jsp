<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>流水号</th>
        <th>图书号</th>
        <th>读者证号</th>
        <th>借出日期</th>
        <th>归还日期</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="alog">
        <tr>
            <td><c:out value="${alog.sernum}"></c:out></td>
            <td><c:out value="${alog.bookId}"></c:out></td>
            <td><c:out value="${alog.readerId}"></c:out></td>
            <td><c:out value="${alog.lendDate}"></c:out></td>
            <td><c:out value="${alog.backDate}"></c:out></td>
            <td><a href="deletebook.html?bookId=<c:out value="${alog.sernum}"></c:out>"><button type="button" class="btn btn-danger btn-xs">删除</button></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>