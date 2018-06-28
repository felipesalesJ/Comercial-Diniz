<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Comercial Diniz</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Comercial Diniz</h1>
			<h3>Gerenciar Sistema</h3>
			<hr>
				<form action="/ProjetodePI2/gerente" method="post">
						<input type="hidden" name="acao" value="validarsenha">
						<input type="password" name="senha" placeholder="Digite a senha"/>
						<button type="submit" name="Submit">Entrar</button><br />
						<h2 style="color:red;">Senha Incorreta</h2>
				</form>
				<br />
				
				<h3>Realizar venda</h3>
			<hr>
				<form action="Funcionario.jsp" method="post">
						<button type="submit" name="Submit">Continuar</button>
				</form>
				<br />
		</div>
	</div>
</body>
</html>