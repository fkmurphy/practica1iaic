package practica.modelo.minijuegos.Garrafas;

import practica.modelo.minijuegos.Juego;

public class JuegoGarrafas extends Juego{

	public JuegoGarrafas() {
		 		super("JuegoGarrafas", new Garrafas(), new Sucesores(), new Objetivo() ,new Coste(), new Heurística());
		// TODO Auto-generated constructor stub
	}

}
