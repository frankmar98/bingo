/**
 * Version preliminar del Bingo por Frank Martinez 1AMT B. Falta mucho.
 * Sentiros libres de tocar cosas, lo que querais.
 * @author fmm
 *
 */



public class Tablero {
	public static final int DIMENX = 5;// DIMENSIONES TABLERO
	public static final int DIMENY = 5;// DIMENSIONES TABLERO
	public static final int MAXBOLA = 91;// maximo numero que puede salir en la bola +1
	private int[][] tablero = new int[DIMENX][DIMENY];
	private boolean[][] aciertos = new boolean[DIMENX][DIMENY];
	private String id = "0";

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param tablero
	 */
	public Tablero() {
		super();
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				this.tablero[i][j] = 0;
				this.aciertos[i][j] = false;
			}
		}
		this.id = "tab" + (int) (10000 * Math.random());
	}

	public void rellenarAleatorio() {
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				this.tablero[i][j] = (int) (MAXBOLA * Math.random());
			}
		}
	}

	public void mostrar() {
		char ch1 = '*';
		System.out.print("" + ch1);
		for (int i = 0; i < DIMENX; i++) {
			System.out.print("" + ch1 + ch1 + ch1 + ch1);
		}
		System.out.println("" + ch1);
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				if (!aciertos[i][j]) {
					System.out.print("" + ch1 + this.tablero[i][j] + ch1);
				} else {
					System.out.print("" + ch1 + "xx" + ch1);
				}

			}
			System.out.println("" + ch1);
		}
	}

	public void tirar() {
		int numero;
		boolean haAcertado = false;
		numero = (int) (MAXBOLA * Math.random());
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				if (numero == tablero[i][j]) {
					aciertos[i][j] = true;
					haAcertado = true;
				}
			}
		}
		if (haAcertado) {
			System.out.println("Felicidades, ha acertado el numero " + numero);
			System.out.println("Ha sido tachado con xx");
		}
		
		comprobarTodo();

	}

	public void comprobarTodo() {
		boolean lineax, lineay, bingo;
		lineax = comprobarLineaX();
		lineay = comprobarLineaY();
		bingo = comprobarBingo();
		if (lineax) {
			System.out.println("Ha sacado linea! Felicidades!");
		}
		if (lineay) {
			System.out.println("Ha sacado linea! Felicidades!");
		}
		if (bingo) {
			System.out.println("Ha sacado BINGO!! Felidades!");
		}

	}

	public boolean comprobarLineaX() {
		boolean esLinea = false;
		int contador = 0;
		for (int i = 0; i < DIMENX; i++) {
			contador = 0;
			for (int j = 0; j < DIMENY; j++) {
				if (aciertos[i][j]) {
					contador++;
				}
			}
		}
		if (contador >= DIMENX - 1) {
			esLinea = true;
		}
		return esLinea;
	}

	public boolean comprobarLineaY() {
		boolean esLinea = false;
		int contador = 0;
		for (int i = 0; i < DIMENY; i++) {
			contador = 0;
			for (int j = 0; j < DIMENX; j++) {
				if (aciertos[j][i]) {
					contador++;
				}
			}
		}
		if (contador >= DIMENY - 1) {
			esLinea = true;
		}
		return esLinea;
	}

	public boolean comprobarBingo() {
		boolean esBingo = false;
		int contador = 0;
		for (int i = 0; i < DIMENX; i++) {
			for (int j = 0; j < DIMENY; j++) {
				if (aciertos[i][j]) {
					contador++;
				}
			}
		}
		if (contador >= (DIMENX * DIMENY) - 1) {
			esBingo = true;
		}
		return esBingo;
	}

}
