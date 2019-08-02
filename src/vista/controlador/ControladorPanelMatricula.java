package vista.controlador;

import modelo.vista.CamionMV;
import utiles.Marca;
import vistas.comunes.PanelMatricula;

public class ControladorPanelMatricula {

	public void rellenarDatos(PanelMatricula panel, CamionMV camion) {
		panel.txtMatricula.setText(camion.getMatricula());
		if (camion.getMarca() != null && panel.getTxtMarca() != null) {
			panel.getTxtMarca().setText(camion.getMarca().toString());
		}
		panel.txtPotencia.setText(camion.getPotencia());
		panel.txtID.setText(camion.getID().toString());
	}

	public CamionMV obtenerDatos(PanelMatricula panel) {
		CamionMV modelo = new CamionMV();
		modelo.setMatricula(panel.txtMatricula.getText());
		if (!panel.txtID.getText().isEmpty()) {
			modelo.setID(new Long(panel.txtID.getText()));
		}
		if (panel.getEspecialidad() != null) {
			modelo.setMarca((Marca) panel.getEspecialidad().getSelectedItem());
		}
		modelo.setPotencia(panel.txtPotencia.getText());
		return modelo;
	}

	public void vaciarDatos(PanelMatricula panel) {
		panel.txtMatricula.setText("");
		panel.txtMarca.setText("");
		panel.txtPotencia.setText("");
	}

}
