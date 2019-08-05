package utiles;

public enum Mercancia {
	
	SELCCIONAR (0), Cristal(1), Combustible(2), Excavadora(3), Comida(4);

	private int valor;

	private Mercancia(int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
