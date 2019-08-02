package modelo.vista;

import utiles.EstadoConductor;
import utiles.Habilidad;

public class ConductorMV {
	private String nombre, direccion, telefono;
	private Long ID;
	private Habilidad habilidad;
	private EstadoConductor estado;

	public ConductorMV() {
	}

	public ConductorMV(String nombre, String apellidos, String direccion, String telefono, Habilidad habilidad,
			EstadoConductor estado) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.habilidad = habilidad;
		this.estado = estado;
	}

	public EstadoConductor getEstado() {
		return estado;
	}

	public void setEstado(EstadoConductor estado) {
		this.estado = estado;
	}

	public Habilidad getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(Habilidad habilidad) {
		this.habilidad = habilidad;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Long getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
