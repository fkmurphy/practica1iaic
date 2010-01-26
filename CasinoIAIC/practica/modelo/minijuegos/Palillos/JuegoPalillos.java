package practica.modelo.minijuegos.Palillos;

import practica.modelo.minijuegos.Juego;

public class JuegoPalillos extends Juego{
	public JuegoPalillos()
	{
		super("JuegoPalillos",new Palillos(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
	

}
