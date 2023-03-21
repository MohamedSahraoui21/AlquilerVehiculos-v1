package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {
//Aqui no he creado todas las clases de la tarea pero asi seria la clase Main si tenemos todas las clases hechas
	public static void main(String[] args) {
		
		Modelo modelo=new Modelo();
		Vista vista=new Vista();
		Controlador controlador= new Controlador (modelo,vista);
		controlador.comenzar();
	}

	
}
