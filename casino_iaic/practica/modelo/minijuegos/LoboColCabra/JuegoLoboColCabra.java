package practica.modelo.minijuegos.LoboColCabra;

import practica.modelo.minijuegos.Juego;

public class JuegoLoboColCabra extends Juego{
	
	
	public JuegoLoboColCabra()
	{
		super("JuegoColCabra", new LoboColCabra(), new Sucesores(), new Objetivo(), new Coste(), new Heuristica());
	}

}
