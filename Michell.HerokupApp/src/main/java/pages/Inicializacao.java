package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class Inicializacao extends BasePage{
	
	public void realizarlogin() {
		escrever("login_email", "michell.soares@outlook.com");
		escrever("login_password","jasmim30");
		
		clicarBotao("lockedtop_0$ctl07$lockedtop_0$btnLoginctl07$lockedtop_0$ctl05$");
		
		esperarElemento(By.xpath("//*[@id='task-board']//h3"));
		
	}

}
