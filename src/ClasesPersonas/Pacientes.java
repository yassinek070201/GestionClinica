/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPersonas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Yassin
 */
public class Pacientes {

    private String nombre;
    private LocalDate fechanacimiento;
    private int id;
    private static int contador = 1;
    

    List<Pacientes> pacientes = new ArrayList<>();

    public Pacientes() {
    }

    public Pacientes(String nombre, LocalDate fechanacimiento, int id) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.id = id;
        if (id >= contador) {
            contador = id + 1;
        }
    }

    public Pacientes(String nombre, LocalDate fechanacimiento) {
        this.nombre = nombre;
        this.fechanacimiento = fechanacimiento;
        this.id = contador++;
    }

    public List<Pacientes> getPacientes() {
        return pacientes;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void insertar(Pacientes paciente) {
        pacientes.add(paciente);
    }

    public void mostrarPacientes() {
        if (pacientes.size() == 0) {
            System.out.println("No hay pacientes en la clinica");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
                Pacientes paciente = pacientes.get(i);
                System.out.println(paciente.toString());
            }
        }
    }

    @Override
    public String toString() {
        return "El id del paciente es: " + id + ", el nombre es: " + nombre + ", la fecha de nacimiento es: " + fechanacimiento;
    }

}
