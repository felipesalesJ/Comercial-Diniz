<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gerenciar Produtos</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
				<h1>Gerenciamento dos Funcionarios</h1>
				<h2>Adicionar Funcionário</h2>
				<form action="/ProjetodePI2/funcionario" method="post">
						<input type="hidden" name="acao" value="cadastrarFuncionario">
						<input type="text" name="nome" placeholder="nome do funcionário"><br/>
						<input type="text" name="telefone"placeholder="telefone do funcionário"><br/>
						<input type="text" name="email" placeholder="email do funcionário"><br/>
						<input type="text" name="salario" placeholder="salário do funcionário"><br/>
						<button type="submit" name="Submit">Cadastrar Funcionário</button>
				</form>
				<form action="/ProjetodePI2/gerenciarSistema/Funcionario/gerenciarFuncionario.jsp" method="post">
					<button type="submit">Voltar</button>		
				</form>
				
				</div>
	</div>
</body>
</html>