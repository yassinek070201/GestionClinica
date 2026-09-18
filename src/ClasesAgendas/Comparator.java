/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAgendas;

import ClasesCitas.*;

/**
 *
 * @author Yassin
 */
public class Comparator<Cita> {

    public int compare(Prioridad cita, Prioridad cita2){
        if(cita.ordinal() < cita2.ordinal())
            return 1;
        else if (cita.ordinal() == cita2.ordinal())
            return 0;
        else
            return -1;
    }
}
