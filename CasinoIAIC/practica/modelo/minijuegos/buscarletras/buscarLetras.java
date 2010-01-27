package practica.modelo.minijuegos.buscarletras;






public class buscarLetras {
	
	

	char uno;
	    char dos;
	    char uf;
	    char df;
	    boolean iz;
	    boolean opAplicados;
	   
	
	  public buscarLetras(){
	        
	         iz=true;
	         int n = (int)(Math.random()*25)+97;
	         int n1 = (int)(Math.random()*25)+97;
	         uno =(char)n;
	         dos=(char)n1;
	         int a = (int)(Math.random()*25)+97;
	         int b = (int)(Math.random()*25)+97;
	         uf =(char)a;
	         df=(char)b;
	        
	    }
	    
	    public buscarLetras(char u,char d,boolean t,char uu,char dd){
	         
	        
	         uno=u;
	         dos=d;
	         uf=uu;
	         df=dd;
	         iz=t;
	    }
	    
	    public boolean equals( Object arg ) {
	        
	    	boolean ok;
	        if( (arg != null) && (arg instanceof buscarLetras) ) {
	            // Hacemos un moldeado del Object general a tipo java511
	            buscarLetras temp = (buscarLetras)arg;

	            // Se realiza la comparacion y se devuelve el resultado
	            ok=( this.getDf() == temp.getDf() )
	            &&(this.getDos()==temp.getDos()
	            &&(this.getUf()==temp.getUf())
	            &&(this.getUno()==temp.getUno()));
	            }
	        else {
	            // No es del tipo esperado
	            ok=( false );
	            }
	      
	        return ok;
	        
	    }
	    
	    public int hashCode() {
	        int result = 17;
	        int position = this.getDf();
	        result = 37 * result + position;
	        position = this.getDos();
	        result = 37 * result + position;
	        position = this.getUf();
	        result = 37 * result + position;
	        position = this.getUno();
	        result = 37 * result + position;
	     
	        
	        return result;
	    }
	    
	    
	    public buscarLetras applyOperator(int operadores){
	    	this.opAplicados= false;
	       buscarLetras nextState = new buscarLetras(this.uno,this.dos,this.iz,this.uf,this.df);
	       if((operadores==0)&&(this.iz)){
	          if (this.uno!='z') nextState.uno=(char)((int)this.uno+1);
	          else nextState.uno='a';
	          nextState.iz=!(this.iz);
	          this.opAplicados= true;
	       }
	       if((operadores==1)&&(this.iz)){
	          if (this.uno!='a') nextState.uno=(char)((int)this.uno-1);
	          else nextState.uno='z';
	          nextState.iz=!(this.iz);
	          this.opAplicados= true;
	       }
	       if((operadores==2)&&(!this.iz)){
	          if (this.dos!='z') nextState.dos=(char)((int)this.dos+1);
	          else nextState.dos='a';
	          nextState.iz=!(this.iz);
	          this.opAplicados= true;
	       }
	       if((operadores==3)&&(!this.iz)){
	          if (this.dos!='a') nextState.dos=(char)((int)this.dos-1);
	          else nextState.dos='z';
	          nextState.iz=!(this.iz);
	          this.opAplicados= true;
	       }
	         return nextState;
	      }
	    
	    public boolean opAplicados(){
	    	return this.opAplicados;
	    }
	     
	   public int getCoste(){
		   return 1;
	   }
	      
	      public boolean isGoal(){
	         return (uno==uf&&dos==df);
	      }
	      
	    
	     
	      public String toString(){
	         return "("+uno+" "+dos+")"+"("+uf+" "+df+")";
	      }
	      
	      public float h(){
	          return Math.abs(uf-uno)+Math.abs(df-dos);
	      }
	      
	      public char getUno() {
	  		return uno;
	  	}

	  	public void setUno(char uno) {
	  		this.uno = uno;
	  	}

	  	public char getDos() {
	  		return dos;
	  	}

	  	public void setDos(char dos) {
	  		this.dos = dos;
	  	}

	  	public char getUf() {
	  		return uf;
	  	}

	  	public void setUf(char uf) {
	  		this.uf = uf;
	  	}

	  	public char getDf() {
	  		return df;
	  	}

	  	public void setDf(char df) {
	  		this.df = df;
	  	}

	  	public boolean isIz() {
	  		return iz;
	  	}

	  	public void setIz(boolean iz) {
	  		this.iz = iz;
	  	}

}
