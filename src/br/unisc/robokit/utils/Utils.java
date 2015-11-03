package br.unisc.robokit.utils;

public class Utils 
{

	public String preencherComZerosAEsquerda(String palavra, int tamanhoFinal)
	{
		int contador = tamanhoFinal - palavra.length();
		
		StringBuilder concatenacoes = new StringBuilder("");
		
		for(int i = 0; i < contador; i++)
		{
			concatenacoes.append("0");
		}

		concatenacoes.append(palavra);
		
		return concatenacoes.toString();
	}
	
}