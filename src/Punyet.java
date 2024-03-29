/*
 * Programa: Punyet
 * 
 * Comentario: Programa que nos permite jugar al juego de "los chinos� contra el ordenador. El ganador ser� el primero que venza en tres jugadas. 
 * 			   El jugador podr� retirarse si lo desea, y perder� el juego.
 * 
 * Entradas: 
 * 
 * 		- int chinosUsuario (chinos elegidos por el usuario)
 * 		- int totalUsuario (total de chinos elegidos por el usuario)
 * 		- char siguienteRonda (opcion para jugar la siguiente ronda)
 * 		- char repetir (opcion para jugar otra partida)
 * 
 * Salidas: 
 * 
 * 		- Mensajes de ayuda al usuario
 * 		- int victoriasUsuario (El total de victorias del usuario en una partida)
 * 		- int victoriasOrdenador (El total de victorias del ordenador en una partida)
 * 		- int chinosOrdenador (La cantidad de chinos que ha elegido guardar el ordenador en su mano en una ronda)
 * 		- int totalOrdenador (La cantidad de chinos total sumada que ha elegido el ordenador en una ronda)
 * 
 * Restricciones:
 * 
 * 		- La cantidad de chinos elegida por el usuario y el ordenador en su mano debe ser un n�mero del 0 al 3
 * 		- La cantidad total de chinos elegida por el usuario y el ordenador deber ser un n�mero del 0 al 6 y no pueden ser iguales el uno del otro
 * 		- La variable siguienteRonda deber ser un char que permita �nicamente los valores 'S' (S�) o 'N' (No)
 * 		- La variable repetir deber ser un char que permita �nicamente los valores 'S' (S�) o 'N' (No)
 * 
 * PG
 * Inicio
 * 	Explicacion del Juego
 * 	Hacer
 * 		Para(contador = 0, contador menor o igual a 2 y jugador quiera jugar siguiente ronda, contador++)
 * 			Leer y Validar cantidad chinos usuario
 * 			Generar cantidad aleatoria chinos ordenador
 * 			Calcular cantidad total
 * 			Si contador es par
 * 				Leer y Validar total usuario
 * 				Generar y Mostrar total ordenador
 * 			Sino
 * 				Generar y Mostrar total ordenador
 * 				Leer y Validar total usuario
 * 			Fin_Si
 * 			Comprobar ganador ronda
 * 			Leer y Validar seguir jugando
 * 		Fin_Para
 * 		Comprobar ganador partida
 * 		Leer y Validar repetir juego
 * 	Mientras quiera seguir jugando
 * Fin
 */

import java.util.Random;
import java.util.Scanner;

public class Punyet 
{

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		Random aleatorio = new Random();
		
		char repetir, siguienteRonda;
		int chinosUsuario, chinosOrdenador, totalChinos, totalUsuario, totalOrdenador, victoriasUsuario = 0, victoriasOrdenador = 0;
		
		//Explicaci�n del Juego
		System.out.println("En cada ronda cada jugador guarda a escondidas entre ninguno y 3 chinos en su mano,\n que a continuaci�n muestra cerrada al resto de jugadores, con el brazo estirado delante de s�.\n Entonces cada jugador por turno dice una cifra, intentando adivinar cuantos chinos suman todas las manos.\n\n\n");
		
		
		do
		{
			
			siguienteRonda = 'S';
			
			System.out.println("			EMPECEMOS LA PARTIDA\n\n\n");
			
			for(int contador = 0; contador <= 2 && siguienteRonda == 'S'; contador++)
			{
				//Leer y Validar cantidad chinos usuario
				System.out.print("Introduce que cantidad de chinos desea guardar en tu mano: ");
				do
				{
					chinosUsuario = teclado.nextInt();
					
					if(chinosUsuario < 0 || chinosUsuario > 3)
					{
						System.out.print("\nRercuerda que la cantidad de chinos que puede guardar en su mano debe ser un numero entre el 0 y el 3: ");

					}
				}
				while(chinosUsuario < 0 || chinosUsuario > 3);
				
				//Generar cantidad aleatoria chinos ordenador
				chinosOrdenador = aleatorio.nextInt(4);
				
				//Calcular cantidad total
				totalChinos = chinosUsuario + chinosOrdenador;
				
				
				if(contador % 2 == 0) //Si contador es par
				{
					//Leer y Validar total usuario
					System.out.println("\nIntroduce el total de chinos que crees que hay entre la suma de los tuyos con los elegidos por el ordenador:");
					do
					{
						totalUsuario = teclado.nextInt();
						
						if(totalUsuario < 0 || totalUsuario > 6)
						{
							System.out.println("\nEse total no puede ser posible, el total maximo de chinos posibles es 6 y el minimo 0, vuelvelo a intentar:");
						}
					}
					while(totalUsuario < 0 || totalUsuario > 6);
					
					//Generar y Mostrar total ordenador
					do
					{
						totalOrdenador = aleatorio.nextInt(7);
					}
					while(totalOrdenador == totalUsuario || totalOrdenador < chinosOrdenador);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("\n\nEl total de chinos elegido por el ordenador es: "+totalOrdenador+" chinos\n\n");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					//Generar y Mostrar total ordenador
					do
					{
					totalOrdenador = aleatorio.nextInt(7);
					}
					while(totalOrdenador < chinosOrdenador);
					
					System.out.println("\n\nEl total de chinos elegido por el ordenador es: "+totalOrdenador+" chinos\n");
					
					//Leer y Validar total usuario
					System.out.print("Introduce el total de chinos que crees que hay entre la suma de los tuyos con los elegidos por el ordenador:");
					do
					{
						totalUsuario = teclado.nextInt();
						
						if(totalUsuario < 0 || totalUsuario > 6)
						{
							System.out.println("\nEse total no puede ser posible, el total maximo de chinos posibles es 6 y el minimo 0, vuelvelo a intentar:");
						}
						else if(totalUsuario == totalOrdenador)
						{
							System.out.println("\nNo puedes elegir el mismo total que el ordenador, elige otro diferente");
						}
						
						System.out.println("\n\n");
							
					}
					while(totalUsuario < 0 || totalUsuario > 6 || totalUsuario == totalOrdenador);
				}
				
				//Comprobar ganador ronda
				if(totalUsuario == totalChinos)
				{
					System.out.println("Enhorabuena! Has ganado la ronda");
					victoriasUsuario++;
				}
				else if(totalOrdenador == totalChinos)
				{
					System.out.println("Una pena, victoria del ordenador...");
					victoriasOrdenador++;
				}
				else
				{
					System.out.println("Casi... Ninguno habeis acertado");
				}
				
				System.out.println("");
				
				//Leer y Validar seguir jugando
				if(contador != 2)
				{
					do
					{
						System.out.println("Quieres jugar la siguiente ronda?: (S/N)");
						siguienteRonda = Character.toUpperCase(teclado.next().charAt(0));
					}
					while(siguienteRonda != 'S' && siguienteRonda != 'N');
				}
			}
			
			System.out.println("\n\n");
			
			//Comprobar ganador partida
			if(victoriasUsuario > victoriasOrdenador)
			{
				System.out.println("Que bien! Le has ganado al ordenador "+victoriasUsuario+" a "+victoriasOrdenador);
			}
			else if(victoriasUsuario < victoriasOrdenador)
			{
				System.out.println("Que malo eres, te ha ganador el ordenador " +victoriasUsuario+" a "+victoriasOrdenador);
			}
			else
			{
				System.out.println("Habeis empatado "+victoriasUsuario+" a "+victoriasOrdenador);
			}
			
			//Leer y Validar repetir juego
			do
			{
				System.out.println("\nDesea volver a jugar?: (S o N)");
				repetir = Character.toUpperCase(teclado.next().charAt(0));
			}
			while(repetir != 'S' && repetir != 'N');
		}
		while(repetir == 'S');
	}

}
