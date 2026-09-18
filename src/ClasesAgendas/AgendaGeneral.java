/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAgendas;

import ClasesCitas.*;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yassin
 */
public class AgendaGeneral {

    int cont = 0;
    public static List<Cita> citasGeneral = new ArrayList<>();
    public static List<Cita> citasUrgencias = new ArrayList<>();
    public static List<Cita> citasEspecialistas = new ArrayList<>();
    Comparator comparador = new Comparator();
    TipoAgenda tipoagenda;

    public AgendaGeneral() {
        
    }

    public List<Cita> getCitasUrgencias() {
        return citasUrgencias;
    }

    public void setTipoagenda(TipoAgenda tipoagenda) {
        this.tipoagenda = tipoagenda;
    }

    public TipoAgenda getTipoagenda() {
        return tipoagenda;
    }

    public void mostrarCitas(TipoAgenda tipo) {
        System.out.println(citasGeneral.size());
        if (tipo.equals(TipoAgenda.GENERAL)) {
            for (Cita citas : citasGeneral) {
                System.out.println(citas);
            }
            if (citasGeneral.isEmpty()) {
                System.out.println("No hay ninguna cita en la agenda");
            }
        } else if (tipo.equals(TipoAgenda.URGENCIAS)) {
            for (Cita citas : citasUrgencias) {
                System.out.println(citas);
            }
            if (citasUrgencias.isEmpty()) {
                System.out.println("No hay ninguna cita en la agenda");
            }
        } else {
            for (Cita citas : citasEspecialistas) {
                System.out.println(citas);
            }
            if (citasEspecialistas.isEmpty()) {
                System.out.println("No hay ninguna cita en la agenda");
            }
        }
    }
    public int getsizeagendaGeneral(){
        return citasGeneral.size();
    }
    public void insertarCita(Cita cita) {
        if (tipoagenda.equals(TipoAgenda.GENERAL) && cita instanceof CitaGeneral) {
            int i = 0;
            while (i < citasGeneral.size()) {
                if (citasGeneral.get(i).getFechacita().isAfter(cita.getFechacita())) {
                    citasGeneral.add(i, cita);
                    break;
                } else if (citasGeneral.get(i).getFechacita().equals(cita.getFechacita())) {
                    if (comparador.compare(citasGeneral.get(i).getPrioridad(), cita.getPrioridad()) > 0) {
                        citasGeneral.add(i, cita);
                        break;
                    } else if (citasGeneral.get(i).getPrioridad().equals(cita.getPrioridad())) {
                        if (citasGeneral.get(i).getIdcita() > cita.getIdcita()) {
                            citasGeneral.add(i, cita);
                            break;
                        }
                    }
                }
                i++;
            }
            if (i == citasGeneral.size()) {
                citasGeneral.add(i, cita);
            }
            System.out.println("Añadiendo cita...");
        } else if (tipoagenda.equals(TipoAgenda.ESPECIALISTA) && cita instanceof CitaEspecialista) {
            int i = 0;
            while (i < citasEspecialistas.size()) {
                if (citasEspecialistas.get(i).getFechacita().isAfter(cita.getFechacita())) {
                    citasEspecialistas.add(i, cita);
                    break;
                } else if (citasEspecialistas.get(i).getFechacita().equals(cita.getFechacita())) {
                    if (comparador.compare(citasEspecialistas.get(i).getPrioridad(), cita.getPrioridad()) > 0) {
                        citasEspecialistas.add(i, cita);
                        break;
                    } else if (citasEspecialistas.get(i).getPrioridad().equals(cita.getPrioridad())) {
                        if (citasEspecialistas.get(i).getIdcita() > cita.getIdcita()) {
                            citasEspecialistas.add(i, cita);
                            break;
                        }
                    }
                }
                i++;
            }
            if (i == citasEspecialistas.size()) {
                citasEspecialistas.add(i, cita);
            }
            System.out.println("Añadiendo cita...");
        } else if (tipoagenda.equals(TipoAgenda.URGENCIAS) && cita instanceof CitaUrgencias) {
            int i = 0;
            while (i < citasUrgencias.size()) {
                if (citasUrgencias.get(i).getFechacita().isAfter(cita.getFechacita())) {
                    citasUrgencias.add(i, cita);
                    break;
                } else if (citasUrgencias.get(i).getFechacita().equals(cita.getFechacita())) {
                    if (comparador.compare(citasUrgencias.get(i).getPrioridad(), cita.getPrioridad()) > 0) {
                        citasUrgencias.add(i, cita);
                        break;
                    } else if (citasUrgencias.get(i).getPrioridad().equals(cita.getPrioridad())) {
                        if (citasUrgencias.get(i).getIdcita() > cita.getIdcita()) {
                            citasUrgencias.add(i, cita);
                            break;
                        }
                    }
                }
                i++;
            }
            if (i == citasUrgencias.size()) {
                citasUrgencias.add(i, cita);
            }
            System.out.println("Añadiendo cita...");
        } else {
            System.out.println("No estas introduciendo la cita en la agenda correcta");
        }

    }

    public void actualizarfecha(Cita cita, LocalDate fecha) {
        if (tipoagenda.equals(TipoAgenda.GENERAL) && cita instanceof CitaGeneral) {
            if (citasGeneral.contains(cita)) {
                cita.setFechacita(fecha);
                citasGeneral.remove(cita);
                int i = 0;
                while (i < citasGeneral.size()) {
                    if (citasGeneral.get(i).getFechacita().isAfter(cita.getFechacita())) {
                        citasGeneral.add(i, cita);
                        break;
                    } else if (citasGeneral.get(i).getFechacita().equals(cita.getFechacita())) {
                        if (comparador.compare(citasGeneral.get(i).getPrioridad(), cita.getPrioridad()) > 0) {
                            citasGeneral.add(i, cita);
                            break;
                        } else if (citasGeneral.get(i).getPrioridad().equals(cita.getPrioridad())) {
                            if (citasGeneral.get(i).getIdcita() > cita.getIdcita()) {
                                citasGeneral.add(i, cita);
                                break;
                            }
                        }
                    }
                    i++;
                }
                if (i == citasGeneral.size()) {
                    citasGeneral.add(i, cita);
                }
                System.out.println("Cambiando fecha");
            }
        } else if (tipoagenda.equals(TipoAgenda.ESPECIALISTA) && cita instanceof CitaEspecialista) {
            if (citasEspecialistas.contains(cita)) {
                cita.setFechacita(fecha);
                citasEspecialistas.remove(cita);
                int i = 0;
                while (i < citasEspecialistas.size()) {
                    if (citasEspecialistas.get(i).getFechacita().isAfter(cita.getFechacita())) {
                        citasEspecialistas.add(i, cita);
                        break;
                    } else if (citasEspecialistas.get(i).getFechacita().equals(cita.getFechacita())) {
                        if (comparador.compare(citasEspecialistas.get(i).getPrioridad(), cita.getPrioridad()) > 0) {
                            citasEspecialistas.add(i, cita);
                            break;
                        } else if (citasEspecialistas.get(i).getPrioridad().equals(cita.getPrioridad())) {
                            if (citasEspecialistas.get(i).getIdcita() > cita.getIdcita()) {
                                citasEspecialistas.add(i, cita);
                                break;
                            }
                        }
                    }
                    i++;
                }
                if (i == citasEspecialistas.size()) {
                    citasEspecialistas.add(i, cita);
                }
                System.out.println("Cambiando fecha");
            }
        } else if (tipoagenda.equals(TipoAgenda.URGENCIAS) && cita instanceof CitaUrgencias) {
            if (citasUrgencias.contains(cita)) {
                cita.setFechacita(fecha);
                citasUrgencias.remove(cita);
                int i = 0;
                while (i < citasUrgencias.size()) {
                    if (citasUrgencias.get(i).getFechacita().isAfter(cita.getFechacita())) {
                        citasUrgencias.add(i, cita);
                        break;
                    } else if (citasUrgencias.get(i).getFechacita().equals(cita.getFechacita())) {
                        if (comparador.compare(citasUrgencias.get(i).getPrioridad(), cita.getPrioridad()) > 0) {
                            citasUrgencias.add(i, cita);
                            break;
                        } else if (citasUrgencias.get(i).getPrioridad().equals(cita.getPrioridad())) {
                            if (citasUrgencias.get(i).getIdcita() > cita.getIdcita()) {
                                citasUrgencias.add(i, cita);
                                break;
                            }
                        }
                    }
                    i++;
                }
                if (i == citasUrgencias.size()) {
                    citasUrgencias.add(i, cita);
                }
                System.out.println("Cambiando fecha");
            }
        } else {
            System.out.println("La cita no esta en la agenda");
        }
    }

    public void cancelarcita(int id) {
        if (tipoagenda.equals(TipoAgenda.URGENCIAS)) {
            for (int i = 0; i < citasUrgencias.size(); i++) {
                if (id == citasUrgencias.get(i).getIdcita()) {
                    citasUrgencias.remove(i);
                    break;
                } else if (i == citasUrgencias.size() - 1) {
                    System.out.println("El id no existe en la agenda");
                }
            }
        } else if (tipoagenda.equals(TipoAgenda.GENERAL)) {
            for (int i = 0; i < citasGeneral.size(); i++) {
                if (id == citasGeneral.get(i).getIdcita()) {
                    citasGeneral.remove(i);
                    break;
                } else if (i == citasGeneral.size() - 1) {
                    System.out.println("El id no existe en la agenda");
                }
            }
        } else {
            for (int i = 0; i < citasEspecialistas.size(); i++) {
                if (id == citasEspecialistas.get(i).getIdcita()) {
                    citasEspecialistas.remove(i);
                    break;
                } else if (i == citasEspecialistas.size() - 1) {
                    System.out.println("El id no existe en la agenda");
                }
            }
        }
    }

    public void siguientecita() {
        if (tipoagenda.equals(TipoAgenda.URGENCIAS)) {
            if (cont < citasUrgencias.size()) {
                System.out.println("La siguiente cita es: " + citasUrgencias.get(cont));
                cont++;
            } else {
                System.out.println("Ya no hay mas citas en la agenda");
            }
        } else if (tipoagenda.equals(TipoAgenda.GENERAL)) {
            if (cont < citasGeneral.size()) {
                System.out.println("La siguiente cita es: " + citasGeneral.get(cont));
                cont++;
            } else {
                System.out.println("Ya no hay mas citas en la agenda");
            }
        } else {
            if (cont < citasEspecialistas.size()) {
                System.out.println("La siguiente cita es: " + citasEspecialistas.get(cont));
                cont++;

            } else {
                System.out.println("Ya no hay mas citas en la agenda");
            }
        }
    }

    public void vaciar() {
        if (tipoagenda.equals(TipoAgenda.URGENCIAS)) {
            citasUrgencias.clear();
        }else if(tipoagenda.equals(TipoAgenda.GENERAL)){
            citasGeneral.clear();
        }else{
            citasEspecialistas.clear();
        }
    }
     
}
