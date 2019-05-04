<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
</head>
<body>
	<h1>Bienvenido a mi pagina web perro, está perrón</h1>
	<p>Proyecto que refleja la fé que tengo en la humanidad</p>
	
	<form action="login" method="POST">
		<label>Nombre: </label>
		<input type="text" name="name">
		<br>
		<label>Contraseña: </label>
		<input type="password" name="password">
		<br>
		<input type="submit" value="Entrar">
	</form>
</body>
</html>