package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ClienteBo;
import br.com.lojaconstrucao.modelo.Cliente;


public class clienteServlet extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    //teste
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cliente cliente = new Cliente();
		ClienteBo bo = new ClienteBo();
		String acao = req.getParameter("acao");
		
		if(acao.equals("removerCliente")){
			
			bo.removerCliente(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/removerCliente.jsp");	
		}	
		
		if(acao.equals("alterarCliente")){
			cliente.setId(Integer.parseInt(req.getParameter("id")));
			cliente.setNome(req.getParameter("nome"));
			cliente.setTelefone(req.getParameter("telefone"));
			cliente.setEmail(req.getParameter("email"));
			
			bo.alterarCliente(cliente);
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/modificarCliente.jsp");
		}
        
		if(acao.equals("listarConsultarCliente")){
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/consultarClientes.jsp");
		}

		if(acao.equals("listarAlterarCliente")){
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/modificarCliente.jsp");
		}
		
		if(acao.equals("listarRemoverCliente")){
			req.getSession().setAttribute("clientes", bo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Clientes/removerCliente.jsp");
		}
		
		
		
		/*if(acao.equals("cadastrarProduto")){       	
				produto.setNome(req.getParameter("nome"));
	            produto.setQuant(Integer.parseInt(req.getParameter("Quantidade")));
	            produto.setPreço(Double.parseDouble(req.getParameter("Preço")));
	           
	            ProdutoBo produtoBo = new ProdutoBo();
	            produtoBo.cadastrarProduto(produto);
	            
	            resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/produtoAdicionado.jsp");
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
			
		}*/
	}
}

 