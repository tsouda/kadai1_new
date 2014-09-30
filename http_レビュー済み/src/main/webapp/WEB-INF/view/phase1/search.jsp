<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
	<title>フライトプラン検索</title>
	<script language="JavaScript">
	<!--
	// 数値のみを入力可能にする
	function numOnly() {
	   m = String.fromCharCode(event.keyCode);
	   if("0123456789\b\r".indexOf(m, 0) < 0) return false;
	   return true;
	}
	 //-->
	</script>
	</head> 
	<body>
		<h2>${message}</h2>
	<form action="/http/search" method="post" >
		<input type="text" name="input1" maxlength="5" onkeyDown="return numOnly()"/>
		<input type="submit" value="検索">
	</form>	
	</body>
</html>
