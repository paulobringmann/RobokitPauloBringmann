package br.unisc.robokit.comandos.notasMusicais;

public class NotaMusicalFactory 
{

	public NotaMusical criarNotaMusical(int codigo)
	{
		switch(codigo)
		{
			case 1 : return new Do();
			case 2 : return new DoSustenido();
			case 3 : return new Re();
			case 4 : return new ReSustenido();
			case 5 : return new Mi();
			case 6 : return new MiSustenido();
			case 7 : return new Fa();
			case 8 : return new FaSustenido();
			case 9 : return new Sol();
			case 10 : return new SolSustenido();
			case 11 : return new La();
			case 12 : return new LaSustenido();
			case 13 : return new Si();
			case 14 : return new Pausa();
		}
		
		return new Pausa(); //FIXME Disparar erro?
	}
	
	public NotaMusical criarNotaMusical(String codigo)
	{
		if(codigo.equals("C"))
			return new Do();
		else if(codigo.equals("C#"))
			return new DoSustenido();
		else if(codigo.equals("D"))
			return new Re();
		else if(codigo.equals("D#"))
			return new ReSustenido();
		else if(codigo.equals("E"))
			return new Mi();
		else if(codigo.equals("E#"))
			return new MiSustenido();
		else if(codigo.equals("F"))
			return new Fa();
		else if(codigo.equals("F#"))
			return new FaSustenido();
		else if(codigo.equals("G"))
			return new Sol();
		else if(codigo.equals("G#"))
			return new SolSustenido();
		else if(codigo.equals("A"))
			return new La();
		else if(codigo.equals("A#"))
			return new LaSustenido();
		else if(codigo.equals("B"))
			return new Si();
		else if(codigo.equals("P"))
			return new Pausa();
		
		return new Pausa(); //FIXME Disparar erro?
	}
	
}