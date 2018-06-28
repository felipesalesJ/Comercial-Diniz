<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Consultar Produto</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h3>Clientes do Sistema</h3>
			<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>TELEFONE</th>
				<th>EMAIL</th>
				
			</tr>
		</thead>
		<% for(Cliente clientes: (List<Cliente>) session.getAttribute("clientes")){ %>
		<tbody>
			<tr>
				<td><%=clientes.getId()%></td>
				<td><%=clientes.getNome()%></td>
				<td><%=clientes.getTelefone()%></td>
				<td><%=clientes.getEmail()%></td>
			</tr>
		</tbody>
		<%}%>
	</table>
			
			<hr>
			<form action="/ProjetodePI2/cliente" method="post">
						<input type="hidden" name="acao" value="removerCliente">
						<input type="text" name="id" placeholder="Digite o id aqui"><br/>
						<button type="submit" name="Submit">Remover Cliente</button>
				</form>
				<form action="/ProjetodePI2/gerenciarSistema/Clientes/gerenciarCliente.jsp" method="post">			
						<button type="submit" name="Submit">Voltar</button>
				
		</div>
	</div>
</body>
</html>