package br.com.lojaconstrucao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lojaconstrucao.bo.ClienteBo;
import br.com.lojaconstrucao.bo.ProdutoBo;
import br.com.lojaconstrucao.bo.VendasBo;
import br.com.lojaconstrucao.bo.funcionarioBo;
import br.com.lojaconstrucao.modelo.Cliente;
import br.com.lojaconstrucao.modelo.Funcionario;
import br.com.lojaconstrucao.modelo.Produto;
import br.com.lojaconstrucao.modelo.Vendas;

public class vendasServlet extends HttpServlet {
	Cliente c = new Cliente();
	Funcionario f = new Funcionario();
	Produto p = new Produto();
	ClienteBo cbo = new ClienteBo();
	funcionarioBo fbo = new funcionarioBo();
	ProdutoBo pbo = new ProdutoBo();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] testes;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Vendas venda = new Vendas();
		VendasBo bo = new VendasBo();
		String acao = req.getParameter("acao");
		
		if(acao.equals("mostrarUmFuncionario")){
			if(req.getParameter("id") == "" || req.getParameter("id") == null){
				req.getSession().setAttribute("func", fbo.obterTodosFuncionarios());
				resp.sendRedirect("/ProjetodePI2/Menu/menuVendaErro.jsp");
			}else{
				
				req.getSession().setAttribute("func", fbo.obterFuncionarioId(Integer.parseInt(req.getParameter("id"))));
				req.getSession().setAttribute("clientes", cbo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/Menu/menuVendaCliente.jsp");
			}
		}
		
		if(acao.equals("mostrarUmFuncionariopnome")){
			req.getSession().setAttribute("func", req.getParameter("id"));
			req.getSession().setAttribute("clientes", cbo.listarClientes());
			resp.sendRedirect("/ProjetodePI2/Menu/menuVendaCliente.jsp");
		}
		
		if(acao.equals("mostrarCliente")){
			if(req.getParameter("id") == "" || req.getParameter("id") == null){
				req.getSession().setAttribute("func", req.getParameter("id"));
				req.getSession().setAttribute("clientes", cbo.listarClientes());
				resp.sendRedirect("/ProjetodePI2/Menu/menuVendaClienteErro.jsp");
		}else{
			req.getSession().setAttribute("cliente",cbo.obterClienteId(Integer.parseInt(req.getParameter("id"))));
			req.getSession().setAttribute("produtos",pbo.obterTodosProdutos());
			resp.sendRedirect("/ProjetodePI2/Menu/menuRealizarVenda.jsp");
			
			}
		}
		
		if(acao.equals("realizarVenda")){
			String[] quant = req.getParameterValues("quant");
			String[] id = req.getParameterValues("selecionado");
			int total = 0;
			List<String> escolhidos = new ArrayList<>();
			
			for(int i  = 0; i<quant.length;i++){
				String string = quant[i];
				if(string!=null && string!="" ){
					escolhidos.add(string);
				}
			}

			for (String string : escolhidos) {
				System.out.println("ESCOLHIDOS: "+string);
			}
			
			for(int i = 0; i<id.length; i++){
			p = pbo.obterPorId(Integer.parseInt(id[i]));
			
			total = (int) (total + p.getPreço());
			
			venda.setNomeProduto(p.getNome());
			venda.setNomeCliente(req.getParameter("nomecliente"));
			venda.setNomeVendedor(req.getParameter("nomevendedor"));
			venda.setQuantidade(Integer.parseInt(escolhidos.get(i)));
			venda.setPrecoUni(p.getPreço());
			venda.setPrecoTotal(p.getPreço()*Integer.parseInt(escolhidos.get(i)));
			venda.setPrecototalvenda(venda.getPrecototalvenda()+venda.getPrecoTotal());
			
			bo.cadastrarVenda(venda);
		
			System.out.println("TOTAL TUDO: "+venda.getPrecototalvenda());			}
			//req.getSession().setAttribute("vendas", );
			resp.sendRedirect("/ProjetodePI2/Menu/menuRealizarVenda.jsp");
			
		/*	List<Integer> selecionados = new ArrayList<>();
			
			for (int i = 0; i <id.length;i++) {
				String string = id[i];
				selecionados.add(Integer.parseInt(id[i]));
			}
			
			List<Vendas> vendas = new ArrayList<>();
			
			*/
		}
	
		
	
			/*String[] quant = req.getParameterValues("quant");
			String[] id = req.getParameterValues("selecionado");
			for(int i = 0; i<quant.length; i++){
				if(quant[i] == null || quant[i] == ""){
					System.out.println("Ignora");
				}else{
					for(int e = 0; e<id.length; e++){
						System.out.println("ID selecionado: " +	id[e]);
						System.out.println("Quantidade: " +	quant[i]);
					}
					
					}
			}*/
			
			/*String[] teste = req.getParameterValues("selecionado");
			double total = 0;
			for(int i = 0; i<teste.length; i++){
				System.out.println("aqui: "+teste[i]);
			p = pbo.obterPorId(Integer.parseInt(teste[i]));
			
			total = total + p.getPreço();
			
			venda.setNomeProduto(p.getNome());
			venda.setNomeCliente(req.getParameter("nomecliente"));
			venda.setNomeVendedor(req.getParameter("nomevendedor"));
			venda.setQuantidade(Integer.parseInt(quant[i]));
			venda.setPrecoUni(p.getPreço());
			venda.setPrecoTotal(total);
			venda.setPrecototalvenda(213);
			
			bo.cadastrarVenda(venda);
			}
			resp.sendRedirect("/ProjetodePI2/Menu/menuRealizarVenda.jsp");*/
		
		if(acao.equals("listarVoltar")){
			req.getSession().setAttribute("func", fbo.obterTodosFuncionarios());
			resp.sendRedirect("/ProjetodePI2/Menu/menuVenda.jsp");
		}
	}
}
