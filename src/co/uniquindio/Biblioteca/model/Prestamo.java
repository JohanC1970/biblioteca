package co.uniquindio.Biblioteca.model;

import java.util.ArrayList;
import java.util.Collection;

public class Prestamo {

	private String fecha;
	private String codigo;
	private Integer tiempoEntrega;
	private double total;

	private ArrayList<DetallePrestamo>listaDetallesPrestamo = new ArrayList<DetallePrestamo>();
	private Empleado empleadoPrestamo;

	public Prestamo(){
		super();
	}

	public Prestamo(String fecha, String codigo, Integer tiempoEntrega, double total, Empleado empleadoPrestamo) {
		super();
		this.fecha = fecha;
		this.codigo = codigo;
		this.tiempoEntrega = tiempoEntrega;
		this.total = total;
		this.empleadoPrestamo = empleadoPrestamo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(Integer tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public ArrayList<DetallePrestamo> getListaDetallesPrestamo() {
		return listaDetallesPrestamo;
	}

	public void setListaDetallesPrestamo(ArrayList<DetallePrestamo> listaDetallesPrestamo) {
		this.listaDetallesPrestamo = listaDetallesPrestamo;
	}

	public Empleado getEmpleadoPrestamo() {
		return empleadoPrestamo;
	}

	public void setEmpleadoPrestamo(Empleado empleadoPrestamo) {
		this.empleadoPrestamo = empleadoPrestamo;
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
		Prestamo other = (Prestamo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prestamo [fecha=" + fecha + ", codigo=" + codigo + ", tiempoEntrega=" + tiempoEntrega + ", total="
				+ total + ", empleadoPrestamo=" + empleadoPrestamo + "]";
	}

	//Punto 1 preparcial
	public boolean cumpleIsbn(String isbn) {
		boolean cumple = false;

		for (DetallePrestamo detallePrestamo : listaDetallesPrestamo) {
			if(detallePrestamo.cumpleIsbn(isbn)){
				return true;
			}
		}
		return cumple;
	}

	public boolean cumpleLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia) {
		boolean cumple = false;
		boolean cumpleAniosExperiencia = verificarAniosExperiencia(aniosExperiencia);
		boolean cumpleRequisitosLibro = verificarLibro(titulo,limiteInferior,limiteSuperior);
		if(cumpleAniosExperiencia && cumpleRequisitosLibro){
			return true;
		}
		return cumple;
	}

	private boolean verificarLibro(String titulo, int limiteInferior, int limiteSuperior) {

		for (DetallePrestamo detallePrestamo : listaDetallesPrestamo) {
			if(detallePrestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior)){
				return true;
			}
		}

		return false;
	}

	private boolean verificarAniosExperiencia(int aniosExperiencia) {
		return empleadoPrestamo.getAniosExperiencia()>1;
	}

	public int obtenerCantidadTipo(TipoLibro tipo) {
		int contador = 0;
		for (DetallePrestamo detallePrestamo : listaDetallesPrestamo) {
			if(detallePrestamo.cumpleTipo(tipo)){

				//Me suma la cantidad de libros que cumplan con el requisito en este detalle del prestamo
				contador+= detallePrestamo.getCantidad();
			}
		}

		return contador;
	}

	//------------------------------Parcial--------------------------------------------

	//-----Punto2 Parcial
	/**
	 * Esta funcion verifica si un prestamo cumple las condiciones
	 * Punto 2 del parcial
	 * @param cantidad
	 * @param autor
	 * @return
	 */
	public boolean verificarPrestamoCantidadAutor(int cantidad, String autor) {
		boolean cumpleAutor = isCumpleAutorVocales(empleadoPrestamo.getNombre());
		boolean cumplePrestamo = isCumplePrestamoCantidadAutor(cantidad,autor);

		if(cumpleAutor && cumplePrestamo){
			return true;
		}

		return false;
	}

	/**
	 * Esta funcion verifica si la cantidad de libros prestados es la indicada, tambien verifica si el autor es el correcto
	 * Punto 2 del parcial
	 * @param cantidad
	 * @param autor
	 * @return
	 */
	private boolean isCumplePrestamoCantidadAutor(int cantidad, String autor) {
		boolean condicion = false;
		for (DetallePrestamo detallePrestamo : listaDetallesPrestamo) {
			if(detallePrestamo.getCantidad()>=cantidad && detallePrestamo.verificarAutor(autor)){
				return true;
			}
		}
		return condicion;
	}


	/**
	 * Esta funcion verifica si un nombre tiene mas de dos vocales
	 * Punto 2 del parcial
	 * @param nombre
	 * @return
	 */
	public boolean isCumpleAutorVocales(String nombre){
		  int contadorVocales = 0;
		    String vocales = "aeiouAEIOU";
		    for (int i = 0; i < nombre.length(); i++) {
		        if (vocales.indexOf(nombre.charAt(i)) != -1) {
		            contadorVocales++;
		        }
		    }
		    return contadorVocales > 2;
	}

	//-----------Punto3
	/**
	 * Esta funcion verifica si el tipo del empleado es el mismo ingresado
	 * punto 3 del parcial
	 * @param tipo
	 * @return
	 */
	public boolean verificarTipoEmpleado(TipoEmpleado tipo) {
		return empleadoPrestamo.getTipoEmpleado().equals(tipo);
	}


}
