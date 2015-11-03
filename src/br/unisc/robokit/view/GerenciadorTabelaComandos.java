package br.unisc.robokit.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.unisc.robokit.ComandoRobokit;

public class GerenciadorTabelaComandos extends AbstractTableModel 
{

	private static final long serialVersionUID = 7238716733286975432L;
	
	private List<ComandoRobokit> linhas = new ArrayList<ComandoRobokit>();  
    private String [] colunas;
    
    public GerenciadorTabelaComandos()
    {
    	colunas = new String[]{"Nº", "Comando", ""};
    }
    
    public void incluir(ComandoRobokit comando)
    {
    	linhas.add(comando);
    	int linha = getLinhas().size()-1;  
        fireTableRowsInserted(linha,linha); 
    }
    
	public List<ComandoRobokit> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<ComandoRobokit> linhas) {
		this.linhas = linhas;
	}

	public String[] getColunas() {
		return colunas;
	}

	@Override
	public int getColumnCount() {
		return getColunas().length;
	}

	@Override
	public int getRowCount() {
		return getLinhas().size();
	}

	@Override
	public Object getValueAt(int indiceLinha, int indiceColuna) 
	{
		ComandoRobokit comando = (ComandoRobokit) linhas.get(indiceLinha);
		
	      switch (indiceColuna) 
	      {  
		      case 0:   
		         return indiceLinha + 1;  
		      case 1:   
		         return comando.descricao();  
		      default:   
		         return null;
	      }
	}

	public void removerTodos() 
	{
		for(int i = 0; i < linhas.size(); i++)
		{
			fireTableRowsDeleted(i, i);
		}
		
		linhas = new ArrayList<ComandoRobokit>();
	}

}