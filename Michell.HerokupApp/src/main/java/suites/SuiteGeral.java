package suites;

import static core.DriverFactory.getDriver;
import static core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import pages.Inicializacao;
import pages.TaskPage;
import tests.Configuracao;
import tests.Tasks;


@RunWith(Suite.class)
@SuiteClasses({
	Tasks.class,
	Configuracao.class
})

public class SuiteGeral {

	
	@BeforeClass
	public static void prepararoCenario() throws Exception {
		
		Inicializacao init = new Inicializacao();
		getDriver().get("https://mark7.herokuapp.com");
		init.realizarlogin();
		
		excluirTarefas("Tarefa automatizada");
		excluirTarefas("Tarefa para edição");
		excluirTarefas("Tarefa para ediçãoeditada");
		excluirTarefas("Tarefa para exclusão");
		
		killDriver();
		
	}
	
	private static void excluirTarefas(String tarefa) throws InterruptedException {
		TaskPage pg = new TaskPage();
		
		if(pg.obterTarefa(tarefa)){
		pg.clicarEmExcluirTarefa(tarefa);
		pg.confirmarExclusao();
		}
	}
}
