package utiles;

public enum EstadoRuta {
	Parada(0), Ruta(1), Finalizada(2);

	private int valor;

	private EstadoRuta (int valor) {
		this.valor=valor;
	}

	public int getValor() {
		return valor;
	}
}
