package practica.modelo.minijuegos.NB;

import practica.modelo.minijuegos.Juego;

public class JuegoNB extends Juego{
	public JuegoNB()
	{
		super("JuegoNB",new NB(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
	

}
