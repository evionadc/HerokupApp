package pages;

import org.openqa.selenium.By;

import com.github.javafaker.Faker;

import core.BasePage;

public class ConfiguracaoPages extends BasePage {

	
	public void clicarEmConfiguracoes() {
		
		clicarBotao(By.xpath("//ul[@class='nav luna-nav']/li/a[@href='/user_settings']"));
		
	}
	
	public void setEmpresa() {
		
		esperarElemento("profile-company");
		escrever("profile-company", new Faker().company().name());
		
	}
	
	public void Salvar() {
		
		clicarBotao("form-submit-button");
	}
	
	public String obterMensagem() {
		
		return obterTexto(By.xpath("//form//div[@class='panel-body']"));
	}
}
