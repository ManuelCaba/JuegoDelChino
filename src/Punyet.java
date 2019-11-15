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
		
		//Explicación del Juego
		System.out.println("En construcción");
		
		
		do
		{
			
			siguienteRonda = 'S';
			
			for(int contador = 0; contador <= 2 && siguienteRonda == 'S'; contador++)
			{
				//Leer y Validar cantidad chinos
				System.out.println("Introduce que cantidad de chinos desea guardar en su mano");
				do
				{
					chinosUsuario = teclado.nextInt();
					
					if(chinosUsuario < 0 || chinosUsuario > 3)
					{
						System.out.println("Rercuerda que la cantidad de chinos que puede guardar en su mano debe ser un numero entre el 0 y el 3");

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
					System.out.println("Introduce el total de chinos que crees que hay entre la suma de los tuyos con los elegidos por el ordenador:");
					do
					{
						totalUsuario = teclado.nextInt();
						
						if(totalUsuario < 0 || totalUsuario > 6)
						{
							System.out.println("Ese total no puede ser posible, el total maximo de chinos posibles es 6 y el minimo 0, vuelvelo a intentar:");
						}
					}
					while(totalUsuario < 0 || totalUsuario > 6);
					
					//Generar y mostrar total ordenador
					do
					{
						totalOrdenador = aleatorio.nextInt(7);
					}
					while(totalOrdenador == totalUsuario || totalOrdenador < chinosOrdenador);
					
					System.out.println("El total de chinos elegido por el ordenador es: "+totalOrdenador+" chinos");
				}
				else
				{
					//Generar y mostrar total ordenador
					do
					{
					totalOrdenador = aleatorio.nextInt(7);
					}
					while(totalOrdenador < chinosOrdenador);
					
					System.out.println("El total de chinos elegido por el ordenador es: "+totalOrdenador+" chinos");
					
					//Leer y Validar total usuario
					System.out.println("Introduce el total de chinos que crees que hay entre la suma de los tuyos con los elegidos por el ordenador:");
					do
					{
						totalUsuario = teclado.nextInt();
						
						if(totalUsuario < 0 || totalUsuario > 6)
						{
							System.out.println("Ese total no puede ser posible, el total maximo de chinos posibles es 6 y el minimo 0, vuelvelo a intentar:");
						}
						else if(totalUsuario == totalOrdenador)
						{
							System.out.println("No puedes elegir el mismo total que el ordenador, elige otro diferente");
						}
							
					}
					while(totalUsuario < 0 || totalUsuario > 6);
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
			
			//Comprobar ganador ronda
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
			
			//Leer y Validar repetir
			do
			{
				System.out.println("Desea volver a jugar?: (S o N)");
				repetir = Character.toUpperCase(teclado.next().charAt(0));
			}
			while(repetir != 'S' && repetir != 'N');
		}
		while(repetir == 'S');
	}

}
