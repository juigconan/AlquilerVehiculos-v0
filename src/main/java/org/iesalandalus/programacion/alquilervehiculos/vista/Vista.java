package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista {

	Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador = controlador;
	}

	public void comenzar() {
		Opcion opcion;
		// controlador.comenzar();
		do {
			Consola.mostrarCabecera("Menu principal");
			Consola.mostrarMenu();
			opcion = Consola.elegirOpcion();
			ejecutar(opcion);
		} while (opcion != Opcion.SALIR);
	}

	public void terminar() {
		System.out.print("¡Gracias por utilizar nuestra aplicacion!");
	}

	private void ejecutar(Opcion opcion) {

		switch (opcion) {
		case SALIR: {
			terminar();
			break;
		}
		case INSERTAR_CLIENTE: {
			insertarCliente();
			break;
		}
		case INSERTAR_TURISMO: {
			insertarTurismo();
			break;
		}
		case INSERTAR_ALQUILER: {
			insertarAlquiler();
			break;
		}
		case BUSCAR_CLIENTE: {
			buscarCliente();
			break;
		}
		case BUSCAR_TURISMO: {
			buscarTurismo();
			break;
		}
		case BUSCAR_ALQUILER: {
			buscarAlquiler();
			break;
		}
		case MODIFICAR_CLIENTE: {
			modificarCliente();
			break;
		}
		case DEVOLVER_ALQUILER: {
			devolverAlquiler();
			break;
		}
		case BORRAR_CLIENTE: {
			borrarCliente();
			break;
		}
		case BORRAR_TURISMO: {
			borrarTurismo();
			break;
		}
		case BORRAR_ALQUILER: {
			borrarAlquiler();
			break;
		}
		case LISTAR_CLIENTES: {
			listarClientes();
			break;
		}
		case LISTAR_TURISMOS: {
			listarTurismos();
			break;
		}
		case LISTAR_ALQUILERES: {
			listarAlquileres();
			break;
		}
		case LISTAR_ALQUILERES_CLIENTE: {
			listarAlquileresCliente();
			break;
		}
		case LISTAR_ALQUILERES_TURISMO: {
			listarAlquileresTurismo();
			break;
		}
		default: {
			// Nunca se deberia llegar a este codigo, pero por si acaso aqui lo dejo
			throw new IllegalArgumentException("ERROR: Opción no valida.");
		}

		}

	}

	private void insertarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		try {
			controlador.insertarCliente(Consola.leerCliente());
			System.out.println("Cliente insertado correctamente");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		try {
			controlador.insertarTurismo(Consola.leerTurismo());
			System.out.println("Turismo insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		try {
			controlador.insertarAlquiler(Consola.leerAlquiler());
			System.out.println("Alquiler insertado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void buscarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		Cliente cliente = null;
		try {
			cliente = controlador.buscarCliente(Consola.leerClienteDni());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(cliente != null ? cliente.toString() : "No existe el cliente");
	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		Turismo turismo = null;
		try {
			turismo = controlador.buscarTurismo(Consola.leerTurismoMatricula());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(turismo != null ? turismo.toString() : "No existe el turismo");
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		Alquiler alquiler = null;
		try {
			alquiler = controlador.buscarAlquiler(Consola.leerAlquiler());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
		System.out.println(alquiler != null ? alquiler.toString() : "No existe el alquiler");
	}

	private void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");
		System.out.println("Inroduce los datos del cliente: ");
		try {
			Cliente cliente = Consola.leerCliente();
			String nombre = Consola.leerNombre();
			String telefono = Consola.leerTelefono();
			controlador.modificarCliente(cliente, nombre, telefono);
			System.out.println("Cliente modificado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");
		try {
			controlador.devolverAlquiler(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
			System.out.println("Alquiler devuelto correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		try {
			controlador.borrarCliente(Consola.leerCliente());
			System.out.println("Cliente borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo");
		try {
			controlador.borrarTurismo(Consola.leerTurismo());
			System.out.println("Turismo borrado correctamente");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler");
		try {
			controlador.borrarAlquiler(Consola.leerAlquiler());
			System.out.println("Alquiler borrado correctamente.");
		} catch (OperationNotSupportedException | IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Listado de clientes");
		controlador.listarClientes();
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Listado de turismos");
		controlador.listarTurismos();
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Listado de alquileres");
		controlador.listarAlquileres();
	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listado de alquileres del cliente");
		try {
			controlador.listarAlquileresClientes(Consola.leerCliente());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listado de alquileres del turismo");
		try {
			controlador.listarAlquileresTurismo(Consola.leerTurismo());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

}
