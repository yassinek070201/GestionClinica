/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPersonas;

/**
 *
 * @author Yassin
 */
public enum Especialidad{
       GENERAL, OTORRINO, CIRUJANO, PEDIATRIA, OFTALMOLOGO;
        @Override
    public String toString() {
        return this.name().toLowerCase(); 
    }
    }

