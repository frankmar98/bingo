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
	
	private static GeneradorAleatorio aleTodos = new GeneradorAleatorio(90, 1);

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
	public static Usuario[] crearUsuario(Usuario[] usuarios) {
		String nombre;
		int i = 0;
		double saldoInicial;
		Usuario usu;
		while (usuarios[i] != null && i < MAX_USU - 1) {
			i++; // contador para insertar el nuevo usuario en esta posicion
		}
		System.out.println("Introduce nuevo nombre");
		nombre = scs.nextLine();
		System.out.println("Introduce saldo inicial");
		saldoInicial = sci.nextDouble();
		usu = new Usuario(nombre, saldoInicial); // creacion usuario
		usuarios[i] = usu; // insercion usuario en la lista
		System.out.println("Usuario creado con nombre: " + usu.getNombre() + " e id: " + usu.getId());
		return usuarios;
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
		for (int i = 0; i < listaUsu.length; i++) { // busqueda secuencial
			if (listaUsu[i] != null && listaUsu[i].getNombre().equals(nombreUsuario)) {
				esValido = true;
				posUsu = i;
			}
		}
		if (!esValido) { // no existe el usuario introducido por teclado
			System.out.println("Usuario no existente");
			posUsu = -1;
		}
		return posUsu;
	}

	/**
	 * Inicializa la lista de tableros
	 * 
	 * @return
	 */

	public static Tablero[] iniciarTableros() {
		Tablero[] listaInicial;
		listaInicial = new Tablero[MAX_TABS];
		return listaInicial;
	}

	/**
	 * Actualiza la lista de tableros insertando uno nuevo
	 * 
	 * @param anteriorLista
	 * @return
	 */

	public static Tablero[] crearTablero(Tablero[] tableros) {
		int i = 0;
		Tablero tab = new Tablero(90, 1); // bolas entre 0-90 repetidas 1 vez
		while (tableros[i] != null && i < MAX_TABS - 1) {
			i++; // contador para insertar el nuevo tablero en esta posicion
		}
		tab.rellenarAleatorio(); // se rellena al crear
		tableros[i] = tab; // insercion del tablero en la lista
		System.out.println("Tablero creado con id=" + tab.getId());
		return tableros;
	}

	/**
	 * Muestra los tableros existentes y su id por consola
	 * 
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
	 * Tira la misma bola para todos los tableros creados
	 * @param tableros
	 */

	public static void jugar(Tablero[] tableros) {
		int bola;
		bola = aleTodos.tirar(); // generar numero aleatorio controlando no se repita
		for (int i = 0; i < tableros.length; i++) {
			if (tableros[i] != null) { // iterar hasta donde la lista este llena
				tableros[i].actualizar(bola);
				tableros[i].mostrar();
			}
		}
	}
}
