package practica.modelo.minijuegos.banderaHolandesa;

import practica.modelo.minijuegos.Juego;

public class JuegoBanderaHolandesa  extends Juego{



public JuegoBanderaHolandesa()
{
	super("JuegoBanderaHolandesa",new banderaHolandesa(), new Sucesores(), new Objetivo(), new Coste(), new Heuristica());
}

}
