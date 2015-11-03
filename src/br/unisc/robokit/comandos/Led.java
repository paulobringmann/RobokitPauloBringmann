package br.unisc.robokit.comandos;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.excecoes.ParametroInvalidoException;

public class Led implements ComandoRobokit
{

	public static final Boolean LIGADO_SEMPRE = true;
	public static final Boolean DESLIGAR_APOS_EXECUCAO = false;
	
	private int numeroDoLed;
	
	private int tempoLigado;
	
	private boolean sempreLigado;
	
	private boolean sensorAtivo;
	
	private int passoConfiguracao;
	
	public Led()
	{
		passoConfiguracao = 1;
	}
	
	public void configurar(Object parametro) throws ParametroInvalidoException
	{
		switch( passoConfiguracao )
		{
			case 1 : 
			ligarLed((Integer) parametro);
			break;
			
			case 2 :
			comTempoDeDuracao((Integer) parametro);
			break;
			
			case 3 :
			ficarSempreLigado((Boolean) parametro);
			break;
			
			case 4 :
			sensorAtivo((Boolean) parametro);
			break;
		}
	}
	
	public void ligarLed(int numero) throws ParametroInvalidoException
	{
		if( numero < 1 || numero > 4 )
		{
			throw new ParametroInvalidoException("Código do LED inválido.");
		}
		
		this.numeroDoLed = numero;
		passoConfiguracao++;
	}
	
	public void comTempoDeDuracao(int tempo) throws ParametroInvalidoException
	{
		//FIXME Tem um periodo de limite?
		this.tempoLigado = tempo;
		passoConfiguracao++;
	}
	
	public void sensorAtivo(boolean sensorAtivo)
	{
		this.sensorAtivo = sensorAtivo;
		passoConfiguracao++;
	}
	
	public void ficarSempreLigado(boolean sempreLigado)
	{
		this.sempreLigado = sempreLigado;
		passoConfiguracao++;
	}

	@Override
	public void executar() 
	{
		
	}

	@Override
	public String descricao() 
	{
		StringBuilder descricao = new StringBuilder("LED");
		descricao.append(" ").append(numeroDoLed);
		descricao.append(" COM TEMPO LIGADO ").append(tempoLigado).append(" SEGUNDO(S)");
		descricao.append(", O LED ");
		
		if(sempreLigado)
			descricao.append("NÃO ");
		
		descricao.append("DESLIGARÁ APÓS TEMPO DETERMINADO");
		descricao.append(" E COM SENSOR ");
		
		if(sensorAtivo)
			descricao.append("HABILITADO");
		else
			descricao.append("DESABILITADO");
		
		return descricao.toString();
	}

	public int getNumeroDoLed() {
		return numeroDoLed;
	}

	public int getTempoLigado() {
		return tempoLigado;
	}

	public boolean isSempreLigado() {
		return sempreLigado;
	}

	public boolean isSensorAtivo() {
		return sensorAtivo;
	}

	@Override
	public int getPassoConfiguracao() {
		return passoConfiguracao;
	}

}