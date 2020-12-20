/**
 * Version preliminar del Bingo por Frank Martinez 1AMT B. Falta mucho.
 * Sentiros libres de tocar cosas, lo que querais.
 * 
 * Usuario del bingo, poco desarrollado por ahora se puede ampliar
 * 
 * 
 * @author fmm
 *
 */

public class Usuario {

	private String nombre; //4 caracteres o mas, o error
	private String id; //id de usuario
	private double saldo; //pedido pero no usado por ahora
	private boolean esVetado; //no usado por ahora
	/**
	 * @param nombre
	 * @param saldo
	 */
	public Usuario(String nombre, double saldo) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
		this.esVetado = false;
		this.id = "" +  (int)(10000*(Math.random()))+nombre.substring(0, 4);
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the esVetado
	 */
	public boolean isEsVetado() {
		return esVetado;
	}
	/**
	 * @param esVetado the esVetado to set
	 */
	public void setEsVetado(boolean esVetado) {
		this.esVetado = esVetado;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	
}
