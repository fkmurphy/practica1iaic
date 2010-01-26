package practica.modelo.minijuegos.Caballo;







public class Caballo {
	   int matri[][];
	    int posi;
	    int posj;
	    int vacias;
	   int coste;
	
	   
	   public int[][] getMatri() {
		return matri;
	}

	public void setMatri(int[][] matri) {
		this.matri = matri;
	}

	public int getPosi() {
		return posi;
	}

	public void setPosi(int posi) {
		this.posi = posi;
	}

	public int getPosj() {
		return posj;
	}

	public void setPosj(int posj) {
		this.posj = posj;
	}

	public int getVacias() {
		return vacias;
	}

	public void setVacias(int vacias) {
		this.vacias = vacias;
	}

	public Caballo(){
	        
	         posi=(int)(Math.random()*5);
	         posj=(int)(Math.random()*5);
	         vacias = 24;
	        
	         matri = new int[5][5];
	         for (int i = 0;i<5;i++){
	            for (int j = 0;j<5;j++){
	                 matri[i][j]=0; 
	            }
	        }   
	         matri[posi][posj]= 1;
	       
	    }
	    
	    public Caballo(int pi,int pj,int r,int[][] m){
	       
	        
	         posi=pi;
	         posj=pj;
	         vacias=r;
	      
	         matri = new int[5][5];
	         for (int i = 0;i<5;i++){
	            for (int j = 0;j<5;j++){
	                 matri[i][j]=m[i][j]; 
	            }
	        } 
	        
	    }
	    
    public boolean equals( Object arg ) {
	        
	    	boolean ok;
	        if( (arg != null) && (arg instanceof Caballo) ) {
	            // Hacemos un moldeado del Object general a tipo java511
	            Caballo temp = (Caballo)arg;

	            // Se realiza la comparacion y se devuelve el resultado
	            ok=( this.getVacias() == temp.getVacias() )
	            &&(this.getMatri()==temp.getMatri())
	            &&(this.getPosi()==temp.getPosi())
	            &&(this.getPosj()==temp.getPosj());
	           
	            }
	        else {
	            // No es del tipo esperado
	            ok=( false );
	            }
	      
	        return ok;
	        
	    }
	    
	    public int hashCode() {
	        int result = 17;
	        int position = this.getVacias();
	        result = 37 * result + position;
	        position = this.getPosi();
	        result = 37 * result + position;
	        position = this.getPosj();
	        result = 37 * result + position;
	       
	       
	     
	        
	        return result;
	    }
	    
	    
	    public Caballo applyOperator(int operadores){
	    	
	       int posx= this.posi;
	       int posy= this.posj;
	       Caballo nextState = new Caballo(this.posi,this.posj,this.vacias,this.matri);
	                if((operadores==0)&&((posx-2>=0)&&(posy-1>=0)&&(matri[posx-2][posy-1]==0))){
	                    nextState.posi = posx-2;
	                    nextState.posj = posy-1;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	                if((operadores==1)&&((posx-2>=0)&&(posy+1<5)&&(matri[posx-2][posy+1]==0))){
	                    nextState.posi = posx-2;
	                    nextState.posj = posy+1;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1; 
	                }
	                if((operadores==2)&&((posx-1>=0)&&(posy-2>=0)&&(matri[posx-1][posy-2]==0))){
	                    nextState.posi = posx-1;
	                    nextState.posj = posy-2;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	                if((operadores==3)&&((posx-1>=0)&&(posy+2<5)&&(matri[posx-1][posy+2]==0))){
	                    nextState.posi = posx-1;
	                    nextState.posj = posy+2;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	                if((operadores==4)&&((posx+1<5)&&(posy-2>=0)&&(matri[posx+1][posy-2]==0))){
	                    nextState.posi = posx+1;
	                    nextState.posj = posy-2;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	                if((operadores==5)&&((posx+1<5)&&(posy+2<5)&&(matri[posx+1][posy+2]==0))){
	                    nextState.posi = posx+1;
	                    nextState.posj = posy+2;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	                if((operadores==6)&&((posx+2<5)&&(posy-1>=0)&&(matri[posx+2][posy-1]==0))){
	                    nextState.posi = posx+2;
	                    nextState.posj = posy-1;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	                if((operadores==7)&&((posx+2<5)&&(posy+1<5)&&(matri[posx+2][posy+1]==0))){
	                    nextState.posi = posx+2;
	                    nextState.posj = posy+1;
	                    nextState.matri[nextState.posi][nextState.posj]=1;
	                    nextState.vacias=this.vacias-1;
	                }
	              nextState.setCoste(3);
	       return nextState;
	    }
	       
	    
	   
	    
	    public int getCoste(){
			return coste;
		}
	    
	    public int setCoste(int c){
	    	return coste=c;
	    }
	     
	    
	      
	      public boolean isGoal(){
	         return (vacias<6);
	      }
	      
	    
	      public String toString(){
	         return matri[0][0]+" "+matri[0][1]+" "+matri[0][2]+" "+matri[0][3]+" "+matri[0][4]+"\n"+
	                 matri[1][0]+" "+matri[1][1]+" "+matri[1][2]+" "+matri[1][3]+" "+matri[1][4]+"\n"+
	                 matri[2][0]+" "+matri[2][1]+" "+matri[2][2]+" "+matri[2][3]+" "+matri[2][4]+"\n"+
	                 matri[3][0]+" "+matri[3][1]+" "+matri[3][2]+" "+matri[3][3]+" "+matri[3][4]+"\n"+
	                 matri[4][0]+" "+matri[4][1]+" "+matri[4][2]+" "+matri[4][3]+" "+matri[4][4]+"\n";
	      }
	      
	      public float h(){
	          return vacias;
	      }

}
