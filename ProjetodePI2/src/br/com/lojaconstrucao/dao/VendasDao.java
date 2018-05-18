package br.com.lojaconstrucao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.lojaconstrucao.modelo.Vendas;

public class VendasDao {
	public void cadastrarVenda(Vendas venda){
		String query = "INSERT INTO relatoriovendas(nomeCliente,vendedor,nomeProduto, quantProduto,precoUNI, precoTOT) VALUES (?, ?, ?,?,?,?)";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1, venda.getNomeCliente());
			ps.setString(2, venda.getNomeVendedor());
			ps.setString(3, venda.getNomeProduto());
			ps.setInt(4, venda.getQuantidade());
			ps.setDouble(5, venda.getPrecoUni());
			ps.setDouble(6, venda.getPrecoTotal());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
