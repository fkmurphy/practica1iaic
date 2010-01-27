package practica.modelo.minijuegos.NB;










public class NB {
	private int tablero [];
	  private  int vacio;
	  private  int coste;
	  private boolean apOperadores;
	    
	    // 0 = negro, 1 = blanco, hueco = 2;
	    public NB(){
	       
	         tablero = new int [7];
	         tablero[0]=0;
	         tablero[1]=0;
	         tablero[2]=0;
	         tablero[3]=2;
	         tablero[4]=1;
	         tablero[5]=1;
	         tablero[6]=1;
	         vacio=3;
	      
	    }
	    
	    public int getCoste() {
			return coste;
		}

		public void setCoste(int coste) {
			this.coste = coste;
		}

		public NB(int T[],int vac){
	        
	         tablero = new int [7];
	         for(int i= 0;i<7;i++){
	                tablero[i] =T[i];
	         }
	         vacio=vac;
	    }
		
	    
	    public boolean equals( Object arg ) {
		        
		    	boolean ok;
		        if( (arg != null) && (arg instanceof NB) ) {
		            // Hacemos un moldeado del Object general a tipo java511
		            NB temp = (NB)arg;

		            // Se realiza la comparacion y se devuelve el resultado
		            ok=( this.getVacio() == temp.getVacio() )
		            &&(this.getTablero()==temp.getTablero());
		           
		           
		            }
		        else {
		            // No es del tipo esperado
		            ok=( false );
		            }
		      
		        return ok;
		        
		    }
		    
		    public int[] getTablero() {
			return tablero;
		}

		public void setTablero(int[] tablero) {
			this.tablero = tablero;
		}

		public int getVacio() {
			return vacio;
		}

		public void setVacio(int vacio) {
			this.vacio = vacio;
		}

			public int hashCode() {
		        int result = 17;
		        int position = this.getVacio();
		        result = 37 * result + position;
		       
		   
		        return result;
		    }
	    
			
		  
		      
	    public NB applyOperator(int  op){
	    	
	    int v= this.vacio;
	 this.apOperadores=false;
        NB nextState = new NB(this.tablero,this.vacio);
	   
	       if((op==0)&&((v>=1)&&(v<=6))){
	    	   int temp = nextState.tablero[v-1];
	          nextState.tablero[v] = temp;
	          nextState.tablero[v-1]= 2;
	          nextState.vacio = v-1;
	          nextState.setCoste(1);
	          this.apOperadores=true;
	       }
	       if((op==1)&&((v>=2)&&(v<=6))){
	    	   nextState.tablero[v] = nextState.tablero[v-2];
	    	   nextState.tablero[v-2]= 2;
	    	   nextState.vacio = v-2;  
	    	   nextState.setCoste(2);
	    	   this.apOperadores=true;
	       }
	       if((op==2)&&((v>=3)&&(v<=6))){
	    	   nextState.tablero[v] = nextState.tablero[v-3];
	    	   nextState.tablero[v-3]= 2;
	    	   nextState.vacio = v-3;
	          nextState.setCoste(3);
	          this.apOperadores=true;
	       }
	       if((op==3)&&((v>=0)&&(v<=5))){
	    	   nextState.tablero[v] = nextState.tablero[v+1];
	    	   nextState.tablero[v+1]= 2;
	    	   nextState.vacio = v+1; 
	          nextState.setCoste(1);
	          this.apOperadores=true;
	       }
	       if((op==4)&&((v>=0  && v<=4))){
	    	   nextState.tablero[v] = nextState.tablero[v+2];
	    	   nextState.tablero[v+2]= 2;
	    	   nextState.vacio = v+2;  
	    	   nextState.setCoste(2);
	    	   this.apOperadores=true;
	       }
	       if((op==5)&&((v>=0 && v<=3))){
	    	   nextState.tablero[v] =nextState.tablero[v+3];
	    	   nextState.tablero[v+3]= 2;
	    	   nextState.vacio = v+3;  
	    	   nextState.setCoste(3);
	    	   this.apOperadores=true;
	       }
	      
	       
	         return nextState;
	      }
	    
public boolean aplOperadores(){
	return this.apOperadores;
}
	      
	      public boolean isGoal(){
	         return (tablero[0]==1&&tablero[1]==1&&tablero[2]==1&&tablero[3]==2&&
	                     tablero[4]==0&&tablero[5]==0&&tablero[6]==0);
	      }
	      
	    
	     
	      public String toString(){
	         return "("+tablero[0]+" "+tablero[1]+" "+tablero[2]+" "+tablero[3]+" "+tablero[4]+
	                 " "+tablero[5]+" "+tablero[6]+")";
	      }
	      
	      public float h(){
	          float c =1;
	          if (tablero[0]!=1) c++;
	          if (tablero[1]!=1) c++; 
	          if (tablero[2]!=1) c++;
	          if (tablero[3]!=2) c++;
	          if (tablero[4]!=0) c++;
	          if (tablero[5]!=0) c++;
	          if (tablero[6]!=0) c++;
	          return c;
	      }
}
