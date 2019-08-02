package vista.controlador;

import modelo.dto.CamionDTO;
import modelo.dto.ConductorDTO;
import modelo.vista.RutaMV;
import utiles.EstadoConductor;
import utiles.EstadoRuta;
import utiles.Habilidad;
import utiles.Mercancia;
import vistas.comunes.PanelRuta;

public class ControladorPanelRuta {
//	public void rellenarDatos(PanelRuta panel, RutaMV ruta) {
//		panel.txtID.setText(String.valueOf(persona.getID()));
//		panel.txtNombre.setText(persona.getNombre());
//		panel.txtDireccion.setText(persona.getDireccion());
//		panel.textTelefono.setText(persona.getTelefono());
//		if (persona.getHabilidad() != null && panel.getTxtEspecialidad() != null) {
//			panel.getTxtEspecialidad().setText(persona.getHabilidad().toString());
//		}
//
//	}

	public RutaMV obtenerDatos(PanelRuta panel) {
		RutaMV modelo = new RutaMV();
		
		modelo.setEstado((EstadoRuta) EstadoRuta.Ruta);
		
		modelo.setFecha(null);
		
		modelo.setKm(Long.parseLong(panel.getTxtDistancia().getText()));
		
		modelo.setKmRecorrido(0);
		
		if (panel.getComboMercancia() != null) {
			modelo.setMercancia((Mercancia) panel.getComboMercancia().getSelectedItem());
		}
		if (panel.getComboCamion() != null) {
			modelo.setCamion((CamionDTO)panel.getComboCamion().getSelectedItem());
		}
		if (panel.getComboConductorUno() != null) {
			modelo.setConductorUno((ConductorDTO)panel.getComboConductorUno().getSelectedItem());
		}
		if (panel.getComboConductorDos() != null) {
			modelo.setConductorDos((ConductorDTO)panel.getComboConductorDos().getSelectedItem());
		}
		return modelo;
	}

	public void vaciarDatos(PanelRuta panel) {
		panel.getTxtDistancia().setText("");
	}
}
