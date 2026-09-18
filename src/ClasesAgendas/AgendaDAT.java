/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAgendas;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import ClasesCitas.Cita;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 *
 * @author Yassin
 */
public class AgendaDAT extends AgendaGeneral {

    public void CrearAgendaEspecialista() {
        try {
            FileOutputStream fos = new FileOutputStream("AgendaEspecialista.dat");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter fw = new BufferedWriter(osw);
            if (citasEspecialistas.size() == 0) {
                System.out.println("citasEspecialista es null en AgendaGeneral");
            } else {
                for (int i = 0; i < citasEspecialistas.size(); i++) {
                    Cita cita = citasEspecialistas.get(i);
                    fw.write(cita.toString());
                    fw.write(";");
                }
                fw.close();
                osw.close();
                fos.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
