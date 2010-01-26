/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.modelo.Log;

/**
 *
 * @author 
 */
public class LogMens {

    EnumLogs tipoLog;
    String mensaje;

    public LogMens(EnumLogs tipoLog, String mensaje) {
        this.tipoLog = tipoLog;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public EnumLogs getTipo(){
        return tipoLog;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
