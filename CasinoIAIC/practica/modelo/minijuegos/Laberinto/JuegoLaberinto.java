package practica.modelo.minijuegos.Laberinto;

import practica.modelo.minijuegos.Juego;


public class JuegoLaberinto extends Juego{
	public JuegoLaberinto()
	{
		super("JuegoLaberinto",new Laberinto(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
}
