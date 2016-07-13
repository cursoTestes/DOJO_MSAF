package br.com.k21;

public class CalculadoraComissao {

	private static final double ValorComissaoFaixa2 = 0.06;
	private static final double ValorComissaoFaixa1 = 0.05;

	public static double calcular( double valor ){
		double comissao =0d;
		if (valor > 0d && valor <= 10000d){
			comissao = valor *ValorComissaoFaixa1;
			
		}	else {
			comissao = valor *ValorComissaoFaixa2;
		
		}
		return ArredondarParaBaixo(comissao);
	}

	private static double ArredondarParaBaixo(double comissao) {
		return Math.floor(comissao * 100)/100;
	}
	
		
}
