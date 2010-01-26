package practica.modelo.casino;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import practica.modelo.GestorModelo;



public class Zona {
	
	Puerta puerta;
	private int idZona;
	private TipoZona tipoZona;
	private Hashtable<Zona,Integer> contiguos;
	private int dificultadLocal;
	private int dificultadGlobal;
	private int premio;


    public int getPremio() {
		return premio;
	}

	public void setPremio(int premio) {
		this.premio = premio;
	}

	private Integer dificultadPropagada;
    
	//private ArrayList<Zona> zonasContiguas=new ArrayList<Zona>();
	private GestorModelo gestorModelo;
	
/*	public ArrayList<Zona> getZonasContiguas() {
		return zonasContiguas;
	}
	
	

	public void setZonasContiguas(ArrayList<Zona> zonasContiguas) {
		this.zonasContiguas = zonasContiguas;
		
	}*/
	
	public void setZonaContigua(Zona contiguo, Integer distancia) {
        this.contiguos.put(contiguo, distancia);
    }

	public Zona(Puerta puerta, int idZona, TipoZona tipoZona)
	{
		this.puerta=puerta;
		this.puerta.setZona(this);
		this.idZona=idZona;
		this.tipoZona=tipoZona;

        this.contiguos=new Hashtable<Zona,Integer>();
        if (this.tipoZona.equals(tipoZona.OBJETIVO))
            this.dificultadPropagada=new Integer(0);
        else dificultadPropagada=Integer.MAX_VALUE;

	}
	
	public TipoZona getTipoZona() {
		return tipoZona;
	}

	public void setTipoZona(TipoZona tipoZona) {
		this.tipoZona = tipoZona;
	}


	
	
	public Zona()
	{

        contiguos=new Hashtable<Zona,Integer>();
	}

	public Puerta getPuerta() {
		return puerta;
	}

	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public void setPuerta(Puerta puerta) {
		this.puerta = puerta;
	}

	public int menorDificultad() {
		
		Iterator it = this.contiguos.keySet().iterator();//zonasContiguas.iterator();
		int menorDificultad=1000000;
		  if (it.hasNext())
		  menorDificultad  = ((Zona) it.next()).getDificultad();
		  Zona aux =null;
		  while (it.hasNext())
		  {
			  aux = (Zona) it.next();
			  if (menorDificultad > aux.getDificultad())
				  menorDificultad= aux.getDificultad();
			  
		  }
		return menorDificultad;
		
		
	}
	
	private int getDificultad() {
		
		return this.dificultadLocal;
	}
	
	public void setDificultad(int dificultad){
		this.dificultadLocal=dificultad;
		this.premio=dificultad*10;
	}

	
	
	public int dameNombreZona()
	{
		return this.idZona;
	}
	
	
	public boolean esObjetivo()
	{
		if (this.tipoZona==TipoZona.OBJETIVO)
			System.out.println("He llegado");
			
		return this.tipoZona == TipoZona.OBJETIVO;
	}

	public void setDificultadPropagada(int propagacion)
	{
		this.dificultadPropagada=propagacion;
	}
	
	public int getDificultadPropagada()
	{
		return this.dificultadPropagada;
	}

	public String dameInformacion() {
		String info = new String();
		
		info = "ID_ZONA "+this.idZona + "CONTIGUOS :" + this.getContiguas2string2() + " ESTRATEGIA: "+this.puerta.getIdEstrategia() + " JUEGO: "+this.puerta.getIdJuego();
				
		return info;
	}
	public String getContiguas2string(){
		String salida ="{";
		Iterator it = this.contiguos.keySet().iterator();//zonasContiguas.iterator();
			
			while (it.hasNext())
			{
				Zona zona = (Zona) it.next();
				salida+= zona.getIdZona()+",";
			}
			salida+="}";
		return salida;
	}
	public String getContiguas2string2(){
//		String salida="{";
//		Iterator it = this.contiguos.el
//				  while (it.hasNext())
//		  {
//			  Zona zona= (Zona) it.next();
//			  salida+= "Z"+zona.getIdZona()+",";
//		  }
//		  salida+="}";
//		
		return this.contiguos.toString();
		  
	}

	public void register(GestorModelo gm) {
		this.gestorModelo = gm;
		
	}
	
	public void propagaDificultad(int estimacionObjetivo, Zona zonaAnterior, int saltos, int maxSaltos) {


        boolean propaga = false;
        int saltosloc=saltos;

        if (saltosloc <= maxSaltos) {

            saltosloc++;

            if (this.tipoZona.equals(TipoZona.OBJETIVO)) {
                this.dificultadPropagada = 0;
                propaga = true;
            } else if (contiguos.containsKey(zonaAnterior)) { // zonaAnterior --> null cuando es zonaObjetivo	
                
            	Integer distanciaZonaAnterior = new Integer(contiguos.get(zonaAnterior));
                if (this.dificultadPropagada > estimacionObjetivo + distanciaZonaAnterior) {
                    this.dificultadPropagada = estimacionObjetivo + distanciaZonaAnterior;
                    propaga = true;
                }

            }

            if (propaga) {
                Iterator it = contiguos.keySet().iterator();
                while (it.hasNext()) {
                    Zona z = ((Zona) it.next());
                    if (!z.equals(zonaAnterior)) {
                        z.propagaDificultad(dificultadPropagada,this, saltosloc, maxSaltos);
                    }
                }
            }
        }
    }
	
	public void propagaDificultadArray(int estimacionObjetivo, Zona zonaAnterior, int saltos, int maxSaltos) {

/*
        boolean propaga = false;
        int saltosloc=saltos;

        if (saltosloc <= maxSaltos) {

            saltosloc++;

            if (this.tipoZona.equals(TipoZona.OBJETIVO)) {
                this.dificultadPropagada = 0;
                propaga = true;
   //         } else if (contiguos.containsKey(zonaAnterior)) { // cuando usabamos hastable
            } else if (this.esContigua(zonaAnterior.getIdZona())) { // zonaAnterior --> null cuando es zonaObjetivo	
                
            	Integer distanciaZonaAnterior = new Integer(dameDificultadZona(zonaAnterior.getIdZona()));
                if (this.dificultadPropagada > estimacionObjetivo + distanciaZonaAnterior) {
                    this.dificultadPropagada = estimacionObjetivo + distanciaZonaAnterior;
                    propaga = true;
                }

            }

            if (propaga) {
                Iterator it = contiguos.keySet().iterator();
                while (it.hasNext()) {
                    Zona z = ((Zona) it.next());
                    if (!z.equals(zonaAnterior)) {
                        z.propagaDificultad(dificultadPropagada,this, saltosloc, maxSaltos);
                    }
                }
            }
        }*/
    }


/*
	private boolean esContigua(int idZona2) {  //esto sobrara cuando pase todo a hastable
		boolean encontrado =false;
	
		Iterator it = this.zonasContiguas.iterator();
		 while (it.hasNext() || !encontrado) {
             Zona z = ((Zona) it.next());
             if (z.getIdZona()==idZona2) {
            	 encontrado = true;
             }
		 }
		return encontrado;
	}
*/
	public Integer getDificultadLocal() {
		return this.dificultadLocal;
	}

	public Hashtable<Zona,Integer> getZonasContiguasHash() {
		return contiguos;
	}

	public boolean contiene(Zona zona) {
		
		return this.contiguos.keySet().contains(zona);
	}
	
	
	
	
}
