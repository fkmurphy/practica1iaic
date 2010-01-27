package practica.modelo.minijuegos.Mochila;

import practica.modelo.minijuegos.Juego;


public class JuegoMochila extends Juego{
	public JuegoMochila()
	{
		super("JuegoMochila",new Mochila(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
}
