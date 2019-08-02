package modelo.dao;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import modelo.dto.RutaDTO;

public class RutasActivasDAO {
	private String rutaCarpeta = "rutasActivas";
	private String extension = ".rut";
	private String nombreFichero = "rutas";
	private DAOColecciones<RutaDTO> acceso;

	public RutasActivasDAO() {
		String path = rutaCarpeta + File.separator + nombreFichero + extension;
		acceso = new DAOColecciones<RutaDTO>(path, true);
	}

	public boolean guardar(RutaDTO ruta) {
		return acceso.save(ruta);
	}

	public RutaDTO consultar(Long id) {
		RutaDTO ruta = new RutaDTO();
		ruta.setID(id);
		return acceso.findById(ruta);
	}

	public boolean modificar(RutaDTO ruta) {
		return acceso.modify(ruta);
	}

	public ArrayList<String> obtenerTodosIds() {
		ArrayList<String> lista = new ArrayList<>();
		for (RutaDTO ruta : acceso.getAll()) {
			lista.add(String.valueOf(ruta.getID()));
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