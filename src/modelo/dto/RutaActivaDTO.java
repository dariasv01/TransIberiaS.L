package modelo.dto;

import java.sql.Date;

import utiles.EstadoRuta;
import utiles.Mercancia;

public class RutaActivaDTO extends RutaDTO {
	private float kmRecorrido;
	private EstadoRuta estado;
	private ConductorDTO conductorUno, conductorDos;

	public RutaActivaDTO() {

	}

	public RutaActivaDTO(Mercancia mercancia, CamionDTO camion, Date fecha, float km, float kmRecorrido,
			EstadoRuta estado, ConductorDTO conductorUno, ConductorDTO conductorDos, Long ID) {
		super(mercancia, camion, fecha, km, ID);
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

	public ConductorDTO getConductorUno() {
		return conductorUno;
	}

	public void setConductorUno(ConductorDTO conductorUno) {
		this.conductorUno = conductorUno;
	}

	public ConductorDTO getConductorDos() {
		return conductorDos;
	}

	public void setConductorDos(ConductorDTO conductorDos) {
		this.conductorDos = conductorDos;
	}

	

}
