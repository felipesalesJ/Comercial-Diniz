<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="br.com.lojaconstrucao.modelo.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="../resource/css/bootstrap.min.css"/>
<title>Comercial Diniz</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Vendedor <%=session.getAttribute("func")%></h1>
			<h2>Cliente <%=session.getAttribute("cliente") %></h1>
			<br/>
			<table class="table table-hover" >
		<thead class="thead-dark">
			<tr>
				<th>NOME DO Cliente</th>
				<th>VENDEDOR</th>
				<th>NOME DO PRODUTO</th>
				<th>QUANTIDADE DE PRODUTOS</th>
				<th>PREÇO UNITÁRIO</th>
				<th>PREÇO TOTAL</th>
				<th>PREÇO TOTAL DA VENDA</th>
			</tr>
		</thead>
		<% for(Vendas vendas: (List<Vendas>) session.getAttribute("venda")){ %>
		<tbody>
			<tr>
				<td><%=vendas.getNomeCliente()%></td>
				<td><%=vendas.getNomeVendedor()%></td>
				<td><%=vendas.getNomeProduto()%></td>
				<td><%=vendas.getQuantidade()%></td>
				<td><%=vendas.getPrecoUni()%></td>
				<td><%=vendas.getPrecoTotal()%></td>
				<td><%=vendas.getPrecototalvenda()%></td>				
			</tr>
		</tbody>
		<%}%>	
		</table>
			<h3>Realizar Venda:</h3>
			<form action="/ProjetodePI2/vendas" method="post">
			<input type="hidden" name="acao" value="realizarVenda">
				<input type="hidden" name = "nomecliente" value=<%=session.getAttribute("cliente") %>></input>
				<input type="hidden" name = "nomevendedor" value=<%=session.getAttribute("func") %>></input>
				<button class="btn btn-primary" type="submit" name="Submit">Continuar</button>
				
		</form>
		<br/>
				<form action="/ProjetodePI2/vendas" method="post">
				<input type="hidden" name="acao" value="mostrarUmFuncionariopnome">
				<input type="hidden" name="id" value=<%=session.getAttribute("func")%>></input>
						<button class="btn btn-primary" type="submit" name="Submit">Voltar</button>
					</form>		
	</div>
</div>
</body>
</html>