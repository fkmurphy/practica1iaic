package practica.modelo.minijuegos.banderaHolandesa;







public class banderaHolandesa {
	 int bandera [];

	    int vacio;
	    
	    public int getCosteop() {
			return costeop;
		}

		public void setCosteop(int costeop) {
			this.costeop = costeop;
		}

		int costeop;
	   
	    
	    public banderaHolandesa(){
	      
	         int vec[];
	         vec = new int[7];
	         int n = 0; 
	         vec[0]=0;vec[1]=0;vec[2]=1;vec[3]=1;vec[4]=2;vec[5]=2;vec[6]=3;
	       
	         this.bandera = new int [7];
	         for(int i = 0;i<7;i++){
	             while(vec[n]== -1){
	                      n =(int) (Math.random()*7);
	             }
	             this.bandera[i]= vec[n];
	             vec[n]=-1;
	         }
	         for (int i = 0;i<7;i++){
	             if (this.bandera[i]== 3) this.vacio = i;
	         }
	         
	       
	       
	   }
	    
	    public boolean equals( Object arg ) {
	        
	    	boolean ok;
	        if( (arg != null) && (arg instanceof banderaHolandesa) ) {
	            // Hacemos un moldeado del Object general a tipo java511
	            banderaHolandesa temp = (banderaHolandesa)arg;

	            // Se realiza la comparacion y se devuelve el resultado
	            ok=( this.getVacio() == temp.getVacio() );
	           // &&(this.getBandera()==temp.getBandera());
	           
	            }
	        else {
	            // No es del tipo esperado
	            ok=( false );
	            }
	      
	        return ok;
	        
	    }
	    
	    public int hashCode() {
	        int result = 17;
	        int position = this.getVacio();
	        result = 37 * result + position;
	       
	     
	        
	        return result;
	    }
	    
	    
	    public int[] getBandera() {
			return bandera;
		}

		public void setBandera(int[] bandera) {
			this.bandera = bandera;
		}

		public int getVacio() {
			return vacio;
		}

		public void setVacio(int vacio) {
			this.vacio = vacio;
		}

		public banderaHolandesa( int B[],int v){
	        
	         vacio = v;
	         bandera = new int [7];
	         for(int i= 0;i<7;i++){
	                bandera[i] = B[i];
	         }
	    }
	    
	    public banderaHolandesa applyOperator(int op){
	       banderaHolandesa nextState = new banderaHolandesa(this.bandera,this.vacio);
	       if((op==0)&&((this.vacio>=1)&&(this.vacio<=6))){
	          nextState.bandera[this.vacio] = nextState.bandera[this.vacio-1];
	          nextState.bandera[this.vacio-1]= 3;
	          nextState.vacio = this.vacio-1;
	          nextState.setCosteop(1);
	       }
	       
	       if((op==1)&&((this.vacio>=0)&&(this.vacio<=5))){
	          nextState.bandera[this.vacio] = nextState.bandera[this.vacio+1];
	          nextState.bandera[this.vacio+1]= 3;
	          nextState.vacio = this.vacio+1;  
	          nextState.setCosteop(1);
	       }
	       if((op==2)&&((this.vacio>=0)&&(this.vacio<=4))){
	          nextState.bandera[this.vacio] = nextState.bandera[this.vacio+2];
	          nextState.bandera[this.vacio+2]= 3;
	          nextState.vacio = this.vacio+2;  
	          nextState.setCosteop(2);
	       }
	       if((op==3)&&((this.vacio>=2)&&(this.vacio<=6))){
	          nextState.bandera[this.vacio] = nextState.bandera[this.vacio-2];
	          nextState.bandera[this.vacio-2]= 3;
	          nextState.vacio = this.vacio-2;  
	          nextState.setCosteop(2);
	       }
	       
	       return nextState;
	    }
	  
	    
	      
	      public boolean isGoal(){
	         return (bandera[0]==0&&bandera[1]==0&&bandera[2]==1&&bandera[3]==1&&bandera[4]==2
	                 &&bandera[5]==2&&bandera[6]==3);
	      }
	      
	   
	     
	      public String toString(){
	         return "("+bandera[0]+" "+bandera[1]+" "+bandera[2]+" "+bandera[3]+" "+bandera[4]+
	                 " "+bandera[5]+" "+bandera[6]+")";
	      }
	      
	      public float h(){
	          float c =1;
	          if (bandera[0]!=0) c++;
	          if (bandera[1]!=0) c++; 
	          if (bandera[2]!=1) c++;
	          if (bandera[3]!=1) c++;
	          if (bandera[4]!=2) c++;
	          if (bandera[5]!=2) c++;
	          if (bandera[6]!=3) c++;
	          return c;
	      }
}
