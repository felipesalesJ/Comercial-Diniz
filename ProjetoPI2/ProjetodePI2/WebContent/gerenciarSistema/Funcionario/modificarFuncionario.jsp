<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Consultar Funcionários</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h3>Alterar Cadastro dos Funcionários</h3>
			<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>TELEFONE</th>
				<th>EMAIL</th>
				<th>SALARIO</th>
			</tr>
		</thead>
		<% for(Funcionario funcionario: (List<Funcionario>) session.getAttribute("func")){ %>
		<tbody>
			<tr>
				<td><%=funcionario.getId()%></td>
				<td><%=funcionario.getNome()%></td>
				<td><%=funcionario.getTelefone()%></td>
				<td><%=funcionario.getEmail()%></td>
				<td><%=funcionario.getSalario()%></td>
			</tr>
		</tbody>
		<%}%>
	</table>
			
			<hr>
			
				<form action="/ProjetodePI2/funcionario" method="post">
						<input type="hidden" name="acao" value="alterarFuncionario">
						<input type="text" name="id" placeholder="Digite o id aqui"><br/>
						<input type="text" name="nome" placeholder="Digite o nome aqui"><br/>
						<input type="text" name="telefone"placeholder="Digite o telefone aqui"><br/>
						<input type="text" name="email"	placeholder="Digite o email aqui"><br/>
						<input type="text" name="salario"	placeholder="Digite o salário aqui"><br/>
						<button type="submit" name="Submit">Alterar</button>
				</form>
				<form action="/ProjetodePI2/gerenciarSistema/Funcionario/gerenciarFuncionario.jsp" method="post">			
						<button type="submit" name="Submit">Voltar</button>
				
		</div>
	</div>
</body>
</html>