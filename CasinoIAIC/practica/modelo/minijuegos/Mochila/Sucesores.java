package practica.modelo.minijuegos.Mochila;

import java.util.ArrayList;
import java.util.List;



import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		int operadores;
		Mochila g =  (Mochila)state;
		List<Successor> successors = new ArrayList<Successor>();
		/* Tenemos 2 posibles operadores que debemos almacenar*/
		
		
		int p= g.getPos();
		int coste;
		
		
		
		
		 for (int i=0;i<10;i++){
		      Mochila nextState = new Mochila(g.getPesoTes(),g.getValorTes(),g.getCapacidad(),g.getValor(),g.getPos());
		 
	            if((g.getPesoTes(p)!=0)&&(g.getCapacidad()-g.pesoTes[p]>=0)){
	            	
	                nextState.capacidad=g.getCapacidad()-g.pesoTes[i];
	                nextState.valor=g.valor+g.valorTes[i];
	                nextState.pesoTes[i]=0;
	                nextState.valorTes[i]=0;
	                nextState.pos=(g.getPos()+1)%10;
	                coste = g.getPesoTes((g.getPos()+1)%10);
	                nextState.setCoste(coste);
	           
	                
	            }
	            else
	                nextState.pos=(g.getPos()+1)%10; 
	  
			
	       
	           successors.add(new Successor(nextState.toString(),nextState));
	          
		}
		
		return successors;
		
	}

}
