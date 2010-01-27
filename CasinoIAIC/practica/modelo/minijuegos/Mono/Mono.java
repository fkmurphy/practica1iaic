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
	
	public boolean equals( Object arg ) {
	    // Se comprueba que el argumento es del tipo adecuado y
	    // que no es nulo. Si lo anterior se cumple se realiza
	    // la comprobacion de equivalencia de los datos.
	    // Observese que se ha empleado el operador instanceof
		boolean ok;
	    if( (arg != null) && (arg instanceof Mono) ) {
	        // Hacemos un moldeado del Object general a tipo java511
	        Mono temp = (Mono)arg;

	        // Se realiza la comparacion y se devuelve el resultado
	        ok=( this.getPos() == temp.getPos() )
	        &&(this.getCaja()==temp.getCaja())
	        &&(this.dameSubido()==temp.dameSubido())
	        &&(this.isPlatano()==temp.isPlatano());
	        }
	    else {
	        // No es del tipo esperado
	        ok=( false );
	        }
	  
	    return ok;
	    
	}
	
	public int hashCode() {
	    int result = 17;
	    int position = this.getCaja();
	    result = 37 * result + position;
	    position = this.getPos();
	    result = 37 * result + position;
	  
	    if (this.isPlatano()) position = 1;
	    else position=0;
	    result = 37 * result + position;
	    
	    if (this.dameSubido()) position = 1;
	    else position=0;    
	    result = 37 * result + position;
	    
	    return result;
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
