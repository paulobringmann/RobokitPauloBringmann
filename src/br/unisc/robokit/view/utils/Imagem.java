package br.unisc.robokit.view.utils;

import javax.swing.ImageIcon;

public class Imagem 
{

	public ImageIcon criarImagem(String caminho)
	{
		java.net.URL imgURL = getClass().getResource(caminho);
	    if (imgURL != null) 
	    {
	        return new ImageIcon(imgURL);
	    } 
	    
	    return null;
	}
	
}