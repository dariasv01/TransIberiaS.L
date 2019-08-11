package vista.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
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
import utiles.EstadoRuta;
import vistas.ruta.PanelRutaActiva;

public class ControladorPanelRutasActivas {

	private String[][] data;
	private String matricula, fecha, km, kmRecorrido, conductorNombre, estado, mercancia;
	private Control control = new Control();

	public void rellenarTablaRutasActivas(PanelRutaActiva panel, Facade facade) {
		String nombresColumnas[] = { "Mercancia", "Camión", "Fecha", "KM", "KM recorridos", "Estado", "Conductor" };
		data = new String[facade.listadoIdRutaActiva().size()][7];
		ArrayList<String> idRuta = new ArrayList<>(facade.listadoIdRutaActiva());
		for (int i = 0; i < idRuta.size(); i++) {
			RutaMV ruta = facade.obtenerRutaActiva(idRuta.get(i));
			CamionMV camion = facade.obtenerCamion(ruta.getCamionId().toString());
			ConductorMV conductor = facade.obtenerConductor(ruta.getConductorUno().toString());
			ConductorMV conductorDos = null;
			if (null != ruta.getConductorDos()) {
				conductorDos = facade.obtenerConductor(ruta.getConductorDos().toString());
			}
			matricula = camion.getMatricula();
			fecha = toString().valueOf(ruta.getFecha().toLocalDate());
			km = toString().valueOf(ruta.getKm());

			if (ruta.isCambioTurno() == false || null != ruta.getConductorDos()) {
				if (ruta.getFechaDescanso() != null) {
					ruta.setKmRecorrido(ruta.getKmRecorridoDescanso()+control.recorrerDistancia(ruta.getFechaDescanso()));
				} else {
					ruta.setKmRecorrido(control.recorrerDistancia(ruta.getFecha()));
				}
			}
			facade.modificarRuta(ruta);
			kmRecorrido = toString().valueOf(ruta.getKmRecorrido());

			if (ruta.isCambioTurno() && null != ruta.getConductorDos()) {
				conductorNombre = conductorDos.getNombre();
			} else {
				conductorNombre = conductor.getNombre();
			}

			if (null != ruta.getEstado()) {
				estado = ruta.getEstado().toString();
			}

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

			if (control.cambioConductorDosOdescansar(ruta.getFechaTurno()) && ruta.isCambioTurno() == false) {
				if (null != ruta.getConductorDos()) {
					facade.modificarConductor(conductorDos.getID(), EstadoConductor.Ruta);
				} else {
					ruta.setEstado(EstadoRuta.Parada);
					facade.modificarCamion(camion.getID(), EstadoCamion.Parado);
					facade.modificarConductor(conductor.getID(), EstadoConductor.Descanso);
				}
				if (null != ruta.getConductorDos()) {
					conductorNombre = conductorDos.getNombre();
				}
				ruta.setCambioTurno(true);
			}

			if (control.cambioConductorUno(ruta.getFechaTurno()) && ruta.isCambioTurno()) {
				if (null != ruta.getConductorDos()) {
					facade.modificarConductor(conductorDos.getID(), EstadoConductor.Ruta);
				} else {
					facade.modificarConductor(conductor.getID(), EstadoConductor.Descanso);
					ruta.setEstado(EstadoRuta.Ruta);
					ruta.setFechaDescanso(facade.obtenerHoraAplicacion());
					ruta.setKmRecorridoDescanso(ruta.getKmRecorrido());
				}
				ruta.setCambioTurno(false);
				ruta.setFechaTurno(facade.obtenerHoraAplicacion());
			}
			facade.modificarRuta(ruta);
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

		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
		panel.getTable().setModel(defaultTableModel);
	}
}
