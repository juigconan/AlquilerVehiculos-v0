package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;

	public void comenzar() {
		clientes = new Clientes();
		alquileres = new Alquileres();
		turismos = new Turismos();
	}

	public void terminar() {
		System.out.print("El modelo ha terminado");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		turismos.insertar(new Turismo(turismo));

	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.insertar(new Alquiler(alquiler));
	}

	public Cliente buscar(Cliente cliente) {
		return new Cliente(clientes.buscar(cliente));
	}

	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(alquileres.buscar(alquiler));
	}

	public Turismo buscar(Turismo turismo) {
		return new Turismo(turismos.buscar(turismo));
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		Alquiler alquilerBuscado = alquileres.buscar(alquiler);
		alquilerBuscado.devolver(fechaDevolucion);
		
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(cliente)) {
			alquileres.borrar(alquiler);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		for (Alquiler alquiler : alquileres.get(turismo)) {
			alquileres.borrar(alquiler);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> listaADevolver = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaADevolver.add(new Cliente(cliente));
		}
		return listaADevolver;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaADevolver = new ArrayList<>();
		for (Turismo turismo : turismos.get()) {
			listaADevolver.add(new Turismo(turismo));
		}
		return listaADevolver;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaADevolver = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaADevolver.add(new Alquiler(alquiler));
		}
		return listaADevolver;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		List<Alquiler> listaADevolver = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler.getCliente().equals(cliente)) {
				listaADevolver.add(new Alquiler(alquiler));
			}
		}
		return listaADevolver;
	}
	
	public List<Alquiler> getAlquileres(Turismo turismo) {
		List<Alquiler> listaADevolver = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			if (alquiler.getTurismo().equals(turismo)) {
				listaADevolver.add(new Alquiler(alquiler));
			}
		}
		return listaADevolver;
	}

}
