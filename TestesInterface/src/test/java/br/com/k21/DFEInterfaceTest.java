package br.com.k21;

import junit.framework.Assert;

import org.fluentlenium.adapter.FluentTest;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DFEInterfaceTest extends FluentTest {

	@Override
	public WebDriver getDefaultDriver() {
		return new FirefoxDriver();
	}
	
	@Test
	public void teste_login_com_sucesso() {
		FazerLogin();
		
		String urlEsperada = "https://h.dfe.mastersaf.com.br/mvc/rps/painel/index";
		
		Assert.assertEquals(urlEsperada,
				url());
					
	}

	@Test
	public void teste_Cadastro_Carta() {
		
		FazerLogin();
		
		goTo("https://h.dfe.mastersaf.com.br/mvc/camposCartaCorrecao/adicionar");
		
		
		String msgSuc = CadastrarNovaCarta("Teste do Teclado Quente");
		
		Assert.assertEquals("Operação realizada com sucesso! ",
				msgSuc);
					
	}

	private String CadastrarNovaCarta(String descricao) {
		fill("#descricaoCampo").with(descricao);
		click("#formCamposCartaCorrecao/div[1]/div[1]/div/input");
		
		String msgSuc = findFirst("#msafModalWindowBoxGeralBody/span").getText();
		return msgSuc;
	}
	
	private void FazerLogin() {
		goTo("https://h.dfe.mastersaf.com.br/mvc/login");
		fill("#nomeusuario").with("lucasgermani");
		fill("#senha").with("123456");
		
		submit("#enter");
	}	
			
	
}
