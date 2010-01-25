package practica.Controlador;

import practica.Vista.Interfaz;
import practica.modelo.GestorModelo;
import practica.modelo.Log.Log;


public class Controlador {
	
	Interfaz interfaz;
	GestorModelo gestorModelo;
	Log log;
	public Controlador()
	{
		this.log=new Log();
	}
	
	public void setVista(Interfaz vista)
	{
		this.interfaz=vista;
	}

	public void setModelo(GestorModelo modelo)
	{
		this.gestorModelo=modelo;
	}

	public void ejecutarJuego(int num)
	{
			this.gestorModelo.ejecutaJuego(num);
	}
	
	
	public void vistaMuestraMinijuego(StringBuffer resultado)
	{
		this.interfaz.mostrarMinijuegoParticular(resultado);
	}
	
	
	
	
	
	public void generarCasinoAleatorio()
	{
		
		
		this.gestorModelo.generaCasinoAleatorio();
		this.gestorModelo.registrarLogEnCasino(log);
		
	}
	
	public void cargardeFichero(String ruta)
	{
		System.out.println("Hay que hacerlo JuanManolo!");
	}

	public void guardarCasino()
	{
		System.out.println("Hay que hacerlo JuanManolo!");
	}

	
	public void ejecutaCasino()
	{
		this.gestorModelo.ejecutaCasino();
	}
}
