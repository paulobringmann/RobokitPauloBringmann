package br.unisc.robokit.view;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.unisc.robokit.eventos.TecladoNotasMusicaisEvento;

public class TecladoNotasMusicais extends JPanel
{
	
	private static final long serialVersionUID = 4395126120415389490L;

	private JButton botaoPausa;
	private JButton botaoOk;
	
	private JButton botaoLa;
	private JButton botaoSi;
	private JButton botaoDo;
	private JButton botaoRe;
	private JButton botaoMi;
	private JButton botaoFa;
	private JButton botaoSol;
	
	private JButton botaoLaSustenido;
	private JButton botaoDoSustenido;
	private JButton botaoReSustenido;
	private JButton botaoMiSustenido;
	private JButton botaoFaSustenido;
	private JButton botaoSolSustenido;
	
	private JButton[] notas;
	private JButton[] notasSustenidas;
	
	public TecladoNotasMusicais(JTextField tfEntrada)
	{
		setLayout(null);
		setBackground(null);
		setBounds(135, 120, 120, 160);
		
		JCheckBox cxSustenido = new JCheckBox("Sustenido");
		cxSustenido.setLocation(0, 0);
		cxSustenido.setSize(200, 20);
		cxSustenido.setBackground(null);
		cxSustenido.addChangeListener(new ChangeListener() 
		{	
			@Override
			public void stateChanged(ChangeEvent ev) 
			{
				if( ((JCheckBox) ev.getSource()).isSelected() )
				{
					esconder(notas);
					mostra(notasSustenidas);
					
					botaoSi.setEnabled(false);
				}
				else
				{
					esconder(notasSustenidas);
					mostra(notas);
					
					botaoSi.setEnabled(true);
				}
			}
		});
		add(cxSustenido);
		
		TecladoNotasMusicaisEvento evento = new TecladoNotasMusicaisEvento(tfEntrada, this);
		
		botaoLa = criarBotao("/assets/la.png");
	    botaoLa.setLocation(0, 40);
	    botaoLa.addActionListener(evento);
	    add(botaoLa);
	    
	    botaoSi = criarBotao("/assets/si.png");
	    botaoSi.setLocation(40, 40);
	    botaoSi.addActionListener(evento);
	    add(botaoSi);
	    
	    botaoDo = criarBotao("/assets/do.png");
	    botaoDo.setLocation(80, 40);
	    botaoDo.addActionListener(evento);
	    add(botaoDo);
	
	    botaoRe = criarBotao("/assets/re.png");
	    botaoRe.setLocation(0, 80);
	    botaoRe.addActionListener(evento);
	    add(botaoRe);
	    
	    botaoMi = criarBotao("/assets/mi.png");
	    botaoMi.setLocation(40, 80);
	    botaoMi.addActionListener(evento);
	    add(botaoMi);
	    
	    botaoFa = criarBotao("/assets/fa.png");
	    botaoFa.setLocation(80, 80);
	    botaoFa.addActionListener(evento);
	    add(botaoFa);
	    
	    botaoPausa = criarBotao("/assets/pausa.png");
	    botaoPausa.setLocation(0, 120);
	    botaoPausa.addActionListener(evento);
	    add(botaoPausa);
	    
	    botaoSol = criarBotao("/assets/sol.png");
	    botaoSol.setLocation(40, 120);
	    botaoSol.addActionListener(evento);
	    add(botaoSol);
	    
	    botaoLaSustenido = criarBotao("/assets/la_sustenido.png");
	    botaoLaSustenido.setLocation(0, 40);
	    botaoLaSustenido.addActionListener(evento);
	    add(botaoLaSustenido);
	    
	    botaoDoSustenido = criarBotao("/assets/do_sustenido.png");
	    botaoDoSustenido.setLocation(80, 40);
	    botaoDoSustenido.addActionListener(evento);
	    add(botaoDoSustenido);
	
	    botaoReSustenido = criarBotao("/assets/re_sustenido.png");
	    botaoReSustenido.setLocation(0, 80);
	    botaoReSustenido.addActionListener(evento);
	    add(botaoReSustenido);
	    
	    botaoMiSustenido = criarBotao("/assets/mi_sustenido.png");
	    botaoMiSustenido.setLocation(40, 80);
	    botaoMiSustenido.addActionListener(evento);
	    add(botaoMiSustenido);
	    
	    botaoFaSustenido = criarBotao("/assets/fa_sustenido.png");
	    botaoFaSustenido.setLocation(80, 80);
	    botaoFaSustenido.addActionListener(evento);
	    add(botaoFaSustenido);
	    
	    botaoSolSustenido = criarBotao("/assets/sol_sustenido.png");
	    botaoSolSustenido.setLocation(40, 120);
	    botaoSolSustenido.addActionListener(evento);
	    add(botaoSolSustenido);
	    
	    notas = new JButton[]{ botaoLa, botaoDo, botaoRe, botaoMi, botaoFa, botaoSol };
	    notasSustenidas = new JButton[]{ botaoLaSustenido, botaoDoSustenido, botaoReSustenido, botaoMiSustenido, botaoFaSustenido, botaoSolSustenido };
	    
	    esconder(notasSustenidas);
	    
	    botaoOk = criarBotao("/assets/executar.jpg");
	    botaoOk.setLocation(80, 120);
	    add(botaoOk);
	}
	
	private void esconder(JButton[] botoes)
	{
		for(JButton botao : botoes)
		{
			botao.setVisible(false);
		}
	}
	
	private void mostra(JButton[] botoes)
	{
		for(JButton botao : botoes)
		{
			botao.setVisible(true);
		}
	}
	
	public JButton getBotaoLa() {
		return botaoLa;
	}

	public JButton getBotaoSi() {
		return botaoSi;
	}

	public JButton getBotaoDo() {
		return botaoDo;
	}

	public JButton getBotaoRe() {
		return botaoRe;
	}

	public JButton getBotaoMi() {
		return botaoMi;
	}

	public JButton getBotaoFa() {
		return botaoFa;
	}

	public JButton getBotaoPausa() {
		return botaoPausa;
	}

	public JButton getBotaoSol() {
		return botaoSol;
	}
	
	public JButton getBotaoOk() {
		return botaoOk;
	}

	public JButton getBotaoLaSustenido() {
		return botaoLaSustenido;
	}

	public JButton getBotaoDoSustenido() {
		return botaoDoSustenido;
	}

	public JButton getBotaoReSustenido() {
		return botaoReSustenido;
	}

	public JButton getBotaoMiSustenido() {
		return botaoMiSustenido;
	}

	public JButton getBotaoFaSustenido() {
		return botaoFaSustenido;
	}

	public JButton getBotaoSolSustenido() {
		return botaoSolSustenido;
	}

	public JButton[] getNotas() {
		return notas;
	}

	public JButton[] getNotasSustenidas() {
		return notasSustenidas;
	}

	private JButton criarBotao(String caminhoImagem)
	{
		return new BotaoFactory().criarBotao(caminhoImagem);
	}

}