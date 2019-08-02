package modelo.dao;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.dto.CamionDTO;
import utiles.EstadoCamion;

public class CamionDAO {
	private String rutaCarpeta = "cami";
	private String extension = ".cam";
	private String nombreFichero = "listaCamiones";
	private DAOColecciones<CamionDTO> acceso;

	public CamionDAO() {
		String path = rutaCarpeta + File.separator  + nombreFichero + extension;
		acceso = new DAOColecciones<CamionDTO>(path, true);
	}

	public boolean guardar(CamionDTO camion) {
		return acceso.save(camion);
	} 

	public CamionDTO consultar(Long id) {
		CamionDTO camion = new CamionDTO();
		camion.setID(id);
		return acceso.findById(camion);
	}

	public boolean modificar(CamionDTO camion) {
		return acceso.modify(camion);
	}

	public HashMap<Long,String> obtenerMapaIDNombre() {
		HashMap<Long,String> mapa = new HashMap<Long,String>();
		for (CamionDTO camion : acceso.getAll()) {
			if (!(camion.getEstado()==EstadoCamion.Vendido)) {
				mapa.put(camion.getID(),camion.getMatricula());
			}
		}
		return mapa;
	}
	
	public HashMap<Long,String> obtenerMapaIDEnRuta() {
		HashMap<Long,String> mapa = new HashMap<Long,String>();
		for (CamionDTO camion : acceso.getAll()) {
			if ((!(camion.getEstado()==EstadoCamion.Vendido))&&(camion.getEstado()==EstadoCamion.Ruta)) {
				mapa.put(camion.getID(),camion.getMatricula());
			}
		}
		return mapa;
	}

	public HashMap<Long,String> obtenerMapaIDGaraje() {
		HashMap<Long,String> mapa = new HashMap<Long,String>();
		for (CamionDTO camion : acceso.getAll()) {
			if ((!(camion.getEstado()==EstadoCamion.Vendido))&&(camion.getEstado()==EstadoCamion.Garaje)) {
				mapa.put(camion.getID(),camion.getMatricula());
			}
		}
		return mapa;
	}
	
	public ArrayList<String> obtenerTodosIds() {
		ArrayList<String> lista = new ArrayList<>();
		for (CamionDTO camion : acceso.getAll()) {
				lista.add(String.valueOf(camion.getID()));
		}
		return lista;
	}

	public Long obtenerId() {
		ArrayList<String> lista = obtenerTodosIds();
		Long idMax = null;
		for (String id : lista) {
			Long idAux = new Long(id);
			if (null == idMax || idAux > idMax) {
				idMax = idAux;
			}
		}
		if (null == idMax) {
			idMax = 0L;
		}
		return idMax + 1;
	}

}