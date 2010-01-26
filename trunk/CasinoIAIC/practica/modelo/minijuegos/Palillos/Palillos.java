package practica.modelo.minijuegos.Palillos;

public class Palillos {
	  private int palillos;
      
      private int turno;
      
      /**
       * Constructora con parametros del estado de los palillos correspondiente
       * @param palillos numero de palillos que hay en el juego
       * @param turno turno en que se encuentra el juego
       */
      public Palillos(int palillos, int turno){
              this.palillos = palillos;
              this.turno = turno;
      }
      
      public Palillos(){
    	  palillos=6;
    	  turno=1;
      }
      
      public int getPalillos() {
		return palillos;
	}

	public void setPalillos(int palillos) {
		this.palillos = palillos;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	/**
       * Heuristica del juego
       * @return la heuristica dise–ada para este juego
       */
      public float h() {
           return palillos+turno;
      }
      
      /**
       * Indica si un estado es solucion del problema o no
       * @return true si ha llegado a solucion o false en caso contrario
       */
      public boolean isGoal() {
            return  (palillos == 0 && (turno%2 == 0));
            
         }
      
      
      /**
       * crea un string de mensaje del estado en el que se encuentra
       * @return un String
       */
      public String toString() {
            return "Quedan "+ palillos +" palillos.";
      }
      
      public int getCoste(){
			return 1;
		}
    
      
}
