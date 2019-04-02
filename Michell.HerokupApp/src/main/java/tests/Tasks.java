package tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTest;
import pages.TaskPage;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tasks extends BaseTest{
	
	TaskPage pg = new TaskPage();
	
	@Test
	public void teste01Tasks() {
			
		String nomeTarefa = "Tarefa automatizada";
		String tags ="testes,selenium,";
		criarTarefa(nomeTarefa, tags);
		
		Assert.assertEquals(nomeTarefa, pg.obterTarefacriada(nomeTarefa));
	
	}
	
	@Test
	public void teste02EditarTask() {
		
		String nomeTarefa = "Tarefa para edição";
		String tags ="testes,selenium,";
		
		criarTarefa(nomeTarefa, tags);
		
		pg.clicarEmEditarTarefa(nomeTarefa);
		pg.editarTarefa(nomeTarefa + "editada");
		pg.clicarEmSalvar();
		
		
		Assert.assertEquals("Finalizado", pg.obterStatusTarefa(nomeTarefa + "editada"));
	}
	
	@Test
	public void teste03ExcluirTask() throws InterruptedException {
		String nomeTarefa = "Tarefa para exclusão";
		
		criarTarefa(nomeTarefa, "testes,selenium,");
		
		pg.clicarEmExcluirTarefa(nomeTarefa);
		pg.confirmarExclusao();
		
		Assert.assertFalse(pg.obterTarefa(nomeTarefa));
		
	}
	
	public void criarTarefa(String nomeTarefa, String tags) {
		pg.clicarEmNovaTarefa();
		pg.preencherTarefa(nomeTarefa,tags);
		pg.clicarEmSalvar();
	}
	
}
