package modelo.dto;

import java.sql.Date;

import utiles.EstadoRuta;
import utiles.Mercancia;

public class RutaActivaDTO extends RutaDTO {
	private float kmRecorrido;
	private EstadoRuta estado;
	private Long conductorUno, conductorDos;

	public RutaActivaDTO() {

	}

	public RutaActivaDTO(Mercancia mercancia, Long camionId, Date fecha, float km, float kmRecorrido, EstadoRuta estado,
			Long conductorUno, Long conductorDos, Long ID) {
		super(mercancia, camionId, fecha, km, ID);
		this.kmRecorrido = kmRecorrido;
		this.estado = estado;
		this.conductorUno = conductorUno;
		this.conductorDos = conductorDos;
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
