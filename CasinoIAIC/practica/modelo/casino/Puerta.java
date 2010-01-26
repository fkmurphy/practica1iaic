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
	public Puerta()
	{
		this.apuesta  = new Random(100).nextInt();
		
	}
	
	public void setZona(Zona zona)
	{
		this.zona=zona;
	}
	
	public int getIdJuego() {
		return idJuego;
	}

	public void setJuego(Juego juego,int idJuego) {
		this.juego = juego;
		this.idJuego = idJuego;
	}

	public int getIdEstrategia() {
		return idEstrategia;
	}

	public void setIdEstrategia(int idEstrategia) {
		this.idEstrategia = idEstrategia;
	}

	public Puerta(int apuesta)
	{
		this.apuesta=apuesta;
	}

	public int getApuesta() {
		return apuesta;
	}

	public void setApuesta(int apuesta) {
		this.apuesta = apuesta;
	}

	public int ejecutaJuego()
	{
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
