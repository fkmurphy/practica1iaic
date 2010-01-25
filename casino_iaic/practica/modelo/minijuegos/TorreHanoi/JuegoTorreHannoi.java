package practica.modelo.minijuegos.TorreHanoi;

import practica.modelo.minijuegos.Juego;



public class JuegoTorreHannoi extends Juego{
	
	public JuegoTorreHannoi()
	{
		super("JuegoTorreHannoi",new TorreHannoi(), new Sucesores(), new Objetivo(), new Coste(), new Heur’stica());
	}
	
	

}
