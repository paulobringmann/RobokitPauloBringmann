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
import br.unisc.robokit.comandos.DirecaoEsquerda;
import br.unisc.robokit.comandos.MotorPasso;
import br.unisc.robokit.view.utils.Imagem;

public class DisplayMotorPasso extends Display
{

	private static final long serialVersionUID = -3538186051645630909L;

	private ImageIcon[] imagens;
    
	private JLabel lblImagem;
    private JLabel lblNumeroPasso;
	
    private int controlador = 0;
    
    private MotorPasso motor;
    private Timer timer;
    
    public DisplayMotorPasso()
    {
    	setLayout(null);
        setSize(100, 130);
        setBackground(Color.WHITE);
        
        imagens = new ImageIcon[10];
        imagens[0] = new Imagem().criarImagem("/assets/MP_0.png");
        imagens[1] = new Imagem().criarImagem("/assets/MP_1.png");
        imagens[2] = new Imagem().criarImagem("/assets/MP_2.png");
        imagens[3] = new Imagem().criarImagem("/assets/MP_3.png");
        imagens[4] = new Imagem().criarImagem("/assets/MP_4.png");
        imagens[5] = new Imagem().criarImagem("/assets/MP_5.png");
        imagens[6] = new Imagem().criarImagem("/assets/MP_6.png");
        imagens[7] = new Imagem().criarImagem("/assets/MP_7.png");
        imagens[8] = new Imagem().criarImagem("/assets/MP_8.png");
        imagens[9] = new Imagem().criarImagem("/assets/MP_9.png");
        
        lblNumeroPasso = new JLabel("Nº Passo: 0");
        lblNumeroPasso.setLocation(15, 105);
        lblNumeroPasso.setSize(100, 25);
        add(lblNumeroPasso);
        
        lblImagem = new JLabel(imagens[0]);
        lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagem.setLocation(0, 10);
        lblImagem.setSize(100, 100);
        add(lblImagem);
    }
    
    public void ativar(ComandoRobokit comando)
    {
    	MotorPasso motor = (MotorPasso) comando;
    	
    	this.motor = motor;
    	
        int delay = 0;
        int intervalo = motor.getVelocidade();
   
    	final int numeroPassos = motor.getNumeroDePassos();
    	
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() 
        {
        	int contador = 0;
        	
            public void run() 
            {
            	contador++;
            	lblImagem.setIcon(getNextIcon());
            	lblNumeroPasso.setText(String.format("Nº Passo: %d", contador));
            
            	if(contador == numeroPassos)
            	{
            		parar();
            	}
            }
        }, delay, intervalo);
    }
    
    public void parar()
    {
    	lblNumeroPasso.setText("Nº Passo: 0");
    	
		timer.cancel();
    
		avisarQueParou();
    }
    
    private Icon getNextIcon() 
    {
    	if(motor.getDirecao() instanceof DirecaoEsquerda )
    	{
    		controlador--;
    		
    		if(controlador < 0)
    		{
    			controlador = imagens.length - 1;
    		}
    	}
    	else
    	{
    		controlador++;
    		
    		if(controlador > imagens.length - 1)
    		{
    			controlador = 0;
    		}
    	}

    	return imagens[controlador];
    }
   
}