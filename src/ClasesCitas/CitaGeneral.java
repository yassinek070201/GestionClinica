/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesCitas;

import ClasesAgendas.TipoAgenda;
import ClasesPersonas.Medicos;
import ClasesPersonas.Pacientes;
import java.time.LocalDate;

/**
 *
 * @author Yassin
 */
public class CitaGeneral extends Cita {

    public CitaGeneral(Pacientes paciente, Medicos medico, LocalDate fechacita, Prioridad prioridad, TipoAgenda tipo) {
        super(paciente, medico, fechacita, prioridad, tipo);
    }

    

    

}
