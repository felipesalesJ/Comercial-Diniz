package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.modelo.Produto;

public class produtosServlet extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Produto produto = new Produto();
        ProdutoBo bo = new ProdutoBo();
		String acao = req.getParameter("acao");
        
		if(acao.equals("cadastrarProduto")){       	
				produto.setNome(req.getParameter("nome"));
	            produto.setQuant(Integer.parseInt(req.getParameter("Quantidade")));
	            produto.setPreço(Double.parseDouble(req.getParameter("Preço")));
	           
	            ProdutoBo produtoBo = new ProdutoBo();
	            produtoBo.cadastrarProduto(produto);
	            
	            //req.getSession().setAttribute("produtos", );
	            resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/produtoAdicionado.jsp");
	            
		}
		
		if(acao.equals("alterarProduto")){
			produto.setId(Integer.parseInt(req.getParameter("id")));
			produto.setNome(req.getParameter("nome"));
			produto.setQuant(Integer.parseInt(req.getParameter("quantidade")));
			produto.setPreço(Double.parseDouble(req.getParameter("valor")));
			
			bo.alterarProduto(produto);
			
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/alterarProdutos.jsp");
		}
		
		if(acao.equals("removerProduto")){
			
			bo.removerProduto(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/excluirProdutos.jsp");
			
		}
		
		if(acao.equals("listarAlteraProdutos")){
			req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/alterarProdutos.jsp");
		}
		
		if(acao.equals("listarConsultarProdutos")){
			req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/consultarProdutos.jsp");
		}	
		
		if(acao.equals("listarExcluirProdutos")){
			req.getSession().setAttribute("produtos", bo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/excluirProdutos.jsp");
			
		}
	}
}

 