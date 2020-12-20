import java.util.Scanner;

/**
 * Version preliminar del Bingo por Frank Martinez 1AMT B. Falta mucho. Sentiros
 * libres de tocar cosas, lo que querais.
 * 
 * Clase con metodos estaticos para realizar operaciones sobre los tableros y
 * usuarios instanciados
 * 
 * @author fmm
 *
 */

public class Operaciones {

	public static final int MAX_USU = 10; // maximo usuarios
	public static final int MAX_TABS = 10; // maximo tableros

	static Scanner scs = new Scanner(System.in); // para cadenas
	static Scanner sci = new Scanner(System.in); // para numeros

	/**
	 * Inicializa la lista de usuarios
	 * 
	 * @return
	 */
	public static Usuario[] inicializarUsuarios() {
		Usuario[] listaInicial;
		listaInicial = new Usuario[MAX_USU];
		return listaInicial;
	}

	/**
	 * Actualiza la lista de usuarios creando uno nuevo
	 * 
	 * @param anteriorLista
	 * @return
	 */
	public static Usuario[] crearUsuario(Usuario[] anteriorLista) {
		String nombre;
		int i = 0;
		double saldoInicial;
		Usuario[] nuevaLista;
		nuevaLista = new Usuario[MAX_USU];
		nuevaLista = anteriorLista;
		Usuario usu;
		while (anteriorLista[i] != null && i < MAX_USU - 1) {
			i++; // contador para insertar el nuevo usuario en esta posicion
		}
		System.out.println("Introduce nuevo nombre");
		nombre = scs.nextLine();
		System.out.println("Introduce saldo inicial");
		saldoInicial = sci.nextDouble();
		usu = new Usuario(nombre, saldoInicial); // creacion usuario
		nuevaLista[i] = usu; // insercion usuario en la lista
		System.out.println("Usuario creado con nombre:" + usu.getNombre() + " e id: " + usu.getId());
		return nuevaLista;
	}

	/**
	 * Iniciar sesion con un usuario ya creado, devuelve su posicion en la lista
	 * 
	 * @param listaUsu
	 * @return
	 */

	public static int iniciarSesion(Usuario[] listaUsu) {
		boolean esValido = false;
		int posUsu = -1;
		String nombreUsuario;
		System.out.println("Introduzca su nombre de usuario:");
		nombreUsuario = scs.nextLine();
		for (int i = 0; i < listaUsu.length; i++) { //busqueda secuencial
			if (listaUsu[i] != null) { // iterar hasta donde la lista este llena
				if (listaUsu[i].getNombre().equals(nombreUsuario)) {
					esValido = true;
					posUsu = i;
				}
			}
		}
		if (!esValido) { //no existe el usuario introducido por teclado
			System.out.println("Usuario no existente");
			posUsu = -1;
		}
		return posUsu;
	}
	
	/**
	 * Inicializa la lista de tableros
	 * @return
	 */

	public static Tablero[] iniciarTableros() {
		Tablero[] listaInicial;
		listaInicial = new Tablero[MAX_TABS];
		return listaInicial;
	}
	
	/**
	 * Actualiza la lista de tableros insertando uno nuevo
	 * @param anteriorLista
	 * @return
	 */

	public static Tablero[] crearTablero(Tablero[] anteriorLista) {
		int i = 0;
		Tablero[] nuevaLista = new Tablero[MAX_TABS];
		nuevaLista = anteriorLista;
		Tablero tab = new Tablero(90,1); //bolas entre 0-90 repetidas 1 vez
		while (anteriorLista[i] != null && i < MAX_TABS - 1) {
			i++; //contador para insertar el nuevo tablero en esta posicion
		}
		tab.rellenarAleatorio(); // se rellena al crear
		nuevaLista[i] = tab; //insercion del tablero en la lista
		System.out.println("Tablero creado con id=" + tab.getId());
		return nuevaLista;
	}
	
	/**
	 * Muestra los tableros existentes y su id por consola
	 * @param lista
	 */

	public static void mostrarTableros(Tablero[] lista) {
		System.out.println("Tableros disponibles para jugar: ");
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != null) {
				System.out.println("Tablero n" + (i + 1) + ", id = " + lista[i].getId());
			}
		}
	}
	
	/**
	 * Permite elegir un tablero introduciendo su id
	 * @param lista
	 * @return
	 */

	public static int elegirTablero(Tablero[] lista) {
		int posicion = -1;
		String tab;
		boolean esValido = false;
		mostrarTableros(lista); //primero los muestra
		System.out.println("Introduzca el id del tablero a elegir: ");
		tab = scs.nextLine(); //tablero elegido
		for (int i = 0; i < lista.length; i++) { //busqueda secuencial
			if (lista[i] != null) { //iterar hasta donde la lista este llena
				if (lista[i].getId().equals(tab)) {
					posicion = i;
					esValido = true;
				}
			}
		}
		if (!esValido) { //no existe el tablero introducido
			System.out.println("Tablero no existente");
			posicion = -1;
		}
		return posicion;
	}
}
