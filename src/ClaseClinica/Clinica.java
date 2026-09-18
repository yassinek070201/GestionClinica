/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClaseClinica;


/**
 *
 * @author Yassin
 */
import ClasesCitas.*;
import ClasesCitas.Prioridad;
import ClasesAgendas.AgendaGeneral;
import ClasesAgendas.AgendaXML;
import ClasesAgendas.TipoAgenda;
import ClasesPersonas.Especialidad;
import ClasesPersonas.Medicos;
import ClasesPersonas.Pacientes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ClasesPersonas.MedicosCSV;
import ClasesPersonas.PacientesCSV;
import ClasesAgendas.AgendaXML;
public class Clinica {

    Pacientes paciente2;
    Medicos medico2;

    public List<Medicos> medicos = new ArrayList<>();
    public List<Pacientes> pacientes = new ArrayList<>();

    private List<Pacientes> listaPacientes;
    private List<Medicos> listaMedicos;

    AgendaGeneral agenda = new AgendaGeneral();

    public static List<Cita> citasGeneral = new ArrayList<>();
    public static List<Cita> citasUrgencias = new ArrayList<>();
    public static List<Cita> citasEspecialistas = new ArrayList<>();

    public Clinica() {
        System.out.println("Iniciando clínica y cargando información...");

        listaPacientes = PacientesCSV.cargarPacientes("pacientes.csv");
        listaMedicos = MedicosCSV.cargarMedicosCSV("medicos.csv");

        pacientes.addAll(listaPacientes);
        medicos.addAll(listaMedicos);

        citasUrgencias = AgendaXML.cargarCitasXML();
    }

    Pacientes paciente;

    public void insertarMedico(String nombre, Especialidad especializacion) {
        Medicos medico = new Medicos(nombre, especializacion);
        medicos.add(medico);
    }

    public void insertarPaciente(String nombre, LocalDate fecha) {
        paciente = new Pacientes(nombre, fecha);
        pacientes.add(paciente);
    }

    public void mostrarMedico() {
        if (medicos.size() != 0) {
            for (Medicos medico : medicos) {
                System.out.println(medico.toString());
            }
        } else {
            System.out.println("No hay medicos");
        }
    }

    public void mostrarPaciente() {
        if (pacientes.size() != 0) {
            for (Pacientes paciente : pacientes) {
                System.out.println(paciente.toString());
            }
        } else {
            System.out.println("No hay pacientes");
        }
    }
   public void actualizarFechaCita(int id, LocalDate fecha) {

    for (Cita cita : AgendaGeneral.citasGeneral) {
        if (cita.getIdcita() == id) {
            agenda.setTipoagenda(TipoAgenda.GENERAL);
            agenda.actualizarfecha(cita, fecha);
            return;
        }
    }

    for (Cita cita : AgendaGeneral.citasEspecialistas) {
        if (cita.getIdcita() == id) {
            agenda.setTipoagenda(TipoAgenda.ESPECIALISTA);
            agenda.actualizarfecha(cita, fecha);
            return;
        }
    }

    for (Cita cita : AgendaGeneral.citasUrgencias) {
        if (cita.getIdcita() == id) {
            agenda.setTipoagenda(TipoAgenda.URGENCIAS);
            agenda.actualizarfecha(cita, fecha);
            return;
        }
    }

    System.out.println("No existe una cita con el ID " + id);
}
    public void crearCita(int idpaciente, int idmedico, LocalDate fecha,
            Prioridad prioridad, TipoAgenda tipo) {

        paciente2 = null;

        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getId() == idpaciente) {
                paciente2 = pacientes.get(i);
                break;
            }
        }

        if (paciente2 == null) {
            System.out.println("No esta este paciente");
            return;
        }

        medico2 = null;

        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).getId() == idmedico) {
                medico2 = medicos.get(i);
                break;
            }
        }

        if (medico2 == null) {
            System.out.println("No esta este medico");
            return;
        }

        agenda.setTipoagenda(tipo);

        if (tipo.equals(TipoAgenda.ESPECIALISTA)) {

            CitaEspecialista cita = new CitaEspecialista(
                    paciente2, medico2, fecha, prioridad, tipo);

            agenda.insertarCita(cita);

        } else if (tipo.equals(TipoAgenda.GENERAL)) {

            CitaGeneral cita = new CitaGeneral(
                    paciente2, medico2, fecha, prioridad, tipo);

            agenda.insertarCita(cita);

        } else if (tipo.equals(TipoAgenda.URGENCIAS)) {

            CitaUrgencias cita = new CitaUrgencias(
                    paciente2, medico2, fecha, prioridad, tipo);

            agenda.insertarCita(cita);
        }
    }

    public void cancelarCita(int id) {
        agenda.cancelarcita(id);
    }

    public void siguienteCita() {
        agenda.siguientecita();
    }

    public void mostrarcitas(TipoAgenda tipo) {
        agenda.mostrarCitas(tipo);
    }
}
