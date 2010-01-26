package practica.modelo.minijuegos.Caballo;

import practica.modelo.minijuegos.Juego;


public class JuegoCaballo extends Juego {
	
	public JuegoCaballo()
	{
		super("JuegoCaballo", new Caballo(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
	

}
