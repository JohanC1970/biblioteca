package co.uniquindio.Biblioteca.model;

import java.util.ArrayList;
import java.util.Collection;

public class Estudiante {

	private String nombres;
	private String apellidos;
	private Integer edad;
	private String programa;
	private String estado;
	private String identificacion;

	private ArrayList<Prestamo>listaPrestamos = new ArrayList<Prestamo>();

	public Estudiante(){
		super();
	}
	public Estudiante(String nombres, String apellidos, String identificacion, String programa, String estado,
			int edad) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.identificacion = identificacion;
		this.programa = programa;
		this.estado = estado;
		this.edad = edad;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}
	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}
	@Override
	public String toString() {
		return "Estudiante [nombres=" + nombres + ", apellidos=" + apellidos + ", identificacion=" + identificacion
				+ ", programa=" + programa + ", estado=" + estado + ", edad=" + edad + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
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
		Estudiante other = (Estudiante) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}

	//-------------------------------Parcial--------------------------

	//---------Punto 3 del parcial
	/**
	 *Funcion para verificar si un empleado cumple con el tipo necesario
	 *Punto3 parcial
	 * @param tipo
	 * @return
	 */
	public boolean verificarTipoEmpleado(TipoEmpleado tipo) {
		boolean condicion = false;
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.verificarTipoEmpleado(tipo)){
				return true;
			}
		}
		return condicion;
	}

}
