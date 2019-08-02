package facade;

import java.util.ArrayList;
import java.util.HashMap;

import control.nucleo.CamionNucleo;
import control.nucleo.ConductorNucleo;
import control.nucleo.RutaNucleo;
import modelo.dto.RutaActivaDTO;
import modelo.vista.CamionMV;
import modelo.vista.ConductorMV;
import modelo.vista.RutaMV;

public class Facade {

	private ConductorNucleo conductorNucleo= new ConductorNucleo();
	private CamionNucleo camionNucleo=new CamionNucleo();
	private RutaNucleo rutaNucleo=new RutaNucleo();
	
//CONDUCTOR
	
	public boolean guardarConductor(ConductorMV conductorMV) {
		return conductorNucleo.altaConductor(conductorMV);
	}

	public ConductorMV conductorConductor(String id) {
		return conductorNucleo.obtenerConductor(id);
	}
	
	public ArrayList<String> listadoIdConductores(){
		return conductorNucleo.listadoIdConductores();
	}
	
	public boolean darBajaConductor(ConductorMV conductorMV) {
		return conductorNucleo.bajaConductor(conductorMV);
	}
//
//	public boolean modificarPaciente(PersonaMV obtenerDatos) {
//		return pacienteNucleo.modificarPaciente(obtenerDatos);
//	}
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
	
	public ArrayList<String> listadoIdCamiones(){
		return camionNucleo.listadoIdCamiones();
	}
	
	public boolean venderCamion(CamionMV camion) {
		return camionNucleo.venderCamion(camion);
	}

	public HashMap<Long, String> obtnerMapaConductor() {
		return conductorNucleo.obtenerMapaIDNombre();
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
	
	public boolean guardarRuta(RutaMV rutaMV) {
		return rutaNucleo.nuevaRuta(rutaMV);
	}

//	public ArrayList<RutaMV> obtenerCita(String idPcaciente) {
//		return rutaNucleo.obtenerCita(idPcaciente);
//	}


}

