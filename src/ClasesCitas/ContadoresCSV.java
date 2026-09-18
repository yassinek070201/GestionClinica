/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesCitas;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 *
 * @author Yassin
 */
public class ContadoresCSV extends Cita {
    public void crearContadores(){
        try{
            FileOutputStream fos = new FileOutputStream("Contadores.csv");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter fw = new BufferedWriter(osw);
            if(contador==0){
                System.out.println("PAcientes esta vacio");
            }else{
            for(int i=0; i<contador;i++){
                
                fw.write(contador);
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
