package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {

	private Modelo modelo;
	private Vista vista;

	public Controlador(Modelo modelo, Vista vista) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (vista == null) {
			throw new NullPointerException("ERROR: La vista no puede ser nula.");
		}

		this.modelo = modelo;
		this.vista = vista;
		this.vista.setControlador(this);

	}

	public void comenzar() {
		vista.comenzar();
		modelo.comenzar();
	}

	public void insertarCliente(Cliente cliente) throws OperationNotSupportedException {
		modelo.insertar(cliente);
	}

	public void insertarTurismo(Turismo turismo) throws OperationNotSupportedException {
		modelo.insertar(turismo);
	}

	public void insertarAlquiler(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.insertar(alquiler);
	}

	public Cliente buscarCliente(Cliente cliente) {
		return modelo.buscar(cliente);

	}

	public Turismo buscarTurismo(Turismo turismo) {
		return modelo.buscar(turismo);

	}

	public Alquiler buscarAlquiler(Alquiler alquiler) {
		return modelo.buscar(alquiler);

	}

	public void modificarCliente(Cliente cliente, String nombre, String telefono)
			throws OperationNotSupportedException {
		modelo.modificar(cliente, nombre, telefono);

	}

	public void devolverAlquiler(Alquiler leerAlquiler, LocalDate fechaDevolucion)
			throws OperationNotSupportedException {
		modelo.devolver(leerAlquiler, fechaDevolucion);

	}

	public void borrarCliente(Cliente cliente) throws OperationNotSupportedException {
		modelo.borrar(cliente);
	}

	public void borrarTurismo(Turismo turismo) throws OperationNotSupportedException {
		modelo.borrar(turismo);
	}

	public void borrarAlquiler(Alquiler alquiler) throws OperationNotSupportedException {
		modelo.borrar(alquiler);
	}

	public void listarClientes() {
		for(Cliente cliente : modelo.getClientes()) {
			System.out.println(cliente);
		}
	}

	public void listarTurismos() {
		for(Turismo turismo : modelo.getTurismos()) {
			System.out.println(turismo);
		}

	}

	public void listarAlquileres() {
		for(Alquiler alquiler : modelo.getAlquileres()) {
			System.out.println(alquiler);
		}

	}

	public void listarAlquileresClientes(Cliente cliente) {
		for(Alquiler alquiler :modelo.getAlquileres(cliente)) {
			System.out.println(alquiler);
		}

	}

	public void listarAlquileresTurismo(Turismo turismo) {
		for(Alquiler alquiler : modelo.getAlquileres(turismo)) {
			System.out.println(alquiler);
		}

	}

}
