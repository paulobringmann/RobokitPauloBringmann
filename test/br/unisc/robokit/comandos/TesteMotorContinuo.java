package br.unisc.robokit.comandos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.unisc.robokit.excecoes.ParametroInvalidoException;

public class TesteMotorContinuo 
{

	private MotorContinuo motor;
	
	@Before
	public void setUp()
	{
		motor = new MotorContinuo();
	}

	@Test
	public void deveriaPrintarADescricao() throws ParametroInvalidoException
	{
		motor.motor(1);
		motor.comVelocidadeDe(200);
		motor.comTempoDeDuracao(200);
		motor.sensorAtivo(false);
		
		assertEquals("MOTOR CONTINUO 1 COM VELOCIDADE DE 005 COM TEMPO 200 SEGUNDOS E COM SENSOR HABILITADO", motor.descricao() );
	}
	
}