/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package practica.modelo.Log;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 
 */
public class Log {

  private static ArrayList<LogMens> log=new ArrayList<LogMens>();


   public static void addCasino(String mensaje){
      log.add(new LogMens(EnumLogs.CASINO,mensaje));
   }

   public static void addCasinoDet(String mensaje){
      log.add(new LogMens(EnumLogs.CASINO_DET,mensaje));
   }

   public static void addMinijuegos(String mensaje){
      log.add(new LogMens(EnumLogs.MINIJUEGOS,mensaje));
   }

   public static void addMiniJuegoDet(String mensaje){
       log.add(new LogMens(EnumLogs.MINIJUEGOS_DET,mensaje));
   }

   public static void addAplicacion(String mensaje){
       log.add(new LogMens(EnumLogs.APLICACION,mensaje));
   }


   public static String getLog(){

       String str="";

       Iterator it=log.iterator();

       while (it.hasNext())
           str+=((LogMens) it.next()).getMensaje()+"\n";

       return str;
   }

      public static String getLogMicromundo(){

       String str="";

       Iterator it=log.iterator();

       while (it.hasNext()){
         LogMens lmens=((LogMens) it.next());
          if ((lmens.getTipo().equals(EnumLogs.CASINO))
          || (lmens.getTipo().equals(EnumLogs.CASINO_DET)))
           str+=lmens.getMensaje()+"\n";
       }
       return str;
   }


       public static String getLogMiniJuegos(){

       String str="";

       Iterator it=log.iterator();

       while (it.hasNext()){
         LogMens lmens=((LogMens) it.next());
          if ((lmens.getTipo().equals(EnumLogs.MINIJUEGOS))
          || (lmens.getTipo().equals(EnumLogs.MINIJUEGOS_DET)))
           str+=lmens.getMensaje()+"\n";
       }
       return str;
   }
       
      public static void borrarLog(){

     log.removeAll(log);
   }






}
