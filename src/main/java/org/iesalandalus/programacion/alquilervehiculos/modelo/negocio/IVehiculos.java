package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public interface IVehiculos {

	List<Vehiculo> get();

	int getCantidad();
	//crear metodo insertar//

	void insertar(Vehiculo vehiculo) throws OperationNotSupportedException;

	//crear metodo buscar//
	Vehiculo buscar(Vehiculo vehiculo);

	//crear metodo borrar//
	void borrar(Vehiculo vehiculo) throws OperationNotSupportedException;

}