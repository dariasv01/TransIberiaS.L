package listener.ComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import control.logica.Item;
import facade.Facade;
import utiles.Mercancia;
import vista.controlador.ControladorPanelRuta;
import vistas.comunes.PanelRuta;

public class ActionComboMercancias implements FocusListener, ActionListener {

	private JComboBox mercancia, conductorUno, conductorCinco;
	private Facade facade;
	private PanelRuta panel;
	private ControladorPanelRuta controlador;
	private JCheckBox chUno, chDos;

	public ActionComboMercancias(JComboBox mercancia, JComboBox conductorUno, JComboBox conductorCinco, JCheckBox chUno,
			JCheckBox chDos, Facade facade, ControladorPanelRuta controlador, PanelRuta panel) {
		this.mercancia = mercancia;
		this.conductorUno = conductorUno;
		this.conductorCinco = conductorCinco;
		this.chUno = chUno;
		this.chDos = chDos;
		this.facade = facade;
		this.panel = panel;
		this.controlador = controlador;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JComboBox combo = (JComboBox) arg0.getSource();
		if (null != combo.getSelectedItem() && mercancia.getItemCount() > 0) {
			switch (mercancia.getSelectedIndex()) {
			case 1:
				HashMap<Long, String> mapa = facade.obtnerMapaFragil();
				conductorUno.removeAllItems();
				conductorCinco.removeAllItems();
				for (Map.Entry<Long, String> entry : mapa.entrySet()) {
					conductorUno.addItem(new Item(entry.getKey(), entry.getValue()));
					conductorCinco.addItem(new Item(entry.getKey(), entry.getValue()));
				}
				if (mapa.size() == 1) {
					conductorCinco.setEnabled(false);
					chUno.setSelected(true);
					chDos.setSelected(false);
					chDos.setEnabled(false);
					conductorCinco.removeAllItems();
				} else {
					chDos.setEnabled(true);
				}
				break;
			case 2:
				HashMap<Long, String> mapaDos = facade.obtnerMapaInflamable();
				conductorUno.removeAllItems();
				conductorCinco.removeAllItems();
				for (Map.Entry<Long, String> entryDos : mapaDos.entrySet()) {
					conductorUno.addItem(new Item(entryDos.getKey(), entryDos.getValue()));
					conductorCinco.addItem(new Item(entryDos.getKey(), entryDos.getValue()));
				}
				if (mapaDos.size() == 1) {
					conductorCinco.setEnabled(false);
					chUno.setSelected(true);
					chDos.setSelected(false);
					chDos.setEnabled(false);
					conductorCinco.removeAllItems();
				} else {
					chDos.setEnabled(true);
				}
				
				break;
			case 3:
				HashMap<Long, String> mapaTres = facade.obtnerMapaPesada();
				conductorUno.removeAllItems();
				conductorCinco.removeAllItems();
				for (Map.Entry<Long, String> entryTres : mapaTres.entrySet()) {
					conductorUno.addItem(new Item(entryTres.getKey(), entryTres.getValue()));
					conductorCinco.addItem(new Item(entryTres.getKey(), entryTres.getValue()));
				}
				if (mapaTres.size() == 1) {
					conductorCinco.setEnabled(false);
					chUno.setSelected(true);
					chDos.setSelected(false);
					chDos.setEnabled(false);
					conductorCinco.removeAllItems();
				} else {
					chDos.setEnabled(true);
				}
				break;
			case 4:
				HashMap<Long, String> mapaCuatro = facade.obtnerMapaComun();
				conductorUno.removeAllItems();
				conductorCinco.removeAllItems();
				for (Map.Entry<Long, String> entryCuatro : mapaCuatro.entrySet()) {
					conductorUno.addItem(new Item(entryCuatro.getKey(), entryCuatro.getValue()));
					conductorCinco.addItem(new Item(entryCuatro.getKey(), entryCuatro.getValue()));
				}
				if (mapaCuatro.size() == 1) {
					conductorCinco.setEnabled(false);
					chUno.setSelected(true);
					chDos.setSelected(false);
					chDos.setEnabled(false);
					conductorCinco.removeAllItems();
				} else {
					chDos.setEnabled(true);
				}
				break;
			default:
				break;
			}

		}
	}

}
