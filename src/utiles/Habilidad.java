package utiles;

public enum Habilidad {

	SELCCIONAR (0), Frágil(1), Inflamable(2), Pesada(3), Común(4);

	private int valor;

	private Habilidad(int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
