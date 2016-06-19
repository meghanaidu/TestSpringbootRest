<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>

</head>
<body>
	<form action="/contacts/add" method="post">
		<table>
			<tr>
				<th>Register your contact details</th>
			</tr>
			<tr>
				<td>Name: <input type="text" name="Name">
				</td>
			</tr>
			<tr>
				<td>Email: <input type="text" name="Email">
				</td>
			</tr>
			<tr>
				<td>Profession: <input type="text" name="Profession">
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>