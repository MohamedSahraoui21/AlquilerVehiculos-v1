package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes  {
   //crear atributo coleccioneCliente tipo list//
	private List<Cliente> coleccioneCliente;
	
    //constructor por defecto que crea el arraylist

	public Clientes() {
		coleccioneCliente = new ArrayList<>();
	}

	
	@Override
	public List<Cliente> get() {
		return new ArrayList<Cliente>(coleccioneCliente);
	}
    //voy a utlizar un metodo de arraylist (.size) para saber la cantidad de una lista

	@Override
	public int getCantidad() {
		return coleccioneCliente.size();
	}
    //voy a utlizar un metodo de arraylist (.Add) para añadir un valor a la lista

	@Override
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}

		coleccioneCliente.add(cliente);
	}
    //voy a utlizar un metodo de Arraylist (.get) para buscar un valor en la lista
	@Override
	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		if (coleccioneCliente.contains(cliente)) {
			return cliente;
		}
		return null;
	}
	   //voy a utilizar un metodo de arraylist (.remove) para borrar un elemento de la lista
	@Override
	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (!coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}
		coleccioneCliente.remove(cliente);
	}
    // voy a utilizar un metodo de Arraylist (.set()) para modificar una lista
	@Override
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {

		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}
		if (!coleccioneCliente.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		} else {
			if (nombre != null && !nombre.trim().isEmpty()) {
				cliente.setNombre(nombre);
			}

			if (telefono != null && !telefono.trim().isEmpty()) {
				cliente.setTelefono(telefono);
			}
		}

	}

}
