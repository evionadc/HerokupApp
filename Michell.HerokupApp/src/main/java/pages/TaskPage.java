package pages;

import static Utils.DataUtils.obterDataFormatada;

import java.util.Date;

import org.openqa.selenium.By;

import core.BasePage;

public class TaskPage extends BasePage {

	public void clicarEmNovaTarefa() {
		clicarBotao("insert-button");

	}

	public void preencherTarefa(String nomeTarefa, String tags) {

		esperarElemento("form-submit-button");
		escrever("title", nomeTarefa);
		escrever("dueDate", obterDataFormatada(new Date()));
		escrever(By.xpath("//*[@id='add-task']/div[4]/div/div/input"), tags);

	}

	public void clicarEmSalvar() {

		clicarBotao("form-submit-button");
	}
	
	public String obterTarefacriada(String nomeTarefa) {
		esperarElemento(By.xpath("//table[@id='tasks']/tbody/tr/td/a[.='"+nomeTarefa+"']"));
		return obterTexto(By.xpath("//table[@id='tasks']/tbody/tr/td/a[.='"+nomeTarefa+"']"));
	}
	
	public void clicarEmEditarTarefa(String nomeTarefa) {
		esperarElemento(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']/td[5]/div/button[@id='edit-button']"));
		clicarBotao(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']/td[5]/div/button[@id='edit-button']"));
	}
	
	public void editarTarefa(String nomeTarefa) {

		esperarElemento("form-submit-button");
		escrever(By.name("title"), nomeTarefa);
		clicarRadio(By.name("done"));

	}
	
	public String obterStatusTarefa(String nomeTarefa) {
		esperarElemento(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']/td[1]/span"));
		return obterTexto(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']/td[1]/span"));
	}
	
	public void clicarEmExcluirTarefa(String nomeTarefa) {
		esperarElemento(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']/td[5]/div/button[@id='delete-button']"));
		clicarBotao(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']/td[5]/div/button[@id='delete-button']"));
	}
	
	public void confirmarExclusao() throws InterruptedException {
		esperarElemento(By.xpath("//*[@class='btn btn-danger']"));
		clicarBotao(By.xpath("//*[@class='btn btn-danger']"));
		Thread.sleep(1000);
	}

	public boolean obterTarefa(String nomeTarefa) {
		
		return obterElemento(By.xpath("//table[@id='tasks']/tbody/tr[td/a='"+nomeTarefa+"']"));
	}
}
