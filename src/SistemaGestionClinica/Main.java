/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package SistemaGestionClinica;

import ClasesAgendas.TipoAgenda;
import ClaseClinica.Clinica;
import ClasesCitas.*;
import ClasesPersonas.Especialidad;
import ClasesPersonas.Pacientes;
import ClasesPersonas.Medicos;
import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

/**
 *
 * @author Yassin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion, opcion2, ano, dia, mes, idpaciente, idmedico, opcion3, opcion4;
        String nombre, nombre2;
        Especialidad especializacion;
        Prioridad prioridad;
        TipoAgenda tipo;

        Scanner scn = new Scanner(System.in);
        Clinica clinica = new Clinica();
        do {
            System.out.println("1.- Introducir nuevo paciente");
            System.out.println("2.- Introducir nuveo medico");
            System.out.println("3.- Consultar todos los pacientes");
            System.out.println("4.- Consultar todos los medicos");
            System.out.println("5.- Crear una nueva cita");
            System.out.println("6.- Actualizar fecha de una cita");
            System.out.println("7.- Cancelar una cita");
            System.out.println("8.- Dar paso a la siguiete cita");
            System.out.println("9.- Consultar todas las citas");
            System.out.println("0.- Salir");
            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Dime el nombre del paciente");
                    nombre2 = scn.next();
                    System.out.println("Dime el año de nacimiento");
                    ano = scn.nextInt();
                    System.out.println("Dime el mes de nacimiento");
                    mes = scn.nextInt();
                    System.out.println("Dime el dia de nacimiento");
                    dia = scn.nextInt();
                    if (mes <= 12) {
                        switch (mes) {
                            case 1, 3, 5, 7, 8, 10, 12:
                                if (dia <= 31) {
                                    clinica.insertarPaciente(nombre2, LocalDate.of(ano, mes, dia));
                                } else {
                                    System.out.println("Para ese mes solo tiene 31 dias");
                                }
                                break;
                            case 4, 6, 9, 11:
                                if (dia <= 30) {
                                    clinica.insertarPaciente(nombre2, LocalDate.of(ano, mes, dia));
                                } else {
                                    System.out.println("Para ese mes solo tiene 30 dias");
                                }
                                break;
                            case 2:
                                if (ano % 4 == 0 || ano % 100 == 0 || ano % 400 == 0) {
                                    if (dia <= 29) {
                                        clinica.insertarPaciente(nombre2, LocalDate.of(ano, mes, dia));
                                    } else {
                                        System.out.println("El ano es bisiesto solo tiene 29 dias");
                                    }
                                } else {
                                    if (dia <= 28) {
                                        clinica.insertarPaciente(nombre2, LocalDate.of(ano, mes, dia));
                                    } else {
                                        System.out.println("Febrero solo tiene 28 dias");
                                    }
                                }
                                break;
                        }
                    } else {
                        System.out.println("El ano solo tiene 12 meses");
                    }
                    break;
                case 2:
                    System.out.println("Dame el nombre del medico: ");
                    nombre = scn.next();
                    System.out.println("Dame la especializacion");
                    System.out.println("1.-GENERAL");
                    System.out.println("2.-OTORRINO");
                    System.out.println("3.-CIRUJANO");
                    System.out.println("4.-PEDIATRA");
                    System.out.println("5.-OFTALMOLOGO");
                    opcion2 = scn.nextInt();
                    switch (opcion2) {
                        case 1:
                            especializacion = Especialidad.GENERAL;
                            clinica.insertarMedico(nombre, especializacion);
                            break;
                        case 2:
                            especializacion = Especialidad.OTORRINO;
                            clinica.insertarMedico(nombre, especializacion);
                            break;
                        case 3:
                            especializacion = Especialidad.CIRUJANO;
                            clinica.insertarMedico(nombre, especializacion);
                            break;
                        case 4:
                            especializacion = Especialidad.PEDIATRIA;
                            clinica.insertarMedico(nombre, especializacion);
                            break;
                        case 5:
                            especializacion = Especialidad.OFTALMOLOGO;
                            clinica.insertarMedico(nombre, especializacion);
                            break;
                        default:
                            System.out.println("Introduce un numero del menu");
                            break;
                    }
                    break;
                case 3:
                    clinica.mostrarPaciente();
                    break;
                case 4:
                    clinica.mostrarMedico();
                    break;
                case 5:
                    System.out.println("Dame el id del paciente a insertar: ");
                    idpaciente = scn.nextInt();
                    System.out.println("Dame el id del medico a insertar");
                    idmedico = scn.nextInt();
                    System.out.println("Dime el año de la cita");
                    ano = scn.nextInt();
                    System.out.println("Dime el mes de la cita");
                    mes = scn.nextInt();
                    System.out.println("Dime el dia de la cita");
                    dia = scn.nextInt();
                    System.out.println("Que prioridad tiene la cita?");
                    System.out.println("1.- Baja");
                    System.out.println("2.- Media");
                    System.out.println("3. Alta");
                    opcion3 = scn.nextInt();
                    if (opcion3 == 1) {
                        prioridad = Prioridad.BAJA;
                    } else if (opcion3 == 2) {
                        prioridad = Prioridad.MEDIA;
                    } else {
                        prioridad = Prioridad.ALTA;
                    }

                    System.out.println("Que tipo de cita quires?");
                    System.out.println("1.- General");
                    System.out.println("2.- Especialidad");
                    System.out.println("3.- Urgencias");
                    opcion4 = scn.nextInt();
                    if (opcion4 == 1) {
                        tipo = TipoAgenda.GENERAL;
                    } else if (opcion4 == 2) {
                        tipo = TipoAgenda.ESPECIALISTA;
                    } else {
                        tipo = TipoAgenda.URGENCIAS;
                    }

                    if (mes <= 12) {
                        switch (mes) {
                            case 1, 3, 5, 7, 8, 10, 12:
                                if (dia <= 31) {
                                    clinica.crearCita(idpaciente, idmedico, LocalDate.of(ano, mes, dia), prioridad, tipo);
                                } else {
                                    System.out.println("Para ese mes solo tiene 31 dias");
                                }
                                break;
                            case 4, 6, 9, 11:
                                if (dia <= 30) {
                                    clinica.crearCita(idpaciente, idmedico, LocalDate.of(ano, mes, dia), prioridad, tipo);
                                } else {
                                    System.out.println("Para ese mes solo tiene 30 dias");
                                }
                                break;
                            case 2:
                                if (ano % 4 == 0 || ano % 100 == 0 || ano % 400 == 0) {
                                    if (dia <= 29) {
                                        clinica.crearCita(idpaciente, idmedico, LocalDate.of(ano, mes, dia), prioridad, tipo);
                                    } else {
                                        System.out.println("El ano es bisiesto solo tiene 29 dias");
                                    }
                                } else {
                                    if (dia <= 28) {
                                        clinica.crearCita(idpaciente, idmedico, LocalDate.of(ano, mes, dia), prioridad, tipo);
                                    } else {
                                        System.out.println("Febrero solo tiene 28 dias");
                                    }
                                }
                                break;
                        }
                    } else {
                        System.out.println("El ano solo tiene 12 meses");
                    }
                    break;
                case 6:
                    System.out.println("Dame el id de la cita que quieres actualizar:");
                    int idcita = scn.nextInt();

                    System.out.println("Dime el nuevo año:");
                    ano = scn.nextInt();

                    System.out.println("Dime el nuevo mes:");
                    mes = scn.nextInt();

                    System.out.println("Dime el nuevo dia:");
                    dia = scn.nextInt();

                    LocalDate nuevaFecha = LocalDate.of(ano, mes, dia);

                    clinica.actualizarFechaCita(idcita, nuevaFecha);

                    break;
                case 7:
                    System.out.println("Dame el id de la cita");
                    int id=scn.nextInt();
                    clinica.cancelarCita(id);
                    break;
                case 8:
                    clinica.siguienteCita();
                    break;
                case 9:
                    System.out.println("Que tipo de cita quires?");
                    System.out.println("1.- General");
                    System.out.println("2.- Especialidad");
                    System.out.println("3.- Urgencias");
                    opcion4 = scn.nextInt();
                    if (opcion4 == 1) {
                        tipo = TipoAgenda.GENERAL;
                    } else if (opcion4 == 2) {
                        tipo = TipoAgenda.ESPECIALISTA;
                    } else {
                        tipo = TipoAgenda.URGENCIAS;
                    }
                    clinica.mostrarcitas(tipo);
                    break;
                case 0:
                    System.out.println("Hasta Pronto");
                    break;
            }
        } while (opcion != 0);
    }

}
