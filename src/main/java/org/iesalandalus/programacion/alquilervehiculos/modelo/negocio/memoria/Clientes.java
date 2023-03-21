package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.IClientes;

public class Clientes implements IClientes  {
   //crear atributo coleccioneCliente tipo list//
	private List<Cliente> coleccioneCliente;
	

	public Clientes() {
		coleccioneCliente = new ArrayList<>();
	}

	
	@Override
	public List<Cliente> get() {
		return new ArrayList<Cliente>(coleccioneCliente);
	}

	@Override
	public int getCantidad() {
		return coleccioneCliente.size();
	}

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
       //metodo buscar//
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
      //metodo borrar//
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
     //metodo modificar//
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
