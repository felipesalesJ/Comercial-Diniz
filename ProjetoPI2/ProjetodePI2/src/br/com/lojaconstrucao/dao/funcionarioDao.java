package br.com.lojaconstrucao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.lojaconstrucao.modelo.Funcionario;
import br.com.lojaconstrucao.modelo.Produto;

public class funcionarioDao {
	Funcionario func = new Funcionario();
	
	public void adicionarFuncionario(Funcionario func){
		String query = "INSERT INTO funcionarios(nome,telefone,email, salario) VALUES (?, ?, ?, ?)";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1,func.getNome());
			ps.setString(2, func.getTelefone());
			ps.setString(3, func.getEmail());
			ps.setDouble(4, func.getSalario());
			ps.execute();
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> obterTodosFuncionarios(){
		String query = "Select * from funcionarios";
		Connection con = new Conexao().obterConexao();
		List<Funcionario> func = new ArrayList<>();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setTelefone(rs.getString("telefone"));
				f.setEmail(rs.getString("email"));
				f.setSalario(rs.getDouble("salario"));
				func.add(f);
			}
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return func;
	}
	
	public void modificarFuncionario(Funcionario funcionario){
		String query = "update funcionarios set nome = ?, telefone = ?, email = ?, salario = ? where id = ?";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getTelefone());
			ps.setString(3, funcionario.getEmail());
			ps.setDouble(4, funcionario.getSalario());
			ps.setInt(5,funcionario.getId());
			ps.executeUpdate();
			ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	public void removerFuncionario(int id){
		String query = "delete from funcionarios where id = ?";
		Connection con = new Conexao().obterConexao();
		PreparedStatement ps = null;
		try{
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}
	
	
	
	/*
	public List<Produto> obterTodosProdutos(){
		String query = "select * from Produtos";
		Connection con = new Conexao().obterConexao();
		List<Produto> produtos = new ArrayList<>();
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setQuant(rs.getInt("quant"));
				produto.setPreço(rs.getDouble("preco"));
				produtos.add(produto);
			}
			ps.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return produtos;
	}
	
	
	*/
}
