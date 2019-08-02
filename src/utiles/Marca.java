package utiles;

public enum Marca {
	
	SELCCIONAR (0,""), MAN(1,"350.6"), Volvo(2,"250"), DAF(3,"500"), Iveco(4,"300.8"), Scania(5,"400"), Renault(6,"200.6");

	private int valor;
	private String potencia;

	private Marca(int valor, String potencia) {
		this.valor=valor;
		this.potencia=potencia;
	}

	public int getValor() {
		return valor;
	}

	public String getPotencia() {
		return potencia;
	}
	
}
