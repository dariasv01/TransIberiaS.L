package control.nucleo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.dao.HoraDAO;
import modelo.dto.HoraDTO;

public class HoraNucleo {
	private HoraDAO dao = new HoraDAO();

	public HoraNucleo() {
	}

	public boolean guardarHoraAplicacion(LocalDateTime fecha) {
		HoraDTO horaDTO = new HoraDTO();
		horaDTO.setFechaAplicacion(fecha);
		horaDTO.setFechaSistema(LocalDateTime.now());
		horaDTO.setID(1);
		if (dao.guardar(horaDTO)) {
			return true;
		}
		return false;

	}

	public boolean modificarHoraAplicacion(LocalDateTime fecha) {
		HoraDTO horaDTO = new HoraDTO();
		horaDTO.setFechaAplicacion(fecha);
		horaDTO.setFechaSistema(LocalDateTime.now());
		horaDTO.setID(1);
		if (dao.modificar(horaDTO)) {
			return true;
		}
		return false;

	}

	public LocalDateTime obtenerHoraSistemaGuardada() {
		HoraDTO hora = dao.consultar((long) 1);
		return hora.getFechaSistema();

	}

	public LocalDateTime obtenerHoraAplicacionGuardada() {
		HoraDTO hora = dao.consultar((long) 1);
		return hora.getFechaAplicacion();

	}
	
	public ArrayList<String> listadoId() {
		return dao.obtenerTodosIds();
	}

}
