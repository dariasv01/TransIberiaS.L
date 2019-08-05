package modelo.dao;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.dto.RutaActivaDTO;
import modelo.dto.RutaDTO;
import utiles.EstadoCamion;
import utiles.EstadoRuta;

public class RutasActivasDAO {
	private String rutaCarpeta = "rutasActivas";
	private String extension = ".rut";
	private String nombreFichero = "rutas";
	private DAOColecciones<RutaActivaDTO> acceso;

	public RutasActivasDAO() {
		String path = rutaCarpeta + File.separator + nombreFichero + extension;
		acceso = new DAOColecciones<RutaActivaDTO>(path, true);
	}

	public boolean guardar(RutaActivaDTO ruta) {
		return acceso.save(ruta);
	}

	public RutaActivaDTO consultar(Long id) {
		RutaActivaDTO ruta = new RutaActivaDTO();
		ruta.setID(id);
		return acceso.findById(ruta);
	}

	public boolean modificar(RutaActivaDTO ruta) {
		return acceso.modify(ruta);
	}

	public ArrayList<String> obtenerTodosIds() {
		ArrayList<String> lista = new ArrayList<>();
		for (RutaActivaDTO ruta : acceso.getAll()) {
			lista.add(String.valueOf(ruta.getID()));
		}
		return lista;
	}

	public HashMap<Long, String> obtenerMapaIDRutaActiva() {
		HashMap<Long, String> mapa = new HashMap<Long, String>();
		for (RutaActivaDTO ruta : acceso.getAll()) {
			if ((!(ruta.getEstado() == EstadoRuta.Ruta)) || (ruta.getEstado() == EstadoRuta.Parada)) {
				mapa.put(ruta.getID(), ruta.getCamionId().toString());
			}
		}
		return mapa;
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