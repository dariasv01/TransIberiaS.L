package vista.controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import facade.Facade;
import modelo.vista.CamionMV;
import modelo.vista.ConductorMV;
import modelo.vista.RutaMV;
import vistas.ruta.PanelRutaActiva;

public class ControladorPanelRutasActivas {

	private Facade facade = new Facade();

	public void rellenarTablaRutasActivas(PanelRutaActiva panel) {
		String nombresColumnas[] = { "Mercancia", "Camión", "Fecha", "KM", "KM recorridos", "Estado", "Conductor" };
		String[][] data = new String[facade.listadoIdRutaActiva().size()][7];
		for (int i = 0; i < facade.listadoIdRutaActiva().size(); i++) {
			RutaMV ruta = facade.obtenerRutaActiva(toString().valueOf(i + 1));
			CamionMV camion = facade.obtenerCamion(ruta.getCamionId().toString());
			ConductorMV conductor = facade.obtenerConductor(ruta.getConductorUno().toString());
			String matricula = camion.getMatricula();
			String fecha = toString().valueOf(ruta.getFecha());
			String km = toString().valueOf(ruta.getKm());
			String kmRecorrido = toString().valueOf(ruta.getKmRecorrido());

			String conductorNombre = conductor.getNombre();

			String estado = "";

			if (null != ruta.getEstado()) {
				estado = ruta.getEstado().toString();
			}

			String mercancia = "";

			if (null != ruta.getMercancia()) {
				mercancia = ruta.getMercancia().toString();
			}

			data[i][0] = mercancia;
			data[i][1] = matricula;
			data[i][2] = fecha;
			data[i][3] = km;
			data[i][4] = kmRecorrido;
			data[i][5] = estado;
			data[i][6] = conductorNombre;

		}

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
		panel.getTable().setModel(defaultTableModel);

	}

}
