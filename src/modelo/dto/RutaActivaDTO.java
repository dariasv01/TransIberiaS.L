package modelo.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import utiles.EstadoRuta;
import utiles.Mercancia;

public class RutaActivaDTO extends RutaDTO {
	private float kmRecorrido, kmRecorridoDescanso;
	private EstadoRuta estado;
	private Long conductorUno, conductorDos;
	private LocalDateTime fechaTurno, fechaDescanso;
	private boolean cambioTurno;

	public RutaActivaDTO() {

	}

	public RutaActivaDTO(Mercancia mercancia, Long camionId, LocalDateTime fecha, float km, float kmRecorrido,
			EstadoRuta estado, Long conductorUno, Long conductorDos, Long ID, boolean cambioTurno,
			LocalDateTime fechaTurno, LocalDateTime fechaDescanso, float kmRecorridoDescanso) {
		super(mercancia, camionId, fecha, km, ID);
		this.kmRecorrido = kmRecorrido;
		this.estado = estado;
		this.conductorUno = conductorUno;
		this.conductorDos = conductorDos;
		this.cambioTurno = cambioTurno;
		this.fechaTurno = fechaTurno;
		this.fechaDescanso = fechaDescanso;
		this.kmRecorridoDescanso = kmRecorridoDescanso;
	}

	public float getKmRecorridoDescanso() {
		return kmRecorridoDescanso;
	}

	public void setKmRecorridoDescanso(float kmRecorridoDescanso) {
		this.kmRecorridoDescanso = kmRecorridoDescanso;
	}

	public LocalDateTime getFechaDescanso() {
		return fechaDescanso;
	}

	public void setFechaDescanso(LocalDateTime fechaDescanso) {
		this.fechaDescanso = fechaDescanso;
	}

	public LocalDateTime getFechaTurno() {
		return fechaTurno;
	}

	public void setFechaTurno(LocalDateTime fechaTurno) {
		this.fechaTurno = fechaTurno;
	}

	public boolean isCambioTurno() {
		return cambioTurno;
	}

	public void setCambioTurno(boolean cambioTurno) {
		this.cambioTurno = cambioTurno;
	}

	public float getKmRecorrido() {
		return kmRecorrido;
	}

	public void setKmRecorrido(float kmRecorrido) {
		this.kmRecorrido = kmRecorrido;
	}

	public EstadoRuta getEstado() {
		return estado;
	}

	public void setEstado(EstadoRuta estado) {
		this.estado = estado;
	}

	public Long getConductorUno() {
		return conductorUno;
	}

	public void setConductorUno(Long conductorUno) {
		this.conductorUno = conductorUno;
	}

	public Long getConductorDos() {
		return conductorDos;
	}

	public void setConductorDos(Long conductorDos) {
		this.conductorDos = conductorDos;
	}

}
