package br.unisc.robokit.displays;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.comandos.Led;

public class DisplayLed extends Display
{

	private static final long serialVersionUID = -2497685458964865031L;

	private ImageIcon imgDesligada;
    private ImageIcon imgLigada;
    
    private JLabel lblImagem;
    private JLabel lblContador;
    
    private Timer timer;
    
    private Led led;
    
    public DisplayLed(final ImageIcon imgDesligada, final ImageIcon imgLigada)
    {
        this.imgDesligada = imgDesligada;
        this.imgLigada = imgLigada;
        
        setLayout(null);
        setSize(100, 130);
        setBackground(Color.WHITE);
        
        lblContador = new JLabel("0 s");
        lblContador.setLocation(40, 105);
        lblContador.setSize(100, 25);
        add(lblContador);
        
        lblImagem = new JLabel(imgDesligada);
        lblImagem.setSize(100, 100);
        lblImagem.setIcon(imgDesligada);
        add(lblImagem);
    }

    public void ativar(ComandoRobokit comando)
    {
    	Led led = (Led) comando;
    	this.led = led;
    	
        int delay = 0;
        int intervalo = 1000; //1s
   
    	final int tempoLigada = led.getTempoLigado();
    	
    	ligar();
    	
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() 
        {
        	int contador = 0;
        	
            public void run() 
            {
            	contador++;
            	
            	lblContador.setText(String.format("%d s", contador));
            
            	if(contador == tempoLigada)
            	{
            		parar();   		
            	}
            }
        }, delay, intervalo);
    }
    
    public void parar()
    {
    	timer.cancel();
    	
    	if(!led.isSempreLigado())
		{
			desligar();
		}
    	
    	lblContador.setText("0s");
    	
    	super.avisarQueParou();
    }
    
    private void ligar()
    {
        lblImagem.setIcon(imgLigada);
    }
    
    private void desligar()
    {
        lblImagem.setIcon(imgDesligada);
    }
       
}