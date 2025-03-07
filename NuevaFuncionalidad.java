package Practica5_Elizabeth_Miguel;


public class Caballero extends Personaje {

	/**
	 * @author Elizabeth Suarez
	 * Constructor de Caballero
	 * @param x Fila inicial
	 * @param y Columna inicial
	 * @param color Color del personaje
	 */
	public Caballero(int x, int y, String color) {
		super("Caballero",20, 15, 7, 2, 3, 25, 'C', x, y, color);
	}
	
	/**
	 * @author Miguel Gallego
	 */
	public Caballero() {
		super("Caballero",20, 15, 7, 2, 3, 25);
	}

	/**
	 * @author Miguel Gallego
	 * Metodo sobreescrito de atacar
	 */
	@Override
	public int atacar(Personaje enemigo) {
		int ataque = (int) (Math.random() * ataqueMax); 
		int defensa = (int) (Math.random() * enemigo.defensaMax);
		return (int) Math.max(0, ataque - defensa) ;
	}

	/**
	 * @author Elizabeth Suarez
	 * Metodo sobrescrito para mostrar Informacion
	 */
	@Override
	public void info () {
		super.info();
		System.out.println("\033[3m		\"El honor es mi escudo, la justicia mi espada\"\033[0m");
	}

}

