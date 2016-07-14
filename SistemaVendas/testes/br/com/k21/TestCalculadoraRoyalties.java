package br.com.k21;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	VendaRepository vr;
	
	@Before
	public void inicializarMocks(){
		
		 vr = Mockito.mock(VendaRepository.class);	
	}
	
	@Test
	public void testaFaturamentoZeradoparaMesSemVendas() {
		int mes = 1;
		int ano = 2016;
		double valorEsperado = 0d;
		double valorCalculado=0d;
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties();
		
		cr.setVendaRepository(vr);
		
		valorCalculado = cr.calcular(mes, ano);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}	
	
	@Test
	public void testaFaturamentoparaMesComUmaVenda() {
		int mes = 2;
		int ano = 2016;
		double valorEsperado = 190d;
		double valorCalculado=0d;
		
		List<Venda> vendas = new ArrayList<Venda>();
		
		vendas.add(new Venda(1,1,mes,ano,new BigDecimal("1000")));
		
		Mockito.when(vr.obterVendasPorMesEAno(mes, ano)).thenReturn(vendas);
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties();
		
		cr.setVendaRepository(vr);
		
		valorCalculado = cr.calcular(mes, ano);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}
	
	@Test
	public void testaFaturamentoparaMesComDuasVendas() {
		int mes = 3;
		int ano = 2016;
		double valorEsperado = 3950;
		double valorCalculado=0d;
		
		List<Venda> vendas = new ArrayList<Venda>();
		
		vendas.add(new Venda(1,1,mes,ano,new BigDecimal("1000")));
		vendas.add(new Venda(1,1,mes,ano,new BigDecimal("20000")));

		Mockito.when(vr.obterVendasPorMesEAno(mes, ano)).thenReturn(vendas);
		
		CalculadoraRoyalties cr = new CalculadoraRoyalties();
		
		cr.setVendaRepository(vr);
		
		valorCalculado = cr.calcular(mes, ano);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}
}
