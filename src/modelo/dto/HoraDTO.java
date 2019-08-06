package modelo.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HoraDTO implements Serializable {
	private LocalDateTime fechaAplicacion, fechaSistema;
	private Long id;

	public HoraDTO() {

	}

	public HoraDTO(LocalDateTime fechaAplicacion, LocalDateTime fechaSistema, long id) {
		this.fechaAplicacion = fechaAplicacion;
		this.fechaSistema = fechaSistema;
		this.id = id;
	}

	public LocalDateTime getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(LocalDateTime fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	public LocalDateTime getFechaSistema() {
		return fechaSistema;
	}

	public void setFechaSistema(LocalDateTime fechaSistema) {
		this.fechaSistema = fechaSistema;
	}

	public long getID() {
		return id;
	}

	public void setID(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		return this.id.equals(((HoraDTO) obj).id);
	}
}
