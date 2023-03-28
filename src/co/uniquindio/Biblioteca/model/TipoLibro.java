package co.uniquindio.Biblioteca.model;

public enum TipoLibro {

	CIENTIFICO(0),BIOGRAFIA(1),MONOGRAFIA(2);
	int valor;

	 TipoLibro (int valor){

		this.valor = valor;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
