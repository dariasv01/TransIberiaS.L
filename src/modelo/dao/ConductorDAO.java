package modelo.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import modelo.dto.CamionDTO;
import modelo.dto.ConductorDTO;
import utiles.EstadoCamion;
import utiles.EstadoConductor;
import utiles.Habilidad;

public class ConductorDAO {

	private String rutaCarpeta = "conductor";
	private String extension = ".cond";

	public ConductorDAO() {

	}

	public boolean guardar(ConductorDTO conductor) {
		String path = rutaCarpeta + File.separator + conductor.getID() + extension;
		DAO<ConductorDTO> acceso = new DAO<ConductorDTO>(path, true);
		return acceso.save(conductor);
	}

	public ConductorDTO consultar(Long id) {
		String path = rutaCarpeta + File.separator + String.valueOf(id) + extension;
		DAO<ConductorDTO> acceso = new DAO<ConductorDTO>(path, false);
		return acceso.getOne();
	}

	public boolean modificar(ConductorDTO conductor) {
		String idConductor = String.valueOf(conductor.getID());
		String path = rutaCarpeta + File.separator + idConductor + extension;
		DAO<ConductorDTO> acceso = new DAO<ConductorDTO>(path, false);
		return acceso.override(conductor);
	}

	public boolean eliminar(ConductorDTO conductor) {
		String idConductor = String.valueOf(conductor.getID());
		String path = rutaCarpeta + File.separator + idConductor + extension;
		DAO<ConductorDTO> acceso = new DAO<ConductorDTO>(path, false);
		return acceso.delete();
	}

	public ArrayList<String> obtenerTodosLosId() {
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		ArrayList<String> listaId = new ArrayList<>();
		for (String nombre : lista) {
			String idTexto = nombre.replace(extension, "");
			if (!consultar(new Long(idTexto)).isEliminado()) {
				listaId.add(idTexto);
			}
		}
		return listaId;
	}

	public HashMap<Long, String> obtenerMapaIDNombre() {
		HashMap<Long, String> mapa = new HashMap<Long, String>();
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		for (String nombre : lista) {
			Long idConductorDTO = new Long(nombre.replace(extension, ""));
			ConductorDTO conductorDTO = consultar(idConductorDTO);
			if (!conductorDTO.isEliminado()) {
				mapa.put(conductorDTO.getID(), conductorDTO.getNombre());
			}
		}
		return mapa;
	}

	public HashMap<Long, String> obtenerMapaIDFragil() {
		HashMap<Long, String> mapa = new HashMap<Long, String>();
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		for (String nombre : lista) {
			Long idConductorDTO = new Long(nombre.replace(extension, ""));
			ConductorDTO conductorDTO = consultar(idConductorDTO);
			if (((conductorDTO.getHabilidad() == Habilidad.Frágil))
					&& (conductorDTO.getEstado() == EstadoConductor.Parado)) {
				mapa.put(conductorDTO.getID(), conductorDTO.getNombre());
			}
		}
		return mapa;
	}

	public HashMap<Long, String> obtenerMapaIDInflamable() {
		HashMap<Long, String> mapa = new HashMap<Long, String>();
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		for (String nombre : lista) {
			Long idConductorDTO = new Long(nombre.replace(extension, ""));
			ConductorDTO conductorDTO = consultar(idConductorDTO);
			if (((conductorDTO.getHabilidad() == Habilidad.Inflamable))
					&& (conductorDTO.getEstado() == EstadoConductor.Parado)) {
				mapa.put(conductorDTO.getID(), conductorDTO.getNombre());
			}
		}
		return mapa;
	}

	public HashMap<Long, String> obtenerMapaIDPesada() {
		HashMap<Long, String> mapa = new HashMap<Long, String>();
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		for (String nombre : lista) {
			Long idConductorDTO = new Long(nombre.replace(extension, ""));
			ConductorDTO conductorDTO = consultar(idConductorDTO);
			if (((conductorDTO.getHabilidad() == Habilidad.Pesada))
					&& (conductorDTO.getEstado() == EstadoConductor.Parado)) {
				mapa.put(conductorDTO.getID(), conductorDTO.getNombre());
			}
		}
		return mapa;
	}

	public HashMap<Long, String> obtenerMapaIDComun() {
		HashMap<Long, String> mapa = new HashMap<Long, String>();
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		for (String nombre : lista) {
			Long idConductorDTO = new Long(nombre.replace(extension, ""));
			ConductorDTO conductorDTO = consultar(idConductorDTO);
			if (((conductorDTO.getHabilidad() == Habilidad.Común))
					&& (conductorDTO.getEstado() == EstadoConductor.Parado)) {
				mapa.put(conductorDTO.getID(), conductorDTO.getNombre());
			}
		}
		return mapa;
	}

	public Long obtnerIDconductor() {
		DAO<ConductorDTO> acceso = new DAO<>(rutaCarpeta, false);
		List<String> lista = acceso.listarElementosPorNombre();
		Long idFinal = null;
		for (String nombre : lista) {
			String idTexto = nombre.replace(extension, "");
			Long idAux = new Long(idTexto);
			if (null == idFinal || idAux > idFinal) {
				idFinal = idAux;
			}
		}
		if (null == idFinal) {
			idFinal = 0L;
		}
		return idFinal + 1;
	}

}
