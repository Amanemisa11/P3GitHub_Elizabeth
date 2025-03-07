package programacion;
import java.util.*;
public class ewfrwertg {
	static Scanner sc = new Scanner (System.in);

	

	public static int[] codigoProducto = {0,1,2,3,4,5,6,7,8,9};
	public static String[] nombresProductos = { "Mouse Genius", "Mouse Logitech", "Alexa Altavoz", "Siri Altavoz", "Samsung S21", "Play5", "Xbox Series X", "Nintendo Switch", "Laptop Dell", "Razer BlackShark"};
	public static double[] preciosProductos = {12.99,20.99,34.21,339.00,300.00,374.00,499.00,219.99,689.00,52.24};
	public static int[] cantidadesStock = {30,25,12,41,20,3,20,53,36,80};
	public static int[] stockTemporal = cantidadesStock.clone();

	public static String[] carritoProductos = new String[0];
	public static int[] carritoCantidad = new int[0];
	public static double[] carritoPrecios = new double[0];

	static boolean elimina =false;
	static int opcion;
	static int intentos = 0;
	static int ind = 0;
	static String respuesta;
	static String GREEN = "\u001B[32m";
	static String RESET = "\u001B[0m"; 
	static String BOLD = "\u001B[1m";
	static String PURPLE = "\u001B[35m"; 


	public static void main(String[] args) {

		do {
			System.out.println("---------------------------------" ); 
			System.out.println(PURPLE + BOLD + "Bienvenido a Gaelictronyc! \u26A0\u26A1"+RESET);
			System.out.println("---------------------------------" ); 
			System.out.println(); 
			System.out.println("-------> " + GREEN +"Menú Principal " + RESET + "<-------");
			System.out.println("\t1. Administrador");
			System.out.println("\t2. Cliente ");
			System.out.println("\t0. Salir");
			System.out.println("------------------------------"); 
			System.out.println("Seleccione una opción: ");
			opcion=sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				administrador();
				opcion = -1;
				break;
			case 2:
				cliente();
				opcion = -1;
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default :
				System.out.println("Opción invalida. Intente de nuevo.");
				break;
			}
		}while(opcion != 0);

	}

	static void administrador () {
		if (intentos > 2){
			System.out.println("Número de intentos superado");
			System.out.println("Saliendo....");
			intentos = 0;
		}else{
			System.out.println("Introduzca la contraseña: ");
			int contraseña = sc.nextInt();
			sc.nextLine();
			if (contraseña == 1234){
				do {
					System.out.println("----->"+GREEN+" Menú de Administrador"+RESET+" <-----");
					System.out.println("1. Alta de producto");
					System.out.println("2. Consulta de productos ");
					System.out.println("3. Modificación de producto");
					System.out.println("4. Baja de un producto");
					System.out.println("0. Salir");
					System.out.println("-----------------------------------"); 
					System.out.println("Seleccione una opción: ");
					opcion=sc.nextInt();
					sc.nextLine();

					switch (opcion) {
					case 1:
						altaProducto();
						break;
					case 2:
						consultaProductos();
						break;
					case 3:
						consultaProductos();
						System.out.println("Elija el producto a modificar (Código de producto)");
						ind = sc.nextInt();
						sc.nextLine();
						if (ind >= codigoProducto.length){
							System.out.println("El producto no existe");
							break;
						}
						System.out.println("¿Desea modificar " + nombresProductos[ind] + " ? (s/n): ");			
						respuesta = sc.nextLine();
						if (!respuesta.equalsIgnoreCase("s")) break;
						modificarProducto(ind);
						break;
					case 4:
						consultaProductos();
						if (nombresProductos.length != 0){
							bajaProducto();
						}
						break;
					case 0:
						System.out.println("Saliendo...");
						break;
					default :
						System.out.println("Opción invalida. Intente de nuevo.");
						break;
					}
				}while(opcion != 0);
			}else if(contraseña == 112358){
				System.out.println("------------------------------------------------------------");
				System.out.println(PURPLE + BOLD + "Pensaste que era una contraseña, pero era yo, " 
						+ GREEN + "F" + PURPLE + "I" + GREEN + "B" + PURPLE + "O" + GREEN + "N" 
						+ PURPLE + "A" + GREEN + "C" + PURPLE + "C" + GREEN + "I" + RESET);
				System.out.println("------------------------------------------------------------");
				administrador();
			}else if(contraseña == 11235813) {
				System.out.println("Introduce un número: ");
				System.out.println("Advertencia: si lo ejecutas con números grandes, tendrás tiempo para hacer café ☕.");
				int fibo = sc.nextInt();
				if (fibo > 56) {
				    System.out.println("Hasta la JVM 🤖 necesita una pausa para tomar café ☕️. ¡No exageres con el número!");
				}else
				System.out.println("Espero disfrutaras el café ☕. "+"Tu suma de fibonacci es: "+fib(fibo));
			}else {
				System.out.println("La contraseña es incorrecta");
				intentos++;
				administrador();
			}
		}
	}
	static void cliente () {
		do {
			System.out.println("----->" + GREEN +" Menú de Compras" + RESET+" <-----");
			System.out.println("1. Consultar Productos");
			System.out.println("2. Añadir al carrito");
			System.out.println("3. Eliminar del carrito");
			System.out.println("4. Mostrar carrito");
			System.out.println("5. Facturar y Pagar");
			System.out.println("0. Salir");
			System.out.println("--------------------------------------"); 
			System.out.println("Seleccione una opción: ");
			opcion=sc.nextInt();
			sc.nextLine();

			switch (opcion) {
			case 1:
				consultaProductosCliente();
				break;
			case 2:
				añadirCarrito();
				break;
			case 3:
				eliminarCarrito();
				break;
			case 4:
				mostrarCarrito();
				break;
			case 5:
				if (carritoProductos.length == 0){
					System.out.println("No ha añadido productos a su carrito");
					break;
				}
				facturar();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default :
				System.out.println("Opción invalida. Intente de nuevo.");
				break;
			}
		}while(opcion != 0);
	}
	public static void añadirCarrito(){
		while (true) {
			consultaProductosCliente();
			if (nombresProductos.length == 0) {
				System.out.println("No disponemos de existencias actualmente, vuelva más tarde.");
				return;
			}


			System.out.println("Indique el código del producto a comprar (-1 para salir): ");
			int ind = sc.nextInt();
			sc.nextLine();

			if (ind == -1) break;
			if (ind < 0 || ind >= codigoProducto.length) {
				System.out.println("El producto no existe.");
				continue;
			}

			System.out.println("Ingrese la cantidad a comprar: ");
			int cantidad = sc.nextInt();
			sc.nextLine();

			if (cantidad<= 0) {
				System.out.println("No se ha ingresado una cantidad correcta. No se añadió nada al carrito.");
				continue;
			}else if (cantidad > stockTemporal[ind]) {
				System.out.println("No hay suficiente stock. Intente con una cantidad menor.");
				continue;
			}

			agregarAlCarrito(nombresProductos[ind], preciosProductos[ind], cantidad);
			stockTemporal[ind] -= cantidad;  

			System.out.println("¿Desea comprar otro producto? (s/n): ");
			respuesta = sc.nextLine();
			if (!respuesta.equalsIgnoreCase("s")) break;
		}

	}
	public static void altaProducto(){
		String nombre;
		do {
			System.out.println("Nombre del producto a introducir");
			nombre = sc.nextLine();
			intentos = 0;
			if (indiceProducto(nombre) != -1){
				System.out.println("El producto ya existe");
				intentos =1;
			}
		}while (intentos != 0);
		System.out.println("Precio por unidad");
		double precio = sc.nextDouble();
		sc.nextLine();
		if (precio <=0){
			System.out.println("Precio introducido no valido");
			return;
		}
		System.out.println("Cantidad disponible del producto");
		int cantidad = sc.nextInt();
		sc.nextLine();
		if (cantidad <=0){
			System.out.println("Cantidad introducida no valida");
			return;
		}
		codigoProducto = aumentarArray(codigoProducto);
		nombresProductos = aumentarArray(nombresProductos, nombre);
		preciosProductos = aumentarArray(preciosProductos, precio);
		cantidadesStock = aumentarArray(cantidadesStock, cantidad);
		stockTemporal = aumentarArray(cantidadesStock, cantidad);

	}
	public static void bajaProducto(){
		System.out.println("Elija el producto a eliminar (Código de producto)");
		ind = sc.nextInt();
		sc.nextLine();
		if (ind >= codigoProducto.length){
			System.out.println("El producto no existe");
			return;
		}
		System.out.println("¿Desea eliminar " + nombresProductos[ind] + " ? (s/n): ");
		respuesta = sc.nextLine();
		if (!respuesta.equalsIgnoreCase("s")) return;

		codigoProducto = eliminarElemento(codigoProducto);
		nombresProductos = eliminarElemento(nombresProductos, ind);
		preciosProductos = eliminarElemento(preciosProductos, ind);
		cantidadesStock = eliminarElemento(cantidadesStock, ind);

		stockTemporal= eliminarElemento(stockTemporal,ind);

		int cont=0;

		for (int i = 0; i < carritoProductos.length; i++) {
			boolean encontrado = false;

			for (String producto : nombresProductos) {
				if (producto.equals(carritoProductos[i])) {
					encontrado = true;
					break;
				}
			}
			if (!encontrado) {
				cont++;
				carritoProductos = eliminarElemento(carritoProductos, i);
				carritoCantidad = eliminarElemento(carritoCantidad, i);
				carritoPrecios = eliminarElemento(carritoPrecios, i);
				i--;
			}
		}
		if(cont>0) {
			System.out.println("El producto ya no está disponible en los carritos de los clientes.");
			cont=0;
			elimina=true;
		}else {
			System.out.println("El producto se ha eliminado del stock");
		}

		consultaProductos();

	}
	public static void mostrarCarrito(){
		if (elimina) {
			System.out.println("Se han eliminado productos de su carrito");
			elimina = false;
		}
		System.out.println("-----------------------------------------------------------------------------");
		System.out.printf("%-5s | %-30s | %-10s | %-7s| %-10s\n", "Nº", "Nombre", "Cantidad" , "Precio/u" , "Precio total");
		System.out.println("-----------------------------------------------------------------------------");

		for (int i = 0; i < carritoProductos.length; i++) {
			System.out.printf("%-5s | %-30s | %-10d | %-7.2f€| %-10.2f€\n",
					i+1, carritoProductos[i],  carritoCantidad[i], carritoPrecios[i] , carritoPrecios[i]*carritoCantidad[i] );
		}

		System.out.println("-----------------------------------------------------------------------------");	
	}
	public static void eliminarCarrito() {

		mostrarCarrito();
		if (carritoProductos.length == 0) {
			System.out.println("El carrito está vacío. No hay productos para eliminar.");
			return;
		}

		System.out.println("Ingrese el número del producto que desea eliminar: ");
		ind = sc.nextInt();
		sc.nextLine();

		if (ind < 1 || ind > carritoProductos.length) {
			System.out.println("Número inválido. No se eliminó ningún producto.");
			return;
		}

		actualizarStock(carritoProductos[ind-1], ind-1);
		carritoProductos = eliminarElemento(carritoProductos, ind- 1);
		carritoCantidad = eliminarElemento(carritoCantidad, ind- 1);
		carritoPrecios = eliminarElemento(carritoPrecios, ind- 1);

		System.out.println("Producto eliminado exitosamente.");
		mostrarCarrito();
	}
	public static void facturar() {
		if (elimina) {
			System.out.println("Se han eliminado productos de su carrito");
			elimina = false;

		}

		double totalSinIVA = 0;

		System.out.println("\n-------------------->"+ GREEN +" FACTURA DE COMPRA"+ RESET +" <-------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.printf("%-5s | %-20s | %-10s | %-7s | %-10s\n", "Nº", "Producto", "Cantidad", "Precio", "Subtotal");
		System.out.println("------------------------------------------------------------------");


		for (int i = 0; i < carritoProductos.length; i++) {
			double subtotal = carritoCantidad[i] * carritoPrecios[i];
			System.out.printf("%-5d | %-20s | %-10d | %-7.2f€ | %-10.2f€\n",
					i + 1, carritoProductos[i], carritoCantidad[i], carritoPrecios[i], subtotal);
			totalSinIVA += subtotal;
		}


		double totalConIVA = totalSinIVA * 1.21;


		System.out.println("------------------------------------------------------------------");
		System.out.printf("%-47s %.2f€\n", "Total sin IVA:", totalSinIVA);
		System.out.printf("%-48s %.2f€\n", "IVA (21%):", totalSinIVA * 0.21);
		System.out.printf("%-47s %.2f€\n", "Total con IVA:", totalConIVA);
		System.out.println("------------------------------------------------------------------");


		System.out.println("¿Desea proceder con el pago? (s/n): ");
		respuesta = sc.nextLine();
		if (respuesta.equalsIgnoreCase("s")) {
			pagar(totalConIVA);
			cantidadesStock = stockTemporal.clone();

		} else {
			System.out.println("Compra cancelada.");
			System.out.println("Gracias por visitarnos. ¡Vuelva pronto!");
			stockTemporal = cantidadesStock.clone(); 
		}

	}
	public static void pagar(double total) {
		System.out.println("\n-------------------->"+ GREEN +"Proceso de pago"+ RESET +" <-------------------------");

		System.out.print("Ingrese el número de tarjeta (16 dígitos): ");
		String numeroTarjeta = sc.nextLine();
		boolean esValido;
		do{
			esValido=true;
			for (int i = 0; i < numeroTarjeta.length(); i ++){

				if (!Character.isDigit(numeroTarjeta.charAt(i)) ){			
					esValido = false;
					break;
				}

			}
			if (esValido && numeroTarjeta.length() == 16 )break;
			System.out.println("Numero de tarjeta no valido (Tiene 16 digitos)");
			System.out.println("Vuelva a escribirlo: ");
			numeroTarjeta = sc.nextLine();

		}while (numeroTarjeta.length() != 16 || !esValido );


		System.out.println("Ingrese el código de seguridad (CVC de 3 dígitos): ");
		String cvc = sc.nextLine();

		do{
			esValido=true;
			for (int i = 0; i < cvc.length(); i ++){

				if (!Character.isDigit(cvc.charAt(i)) ){			
					esValido = false;
					break;
				}

			}
			if (esValido && cvc.length() == 3 )break;
			System.out.println("Numero de cvc no valido (Tiene 3 digitos)");
			System.out.println("Vuelva a escribirlo: ");
			cvc = sc.nextLine();
		}while (cvc.length() != 3 || !esValido );



		System.out.println("¿Desea financiar su compra? (s/n): ");
		respuesta = sc.nextLine();

		if (respuesta.equalsIgnoreCase("s")) {
			do{
				System.out.println("Ingrese el número de meses (3, 6 o 12): ");
				int meses = sc.nextInt();


				while (meses != 3 && meses != 6 && meses != 12) {
					System.out.println("Opción inválida. Ingrese 3, 6 o 12 meses: ");
					meses = sc.nextInt();
				}
				sc.nextLine();

				double totalConInteres = total * 1.29;
				double pagoMensual = totalConInteres / meses;

				System.out.println("-----------------------------------------------------------");
				System.out.printf("Total a pagar con el 29%% de interés: %.2f€\n", totalConInteres);
				System.out.printf("Pago mensual por %d meses: %.2f€\n", meses, pagoMensual);
				System.out.println("-----------------------------------------------------------");
				System.out.println("Desea proceder con el pago? (s/n)");
				respuesta = sc.nextLine();
			} while (!respuesta.equalsIgnoreCase("s"));

		} else {
			System.out.println("-----------------------------------------------------------");
			System.out.printf("Pago total a cargar a su tarjeta : %.2f€\n", total);
			System.out.println("-----------------------------------------------------------");
		}
		System.out.println("-----------------------------------------------------------");
		System.out.println("¡Pago realizado con éxito! Gracias por su compra.");
		System.out.println("-----------------------------------------------------------");
		carritoCantidad = Arrays.copyOf(carritoCantidad, 0) ;
		carritoPrecios = Arrays.copyOf(carritoPrecios, 0) ;
		carritoProductos = Arrays.copyOf(carritoProductos, 0) ;
	}
	public static void agregarAlCarrito(String nombre, double precio, int cantidad) {
		carritoProductos = aumentarArray(carritoProductos, nombre);
		carritoCantidad = aumentarArray(carritoCantidad, cantidad);
		carritoPrecios = aumentarArray(carritoPrecios, precio );
	}
	public static int indiceProducto(String nombre) {
		for (int i = 0; i < nombresProductos.length; i++) {
			if (nombresProductos[i].equalsIgnoreCase(nombre)) {
				return i;
			}
		}
		return -1;
	}
	public static void consultaProductos() {
		if (nombresProductos.length == 0) {
			System.out.println("No hay productos en el inventario.");
			return;
		}

		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%-10s | %-30s | %-7s | %-10s\n", "Código", "Nombre", "Precio", "Cantidad");
		System.out.println("-------------------------------------------------------------------");

		for (int i = 0; i < nombresProductos.length; i++) {
			System.out.printf("%-10s | %-30s | %-7.2f€| %-10d\n",
					String.format("%03d", codigoProducto[i]), nombresProductos[i], preciosProductos[i] , cantidadesStock[i] );
		}

		System.out.println("-------------------------------------------------------------------");
	}
	public static void consultaProductosCliente() {
		if (nombresProductos.length == 0) {
			System.out.println("No hay productos en el inventario.");
			return;
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.printf("%-10s | %-30s | %-7s | %-10s\n", "Código", "Nombre", "Precio", "Cantidad");
		System.out.println("-------------------------------------------------------------------");

		for (int i = 0; i < nombresProductos.length; i++) {
			System.out.printf("%-10s | %-30s | %-7.2f€| %-10d\n",
					String.format("%03d", codigoProducto[i]), nombresProductos[i], preciosProductos[i] , stockTemporal[i] );
		}
		System.out.println("-------------------------------------------------------------------");
	}
	public static void modificarProducto(int mod) {

		System.out.println("El precio actual es " + preciosProductos[mod]);
		System.out.println("¿Desea modificarlo? (s/n): ");
		respuesta = sc.nextLine();
		if (!respuesta.equalsIgnoreCase("s")) {       
			return;
		}

		System.out.println("Ingrese el nuevo precio: ");
		double nuevoPrecio = sc.nextDouble();
		sc.nextLine();
		if (nuevoPrecio >0) {preciosProductos[mod] = nuevoPrecio;
		System.out.println("Precio modificado con éxito.");
		}else {
			System.out.println("El precio no es valido, no se ha modificado");
		}

		System.out.println("La cantidad actual es " + cantidadesStock[mod]);
		System.out.println("¿Desea modificarlo? (s/n): ");
		respuesta = sc.nextLine();
		if (!respuesta.equalsIgnoreCase("s")) {       
			return;
		}
		System.out.println("Ingrese la nueva cantidad: ");
		int nuevaCantidad = sc.nextInt();
		sc.nextLine();
		if (nuevaCantidad < cantidadesStock[mod]) {
			stockTemporal[mod] = stockTemporal[mod] - (cantidadesStock[mod]-nuevaCantidad);
		}else if (nuevaCantidad > cantidadesStock[mod]) {
			stockTemporal[mod] = stockTemporal[mod] + (nuevaCantidad - cantidadesStock[mod]);
		}
		if (nuevaCantidad >= 0) {
			cantidadesStock[mod] = nuevaCantidad;
			System.out.println("Cantidad modificada con éxito.");
		}else{
			System.out.println("La cantidad no es valida, no se ha modificado");
		}
		consultaProductos();
	}
	public static int[] aumentarArray(int[] array){
		int[] nuevoArray = new int[array.length + 1];
		for (int i = 0; i < nuevoArray.length; i++){
			nuevoArray[i] = i;
		}
		return nuevoArray;
	}
	public static String[] aumentarArray(String[] array, String valor) {
		String[] nuevoArray = new String[array.length + 1];
		System.arraycopy(array, 0, nuevoArray, 0, array.length);
		nuevoArray[array.length] = valor;
		return nuevoArray;
	}
	public static double[] aumentarArray(double[] array, double valor) {
		double[] nuevoArray = new double[array.length + 1];
		System.arraycopy(array, 0, nuevoArray, 0, array.length);
		nuevoArray[array.length] = valor;
		return nuevoArray;
	}
	public static int[] aumentarArray(int[] array, int valor) {
		int[] nuevoArray = new int[array.length + 1];
		System.arraycopy(array, 0, nuevoArray, 0, array.length);
		nuevoArray[array.length] = valor;
		return nuevoArray;
	}
	public static int[] eliminarElemento(int[] array){
		int[] nuevoArray = new int[array.length -1];
		for (int i = 0; i < nuevoArray.length; i++){
			nuevoArray[i] = i;
		}
		return nuevoArray;
	}
	public static String[] eliminarElemento(String[] array, int indice) {
		String[] nuevoArray = new String[array.length - 1];
		for (int i = 0, j = 0; i < array.length; i++) {
			if (i != indice) nuevoArray[j++] = array[i];
		}
		return nuevoArray;
	}
	public static double[] eliminarElemento(double[] array, int indice) {
		double[] nuevoArray = new double[array.length - 1];
		for (int i = 0, j = 0; i < array.length; i++) {
			if (i != indice) nuevoArray[j++] = array[i];
		}
		return nuevoArray;
	}
	public static int[] eliminarElemento(int[] array, int indice) {
		int[] nuevoArray = new int[array.length - 1];
		for (int i = 0, j = 0; i < array.length; i++) {
			if (i != indice) nuevoArray[j++] = array[i];
		}
		return nuevoArray;
	}
	public static void actualizarStock(String nombre, int ind){

		for (int i = 0; i < nombresProductos.length;i ++) {

			if(nombre.equalsIgnoreCase(nombresProductos[i])) {
				stockTemporal[i] = cantidadesStock[i];
			} 
		}

	}
	public static long fib(int n) {
		
	 return (n <= 1) ? n : fib(n - 1) + fib(n - 2);
	}
	   
}




