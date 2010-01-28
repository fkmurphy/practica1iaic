package practica.modelo.minijuegos;

import practica.Controlador.Controlador;

import practica.modelo.minijuegos.Canibales.JuegoCanibales;
import practica.modelo.minijuegos.Garrafas.JuegoGarrafas;
import practica.modelo.minijuegos.Laberinto.JuegoLaberinto;
import practica.modelo.minijuegos.LoboColCabra.JuegoLoboColCabra;
import practica.modelo.minijuegos.Mochila.JuegoMochila;
import practica.modelo.minijuegos.Mono.JuegoMono;
import practica.modelo.minijuegos.NB.JuegoNB;
import practica.modelo.minijuegos.Palillos.JuegoPalillos;
import practica.modelo.minijuegos.Puzzle.JuegoPuzzle;
import practica.modelo.minijuegos.TorreHanoi.JuegoTorreHannoi;

import practica.modelo.minijuegos.buscarletras.JuegoBuscarLetras;
import practica.modelo.minijuegos.nReinas2.JuegoNReinas;




public class GestorMinijuegos {
	
	private Controlador miControlador;	

    static int max;
    static int min;
	
	public void registerControlador(Controlador controlador)
	{
		this.miControlador=controlador;
	}
	
	
	  
	  public Juego dameMinijuego(int idMinijuego)
	  {
		  
		  Juego juego = null;
		  switch(idMinijuego)
		  {
		  case 1: juego = new JuegoLoboColCabra(); 
		  			break;
		  			
		  case 2: juego = new JuegoCanibales();
		  			break;
		  			
		  case 3: juego = new JuegoGarrafas();
		  			break;
		  			
		  case 4: juego = new JuegoMono();
		  			break;
		  
		  case 5: juego = new JuegoNReinas();
		  			 break;
		  case 6: juego = new JuegoMochila();
			 				break;
		  case 7: juego = new JuegoLaberinto();
			 		break;
			 
		  case 8: juego = new JuegoPalillos();
			 		break;
			
		  case 9: juego = new JuegoTorreHannoi();
			 		break;
		  			 
		  case 10: juego = new JuegoPuzzle();
			 		break;
			 
		  case 11: juego = new JuegoNB();
			 				break;
		  case 12: juego = new JuegoBuscarLetras();
			 		break;
			 
		  		
		  }
		  System.out.println(juego.nombre);
		  return juego;
		  
	  }

	  public static void setRango(int min, int max) {
	         GestorMinijuegos.max=max;
	    }
	  
}
