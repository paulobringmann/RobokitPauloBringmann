package br.unisc.robokit.view;

import javax.swing.JButton;

import br.unisc.robokit.view.utils.Imagem;

public class BotaoFactory 
{

	public JButton criarBotao(String caminhoImagem)
	{
		JButton b = new JButton(new Imagem().criarImagem(caminhoImagem));
	    b.setBackground(null);
	    //b.setBorder(null);
	    b.setSize(31, 31);
	    return b;
	}
	
}