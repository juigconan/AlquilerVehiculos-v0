package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
		StringBuilder subrayado = new StringBuilder();
		for (int i = 0; i < mensaje.length(); i++) {
			subrayado.append("-");
		}
		System.out.println(subrayado);
	}

	public static void mostrarMenu() {
		for (Opcion opcion : Opcion.values()) {
			if (opcion.ordinal() != 0) {
				System.out.println(opcion.toString());
			}
		}
		System.out.println(Opcion.SALIR.toString());
	}

	private static String leerCadena(String mensaje) {
		System.out.printf("Introduce %s", mensaje);
		return Entrada.cadena();
	}

	private static int leerEntero(String mensaje) {
		System.out.printf("Introduce %s", mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		System.out.printf("Introduce %s (%s)", mensaje, PATRON_FECHA);
		return LocalDate.parse(Entrada.cadena(), FORMATO_FECHA);
	}

	public static Opcion elegirOpcion() {
		Opcion opcion = null;
		do {
			int indice = leerEntero("la opcion deseada:");
			try {
				opcion = Opcion.get(indice);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (opcion == null);

		return opcion;
	}

	public static Cliente leerCliente() {

		Cliente cliente = null;
		do {
			try {
				cliente = new Cliente(leerNombre(), leerCadena("el dni del cliente:"), leerTelefono());
			} catch (Exception e) {
				System.out.println("ERROR: algún parametro no es válido.");
			}
		} while (cliente == null);

		return cliente;
	}

	public static Cliente leerClienteDni() {
		Cliente cliente = null;
		do {
			String dni = leerCadena("el dni del cliente:");

			try {
				cliente = Cliente.getClienteConDni(dni);
			} catch (Exception e) {
				System.out.println("ERROR: El DNI no es válido.");
			}
		} while (cliente == null);

		return cliente;
	}

	public static String leerNombre() {
		return leerCadena("el nombre del cliente:");
	}

	public static String leerTelefono() {
		return leerCadena("el telefono del cliente:");
	}

	public static Turismo leerTurismo() {

		Turismo turismo = null;
		do {
			try {
				turismo = new Turismo(leerCadena("la marca del turismo:"), leerCadena("el modelo del turismo:"),
						leerEntero("la cilindrada del turismo:"), leerCadena("la matricula del turismo:"));
			} catch (Exception e) {
				System.out.println("ERROR: algún parametro no es válido.");
			}
		} while (turismo == null);

		return turismo;
	}
	
	public static Turismo turismoMatricula() {
		Turismo turismo = null;
		do {
			try {
				turismo = Turismo.getTurismoConMatricula(leerCadena("la matricula del turismo:"));
			} catch (Exception e) {
				System.out.println("ERROR: La matricula no es válida.");
			}
		} while (turismo == null);

		return turismo;
	}
	
	public static Alquiler leerAlquiler() {
		Alquiler alquiler = null;
		do {
			try {
				alquiler = new Alquiler(leerCliente(),leerTurismo(),leerFecha("la fecha del alquiler:"));
			} catch (Exception e) {
				System.out.println("ERROR: algún parametro no es válido.");
			}
		} while (alquiler == null);

		return alquiler;
	}
	
	public static LocalDate leerFechaDevolucion() {
		return leerFecha("la fecha de devolución:");
	}

}
