<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${list.get(0).getName()} --%>
<table width="500">
<tr>
<td>이름</td>
<td>나이</td>
<td>주소</td>
<td>작성일</td>
</tr>
<c:forEach items="${list}" var="dto_input">
<tr>
<td>${dto_input.name}</td>
<td>${dto_input.age}</td>
<td>${dto_input.addr}</td>
<td>${dto_input.writeday}</td>
</tr>
</c:forEach>
</table>
</body>
</html>