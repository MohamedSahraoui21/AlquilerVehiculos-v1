package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IAlquileres;


public class Alquileres implements IAlquileres  {

	 //crear atributo de tipo list//


	private List<Alquiler> coleccionAlquileres;
    //constructor por defecto que crea el arraylist

	public Alquileres() {
		coleccionAlquileres = new ArrayList<>();
	}

	@Override
	public List<Alquiler> get() {
		return new ArrayList<Alquiler>(coleccionAlquileres);
	}

	public List<Alquiler> get(Cliente cliente) {

		List<Alquiler> alquileresCl = new ArrayList<Alquiler>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getCliente().equals(cliente)) {
				alquileresCl.add(alquiler);
			}
		}
		return alquileresCl;
	}
    //voy a utlizar un metodo de arraylist (.Add)

	@Override
	public List<Alquiler> get(Vehiculo vehiculo) {
		List<Alquiler> alquileresVeh = new ArrayList<>();
		for (Alquiler alquiler : coleccionAlquileres) {
			if (alquiler.getVehiculo().equals(vehiculo)) {
				alquileresVeh.add(alquiler);
			}
		}
		return alquileresVeh;
	}

    //voy a utlizar un metodo de arraylist (.size) para saber la cantidad de una lista

	@Override
	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	// metodo insertar//

	@Override
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(), alquiler.getVehiculo(), alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}

	private void comprobarAlquiler(Cliente cliente, Vehiculo vehiculo, LocalDate fechaAlquiler)
			throws OperationNotSupportedException {

		for (Alquiler alquiler : get(cliente)) {

			if (alquiler.getFechaDevolucion() == null) {
				throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
			}
			if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
				throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
			}
		}
		// comprobar el alquiler si esta todavia sin devolver o posterior //

		for (Alquiler alquiler : get(vehiculo)) {
			if (alquiler.getFechaDevolucion() == null) {
				throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
			}
			if (alquiler.getFechaDevolucion().isAfter(fechaAlquiler) || alquiler.getFechaDevolucion().isEqual(fechaAlquiler)) {
				throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
			}
		}

	}
	
	private Alquiler getAlquilerAbierto(Cliente cliente) {
		Iterator<Alquiler> iteradorCliente = get(cliente).iterator();
		Alquiler alquilerAbierto = null;
		while (iteradorCliente.hasNext()) {
			Alquiler alquiler=iteradorCliente.next();
			if(alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion()==null) {
				alquilerAbierto = alquiler;
			}
		}
		return alquilerAbierto;
	}
	
	@Override
	public void devolver(Cliente cliente, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler de un cliente nulo.");
		}
		if (getAlquilerAbierto(cliente) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler abierto para ese cliente.");
		}
		getAlquilerAbierto(cliente).devolver(fechaDevolucion);
	}
	
	private Alquiler getAlquilerAbierto(Vehiculo vehiculo) {
		Iterator<Alquiler> iteradorVehiculo = get(vehiculo).iterator();
		Alquiler alquilerAbierto = null;
		while (iteradorVehiculo.hasNext()) {
			Alquiler alquiler=iteradorVehiculo.next();
			if(alquiler.getVehiculo().equals(vehiculo) && alquiler.getFechaDevolucion()==null) {
				alquilerAbierto = alquiler;
			}
		}
		return alquilerAbierto;
	}
	
	
	@Override
	public void devolver(Vehiculo vehiculo, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (vehiculo== null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler de un vehículo nulo.");
		}
		if (getAlquilerAbierto(vehiculo) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler abierto para ese vehículo.");
		}
		getAlquilerAbierto(vehiculo).devolver(fechaDevolucion);

	}
	
	   //voy a utilizar un metodo de arraylist (.remove) para borrar un elemento de la lista

	@Override
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		coleccionAlquileres.remove(alquiler);
	}
	
    // voy a ultilizar un metodo de ArrayList para buscar un valor en la lista utilizar (.get())

	@Override
	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		if (coleccionAlquileres.contains(alquiler)) {
			return alquiler;
		}
		return null;
	}

	
          
}