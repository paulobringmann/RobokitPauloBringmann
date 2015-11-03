package br.unisc.robokit.comandos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.unisc.robokit.excecoes.ParametroInvalidoException;

public class TesteComandoRobokitBuilder 
{

	private ComandoRobokitBuilder construtor;
	
	@Before
	public void setUp()
	{
		construtor = new ComandoRobokitBuilder();
	}
	
	@Test
	public void deveriaCriarMotorDePasso()
	{
		construtor.criarMotorPasso();
		
		assertEquals(MotorPasso.class, construtor.getComandoAtual().getClass());
	}
	
	@Test
	public void deveriaAbstrairAConfiguracaoDoMotorDePasso() throws ParametroInvalidoException
	{
		construtor.criarMotorPasso();
		construtor.configurar(new DirecaoEsquerda());
		construtor.configurar(150);
		construtor.configurar(950);
		construtor.configurar(false);
		
		MotorPasso motor = (MotorPasso) construtor.getComandoAtual();
		assertEquals(motor.getDirecao().getClass(), DirecaoEsquerda.class);
		assertEquals(150, motor.getNumeroDePassos());
		assertEquals(950, motor.getVelocidade());
		assertFalse(motor.isSensorAtivo());
	}
	
	@Test
	public void deveriaAbstrairAConfiguracaoDoMotorContinuo() throws ParametroInvalidoException
	{
		construtor.criarMotorContinuo();
		construtor.configurar(2);
		construtor.configurar(150);
		construtor.configurar(220);
		construtor.configurar(false);
		
		MotorContinuo motor = (MotorContinuo) construtor.getComandoAtual();
		assertEquals(2, motor.getNumeroDoMotor());
		assertEquals(150, motor.getVelocidade());
		assertEquals(220, motor.getTempoDeDuracao());
		assertFalse(motor.isSensorAtivo());
	}
	
	@Test
	public void deveriaAbstrairAConfiguracaoDaLed() throws ParametroInvalidoException
	{
		construtor.criarLed();
		construtor.configurar(2);
		construtor.configurar(150);
		construtor.configurar(false);
		construtor.configurar(false);
		
		Led led = (Led) construtor.getComandoAtual();
		assertEquals(2, led.getNumeroDoLed());
		assertEquals(150, led.getTempoLigado());
		assertFalse(led.isSempreLigado());
		assertFalse(led.isSensorAtivo());
	}
	
	@Test
	public void deveriaAbstrairAConfiguracaoDoSom() throws ParametroInvalidoException
	{
		construtor.criarSom();
		construtor.configurar(1);
		construtor.configurar(1);
		
		Som som = (Som) construtor.getComandoAtual();
		fail("Implementar...");
	}
	
}