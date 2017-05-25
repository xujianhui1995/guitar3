<%@ page contentType="text/html; charset=UTF-8" language="java"
	errorPage=""%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>查询页面</title>
</head>
<body>
	<h3>查询结果：</h3>
	<table width="640" border="1">
		<tr>
			<td>serialNumber</td>
			<td>price</td>
			<td>builder</td>
			<td>model</td>
			<td>type</td>
			<td>numStrings</td>
			<td>backWood</td>
			<td>topWood</td>
			<td>编辑</td>

		</tr>
		<tr>
			<td>${requestScope.guitar.serialNumber}</td>
			<td>${requestScope.guitar.price}</td>
			<td>${requestScope.guitar.getSpec().builder}</td>
			<td>${requestScope.guitar.getSpec().model}</td>
			<td>${requestScope.guitar.getSpec().type}</td>
			<td>${requestScope.guitar.getSpec().numStrings}</td>
			<td>${requestScope.guitar.getSpec().backWood}</td>
			<td>${requestScope.guitar.getSpec().topWood}</td>
			<td><a href="delGuitar?serialNumber=${requestScope.guitar.serialNumber}">删除</a></td>

		</tr>
	</table>
</body>
</html>
