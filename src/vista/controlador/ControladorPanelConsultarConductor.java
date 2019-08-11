package vista.controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import control.nucleo.ConductorNucleo;
import facade.Facade;
import modelo.vista.ConductorMV;
import vistas.conductor.PanelConsultaConductor;

public class ControladorPanelConsultarConductor {


	public void rellenarTablaConductor(PanelConsultaConductor panel, Facade facade) {
		String nombresColumnas[] = { "Nombre", "Dirección", "Telefono", "Habilidad", "Estado" };
		String[][] data = new String[facade.listadoIdConductores().size()][5];
		ArrayList<String> idConductor = new ArrayList<>(facade.listadoIdConductores());
		for (int i = 0; i < idConductor.size(); i++) {
			
			ConductorMV conductor = facade.obtenerConductor(idConductor.get(i));
			String nombre = conductor.getNombre();
			String direccion = conductor.getDireccion();

			String telefono = conductor.getTelefono();

			String habilidad = "";

			if (null != conductor.getHabilidad()) {
				habilidad = conductor.getHabilidad().toString();
			}
			String estado = "";

			if (null != conductor.getEstado()) {
				estado = conductor.getEstado().toString();
			}
			data[i][0] = nombre;
			data[i][1] = direccion;
			data[i][2] = telefono;
			data[i][3] = habilidad;
			data[i][4] = estado;

		}

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
		panel.getTable().setModel(defaultTableModel);

	}

}
