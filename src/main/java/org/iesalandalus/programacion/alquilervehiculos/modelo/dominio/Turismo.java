package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;



public class Turismo extends Vehiculo {
	private static final int FACTOR_CILINDRADA=10;
	private int cilindrada;
	//constructores
	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		super(marca,modelo,matricula);
		
		setCilindrada(cilindrada);
	}

	public Turismo(Turismo turismo) {
		super(turismo);
		if(turismo==null) {
			throw new NullPointerException("sjdsfhgsf");
		}
		
	
		cilindrada = turismo.getCilindrada();
		
	}
    public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada <1 || cilindrada > 5000) {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}
	@Override
	public int getFactorPrecio() {
		return cilindrada/FACTOR_CILINDRADA;
		
	}
	//to string//
	@Override
	public String toString() {
		return String.format("%s %s (%d cc) - %s" , getMarca() , getModelo(), cilindrada, getMatricula() );
	}

}

