package br.unisc.robokit.comandos;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.excecoes.ParametroInvalidoException;
import br.unisc.robokit.utils.Utils;

public class MotorPasso implements ComandoRobokit
{

	private Direcao direcao;
	
	private int numeroDePassos = 0;
	
	private int velocidade = 0;
	
	private boolean sensorAtivo = false;
	
	private int passoConfiguracao;
	
	public MotorPasso()
	{
		passoConfiguracao = 1;
	}
	
	public void executar()
	{
		
	}

	public void configurar(Object parametro) throws ParametroInvalidoException
	{
		switch( passoConfiguracao )
		{
			case 1 : 
			girarPara((Direcao) parametro);
			break;
			
			case 2 :
			numeroDePassos((Integer) parametro);
			break;
			
			case 3 :
			comVelocidadeDe((Integer) parametro);
			break;
			
			case 4 :
			sensorAtivo((Boolean) parametro);
			break;
		}
	}
	
	public void girarPara(Direcao direcao) 
	{
		this.direcao = direcao;
		passoConfiguracao++;
	}

	public void numeroDePassos(int numeroDePassos) throws ParametroInvalidoException
	{
		if(numeroDePassos < 1 || numeroDePassos > 999)
		{
			throw new ParametroInvalidoException("Número de passos fora do limite permitido.");
		}
		
		this.numeroDePassos = numeroDePassos;
		passoConfiguracao++;
	}
	
	public void comVelocidadeDe(int velocidade) throws ParametroInvalidoException
	{
		if(velocidade < 1 || velocidade > 999)
		{
			throw new ParametroInvalidoException("Velocidade foram do limite permitido");
		}
		
		this.velocidade = velocidade;
		passoConfiguracao++;
	}
	
	public void sensorAtivo(boolean sensor)
	{
		this.sensorAtivo = sensor;
		passoConfiguracao++;
	}

	@Override
	public String descricao() 
	{
		StringBuilder descricao = new StringBuilder("MOTOR DE PASSO");
		descricao.append(" GIRAR À ").append(direcao.getDescricao());
		descricao.append(" Nº DE PASSOS ").append(numeroDePassos);
		descricao.append(" COM VELOCIDADE DE ").append( new Utils().preencherComZerosAEsquerda(String.valueOf(velocidade), 3) );
		descricao.append(" E COM SENSOR ");
		
		if(sensorAtivo)
			descricao.append("HABILITADO");
		else
			descricao.append("DESABILITADO");
		
		return descricao.toString();
	}
	
	public int getNumeroDePassos() {
		return numeroDePassos;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public boolean isSensorAtivo() {
		return sensorAtivo;
	}

	public Direcao getDirecao() 
	{
		return direcao;
	}

	@Override
	public int getPassoConfiguracao() {
		return passoConfiguracao;
	}
	
}