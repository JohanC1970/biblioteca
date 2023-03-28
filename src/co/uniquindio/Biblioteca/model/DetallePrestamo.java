package co.uniquindio.Biblioteca.model;

public class DetallePrestamo {

	private String codigo;
	private double subTotal;
	private Integer cantidad;

	private Libro libro;

	public DetallePrestamo(){
		super();
	}

	public DetallePrestamo(String codigo, double subTotal, Integer cantidad) {
		super();
		this.codigo = codigo;
		this.subTotal = subTotal;
		this.cantidad = cantidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "DetallePrestamo [codigo=" + codigo + ", subTotal=" + subTotal + ", cantidad=" + cantidad + ", libro="
				+ libro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePrestamo other = (DetallePrestamo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	//Punto 1 preparcial
	public boolean cumpleIsbn(String isbn) {
		return libro.getIsbn().equals(isbn);
	}

	//Punto 2 preparcial
	public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior) {
		boolean verificarNombre = verificarTitulo(titulo);
		boolean verificarCantidad = verificarRango(limiteInferior, limiteSuperior);

		if(verificarNombre && verificarCantidad){
			return true;
		}

		return false;
	}

	private boolean verificarRango(int limiteInferior, int limiteSuperior) {
		if(cantidad>=5 && cantidad<=15){
			return true;
		}
		return false;
	}

	private boolean verificarTitulo(String titulo) {
		return libro.getTitulo().equals(titulo);
	}

	public boolean cumpleTipo(TipoLibro tipo) {

		return libro.getTipo().equals(tipo);

	}

	//----------------------------------------------Parcial--------------------------------

	/**
	 * Esta funcion verifica el autor de un libro
	 * Punto numero 2 del parcial
	 * @param autor
	 * @return
	 */
	public boolean verificarAutor(String autor) {
		return libro.getAutor().equals(autor);
	}

}
