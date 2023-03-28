package co.uniquindio.Biblioteca.model;

import java.util.ArrayList;

public class Empleado {

	private String nombre;
	private double salario;
	private String cargo;
	private Integer aniosExperiencia;
	private TipoEmpleado tipoEmpleado;


	private ArrayList<Prestamo>listaPrestamos= new ArrayList<Prestamo>();

	public Empleado(){
		super();
	}

	public Empleado(String nombre, double salario, String cargo, Integer aniosExperiencia, TipoEmpleado tipoEmpleado) {
		super();
		this.nombre = nombre;
		this.salario = salario;
		this.cargo = cargo;
		this.aniosExperiencia = aniosExperiencia;
		this.tipoEmpleado = tipoEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}


	public Integer getAniosExperiencia() {
		return aniosExperiencia;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}


	@Override
	public String toString() {
		return "Empleado [nombre=" + nombre + ", salario=" + salario + ", cargo=" + cargo + ", aniosExperiencia="
				+ aniosExperiencia + ", tipoEmpleado=" + tipoEmpleado + ", listaPrestamos=" + listaPrestamos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Empleado other = (Empleado) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	//------------------------------------Parcial---------------------------------------------


}
