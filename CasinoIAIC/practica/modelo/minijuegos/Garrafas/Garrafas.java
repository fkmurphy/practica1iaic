package practica.modelo.minijuegos.Garrafas;






public class Garrafas {

	
	private int jarra3;
	private int jarra4;
	private int costeOp;
	
	
	public Garrafas() {
		
		jarra3=0;
		jarra4=0;
	
	}
	
	public boolean esObjetivo() {
		
		return jarra4==2;
	}
	
	public Garrafas(int a, int b){
		this.jarra3=a;
		this.jarra4=b;
	}
	
	   public boolean equals( Object arg ) {
		      
	    	boolean ok;
	        if( (arg != null)&& (arg instanceof Garrafas)  ) {
	          
	            Garrafas temp = (Garrafas)arg;

	          
	            ok=( this.getJarra3() == temp.getJarra3())
	            &&(this.getJarra4()==temp.getJarra4());
	            
	            }
	        else {
	           
	            ok=( false );
	            }
	      
	        return ok;
	        
	    }
	   
	    public int hashCode() {
	        int result = 17;
	        int position = this.getJarra3();
	        result = 37 * result + position;
	        position = this.getJarra4();
	        result = 37 * result + position;
	      
	        return result;
	    }

	public int getJarra3() {
		return jarra3;
	}

	public void setJarra3(int jarra3) {
		this.jarra3 = jarra3;
	}

	public int getJarra4() {
		return jarra4;
	}

	public void setJarra4(int jarra4) {
		this.jarra4 = jarra4;
	}
	
	public float Heuristica(){
		return (Math.abs(jarra4-2));
	}
	

	
	public Garrafas Operadores(int operadores){
	
		int iJ3 = 0;
        int iJ4 = 0; 
      //  String operador = "";
       jarra3= this.getJarra3();
       jarra4= this.getJarra4();

    //llenar garrafa de 3L
    if (operadores == 0 && jarra3<3 ){
            iJ3 = 3;
            iJ4 = jarra4;
       //     operador ="LLenar jarra de 3 L";
            costeOp=3-jarra3;
    }
    //llenar garrafa de 4L
    if (operadores == 1 && jarra4<4 ){
            iJ4 = 4;
            iJ3 = jarra3;
     //       operador ="LLenar jarra de 4 L";
            costeOp=4-jarra4;
    }
    //vaciar garrafa de 4L
    if (operadores == 2 && jarra4>0 ){
            iJ4 = 0;
            iJ3 = jarra3;
    //        operador ="Vaciar jarra de 4 L";
            costeOp=jarra4;
    }
    //vaciar garrafa de 3L
    if (operadores == 3 && jarra3>0 ){
            iJ3 = 0;
            iJ4 = jarra4;
   //         operador ="Vaciar jarra de 3 L";
            costeOp=jarra3;
    }
    //verter garrafa de 3L sobre garrafa de 4L
    if (operadores == 4 && jarra3>0 && jarra4<4 ){
            if (jarra3+jarra4 <= 4){
                    iJ4=jarra3+jarra4;
                    iJ3=0;
                    costeOp=jarra3;
            }
            else {
                    iJ4 = 4;
                    iJ3 = (jarra3+jarra4)-4;
                    costeOp=4-jarra4;
            }
   //         operador ="Verter jarra de 3 L sobre la de 4 L";
    }
    //verter garrafa de 4L sobre garrafa de 3L
    if (operadores == 5 && jarra4>0 && jarra3<3 ){
            if (jarra3+jarra4 <= 3){
                    iJ3=jarra3+jarra4;
                    iJ4=0;
                    costeOp=jarra4;
            }
            else {
                    iJ3 = 3;
                    iJ4 = jarra4-(iJ3-jarra3);
                    costeOp=3-jarra3;
            }
   //         operador ="Verter jarra de 4 L sobre la de 3 L";
    }
    Garrafas nuevoEstado = new Garrafas(iJ3,iJ4);
    nuevoEstado.setCoste(costeOp);
    return nuevoEstado;
	}
	 public String toString() {
         return "( Jarra de 3:" + jarra3 + "; Jarra de 4:" + jarra4 +" )";
    }
	 
	 public int getCoste() {
			return costeOp;
		}
	 public void setCoste(int coste) {
			this.costeOp = coste;
	 }
	
	
  


}
