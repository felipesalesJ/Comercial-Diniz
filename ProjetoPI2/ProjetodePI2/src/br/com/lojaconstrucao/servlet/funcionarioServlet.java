package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.bo.funcionarioBo;
import br.com.lojaconstrucao.modelo.Funcionario;
import br.com.lojaconstrucao.modelo.Produto;

public class funcionarioServlet extends HttpServlet{

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
        Funcionario func = new Funcionario();
        funcionarioBo bo = new funcionarioBo();
		String acao = req.getParameter("acao");

		if(acao.equals("cadastrarFuncionario")){       	
				func.setNome(req.getParameter("nome"));
	            func.setTelefone(req.getParameter("telefone"));
				func.setEmail(req.getParameter("email"));
	            func.setSalario(Double.parseDouble(req.getParameter("salario")));
	            
	            bo.adicionarFuncionario(func);
	            
	            resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/adicionarFuncionario.jsp");
		}
		
		if(acao.equals("alterarFuncionario")){
			func.setId(Integer.parseInt(req.getParameter("id")));
			func.setNome(req.getParameter("nome"));
			func.setTelefone(req.getParameter("telefone"));
			func.setEmail(req.getParameter("email"));
			func.setSalario(Double.parseDouble(req.getParameter("salario")));
			
			bo.modificarFuncionario(func);
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/modificarFuncionario.jsp");
		}
		
		if(acao.equals("removerFuncionario")){
			
			bo.removerFuncionario(Integer.parseInt(req.getParameter("id")));
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Produtos/excluirProdutos.jsp");
			
		}	
		
		if(acao.equals("listarConsultarFuncionario")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/consultarFuncionario.jsp");
		}
		
		if(acao.equals("listarAlterarFuncionarios")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/modificarFuncionario.jsp");
		}
		
		if(acao.equals("listarRemoverFuncionario")){
			req.getSession().setAttribute("func", bo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/gerenciarSistema/Funcionario/excluirFuncionario.jsp");
		}
	}
} 