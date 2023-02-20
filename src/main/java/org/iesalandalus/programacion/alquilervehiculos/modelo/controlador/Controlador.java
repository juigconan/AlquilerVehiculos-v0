package org.iesalandalus.programacion.alquilervehiculos.modelo.controlador;

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

	public void devolverAlquiler(Alquiler alquiler) {
		// TODO Auto-generated method stub

	}

	public void borrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	public void borrarTurismo(Turismo turismo) {
		// TODO Auto-generated method stub

	}

	public void borrarAlquiler(Alquiler alquiler) {
		// TODO Auto-generated method stub

	}

	public void listarClientes() {
		// TODO Auto-generated method stub

	}

	public void listarTurismos() {
		// TODO Auto-generated method stub

	}

	public void listarAlquileres() {
		// TODO Auto-generated method stub

	}

	public void listarAlquileresClientes(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	public void listarAlquileresTurismo(Turismo turismo) {
		// TODO Auto-generated method stub

	}

}
