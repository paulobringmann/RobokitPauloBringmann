package br.unisc.robokit.displays;

import java.util.Timer;
import java.util.TimerTask;

import org.jfugue.Player;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.comandos.Som;

public class TocadorSom extends Display
{

	private static final long serialVersionUID = 6568174373929666476L;
	
	private static Player player = new Player();
	
	//Rest = R
	public void ativar(ComandoRobokit comando)
	{
		final Som som = (Som) comando;
		
		int duracao = som.getDuracao();
		int numeroExecucoes = duracao / 16;
		
		for( int i = 0; i < numeroExecucoes; i++ )
		{
			player.play(som.getNota().getNome());
		}
		
		
		final Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() 
			{
				timer.cancel();
				parar();
			}
		}, 5, 1);
	}
	
	public void parar()
	{
		super.avisarQueParou();
	}
	
}