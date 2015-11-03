package br.unisc.robokit.excecoes;

public class ConstrucaoInvalidaException extends RuntimeException
{

	private static final long serialVersionUID = 7889574900316984683L;

	public ConstrucaoInvalidaException(String mensagem)
	{
		super(mensagem);
	}
	
}