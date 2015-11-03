package br.unisc.robokit.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import br.unisc.robokit.view.TecladoNumerico;

public class TecladoNumericoEvento implements ActionListener
{

	private JTextField tfEntrada;
	private TecladoNumerico teclado;
	
	public TecladoNumericoEvento(JTextField tfEntrada, TecladoNumerico teclado)
	{
		this.tfEntrada = tfEntrada;
		this.teclado = teclado;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == teclado.getBotao0())
		{
			tfEntrada.setText(tfEntrada.getText() + "0");
		}
		else if(e.getSource() == teclado.getBotao1())
		{
			tfEntrada.setText(tfEntrada.getText() + "1");
		}
		else if(e.getSource() == teclado.getBotao2())
		{
			tfEntrada.setText(tfEntrada.getText() + "2");
		}
		else if(e.getSource() == teclado.getBotao3())
		{
			tfEntrada.setText(tfEntrada.getText() + "3");
		}
		else if(e.getSource() == teclado.getBotao4())
		{
			tfEntrada.setText(tfEntrada.getText() + "4");
		}
		else if(e.getSource() == teclado.getBotao5())
		{
			tfEntrada.setText(tfEntrada.getText() + "5");
		}
		else if(e.getSource() == teclado.getBotao6())
		{
			tfEntrada.setText(tfEntrada.getText() + "6");
		}
		else if(e.getSource() == teclado.getBotao7())
		{
			tfEntrada.setText(tfEntrada.getText() + "7");
		}
		else if(e.getSource() == teclado.getBotao8())
		{
			tfEntrada.setText(tfEntrada.getText() + "8");
		}
		else if(e.getSource() == teclado.getBotao9())
		{
			tfEntrada.setText(tfEntrada.getText() + "9");
		}
	}
	
}