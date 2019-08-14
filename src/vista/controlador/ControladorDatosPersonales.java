package vista.controlador;

import modelo.vista.ConductorMV;
import utiles.Habilidad;
import vistas.comunes.PanelDatosPersonales;

public class ControladorDatosPersonales {
	public void rellenarDatos(PanelDatosPersonales panel, ConductorMV persona) {
		panel.txtID.setText(String.valueOf(persona.getID()));
		panel.txtNombre.setText(persona.getNombre());
		panel.txtDireccion.setText(persona.getDireccion());
		panel.textTelefono.setText(persona.getTelefono());
		panel.txtHabilidad.setText(persona.getHabilidad().toString());
		if (persona.getHabilidad() != null && panel.getTxtEspecialidad() != null) {
			panel.getTxtEspecialidad().setText(persona.getHabilidad().toString());
		}

	}

	public ConductorMV obtenerDatos(PanelDatosPersonales panel) {
		ConductorMV modelo = new ConductorMV();
		if (!panel.txtID.getText().isEmpty()) {
			modelo.setID(new Long(panel.txtID.getText()));
		}
		modelo.setNombre(panel.txtNombre.getText()+" "+panel.txtaApellido.getText());
		modelo.setDireccion(panel.txtDireccion.getText());
		modelo.setTelefono(panel.textTelefono.getText());
		if (panel.getEspecialidad() != null && panel.getEspecialidad().getSelectedIndex()>0) {
			modelo.setHabilidad((Habilidad) panel.getEspecialidad().getSelectedItem());
		}
		return modelo;
	}

	public void vaciarDatos(PanelDatosPersonales panel) {
		panel.txtNombre.setText("");
		panel.txtaApellido.setText("");
		panel.txtDireccion.setText("");
		panel.textTelefono.setText("");
	}
}
