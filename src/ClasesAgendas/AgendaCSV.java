/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAgendas;

/**
 *
 * @author Yassin
 */
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import ClasesCitas.Cita;
public class AgendaCSV extends AgendaGeneral{

    public AgendaCSV() {
    }
    
    public void CrearAgendaGeneral(){
        try{
           FileOutputStream fos = new FileOutputStream("AgendaGeneral.csv");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter fw = new BufferedWriter(osw);
            if(citasGeneral.size()==0){
                System.out.println("citasGeneral es null en AgendaGeneral");
            }else{
            for(int i=0; i<citasGeneral.size();i++){
                Cita cita=citasGeneral.get(i);
                fw.write(cita.toString());
                fw.write(";");
    }
            fw.close();
            osw.close();
            fos.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
