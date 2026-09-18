package ClasesPersonas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class PacientesCSV extends Pacientes {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public PacientesCSV() {
    }

    public void crearPacientes() {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter("pacientes.csv"))) {
            for (Pacientes paciente : pacientes) {
                fw.write(paciente.getNombre() + ";"
                        + paciente.getFechanacimiento().format(FORMATTER) + ";"
                        + paciente.getId());
                fw.newLine();
            }
            System.out.println("Pacientes guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar pacientes: " + e.getMessage());
        }
    }

    public static List<Pacientes> cargarPacientes(String archivo) {
        List<Pacientes> listaPacientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(";", -1);
                if (datos.length < 3) {
                    System.out.println("Línea de paciente ignorada por formato incorrecto: " + linea);
                    continue;
                }

                String nombre = datos[0].trim();
                LocalDate fechaNacimiento = LocalDate.parse(datos[1].trim(), FORMATTER);
                int id = Integer.parseInt(datos[2].trim());
                listaPacientes.add(new Pacientes(nombre, fechaNacimiento, id));
            }
            System.out.println("Pacientes cargados correctamente: " + listaPacientes.size());
        } catch (IOException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Error en el formato de pacientes: " + e.getMessage());
        }

        return listaPacientes;
    }
}
