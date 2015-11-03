package br.unisc.robokit.displays;

import javax.swing.JPanel;

import br.unisc.robokit.ComandoRobokit;
import br.unisc.robokit.eventos.ExecucaoComandoEvento;
import br.unisc.robokit.eventos.ExecucaoComandoListener;

public abstract class Display extends JPanel
{

	private static final long serialVersionUID = 2808923620823953844L;

	public abstract void ativar(ComandoRobokit comando);
	public abstract void parar();
	
	private javax.swing.event.EventListenerList listenerList = new javax.swing.event.EventListenerList();
	
	 public void addExecucaoComandoListener(ExecucaoComandoListener listener) 
	 { 
		 listenerList.add(ExecucaoComandoListener.class, listener);
	 }

	 public void removeExecucaoComandoListener(ExecucaoComandoListener listener) 
	 {
		 listenerList.remove(ExecucaoComandoListener.class, listener);
	 }

	 protected void avisarQueParou() 
	 {
		 ExecucaoComandoEvento evt = new ExecucaoComandoEvento(this);
		 
		 Object[] listeners = listenerList.getListenerList();
	     for (int i=0; i<listeners.length; i+=2) 
	     {
	    	 if (listeners[i]==ExecucaoComandoListener.class) 
	    	 {
	                ((ExecucaoComandoListener)listeners[i+1]).comandoTerminouExecucao(evt);
	         }
	     }
	 }
	    
}