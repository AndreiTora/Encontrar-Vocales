// ejercicio063. AdivinaVocales. Deseamos hacer un juego para que unxs niñxs aprenda las vocales. 
// Para ello implementa una interfaz 'Jugable', que tiene los siguientes metodos: 
// RellenaConsonantes ;; RellenaVocales (numero de vocales que quiero poner) y las posiciones son al azar ;; Mostrar 
// CompruebaAcierto (le pasas una cordenada x, y), dicho metodo lanza una excepcion 'CoordenadaIncorrecta' si esta fuera de rango ;; 
// Haz una clase AdivinaVocales que implementa el interface Jugable. Tiene como atributos privados el tablero de 20 por 20, un
// numero de vocales que es un entero, un constructor que le paso el numero de vocales y el constructor llama al rellenaConsonantes y al
// rellenaVocales
// Por ultimo tiene un metodo Juega, que interactua con lx niñx pidiendole coordenadas y mostrando los resultados. El metodo finaliza 
// cuando las vocales sean 0.
// cada vez que se acierte se debe reducir el contador y cambiar esa vocal por un asterisco (*)
// 1. Excepcion 2. Interface 3. Creo la clase AdivinaVocales, pongo los metodos que implementan el interface.


/**
Creado para un trabajo de clase de programacion
@author Andrea Cañás Garabito
*/

import java.util.Scanner;

public class ProgramaJuego {
	
	public static void main(String[] args) {

	Scanner teclado = new Scanner(System.in);

	System.out.println("Indique si quiere elegir usted el numero de vocales con las que quiere jugar o prefiere que el programa elija automaticamente: \n 1. Elegir yo \n 2. Elija el programa");

	int opcion = teclado.nextInt();

	switch (opcion) { // este es un switch 

		case 1: 

			System.out.println("Indique las vocales con las que quiere jugar:");
			int numero = teclado.nextInt();
			AdivinaVocales juego = new AdivinaVocales(numero);
			juego.juega();
			break;

		case 2:

			AdivinaVocales juego2 = new AdivinaVocales();
			juego2.juega();
			break;
	}
	
	}
}