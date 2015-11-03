package br.unisc.robokit.comandos;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.comandos.notasMusicais.NotaMusical;
import br.unisc.robokit.comandos.notasMusicais.NotaMusicalFactory;
import br.unisc.robokit.comandos.notasMusicais.TempoFactory;
import br.unisc.robokit.excecoes.ParametroInvalidoException;

public class Som implements ComandoRobokit
{

	private int duracao; //Duracao em ms
	
	private NotaMusical nota;
	
	private int passoConfiguracao;
	
	public Som()
	{
		passoConfiguracao = 1;
	}
	
	public void configurar(Object parametro) throws ParametroInvalidoException
	{
		switch( passoConfiguracao )
		{
			case 1 :
			comDuracaoDe((Integer) parametro);
			break;
			
			case 2 :
			comNotaMusical((String) parametro);
			break;
		}
	}
	
	public void comDuracaoDe(int codigoDuracao) throws ParametroInvalidoException
	{
		if(codigoDuracao < 1 || codigoDuracao > 8)
		{
			throw new ParametroInvalidoException("Código de duração inválido.");
		}
		
		this.duracao = new TempoFactory().definirTempo(codigoDuracao);
		passoConfiguracao++;
	}
	
	public void comNotaMusical(String codigoNotaMusical) throws ParametroInvalidoException
	{
		this.nota = new NotaMusicalFactory().criarNotaMusical(codigoNotaMusical);
		passoConfiguracao++;
	}
	
	public NotaMusical getNota()
	{
		return nota;
	}
	
	public int getDuracao()
	{
		return duracao;
	}
	
	@Override
	public void executar() 
	{
		
	}

	@Override
	public String descricao() 
	{
		//FIXME Colocar descrição com
		StringBuilder descricao = new StringBuilder();
		
		descricao.append("TOCAR A NOTA MUSICAL ");
		descricao.append(nota.getNome());
		descricao.append(" POR ");
		descricao.append(duracao)
		.append("ms");
		
		return descricao.toString();
	}

	@Override
	public int getPassoConfiguracao() {
		return passoConfiguracao;
	}
	
}