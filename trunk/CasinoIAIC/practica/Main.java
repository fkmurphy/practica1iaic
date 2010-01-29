package practica;
import practica.Controlador.*
;
import practica.Vista.Interfaz;

import practica.modelo.*;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Interfaz interfaz = new Interfaz();
		GestorModelo modelo = new GestorModelo();
		modelo.registerVista(interfaz);
		Controlador controlador = new Controlador();
		controlador.setModelo(modelo);
		controlador.setVista(interfaz);
		interfaz.registerControlador(controlador);
		interfaz.setVisible(true);
		
		
		
	}

}
