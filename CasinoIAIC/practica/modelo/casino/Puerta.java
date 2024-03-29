package practica.modelo.casino;

import java.util.Random;

import practica.modelo.GestorModelo;
import practica.modelo.Log.Log;
import practica.modelo.minijuegos.Juego;

public class Puerta {
	
	
	private int apuesta;
	private Juego juego;
	private int idJuego;
	private int idEstrategia;
	private int premio;
	private Zona zona;
	private GestorModelo gestor;
	public Puerta(GestorModelo gm,int idjuego,int estrategia)
	{
		this.gestor = gm;
		this.juego=this.gestor.getGestor().dameMinijuego(idjuego);
		this.idJuego=idjuego;
		this.idEstrategia=estrategia;
		
	}
	
	public void setZona(Zona zona)
	{
		this.zona=zona;
	}
	
	public int getIdJuego() {
		return idJuego;
	}

	public void setJuego(int idJuego) {
		
		this.juego = this.gestor.getGestor().dameMinijuego(idJuego);
		this.idJuego = idJuego;
	}

	public int getIdEstrategia() {
		return idEstrategia;
	}

	public void setIdEstrategia(int idEstrategia) {
		this.idEstrategia = idEstrategia;
	}



	public Puerta() {
		juego=null;
		// TODO Auto-generated constructor stub
	}

	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}

	public int ejecutaJuego()
	{
		if(this.juego==null){
			return 0;
		}
		ResultadoPrueba resultado= this.juego.juega(this.getIdEstrategia());
		this.gestor.getInterfaz().mostrarMinijuego(resultado.getPrintBatalla());
		if (resultado.getResultado())
		{	
		//Log.addCasino("El explorador supera la prueba y consigue entrar a la zona "+this.zona.getIdZona()+"\n");	
		return this.zona.getPremio()-apuesta;
		//return this.premio-apuesta;
		}
		else 
			{//Log.addCasino("El explorador no supera la prueba y debe intentar en otra puerta contigua");
			return 0;
			}

			
	}
	
	public void setPremio(int premio)
	{
		this.premio=premio;
	}

	public void setGestorModelo(GestorModelo gm) {
		// TODO Auto-generated method stub
		this.gestor = gm;
	}

}
