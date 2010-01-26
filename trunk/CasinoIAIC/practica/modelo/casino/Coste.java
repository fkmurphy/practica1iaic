package practica.modelo.casino;


import practica.Controlador.Controlador;
import aima.search.framework.StepCostFunction;

public class Coste implements StepCostFunction{

Controlador controlador;
	
	public Double calculateStepCost(Object fromState, Object toState,
			String action) {
		
		Casino desdeCasino = (Casino) fromState;
		Casino haciaCasino = (Casino) toState;
		
		Jugador jugador = desdeCasino.getJugador();
		Zona zonaSiguiente = haciaCasino.getJugador().getZonaActual();
		
		this.controlador.vistaMuestraMinijuego("\n");
		this.controlador.vistaMuestraMinijuego("El explorador mira en la puerta de la zona:  "+zonaSiguiente.dameNombreZona()+" para saber cual es su apuesta.\n");
		Integer apuesta = jugador.dameApuestade(zonaSiguiente);
		Double dificultadLocal = zonaSiguiente.getDificultadLocal().doubleValue();
		this.controlador.vistaMuestraMinijuego(zonaSiguiente.dameNombreZona()+" responde que tiene una apuesta de "+apuesta.intValue());
		this.controlador.vistaMuestraMinijuego("\n");
		return dificultadLocal;
	}

	
	public  void registerControlador(Controlador controlador)
	{
		this.controlador=controlador;
	}

	
	
	

}
