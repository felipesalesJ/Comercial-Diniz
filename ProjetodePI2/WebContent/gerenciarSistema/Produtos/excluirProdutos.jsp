<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Alterar Produto</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h3>Alterar Produto</h3>
			<h4>Qual Produto Alterar?</h4>
			<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>QUANTIDADE</th>
				<th>PREÇO</th>
				
			</tr>
		</thead>
		<% for(Produto produto: (List<Produto>) session.getAttribute("produtos")){ %>
		<tbody>
			<tr>
				<td><%=produto.getId()%></td>
				<td><%=produto.getNome()%></td>
				<td><%=produto.getQuant()%></td>
				<td><%=produto.getPreço()%></td>
			</tr>
		</tbody>
		<%}%>
	</table>
			
			<hr>
				<form action="/ProjetodePI2/produto" method="post">
						<input type="hidden" name="acao" value="removerProduto">
						<input type="text" name="id" placeholder="Digite o id que deseja excluir"><br/>
						<button type="submit" name="Submit">Excluir</button>
				</form>
				<br/>
				<form action="/ProjetodePI2/gerenciarSistema/Produtos/gerenciarProdutos.jsp" method="post">			
						<button type="submit" name="Submit">Voltar</button>
				
		</div>
	</div>
</body>
</html>