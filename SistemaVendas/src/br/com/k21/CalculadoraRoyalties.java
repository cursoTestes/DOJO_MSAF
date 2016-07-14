package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraRoyalties {
	
	

	private VendaRepository vendaRepository = new VendaRepository();

	public double calcular(int mes, int ano) {
		List<Venda> lista =  getVendaRepository().obterVendasPorMesEAno(mes, ano);
		
		double totalComissao = 0d;
		double valorTotalVendas = 0d;
		
		for (Venda venda : lista) {
			valorTotalVendas = valorTotalVendas 
					+ venda.getValor().doubleValue();
			
			totalComissao = totalComissao + 
					CalculadoraComissao.calcular(venda.getValor().doubleValue());
		}
		
		return (valorTotalVendas - totalComissao) * 0.20 ;
	}

	public VendaRepository getVendaRepository() {
		return vendaRepository;
	}

	public void setVendaRepository(VendaRepository vendaRepository) {
		this.vendaRepository = vendaRepository;
	}

}
