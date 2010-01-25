package practica.modelo.Persistencia;

import java.util.ArrayList;
import java.util.Random;


import practica.modelo.GestorModelo;
import practica.modelo.casino.Casino;
import practica.modelo.casino.Jugador;
import practica.modelo.casino.Puerta;
import practica.modelo.casino.TipoZona;
import practica.modelo.casino.Zona;
import practica.modelo.minijuegos.GestorMinijuegos;


public class GeneradorZonasCasino {
	
	Zona[][] tablaZonas;
	GestorMinijuegos gestor;
//	public  Casino generaCasinos()
//	{
//		
//		tablaZonas = new Zona[9][9];
//		Puerta nuevaPuerta = new Puerta();
//		tablaZonas[0][0] = new Zona(nuevaPuerta,0,TipoZona.ORIGEN);
//		Jugador jugador = new Jugador();
//		jugador.setZonaActual(tablaZonas[0][0]);
//		GestorMinijuegos gestorMinijuegos = new GestorMinijuegos();
//		for (int i=0; i<10; i++)
//			for (int j=1;j<10; j++)
//			{
//				if ((((i==9) && (j==9)) || ((i==9) && (j==0)) || (i==0) && (j==9)))
//					{
//					Puerta puertaObjetivo = new Puerta();
//					tablaZonas[i][j] = new Zona(puertaObjetivo,i+j,TipoZona.OBJETIVO);
//					puertaObjetivo.setZona(tablaZonas[i][j]);
//					}
//				else
//				{
//					Puerta puertaIntermedio = new Puerta();
//					puertaIntermedio.setJuego(gestorMinijuegos.dameMinijuego(i));
//					tablaZonas[i][j] = new Zona(puertaIntermedio,i+j,TipoZona.INTERMEDIO);
//				}
//					
//			}
//
//		return new Casino(100,3,jugador,casinoABuffer(listaZonas).toString());
//		
//	}
//	
	public  Casino generaCasinos2(GestorModelo gm){
		//********* esto se cambiar‡
		int ad[][]= new int[100][100]; //matriz de adyacencia
		for(int i=0;i<100;i++)
				for(int j=0;j<100;j++){
					ad[i][j]=0;
					}
		
		for(int i=0;i<100;i++){ 
			if(i<90) ad[i][i+10]=1;
			if(i%10!=9) ad[i][i+1]=1;
		}
			
		//Aqu’ va la lista de juegos y estrategias en cada zona
		int juego[] = new int[100];  // solo se rellenar‡n del 1 al 96
		int estrategia[] = new int[100];
		int id=1;
		for(int i=1;i<13;i++)
			for(int j=1;j<9;j++){
				juego[id]=i;
				estrategia[id]=j;
				id++;
				
			}
			
		
		
		//**************************
		Zona[] listaZonas;		
		listaZonas=new Zona[100];
			
		
		//Puerta nuevaPuerta = new Puerta();
		//listaZonas[0] = new Zona(nuevaPuerta,0,TipoZona.ORIGEN);
		Puerta nuevaPuerta;
		Random rnd=new Random();
		for (int i=0;i<100;i++){
			nuevaPuerta = new Puerta();
			nuevaPuerta.setGestorModelo(gm);
			if (i>0 && i<97){
				nuevaPuerta.setJuego(gestor.dameMinijuego(juego[1]),juego[1]);
				nuevaPuerta.setIdEstrategia(estrategia[1]);
				listaZonas[i] = new Zona(nuevaPuerta,i,TipoZona.INTERMEDIO);
			}else{//cambiar esto
				nuevaPuerta.setJuego(gestor.dameMinijuego(1),1);
				nuevaPuerta.setIdEstrategia(1);
				listaZonas[i] = new Zona(nuevaPuerta,i,TipoZona.INTERMEDIO);
			}
			
			//listaZonas[i].register(gm); sobra
			listaZonas[i].setDificultad(rnd.nextInt(20));
			
		}
		
		//a–adimos zonas contiguas a cada zona creada previamente
		ArrayList<Zona> zonasContiguas;
		
		for (int i=0;i<100;i++){
			zonasContiguas = new ArrayList<Zona>();
			//for (int j=i+1;j<100;j++){
			for (int j=0;j<100;j++){ //eficiencia regular tirando a mal, pero solo se ejecutar‡ para inicializar
				if (ad[i][j]==1)zonasContiguas.add(listaZonas[j]);
				//if (ad[j][i]==1)zonasContiguas.add(listaZonas[j]);
			}
			
			listaZonas[i].setZonasContiguas(zonasContiguas);
		}
		
		Jugador jugador = new Jugador();
		listaZonas[0].setTipoZona(TipoZona.ORIGEN);
		jugador.setZonaActual(listaZonas[0]);
		listaZonas[97].setTipoZona(TipoZona.OBJETIVO);
		listaZonas[98].setTipoZona(TipoZona.OBJETIVO);
		listaZonas[99].setTipoZona(TipoZona.OBJETIVO);
		
		
		
		return new Casino(100,3,jugador,casinoABuffer(listaZonas).toString());

	}
	
	
	

		
		
		
		
	
	
	public StringBuffer casinoABuffer(Zona[] listaZonas)
	{
		StringBuffer bufer = new StringBuffer();
		for (int i=0;i<100;i++)
				bufer.append(listaZonas[i].dameInformacion()+ "\n");
				
		return bufer;
		
	}










	public void registerGestor(GestorMinijuegos gestor) {
		this.gestor=gestor;
		
	}
	
	





}
