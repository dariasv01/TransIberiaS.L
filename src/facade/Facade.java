package facade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import control.nucleo.CamionNucleo;
import control.nucleo.ConductorNucleo;
import control.nucleo.HoraNucleo;
import control.nucleo.RutaActivaNucleo;
import control.nucleo.RutaHistorialNucleo;
import modelo.dto.RutaActivaDTO;
import modelo.vista.CamionMV;
import modelo.vista.ConductorMV;
import modelo.vista.RutaMV;
import utiles.EstadoCamion;
import utiles.EstadoConductor;

public class Facade {

	private ConductorNucleo conductorNucleo = new ConductorNucleo();
	private CamionNucleo camionNucleo = new CamionNucleo();
	private RutaActivaNucleo rutaActivaNucleo = new RutaActivaNucleo();
	private RutaHistorialNucleo rutaHistorialNucleo = new RutaHistorialNucleo();
	private HoraNucleo hora = new HoraNucleo();

//CONDUCTOR

	public boolean guardarConductor(ConductorMV conductorMV) {
		return conductorNucleo.altaConductor(conductorMV);
	}
	
	public boolean modificarConductor(Long id, EstadoConductor estado) {
		return conductorNucleo.modificarConductor(id.toString(), estado);
	}

	public ConductorMV conductorConductor(String id) {
		return conductorNucleo.obtenerConductor(id);
	}

	public ArrayList<String> listadoIdConductores() {
		return conductorNucleo.listadoIdConductores();
	}

	public boolean darBajaConductor(ConductorMV conductorMV) {
		return conductorNucleo.bajaConductor(conductorMV);
	}

	public HashMap<Long, String> obtnerMapaConductor() {
		return conductorNucleo.obtenerMapaIDNombre();
	}

	public HashMap<Long, String> obtnerMapaFragil() {
		return conductorNucleo.obtenerMapaIDFragil();
	}

	public HashMap<Long, String> obtnerMapaInflamable() {
		return conductorNucleo.obtenerMapaIDInflamable();
	}

	public HashMap<Long, String> obtnerMapaPesada() {
		return conductorNucleo.obtenerMapaIDPesada();
	}

	public HashMap<Long, String> obtnerMapaComun() {
		return conductorNucleo.obtenerMapaIDComun();
	}

//CAMION
	public boolean guardarCamion(CamionMV camion) {
		return camionNucleo.ComprarCamion(camion);
	}
	
	public boolean modificarCamion(Long id, EstadoCamion estado) {
		return camionNucleo.modificarCamion(id.toString(), estado);
	}


	public CamionMV obtenerCamion(String id) {
		return camionNucleo.obtenerCamion(id);
	}

	public ConductorMV obtenerConductor(String id) {
		return conductorNucleo.obtenerConductor(id);
	}

	public ArrayList<String> listadoIdCamiones() {
		return camionNucleo.listadoIdCamiones();
	}

	public boolean venderCamion(CamionMV camion) {
		return camionNucleo.venderCamion(camion);
	}

	public HashMap<Long, String> obtnerMapaCamion() {
		return camionNucleo.obtenerMapaIDNombre();
	}

	public HashMap<Long, String> obtnerMapaEnGaraje() {
		return camionNucleo.obtenerMapaIDEnGaraje();
	}

	public HashMap<Long, String> obtnerMapaEnRuta() {
		return camionNucleo.obtenerMapaIDEnRuta();
	}

//RUTA

	public boolean guardarRuta(RutaMV rutaMV ,LocalDateTime fecha) {
		return rutaActivaNucleo.nuevaRuta(rutaMV,fecha);
	}
	
	public boolean guardarRutaHistorial(RutaMV rutaMV) {
		return rutaHistorialNucleo.nuevaRuta(rutaMV);
	}

	public RutaMV obtenerRutaActiva(String id) {
		return rutaActivaNucleo.obtenerRuta(id);
	}
	
	public boolean modificarRuta(RutaMV rutaMV) {
		return rutaActivaNucleo.modificarConductor(rutaMV);
	}

	public RutaMV obtenerRutaHistorial(String id) {
		return rutaHistorialNucleo.obtenerRuta(id);
	}
	
	public boolean eliminarRutaActiva(RutaMV rutaMV) {
		return rutaActivaNucleo.eliminarRuta(rutaMV);
	}

	public ArrayList<String> listadoIdRutaHistorial() {
		return rutaHistorialNucleo.listadoIdRuta();
	}

	public ArrayList<String> listadoIdRutaActiva() {
		return rutaActivaNucleo.listadoIdRuta();
	}

//HORA

	public boolean guardarHoraAplicacion(LocalDateTime fecha) {
		return hora.guardarHoraAplicacion(fecha);
	}

	public boolean modificarHoraAplicacion(LocalDateTime fecha) {
		return hora.modificarHoraAplicacion(fecha);
	}

	public LocalDateTime obtenerHoraAplicacion() {
		return hora.obtenerHoraAplicacionGuardada();
	}

	public LocalDateTime obtenerHoraSistema() {
		return hora.obtenerHoraSistemaGuardada();
	}
	public ArrayList<String> optenerListaHora() {
		return hora.listadoId();
	}
}
