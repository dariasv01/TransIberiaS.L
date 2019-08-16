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

	private JComboBox mercancia, conductorUno, conductorCinco, camion;
	private Facade facade;
	private PanelRuta panel;
	private ControladorPanelRuta controlador;
	private JCheckBox chUno, chDos;

	public ActionComboMercancias(JComboBox mercancia, JComboBox conductorUno, JComboBox conductorCinco, JCheckBox chUno,
			JCheckBox chDos, JComboBox camion, Facade facade, ControladorPanelRuta controlador, PanelRuta panel) {
		this.mercancia = mercancia;
		this.conductorUno = conductorUno;
		this.conductorCinco = conductorCinco;
		this.chUno = chUno;
		this.chDos = chDos;
		this.facade = facade;
		this.panel = panel;
		this.controlador = controlador;
		this.camion = camion;
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
				selecionMercancia(mapa);
				break;
			case 2:
				HashMap<Long, String> mapaDos = facade.obtnerMapaInflamable();
				selecionMercancia(mapaDos);
				
				break;
			case 3:
				HashMap<Long, String> mapaTres = facade.obtnerMapaPesada();
				selecionMercancia(mapaTres);
				break;
			case 4:
				HashMap<Long, String> mapaCuatro = facade.obtnerMapaComun();
				selecionMercancia(mapaCuatro);
				break;
			default:
				break;
			}
		}
		comboCamion();
	}

	private void comboCamion() {
		camion.removeAllItems();
		HashMap<Long, String> mapa = facade.obtnerMapaEnGaraje();
		for (Map.Entry<Long, String> entry : mapa.entrySet()) {
			camion.addItem(new Item(entry.getKey(), entry.getValue()));
		}
	}

	private void selecionMercancia(HashMap<Long, String> mapa) {
		conductorUno.removeAllItems();
		conductorCinco.removeAllItems();
		rellenarComboConductor(mapa);
		controladorComboConductor(mapa);
	}

	private void controladorComboConductor(HashMap<Long, String> mapa) {
		if (mapa.size() == 1) {
			conductorCinco.setEnabled(false);
			chUno.setSelected(true);
			chDos.setSelected(false);
			chDos.setEnabled(false);
			conductorCinco.removeAllItems();
		} else {
			chDos.setEnabled(true);
		}
	}

	private void rellenarComboConductor(HashMap<Long, String> mapa) {
		for (Map.Entry<Long, String> entry : mapa.entrySet()) {
			conductorUno.addItem(new Item(entry.getKey(), entry.getValue()));
			conductorCinco.addItem(new Item(entry.getKey(), entry.getValue()));
		}
	}

}
