package practica.modelo.minijuegos.Puzzle;

import practica.modelo.minijuegos.Juego;


public class JuegoPuzzle extends Juego{
	public JuegoPuzzle()
	{
		super("JuegoPuzzle",new Puzzle(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
}
