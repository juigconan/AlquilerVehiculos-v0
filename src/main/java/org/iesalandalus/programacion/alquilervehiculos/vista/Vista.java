package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.controlador.Controlador;
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
		}
		case INSERTAR_CLIENTE: {
			insertarCliente();
		}
		case INSERTAR_TURISMO: {
			insertarTurismo();
		}
		case INSERTAR_ALQUILER: {
			insertarAlquiler();
		}
		case BUSCAR_CLIENTE: {
			buscarCliente();
		}
		case BUSCAR_TURISMO: {
			buscarTurismo();
		}
		case BUSCAR_ALQUILER: {
			buscarAlquiler();
		}
		case MODIFICAR_CLIENTE: {
			modificarCliente();
		}
		case DEVOLVER_ALQUILER: {
			devolverAlquiler();
		}
		case BORRAR_CLIENTE: {
			borrarCliente();
		}
		case BORRAR_TURISMO: {
			borrarTurismo();
		}
		case BORRAR_ALQUILER: {
			borrarAlquiler();
		}
		case LISTAR_CLIENTES: {
			listarClientes();
		}
		case LISTAR_TURISMOS: {
			listarTurismos();
		}
		case LISTAR_ALQUILERES: {
			listarAlquileres();
		}
		case LISTAR_ALQUILERES_CLIENTE: {
			listarAlquileresCliente();
		}
		case LISTAR_ALQUILERES_TURISMO: {
			listarAlquileresTurismo();
		}

		}

	}

	private void insertarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		try {
			controlador.insertarCliente(Consola.leerCliente());
			System.out.println("Cliente insertado correctamente");
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void insertarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		try {
			controlador.insertarTurismo(Consola.leerTurismo());
			System.out.println("Turismo insertado correctamente.");
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		try {
			controlador.insertarAlquiler(Consola.leerAlquiler());
			System.out.println("Alquiler insertado correctamente.");
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void buscarCliente() {
		Consola.mostrarCabecera("Insertar cliente");
		controlador.buscarCliente(Consola.leerCliente());
	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("Insertar turismo");
		controlador.buscarTurismo(Consola.leerTurismo());
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("Insertar alquiler");
		controlador.buscarAlquiler(Consola.leerAlquiler());
	}

	private void modificarCliente() {
		Consola.mostrarCabecera("Modificar cliente");
		controlador.modificarCliente(Consola.leerCliente());
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler");
		controlador.devolverAlquiler(Consola.leerAlquiler());
	}

	private void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente");
		controlador.borrarCliente(Consola.leerCliente());
	}
	

	private void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo");
		controlador.borrarTurismo(Consola.leerTurismo());
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler");
		controlador.borrarAlquiler(Consola.leerAlquiler());
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
		controlador.listarAlquileresClientes(Consola.leerCliente());
		
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Listado de alquileres del turismo");
		controlador.listarAlquileresTurismo(Consola.leerTurismo());
	}

}
