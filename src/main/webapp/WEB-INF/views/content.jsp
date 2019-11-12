<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="400">
<tr>
<td>이름</td>
<td>${dto_input.name}</td>
</tr>
<tr>
<td>나이</td>
<td>${dto_input.age}</td>
</tr>
<tr>
<td>주소</td>
<td>${dto_input.addr}</td>
</tr>
<tr>
<td>작성일</td>
<td>${dto_input.writeday}</td>
</tr>
<tr>
<td colspan="2">
<a href="update?id=${dto_input.id}">수정</a>
<a href="delete?id=${dto_input.id}">삭제</a>
<a href="list">목록</a>
</td>
</tr>
</table>
</body>
</html>