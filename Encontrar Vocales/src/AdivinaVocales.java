import java.util.Scanner;

/**
Creado para un trabajo de clase de programacion
@author Andrea Cañás Garabito
*/

public class AdivinaVocales implements Jugable {

	private final int TAMANO = 20;
	private char[][] panel; 
	private String consonantes = "BCDFGHJKLMNPQRSTVWXYZ"; //Abecedario solo de consonantes
	private String vocales ="AEIOU"; // Abecedario solo de vocales
	private int contadorVocales = 0;


	public AdivinaVocales() { //un constructor cuando no le pones cuantas vocales quieres 

		panel = new char[TAMANO][TAMANO];
		rellenaConsonantes();
		rellenaVocales();

	}

	public AdivinaVocales(int numero) { // constructor cuando quieres poner el numero de vocales

		panel = new char[TAMANO][TAMANO];
		rellenaConsonantes();
		rellenaVocales(numero);


	}

	public void rellenaConsonantes() {

		// estes son dos for que van recorriendo el array[][] para rellenar todos los huecos de consonantes

		for (int x = 0; x < panel.length; x++) {
  			for (int y = 0; y < panel[x].length; y++) {

  				int numeroAzar = (int) (Math.random()* 19); // un numero al azar
  				char letraAzar = (char) consonantes.charAt(numeroAzar); // letra del string de consonantes que corresponde a ese numero al azar
  				

  			 	panel[x][y] = letraAzar; // se van metiendo las letras al azar en el string

 			 }
		}

	}

	public void rellenaVocales(int numero) { //en este metodo tu eliges cuantas vocales quieres que haya

		for (int a = 0; a < numero; a++) { 

			//sigue el mismo principio que en el metodo rellenaVocales

			int posicionX = (int) (Math.random()* 19);
			int posicionY = (int) (Math.random()* 19);
  			int numeroAzar = (int) (Math.random()* 4);
			char letraAzar = (char) vocales.charAt(numeroAzar);

  			panel[posicionX][posicionY] = letraAzar;

  			contadorVocales = numero; // Se van contabilizando las vocales que hay para que luego aparezcan en el panel para saber cuantas hay
  		
  		}


	}

	public void rellenaVocales() {

		for (int a = 0; a < (int) (Math.random()* TAMANO) + 8 ; a++) { // Esto decide cuantas vocales se meten. Como minimo siempre va a haber 8 vocales y nunca más de el tamaño del panel

			//sigue el mismo principio que en el metodo rellenaVocales

			int posicionX = (int) (Math.random()* 19);
			int posicionY = (int) (Math.random()* 19);
  			int numeroAzar = (int) (Math.random()* 4);
			char letraAzar = (char) vocales.charAt(numeroAzar);

  			panel[posicionX][posicionY] = letraAzar;

  			contadorVocales++; // Se van contabilizando las vocales que hay para que luego aparezcan en el panel para saber cuantas hay
  		
  		}
 			 

	}


	public void compruebaAcierto(int x, int y) {

		
		if(panel[x][y] == 'A' || panel[x][y] == 'E' || panel[x][y] == 'I'  || panel[x][y] == 'O' || panel[x][y] == 'U' ) { // va comparando a ver si ahi hay alguna vocal
		
			panel[x][y] = '*'; // si se acierta se cambia el acierto por un asterisco
			contadorVocales--; // se descuenta del contador de vocales
			
			System.out.println("\nAcertaste!\n");
		} else {
			System.out.println("\nLastima! Vuelve a intentarlo\n");
		}

	}

	public void mostrar() {

		
		//esto es una trampita para que se vea más cuqui todo 

		System.out.print("       ");
		for (int numero = 0; numero < 10; numero++) { 
			System.out.print("" + numero + "   ");

		}

		for (int numero2 = 10; numero2 < TAMANO; numero2++) { 
			System.out.print("" + numero2 + "  ");

		}
		System.out.println("\n\n");
		
		//dos for que van recorriendo el array para ir imprimiendo las distintas posiciones 
		
		for (int a = 0; a < panel.length; a++) {

			if(a < 10) System.out.print(" " + a +"   "); //siguen siendo cosas cuquis para que quede mejor
			if (a > 9) System.out.print(" " + a +"  ");
			
        	for (int b = 0; b < panel[a].length; b++) {

        		
         		System.out.print("| " + panel[a][b]+ " "); 
       		}

       		System.out.println(" ");
       	}

       	System.out.println("\n\n El numero de vocales que hay es: " + contadorVocales + "\n"); // Aqui se imprime el contador

	}

	public void juega() {

		Scanner teclado = new Scanner(System.in);
		int x;
		int y;
		boolean excepcion; // esto es una variable auxiliar que necesitare despues 

		System.out.println("\n Bienvenido! :) Encuentra las vocales en este panel: \n");
		
		do {

			excepcion = false;

			mostrar();

			System.out.println("\n Por favor, meta las posiciones en las que crea que esta la vocal (x, y): \n");

			System.out.println(" Introduce la variable x (fila, la que esta en horizontal): ");
			x = teclado.nextInt();

			System.out.println(" Introduce la variable y (columna, la que esta en vertical): ");
			y = teclado.nextInt();

			// aqui hay una comprobacion por si se produce una excepcion por estar fuera del rango de la matriz

			try {
 
           		if (x > TAMANO || x < 0 || y > TAMANO || y < 0) {

                	throw new CoordenadaIncorrecta(); 
            	} 
 
       		} catch (CoordenadaIncorrecta e) {

       		excepcion = true;
            System.out.println(" Coordenadas incorrectas, has salido del panel. Intentalo de nuevo\n"); // si sucede muestra este mensaje 
      		 
      		}

			

      		if (excepcion == false) { // si no ha habido ninguna excepcion comprueba si se ha acertado y si no vuelve a pedir los datos

      			compruebaAcierto(x, y); 
      		}


		} while (contadorVocales != 0); // el juego no para hasta que no haya vocales con las que jugar

		mostrar();

		System.out.println(" ENHORABUENA, HAS GANADO!");
	}

}