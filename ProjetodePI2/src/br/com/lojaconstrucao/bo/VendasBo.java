package br.com.lojaconstrucao.bo;

import br.com.lojaconstrucao.dao.VendasDao;
import br.com.lojaconstrucao.modelo.Vendas;

public class VendasBo {
	VendasDao dao = new VendasDao();
	public void cadastrarVenda(Vendas venda){
		dao.cadastrarVenda(venda);
	}
}
