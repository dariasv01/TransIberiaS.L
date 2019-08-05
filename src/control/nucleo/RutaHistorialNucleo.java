package control.nucleo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.dao.RutasActivasDAO;
import modelo.dao.RutasDAO;
import modelo.dto.RutaActivaDTO;
import modelo.dto.RutaDTO;
import modelo.vista.RutaMV;
import utiles.EstadoCamion;
import utiles.EstadoConductor;
import utiles.EstadoRuta;
import utiles.Validator;

public class RutaHistorialNucleo {
	private RutasDAO dao = new RutasDAO();

	public RutaHistorialNucleo() {
	}

	public boolean nuevaRuta(RutaMV ruta) {
		RutaDTO rutaDTO = new RutaDTO();
		CamionNucleo camion = new CamionNucleo();
		rutaDTO.setMercancia(ruta.getMercancia());
		rutaDTO.setCamionId(ruta.getCamionId());
		rutaDTO.setFecha(ruta.getFecha());
		rutaDTO.setKm(ruta.getKm());
		Long IDruta = dao.obtenerId();
		rutaDTO.setID(IDruta);
		if (dao.guardar(rutaDTO)) {
			return true;
		}
		return false;

	}

	public RutaMV obtenerRuta(String id) {
		RutaMV modelo = new RutaMV();
		RutaDTO ruta = (RutaDTO) dao.consultar(new Long(id));
		modelo.setID(ruta.getID());
		modelo.setCamionId(ruta.getCamionId());
		modelo.setFecha(ruta.getFecha());
		modelo.setKm(ruta.getKm());
		modelo.setMercancia(ruta.getMercancia());
		return modelo;
	}

	public ArrayList<String> listadoIdRuta() {
		return dao.obtenerTodosIds();
	}
}
