package br.unisc.robokit.comandos.notasMusicais;

public class TempoFactory 
{

	/**
	 * @return Tempo em millisegundos
	 */
	public int definirTempo(int codigo)
	{
		switch(codigo)
		{
			case 1 : return 16;
			case 2 : return 32;
			case 3 : return 48;
			case 4 : return 64;
			case 5 : return 80;
			case 6 : return 96;
			case 7 : return 112;
			case 8 : return 128;
		}
		
		return 0;
	}
	
}