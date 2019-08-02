package utiles;

public enum EstadoConductor {
	Descanso (0), Ruta(1), Parado(2);

	private int valor;

	private EstadoConductor (int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
