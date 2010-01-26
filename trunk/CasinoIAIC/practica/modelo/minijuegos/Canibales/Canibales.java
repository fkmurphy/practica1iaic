package practica.modelo.minijuegos.Canibales;

public class Canibales {


		private EstadoIslaIzq estadoActual;
	
			public Canibales()
			{
				this.estadoActual = new EstadoIslaIzq();
				this.estadoActual.setBarca(true);
				this.estadoActual.setNumCanibales(3);
				this.estadoActual.setNumMisioneros(3);
			}
			
			public Canibales(EstadoIslaIzq estado)
			{
				this.estadoActual=estado;
			}


			public Double dameCosteMovimiento(Operadores operador)
			{
				if ((operador==Operadores.cruzaM) || (operador== Operadores.cruzaC))
					return 1.0;
				else return 2.0;
			}
			
			public void setEstadoActual(EstadoIslaIzq estado)
			{
				this.estadoActual = estado;
			}
			
			public EstadoIslaIzq getEstadoActual()
			{
				return this.estadoActual;
			}
			
			
			public boolean movimientoSeguro(Operadores operador)
			{
				EstadoIslaIzq estadoAux = this.aplicaMovimiento(operador);
				
				int nC = estadoAux.getNumCanibales();
				int nM = estadoAux.getNumMisioneros();
				
				 if ((nM >= nC || nM == 0) && (nM <= nC || nM == 3) && nM>=0 && nM<=3 && nC>=0 && nC <=3){
					 return true;
				 }else
					 return false;
			}
			
			
			public EstadoIslaIzq aplicaMovimiento(Operadores operador)
			{
					EstadoIslaIzq nuevoEstado = new EstadoIslaIzq();
					
					int numCanibales = this.estadoActual.getNumCanibales();
					int numMisioneros = this.estadoActual.getNumMisioneros();
					boolean barca = this.estadoActual.getBarca();
					
					switch (operador)
					{
							case cruzaC:
							{		
								if (barca)
								{
									numCanibales = numCanibales - 1;
									barca=false;
								}
								else 
								{
									numCanibales = numCanibales + 1;
									barca=true;
								}
							break;
							}
							
							case cruzaM:
							{
								if (barca)
								{
									numMisioneros = numMisioneros - 1;
									barca=false;
								}
								else
								{
									numMisioneros = numMisioneros +1;
									barca=true;
								}
							break;
							}
							
							case cruzaMM:
							{
								if (barca)
								{
									numMisioneros = numMisioneros - 2;
									barca=false;
									
								}
								else
								{
									numMisioneros = numMisioneros + 2;
									barca=true;
								}
								
							break;
							}
							
							case cruzaCC:
							{
								if (barca)
								{
									numCanibales = numCanibales - 2;
									barca=false;
									
								}
								else
								{
									numCanibales = numCanibales + 2;
									barca=true;
									
								}
								
							break;
							}
							
							case cruzaMC:
							{
								if (barca)
								{
									numCanibales = numCanibales -1;
									numMisioneros = numMisioneros -1;
									barca = false;
								}
								else
								{
									numCanibales = numCanibales +1;
									numMisioneros = numMisioneros +1;
									barca = true;
									
								}
								
							break;
							}
							
				}
					nuevoEstado.setBarca(barca);
					nuevoEstado.setNumCanibales(numCanibales);
					nuevoEstado.setNumMisioneros(numMisioneros);
					nuevoEstado.setCoste(this.dameCosteMovimiento(operador));
					return nuevoEstado;
			}
			

			public boolean esObjetivoLogrado()
			{
				return ((this.estadoActual.getNumCanibales()==0) && (this.estadoActual.getNumMisioneros()==0) && (this.estadoActual.getBarca()==false)); 
			}




}
