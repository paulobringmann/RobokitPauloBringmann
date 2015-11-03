package br.unisc.robokit;

import br.unisc.robokit.excecoes.ParametroInvalidoException;

public interface ComandoRobokit 
{

	public void executar();
	
	public String descricao();
	
	public void configurar(Object parametro) throws ParametroInvalidoException;

	//FIXME Temporario
	public int getPassoConfiguracao();
	
	//public String getMensagemProximoPasso();
	
}