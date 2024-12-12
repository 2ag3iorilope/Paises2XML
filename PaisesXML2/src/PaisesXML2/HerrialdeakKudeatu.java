package PaisesXML2;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class HerrialdeakKudeatu {

    public HerrialdeakKudeatu() {
       
    }

    public void SortuXML() {
        try {
           
            Kontinenteak africa = new Kontinenteak("Africa", 30370000, 54, 1460000000);
            Kontinenteak america = new Kontinenteak("America", 42549000, 35, 1050000000);
            Kontinenteak asia = new Kontinenteak("Asia", 44579000, 49, 475000000);
            Kontinenteak europa = new Kontinenteak("Europa", 10180000, 44, 750000000);
            Kontinenteak oceania = new Kontinenteak("Oceania", 8526000, 14, 44000000);
            List<Kontinenteak> kontinenteaks = List.of(africa, america, asia, europa, oceania);

          
            List<Herriak> herriakList = List.of(
                new Herriak("376", "Andorra", 0, LocalDate.of(1993, 3, 14), 64000, "Andorra La Vieja", europa),
                new Herriak("213", "Argelia", 70, LocalDate.of(1962, 3, 3), 27959000, "Argel", africa),
                new Herriak("994", "Azerbayan", 70, LocalDate.of(1991, 8, 30), 7510000, "Baku", asia),
                new Herriak("291", "Eritrea", 0, LocalDate.of(1993, 5, 24), 3400000, "Asmara", africa),
                new Herriak("30", "Grecia", 78, LocalDate.of(1830, 2, 3), 10467000, "Atenas", europa),
                new Herriak("31", "Holanda", 78, LocalDate.of(1581, 7, 26), 15460000, "Amsterdam", europa),
                new Herriak("964", "Irak", 66, LocalDate.of(1958, 7, 14), 20097000, "Bagdad", asia),
                new Herriak("261", "Madagascar", 52, LocalDate.of(1960, 6, 26), 13651000, "Antananarivo", africa),
                new Herriak("223", "Mali", 50, LocalDate.of(1960, 9, 22), 9788000, "Bamaco", africa),
                new Herriak("595", "Paraguay", 68, LocalDate.of(1811, 5, 14), 4828000, "Asuncion", america),
                new Herriak("684", "Samoa Occidental", 68, LocalDate.of(1962, 1, 1), 165000, "Apia", oceania),
                new Herriak("90", "Turquia", 67, LocalDate.of(1923, 10, 29), 61058000, "Ankara", asia)
            );

            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("Kontinenteak");
            doc.appendChild(root);

            for (Kontinenteak kontinentea : kontinenteaks) {
                Element kontinenteElement = doc.createElement("Kontinentea");
                root.appendChild(kontinenteElement);

                kontinenteElement.setAttribute("izena", kontinentea.getIzenaString());
                kontinenteElement.setAttribute("azalera", String.valueOf(kontinentea.getSuperficie()));
                kontinenteElement.setAttribute("herrialdeakKop", String.valueOf(kontinentea.getPais_Kop()));
                kontinenteElement.setAttribute("biztanleria", String.valueOf(kontinentea.getPoblazioa()));

                for (Herriak herria : herriakList) {
                    if (herria.getKontinentea().equals(kontinentea)) {
                        Element herriaElement = doc.createElement("Herria");
                        kontinenteElement.appendChild(herriaElement);

                        herriaElement.setAttribute("kodea", herria.getKodeaString());
                        herriaElement.setAttribute("izena", herria.getIzenaString());
                        herriaElement.setAttribute("populazioa", String.valueOf(herria.getPoblazioa()));
                        herriaElement.setAttribute("kapitala", herria.getKapitala());
                        herriaElement.setAttribute("BiziEsperantza", String.valueOf(herria.getBiziEsperantza()));
                        herriaElement.setAttribute("SortzeData", herria.getDataSortuDate().format(DateTimeFormatter.ISO_DATE));
                    }
                }
            }

  
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\2ag3.iorilope\\Desktop\\kontinenteak.xml"));

            transformer.transform(source, result);

            System.out.println("Xml fitxategia ondo sortu da: kontinenteak.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addPaisToContinent() {
        Scanner scanner = new Scanner(System.in);

       
        ErakutsiErabilgarriKontinenteak();

        
        System.out.print("Sartu Herriaren Kodea: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Sartu Herriaren izena: ");
        String nombrePais = scanner.nextLine();
        
        System.out.print("Sartu bizi esperantza: ");
        int esperanzaVida = scanner.nextInt();
        
        System.out.print("Sartu Poblazioa: ");
        double poblacion = scanner.nextDouble();
        
        System.out.print("Sartu kapitala: ");
        scanner.nextLine();
        String capital = scanner.nextLine();
        
        System.out.print("Sartu sortze data (formatua: yyyy-MM-dd): ");
        String fechaIndependencia = scanner.nextLine();
        
        
        LocalDate fecha = LocalDate.parse(fechaIndependencia, DateTimeFormatter.ISO_DATE);

       
        System.out.print("Sartu nahi duzun kontinentearen zenbakia: ");
        int continenteIndex = scanner.nextInt();

        try {
            
            File xmlFile = new File("C:\\Users\\2ag3.iorilope\\Desktop\\kontinenteak.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

         
            doc.getDocumentElement().normalize();

           
            NodeList continentesList = doc.getElementsByTagName("Kontinentea");
            if (continenteIndex < 1 || continenteIndex > continentesList.getLength()) {
                System.out.println("Kontinente zenbaki desegokia.");
                return;
            }

            Element continenteElement = (Element) continentesList.item(continenteIndex - 1); 

            
            Element paisElement = doc.createElement("Herria");

           
            paisElement.setAttribute("kodea", codigo);
            paisElement.setAttribute("izena", nombrePais);
            paisElement.setAttribute("biziesperantza", String.valueOf(esperanzaVida));
            paisElement.setAttribute("kapitala", capital);
            paisElement.setAttribute("SortzeData", fecha.format(DateTimeFormatter.ISO_DATE));

        
            continenteElement.appendChild(paisElement);

           
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\2ag3.iorilope\\Desktop\\kontinenteak.xml"));
            transformer.transform(source, result);

            System.out.println("Herri berria ondo gehitu da ondorengo kontinentera: " + continenteElement.getAttribute("izena") + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void BilatuEtaErakutsiKodeBidez() {
        try {
         
            File xmlFile = new File("C:\\Users\\2ag3.iorilope\\Desktop\\kontinenteak.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

          
            doc.getDocumentElement().normalize();

           
            Scanner scanner = new Scanner(System.in);
            System.out.print("Sartu bilatu nahi duzun herriaren kodea: ");
            String codigoBuscado = scanner.nextLine();

         
            NodeList herriakList = doc.getElementsByTagName("Herria");
            boolean encontrado = false;

            for (int i = 0; i < herriakList.getLength(); i++) {
                Element herriaElement = (Element) herriakList.item(i);
                String codigo = herriaElement.getAttribute("kodea");

                if (codigo.equals(codigoBuscado)) {
                  
                    System.out.println("Herria aurkitu da:");
                    System.out.println("Kodea: " + herriaElement.getAttribute("kodea"));
                    System.out.println("Izena: " + herriaElement.getAttribute("izena"));
                    System.out.println("Poblazioa: " + herriaElement.getAttribute("populazioa"));
                    System.out.println("Kapitala: " + herriaElement.getAttribute("kapitala"));
                    System.out.println("SortzeData: " + herriaElement.getAttribute("SortzeData"));
                    System.out.println("Bizi Esperantza : " + herriaElement.getAttribute("BiziEsperantza"));
                    encontrado = true;
                    break;
                }
            }

         
            if (!encontrado) {
                System.out.println("No se encontró ningún país con el código: " + codigoBuscado);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ErakutsiErabilgarriKontinenteak() {
        try {
           
            File xmlFile = new File("C:\\Users\\2ag3.iorilope\\Desktop\\kontinenteak.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

          
            doc.getDocumentElement().normalize();

        
            Element root = doc.getDocumentElement();

          
            NodeList continentesList = doc.getElementsByTagName("Kontinentea");
            System.out.println("Erabilgarri dauden Kontinenteak:");
            for (int i = 0; i < continentesList.getLength(); i++) {
                Element continente = (Element) continentesList.item(i);
                System.out.println("- " + continente.getAttribute("izena"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ErakutsiXML() {
        try {
            
            File xmlFile = new File("C:\\Users\\2ag3.iorilope\\Desktop\\kontinenteak.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

         
            doc.getDocumentElement().normalize();

        
            Element root = doc.getDocumentElement();

       
            NodeList continentesList = doc.getElementsByTagName("Kontinentea");
            for (int i = 0; i < continentesList.getLength(); i++) {
                Element continente = (Element) continentesList.item(i);

                System.out.println("Kontinentea: " + continente.getAttribute("izena"));
                System.out.println("\tAzalera: " + continente.getAttribute("azalera"));
                System.out.println("\tHerrialdeak kopurua: " + continente.getAttribute("herrialdeakKop"));
                System.out.println("\tBiztanleria: " + continente.getAttribute("biztanleria"));

            
                NodeList paisesList = continente.getElementsByTagName("Herria");
                for (int j = 0; j < paisesList.getLength(); j++) {
                    Element pais = (Element) paisesList.item(j);
                    System.out.println("\t\tHerria: " + pais.getAttribute("izena"));
                    System.out.println("\t\t\tKodea: " + pais.getAttribute("kodea"));
                    System.out.println("\t\t\tPopulazioa: " + pais.getAttribute("populazioa"));
                    System.out.println("\t\t\tKapitala: " + pais.getAttribute("kapitala"));
                    System.out.println("\t\t\tBiziEsperantza: " + pais.getAttribute("BiziEsperantza"));
                    System.out.println("\t\t\tSortzeData: " + pais.getAttribute("SortzeData"));
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Kontinenteak LortuHerriarenKontinentea(Herriak herria) {
        return herria.getKontinentea();
    }

    public void erakutsiKontinenteak(List<Kontinenteak> kontinenteaks) {
        for (Kontinenteak kontinentea : kontinenteaks) {
            System.out.println(kontinentea.getIzenaString());
        }
    }
}

