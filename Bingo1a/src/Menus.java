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

	Scanner sc = new Scanner(System.in);

	
	/**
	 * Inicializa el menu
	 */
	
	public void inicializar() {
		exeMenu();
	}
	
	/**
	 * Muestra un menu por consola dado su numero
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
			System.out.println("2. Jugar con un tablero");
			System.out.println("3. Jugar con todos");
			System.out.println("4. Salir");
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
	 * Gestiona la logica de los menus, por ahora con 3 niveles.
	 */

	public void exeMenu() {
		Usuario listaUsu[] = new Usuario[Operaciones.MAX_USU];
		Tablero listaTabs[] = new Tablero[Operaciones.MAX_TABS];
		int op1, op2, op3;
		int posUsu = -1;
		int posTab = -1;

		do {
			mostrarMenu(1);
			op1 = sc.nextInt();
			switch (op1) {
			case 1:
				listaUsu = Operaciones.crearUsuario(listaUsu);
				break;
			case 2:
				posUsu = Operaciones.iniciarSesion(listaUsu);
				if (posUsu > -1) {
					do {
						mostrarMenu(2);
						op2 = sc.nextInt();
						switch (op2) {
						case 1:
							listaTabs = Operaciones.crearTablero(listaTabs);
							break;
						case 2:
							posTab = Operaciones.elegirTablero(listaTabs);
							System.out.println("Tu tablero:");
							listaTabs[posTab].mostrar();
							if (posTab > -1) {
								do {
									mostrarMenu(3);
									op3 = sc.nextInt();
									switch (op3) {
									case 1:
										listaTabs[posTab].tirar();
										listaTabs[posTab].mostrar();
										break;
									default:
										System.out.println("error interno");
									}
								} while (op3 != 2);
							}
							break;
						case 3:
							do {
								mostrarMenu(3);
								op3 = sc.nextInt();
								switch (op3) {
								case 1:
									Operaciones.jugarConTodos(listaTabs);
									break;
								default:
									System.out.println("error interno");
								}
							} while (op3 != 2);
							break;
						default:
							System.out.println("Error interno");
						}
					} while (op2 != 3);
				}
				break;
			default:
				System.out.println("Saliendo");
			}
		} while (op1 != 3);

	}

}
