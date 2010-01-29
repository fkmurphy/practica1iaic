package practica.modelo.Persistencia;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;


import practica.modelo.GestorModelo;
import practica.modelo.casino.Casino;
import practica.modelo.casino.Jugador;
import practica.modelo.casino.Puerta;
import practica.modelo.casino.TipoZona;
import practica.modelo.casino.Zona;
import practica.modelo.minijuegos.GestorMinijuegos;
import practica.modelo.minijuegos.Juego;


public class GeneradorZonasCasino {
	
	Zona[][] tablaZonas;
	GestorMinijuegos gestor;

	/*public  Casino generaCasinos2(GestorModelo gm){
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
		Juego juegoAux = null;
		
		//Puerta nuevaPuerta = new Puerta();
		//listaZonas[0] = new Zona(nuevaPuerta,0,TipoZona.ORIGEN);
		Puerta nuevaPuerta;
		Random rnd=new Random();
		
		for (int i=0;i<100;i++){
			nuevaPuerta = new Puerta();
			nuevaPuerta.setGestorModelo(gm);
			if (i>0 && i<97){
				
				nuevaPuerta.setJuego(juegoAux=gestor.dameMinijuego(juego[2]),juego[2]);
				nuevaPuerta.setIdEstrategia(estrategia[3]);
				nuevaPuerta.setApuesta(10);
				//nuevaPuerta.setPremio(100);
				listaZonas[i] = new Zona(nuevaPuerta,i,TipoZona.INTERMEDIO);
				listaZonas[i].setDificultad(this.dameDificultadJuego(2));
				listaZonas[i].setPremio(100);
				nuevaPuerta.setZona(listaZonas[i]);
				}else{//cambiar esto
				nuevaPuerta.setJuego(gestor.dameMinijuego(1),1);
				nuevaPuerta.setIdEstrategia(1);
				listaZonas[i] = new Zona(nuevaPuerta,i,TipoZona.INTERMEDIO);
				nuevaPuerta.setZona(listaZonas[i]);
			}
			
			//listaZonas[i].register(gm); sobra
			listaZonas[i].setDificultad(rnd.nextInt(20));
			
		}
		
		//a–adimos zonas contiguas a cada zona creada previamente
		ArrayList<Zona> zonasContiguas;
		Hashtable<Zona,Integer> contiguas;
		
		for (int i=0;i<100;i++){
			zonasContiguas = new ArrayList<Zona>();
			//for (int j=i+1;j<100;j++){
			for (int j=0;j<100;j++){ //eficiencia regular tirando a mal, pero solo se ejecutar‡ para inicializar
				if (ad[i][j]==1){
					zonasContiguas.add(listaZonas[j]);
					contiguas.
					listaZonas[i].setZonaContigua(listaZonas[j],)
				}
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

	}*/
	

	public  Casino generaCasino3(int numeroZonas,int numeroObjetivos,GestorModelo gm){

	    ArrayList<Zona> listaZonas=new ArrayList<Zona>();

	    Puerta nuevaPuerta;
	   
			
			//nuevaPuerta.setGestorModelo(gm);
			
	    for (int i=0;i<numeroObjetivos;i++) {
	    	/*nuevaPuerta = new Puerta();
	    	listaZonas.add(new Zona(nuevaPuerta,i,TipoZona.OBJETIVO));// (planetaEstado.OBJETIVO,"P"+(i+1)));
	    	listaZonas.get(listaZonas.size()-1).setDificultad(1);
	    	*/
	    	nuevaPuerta = new Puerta(gm,1,1);   //a–ade juego y estrategia a la puerta
	    	 nuevaPuerta.setApuesta(0);  //a–ade apuesta a la puerta
	    	 listaZonas.add(new Zona(nuevaPuerta,i,TipoZona.OBJETIVO));
	    	 listaZonas.get(listaZonas.size()-1).setDificultad(1);
	    	
	    }
	    
	    
	    
	    int juego=1;
	    int estrategia=1;
	     for (int i=0;i<numeroZonas;i++) { //+1 sera el planeta origen que luego se buscara para buscar el mas alejado de los planetas objetivos
	    	 nuevaPuerta = new Puerta(gm,juego,estrategia);   //a–ade juego y estrategia a la puerta
	    	 nuevaPuerta.setApuesta(this.dameDificultadJuego(juego)*5);  //a–ade apuesta a la puerta
	    	 listaZonas.add(new Zona(nuevaPuerta,i+numeroObjetivos,TipoZona.INTERMEDIO));
	    	 listaZonas.get(listaZonas.size()-1).setDificultad(this.dameDificultadJuego(juego)); //a–ade dificultad local Y premio a la Zona
	    	 if(juego==12){//vamos asignando juegos con estrategias
	    		 juego=1;
	    		 estrategia++;	    		
	    	 }else juego++;
	    		     
	     }

	     for (int i=0;i<numeroZonas+numeroObjetivos;i++) {

	      //   Random distancia = new Random() ; //dificultad!!!
	         Random indiceContiguo = new Random();
	         //Random numContiguos = new Random();

	         int np=2;//numContiguos.nextInt(2);



	         //for (int j=0;j<=np;j++){
	         int j=0;
             int indice=i;
	        while(j<=np){

	             while ((indice==i) || (listaZonas.get(i).contiene(listaZonas.get(indice)))){
	             indice= indiceContiguo.nextInt(numeroZonas+numeroObjetivos);//indice contiene un idZona que no es contigua (aœn)
	             }
	             if((listaZonas.get(i).getNumContiguos()<3)&&(listaZonas.get(indice).getNumContiguos()<3)){
	            	 listaZonas.get(i).setZonaContigua(listaZonas.get(indice),listaZonas.get(indice).getDificultadLocal());
	            	 listaZonas.get(indice).setZonaContigua(listaZonas.get(i),listaZonas.get(i).getDificultadLocal());
	             }
	             j++;

	         }if (listaZonas.get(i).getNumContiguos()<4){
	        	 indice = (i+5)%(numeroZonas+numeroObjetivos);
	        	 listaZonas.get(i).setZonaContigua(listaZonas.get(indice),listaZonas.get(indice).getDificultadLocal());
            	 listaZonas.get(indice).setZonaContigua(listaZonas.get(i),listaZonas.get(i).getDificultadLocal());
	         }
	        	 

	     }


	 
	    // for (int i=0;i<numeroObjetivos;i++){
	    	 listaZonas.get(0).propagaDificultad(0, null,0,50);
	    //  }

	    int min=Integer.MAX_VALUE;
	    int max=Integer.MIN_VALUE;

	      for (int i=0;i<listaZonas.size();i++){

	      int aux=listaZonas.get(i).getDificultadPropagada();

	      if (min>aux)
	          min=aux;
	      if (max<aux)
	          max=aux;

	      }

	      GestorMinijuegos.setRango(min,max);
	      
	    for (int i=0;i<numeroObjetivos;i++){
	    	listaZonas.get(i).setSaltos(0,listaZonas.get(i)); //recursivamente aplicamos saltos
	      }
	      

	      Zona zonaOrigen=generaZonaOrigen(listaZonas); //busca la zona mas alejada de los objetivos y lo marca como origen

	      Jugador jugador=new Jugador(zonaOrigen);

	      StringBuffer printCasinoMiniJuego=new StringBuffer();
	      printCasinoMiniJuego.append("Id Zona,Tipo,Juego,Estrategia,NumContiguos,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,estimacion\n");
	      for (int i=0;i<listaZonas.size();i++) {

	    	  System.out.print(listaZonas.get(i).getIdZona()+",tipo "
	                  +listaZonas.get(i).getTipoZona()+",juego "
	                  +listaZonas.get(i).getPuerta().getIdJuego()+",estrat "
	                  +listaZonas.get(i).getPuerta().getIdEstrategia()+",contiguos "
	                  +listaZonas.get(i).getContiguas2string2()+",saltos\t "
	          			+listaZonas.get(i).getSaltos()+"    ,DiffPropagada "
	          			+listaZonas.get(i).getDificultadPropagada()+"\n");
	

	    	  printCasinoMiniJuego.append(listaZonas.get(i).getIdZona()+","
	                          +listaZonas.get(i).getTipoZona()+","
	                          +listaZonas.get(i).getPuerta().getIdJuego()+","
	                          +listaZonas.get(i).getPuerta().getIdEstrategia()+","	                          
	                          +listaZonas.get(i).getNumContiguos()+","
	                          +listaZonas.get(i).getContiguas2string2()+","
	    	  				  +listaZonas.get(i).getDificultadPropagada()+"\n");
	          }
	     
	      return new Casino(zonaOrigen,jugador,numeroZonas,numeroObjetivos,printCasinoMiniJuego.toString());
	     
	    }
	
	
	
		
	
	







	public StringBuffer casinoABuffer(Zona[] listaZonas)
	{
		StringBuffer bufer = new StringBuffer();
		for (int i=0;i<100;i++)
				bufer.append(listaZonas[i].dameInformacion()+ "\n");
				
		return bufer;
		
	}



	private static Zona generaZonaOrigen(ArrayList<Zona> listaZonas) {
		/* int maxDistancia=Integer.MIN_VALUE;
	        int indice=-1;
	        int i=0;

	        Iterator it=listaPlanetas.iterator();

	        while (it.hasNext()){
	           planeta p= ((planeta)it.next());

	           if (p.getEstimacionDistancia()>maxDistancia)
	            {  maxDistancia=p.getEstimacionDistancia();
	               indice=i;
	            }

	           i++;
	        }

	        listaPlanetas.get(indice).setEstado(planetaEstado.ORIGEN);

	        System.out.print(listaPlanetas.get(indice).getEstimacionDistancia()+"\n");


	        return listaPlanetas.get(indice);

	        */
	        //////////////

		        int maxDistancia=Integer.MIN_VALUE;
		        int indice=-1;
		        int i=0;

		        Iterator it=listaZonas.iterator();

		        while (it.hasNext()){
		           Zona p= ((Zona)it.next());

		           if ((p.getSaltos()>maxDistancia)&&(p.getSaltos()<Integer.MAX_VALUE)&&(p.getTipoZona().equals(TipoZona.INTERMEDIO)))//.getDificultadPropagada()>maxDistancia)
		            {  maxDistancia=p.getSaltos();
		               indice=i;
		            }

		           i++;
		        }

		        listaZonas.get(indice).setTipoZona(TipoZona.ORIGEN);

		        System.out.print(listaZonas.get(indice).getSaltos()+"\n");


		        return listaZonas.get(indice);

		    }








	public void registerGestor(GestorMinijuegos gestor) {
		this.gestor=gestor;
		
	}
	
	


	public int dameDificultadJuego(int idJuego)
	{
		switch (idJuego)
		{			case 1: return 2;
					case 2: return 3;
					case 3: return 3;
					case 4: return 2;
					case 5: return 1;//TODO
					case 6: return 6;
					case 7: return 3;
					case 8: return 2;
					case 9: return 4;			//100;
					case 10: return 2; 			//2;
					case 11: return 4;			//100;
					case 12: return 4;			//100;
		}
		return 0;
		
	}
	
	public Casino cargaCasino(String fileName,GestorModelo gm) throws FileNotFoundException{
	CsvReader reader;
	boolean error=false;
	ArrayList<Zona> listaZonas=new ArrayList<Zona>();
	int idZonaOrigen = -1;
	try {
		reader = new CsvReader(fileName);


		reader.readHeaders();
		 
		 Puerta nuevaPuerta;
		while (reader.readRecord())
		{
			int idZona = Integer.parseInt(reader.get("Id Zona"));
			String tipoZona = reader.get("Tipo");
			int juego = Integer.parseInt(reader.get("Juego"));
			int estrategia = Integer.parseInt(reader.get("Estrategia"));
			int numContiguos  = Integer.parseInt(reader.get("NumContiguos"));
			int estimacion = Integer.parseInt(reader.get("estimacion"));
			
			
			// Aqui lo interpretamos

			if(idZona<3){ // creamos origenes
				nuevaPuerta = new Puerta(gm,1,1);   //a–ade juego y estrategia a la puerta
		    	 nuevaPuerta.setApuesta(0);  //a–ade apuesta a la puerta
		    	 listaZonas.add(new Zona(nuevaPuerta,idZona,TipoZona.OBJETIVO));
		    	 listaZonas.get(listaZonas.size()-1).setDificultad(1);
		    	 listaZonas.get(listaZonas.size()-1).setDificultadPropagada(estimacion);
				
			}else{  // creamos zonas intermedias
				nuevaPuerta = new Puerta(gm,juego,estrategia);   //a–ade juego y estrategia a la puerta
		    	 nuevaPuerta.setApuesta(this.dameDificultadJuego(juego)*5);  //a–ade apuesta a la puerta
		    	 if(tipoZona.equalsIgnoreCase("ORIGEN")){
			    	 listaZonas.add(new Zona(nuevaPuerta,idZona,TipoZona.ORIGEN));
			    	 idZonaOrigen=idZona;
		    	 }else{
			    	 listaZonas.add(new Zona(nuevaPuerta,idZona,TipoZona.INTERMEDIO));
		    	 }
		    	 listaZonas.get(listaZonas.size()-1).setDificultad(this.dameDificultadJuego(juego));
		    	 listaZonas.get(listaZonas.size()-1).setDificultadPropagada(estimacion);
				
			}
			
			//a–adimos los contiguos
			for (int i=1;i<=numContiguos;i++){
				int idContiguo  = Integer.parseInt(reader.get("c"+i));
				if (idContiguo<idZona){ //a–ade contiguo
					
					listaZonas.get(idZona).setZonaContigua(listaZonas.get(idContiguo),listaZonas.get(idContiguo).getDificultadLocal());
	            	 listaZonas.get(idContiguo).setZonaContigua(listaZonas.get(idZona),listaZonas.get(idZona).getDificultadLocal());
				}
			}
			
			
		}//fin de while

		reader.close();
	} catch (Exception e) {
		error =true;
	}
	
	
	 //for (int i=0;i<3;i++){
    	// listaZonas.get(0).propagaDificultad(0, null,0,20);
      //}

    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;

      for (int i=0;i<listaZonas.size();i++){

      int aux=listaZonas.get(i).getDificultadPropagada();

      if (min>aux)
          min=aux;
      if (max<aux)
          max=aux;

      }

      GestorMinijuegos.setRango(min,max);

      Zona zonaOrigen=listaZonas.get(idZonaOrigen);//generaZonaOrigen(listaZonas); //busca la zona mas alejada de los objetivos y lo marca como origen

      Jugador jugador=new Jugador(listaZonas.get(idZonaOrigen));

      StringBuffer printCasinoMiniJuego=new StringBuffer();

      for (int i=0;i<listaZonas.size();i++) {

/*           printEspacioMicromundo.append(listaPlanetas.get(i)+" "
                          +listaPlanetas.get(i).getEstado()+" "
                          +listaPlanetas.get(i).printHijosContiguos()+" "
                          +listaPlanetas.get(i).getNaveHostil()+" EstimDist: "
                          +listaPlanetas.get(i).getEstimacionDistancia()+"\n");
*/

    	  System.out.print(listaZonas.get(i).getIdZona()+",tipo "
                  +listaZonas.get(i).getTipoZona()+",juego "
                  +listaZonas.get(i).getPuerta().getIdJuego()+",estrat "
                  +listaZonas.get(i).getPuerta().getIdEstrategia()+",contiguos "
                  +listaZonas.get(i).getContiguas2string2()+",saltos\t "
          			+listaZonas.get(i).getSaltos()+"    ,DiffPropagada "
          			+listaZonas.get(i).getDificultadPropagada()+"\n");
    	  
    	  printCasinoMiniJuego.append(listaZonas.get(i).getIdZona()+","
                  +listaZonas.get(i).getTipoZona()+","
                  +listaZonas.get(i).getPuerta().getIdJuego()+","
                  +listaZonas.get(i).getPuerta().getIdEstrategia()+","	                          
                  +listaZonas.get(i).getNumContiguos()+","
                  +listaZonas.get(i).getContiguas2string2()
    	  		  +listaZonas.get(i).getDificultadPropagada()+"\n");	
          }
      		
      return new Casino(zonaOrigen,jugador,100,3,printCasinoMiniJuego.toString());
     
	
	
	
	
	
}


}
