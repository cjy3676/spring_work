<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update_ok" method="post">
<input type="hidden" name="id" value="${dto_input.id}">
name <input type="text" name="name" value="${dto_input.name}"><p>
age <input type="text" name="age" value="${dto_input.age}"><p>
address <input type="text" name="addr" value="${dto_input.addr}"><p>
<input type="submit" value="저장">
</body>
</html>