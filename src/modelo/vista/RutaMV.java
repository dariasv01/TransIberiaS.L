package modelo.vista;

import java.sql.Date;
import java.time.LocalDateTime;

import modelo.dto.CamionDTO;
import modelo.dto.ConductorDTO;
import utiles.EstadoRuta;
import utiles.Mercancia;

public class RutaMV {
	private Mercancia mercancia;
	private Long camionId;
	private float km;
	private float kmRecorrido, kmRecorridoDescanso;
	private EstadoRuta estado;
	private Long conductorUno, conductorDos;
	private Long ID;
	private LocalDateTime fechaTurno, fechaDescanso, fecha;
	private boolean cambioTurno;

	public RutaMV() {
	}

	public RutaMV(Mercancia mercancia, Long camionId, LocalDateTime fecha, float km, float kmRecorrido,
			EstadoRuta estado, Long conductorUno, Long conductorDos, Long ID, boolean cambioTurno,
			LocalDateTime fechaTurno, LocalDateTime fechaDescanso, float kmRecorridoDescanso) {
		this.mercancia = mercancia;
		this.camionId = camionId;
		this.fecha = fecha;
		this.km = km;
		this.kmRecorrido = kmRecorrido;
		this.estado = estado;
		this.conductorUno = conductorUno;
		this.conductorDos = conductorDos;
		this.ID = ID;
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

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Mercancia getMercancia() {
		return mercancia;
	}

	public void setMercancia(Mercancia mercancia) {
		this.mercancia = mercancia;
	}

	public Long getCamionId() {
		return camionId;
	}

	public void setCamionId(Long camionId) {
		this.camionId = camionId;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
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
