package br.unisc.robokit.displays;

import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.comandos.MotorContinuo;

public class DisplayMotorContinuo extends Display
{

	private static final long serialVersionUID = -1436223270776372383L;

	private ImageIcon[] imagens;
	
	private JLabel lblImagem;
    private JLabel lblContador;
    
    private int controlador = 0;
    
    private Timer timer;
    private Timer contadorSegundos;
    
    public DisplayMotorContinuo(ImageIcon[] imagens)
    {
    	this.imagens = imagens;
    
    	setLayout(null);
        setSize(100, 130);
        setBackground(Color.WHITE);
        
        lblImagem = new JLabel(imagens[0]);
        lblImagem.setLocation(0, 10);
        lblImagem.setSize(100, 100);
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblImagem);
        
        lblContador = new JLabel("0s");
        lblContador.setLocation(40, 105);
        lblContador.setSize(100, 25);
        add(lblContador);
    }

    public void ativar(ComandoRobokit comando)
    {
    	MotorContinuo motor = (MotorContinuo) comando;
    	
        int delay = 0;
        int intervalo = Math.abs(motor.getVelocidade() - 1000); //Inversão da velocidade do motor
    
        final int duracao = motor.getTempoDeDuracao();
        
        timer = new Timer();
        contadorSegundos = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask() 
        {
            public void run() {
            	lblImagem.setIcon(getNextIcon());
            }
        }, delay, intervalo);
        
        contadorSegundos.scheduleAtFixedRate(new TimerTask() {
        	int segundos = 0;
        	
			@Override
			public void run() {
				segundos++;
				lblContador.setText(String.format("%d s", segundos));
				
				if(segundos == duracao)
				{
					parar();
				}
			}
		}, delay, 1000);
    }
    
    public void parar()
    {
    	lblContador.setText("0s");
    	
    	timer.cancel();
    	contadorSegundos.cancel();
    	
    	avisarQueParou();
    }
    
    private Icon getNextIcon() 
    {
    	controlador++;
    		
    	if(controlador > imagens.length - 1)
    	{
    		controlador = 0;
    	}

    	return imagens[controlador];
    }
    
}