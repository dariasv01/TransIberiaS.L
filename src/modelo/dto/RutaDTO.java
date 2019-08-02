package modelo.dto;

import java.io.Serializable;
import java.sql.Date;

import utiles.Mercancia;

public class RutaDTO implements Serializable{
	private Mercancia mercancia;
	private CamionDTO camion;
	private Date fecha;
	private float km;
	private Long ID;
	
	public RutaDTO(){
	}
	
	public  RutaDTO(Mercancia mercancia,CamionDTO camion, Date fecha, float km, Long ID) {
		this.mercancia=mercancia;
		this.camion=camion;
		this.fecha=fecha;
		this.km=km;
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

	public CamionDTO getCamion() {
		return camion;
	}

	public void setCamion(CamionDTO camion) {
		this.camion = camion;
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
	
}
