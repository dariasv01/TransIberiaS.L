package modelo.vista;

import java.sql.Date;

import modelo.dto.CamionDTO;
import modelo.dto.ConductorDTO;
import utiles.EstadoRuta;
import utiles.Mercancia;

public class RutaMV {
	private Mercancia mercancia;
	private Long camionId;
	private Date fecha;
	private float km;
	private float kmRecorrido;
	private EstadoRuta estado;
	private Long conductorUno, conductorDos;
	private Long ID;
	
	public RutaMV(){
	}
	
	public  RutaMV(Mercancia mercancia, Long camionId, Date fecha, float km, float kmRecorrido,
			EstadoRuta estado, Long conductorUno, Long conductorDos, Long ID) {
		this.mercancia=mercancia;
		this.camionId=camionId;
		this.fecha=fecha;
		this.km=km;
		this.kmRecorrido = kmRecorrido;
		this.estado = estado;
		this.conductorUno = conductorUno;
		this.conductorDos = conductorDos;
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
