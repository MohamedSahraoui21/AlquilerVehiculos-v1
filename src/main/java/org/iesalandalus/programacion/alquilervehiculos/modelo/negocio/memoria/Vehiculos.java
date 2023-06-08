package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;


import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IVehiculos;

public class Vehiculos implements IVehiculos {
	

	private List<Vehiculo> coleccionVehiculos;
    //constructor por defecto que crea el arraylist

	public Vehiculos() {
		coleccionVehiculos = new ArrayList<>();
	}

	@Override
	public List<Vehiculo> get() {
		return coleccionVehiculos;
	}
    //voy a utlizar un metodo de arraylist (.size) para saber la cantidad de una lista

	@Override
	public int getCantidad() {
		return coleccionVehiculos.size();
	} 
	//crear metodo insertar voy a utlizar un metodo de arraylist (.Add) para añadir un valor a la lista

	

	@Override
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un vehículo nulo.");
		}

		if (coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un vehículo con esa matrícula.");
		}
		coleccionVehiculos.add(vehiculo);
	}
    //voy a utlizar un metodo de Arraylist (.get) para buscar un valor en la lista
	@Override
	public Vehiculo buscar(Vehiculo vehiculo) {
		Vehiculo vehiculoEncontrado;
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un vehículo nulo.");
		}

		int indice = coleccionVehiculos.indexOf(vehiculo);
		if (indice != -1) {
			vehiculoEncontrado = coleccionVehiculos.get(indice);
		} else {
			vehiculoEncontrado = null;
		}
		return vehiculoEncontrado;
	}
	   //voy a utilizar un metodo de arraylist (.remove) para borrar un elemento de la lista
	@Override
	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un vehículo nulo.");
		}
		if (!coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún vehículo con esa matrícula.");
		}
		coleccionVehiculos.remove(vehiculo);
	}

}
