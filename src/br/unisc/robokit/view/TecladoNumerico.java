package br.unisc.robokit.view;

import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.unisc.robokit.eventos.TecladoNumericoEvento;

public class TecladoNumerico extends JPanel
{

	private static final long serialVersionUID = -9071101572037568349L;

	private JButton botao1;
	private JButton botao2;
	private JButton botao3;
	private JButton botao4;
	private JButton botao5;
	private JButton botao6;
	private JButton botao7;
	private JButton botao8;
	private JButton botao9;
	private JButton botao0;
	private JButton botaoESC;
	private JButton botaoOk;
	
	public TecladoNumerico(JTextField tfEntrada)
	{
		setLayout(null);
		setBackground(null);
		setBounds(135, 120, 120, 160);
		
		TecladoNumericoEvento evento = new TecladoNumericoEvento(tfEntrada, this);
		
		botao1 = criarBotao("/assets/um.jpg");
	    botao1.setLocation(0, 0);
	    botao1.addActionListener(evento);
	    add(botao1);
	    
	    botao2 = criarBotao("/assets/dois.jpg");
	    botao2.setLocation(40, 0);
	    botao2.addActionListener(evento);
	    add(botao2);
	    
	    botao3 = criarBotao("/assets/tres.jpg");
	    botao3.setLocation(80, 0);
	    botao3.addActionListener(evento);
	    add(botao3);
	    
		botao4 = criarBotao("/assets/quatro.jpg");
	    botao4.setLocation(0, 40);
	    botao4.addActionListener(evento);
	    add(botao4);
	    
	    botao5 = criarBotao("/assets/cinco.jpg");
	    botao5.setLocation(40, 40);
	    botao5.addActionListener(evento);
	    add(botao5);
	    
	    botao6 = criarBotao("/assets/seis.jpg");
	    botao6.setLocation(80, 40);
	    botao6.addActionListener(evento);
	    add(botao6);
	
	    botao7 = criarBotao("/assets/sete.jpg");
	    botao7.setLocation(0, 80);
	    botao7.addActionListener(evento);
	    add(botao7);
	    
	    botao8 = criarBotao("/assets/oito.jpg");
	    botao8.setLocation(40, 80);
	    botao8.addActionListener(evento);
	    add(botao8);
	    
	    botao9 = criarBotao("/assets/nove.jpg");
	    botao9.setLocation(80, 80);
	    botao9.addActionListener(evento);
	    add(botao9);
	    
	    botaoESC = criarBotao("/assets/esc.jpg");
	    botaoESC.setLocation(0, 120);
	    add(botaoESC);
	    
	    botao0 = criarBotao("/assets/zero.jpg");
	    botao0.setLocation(40, 120);
	    botao0.addActionListener(evento);
	    add(botao0);
	    
	    botaoOk = criarBotao("/assets/executar.jpg");
	    botaoOk.setLocation(80, 120);
	    add(botaoOk);
	}
		
	public JButton getBotao1() {
		return botao1;
	}

	public JButton getBotao2() {
		return botao2;
	}

	public JButton getBotao3() {
		return botao3;
	}

	public JButton getBotao4() {
		return botao4;
	}

	public JButton getBotao5() {
		return botao5;
	}

	public JButton getBotao6() {
		return botao6;
	}

	public JButton getBotao7() {
		return botao7;
	}

	public JButton getBotao8() {
		return botao8;
	}

	public JButton getBotao9() {
		return botao9;
	}

	public JButton getBotao0() {
		return botao0;
	}

	public JButton getBotaoESC() {
		return botaoESC;
	}
	
	public JButton getBotaoOk() {
		return botaoOk;
	}
	
	public List<JButton> getTodosBotoes() {
		return  Arrays.asList( botao0, botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botaoOk, botaoESC );
	}
	
	private JButton criarBotao(String caminhoImagem)
	{
		return new BotaoFactory().criarBotao(caminhoImagem);
	}
	
}