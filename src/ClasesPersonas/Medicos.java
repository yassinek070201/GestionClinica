/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPersonas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yassin
 */
public class Medicos {
    private int id;
    private static int contador =1;
    private String nombre;
    private Especialidad especializacion;
    
    List<Medicos> medicos = new ArrayList<>();

    public Medicos(String nombre, Especialidad especializacion) {
        this.id = contador++;
        this.nombre = nombre;
        this.especializacion = especializacion;
    }

    public Medicos() {
    }

    public Medicos( String nombre, int id) {
        this.id = id;
        this.nombre = nombre;
        if (id >= contador) {
            contador = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Especialidad getEspecializacion() {
        return especializacion;
    }
    public void setEspecializacion(Especialidad especializacion) {
        this.especializacion = especializacion;
    }
    public void insertar(Medicos medico){
        medicos.add(medico);
    }
    public void mostrarMedicos(){
        if(medicos.size()==0)
            System.out.println("No hay medicos en la clinica");
        else{
            for(int i=0; i<medicos.size(); i++ ){
                Medicos medico= medicos.get(i);
                System.out.println(medico.toString());
            }
        }
    }
    @Override
    public String toString(){
        return "El id del medico es: " + id + ", el nombre es: " + nombre + ", la especializacion es: " + especializacion;
    }
    
}
