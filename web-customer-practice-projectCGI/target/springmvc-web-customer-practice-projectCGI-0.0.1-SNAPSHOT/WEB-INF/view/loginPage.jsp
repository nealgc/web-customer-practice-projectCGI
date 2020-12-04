<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CGI Practice page login</title>
</head>
<body>
	<form name="loginForm" method="post" action="loginCheck">
		<table width="20%" bgcolor="0099CC" align="center">

			<tr>
				<td colspan=2><center>
						<font size=4><b>HTML Login Page</b></font>
					</center></td>
			</tr>

			<tr>
				<td>Username:</td>
				<td><input type="text" size=25 name="userid"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="Password" size=25 name="pwd"></td>
			</tr>

			<tr>
				<td><input type="Reset"></td>
				<td><input type="submit" onclick="return check(this.form)"
					value="Login"></td>
			</tr>

		</table>
	</form>
</html>
<script language="javascript">
	function check(form) {

		if (form.userid.value == "graham" && form.pwd.value == "graham") {
			return true;
		} else {
			alert("Error Password or Username")
			return false;
		}
	}
</script>