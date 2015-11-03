package br.unisc.robokit;

import java.util.ArrayList;
import java.util.List;

public class Robokit 
{

	private List<ComandoRobokit> historico;
	
	public Robokit()
	{
		limparMemoria();
	}
	
	public void executar(ComandoRobokit command)
	{
		command.executar();
		historico.add(command);
	}
	
	public List<ComandoRobokit> historico()
	{
		return historico;
	}

	public void limparMemoria() 
	{
		this.historico = new ArrayList<ComandoRobokit>();
	}

	public ComandoRobokit getComando(int indice) 
	{
		if(indice > historico.size() - 1)
		{
			return null; //FIXME Disparar erro
		}
		
		return historico.get(indice);
	}
	
}