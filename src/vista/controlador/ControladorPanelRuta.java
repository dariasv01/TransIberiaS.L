package vista.controlador;

import java.awt.event.FocusListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import control.logica.Item;
import modelo.dto.ConductorDTO;
import modelo.vista.CamionMV;
import modelo.vista.RutaMV;
import utiles.EstadoRuta;
import utiles.Mercancia;
import vistas.comunes.PanelRuta;

public class ControladorPanelRuta {

	public RutaMV obtenerDatos(PanelRuta panel) {
		RutaMV modelo = new RutaMV();
		modelo.setEstado((EstadoRuta) EstadoRuta.Ruta);

		modelo.setKm(Long.parseLong(panel.getTxtDistancia().getText()));

		modelo.setKmRecorrido(0);

		if (panel.getComboMercancia() != null && panel.getComboMercancia().getSelectedIndex()>0) {
			modelo.setMercancia((Mercancia) panel.getComboMercancia().getSelectedItem());
		}
		if (panel.getComboCamion() != null) {
			Item item= (Item) panel.getComboCamion().getSelectedItem();
			modelo.setCamionId((long) item.getId());
		}
		if (panel.getComboConductorUno() != null) {
			Item item= (Item) panel.getComboConductorUno().getSelectedItem();
			modelo.setConductorUno((long) item.getId());
		}
		if (panel.getComboConductorCinco() != null && panel.getChBoxDos().isSelected()==true) {
			Item item= (Item) panel.getComboConductorCinco().getSelectedItem();
			modelo.setConductorDos((long) item.getId());
		}
		return modelo;
	}

	public void vaciarDatos(PanelRuta panel) {
		panel.getTxtDistancia().setText("");
		panel.getComboMercancia().setSelectedIndex(0);
		panel.getComboConductorUno().removeAllItems();
		panel.getComboConductorCinco().removeAllItems();
		panel.getComboCamion().removeAllItems();
	}
}
