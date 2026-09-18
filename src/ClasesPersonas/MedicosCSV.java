package ClasesPersonas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Utilidades para guardar y cargar médicos en formato CSV. */
public class MedicosCSV extends Medicos {

    public void crearMedicos() {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("medicos.csv"))) {
            for (Medicos medico : medicos) {
                fw.write(medico.getNombre() + ";" + medico.getId() + ";" + medico.getEspecializacion());
                fw.newLine();
            }
            System.out.println("Médicos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar médicos: " + e.getMessage());
        }
    }

    public static List<Medicos> cargarMedicosCSV(String archivo) {
        List<Medicos> listaMedicos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(";", -1);
                if (datos.length < 2) {
                    
                    datos = linea.split("\\s+");
                }

                if (datos.length < 3) {
                    System.out.println("Línea de médico ignorada por formato incorrecto: " + linea);
                    continue;
                }

                String nombre = datos[0].trim();
                int id = Integer.parseInt(datos[1].replace(";", "").trim());
                Medicos medico = new Medicos(nombre, id);
                medico.setEspecializacion(Especialidad.valueOf(datos[2].trim().toUpperCase()));
                listaMedicos.add(medico);
            }
            System.out.println("Médicos cargados correctamente: " + listaMedicos.size());
        } catch (IOException e) {
            System.out.println("Error al cargar médicos: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error en el formato de médicos: " + e.getMessage());
        }

        return listaMedicos;
    }
}
