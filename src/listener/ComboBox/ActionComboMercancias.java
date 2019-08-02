package listener.ComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;

import control.logica.Item;
import facade.Facade;
import utiles.Mercancia;
import vista.controlador.ControladorPanelRuta;
import vistas.comunes.PanelRuta;

public class ActionComboMercancias implements FocusListener, ActionListener {

	private JComboBox mercancia, conductorUno, conductorDos, camion;
	private Facade facade;
	private PanelRuta panel;
	private ControladorPanelRuta controlador;

	public ActionComboMercancias(JComboBox mercancia,JComboBox conductorUno, JComboBox conductorDos, JComboBox camion, Facade facade,
			ControladorPanelRuta controlador, PanelRuta panel) {
		this.mercancia = mercancia;
		this.conductorUno = conductorUno;
		this.conductorDos = conductorDos;
		this.camion = camion;
		this.facade = facade;
		this.panel = panel;
		this.controlador = controlador;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
	
		for (Mercancia d : Mercancia.values()) {
			mercancia.addItem(d.toString());
		}
		
//		HashMap<Long, String> mapa = facade.obtnerMapaEnGaraje();
//		for (Map.Entry<Long, String> entry : mapa.entrySet()) {
//			camion.addItem(new Item(entry.getKey(), String.valueOf(entry.getKey())));
//		}
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
//		JComboBox combo=(JComboBox)arg0.getSource();
//		if(null!=combo.getSelectedItem()) {
//		Item item= (Item) combo.getSelectedItem();
//		for (Mercancia d : Mercancia.values()) {
//			mercancia.addItem(d.toString());
//		}
//		for (Mercancia d : Mercancia.values()) {
//			mercancia.addItem(d.toString());
//		}
//		}
	}

}
