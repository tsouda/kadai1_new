<%@page pageEncoding="Shift_JIS" contentType="text/html; charset=Shift_JIS" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="phase1.server.bean.FlightPlanBean" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=SHIFT_JIS">
<title>フライトプラン</title>
</head>
<body>
<br>
<h1>フライトプラン</h1>
<hr>
<br>

<!--  var=このセクションで使用する変数名　items=コントローラでセットした変数名 -->
<c:forEach var="obj" items="${list}" varStatus="status">

	<table border="1" cellpadding="10">
		<tr>
			<th>DBC</th>
			<th>出発空港</th>
			<th rowspan="2">FIX1</th>
			<th rowspan="2">FIX2</th>
			<th rowspan="2">FIX3</th>
			<th rowspan="2">FIX4</th>
			<th>到着空港</th>
		</tr>
		<tr>
			<td><c:out value="${obj.dbc}"/></td>
			<td><c:out value="${obj.departure}"/></td>
			<td><c:out value="${obj.arrival}"/></td>
		</tr>
		<tr>
			<th>緯度</th>
			<td><c:out value="${obj.dept_latitude}"/></td>
			<td><c:out value="${obj.one_latitude}"/></td>
			<td><c:out value="${obj.two_latitude}"/></td>
			<td><c:out value="${obj.three_latitude}"/></td>
			<td><c:out value="${obj.four_latitude}"/></td>
			<td><c:out value="${obj.arriv_latitude}"/></td>
		</tr>
		<tr>
			<th>経度</th>
			<td><c:out value="${obj.dept_longitude}"/></td>
			<td><c:out value="${obj.one_longitude}"/></td>
			<td><c:out value="${obj.two_longitude}"/></td>
			<td><c:out value="${obj.three_longitude}"/></td>
			<td><c:out value="${obj.four_longitude}"/></td>
			<td><c:out value="${obj.arriv_longitude}"/></td>
		</tr>
		<tr>
			<th>時間</th>
			<td><c:out value="${obj.dept_time}"/></td>
			<td><c:out value="${obj.one_time}"/></td>
			<td><c:out value="${obj.two_time}"/></td>
			<td><c:out value="${obj.three_time}"/></td>
			<td><c:out value="${obj.four_time}"/></td>
			<td><c:out value="${obj.arriv_time}"/></td>
		</tr>

	</table>
	<br><br>
	</c:forEach>
	<a href="<c:url value="/search"/>">入力画面へ</a>
</body>
</html>