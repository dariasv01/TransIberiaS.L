package utiles;

public enum Habilidad {

	SELCCIONAR (0), Fr�gil(1), Inflamable(2), Pesada(3), Com�n(4);

	private int valor;

	private Habilidad(int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
