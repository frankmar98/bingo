import java.util.Scanner;

/**
 * Version preliminar del Bingo por Frank Martinez 1AMT B. Falta mucho. Sentiros
 * libres de tocar cosas, lo que querais.
 * 
 * Clase Menus. Gestiona los menus por consola y su logica, por ahora con 3
 * niveles de menu
 * 
 * @author fmm
 *
 */
public class Menus {

	Scanner sc = new Scanner(System.in); // para seleccionar opciones en los distintos metodos

	Usuario listaUsu[] = new Usuario[Operaciones.MAX_USU]; // todos los usuarios
	Tablero listaTabs[] = new Tablero[Operaciones.MAX_TABS]; // todos los tableros

	int posUsu = -1; // indice ultimo usuario
	int posTab = -1; // indice ultimo tablero

	/**
	 * Inicializa el menu
	 */

	public void inicializar() {
		listaTabs = Operaciones.iniciarTableros();
		listaUsu = Operaciones.inicializarUsuarios();
		menuNivel1a();
	}

	/**
	 * Muestra un menu por consola dado su numero
	 * 
	 * @param nmenu
	 */

	public void mostrarMenu(int nmenu) {

		switch (nmenu) {
		case 1:
			System.out.println("Bienvenido al Bingo");
			System.out.println("Introduzca su opcion a elegir");
			System.out.println("1. Crear usuario");
			System.out.println("2. Iniciar sesion");
			System.out.println("3. Salir");
			break;
		case 2:
			System.out.println("Bienvenido a su sesion");
			System.out.println("Introduzca la opcion a elegir");
			System.out.println("1. Generar nuevo tablero");
			System.out.println("2. Jugar con todos los tableros");
			System.out.println("3. Salir");
			break;
		case 3:
			System.out.println("A jugar!!");
			System.out.println("1. Lanzar bola");
			System.out.println("2. Salir");
			break;
		default:
			System.out.println("Error interno");
		}

	}

	/**
	 * Menu de 1er nivel. Gestionar usuarios y login.
	 */

	private void menuNivel1a() {
		int op; // opcion menu

		do {
			mostrarMenu(1);
			op = sc.nextInt();
			switch (op) {
			case 1:
				listaUsu = Operaciones.crearUsuario(listaUsu);
				break;
			case 2:
				posUsu = Operaciones.iniciarSesion(listaUsu);
				if (posUsu > -1) {
					menuNivel2a();
				} else {
					System.out.println("No existe el usuario");
				}
				break;
			case 3:
				System.out.println("Salida satisfactoria");
				break;
			default:
				System.out.println("Error interno");
			}

		} while (op != 3);
	}

	/**
	 * Menu de 2o nivel. Gestionar tableros.
	 */

	private void menuNivel2a() {
		int op; // opcion menu
		do {
			mostrarMenu(2);
			op = sc.nextInt();
			switch (op) {
			case 1:
				listaTabs = Operaciones.crearTablero(listaTabs);
				break;
			case 2:
				menuNivel3a();
				break;
			case 3:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Error interno");
			}
		} while (op != 3);
	}

	/**
	 * Menu de 3er nivel. Jugar con un tablero
	 */

	private void menuNivel3a() {
		int op; // opcion menu
		do {
			mostrarMenu(3);
			op = sc.nextInt();
			switch (op) {
			case 1:
				Operaciones.jugar(listaTabs);
				Operaciones.mostrarTableros(listaTabs);
				break;
			case 2:
				System.out.println("Saliendo");
				break;
			default:
				System.out.println("Error interno");
			}
		} while (op != 2);
	}
}
