package practica.modelo;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import aima.search.framework.GraphSearch;
import aima.search.framework.Problem;
import aima.search.framework.Search;
import aima.search.framework.SearchAgent;
import aima.search.informed.AStarSearch;
import aima.search.uninformed.DepthLimitedSearch;
import practica.Controlador.Controlador;
import practica.Vista.Interfaz;
import practica.modelo.Log.Log;
import practica.modelo.Persistencia.GeneradorZonasCasino;
import practica.modelo.casino.Casino;
import practica.modelo.casino.Coste;
import practica.modelo.casino.Heuristica;
import practica.modelo.casino.Objetivo;
import practica.modelo.casino.Sucesores;
import practica.modelo.minijuegos.GestorMinijuegos;
import practica.modelo.search.CasinoAStarSearch;
import practica.modelo.search.CasinoGraphSearch;


public class GestorModelo {
	
	Interfaz interfaz;
	Controlador controlador;
	GeneradorZonasCasino generador;
	GestorMinijuegos gestor;
	Casino casino;
	
	public void setVista(Interfaz interfaz)
	{
		this.interfaz=interfaz;
	}
	
	public void setControlador(Controlador controlador)
	{
		this.controlador=controlador;
	}



	public GestorModelo()
	{
		this.generador = new GeneradorZonasCasino();
		this.gestor = new GestorMinijuegos();
		this.generador.registerGestor(gestor);
	}

	public Interfaz getInterfaz() {
		return interfaz;
	}

	public void setInterfaz(Interfaz interfaz) {
		this.interfaz = interfaz;
	}

	public GeneradorZonasCasino getGenerador() {
		return generador;
	}

	public void setGenerador(GeneradorZonasCasino generador) {
		this.generador = generador;
	}

	public GestorMinijuegos getGestor() {
		return gestor;
	}

	public void setGestor(GestorMinijuegos gestor) {
		this.gestor = gestor;
	}

	public Controlador getControlador() {
		return controlador;
	}

	public void ejecutaJuego(int num) {
		StringBuffer bufer = this.gestor.dameMinijuego(num).juegaTodos();
		this.interfaz.mostrarMinijuegoParticular(bufer);
	}

	public void registerVista(Interfaz interfaz2) {
		this.interfaz=interfaz2;
		
	}

	public void generaCasinoAleatorio() {
	
		casino = this.generador.generaCasino3(97,3, this);
		//casino = this.generador.generaCasino3(100, 3); 
		this.interfaz.mostrarCasino(casino.getCasinoString());
	}
	


	public void registrarLogEnCasino(Log log)
	{
		this.casino.registerLog(log);
	}

	public void ejecutaCasino() {
		
		try {
			Sucesores sucesores=null;
			Coste coste=null;
			Objetivo objetivo=null;
			Problem problem = new Problem(this.casino, sucesores =new Sucesores(), objetivo= new Objetivo(),coste= new Coste(),new Heuristica());
			sucesores.registerControlador(controlador);
			coste.registerControlador(controlador);
			objetivo.registerControlador(controlador);
			Search search = new CasinoAStarSearch(new CasinoGraphSearch());
			SearchAgent agent = new SearchAgent(problem, search);
			
			MostrarAcciones(agent.getActions());
			MostrarInstrucciones(agent.getInstrumentation());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	private static void MostrarAcciones( List acciones){
		for (int i = 0; i < acciones.size(); i++) {
			String action = (String) acciones.get(i);
			System.out.println(action);
		}
	
	}


	private static void MostrarInstrucciones(Properties properties ){
		Iterator keys = properties.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			String property = properties.getProperty(key);
			System.out.println(key + " : " + property);
		}
}

	public Casino generaCasinoAleatoriodePrueba() {
		return this.generador.generaCasino3(97,3,this);
	 
	}

	public void cargaCasino(String ruta) {
		
		try {
			casino = this.generador.cargaCasino(ruta, this);		
		//casino = this.generador.generaCasino3(100, 3); 
			this.interfaz.limpiarVistaCasino();
			this.interfaz.mostrarCasino(casino.getCasinoString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
