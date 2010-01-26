package practica.modelo.minijuegos.buscarletras;
import practica.modelo.minijuegos.Juego;
public class JuegoBuscarLetras extends Juego {
	
	public JuegoBuscarLetras()
	{
		super("JuegoBuscarLetras",new buscarLetras(), new Sucesores(), new Objetivo(), new Coste(), new Heuristica());
	}

}
