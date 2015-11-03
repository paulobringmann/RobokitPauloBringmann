package br.unisc.robokit.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import br.unisc.robokit.view.TecladoNotasMusicais;
import br.unisc.robokit.view.TecladoNumerico;

public class TecladoNotasMusicaisEvento implements ActionListener
{

	private JTextField tfEntrada;
	private TecladoNotasMusicais teclado;
	
	public TecladoNotasMusicaisEvento(JTextField tfEntrada, TecladoNotasMusicais teclado)
	{
		this.tfEntrada = tfEntrada;
		this.teclado = teclado;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == teclado.getBotaoDo())
		{
			tfEntrada.setText("C");
		}
		else if(e.getSource() == teclado.getBotaoDoSustenido())
		{
			tfEntrada.setText("C#");
		}
		else if(e.getSource() == teclado.getBotaoFa())
		{
			tfEntrada.setText("F");
		}
		else if(e.getSource() == teclado.getBotaoFaSustenido())
		{
			tfEntrada.setText("F#");
		}
		else if(e.getSource() == teclado.getBotaoLa())
		{
			tfEntrada.setText("A");
		}
		else if(e.getSource() == teclado.getBotaoLaSustenido())
		{
			tfEntrada.setText("A#");
		}
		else if(e.getSource() == teclado.getBotaoMi())
		{
			tfEntrada.setText("E");
		}
		else if(e.getSource() == teclado.getBotaoMiSustenido())
		{
			tfEntrada.setText("E#");
		}
		else if(e.getSource() == teclado.getBotaoPausa())
		{
			tfEntrada.setText("P");
		}
		else if(e.getSource() == teclado.getBotaoRe())
		{
			tfEntrada.setText("D");
		}
		else if(e.getSource() == teclado.getBotaoReSustenido())
		{
			tfEntrada.setText("D#");
		}
		else if(e.getSource() == teclado.getBotaoSi())
		{
			tfEntrada.setText("B");
		}
		else if(e.getSource() == teclado.getBotaoSol())
		{
			tfEntrada.setText("G");
		}
		else if(e.getSource() == teclado.getBotaoSolSustenido())
		{
			tfEntrada.setText("G#");
		}
	}
	
}