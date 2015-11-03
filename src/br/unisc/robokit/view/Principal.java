package br.unisc.robokit.view;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.Robokit;
import br.unisc.robokit.comandos.ComandoRobokitBuilder;
import br.unisc.robokit.comandos.DirecaoDireita;
import br.unisc.robokit.comandos.DirecaoEsquerda;
import br.unisc.robokit.comandos.Led;
import br.unisc.robokit.comandos.MotorContinuo;
import br.unisc.robokit.comandos.MotorPasso;
import br.unisc.robokit.comandos.Sensor;
import br.unisc.robokit.comandos.Som;
import br.unisc.robokit.displays.Display;
import br.unisc.robokit.displays.DisplayLed;
import br.unisc.robokit.displays.DisplayMotorContinuo;
import br.unisc.robokit.displays.DisplayMotorPasso;
import br.unisc.robokit.displays.TocadorSom;
import br.unisc.robokit.eventos.ExecucaoComandoEvento;
import br.unisc.robokit.eventos.ExecucaoComandoListener;
import br.unisc.robokit.excecoes.ParametroInvalidoException;
import br.unisc.robokit.view.utils.Imagem;

public class Principal extends JApplet
{
	
	private static final long serialVersionUID = -1482981119069611175L;
	
	private Robokit robokit;
	private ComandoRobokitBuilder construtorComandos;
	
	private JButton botaoMotorPasso;
	private JButton botaoGirarDireita;
	private JButton botaoGirarEsquerda;
	private JButton botaoMotorContinuo;
	private JButton botaoLed;
	private JButton botaoSom;
	private JButton botao0;
	private JButton botao1;
	private JButton botao2;
	private JButton botao3;
	private JButton botao4;
	private JButton botao5;
	private JButton botao6;
	private JButton botao7;
	private JButton botao8;
	private JButton botao9;
	private JButton botaoESC;
	private JButton botaoOk;
	private JButton botaoExcluirComandos;
	private JButton botaoExecutarComando;
	private JButton botaoExecutarLista;
	private JButton botaoLimparMemoria;
	private JButton botaoSair;
	private JButton botaoAjuda;
	private JButton botaoPararVoltar;
	
	private List<JButton> botoes;
	private List<JButton> teclado;
	
	private DisplayLed[] leds;
	private DisplayMotorContinuo[] motores;
	private DisplayMotorPasso displayMotorPasso;
	private TocadorSom tocador;
	
	private JLabel lblTotalComandos;
	private JTable tabelaComandos;
	private GerenciadorTabelaComandos modelo;
	
	private TecladoNotasMusicais tecladoNotasMusicais;
	private TecladoNumerico botoesDigitos;
	
	private void criarDispositivos()
	{
	    motores = new DisplayMotorContinuo[2];
	    
	    DisplayMotorContinuo displayMotorContinuo1 = new DisplayMotorContinuo(new ImageIcon[]{ new Imagem().criarImagem("/assets/MC_1_0.png"), new Imagem().criarImagem("/assets/MC_1_1.png"), new Imagem().criarImagem("/assets/MC_1_2.png"), new Imagem().criarImagem("/assets/MC_1_3.png") });
	    displayMotorContinuo1.setLocation(400, 10);
	    displayMotorContinuo1.setBorder(new TitledBorder("MC 1"));
	    add(displayMotorContinuo1);
	    motores[0] = displayMotorContinuo1;
	    
	    DisplayMotorContinuo displayMotorContinuo2 = new DisplayMotorContinuo(new ImageIcon[]{ new Imagem().criarImagem("/assets/MC_2_0.png"), new Imagem().criarImagem("/assets/MC_2_1.png"), new Imagem().criarImagem("/assets/MC_2_2.png"), new Imagem().criarImagem("/assets/MC_2_3.png"), new Imagem().criarImagem("/assets/MC_2_4.png"), new Imagem().criarImagem("/assets/MC_2_5.png") });
	    displayMotorContinuo2.setLocation(545, 10);
	    
	    displayMotorContinuo2.setBorder(new TitledBorder("MC 2"));
	    add(displayMotorContinuo2);
	    motores[1] = displayMotorContinuo2;
	    
	    displayMotorPasso = new DisplayMotorPasso();
	    displayMotorPasso.setLocation(690, 10);
	    displayMotorPasso.setBorder(new TitledBorder("MP"));
	    add(displayMotorPasso);
	    
	    leds = new DisplayLed[4];
	    
	    final DisplayLed displayLed1 = new DisplayLed(new Imagem().criarImagem("/assets/LED_1_0.png"), new Imagem().criarImagem("/assets/LED_1_1.png"));
	    displayLed1.setLocation(395, 160);
	    displayLed1.setBorder(new TitledBorder("LED 1"));
	    add(displayLed1);
	    leds[0] = displayLed1;
	    
	    final DisplayLed displayLed2 = new DisplayLed(new Imagem().criarImagem("/assets/LED_2_0.png"), new Imagem().criarImagem("/assets/LED_2_1.png"));
	    displayLed2.setLocation(495, 160);
	    displayLed2.setBorder(new TitledBorder("LED 2"));
	    add(displayLed2);
	    leds[1] = displayLed2;
	     
	    final DisplayLed displayLed3 = new DisplayLed(new Imagem().criarImagem("/assets/LED_3_0.png"), new Imagem().criarImagem("/assets/LED_3_1.png"));
	    displayLed3.setLocation(595, 160);
	    displayLed3.setBorder(new TitledBorder("LED 3"));
	    add(displayLed3);
	    leds[2] = displayLed3;
	    
	    final DisplayLed displayLed4 = new DisplayLed(new Imagem().criarImagem("/assets/LED_4_0.png"), new Imagem().criarImagem("/assets/LED_4_1.png"));
	    displayLed4.setLocation(695, 160);
	    displayLed4.setBorder(new TitledBorder("LED 4"));
	    add(displayLed4);
	    leds[3] = displayLed4;
	    
	    tocador = new TocadorSom();
	}
	
	public void init() 
	{
		getContentPane().setBackground(new Color(255, 255, 255));
		robokit = new Robokit();
		construtorComandos = new ComandoRobokitBuilder();
		
		criarDispositivos();
		
		modelo  = new GerenciadorTabelaComandos();
	    tabelaComandos = new JTable(modelo);

	    JScrollPane scrollPane = new JScrollPane(tabelaComandos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    tabelaComandos.getColumnModel().getColumn(1).setPreferredWidth(660);
	    tabelaComandos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		setLayout(null);
		setSize(800, 600);
		
		final JTextField tfEntrada = new JTextField();
	    tfEntrada.setBounds(90, 60, 200, 25);
	    add(tfEntrada);
	    
		final JTextArea mensagens = new JTextArea();
	    mensagens.setBounds(90, 10, 200, 50);
	    mensagens.setEditable(false);
	    add(mensagens);
	    
	    JLabel lblComandosCadastrados = new JLabel("Total de comandos cadastrados:");
	    lblComandosCadastrados.setBounds(10, 300, 200, 20);
	    add(lblComandosCadastrados);
	    
	    lblTotalComandos = new JLabel("0");
	    lblTotalComandos.setBounds(200, 300, 50, 20);
	    add(lblTotalComandos);
	    
		JPanel botoesMotores = new JPanel();
		botoesMotores.setLayout(null);
		botoesMotores.setBackground(null);
		botoesMotores.setBounds(10, 10, 80, 80);
		
	    botaoMotorPasso = criarBotao("/assets/mp.jpg");
	    botaoMotorPasso.setLocation(20, 0);
	    botaoMotorPasso.addActionListener(new ActionListener() 
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				construtorComandos.criarMotorPasso();
				mensagens.setText(Mensagens.getMensagem("criacao.motorPasso"));
				habilitarBotoes(botaoGirarDireita, botaoGirarEsquerda);
			}
		});
	    botoesMotores.add(botaoMotorPasso);
	    
	    botaoGirarDireita = criarBotao("/assets/gire_direita.jpg");
	    botaoGirarDireita.setLocation(40, 40);
	    botaoGirarDireita.addActionListener(new ActionListener() 
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if( configurar(new DirecaoDireita()) )
				{
					mensagens.setText(Mensagens.getMensagem("parametros.girarDireita"));	
					habilitarBotoes(teclado);
				}
			}
		});
	    botoesMotores.add(botaoGirarDireita);    
	    
	    botaoGirarEsquerda = criarBotao("/assets/gire_esquerda.jpg");
	    botaoGirarEsquerda.setLocation(0, 40);
	    botaoGirarEsquerda.addActionListener(new ActionListener() 
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				if( configurar(new DirecaoEsquerda()) )
				{
					mensagens.setText(Mensagens.getMensagem("parametros.girarEsquerda"));
					habilitarBotoes(teclado);
				}
			}
		});
	    botoesMotores.add(botaoGirarEsquerda);
	    
	    add(botoesMotores);
	    
	    JPanel botoesOutrasFuncoes = new JPanel();
	    botoesOutrasFuncoes.setLayout(null);
	    botoesOutrasFuncoes.setBackground(null);
	    botoesOutrasFuncoes.setBounds(300, 10, 80, 80);
		
	    botaoMotorContinuo = criarBotao("/assets/mc.jpg");
	    botaoMotorContinuo.setLocation(0, 0);
	    botaoMotorContinuo.addActionListener(new ActionListener() 
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				construtorComandos.criarMotorContinuo();
				mensagens.setText(Mensagens.getMensagem("criacao.motorContinuo"));
				habilitarBotoes(botao1, botao2, botaoOk);
			}
		});
	    botoesOutrasFuncoes.add(botaoMotorContinuo);  
	    
	    botaoLed = criarBotao("/assets/led.jpg");
	    botaoLed.setLocation(40, 0);
	    botaoLed.addActionListener(new ActionListener() 
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				construtorComandos.criarLed();
				mensagens.setText(Mensagens.getMensagem("criacao.led"));
				habilitarBotoes(botao1, botao2, botao3, botao4, botaoOk);
			}
		});
	    botoesOutrasFuncoes.add(botaoLed); 
	    
	    botaoSom = criarBotao("/assets/som.jpg");
	    botaoSom.setLocation(20, 40);
	    botaoSom.addActionListener(new ActionListener() 
	    {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				construtorComandos.criarSom();
				mensagens.setText(Mensagens.getMensagem("criacao.som"));
				habilitarBotoes(botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botaoOk);
			}
		});
	    botoesOutrasFuncoes.add(botaoSom);
	    
	    add(botoesOutrasFuncoes);
	   
	    botoesDigitos = new TecladoNumerico(tfEntrada);
		botao1 = botoesDigitos.getBotao1();
		botao0 = botoesDigitos.getBotao0();
		botao2 = botoesDigitos.getBotao2();
		botao3 = botoesDigitos.getBotao3();
		botao4 = botoesDigitos.getBotao4();
		botao5 = botoesDigitos.getBotao5();
		botao6 = botoesDigitos.getBotao6();
		botao7 = botoesDigitos.getBotao7();
		botao8 = botoesDigitos.getBotao8();
		botao9 = botoesDigitos.getBotao9();
		botaoESC = botoesDigitos.getBotaoESC();
		botaoOk = botoesDigitos.getBotaoOk();
		   
	    botaoOk.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if( construtorComandos.getComandoAtual() instanceof MotorPasso )
				{
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 2)
					{
						if( configurarInteiro(tfEntrada.getText()) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.configurarVelocidade"));
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 3)
					{
						if( configurarInteiro(tfEntrada.getText()) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.ativarSensor"));
							habilitarBotoes(botaoOk, botaoESC);
						}	
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 4)
					{
						if( configurar(Sensor.HABILITADO) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.sensorHabilitado"));
							
							robokit.executar(construtorComandos.getComandoAtual());
							modelo.incluir(construtorComandos.getComandoAtual());
							displayMotorPasso.ativar((MotorPasso) construtorComandos.getComandoAtual());
							resetarBotoes();
							construtorComandos.resetar();
							
							atualizarContagemListaComandos();
						}
					}
				}
				
				else if( construtorComandos.getComandoAtual() instanceof MotorContinuo )
				{
					MotorContinuo motor = (MotorContinuo) construtorComandos.getComandoAtual();
					
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 1)
					{
						if( configurarInteiro(tfEntrada.getText()) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.configurarVelocidade"));
							habilitarBotoes(teclado);
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 2)
					{
						if( configurarInteiro(tfEntrada.getText()) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.configurarTempo"));
							habilitarBotoes(teclado);
						}					
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 3)
					{
						if( configurarInteiro(tfEntrada.getText()) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.ativarSensor"));
							habilitarBotoes(botaoOk, botaoESC);
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 4)
					{
						if( configurar(Sensor.HABILITADO) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.sensorHabilitado"));
							
							robokit.executar(construtorComandos.getComandoAtual());
							modelo.incluir(construtorComandos.getComandoAtual());
							motores[motor.getNumeroDoMotor() - 1].ativar(motor);
							resetarBotoes();
							construtorComandos.resetar();
							
							atualizarContagemListaComandos();
						}
					}
				}
				
				else if( construtorComandos.getComandoAtual() instanceof Led )
				{
					Led led = (Led) construtorComandos.getComandoAtual();
					
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 1)
					{
						if( configurarInteiro(tfEntrada.getText()) ) //Configura Numero da Led
						{
							mensagens.setText(Mensagens.getMensagem("parametros.configurarTempo")); //Proximo passo
							habilitarBotoes(teclado);
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 2)
					{
						if( configurarInteiro(tfEntrada.getText()) ) //Configura o Tempo
						{
							mensagens.setText(Mensagens.getMensagem("parametros.ligadoSempre"));
							habilitarBotoes(botaoOk, botaoESC);
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 3 )
					{
						if( configurar(Led.LIGADO_SEMPRE) ) //Configura Se fica Ligado depois do tempo
						{
							mensagens.setText(Mensagens.getMensagem("parametros.ativarSensor"));
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 4 )
					{
						if( configurar(Sensor.HABILITADO) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.sensorHabilitado")); //Configura sensor habilitado
							
							robokit.executar(construtorComandos.getComandoAtual());
							modelo.incluir(construtorComandos.getComandoAtual());
							leds[led.getNumeroDoLed() - 1].ativar(led);
							resetarBotoes();
							construtorComandos.resetar();
							
							atualizarContagemListaComandos();
						}
					}
				}
				
				else if( construtorComandos.getComandoAtual() instanceof Som )
				{
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 1)
					{
						if( configurarInteiro(tfEntrada.getText()) ) //Tempo de duracao
						{
							mensagens.setText(Mensagens.getMensagem("parametros.notaMusical"));
							
							botoesDigitos.setVisible(false);
							tecladoNotasMusicais.setVisible(true);
						}
					}
				}
				
				tfEntrada.setText("");
			}
		});
		
	    botaoESC.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				if(construtorComandos.getComandoAtual() instanceof MotorPasso )
				{
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 4)
					{
						if( configurar(Sensor.DESABILITADO) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.sensorDesabilitado"));
							
							robokit.executar(construtorComandos.getComandoAtual());
							modelo.incluir(construtorComandos.getComandoAtual());
							displayMotorPasso.ativar((MotorPasso) construtorComandos.getComandoAtual());
							resetarBotoes();
							construtorComandos.resetar();
						}					
					}
				}
				
				else if(construtorComandos.getComandoAtual() instanceof MotorContinuo )
				{
					MotorContinuo motor = (MotorContinuo) construtorComandos.getComandoAtual();
					
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 4)
					{					
						if( configurar(Sensor.DESABILITADO) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.sensorDesabilitado"));
							
							robokit.executar(construtorComandos.getComandoAtual());
							modelo.incluir(construtorComandos.getComandoAtual());
							motores[motor.getNumeroDoMotor() - 1].ativar(motor);
							resetarBotoes();
							construtorComandos.resetar();
							
							atualizarContagemListaComandos();
						}	
					}
				}
				
				else if( construtorComandos.getComandoAtual() instanceof Led )
				{
					Led led = (Led) construtorComandos.getComandoAtual();
					
					if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 3 )
					{						
						if( configurar(Led.DESLIGAR_APOS_EXECUCAO) ) //Configura Se fica Ligado depois do tempo
						{
							mensagens.setText(Mensagens.getMensagem("parametros.ativarSensor"));
						}
					}
					else if(construtorComandos.getComandoAtual().getPassoConfiguracao() == 4 )
					{
						if( configurar(Sensor.DESABILITADO) )
						{
							mensagens.setText(Mensagens.getMensagem("parametros.sensorDesabilitado")); //Configura sensor habilitado
							
							robokit.executar(construtorComandos.getComandoAtual());
							modelo.incluir(construtorComandos.getComandoAtual());
							leds[led.getNumeroDoLed() - 1].ativar(led);
							resetarBotoes();
							construtorComandos.resetar();
						}
					}
				}
			}
		});
	    add(botoesDigitos);
	    
	    tecladoNotasMusicais = new TecladoNotasMusicais(tfEntrada);
	    tecladoNotasMusicais.setVisible(false);
	    add(tecladoNotasMusicais);
	    
	    tecladoNotasMusicais.getBotaoOk().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if( configurar(tfEntrada.getText()) ) //Configura a Nota Musical
				{
					mensagens.setText("");
					tfEntrada.setText("");
					
					robokit.executar(construtorComandos.getComandoAtual());
					modelo.incluir(construtorComandos.getComandoAtual());
					resetarBotoes();

					tocador.ativar((Som) construtorComandos.getComandoAtual());
					
					tecladoNotasMusicais.setVisible(false);
					botoesDigitos.setVisible(true);
					construtorComandos.resetar();
					
					atualizarContagemListaComandos();
				}
			}
		});
	    
	    botaoExecutarComando = criarBotao("/assets/executacomando.jpg");
	    botaoExecutarComando.setLocation(10, 120);
	    botaoExecutarComando.setSize(77, 33);
	    botaoExecutarComando.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				int linhaSelecionada = tabelaComandos.getSelectedRow();
				
				if(linhaSelecionada == -1)
				{
					JOptionPane.showMessageDialog(null, "Selecione um comando para executar");
				}
				else
				{
					ComandoRobokit comando = modelo.getLinhas().get(linhaSelecionada);
					getDisplay(comando).ativar(comando);
				}
			}
		});
	    add(botaoExecutarComando);
	    
	    botaoExecutarLista = criarBotao("/assets/executalista.jpg");
	    botaoExecutarLista.setLocation(10, 160);
	    botaoExecutarLista.setSize(77, 33);
	    botaoExecutarLista.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				mensagens.setText("Executando lista...");
				executarListaComandos();
				mensagens.setText("");
			}
		});
	    add(botaoExecutarLista);
	    
	    botaoExcluirComandos = criarBotao("/assets/excluircomandos.jpg");
	    botaoExcluirComandos.setLocation(10, 200);
	    botaoExcluirComandos.setSize(77, 33);
	    botaoExcluirComandos.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				lblTotalComandos.setText("0");
				mensagens.setText("Comandos excluidos");
			}
		});
	    add(botaoExcluirComandos);
	    
	    botaoLimparMemoria = criarBotao("/assets/limparmemoria.jpg");
	    botaoLimparMemoria.setLocation(10, 240);
	    botaoLimparMemoria.setSize(77, 33);
	    botaoLimparMemoria.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				lblTotalComandos.setText("0");
				robokit.limparMemoria();
				modelo.removerTodos();
			}
		});
	    add(botaoLimparMemoria);
	    
	    botaoSair = criarBotao("/assets/sair.jpg");
	    botaoSair.setLocation(300, 240);
	    botaoSair.setSize(77, 33);
	    botaoSair.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
	    add(botaoSair);
	    
	    botaoPararVoltar = criarBotao("/assets/PARAR_VOLTAR.png");
	    botaoPararVoltar.setLocation(300, 160);
	    botaoPararVoltar.setSize(77, 33);
	    botaoPararVoltar.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				pararComandos();
			}
		});
	    add(botaoPararVoltar);
	    
	    botaoAjuda = criarBotao("/assets/ajudautilsoftware.jpg");
	    botaoAjuda.setLocation(300, 200);
	    botaoAjuda.setSize(77, 33);
	    botaoAjuda.addActionListener(new ActionListener() 
	    {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				mensagens.setText("Ajuda");
			}
		});
	    add(botaoAjuda);
	    tabelaComandos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    scrollPane.setBounds(10, 350, 775, 200);
	    tabelaComandos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    tabelaComandos.getColumnModel().getColumn(0).setMaxWidth(25);
	    tabelaComandos.getColumnModel().getColumn(2).setMaxWidth(85);
	    add(scrollPane);
	    
	    teclado = Arrays.asList( botao0, botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botaoOk );

		botoes = new ArrayList<JButton>();
		botoes.addAll(Arrays.asList( botaoMotorPasso, botaoGirarDireita, botaoGirarEsquerda, botaoMotorContinuo, botaoLed, 
	    		botaoSom, botaoExcluirComandos, botaoESC ));
		botoes.addAll(teclado);
		
	    resetarBotoes();
	}
	
	private boolean configurarInteiro(String texto)
	{
		try
		{
			Integer numero = Integer.parseInt(texto);
			return configurar(numero);
		}
		catch(NumberFormatException ex)
		{
			JOptionPane.showMessageDialog(null, "Somente numeros são validos");
			System.out.println("Return false...");
			return false;
		}
	}
	
	private boolean configurar(Object parametro)
	{
		try
		{
			construtorComandos.getComandoAtual().configurar(parametro);
			return true;
		}
		catch(ParametroInvalidoException ex)
		{
			JOptionPane.showMessageDialog(null, ex.getLocalizedMessage());
			return false;
		}
	}

	private JButton criarBotao(String caminhoImagem)
	{
		return new BotaoFactory().criarBotao(caminhoImagem);
	}
	
	private void resetarBotoes()
	{
		habilitarBotoes( botaoMotorPasso, botaoMotorContinuo, botaoLed, botaoSom );
	}
	
	private void habilitarBotoes(JButton... botoes)
	{
		habilitarBotoes(Arrays.asList(botoes));
	}
	
	private void habilitarBotoes(List<JButton> botoes, JButton... outros)
	{
		desabilitarBotoes();
		
		for(JButton botao : botoes )
		{
			botao.setEnabled(true);
		}
		
		for(JButton botao : outros )
		{
			botao.setEnabled(true);
		}
	}
	
	private void habilitarBotoes(List<JButton> botoes)
	{
		desabilitarBotoes();
		
		for(JButton botao : botoes )
		{
			botao.setEnabled(true);
		}
	}
	
	private void desabilitarBotoes()
	{
		for(JButton botao : botoes)
		{
			botao.setEnabled(false);
		}
	}
	
	private boolean estaEmExecucao = false;
	private int posicao = 0;
	
	private void executarListaComandos()
	{
		estaEmExecucao = true;
		executarProximoComando();
	}
	
	private void executarProximoComando()
	{
		ComandoRobokit comando = robokit.getComando(posicao);
		final Display display = getDisplay(comando);
		display.addExecucaoComandoListener(new ExecucaoComandoListener() 
		{	
			@Override
			public void comandoTerminouExecucao(ExecucaoComandoEvento e) 
			{
				if(posicao < robokit.historico().size() && estaEmExecucao)
				{
					executarProximoComando();
				}
				else
				{
					estaEmExecucao = false;
					posicao = 0;
				}
				
				display.removeExecucaoComandoListener(this);
			}
		});
		
		if(estaEmExecucao)
		{
			display.ativar(comando);
			posicao++;
		}
	}
	
	private void pararComandos()
	{
		List<ComandoRobokit> comandos = robokit.historico();
		
		for(ComandoRobokit comando : comandos)
		{
			getDisplay(comando).parar();
		}
	}
	
	private Display getDisplay(ComandoRobokit comando)
	{
		if(comando instanceof MotorPasso)
		{
			return displayMotorPasso;
		}
		else if(comando instanceof MotorContinuo)
		{
			MotorContinuo motorContinuo = (MotorContinuo) comando;
			return motores[motorContinuo.getNumeroDoMotor() - 1];
		}
		else if(comando instanceof Led)
		{
			Led led = (Led) comando;
			return leds[led.getNumeroDoLed() - 1];
		}
		else if(comando instanceof Som)
		{
			return tocador;
		}
		
		//Classe vazia para não disparar Null-Pointer-Exception
		return new Display() {
			@Override
			public void parar() {}
	
			@Override
			public void ativar(ComandoRobokit comando) {}
		};
	}
	
	private void atualizarContagemListaComandos()
	{
		lblTotalComandos.setText(String.valueOf(robokit.historico().size()));
	}
	
}