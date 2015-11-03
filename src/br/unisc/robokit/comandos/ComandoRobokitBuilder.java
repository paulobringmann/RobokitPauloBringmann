package br.unisc.robokit.comandos;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.excecoes.ConstrucaoInvalidaException;
import br.unisc.robokit.excecoes.ParametroInvalidoException;
import br.unisc.robokit.view.Mensagens;

public class ComandoRobokitBuilder 
{

	private ComandoRobokit comandoAtual = null;
	
	public ComandoRobokit getComandoAtual()
	{
		return comandoAtual;
	}
	
	public void criarMotorPasso()
	{
		verificarCriacao();
		comandoAtual = new MotorPasso();
	}
	
	public void criarMotorContinuo()
	{
		verificarCriacao();
		comandoAtual = new MotorContinuo();
	}
	
	public void criarLed()
	{
		verificarCriacao();
		comandoAtual = new Led();
	}
	
	public void criarSom()
	{
		verificarCriacao();
		comandoAtual = new Som();
	}
	
	private void verificarCriacao()
	{
		if (comandoAtual != null)
		{
			throw new ConstrucaoInvalidaException(Mensagens.getMensagem("erro.construcao"));
		}
	}
	
	public void resetar()
	{
		comandoAtual = null;
	}
	
	public ComandoRobokit build()
	{
		return comandoAtual;
	}

	//Responsável por fazer toda a configuração do comando, independente do tipo de parametro passado
	public void configurar(Object parametro) throws ParametroInvalidoException 
	{
		comandoAtual.configurar(parametro);
	}
	
}