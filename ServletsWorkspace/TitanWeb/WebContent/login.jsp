<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- directiva declarativa: declaramos variables --%>
	<%! int i = 0; %>
	<form action="./loginRoute" method="get">
	
		<table>
			<tr>
				<td><label>Usuario</label></td>
				<td><input type="text" name="usuario"></td>
				<td><label>Clave</label></td>
				<td><input type="password" name="password"></td>
				<td><label>Empresa</label></td>
				<td><input type="text" name="empresa"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
		<%-- Scriptplets --%>
		<% for(i = 0; i < 10; i++) { %>
			<%-- directiva de expresion --%>
			<label>Hola <%=i%></label>
		<%
			}
		%>
	</form>
</body>
</html>