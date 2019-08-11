package vista.controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import facade.Facade;
import modelo.vista.CamionMV;
import vistas.camion.PanelConsultaCamion;

public class ControladorPanelConsultarCamion {


	public void rellenarTablaCamion(PanelConsultaCamion panel, Facade facade) {
		String nombresColumnas[] = { "Matricula", "Marca", "Potncia", "Estado" };
		String[][] data = new String[facade.listadoIdCamiones().size()][4];
		for (int i = 0; i < facade.listadoIdCamiones().size(); i++) {
			CamionMV camion = facade.obtenerCamion(toString().valueOf(i + 1));
			String matricula = camion.getMatricula();
			String marca = "";
			if (null != camion.getMarca()) {
				marca = camion.getMarca().toString();
			}
			String potencia = camion.getPotencia();

			String estado = "";
			
			if (null != camion.getEstado()) {
				estado = camion.getEstado().toString();
			}
			
			data[i][0] = matricula;
			data[i][1] = marca;
			data[i][2] = potencia;
			data[i][3] = estado;

		}

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
		panel.getTable().setModel(defaultTableModel);

	}

}
