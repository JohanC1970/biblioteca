package co.uniquindio.Biblioteca.model;

public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private TipoLibro tipo;
	public Libro(){
		super();
	}


	public Libro(String isbn, String titulo, String autor, TipoLibro tipo) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.tipo = tipo;
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	public TipoLibro getTipo() {
		return tipo;
	}


	public void setTipo(TipoLibro tipo) {
		this.tipo = tipo;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", tipo=" + tipo + "]";
	}



}
