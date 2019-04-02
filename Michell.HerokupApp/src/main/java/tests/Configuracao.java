package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.ConfiguracaoPages;

public class Configuracao extends BaseTest {
	
	ConfiguracaoPages cp = new ConfiguracaoPages();

	@Test
	public void teste01AlterarEmpresa() {
		
		cp.clicarEmConfiguracoes();
		cp.setEmpresa();
		cp.Salvar();
		
		Assert.assertEquals("Perfil atualizado com sucesso.", cp.obterMensagem());
		
	}
	
}
