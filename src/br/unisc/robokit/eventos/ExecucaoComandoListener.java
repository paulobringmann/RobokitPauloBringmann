package br.unisc.robokit.eventos;

public interface ExecucaoComandoListener extends java.util.EventListener
{

	public void comandoTerminouExecucao(ExecucaoComandoEvento e);
	
}