<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>Book</title>
        <style>
            table {
                border-collapse: collapse;/*显示单边框*/
            }
            th{
                text-align:center;/*居中*/
            }
            table, td, th {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>编号</th>
                <th>书名</th>
                <th>价格</th>
                <th>状态</th>
                <th>创建日期</th>
            </tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookName}</td>
                <td>${book.price}</td>
                <td>${book.status}</td>
                <td>${book.createTime}</td>
            </tr>
        </c:forEach>
        </table>
    </body>
    </html>
