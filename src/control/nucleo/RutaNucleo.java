package control.nucleo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.dao.RutasActivasDAO;
import modelo.dto.RutaActivaDTO;
import modelo.vista.RutaMV;
import utiles.EstadoConductor;
import utiles.EstadoRuta;
import utiles.Validator;

public class RutaNucleo {
private RutasActivasDAO dao= new RutasActivasDAO();
	
	public RutaNucleo() {
	}
	
	public boolean nuevaRuta(RutaMV ruta) {
		RutaActivaDTO rutaDTO= new RutaActivaDTO();
		rutaDTO.setMercancia(ruta.getMercancia());
		rutaDTO.setCamion(ruta.getCamion());
		rutaDTO.setFecha(ruta.getFecha());
		rutaDTO.setKm(ruta.getKm());
		rutaDTO.setKmRecorrido(ruta.getKmRecorrido());
		rutaDTO.setConductorUno(ruta.getConductorUno());
		rutaDTO.setConductorDos(ruta.getConductorDos());
		rutaDTO.setEstado((EstadoRuta) EstadoRuta.Ruta);
		Long IDconductor =dao.obtenerId();
		rutaDTO.setID(IDconductor);
		if (dao.guardar(rutaDTO)) {
			return  true;
		}
		return false;
		
	}
	
//	public boolean modificarConductor(ConductorMV conductor) {
//		ConductorDTO conductorDTO= dao.consultar(conductor.getID());
//		conductorDTO.setNombre(conductor.getNombre());
//		conductorDTO.setDireccion(conductor.getDireccion());
//		conductorDTO.setTelefono(conductor.getTelefono());
//		if (validacionConductor(conductor)) {
//			return  dao.modificar(conductorDTO); 
//		}
//		return false;
//		
//	}
//	public boolean bajaConductor(RutaMV ruta) {
//		RutaActivaDTO rutaDTO= (RutaActivaDTO) dao.consultar(ruta.getID());
//		return  dao.eliminar(rutaDTO);
//	}
	
//	public RutaMV obtenerRuta(String id) {
//		RutaMV modelo=new RutaMV();
//		RutaActivaDTO ruta=(RutaActivaDTO) dao.consultar(new Long(id));
//		
//		modelo.setID(ruta.getID());
//		modelo.setNombre(ruta.getNombre());
//		modelo.setDireccion(ruta.getDireccion());
//		modelo.setTelefono(ruta.getTelefono());
//		modelo.setHabilidad(ruta.getHabilidad());
//		modelo.setEstado(ruta.getEstado());
//		return modelo;
//	}
//
//	public ArrayList<String> listadoIdRuta() {
//		return dao.obtenerTodosIds();
//	}
}
