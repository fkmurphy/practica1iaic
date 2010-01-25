package practica.modelo.minijuegos.Mono;

public class Mono {
    
	private int pos;
	private int caja;
	private boolean sobrecaja;
	private boolean platano;
	
	public Mono(){
	    
	    pos=0;
	    sobrecaja= false;
	    caja=2;
	    platano=false;
	    
	}
	
	public Mono(int pos, int caja, boolean sobrecaja, boolean platano){
		this.caja= caja;
		this.platano= platano;
		this.pos= pos;
		this.sobrecaja= sobrecaja;
	}
	
	 public boolean esObjetivo(){
         return platano == true;
     }
	 
	 public void cambiaPos(int p){
         this.pos = p;
     }    
	 public void ponSubido(boolean s){
         this.sobrecaja = s;
	 }
 
	 public void ponCaja(int p){
         this.caja = p;
	 }       
 
	 public void ponPlatano(boolean p){
         this.platano = p;
	 }
	 
	 public int getCoste(){
			return 1;
		}
 
	 public int damePos(){
         return this.pos;
	 }
 
	 public boolean dameSubido(){
         return this.sobrecaja;
	 }
 
	 public int damePosCaja(){
		 return this.caja;
	 }
 
	 public boolean damePlatano(){
         return this.platano;
	 }
	 
	 public float hueristica() {
           if (pos == 0) return 5;
           if (pos == 2 && caja != 2) return 5;
           if (pos == 1 && caja != 1) return 4;
           if (pos == 2 && caja == 2 && !sobrecaja) return 3;
           if (pos == 2 && caja == 2 && sobrecaja) return 2;
           if (pos == 1 && sobrecaja && !platano) return 1;
           if (pos == 1 && sobrecaja && platano) return 0;
           return 6;
	   }
	 public String toString() {
           return "(Posicion:" + pos + ", Subido:" + (sobrecaja?1:0) + ", Caja:" + caja + ", Platano:" + (platano?1:0) + ")";
     }

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getCaja() {
		return caja;
	}

	public void setCaja(int caja) {
		this.caja = caja;
	}

	public boolean isSobrecaja() {
		return sobrecaja;
	}

	public void setSobrecaja(boolean sobrecaja) {
		this.sobrecaja = sobrecaja;
	}

	public boolean isPlatano() {
		return platano;
	}

	public void setPlatano(boolean platano) {
		this.platano = platano;
	}



	 
	
}
