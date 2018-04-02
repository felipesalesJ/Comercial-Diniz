<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gerenciamento do sistema</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
				<h1>Gerenciarmento do Sistema</h1>
				<form action="/ProjetodePI2/gerenciarSistema/Gerente/gerenciarGerente.jsp" method="post">
						<button type="submit">Modificar nome/senha do gerente</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Produtos/gerenciarProdutos.jsp" method="post">
						<button type="submit">Gerenciar Produtos</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Clientes/gerenciarCliente.jsp" method="post">
						<button type="submit">Gerenciar Clientes</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerenciarSistema/Funcionario/gerenciarFuncionario.jsp" method="post">
						<button type="submit">Gerenciar Funcionários</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerente" method="post">
						<input type="hidden" name="acao" value="validarsenha">
						<button type="submit">Realizar venda</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerente" method="post">
						<input type="hidden" name="acao" value="validarsenha">
						<button type="submit">Emitir Relatorio de Compras</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/gerente" method="post">
						<input type="hidden" name="acao" value="validarsenha">
						<button type="submit">Emitir Relatorio de Vendas</button>
				</form>
				<hr>
				<form action="/ProjetodePI2/menu.jsp" method="post">
						<button type="submit">Voltar</button>
				</form>
				
				<br />
		</div>
	</div>
</body>
</html>