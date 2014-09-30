<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
	<title>フライトプラン検索</title>
	</head> 
	<body>
			<h5>DBが200000ある場合、全件表示はしないでください</h5>
		<h2>${message}</h2>
	<form action="/http/search" method="post" >
		<input type="text" name="input1" maxlength="5"/>
		<input type="submit" value="検索">
	</form>	
	</body>
</html>
