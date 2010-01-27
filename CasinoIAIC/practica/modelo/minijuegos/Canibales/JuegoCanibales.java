package practica.modelo.minijuegos.Canibales;

import practica.modelo.minijuegos.Juego;

public class JuegoCanibales extends Juego{

	
	public JuegoCanibales()
	{
		super("JuegoCanibales", new Canibales(), new Sucesores(), new Objetivo(), new Coste(), new Heuristica());
	}
	
	
}
