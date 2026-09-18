/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesAgendas;

import ClasesCitas.Cita;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.time.format.DateTimeFormatter;
import ClasesPersonas.Especialidad;
import ClasesPersonas.Medicos;
import ClasesPersonas.Pacientes;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.NodeList;

/**
 *
 * @author Yassin
 */
public class AgendaXML extends AgendaGeneral {

    public void CrearAgendaUrgencias() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document documento = implementation.createDocument(null, "citas", null);
            documento.setXmlVersion("1.0");
            if (citasUrgencias.size() == 0) {
                System.out.println("citasUrgencias es null en AgendaGeneral");

            } else {
                for (int i = 0; i < citasUrgencias.size(); i++) {
                    Cita cita = citasUrgencias.get(i);

                    Element elementoCita = documento.createElement("Cita");
                    elementoCita.setAttribute("Id", Integer.toString(cita.getIdcita()));

                    Element elementoPaciente = documento.createElement("Paciente");
                    elementoPaciente.setAttribute("Id", Integer.toString(cita.getIdpaciente()));
                    Element elementoNombre = documento.createElement("nombre");
                    elementoNombre.appendChild(documento.createTextNode(cita.getNombrePaciente()));
                    Element elementoFecha = documento.createElement("fechaNacimiento");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    elementoFecha.appendChild(documento.createTextNode(cita.getFechanacimientoPaciente().format(formatter)));
                    elementoPaciente.appendChild(elementoNombre);
                    elementoPaciente.appendChild(elementoFecha);

                    Element elementoMedico = documento.createElement("Medico");
                    elementoMedico.setAttribute("Id", Integer.toString(cita.getIdmedico()));
                    Element elementoNombreMedico = documento.createElement("nombre");
                    elementoNombreMedico.appendChild(documento.createTextNode(cita.getNombreMedico()));
                    Element elementoEspecialidad = documento.createElement("especialidad");
                    elementoEspecialidad.appendChild(documento.createTextNode(cita.getEspecialidadMedico().toString()));
                    elementoMedico.appendChild(elementoNombreMedico);
                    elementoMedico.appendChild(elementoEspecialidad);

                    elementoCita.appendChild(elementoPaciente);
                    elementoCita.appendChild(elementoMedico);

                    documento.getDocumentElement().appendChild(elementoCita);
                    Transformer transformer = TransformerFactory.newInstance().newTransformer();
                    Source source = new DOMSource(documento);
                    Result result = new StreamResult(new File("AgendaUrgencias.xml"));
                    transformer.transform(source, result);
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<Cita> cargarCitasXML() {
        List<Cita> listaCitas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("AgendaUrgencias.xml"));
            NodeList listacitas = documento.getElementsByTagName("Cita");
            for(int i=0; i<listacitas.getLength();i++){
                Element citaElement= (Element) listacitas.item(i);
                int idcita= Integer.parseInt(citaElement.getAttribute("Id"));
                Element pacienteElement = (Element) citaElement.getElementsByTagName("Paciente").item(0);
                int idPaciente = Integer.parseInt(pacienteElement.getAttribute("Id"));
                String nombrePaciente = pacienteElement.getElementsByTagName("nombre").item(0).getTextContent();
                 LocalDate fechaNacimiento = LocalDate.parse(pacienteElement.getElementsByTagName("fechaNacimiento").item(0).getTextContent(), formatter);
                 Pacientes paciente = new Pacientes( nombrePaciente, fechaNacimiento, idPaciente);
                 Element medicoElement = (Element) citaElement.getElementsByTagName("Medico").item(0);
                 int idMedico = Integer.parseInt(medicoElement.getAttribute("Id"));
                 String nombreMedico = medicoElement.getElementsByTagName("nombre").item(0).getTextContent();
                 String especialidad = medicoElement.getElementsByTagName("especialidad").item(0).getTextContent();
                 Medicos medico = new Medicos( nombreMedico,idMedico);
                 listaCitas.add(new Cita(idcita, paciente, medico));
                 
                 
            }
        }catch(Exception e){
                   System.out.println(e.getMessage());
                   }
        return listaCitas;
        }
}
