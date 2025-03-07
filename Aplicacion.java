package Practica5_Elizabeth_Miguel;

/**
 * @author 	Elizabeth Suarez - Miguel Gallego
 * Clase Padre Personaje
 */

public abstract class Personaje {
	protected String nombre;
	protected int vidaMax, vida, ataqueMax, defensaMax, radioAtaque, movimientoMax, costo;
	protected char simbolo;
	protected int x, y; 
	protected String color;
	/**
	 * @author Elizabeth Suarez
	 * Constructor de personaje 
	 * @param nombre Nombre
	 * @param vida Vida 
	 * @param ataqueMax Ataque
	 * @param defensaMax Defensa
	 * @param radioAtaque Radio de ataque
	 * @param movimientoMax Rango de movimiento
	 * @param costo Costo
	 * @param simbolo Simbolo
	 * @param x Fila inicial
	 * @param y Columna inicial
	 * @param color Color del personaje
	 */
	public Personaje(String nombre,int vida, int ataqueMax, int defensaMax, int radioAtaque, int movimientoMax, int costo, char simbolo, int x, int y, String color) {
		this.nombre = nombre;
		this.vida = vida;
		this.vidaMax = vida;
		this.ataqueMax = ataqueMax;
		this.defensaMax = defensaMax;
		this.radioAtaque = radioAtaque;
		this.movimientoMax = movimientoMax;
		this.costo = costo;
		this.simbolo = simbolo;
		this.x = x;
		this.y = y;
		this.color = color;
	}
	/**
	 * @author Miguel Gallego
	 * Constructor de personaje 
	 * @param nombre Nombre
	 * @param vidaMax Vida maxima
	 * @param ataqueMax Ataque
	 * @param defensaMax Defensa
	 * @param radioAtaque Radio de ataque
	 * @param movimientoMax Rango de movimiento
	 * @param costo Costo
	 */
	public Personaje(String nombre,int vidaMax, int ataqueMax, int defensaMax, int radioAtaque, int movimientoMax, int costo) {
		this.nombre = nombre;
		this.vidaMax = vidaMax;
		this.ataqueMax = ataqueMax;
		this.defensaMax = defensaMax;
		this.radioAtaque = radioAtaque;
		this.movimientoMax = movimientoMax;
		this.costo = costo;
	}
	/**
	 * @author Elizabeth Suarez
	 * Comprueba si un personaje esta vivo
	 * @return true/false
	 */
	public boolean estaVivo() {
		return vida > 0;
	}

	/**
	 * @author Miguel Gallego
	 * Funcion que se utiliza para que el personaje reciba el daño durante el ataque
	 * @param danio cuanto daño recibe el personaje
	 */
	public void recibirDanio(int danio) {
		vida -=danio;

		if (vida < 0) {
			vida = 0;
		}
	}

	/**
	 * @author Elizabeth Suarez
	 * Metodo para curar a los personajes que calcula los puntos de vida a aumentar aleatoriamente
	 */
	public void curar() {
		int vidaExtra = (int) (Math.random() * vida);

		if (vida + vidaExtra > vidaMax) {
			vida = vidaMax;

		}else {
			vida += vidaExtra;

		}

		mostrarVida( vida,  vidaMax);
	}

	/**
	 * @author Miguel Gallego 
	 * Muestra la barra de vida de cada personaje cuando se cura
	 * @param vidaActual la vida con la que cuenta el personaje actualmente
	 * @param vidaMax vida maxima del personaje
	 */
	public static void mostrarVida(int vidaActual, int vidaMax) {
		int bloques = (int) ((double)vidaActual/vidaMax * vidaMax);
		System.out.println(
				"\u001B[31m❤ \u001B[37mVida: [" + 
						"\u001B[32m" + "█".repeat(bloques) + 
						"\u001B[37m" + "░".repeat(vidaMax - bloques) + "]" +
						"\u001B[0m\n"
				);
	}

	/**
	 * @author Elizabeth Suarez
	 * Metodo abstracto de atacar 
	 * @param enemigo personaje enemigo
	 * @return cantidad de daño
	 */
	public abstract int atacar(Personaje enemigo);

	/**
	 * @author Miguel Gallego
	 * Muestra la Informacion de cada Personaje
	 */
	public void info () {
		System.out.println("   \u001B[1m"+nombre+"\u001B[0m");
		System.out.println("	Coste ₲:" + costo);
		System.out.println("	Vida ❤: "+ vidaMax);
		System.out.println("	Ataque ⚔:" + ataqueMax);
		System.out.println("	Defensa 🛡️:" + defensaMax);
		System.out.println("	Rango ataque ⏩: " + radioAtaque);
		System.out.println("	Rango Movimiento 🚶: " + movimientoMax);

	}


	// Get-Set
	/**
	 * @author Elizabeth Suarez - Miguel Gallego
	 * Metodos Get - Set
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getx() {
		return x;
	}

	public int gety() {
		return y;
	}

	public int getAtaqueMax() {
		return ataqueMax;
	}

	public void setAtaqueMax(int ataqueMax) {
		this.ataqueMax = ataqueMax;
	}

	public int getDefensaMax() {
		return defensaMax;
	}

	public void setDefensaMax(int defensaMax) {
		this.defensaMax = defensaMax;
	}

	public int getRadioAtaque() {
		return radioAtaque;
	}

	public void setRadioAtaque(int radioAtaque) {
		this.radioAtaque = radioAtaque;
	}

	public int getMovimientoMax() {
		return movimientoMax;
	}

	public void setMovimientoMax(int movimientoMax) {
		this.movimientoMax = movimientoMax;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

}

