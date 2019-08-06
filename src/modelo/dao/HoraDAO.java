package modelo.dao;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.dto.HoraDTO;
import modelo.dto.RutaDTO;

public class HoraDAO {
	private String rutaCarpeta = "aplicacion";
	private String extension = ".hor";
	private String nombreFichero = "hora";
	private DAOColecciones<HoraDTO> acceso;

	public HoraDAO() {
		String path = rutaCarpeta + File.separator + nombreFichero + extension;
		acceso = new DAOColecciones<HoraDTO>(path, true);
	}

	public boolean guardar(HoraDTO hora) {
		return acceso.save(hora);
	}

	public HoraDTO consultar(Long id) {
		HoraDTO hora = new HoraDTO();
		hora.setID(id);
		return acceso.findById(hora);
	}

	public boolean modificar(HoraDTO hora) {
		return acceso.modify(hora);
	}

	public ArrayList<String> obtenerTodosIds() {
		ArrayList<String> lista = new ArrayList<>();
		for (HoraDTO hora : acceso.getAll()) {
			lista.add(String.valueOf(hora.getID()));
		}
		return lista;
	}
//
//	public Long obtenerId() {
//		ArrayList<String> lista = obtenerTodosIds();
//		Long idMax = null;
//		for (String id : lista) {
//			Long idAux = new Long(id);
//			if (null == idMax || idAux > idMax) {
//				idMax = idAux;
//			}
//		}
//		if (null == idMax) {
//			idMax = 0L;
//		}
//		return idMax + 1;
//	}

}