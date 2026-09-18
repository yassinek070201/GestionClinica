/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesCitas;

/**
 *
 * @author Yassin
 */
public enum Prioridad {
    BAJA, MEDIA, ALTA;
     @Override
  public String toString() {
        return this.name().toLowerCase(); 
  }
}
