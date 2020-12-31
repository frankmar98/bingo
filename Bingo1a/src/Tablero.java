/**
 * Version preliminar del Bingo por Frank Martinez 1AMT B. Falta mucho. Sentiros
 * libres de tocar cosas, lo que querais.
 * 
 * Tablero, esto es un carton del bingo, con sus propiedades, logica y
 * operaciones como rellenar
 * 
 * @author fmm
 *
 */

public class Tablero {
	public static final int DIMENX = 5;// DIMENSIONES TABLERO
	public static final int DIMENY = 5;// DIMENSIONES TABLERO
	private int[][] tablero = new int[DIMENX][DIMENY]; // array de los numeros del tablero
	private boolean[][] aciertos = new boolean[DIMENX][DIMENY]; // array de los aciertos sobre el tablero
	private String id; // id del tablero
	private int numeroBolasDeCadaNumero;
	private int maximoBola;
	private int contadorTiradas;
	private GeneradorAleatorio aleTablero;

	/**
	 * Constructor
	 * 
	 * @param tablero
	 */
	public Tablero(int maximoBola, int numeroBolasDeCadaNumero) {
		super();
		for (int i = 0; i < DIMENX; i++) { // rellenar inicialmente tablero vacio
			for (int j = 0; j < DIMENY; j++) {
				this.tablero[i][j] = 0;
				this.aciertos[i][j] = false;
			}
		}
		this.numeroBolasDeCadaNumero = numeroBolasDeCadaNumero;
		this.maximoBola = maximoBola;
		this.id = "tab" + (int) (10000 * Math.random()); // generar id
		this.aleTablero = new GeneradorAleatorio(maximoBola, 1);
	}

	/**
	 * Rellena el tablero con numeros aleatorios
	 */

	public void rellenarAleatorio() {
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				this.tablero[i][j] = aleTablero.tirar();
			}
		}
	}

	/**
	 * Muestra el tablero por consola
	 */

	public void mostrar() {
		char ch1 = '*'; // caracter separador
		for (int i = 0; i < DIMENX; i++) {
			System.out.print("" + ch1 + ch1 + ch1 + ch1);
		}
		System.out.println("" + ch1);
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				if (!aciertos[i][j]) { // numeros restantes por acertar
					System.out.print("" + ch1 + this.tablero[i][j] + ch1);
					if (this.tablero[i][j] < 10) { // numeros de una cifra no descuadran
						System.out.print("" + ch1);
					}
				} else { // numeros ya acertados tachados
					System.out.print("" + ch1 + "xx" + ch1);
				}

			}
			System.out.println("" + ch1);
		}
		for (int i = 0; i < DIMENX; i++) {
			System.out.print("" + ch1 + ch1 + ch1 + ch1);
		}
		System.out.println("" + ch1);
	}

	/**
	 * Actualiza bola tirada para el tablero y realiza comprobaciones
	 */

	public void actualizar(int bola) {
		int numero;
		boolean haAcertado = false;
		numero = bola; // tirar bola
		System.out.println("Ha salido el numero: " + numero); // informar de la tirada
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				if (numero == tablero[i][j]) {
					aciertos[i][j] = true; // actualizar matriz de aciertos
					haAcertado = true;
				}
			}
		}
		if (haAcertado) { // informar del acierto
			System.out.println("Felicidades, ha acertado el numero");
			System.out.println("Ha sido tachado con xx");
		}

		comprobarTodo(); // comprobar lineas o bingo
		contadorTiradas++;
		System.out.println("tirada n" + contadorTiradas);

	}

	/**
	 * @return the numeroBolasDeCadaNumero
	 */
	public int getNumeroBolasDeCadaNumero() {
		return numeroBolasDeCadaNumero;
	}

	/**
	 * @param numeroBolasDeCadaNumero the numeroBolasDeCadaNumero to set
	 */
	public void setNumeroBolasDeCadaNumero(int numeroBolasDeCadaNumero) {
		this.numeroBolasDeCadaNumero = numeroBolasDeCadaNumero;
	}

	/**
	 * Comprobar linea en las 2 dimensiones y bingo, informar en su caso
	 */

	public void comprobarTodo() {
		boolean lineax, lineay, bingo;
		lineax = comprobarLineaX();
		lineay = comprobarLineaY();
		bingo = comprobarBingo();
		if (lineax) {
			System.out.println("Ha sacado linea en horizontal! Felicidades!");
		}
		if (lineay) {
			System.out.println("Ha sacado linea en vertical! Felicidades!");
		}
		if (bingo) {
			System.out.println("Ha sacado BINGO!! Felicidades!");
		}

	}

	/**
	 * Comprobar linea en la dimension X
	 * 
	 * @return
	 */

	private boolean comprobarLineaX() {
		boolean esLinea = false;
		int contador = 0;
		for (int i = 0; i < DIMENX; i++) {
			contador = 0;
			for (int j = 0; j < DIMENY; j++) {
				if (aciertos[i][j]) {
					contador++;
				}
			}
			if (contador >= DIMENX) {
				esLinea = true;
			}
		}
		return esLinea;
	}

	/**
	 * Comprobar linea en la dimension Y
	 * 
	 * @return
	 */

	private boolean comprobarLineaY() {
		boolean esLinea = false;
		int contador = 0;
		for (int j = 0; j < DIMENY; j++) {
			contador = 0;
			for (int i = 0; i < DIMENX; i++) {
				if (aciertos[i][j]) {
					contador++;
				}
			}
			if (contador >= DIMENY) {
				esLinea = true;
			}
		}
		return esLinea;
	}

	/**
	 * Comprobar bingo. No se sale si hay bingo, se tiene que salir el usuario.
	 * 
	 * @return
	 */

	private boolean comprobarBingo() {
		boolean esBingo = false;
		int contador = 0;
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				if (aciertos[i][j]) {
					contador++;
				}
			}
		}
		if (contador >= DIMENX * DIMENY) {
			esBingo = true;
		}
		return esBingo;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

}
