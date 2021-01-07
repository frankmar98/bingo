import java.awt.event.*;
import javax.swing.*;

public class InterfazBingo1 {
	public int contadorTableros = -1;
	public final int MAX_TAB = 10;
	public VentanaTablero[] ventanas = new VentanaTablero[MAX_TAB];
	public Tablero[] tableros = new Tablero[MAX_TAB];
	public boolean haGanado = false;
	private GeneradorAleatorio aleBolas = new GeneradorAleatorio(90,1);
	
	public void iniciarInterfaz() {
		JFrame fr = new JFrame("Aplicacion del Bingo");
		JLabel lb1 = new JLabel("Pulse para jugar");
		JButton b1 = new JButton("Nuevo tablero");
		JButton b2 = new JButton("Jugar");
		b1.setBounds(5,5, 190,190);
		b2.setBounds(205,5,190,190);
		lb1.setBounds(405,5,190,100);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contadorTableros++;
				nuevoTablero(contadorTableros);
			}

		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizar();
			}

		});
		fr.add(lb1);
		fr.add(b1);
		fr.add(b2);
		fr.setSize(600,300);
		fr.setLayout(null);
		fr.setVisible(true);
	}
	
	public void nuevoTablero(int n) {
		VentanaTablero ventana = new VentanaTablero(contadorTableros);
		ventanas[contadorTableros] = ventana;
		ventanas[contadorTableros].iniciar();
		Tablero tablero = new Tablero("" + contadorTableros, 200, 5, 90, 1);
		tableros[contadorTableros] = tablero;
		tableros[contadorTableros].rellenarAleatorio();
	}
	private void actualizar() {
		int bola;
		bola = aleBolas.tirar();
		for (int i = 0;i<=contadorTableros;i++) {
			String s="";
			s += tableros[i].actualizar(bola);
			s += tableros[i].comprobarTodo();
			s += tableros[i].mostrar();
			
			ventanas[i].actualizar(s);
		}
	}
	
}
