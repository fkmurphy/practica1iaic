package practica.modelo.minijuegos.TorreHanoi;





public class TorreHannoi {
	
	private   int p1 [];
	private   int cima1;
	private    int p2 [];
	private   int cima2;
	private  int cima3;
	private  int p3 [];
	private boolean opAplicado;
	
	   
	   
	   
	  
	
	  public TorreHannoi(){
	         
	         
	         p1=new int[4];
	         p2=new int[4];
	         p3=new int[4];
	         cima1= 3;
	         cima2= -1;
	         cima3= -1;
	         p1[0]= 4;
	         p1[1]= 3;
	         p1[2]= 2;
	         p1[3]= 1;
	      
	    }
	    
	    public TorreHannoi(int c1, int c2, int c3,int[] p11,int[] p22,int[] p33){
	         
	         
	         cima1 = c1;
	         cima2 = c2;
	         cima3 = c3;
	         p1=new int[4];
	         p2=new int[4];
	         p3=new int[4];
	         for (int i=0; i<4;i++){
	                p1[i] = p11[i];
	                p2[i] = p22[i];
	                p3[i] = p33[i];
	                
	         }
	    }
	    
	    public boolean equals( Object arg ) {
		      
	    	boolean ok;
	        if( (arg != null)&& (arg instanceof TorreHannoi)  ) {
	          
	            TorreHannoi temp = (TorreHannoi)arg;

	          
	            ok=( this.getCima1() == temp.getCima1())
	            &&(this.getCima2()==temp.getCima2())
	             &&(this.getCima3()==temp.getCima3());
	             // &&(this.getP1()==temp.getP1())
	            //  &&(this.getP2()==temp.getP2())
	           //   &&(this.getP3()==temp.getP3());
	              
	            
	            }
	        else {
	           
	            ok=( false );
	            }
	      
	        return ok;
	        
	    }
	   
	    public int[] getP1() {
			return p1;
		}

		public void setP1(int[] p1) {
			this.p1 = p1;
		}

		public int getCima1() {
			return cima1;
		}

		public void setCima1(int cima1) {
			this.cima1 = cima1;
		}

		public int[] getP2() {
			return p2;
		}

		public void setP2(int[] p2) {
			this.p2 = p2;
		}

		public int getCima2() {
			return cima2;
		}

		public void setCima2(int cima2) {
			this.cima2 = cima2;
		}

		public int getCima3() {
			return cima3;
		}

		public void setCima3(int cima3) {
			this.cima3 = cima3;
		}

		public int[] getP3() {
			return p3;
		}

		public void setP3(int[] p3) {
			this.p3 = p3;
		}

		public int hashCode() {
	        int result = 17;
	        int position = this.getCima1();
	        result = 37 * result + position;
	        position = this.getCima2();
	        result = 37 * result + position;
	        position = this.getCima3();
	        result = 37 * result + position;
	      
	        return result;
	    }
	
  public TorreHannoi  Operadores(int operador){
		 this.opAplicado=false;
		     TorreHannoi nextState = new TorreHannoi(this.cima1,this.cima2,this.cima3,this.p1,this.p2,this.p3);
		     if((operador==0)&&(((this.cima1 != -1) &&(this.cima2 != -1) &&(p1[this.cima1]<p2[this.cima2])) || (this.cima1 != -1) &&(this.cima2 == -1))){
                 nextState.cima2 = this.cima2+1;
                 nextState.p2[nextState.cima2] = p1[this.cima1];
                 nextState.cima1 = this.cima1-1;
                 this.opAplicado=true;
             }
		     if((operador==1)&&(((this.cima1 != -1) &&(this.cima3 != -1)&&(p1[this.cima1]<p3[this.cima3]))|| (this.cima1 != -1) &&(this.cima3 == -1))){
                 nextState.cima3 = this.cima3+1;
                 nextState.p3[nextState.cima3] = p1[this.cima1];
                 nextState.cima1 = this.cima1-1;
                 this.opAplicado=true;
             }
		     if((operador==2)&&(((this.cima2 != -1) &&(this.cima1 != -1)&&(p1[this.cima2]<p1[this.cima1]))|| (this.cima2 != -1) &&(this.cima1 == -1))){
                 nextState.cima1 = this.cima1+1;
                 nextState.p1[nextState.cima1] = p2[this.cima2];
                 nextState.cima2 = this.cima2-1;
                 this.opAplicado=true;
             }
		     if((operador==3)&&(((this.cima2 != -1) &&(this.cima3 != -1)&&(p2[this.cima2]<p3[this.cima3]))|| (this.cima2 != -1) &&(this.cima3 == -1))){
                 nextState.cima3 = this.cima3+1;
                 nextState.p3[nextState.cima3] = p2[this.cima2];
                 nextState.cima2 = this.cima2-1;
                 this.opAplicado=true;
             }
		     if((operador==4)&& (((this.cima3 != -1) &&(this.cima2 != -1)&&(p3[this.cima3]<p2[this.cima2]))|| (this.cima3 != -1) &&(this.cima2 == -1))){
                 nextState.cima1 = this.cima1+1;
                 nextState.p1[nextState.cima1] = p3[this.cima3];
                 nextState.cima3 = this.cima3-1;
                 this.opAplicado=true;
             }
		     if((operador==5)&&(((this.cima3 != -1) &&(this.cima1 != -1)&&(p3[this.cima3]<p1[this.cima1]))|| (this.cima3 != -1) &&(this.cima1 == -1))){
                nextState.cima2 = this.cima2+1;
                 nextState.p2[nextState.cima2] = p3[this.cima3];
                 nextState.cima3 = this.cima3-1;
                 this.opAplicado=true;
             }
    return nextState;
	       
	    }
	    
	public boolean opAplicado(){
		return this.opAplicado;
		
	}
	
	public boolean isvalido() {
		boolean valido= true;
		if( (this.getCima1()<-1)||(this.getCima1()>2) ) valido=false;
		if ((this.getCima2()<-1)||(this.getCima2()>2)) valido=false;
			if ((this.getCima3()<-1)||(this.getCima3()>3)) valido=false;
			return valido;
		
	}
	      

	

	      public boolean esObjetivo(){
	          return (this.cima3 == 3);
	      }
	      
	      public String toString(){
	         return "(" +cima1+" " +cima2+" " +cima3+")";
	      }
	      
	      public float hueristica(){
	          return (3-this.cima3);
	      }
	      
	   
	      public int getCoste() {
				return 1;
			}

}
