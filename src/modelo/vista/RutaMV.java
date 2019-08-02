package modelo.vista;

import java.sql.Date;

import modelo.dto.CamionDTO;
import modelo.dto.ConductorDTO;
import utiles.EstadoConductor;
import utiles.EstadoRuta;
import utiles.Mercancia;

public class RutaMV {
	private Mercancia mercancia;
	private CamionDTO camion;
	private Date fecha;
	private float km;
	private float kmRecorrido;
	private EstadoRuta estado;
	private ConductorDTO conductorUno, conductorDos;
	private Long ID;
	
	public RutaMV(){
	}
	
	public  RutaMV(Mercancia mercancia, CamionDTO camion, Date fecha, float km, float kmRecorrido,
			EstadoRuta estado, ConductorDTO conductorUno, ConductorDTO conductorDos, Long ID) {
		this.mercancia=mercancia;
		this.camion=camion;
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
