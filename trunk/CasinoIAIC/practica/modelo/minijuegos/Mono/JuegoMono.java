package practica.modelo.minijuegos.Mono;

import practica.modelo.minijuegos.Juego;

public class JuegoMono extends Juego{

	
	public JuegoMono()
	{
		super("JuegoMono",new Mono(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
	
	
	
}
