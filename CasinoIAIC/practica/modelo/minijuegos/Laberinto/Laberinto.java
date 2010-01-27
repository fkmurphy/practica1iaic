package practica.modelo.minijuegos.Laberinto;






public class Laberinto {

	  int laberinto [][];
	    int posI, posJ;
	    int posFi , posFj;
	    private boolean opAplicados;
	    

	  
//*********************************************************************/    
	 
	 /* El laberinto es UNICO :
	  * para representar los posibles movimientos en el laberinto utilizamos 4 bit,
	  * en este caso un entero, donde de menos significativo a mas significativo
	  * significa : abajo,arriba,derecha, izq.
	  * Ademas para evitar que el control de ciclos nos salte siempre con Sin Solucion
	  * lo que hacemos es forzar el movimiento que no se repite.
	  * LA POSICION (3,1) NO ES ACCESIBLE para conseguir que en algun momento
	  * no se pueda encontrar solucion, esto lo podemos hacer poniendo que la (3,2) vaya
	  * hacia la derecha.
	  * Se comienza en la posicion (0,0), la posicion final se hace con Random()*/ 
	    
	    
	    public Laberinto(){
	       
	         laberinto = new int[4][4];
	         laberinto[0][0] = 0001 ;
	         laberinto[0][1] = 0100 ;
	         laberinto[0][2] = 1000 ;
	         laberinto[0][3] = 1000 ;
	         laberinto[1][0] = 0001 ;
	         laberinto[1][1] = 0100 ;
	         laberinto[1][2] = 1100 ;
	         laberinto[1][3] = 0010 ;
	         laberinto[2][0] = 0101 ;
	         laberinto[2][1] = 0100 ;
	         laberinto[2][2] = 0110 ;
	         laberinto[2][3] = 0001 ;
	         laberinto[3][0] = 0010 ;
	         laberinto[3][1] = 0100 ;
	         laberinto[3][2] = 0100 ;
	         laberinto[3][3] = 1000 ;
	         posI = 0;
	         posJ = 0;
	         posFi =(int)(Math.random()*4);//3
	         posFj =(int)(Math.random()*4);//1/
	      
	         /*Tenemos que tener en cuenta que la posicion (3,1) NO ES ACCESIBLE.*/
	    }
	    
	    
	    public int getPosI() {
			return posI;
		}


		public void setPosI(int posI) {
			this.posI = posI;
		}


		public int getPosJ() {
			return posJ;
		}


		public void setPosJ(int posJ) {
			this.posJ = posJ;
		}


		public int getPosFi() {
			return posFi;
		}


		public void setPosFi(int posFi) {
			this.posFi = posFi;
		}


		public int getPosFj() {
			return posFj;
		}


		public void setPosFj(int posFj) {
			this.posFj = posFj;
		}


		public boolean equals( Object arg ) {
		      
	    	boolean ok;
	        if( (arg != null)&& (arg instanceof Laberinto)  ) {
	          
	            Laberinto temp = (Laberinto)arg;

	          
	            ok=( this.getPosFi() == temp.getPosFi())
	            &&(this.getPosFj()==temp.getPosFj())
	             &&(this.getPosI()==temp.getPosI())
	              &&(this.getPosJ()==temp.getPosJ());
	         
	            
	            }
	        else {
	           
	            ok=( false );
	            }
	      
	        return ok;
	        
	    }
	    
		
		public int hashCode() {
	        int result = 17;
	        int position = this.getPosFi();
	        result = 37 * result + position;
	        position = this.getPosFj();
	        result = 37 * result + position;
	        position = this.getPosI();
	        result = 37 * result + position;
	        position = this.getPosJ();
	        result = 37 * result + position;
	      
	        return result;
	    }
	    public Laberinto( int B[][],int i, int j, int fi, int fj){
	       
	         laberinto = new int[4][4];
	         for(int h = 0;h<4;h++){
	              for(int p= 0;p<4;p++){
	                  laberinto[h][p] = B[h][p];
	              }
	         }
	         posI = i;
	         posJ = j;
	         posFi = fi;
	         posFj = fj;
	    }
	    
	    public Laberinto Operadores(int op){
	    	this.opAplicados= false;
	       Laberinto nextState = new Laberinto(laberinto,posI,posJ,posFi,posFj);
	        if((op==0)&&(laberinto[posI][posJ] == 1000)||(laberinto[posI][posJ] == 1100)){
	              nextState.posI=posI;
	              nextState.posJ=posJ-1;
	              this.opAplicados= true;
	        }
	       if((op==1)&&(laberinto[posI][posJ] == 0001)||(laberinto[posI][posJ] == 0101)){
	              nextState.posI=posI+1;
	              nextState.posJ=posJ;
	              this.opAplicados= true;
	          }
	       if((op==2)&&(laberinto[posI][posJ] == 0100)||(laberinto[posI][posJ] == 1100)||(laberinto[posI][posJ] == 0101)){
	              nextState.posI=posI;
	              nextState.posJ=posJ+1;
	              this.opAplicados= true;
	          }
	       if((op==3)&&(laberinto[posI][posJ] == 0010)||(laberinto[posI][posJ] == 0110)){
	              nextState.posI=posI-1;
	              nextState.posJ=posJ;
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
	         return ((posI == posFi) && (posJ == posFj));
	      }
	      
	     
	      public String toString(){
	         return "("+posI+" "+posJ+" "+posFi+" "+posFj+")";
	      }
	      
	      public float h(){
	          return 1;
	      }

}
