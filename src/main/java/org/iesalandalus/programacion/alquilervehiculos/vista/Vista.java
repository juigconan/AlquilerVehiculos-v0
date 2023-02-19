package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.modelo.controlador.Controlador;

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
		// TODO Auto-generated method stub
		
	}

	private void insertarTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void insertarAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void buscarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void buscarTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void buscarAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void modificarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void devolverAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void borrarCliente() {
		// TODO Auto-generated method stub
		
	}

	private void borrarTurismo() {
		// TODO Auto-generated method stub
		
	}

	private void borrarAlquiler() {
		// TODO Auto-generated method stub
		
	}

	private void listarClientes() {
		// TODO Auto-generated method stub
		
	}

	private void listarTurismos() {
		// TODO Auto-generated method stub
		
	}

	private void listarAlquileres() {
		// TODO Auto-generated method stub
		
	}

	private void listarAlquileresCliente() {
		// TODO Auto-generated method stub
		
	}

	private void listarAlquileresTurismo() {
		// TODO Auto-generated method stub
		
	}

}
