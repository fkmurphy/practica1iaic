package practica.modelo.casino;

public class ResultadoPrueba {

	
	
	  private String printPrueba;

	    private boolean resultado;

	    public ResultadoPrueba(String printPrueba,boolean res) {
	        this.printPrueba = printPrueba;
	        this.resultado=res;
	    }


	    public String getPrintBatalla() {
	        return printPrueba;
	    }

	    public boolean getResultado() {
	        return resultado;
	    }
}
