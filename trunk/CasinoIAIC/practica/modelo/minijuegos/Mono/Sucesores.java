package practica.modelo.minijuegos.Mono;

import java.util.ArrayList;

import java.util.List;

import practica.modelo.minijuegos.Mono.*;
import practica.modelo.minijuegos.Garrafas.Garrafas;

import aima.search.framework.*;

public class Sucesores implements SuccessorFunction{

	public List getSuccessors(Object state) {
		
		int operadores;
		Mono m =  (Mono)state;
		List<Successor> successors = new ArrayList<Successor>();
		String operador = "";
	    int pos=m.getPos();
	    int caja=m.getCaja();
	    boolean sobreCaja=m.isSobrecaja();
	    boolean platano=m.isPlatano();
		
		   if (pos != 2 && !sobreCaja)
	        { operador  = "andaHaciaVentana"; 
	          Mono nuevoEstado = new Mono(pos+1,caja,sobreCaja,platano);
	          successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	        }
	        if (pos != 0 && !sobreCaja){
	            operador = "andaHaciaPuerta";
	            Mono nuevoEstado = new Mono(pos-1,caja,sobreCaja,platano);
	            successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	        }
	        if (pos == caja && sobreCaja && pos != 2){
	            operador = "empujaCajaHaciaVentana"; 
	            Mono nuevoEstado = new Mono(pos+1,caja+1,sobreCaja,platano);
	            successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	        }
	        if (pos == caja && sobreCaja && pos !=0){ 
	            operador = "empujaCajaHaciaPuerta"; 
	            Mono nuevoEstado = new Mono(pos-1,caja-1,sobreCaja,platano);
	            successors.add(new Successor(nuevoEstado.toString(),nuevoEstado)); 
	        }
	        if (pos == caja && !sobreCaja){ 
	            operador ="subeCaja";
	            Mono nuevoEstado = new Mono(pos,caja,true,platano);
	            successors.add(new Successor(nuevoEstado.toString(),nuevoEstado)); 
	        }
	        if (pos == caja && sobreCaja){
	            operador ="bajaCaja";
	            Mono nuevoEstado = new Mono(pos,caja,false,platano); 
	            successors.add(new Successor(nuevoEstado.toString(),nuevoEstado)); 
	        }
	        if (sobreCaja && caja == 1 && !platano){ 
	            operador ="cogePlatano";
	            Mono nuevoEstado = new Mono(pos,caja,sobreCaja,true);
	            successors.add(new Successor(nuevoEstado.toString(),nuevoEstado));
	        }
		return successors;
	}
	
	
}
