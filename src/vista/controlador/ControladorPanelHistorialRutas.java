package vista.controlador;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;

import facade.Facade;
import modelo.vista.CamionMV;
import modelo.vista.RutaMV;
import vistas.ruta.PanelHistorialRuta;

public class ControladorPanelHistorialRutas {


	public void rellenarTablaHistorialRutas(PanelHistorialRuta panel, Facade facade) {
		String nombresColumnas[] = { "Mercancia", "Camión", "Fecha", "KM" };
		String[][] data = new String[facade.listadoIdRutaHistorial().size()][4];
		for (int i = 0; i < facade.listadoIdRutaHistorial().size(); i++) {
			RutaMV ruta = facade.obtenerRutaHistorial(toString().valueOf(i + 1));
			CamionMV camion = facade.obtenerCamion(ruta.getCamionId().toString());
			String matricula = camion.getMatricula();
			String fecha = toString().valueOf(ruta.getFecha());
			String km = toString().valueOf(ruta.getKm());

			String mercancia = "";

			if (null != ruta.getMercancia()) {
				mercancia = ruta.getMercancia().toString();
			}

			data[i][0] = mercancia;
			data[i][1] = matricula;
			data[i][2] = fecha;
			data[i][3] = km;

		}

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
		panel.getTable().setModel(defaultTableModel);

	}

}
