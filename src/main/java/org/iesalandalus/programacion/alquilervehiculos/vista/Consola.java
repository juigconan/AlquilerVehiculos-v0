package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Consola() {
		
	}
	
	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
		StringBuilder subrayado = new StringBuilder();
		for(int i = 0; i < mensaje.length();i++) {
			subrayado.append("-");
		}
		System.out.println(subrayado);
	}
	
	public static void mostrarMenu() {
		for(Opcion opcion : Opcion.values()) {
			if(opcion.ordinal() != 0) {		
			System.out.println(opcion.toString());
			}
		}
		System.out.println(Opcion.SALIR.toString());
	}
	
	private static String leerCadena(String mensaje) {
		System.out.printf("Introduce %s",mensaje);
		return Entrada.cadena();
	}
	
	private static int leerEntero(String mensaje) {
		System.out.printf("Introduce %s",mensaje);
		return Entrada.entero();
	}
	
	private static LocalDate leerFecha(String mensaje) {
		System.out.printf("Introduce %s (%s)",mensaje, PATRON_FECHA);
		return LocalDate.parse(Entrada.cadena(),FORMATO_FECHA);
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
			}while(opcion == null);
	
		return opcion;
	}
	
	
	public static void main(String[] args) {
		mostrarMenu();
		elegirOpcion();
	}
	
}
