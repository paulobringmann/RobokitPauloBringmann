package br.unisc.robokit.comandos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unisc.robokit.excecoes.ParametroInvalidoException;

public class TesteMotorPasso 
{
	
	private MotorPasso motor;
	
	@Before
	public void setUp()
	{
		motor = new MotorPasso();
	}

	@Test
	public void deveriaPrintarADescricao() throws ParametroInvalidoException
	{
		motor.girarPara(new DirecaoEsquerda());
		motor.numeroDePassos(100);
		motor.comVelocidadeDe(005);
		motor.sensorAtivo(false);
		motor.executar();
		
		assertEquals("MOTOR DE PASSO GIRAR À ESQUERDA Nº DE PASSOS 100 COM VELOCIDADE DE 005 E COM SENSOR DESABILITADO", motor.descricao() );
	}
	
}