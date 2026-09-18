/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesCitas;

import ClasesAgendas.TipoAgenda;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import ClasesPersonas.Medicos;
import ClasesPersonas.Pacientes;


/**
 *
 * @author Yassin
 */
import ClasesPersonas.Especialidad;
public class Cita {
    public static int contador=1;
    private int idcita;
    private int idpaciente;
    private int idmedico;
    private LocalDate fechacita;
    private Prioridad prioridad;
    private TipoAgenda tipo;
    Map<Integer, String> m = new HashMap<>();
    
    Map<Integer, LocalDate> f = new HashMap<>();
    Map<Integer, Especialidad> u = new HashMap<>();

    public Cita() {
    }
    public Cita(int idpaciente, Pacientes paciente, Medicos medico) {
    this.idpaciente = idpaciente;
    this.idmedico = medico.getId();

    m.put(idpaciente, paciente.getNombre());
    m.put(idmedico, medico.getNombre());

    f.put(idpaciente, paciente.getFechanacimiento());
    u.put(idmedico, medico.getEspecializacion());
}

   public Cita(Pacientes paciente, Medicos medico, LocalDate fechacita, Prioridad prioridad, TipoAgenda tipo) {
    this.tipo = tipo;
    this.idcita = contador++;

    this.idpaciente = paciente.getId();
    this.idmedico = medico.getId();

    m.put(idpaciente, paciente.getNombre());
    m.put(idmedico, medico.getNombre());

    f.put(idpaciente, paciente.getFechanacimiento());
    u.put(idmedico, medico.getEspecializacion());

    this.fechacita = fechacita;
    this.prioridad = prioridad;
}
    public LocalDate getFechanacimientoPaciente(){
        return f.get(idpaciente);
    }
    
    public Especialidad getEspecialidadMedico(){
        return u.get(idmedico);
    }
    public int getIdpaciente() {
        return idpaciente;
    }

    public int getIdmedico() {
        return idmedico;
    }
    
    public int getIdcita() {
        return idcita;
    }
    public String getNombrePaciente(){
        return m.get(idpaciente);
    }
    
    public String getNombreMedico(){
        return m.get(idmedico);
    }
    
    public Prioridad getPrioridad() {
        return prioridad;
    }

    public LocalDate getFechacita() {
        return fechacita;
    }

    public void setFechacita(LocalDate fechacita) {
        this.fechacita = fechacita;
    }
    
    @Override
    public String toString(){
        return "El id de la cita es: " + idcita + ", la prioridad es: " + prioridad + ", el nombre del paciente es: "  + getNombrePaciente() +", el nombre del medico es: " + getNombreMedico()+", la fecha es:  " + fechacita;
    }
    
}
