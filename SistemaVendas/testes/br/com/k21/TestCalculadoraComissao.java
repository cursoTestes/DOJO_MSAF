package br.com.k21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestCalculadoraComissao {
	
	
	@Test
	public void testaValoresAbaixoDe10Mil() {
		double valorVenda = 1000d;
		double valorEsperado = 50d;
		double valorCalculado=0d;
		
		valorCalculado = CalculadoraComissao.calcular(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}
	@Test
	public void testaValorLimiteDezMil () {
		double valorVenda = 10000d;
		double valorEsperado = 500d;
		double valorCalculado=0d;
		
		valorCalculado = CalculadoraComissao.calcular(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}
	
	@Test
	public void testaValorLimiteMaiorQueDezMilInferior () {
		double valorVenda = 10001d;
		double valorEsperado = 600.06d;
		double valorCalculado=0d;
		
		valorCalculado = CalculadoraComissao.calcular(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado, 0.01);
	}	
	
	@Test
	public void testaValorDeVendaDecimalMenorQue10Mil () {
		double valorVenda = 8500.58d;
		double valorEsperado = 425.02d;
		double valorCalculado=0d;
		
		valorCalculado = CalculadoraComissao.calcular(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}	
	
	@Test
	public void testaValoresAcimade10Mil() {
		double valorVenda = 20000d;
		double valorEsperado = 1200d;
		double valorCalculado= 0d;
		
		valorCalculado = CalculadoraComissao.calcular(valorVenda);
		
		assertEquals(valorEsperado, valorCalculado, 0);
	}
	
	
		
}
