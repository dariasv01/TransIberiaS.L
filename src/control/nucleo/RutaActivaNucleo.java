package control.nucleo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.dao.RutasActivasDAO;
import modelo.dto.RutaActivaDTO;
import modelo.vista.RutaMV;
import utiles.EstadoCamion;
import utiles.EstadoConductor;
import utiles.EstadoRuta;
import utiles.Validator;

public class RutaActivaNucleo {
private RutasActivasDAO dao= new RutasActivasDAO();
	
	public RutaActivaNucleo() {
	}
	
	public boolean nuevaRuta(RutaMV ruta, LocalDateTime fecha) {
		RutaActivaDTO rutaDTO= new RutaActivaDTO();
		ConductorNucleo conductor =new ConductorNucleo();
		CamionNucleo camion =new CamionNucleo();
		rutaDTO.setMercancia(ruta.getMercancia());
		rutaDTO.setCamionId(ruta.getCamionId());
		rutaDTO.setFecha(fecha);
		rutaDTO.setKm(ruta.getKm());
		rutaDTO.setKmRecorrido(ruta.getKmRecorrido());
		rutaDTO.setConductorUno(ruta.getConductorUno());
		rutaDTO.setConductorDos(ruta.getConductorDos());
		rutaDTO.setFechaTurno(fecha);
		rutaDTO.setFechaDescanso(null);
		rutaDTO.setEstado((EstadoRuta) EstadoRuta.Ruta);
		rutaDTO.setKmRecorridoDescanso(0);
		Long IDruta =dao.obtenerId();
		rutaDTO.setID(IDruta);
		conductor.modificarConductor(ruta.getConductorUno().toString(), EstadoConductor.Ruta);
		if (rutaDTO.getConductorDos()!= null) {
			conductor.modificarConductor(ruta.getConductorDos().toString(), EstadoConductor.Descanso);			
		}
		camion.modificarCamion(ruta.getCamionId().toString(), EstadoCamion.Ruta);
		if (dao.guardar(rutaDTO)) {
			return  true;
		}
		return false;
		
	}
	
	public boolean modificarRuta(RutaMV ruta) {
		RutaActivaDTO rutaDTO= dao.consultar(ruta.getID());
		rutaDTO.setMercancia(ruta.getMercancia());
		rutaDTO.setCamionId(ruta.getCamionId());
		rutaDTO.setFecha(ruta.getFecha());
		rutaDTO.setKm(ruta.getKm());
		rutaDTO.setKmRecorrido(ruta.getKmRecorrido());
		rutaDTO.setConductorUno(ruta.getConductorUno());
		rutaDTO.setConductorDos(ruta.getConductorDos());
		rutaDTO.setEstado(ruta.getEstado());
		rutaDTO.setCambioTurno(ruta.isCambioTurno());
		rutaDTO.setFechaDescanso(ruta.getFechaDescanso());
		rutaDTO.setFechaTurno(ruta.getFechaTurno());
		rutaDTO.setKmRecorridoDescanso(ruta.getKmRecorridoDescanso());
		if (dao.modificar(rutaDTO)) {
			return  true; 
		}
		return false;
		
	}
	public boolean eliminarRuta(RutaMV ruta) {
		RutaActivaDTO rutaDTO= (RutaActivaDTO) dao.consultar(ruta.getID());
		return  dao.eliminar(rutaDTO);
	}
	
	public RutaMV obtenerRuta(String id) {
		RutaMV modelo=new RutaMV();
		RutaActivaDTO ruta=(RutaActivaDTO) dao.consultar(new Long(id));
		modelo.setID(ruta.getID());
		modelo.setKmRecorridoDescanso(ruta.getKmRecorridoDescanso());
		modelo.setCamionId(ruta.getCamionId());
		modelo.setConductorUno(ruta.getConductorUno());
		modelo.setConductorDos(ruta.getConductorDos());
		modelo.setFecha(ruta.getFecha());
		modelo.setKm(ruta.getKm());
		modelo.setKmRecorrido(ruta.getKmRecorrido());
		modelo.setMercancia(ruta.getMercancia());
		modelo.setEstado(ruta.getEstado());
		modelo.setFechaDescanso(ruta.getFechaDescanso());
		modelo.setFechaTurno(ruta.getFechaTurno());
		modelo.setCambioTurno(ruta.isCambioTurno());
		return modelo;
	}

	public ArrayList<String> listadoIdRuta() {
		return dao.obtenerTodosIds();
	}

}
