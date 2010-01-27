package practica.modelo.minijuegos.Mochila;







public class Mochila {

	
	 int pesoTes[];
	    int valorTes[];
	    int capacidad;
	    int pos;
	    int valor;
	    int coste;
	



	    public int getCoste() {
			return coste;
		}

		public void setCoste(int coste) {
			this.coste = coste;
		}

		// 0 = negro, 1 = blanco, hueco = 2;
	    public Mochila(){
	         valor=0;
	       
	         pos=0;
	      
	         pesoTes = new int [10];
	         valorTes= new int [10];
	         for(int i= 0; i<10;i++){
	                pesoTes[i]= (int)(Math.random()*99)+1;
	                valorTes[i]=(int)(Math.random()*500)+1;
	         }
	         capacidad =(int)(Math.random()*99)+1;
	   
	    }
	    
 
	
	    
	    public Mochila(int[]p, int[] v,int c,int va,int pp){
	         pos=pp;
	         valor=va;
	      
	         pesoTes = new int [10];
	         valorTes= new int [10];
	         for(int i= 0; i<10;i++){
	                pesoTes[i]= p[i];
	                valorTes[i]=v[i];
	         }
	         capacidad = c;
	    }
	    
	    public Mochila applyOperator(){
	       Mochila nextState = new Mochila(pesoTes,valorTes,capacidad,valor,pos);
	       for (int i=0;i<10;i++){
	            if((pesoTes[pos]!=0)&&(capacidad-pesoTes[pos]>=0)){
	                nextState.capacidad=capacidad-pesoTes[i];
	                nextState.valor=valor+valorTes[i];
	                nextState.pesoTes[i]=0;
	                nextState.valorTes[i]=0;
	                nextState.pos=(pos+1)%10;
	                coste = pesoTes[(pos+1)%10];
	                nextState.setCoste(coste);
	                
	            }
	            else
	                nextState.pos=(pos+1)%10; 
	            
	       }
	       return nextState;
	      }
	    

		   public boolean equals( Object arg ) {
			      
		    	boolean ok;
		        if( (arg != null)&& (arg instanceof Mochila)  ) {
		          
		            Mochila temp = (Mochila)arg;

		          
		            ok=( this.getCapacidad() == temp.getCapacidad())
		            &&(this.getPos()==temp.getPos())
		            &&(this.getValor()==temp.getValor());
		        //   &&(this.getPesoTes()==temp.getPesoTes())
		        //  &&(this.getValorTes()==temp.getValorTes())
		            
		            }
		        else {
		           
		            ok=( false );
		            }
		      
		        return ok;
		        
		    }
		   
		    public int getPesoTes(int p) {
			return pesoTes[p];
		}
		    public int[] getPesoTes() {
				return pesoTes;
			}

		public void setPesoTes(int[] pesoTes) {
			this.pesoTes = pesoTes;
		}

		public int getValorTes(int p) {
			return valorTes[p];
		}
		public int[] getValorTes() {
			return valorTes;
		}

		public void setValorTes(int[] valorTes) {
			this.valorTes = valorTes;
		}

			public int hashCode() {
		        int result = 17;
		        int position = this.getCapacidad();
		        result = 37 * result + position;
		        position = this.getValor();
		        result = 37 * result + position;
		        position = this.getPos();
		        result = 37 * result + position;
		      
		        return result;
		    }

	  
	      
	      public int getCapacidad() {
				return capacidad;
			}

			public void setCapacidad(int capacidad) {
				this.capacidad = capacidad;
			}

			public int getPos() {
				return pos;
			}

			public void setPos(int pos) {
				this.pos = pos;
			}

			public int getValor() {
				return valor;
			}

			public void setValor(int valor) {
				this.valor = valor;
			}

		public boolean isGoal(){
	         return (capacidad>=0&&capacidad<5);
	      }
	      
	   
	      public String toString(){
	         return "("+capacidad+" "+valor+")";
	      }
	      
	      public float h(){
	          return capacidad;
	      }
}
