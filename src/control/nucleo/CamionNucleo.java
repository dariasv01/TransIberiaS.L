package control.nucleo;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.dao.CamionDAO;
import modelo.dto.CamionDTO;
import modelo.dto.ConductorDTO;
import modelo.vista.CamionMV;
import utiles.EstadoCamion;
import utiles.EstadoConductor;
import utiles.Validator;

public class CamionNucleo {
	private CamionDAO dao = new CamionDAO();

	public CamionNucleo() {
	}

	public boolean ComprarCamion(CamionMV camion) {
		CamionDTO camionDTO = new CamionDTO();
		camionDTO.setMatricula(camion.getMatricula());
		camionDTO.setMarca(camion.getMarca());
		camionDTO.setPotencia(camion.getPotencia());
		camionDTO.setEstado((EstadoCamion) EstadoCamion.Garaje);
		Long IDcamion = dao.obtenerId();
		camionDTO.setID(IDcamion);
		if (validacionMatricula(camion)) {
			return dao.guardar(camionDTO);
		}
		return false;

	}

	public boolean validacionMatricula(CamionMV camion) {
		if (Validator.isMatricula(camion.getMatricula())) {
			return true;
		}
		return false;
	}

	public boolean venderCamion(CamionMV camion) {
		CamionDTO camionDTO = dao.consultar(camion.getID());
		camionDTO.setEstado((EstadoCamion) EstadoCamion.Vendido);
		return dao.modificar(camionDTO);
	}

	public CamionMV obtenerCamion(String id) {
		CamionMV modelo = new CamionMV();
		CamionDTO camion = dao.consultar(new Long(id));
		modelo.setID(camion.getID());
		modelo.setPotencia(camion.getPotencia());
		modelo.setMatricula(camion.getMatricula());
		modelo.setMarca(camion.getMarca());
		modelo.setEstado(camion.getEstado());
		return modelo;
	}

	public boolean modificarCamion(String id, EstadoCamion estado) {
		CamionDTO camionDTO = dao.consultar(new Long(id));
		camionDTO.setEstado(estado);
		if (dao.modificar(camionDTO)) {
			return true;
		}
		return false;

	}

	public ArrayList<String> listadoIdCamiones() {
		return dao.obtenerTodosIds();
	}

	public HashMap<Long, String> obtenerMapaIDNombre() {
		return dao.obtenerMapaIDNombre();
	}

	public HashMap<Long, String> obtenerMapaIDEnRuta() {
		return dao.obtenerMapaIDEnRuta();
	}

	public HashMap<Long, String> obtenerMapaIDEnGaraje() {
		return dao.obtenerMapaIDGaraje();
	}

}
