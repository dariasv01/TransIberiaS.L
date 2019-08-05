package facade;

import java.util.ArrayList;
import java.util.HashMap;

import control.nucleo.CamionNucleo;
import control.nucleo.ConductorNucleo;
import control.nucleo.RutaActivaNucleo;
import control.nucleo.RutaHistorialNucleo;
import modelo.dto.RutaActivaDTO;
import modelo.vista.CamionMV;
import modelo.vista.ConductorMV;
import modelo.vista.RutaMV;

public class Facade {

	private ConductorNucleo conductorNucleo = new ConductorNucleo();
	private CamionNucleo camionNucleo = new CamionNucleo();
	private RutaActivaNucleo rutaActivaNucleo = new RutaActivaNucleo();
	private RutaHistorialNucleo rutaHistorialNucleo = new RutaHistorialNucleo();

//CONDUCTOR

	public boolean guardarConductor(ConductorMV conductorMV) {
		return conductorNucleo.altaConductor(conductorMV);
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

	public boolean guardarRuta(RutaMV rutaMV) {
		return rutaActivaNucleo.nuevaRuta(rutaMV);
	}

	public RutaMV obtenerRutaActiva(String id) {
		return rutaActivaNucleo.obtenerRuta(id);
	}

	public RutaMV obtenerRutaHistorial(String id) {
		return rutaHistorialNucleo.obtenerRuta(id);
	}

	public ArrayList<String> listadoIdRutaHistorial() {
		return rutaHistorialNucleo.listadoIdRuta();
	}

	public ArrayList<String> listadoIdRutaActiva() {
		return rutaActivaNucleo.listadoIdRuta();
	}
}
