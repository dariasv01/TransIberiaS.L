package utiles;

public enum EstadoCamion {
	Garaje (0), Ruta(1), Parado(2), Vendido(3);

	private int valor;

	private EstadoCamion (int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
