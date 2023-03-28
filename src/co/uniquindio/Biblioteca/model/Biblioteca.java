package co.uniquindio.Biblioteca.model;

import java.util.ArrayList;

public class Biblioteca {

	private String nombre;
	private String direccion;
	private String telefono;

	private ArrayList<Estudiante>listaEstudiantes = new ArrayList<Estudiante>();
	private ArrayList<Empleado>listaEmpleados = new ArrayList<Empleado>();
	private ArrayList<Prestamo>listaPrestamos = new ArrayList<Prestamo>();
	private ArrayList<Libro>listaLibros = new ArrayList<Libro>();


	public Biblioteca(){
		super();
	}

	public Biblioteca(String nombre, String direccion, String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Estudiante> getListaEstudiantes() {
		return listaEstudiantes;
	}

	public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
		this.listaEstudiantes = listaEstudiantes;
	}

	public ArrayList<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public ArrayList<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}

	public void setListaPrestamos(ArrayList<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}


	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
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
		Biblioteca other = (Biblioteca) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	//-----------------------------Libro----------------------------------------

	/**
	 * Esta función verifica si existe un libro
	 * @param isbn
	 * @return
	 */
	public boolean verificarLibro(String isbn){
		boolean existe = false;
		for (Libro libro : listaLibros) {
			if(libro.getIsbn().equals(isbn)){
				return true;
			}
		}
		return existe;
	}

	/**
	 * Esta función me crea un libro, en caso de que el libro exista manda una excepcion
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @return
	 * @throws Exception
	 */
	public String crearLibro(String isbn, String titulo, String autor, TipoLibro tipo) throws Exception
	{
		String msj = "El libro ha sido creado exitosamente";
		boolean libroExiste = verificarLibro(isbn);
		if(libroExiste == true)
		{
			throw new Exception("El libro ya existe");
		}
		Libro libroNuevo = new Libro(isbn,titulo,autor,tipo);
		listaLibros.add(libroNuevo);
		return msj;
	}

	/**
	 * Esta función me retorna un libro
	 * @param isbn
	 * @return
	 */
	public Libro obtenerLibro(String isbn)
	{
		Libro libroEncontrado = null;
		for (Libro libro : listaLibros) {
			if(libro.getIsbn().equals(isbn)){
				libroEncontrado = libro;
				return libroEncontrado;
			}
		}
		return libroEncontrado;
	}

	/**
	 * Esta funcion elimina un libro, si no encuentra el libro manda una exception
	 * @param isbn
	 * @throws Exception
	 */
	public void eliminarLibro(String isbn) throws Exception
	{
		Libro libroEncontrado = obtenerLibro(isbn);
		if(libroEncontrado == null)
		{
			throw new Exception("El libro no esta registrado");
		}
		listaLibros.remove(libroEncontrado);
	}

	/**
	 * Esta función me actualiza los datos de un libro, solo actualiza el titulo y el autor.
	 * @param isbn
	 * @param tituloNuevo
	 * @param autorNuevo
	 * @return
	 * @throws Exception
	 */
	public String actualizarLibro(String isbn, String tituloNuevo, String autorNuevo, TipoLibro tipoNuevo) throws Exception{
		String msj= "El libro se actualizo correctamente";
		Libro libroEncontrado = obtenerLibro(isbn);
		if(libroEncontrado == null)
		{
			throw new Exception("El libro no se encuentra registrado");
		}

		libroEncontrado.setAutor(autorNuevo);
		libroEncontrado.setTitulo(tituloNuevo);
		libroEncontrado.setTipo(tipoNuevo);
		return msj;
	}

	//----------------------------Estudiante-------------------------------------

	/**
 	*
 	* @param identificacion
 	* @return
 	*/
	private boolean verificarEstudiante(String identificacion) {
		boolean verificado = false;
		for (Estudiante estudianteaux : listaEstudiantes) {
			if(estudianteaux.getIdentificacion().equals(identificacion)){
				verificado = true;
				return verificado;
			}
		}
		return verificado;
	}

	/**
	 * Este metodo permite crear un estudiante
	 * @param nombres
	 * @param apellidos
	 * @param edad
	 * @param programa
	 * @param estado
	 * @param identificacion
	 * @throws Exception
	 */
	public String crearEstudiante(String nombres, String apellidos, String identificacion, String programa, String estado,
			Integer edad) throws Exception{

		String mensaje = "El estudiante ha sido registrado";
		boolean estudianteEncontrado = verificarEstudiante(identificacion);
		if( estudianteEncontrado == true){
			throw new Exception("El estudiante ya existe");
		}else{
			Estudiante nuevoEstudiante = new Estudiante(nombres,apellidos,identificacion,programa,estado,edad);
			listaEstudiantes.add(nuevoEstudiante);
		}
		return mensaje;
	}

	/**
	 * Obtener un estudiante
	 * @param identificacion
	 * @return
	 */
	public Estudiante obtenerEstudiante (String identificacion){

		Estudiante estudianteEncontrado = null;

		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getIdentificacion().equals(identificacion)){
				estudianteEncontrado = estudiante;
			}
		}
		return estudianteEncontrado;
	}

	public void eliminarEstudiante(String identificacion) throws Exception
	{
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if(estudianteEncontrado == null){
			throw new Exception("El estudiante no esta registrado");
		}
		listaEstudiantes.remove(estudianteEncontrado);
	}

	public String actualizarEstudiante(String nombres , String apellidos , String identificacion, Integer edad) throws Exception{
		Estudiante estudianteEncontrado = obtenerEstudiante(identificacion);
		if(estudianteEncontrado == null){
			throw new Exception("El estudiante no esta registrado");
		}
       estudianteEncontrado.setNombres(nombres);
       estudianteEncontrado.setApellidos(apellidos);
       estudianteEncontrado.setEdad(edad);

       return " El estudiante ha sido actualizado " ;

	}

	//----------------------------Empleado----------------------------------------

	public boolean verificarEmpleado(String nombre){
		boolean empleadoVerificado = false;
		for (Empleado empleado : listaEmpleados) {
			if(empleado.getNombre().equals(nombre));
			return true;
		}

		return empleadoVerificado;
	}

	public String crearEmpleado(String nombre, double salario, String cargo,Integer aniosExperiencia, TipoEmpleado tipoEmpleado) throws Exception{
		boolean existeEmpleado = verificarEmpleado(nombre);
		if(existeEmpleado == true){
			throw new Exception("El empleado ya existe");
		}

		Empleado nuevoEmpleado = new Empleado(nombre,salario,cargo,aniosExperiencia,tipoEmpleado);
		listaEmpleados.add(nuevoEmpleado);
		return "El empleado ha sido registrado exitosamente";
	}

	public Empleado obtenerEmpleado(String nombre){
		Empleado empleadoEncontrado = null;
		for (Empleado empleado : listaEmpleados) {
			if(empleado.getNombre().equals(nombre)){
				empleadoEncontrado = empleado;
				return empleadoEncontrado;
			}
		}
		return empleadoEncontrado;
	}

	public void eliminarEmpleado(String nombre) throws Exception{
		Empleado empleadoEncontrado = obtenerEmpleado(nombre);
		if(empleadoEncontrado == null){
			throw new Exception("El empleado no existe");
		}

		listaEmpleados.remove(empleadoEncontrado);
	}

	public String actualizarEmpleado(String nombre, double salario, String cargo,Integer aniosExperiencia) throws Exception{
		Empleado empleadoEncontrado = obtenerEmpleado(nombre);
		if(empleadoEncontrado == null){
			throw new Exception("El empleado no existe");
		}

		empleadoEncontrado.setCargo(cargo);
		empleadoEncontrado.setSalario(salario);
		empleadoEncontrado.setAniosExperiencia(aniosExperiencia);
		return "Los datos del empleado se han actualizado correctamente";
	}


	//-----------------------Funciones Preparcial------------------------------

	//Punto1

	/**
	 * Esta función me devuelve los datos del empleado que realizo un prestamo de un libro en especifico
	 * @param isbn
	 * @return
	 * @throws PrestamoException
	 */
	public String devolverEmpleadoPrestamoLibroIsbn(String isbn) throws PrestamoException{
		String empleadoEncontrado = "";
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.cumpleIsbn(isbn)){
				empleadoEncontrado = prestamo.getEmpleadoPrestamo().toString();
				return empleadoEncontrado;
			}
		}

		throw new PrestamoException("No existe ningun prestamo con este isbn");
	}

	//Punto 2
	public Prestamo devolverPrestamoLibro(String titulo, int limiteInferior, int limiteSuperior, int aniosExperiencia){
		Prestamo prestamoEncontrado = null;
		for (Prestamo prestamo : listaPrestamos) {
			if(prestamo.cumpleLibro(titulo,limiteInferior,limiteSuperior,aniosExperiencia)){
				prestamoEncontrado = prestamo;
				return prestamoEncontrado;
			}
		}
		return prestamoEncontrado;
	}

	//Punto 3
	public TipoLibro calcularTipoLibroMasPrestado(){

		TipoLibro tipoMasPrestado = TipoLibro.CIENTIFICO;

		int cantidadCientifico = obtenerTotalPrestadosTipo(TipoLibro.CIENTIFICO);
		int cantidadBiografia = obtenerTotalPrestadosTipo(TipoLibro.BIOGRAFIA);
		int cantidadMonografia = obtenerTotalPrestadosTipo(TipoLibro.MONOGRAFIA);

		if(cantidadBiografia>cantidadCientifico && cantidadBiografia>cantidadMonografia){
			return TipoLibro.BIOGRAFIA;
		}

		if(cantidadMonografia>cantidadCientifico && cantidadMonografia>cantidadBiografia){
			return TipoLibro.MONOGRAFIA;
		}

		return tipoMasPrestado;
	}


	public int obtenerTotalPrestadosTipo(TipoLibro tipo) {
		int contador =0;
		for (Prestamo prestamo : listaPrestamos) {
			contador+= prestamo.obtenerCantidadTipo(tipo);
		}
		return contador;
	}
	/*
	//1 Punto parcial
	public ArrayList<Libro>obtenerListaLibrosCientificosEstudiante(String identificacion, String programa, TipoLibro tipoLibro) throws Exception{

		ArrayList<Libro>listaLibrosCientificosEstudiante = new ArrayList<Libro>();
		Estudiante estudianteObtenido = obtenerEstudiantePrograma(identificacion,programa);
		if(estudianteObtenido == null){
			throw new Exception("No es posible encontrar un estudiante");
		}
		listaLibrosCientificosEstudiante.addAll(estudianteObtenido.obterLibros(tipoLibro);
		return listaLibrosCientificosEstudiante;
	}

	public Estudiante obtenerEstudiantePrograma(String identificacion, String programa){
		Estudiante estudianteObtenido = null;
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.getIdentificacion().equals(identificacion) && estudiante.getPrograma().equals(programa)){
				estudianteObtenido = estudiante;
				return estudianteObtenido;
			}
		}
		return estudianteObtenido;
	}
	*/



	/**
	 * Devolver la lista de préstamos donde el empleado tenga en su nombre mínimo tres
	 * vocales y el préstamo tenga al menos 10 libros del autor “Gabriel Garcia Marquez”
	 * Punto 2 del parcial
	 * @param cantidad
	 * @param autor
	 * @return
	 */
	public ArrayList<Prestamo>devolverPrestamosCumple(int cantidad, String autor){
		ArrayList<Prestamo>listaCumple = new ArrayList<Prestamo>();
		for (Prestamo prestamo : listaCumple) {
			if(prestamo.verificarPrestamoCantidadAutor(cantidad,autor)){
				listaCumple.add(prestamo);
			}
		}
		return listaCumple;
	}

	/**
	 * Funcion para dar la lista de estudiantes atendidos por un tipo de empleado
	 *Punto 3 del parcial
	 * @param tipo
	 * @return
	 */
	public ArrayList<Estudiante>darListaEstudiantesAtendidosEmpleado(TipoEmpleado tipo){
		ArrayList<Estudiante>listaEstudiantesAtendidos = new ArrayList<Estudiante>();
		for (Estudiante estudiante : listaEstudiantes) {
			if(estudiante.verificarTipoEmpleado(tipo)){
				listaEstudiantesAtendidos.add(estudiante);
			}
		}

		return listaEstudiantesAtendidos;
	}


}


