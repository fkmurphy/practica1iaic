package practica.modelo.minijuegos.Puzzle;

import aima.search.framework.GoalTest;
import aima.search.framework.HeuristicFunction;
import aima.search.framework.StepCostFunction;
import aima.search.framework.SuccessorFunction;
import practica.modelo.minijuegos.Juego;


public class Puzzle {

	
	   /**
     * Coordenada x de la casilla libre
     */
    private int x;
    
    /**
     * Coordenada y de la casilla libre
     */
    private int y;
    
    /**
     * Tablero que representa el puzzle
     */
    private int [][] tablero;

    /**
     * Genera un nodo de ocho puzzle con el estado del juego en ese momento
     * @param tablero estado actual del problema
     * @param x situacion y del blanco
     * @param y situacion y del hueco
     * @param c Controlador. Poner null para imprimir por pantalla
     */
    public Puzzle(int [][] tablero, int x, int y){
            this.tablero = new int [3][3];
            for(int i = 0; i<=2; i++)
                    for(int j = 0; j<=2; j++)
                            this.tablero[i][j] = tablero[i][j];
            this.x = x;
            this.y = y;
            
    }
    
    public Puzzle(){
    	x=1;
    	y=1;
    	 int[][] tabla = new int[3][3];
         tabla[0][0] = 1; tabla[0][1] = 3; tabla[0][2] = 4;
         tabla[1][0] = 8; tabla[1][1] = 0; tabla[1][2] = 2;
         tabla[2][0] = 7; tabla[2][1] = 6; tabla[2][2] = 5;
         tablero=tabla;

    	
    }
    
    /**
     * Indica si el estado es el estado final
     * @return true en caso de ser el final de la busqueda false en caso contraio
     */
    public boolean isGoal(){
            return  tablero[0][0] == 1 && tablero[0][1] == 2 && tablero[0][2] == 3 &&
                            tablero[1][0] == 8 && tablero[1][1] == 0 && tablero[1][2] == 4 &&  
                            tablero[2][0] == 7 && tablero[2][1] == 6 && tablero[2][2] == 5;
    }
    
    
    public Puzzle Operadores(int operadores){
    	
    	int miX = this.x;
        int miY = this.y;
        Puzzle nuevoEstado = 
            new Puzzle(this.tablero, this.x, this.y);

    	   if (operadores == 0 && miX>0){
               int temp = nuevoEstado.tablero[miX-1][miY];
               nuevoEstado.tablero[miX-1][miY] = 0;
               nuevoEstado.tablero[miX][miY] = temp;
               nuevoEstado.x = miX - 1;
           
       }
       //Mover hueco hacia abajo
       if (operadores == 1 && miX<2){
               int temp = nuevoEstado.tablero[miX+1][miY];
               nuevoEstado.tablero[miX+1][miY] = 0;
               nuevoEstado.tablero[miX][miY] = temp;
               nuevoEstado.x = miX + 1;;
              
       }
       //Mover hueco hacia la izquierda
       if (operadores == 2 && miY>0){
               int temp = nuevoEstado.tablero[miX][miY-1];
               nuevoEstado.tablero[miX][miY-1] = 0;
               nuevoEstado.tablero[miX][miY] = temp;
               nuevoEstado.y = miY - 1;
               
       }
       //Mover hueco hacia la derecha
       if (operadores == 3 && miY<2){
               int temp = nuevoEstado.tablero[miX][miY+1];
               nuevoEstado.tablero[miX][miY+1] = 0;
               nuevoEstado.tablero[miX][miY] = temp;
               nuevoEstado.y = miY + 1;
          
       }
       
       

     return nuevoEstado;
    
    }
   
     
     /**
      * Genera la heuristica para este problema, cuenta fichas descolocadas
      * @return devuelve la heuristica correpondiente float
      */
     public float h() {
             
            float hVal = 0;
            
            if (tablero[0][0] != 1) hVal++;
            if (tablero[0][1] != 2) hVal++;
            if (tablero[0][2] != 3) hVal++;
            if (tablero[1][0] != 8) hVal++;
            if (tablero[1][2] != 4) hVal++;
            if (tablero[2][0] != 7) hVal++;
            if (tablero[2][1] != 6) hVal++;
            if (tablero[2][2] != 5) hVal++;
                    
            return hVal;
     }
     
    /**
     * genera el mensaje del estado en el que nos encontramos
     * @return String con el mensaje del estado en el que se encuentra
     */
    public String toString(){
            String tabla = "\n(";
            for (int i = 0; i<=2; i++){
                    for (int j = 0; j<=2; j++){
                            tabla += " " + tablero[i][j] + " ";
                            if (j==2 && i!=2)
                                    tabla += ")" + "\n" + "(";
                            if (j==2 && i == 2)
                                    tabla += ")" + "\n";
                    }
            }
            return tabla;   
    } 
     
    public int getCoste(){
		return 1;
	}

}
