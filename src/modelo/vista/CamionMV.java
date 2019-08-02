package modelo.vista;

import utiles.EstadoCamion;
import utiles.Marca;

public class CamionMV {
	private Long ID;
	private String matricula, potencia;
	private Marca marca;
	private EstadoCamion estado;

	public CamionMV() {
	}

	public CamionMV(String matricula, Marca marca, String potencia, EstadoCamion estado) {
		this.matricula = matricula;
		this.potencia = potencia;
		this.marca = marca;
		this.estado = estado;
	}

	public EstadoCamion getEstado() {
		return estado;
	}

	public void setEstado(EstadoCamion estado) {
		this.estado = estado;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

}
