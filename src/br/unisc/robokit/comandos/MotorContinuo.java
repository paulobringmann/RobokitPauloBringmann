package br.unisc.robokit.comandos;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.excecoes.ParametroInvalidoException;

public class MotorContinuo implements ComandoRobokit
{

	private int numeroDoMotor;
	
	private int velocidade;
	
	private int tempoDeDuracao;
	
	private boolean sensorAtivo;
	
	private int passoConfiguracao;
	
	public MotorContinuo()
	{
		passoConfiguracao = 1;
	}
	
	public void configurar(Object parametro) throws ParametroInvalidoException
	{
		switch( passoConfiguracao )
		{
			case 1 : 
			motor((Integer) parametro);
			break;
			
			case 2 :
			comVelocidadeDe((Integer) parametro);
			break;
			
			case 3 :
			comTempoDeDuracao((Integer) parametro);
			break;
			
			case 4 :
			sensorAtivo((Boolean) parametro);
			break;
		}
	}

	public void motor(int numeroDoMotor) throws ParametroInvalidoException
	{
		if(numeroDoMotor != 1 && numeroDoMotor != 2)
		{
			throw new ParametroInvalidoException("Código do motor inválido");
		}
		
		this.numeroDoMotor = numeroDoMotor;
		passoConfiguracao++;
	}
	
	public void comVelocidadeDe(int velocidade) throws ParametroInvalidoException
	{
		if(velocidade < 1 || velocidade > 999)
		{
			throw new ParametroInvalidoException("Velocidade fora do limite permitido");
		}
		
		this.velocidade = velocidade;
		passoConfiguracao++;
	}
	
	public void comTempoDeDuracao(int tempo) throws ParametroInvalidoException
	{
		if(tempo < 1 || tempo > 240)
		{
			throw new ParametroInvalidoException("Tempo fora do limite permitido");
		}
		
		this.tempoDeDuracao = tempo;
		passoConfiguracao++;
	}
	
	public void sensorAtivo(boolean sensor)
	{
		this.sensorAtivo = sensor;
	}

	@Override
	public void executar() 
	{
		
	}

	@Override
	public String descricao() 
	{
		StringBuilder descricao = new StringBuilder("MOTOR CONTINUO ");
		descricao.append(numeroDoMotor);
		descricao.append(" COM VELOCIDADE DE ").append(velocidade);
		descricao.append(" COM TEMPO ").append(tempoDeDuracao).append(" SEGUNDO(S)");
		descricao.append(" E COM SENSOR ");
		
		if(sensorAtivo)
			descricao.append("HABILITADO");
		else
			descricao.append("DESABILITADO");
	
		return descricao.toString();
	}

	public int getNumeroDoMotor() {
		return numeroDoMotor;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public int getTempoDeDuracao() {
		return tempoDeDuracao;
	}

	public boolean isSensorAtivo() {
		return sensorAtivo;
	}

	@Override
	public int getPassoConfiguracao() {
		return passoConfiguracao;
	}
	
}