	package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;
	
	import java.util.Objects;
	
	public class Cliente {
	//expresiones regulares//

		private static final String ER_NOMBRE = "[A-ZÁÉÍÓÚÜÑ][a-záéíóúÜñ]+([ ][A-ZÁÉÍÓÚÜÑ][a-záéíóúñúñ]+)*";
		private static final String ER_DNI = "\\d{8}[A-Z]";
		private static final String ER_TELEFONO = "[6-9]\\d{8}";
	
		private String nombre;
		private String dni;
		private String telefono;
		//Constructor con parametro
		public Cliente(String nombre, String dni, String telefono) {
			setNombre(nombre);
			setDni(dni);
			setTelefono(telefono);
		}
		//constructor copia

		public Cliente(Cliente cliente) {
			if (cliente == null) {
				throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
			}
			nombre = cliente.getNombre();
			dni = cliente.getDni();
			telefono = cliente.getTelefono();
		}
	
		public String getNombre() {
			return nombre;
		}
	
		public void setNombre(String nombre) {
			if (nombre == null) {
				throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
			}
			if (!nombre.matches(ER_NOMBRE)) {
				throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
			}
			this.nombre = nombre;
		}
	
		public String getDni() {
			return dni;
		}
	
		private void setDni(String dni) {
			if (dni == null) {
				throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
			}
			if (!dni.matches(ER_DNI)) {
				throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
			}
			if (comprobarLetraDni(dni) == false) {
				throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
			}
			this.dni = dni;
		}
	
		private boolean comprobarLetraDni(String dni) {
			boolean letraCorrecta = false;
			char[] letrasDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
					'H', 'L', 'C', 'K', 'E' };
			//primero sacamos la letra desde el array
			char letraDni = dni.charAt(8); 
			//segundo sacamos los numeros con el substring ("12345678")
			String numeroDniString = dni.substring(0, 8); 
			//cambiamos los numeros de String a integer utilizando pareseInt (12345678)
			int numeroDni = Integer.parseInt(numeroDniString); 
			//sacamos el resto del numero del dni dividido por 23 como dice la regla del dni
			int posicion = numeroDni%23;
			//cogemos la letra que coincide con el resto
			if (letrasDni[posicion] == letraDni ) {
				letraCorrecta = true;
			}
			return letraCorrecta;
	
		}
	
		public String getTelefono() {
			return telefono;
		}
	
		public void setTelefono(String telefono) {
			if (telefono == null) {
				throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
			}
			if (!telefono.matches(ER_TELEFONO)) {
				throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
			}
			this.telefono = telefono;
		}
	
		public static Cliente getClienteConDni(String dni) {
			return new Cliente("Bob Esponja", dni, "950112233");
		}
	    // hashcode y equals se basan sobre el dni
		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			return Objects.equals(dni, other.dni);
		}
	   // toString
		@Override
		public String toString() {
			return String.format("%s - %s (%s)", nombre, dni, telefono);
		}
	
	}