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
				<h1>Gerenciamento dos Produtos</h1>
				<h2>Adicionar Produtos</h2>
				<form action="/ProjetodePI2/produto" method="post">
						<input type="hidden" name="acao" value="cadastrarProduto">
						
						<input type="text" name="nome" placeholder="nome do produto"><br/>
						<input type="text" name="Quantidade"placeholder="quantidade de produto"><br/>
						<input type="text" name="Pre�o" placeholder="valor do produto"><br/>
						
						<button type="submit" name="Submit">Cadastrar Produto</button>
							<h2 style="color:green;">Produto Adicionado Com Sucesso</h2>
				</form>
				
				<form action="/ProjetodePI2/gerenciarSistema/Produtos/gerenciarProdutos.jsp" method="post">
					<button type="submit">Voltar</button>		
				</form>
							
				
				</div>
	</div>
</body>
</html>