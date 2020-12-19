import java.util.Scanner;
/**
 * Version preliminar del Bingo por Frank Martinez 1AMT B. Falta mucho.
 * Sentiros libres de tocar cosas, lo que querais.
 * @author fmm
 *
 */

public class Operaciones {

	public static final int MAX_USU = 10;
	public static final int MAX_TABS = 10;

	static Scanner scs = new Scanner(System.in);
	static Scanner sci = new Scanner(System.in);

	public static Usuario[] inicializarUsuarios() {
		Usuario[] listaInicial;
		listaInicial = new Usuario[MAX_USU]; // maximo de usuarios
		return listaInicial;
	}

	public static Usuario[] crearUsuario(Usuario[] anteriorLista) {
		String nombre;
		int i = 0;
		double saldoInicial;
		Usuario[] nuevaLista;
		nuevaLista = new Usuario[MAX_USU];
		nuevaLista = anteriorLista;
		Usuario usu;
		while (anteriorLista[i] != null && i < MAX_USU - 1) {
			i++;
		}
		System.out.println("Introduce nuevo nombre");
		nombre = scs.nextLine();
		System.out.println("Introduce saldo inicial");
		saldoInicial = sci.nextDouble();
		usu = new Usuario(nombre, saldoInicial);
		nuevaLista[i] = usu;
		System.out.println("Usuario creado con nombre:" + usu.getNombre() + " e id: " + usu.getId());
		return nuevaLista;
	}

	public static int iniciarSesion(Usuario[] listaUsu) {
		boolean esValido = false;
		int posUsu = -1;
		String nombreUsuario;
		System.out.println("Introduzca su nombre de usuario:");
		nombreUsuario = scs.nextLine();
		for (int i = 0; i < listaUsu.length; i++) {
			if (listaUsu[i] != null) {
				if (listaUsu[i].getNombre().equals(nombreUsuario)) {
					esValido = true;
					posUsu = i;
				}
			}
		}
		if (!esValido) {
			System.out.println("Usuario no existente");
			posUsu = -1;
		}
		return posUsu;
	}

	public static Tablero[] iniciarTableros() {
		Tablero[] listaInicial;
		listaInicial = new Tablero[MAX_TABS];
		return listaInicial;
	}

	public static Tablero[] crearTablero(Tablero[] anteriorLista) {
		int i = 0;
		Tablero[] nuevaLista = new Tablero[MAX_TABS];
		nuevaLista = anteriorLista;
		Tablero tab = new Tablero();
		while (anteriorLista[i] != null && i < MAX_TABS - 1) {
			i++;
		}
		tab.rellenarAleatorio(); // se rellena al crear
		nuevaLista[i] = tab;
		System.out.println("Tablero creado con id=" + tab.getId());
		return nuevaLista;
	}

	public static void mostrarTableros(Tablero[] lista) {
		System.out.println("Tableros disponibles para jugar: ");
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != null) {
				System.out.println("Tablero n" + (i + 1) + ", id = " + lista[i].getId());
			}
		}
	}

	public static int elegirTablero(Tablero[] lista) {
		int posicion = -1;
		String tab;
		boolean esValido = false;
		mostrarTableros(lista);
		System.out.println("Introduzca el id del tablero a elegir: ");
		tab = scs.nextLine();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != null) {
				if (lista[i].getId().equals(tab)) {
					posicion = i;
					esValido = true;
				}
			}
		}
		if (!esValido) {
			System.out.println("Tablero no existente");
			posicion = -1;
		}
		return posicion;
	}
}
