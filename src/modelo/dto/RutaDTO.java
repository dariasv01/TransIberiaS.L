package modelo.dto;

import java.io.Serializable;
import java.sql.Date;

import utiles.Mercancia;

public class RutaDTO implements Serializable {
	private Mercancia mercancia;
	private Long camionId;
	private Date fecha;
	private float km;
	private Long ID;

	public RutaDTO() {
	}

	public RutaDTO(Mercancia mercancia, Long camionId, Date fecha, float km, Long ID) {
		this.mercancia = mercancia;
		this.camionId = camionId;
		this.fecha = fecha;
		this.km = km;
		this.ID = ID;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	@Override
	public boolean equals(Object obj) {
		return this.ID.equals(((RutaDTO) obj).ID);
	}

}
