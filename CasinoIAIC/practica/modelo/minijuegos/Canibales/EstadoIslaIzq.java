package practica.modelo.minijuegos.Canibales;

public class EstadoIslaIzq {
	
	
			private int numCanibales;
			private int numMisioneros;
			private boolean barca;
			private Double coste;
			
			
			public EstadoIslaIzq(int numCanibales,int numMisioneros,boolean barca,Double coste)
			{
				this.numCanibales=numCanibales;
				this.numMisioneros=numMisioneros;
				this.barca=barca;
				this.coste=coste;
			}
			
			public EstadoIslaIzq()
			{
				this.numCanibales=3;
				this.numMisioneros=3;
				this.barca=true;
				
			}
			
			public int getNumCanibales()
			{
				return this.numCanibales;
			}
			
			public int getNumMisioneros()
			{
				return this.numMisioneros;
			}
			
			public boolean getBarca()
			{
				return this.barca;
			}
			
			public Double getCoste()
			{
				return this.coste;
			}
			
			public void setNumCanibales(int numCanibales)
			{
				this.numCanibales=numCanibales;
			}
			
			public void setNumMisioneros(int numMisioneros)
			{
				this.numMisioneros=numMisioneros;
			}
			
			public void setBarca(boolean barca)
			{
				this.barca=barca;
			}
			
			public void setCoste(Double coste)
			{
				this.coste=coste;
			}
			
			public int getHeuristica()
			{
				return this.numCanibales + this.numMisioneros;
			}
			
			public String aString()
			{
				String cadena = "ESTADO (CAN,MIS,BARCA) " + numCanibales+ ","
				+ numMisioneros+ ",";
				if (barca) 
					cadena = cadena + "Izquierda.\n";
				else
					cadena = cadena + "Derecha.\n";
				return cadena;
			}
}
