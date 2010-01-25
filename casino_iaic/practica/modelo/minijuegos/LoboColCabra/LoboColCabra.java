package practica.modelo.minijuegos.LoboColCabra;



public class LoboColCabra {
	
	
	int _lobo;
	int _cabra;
	int _col;
	int _granjero;
	Operadores _operador;
	
	public Operadores get_operador() {
		return _operador;
	}

	public void set_operador(Operadores operador) {
		_operador = operador;
	}

	public LoboColCabra()
	{
		this._cabra=1;
		this._cabra=1;
		this._granjero=1;
		this._lobo=1;
	}

	public int get_lobo() {
		return _lobo;
	}

	public void set_lobo(int lobo) {
		_lobo = lobo;
	}

	public int get_cabra() {
		return _cabra;
	}

	public void set_cabra(int cabra) {
		_cabra = cabra;
	}

	public int get_col() {
		return _col;
	}

	public void set_col(int col) {
		_col = col;
	}

	public int get_granjero() {
		return _granjero;
	}

	public void set_granjero(int granjero) {
		_granjero = granjero;
	}

	public LoboColCabra(int lobo, int cabra, int col, int granjero) {
		super();
		_lobo = lobo;
		_cabra = cabra;
		_col = col;
		_granjero = granjero;
	}
	
	
	 
    protected boolean esValido()
    { if (_lobo == _cabra && _lobo == (1 - _granjero))
          return false; 
      if (_cabra == _col && _cabra == (1 - _granjero)) 
          return false;
      return true;  } 
	
    public Double dameCosteArista()
    { 
    	 if ((this._operador==Operadores.cruzaLobo)||(this._operador==Operadores.cruzaCabra) ||(this._operador==Operadores.cruzaCol))
    	 return new Double(1); 
    	 else if (this._operador==Operadores.cruzaGranjero) return new Double(2); 
    	 else  return new Double(0); 
    }
    
    public boolean isObjetivo()
    { return this._lobo ==0 && this._cabra == 0 && _col == 0 && _granjero == 0; 
    }
    
    public Double dameHeuristica()
    {   int valor=_lobo+_cabra+_granjero+_col;
        return new Double(valor);
    }
    
    
    public LoboColCabra aplicaOp(Operadores operadores)
    {
    int _cab=this.get_cabra();
    int _lob=this.get_lobo();
    int _gran=this.get_granjero();
    int _col=this.get_col();	
    
    int iLobo=1;
    int iCabra=1;
    int iCol=0; 
    int iGranjero=0;
    
  
   
    	
    if(operadores == Operadores.cruzaLobo && _lob == _gran){
            iLobo = (1 - _lob);
            iCabra = _cab;
            iCol = _col; 
            iGranjero = (1 - _gran);
             }
        else if(operadores == Operadores.cruzaCabra && _cab == _gran)
        { iLobo = _lob; 
          iCabra = (1 - _cab);
          iCol = _col; 
          iGranjero = (1 - _gran);
          }
        else if(operadores == Operadores.cruzaCol && _col == _gran){
            iLobo = _lob; 
            iCabra = _cab; 
            iCol = (1 - _col); 
            iGranjero = (1 - _gran); 
        }
        else if(operadores == Operadores.cruzaGranjero){
            iLobo = _lob;
            iCabra = _cab; 
            iCol = _col; 
            iGranjero = (1 - _gran); 
          
         }  
        
    LoboColCabra nuevoEstado = new LoboColCabra(iLobo,iCabra,iCol,iGranjero); 
    nuevoEstado.set_operador(operadores);
        return nuevoEstado;
        
        
    }
    public String toString() { 
    	String  lob="";
    	String cabr="";
    	String co="";
    	String granj="";
        if (_lobo==1) lob="izquierda";
        else lob="derecha";
        
        if (_cabra==1) cabr="izquierda";
        else cabr="derecha";
        
        if (_col==1) co="izquierda";
        else co="derecha";
        
        if (_granjero==1) granj="izquierda";
        else granj="derecha";
        
       
    	return "(LOBO:" + lob + ", CABRA:" + cabr + ", COL:" + co + ", GRANJERO:" + granj  ;
    }

}
