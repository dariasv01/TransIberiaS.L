package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import control.logica.Control;
import facade.Facade;
import modelo.vista.CamionMV;
import modelo.vista.ConductorMV;
import modelo.vista.RutaMV;
import utiles.EstadoCamion;
import utiles.EstadoConductor;
import vistas.ruta.PanelRutaActiva;

public class ControladorPanelRutasActivas implements ActionListener {

	private Facade facade = new Facade();
	private Control control = new Control();
	private String[][] data;
	private String matricula,fecha,km,kmRecorrido,conductorNombre,estado,mercancia;
	private PanelRutaActiva panel;
	public void rellenarTablaRutasActivas(PanelRutaActiva panel) {
		String nombresColumnas[] = { "Mercancia", "Camión", "Fecha", "KM", "KM recorridos", "Estado", "Conductor" };
		data = new String[facade.listadoIdRutaActiva().size()][7];
		for (int i = 0; i < facade.listadoIdRutaActiva().size(); i++) {
			RutaMV ruta = facade.obtenerRutaActiva(toString().valueOf(i + 1));
			CamionMV camion = facade.obtenerCamion(ruta.getCamionId().toString());
			ConductorMV conductor = facade.obtenerConductor(ruta.getConductorUno().toString());
			matricula = camion.getMatricula();
			fecha = toString().valueOf(ruta.getFecha().toLocalDate());
			km = toString().valueOf(ruta.getKm());
			kmRecorrido = toString().valueOf(ruta.getKmRecorrido());

			conductorNombre = conductor.getNombre();

			estado = "";

			if (null != ruta.getEstado()) {
				estado = ruta.getEstado().toString();
			}

			mercancia = "";

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
		Timer tiempo = new Timer(1000, this);
		tiempo.start();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		ConductorMV conductorDos = null;
		for (int i = 0; i < facade.listadoIdRutaActiva().size(); i++) {
			RutaMV ruta = facade.obtenerRutaActiva(toString().valueOf(i + 1));
			CamionMV camion = facade.obtenerCamion(ruta.getCamionId().toString());
			ConductorMV conductor = facade.obtenerConductor(ruta.getConductorUno().toString());
			if (null != ruta.getConductorDos()) {
				conductorDos = facade.obtenerConductor(ruta.getConductorDos().toString());
			}
			ruta.setKmRecorrido(control.recorrerDistancia(ruta.getFecha()));
			kmRecorrido = toString().valueOf(control.recorrerDistancia(ruta.getFecha()));
			facade.modificarRuta(ruta);
			data[i][4] = kmRecorrido;
			if (control.rutaFinalizada(ruta.getKm(), ruta.getKmRecorrido())) {
				facade.guardarRutaHistorial(ruta);
				facade.eliminarRutaActiva(ruta);
				facade.modificarCamion(camion.getID(), EstadoCamion.Garaje);
				facade.modificarConductor(conductor.getID(), EstadoConductor.Parado);
				if (null != ruta.getConductorDos()) {
					facade.modificarConductor(conductorDos.getID(), EstadoConductor.Parado);
				}
				
			}
		}
	}

}
