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

/**
 * The Class HerrialdeakKudeatu.
 */
public class HerrialdeakKudeatu {

	/**
	 * Instantiates a new herrialdeak kudeatu.
	 */
	public HerrialdeakKudeatu() {

	}

	/**
	 * Sortu XML.
	 */
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
					new Herriak("90", "Turkia", 67, LocalDate.of(1923, 10, 29), 61058000, "Ankara", asia));

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc;

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);

			if (xmlFile.exists()) {

				doc = builder.parse(xmlFile);
				System.out.println("Fitxategia existitzen da, erabiltzen...");
			} else {

				doc = builder.newDocument();
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
							herriaElement.setAttribute("SortzeData",
									herria.getDataSortuDate().format(DateTimeFormatter.ISO_DATE));
						}
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);

			transformer.transform(source, result);

			System.out.println("Xml fitxategia ondo sortu/eguneratu da: " + xmlFile.getAbsolutePath());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Herri bat gehitzen du aukeratutako kontinentera
	 */
	public void addPaisToContinent() {
		Scanner scanner = new Scanner(System.in);

		ErakutsiErabilgarriKontinenteak();

		String codigo;
		do {
			System.out.print("Sartu Herriaren Kodea (zenbakia bakarrik): ");
			codigo = scanner.nextLine();
		} while (!codigo.matches("\\d+"));

		String nombrePais;
		do {
			System.out.print("Sartu Herriaren izena (letrak bakarrik): ");
			nombrePais = scanner.nextLine();
		} while (!nombrePais.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+"));

		int esperanzaVida = -1;
		do {
			System.out.print("Sartu bizi esperantza (zenbakia): ");
			if (scanner.hasNextInt()) {
				esperanzaVida = scanner.nextInt();
				scanner.nextLine();
			} else {
				System.out.println("Errorea: Mesedez, zenbaki bat sartu.");
				scanner.nextLine();
			}
		} while (esperanzaVida <= 0);

		double poblacion = -1;
		do {
			System.out.print("Sartu Poblazioa (zenbakia): ");
			if (scanner.hasNextDouble()) {
				poblacion = scanner.nextDouble();
				scanner.nextLine();
			} else {
				System.out.println("Errorea: Mesedez, zenbaki bat sartu.");
				scanner.nextLine();
			}
		} while (poblacion <= 0);

		String capital;
		do {
			System.out.print("Sartu kapitala (letrak bakarrik): ");
			capital = scanner.nextLine();
		} while (!capital.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+"));

		LocalDate fecha = null;
		do {
			System.out.print("Sartu sortze data (formatua: yyyy-MM-dd): ");
			String fechaIndependencia = scanner.nextLine();
			try {
				fecha = LocalDate.parse(fechaIndependencia, DateTimeFormatter.ISO_DATE);
			} catch (Exception e) {
				System.out.println("Errorea: Data formatu okerra. Erabili yyyy-MM-dd formatua.");
			}
		} while (fecha == null);

		int continenteIndex = -1;
		do {
			System.out.print("Sartu nahi duzun kontinentearen zenbakia: ");
			if (scanner.hasNextInt()) {
				continenteIndex = scanner.nextInt();
				scanner.nextLine();
			} else {
				System.out.println("Errorea: Kontinente zenbakia egokia sartu behar duzu.");
				scanner.nextLine();
			}
		} while (continenteIndex <= 0);

		try {

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);
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
			paisElement.setAttribute("Poblazioa", String.valueOf(poblacion));
			paisElement.setAttribute("kapitala", capital);
			paisElement.setAttribute("SortzeData", fecha.format(DateTimeFormatter.ISO_DATE));

			continenteElement.appendChild(paisElement);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(xmlFile);
			transformer.transform(source, result);

			System.out.println("Herri berria ondo gehitu da ondorengo kontinentera: "
					+ continenteElement.getAttribute("izena") + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Bilatu herria kodea bidez.
	 */
	public void BilatuHerriaKodea() {
		try {

			Scanner scanner = new Scanner(System.in);
			System.out.print("Sartu herriaren kodea: ");
			String inputCodigo = scanner.nextLine();

			if (!inputCodigo.matches("\\d+")) {
				System.out.println("Kodea zenbaki bat izan behar da.");
				return;
			}

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList kontinenteakList = doc.getElementsByTagName("Kontinentea");

			for (int i = 0; i < kontinenteakList.getLength(); i++) {
				Element kontinenteaElement = (Element) kontinenteakList.item(i);
				String kontinenteIzena = kontinenteaElement.getAttribute("izena");

				NodeList herriakList = kontinenteaElement.getElementsByTagName("Herria");

				for (int j = 0; j < herriakList.getLength(); j++) {
					Element herriaElement = (Element) herriakList.item(j);
					String codigoPais = herriaElement.getAttribute("kodea");

					if (codigoPais.equals(inputCodigo)) {
						String izena = herriaElement.getAttribute("izena");
						String populazioa = herriaElement.getAttribute("populazioa");
						String kapitala = herriaElement.getAttribute("kapitala");
						String sortzeData = herriaElement.getAttribute("SortzeData");
						String biziEsperantza = herriaElement.getAttribute("BiziEsperantza");

						System.out.println("\n=========================================");
						System.out.println("Informazioa: " + izena);
						System.out.println("Kontinentea: " + kontinenteIzena);
						System.out.println("=========================================");
						System.out.printf("%-20s %-15s %-20s %-15s %-20s%n", "Izena", "Poblazioa", "Kapitala",
								"SortzeData", "Bizi Esperantza");
						System.out.println(
								"-------------------------------------------------------------------------------");
						System.out.printf("%-20s %-15s %-20s %-15s %-20s%n", izena, populazioa, kapitala, sortzeData,
								biziEsperantza);
						return;
					}
				}
			}

			System.out.println("Ez da aurkitu herri hau kodearekin: " + inputCodigo);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Bilatu herria izen bidez.
	 */
	public void BilatuHerriaIzena() {
		try {

			Scanner scanner = new Scanner(System.in);
			System.out.print("Sartu herriaren izena (parte bat): ");
			String inputIzena = scanner.nextLine().trim().toLowerCase();

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList kontinenteakList = doc.getElementsByTagName("Kontinentea");

			boolean encontrado = false;

			for (int i = 0; i < kontinenteakList.getLength(); i++) {
				Element kontinenteaElement = (Element) kontinenteakList.item(i);
				String kontinenteIzena = kontinenteaElement.getAttribute("izena");

				NodeList herriakList = kontinenteaElement.getElementsByTagName("Herria");

				for (int j = 0; j < herriakList.getLength(); j++) {
					Element herriaElement = (Element) herriakList.item(j);
					String izena = herriaElement.getAttribute("izena").toLowerCase();

					if (izena.contains(inputIzena)) {
						String codigoPais = herriaElement.getAttribute("kodea");
						String populazioa = herriaElement.getAttribute("populazioa");
						String kapitala = herriaElement.getAttribute("kapitala");
						String sortzeData = herriaElement.getAttribute("SortzeData");
						String biziEsperantza = herriaElement.getAttribute("BiziEsperantza");

						System.out.println("\n=========================================");
						System.out.println("Informazioa: " + izena);
						System.out.println("Kontinentea: " + kontinenteIzena);
						System.out.println("=========================================");
						System.out.printf("%-20s %-15s %-20s %-15s %-20s%n", "Izena", "Poblazioa", "Kapitala",
								"SortzeData", "Bizi Esperantza");
						System.out.println(
								"-------------------------------------------------------------------------------");
						System.out.printf("%-20s %-15s %-20s %-15s %-20s%n", izena, populazioa, kapitala, sortzeData,
								biziEsperantza);
						encontrado = true;
					}
				}
			}

			if (!encontrado) {
				System.out.println("Ez da aurkitu herririk izenarekin: " + inputIzena);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Bilatu eta erakutsi kontinenteko herriak.
	 */
	public void BilatuEtaErakutsiKodeBidez() {
		try {

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList kontinenteakList = doc.getElementsByTagName("Kontinentea");

			System.out.println("Kontinenteak eskuragarri daude:");
			for (int i = 0; i < kontinenteakList.getLength(); i++) {
				Element kontinenteaElement = (Element) kontinenteakList.item(i);
				System.out.println((i + 1) + ". " + kontinenteaElement.getAttribute("izena"));
			}

			Scanner scanner = new Scanner(System.in);
			System.out.print("Aukeratu kontinente bat (1-" + kontinenteakList.getLength() + "): ");
			int aukera = scanner.nextInt();
			scanner.nextLine();

			if (aukera < 1 || aukera > kontinenteakList.getLength()) {
				System.out.println("Aukera ez da baliozkoa!");
				return;
			}

			Element kontinenteaElement = (Element) kontinenteakList.item(aukera - 1);
			String kontinenteaIzena = kontinenteaElement.getAttribute("izena");

			System.out.println("\n=========================================");
			System.out.println(kontinenteaIzena.toUpperCase() + " KONTINENTEA");
			System.out.println("=========================================");

			NodeList herriakList = kontinenteaElement.getElementsByTagName("Herria");

			if (herriakList.getLength() == 0) {
				System.out.println("Ez dago herririk kontinente honetan.");
			} else {

				System.out.printf("%-10s %-20s %-15s %-20s %-15s %-20s%n", "Kodea", "Izena", "Poblazioa", "Kapitala",
						"SortzeData", "Bizi Esperantza");
				System.out.println("-------------------------------------------------------------------------------");

				for (int i = 0; i < herriakList.getLength(); i++) {
					Element herriaElement = (Element) herriakList.item(i);

					String kodea = herriaElement.getAttribute("kodea");
					String izena = herriaElement.getAttribute("izena");
					String populazioa = herriaElement.getAttribute("populazioa");
					String kapitala = herriaElement.getAttribute("kapitala");
					String sortzeData = herriaElement.getAttribute("SortzeData");
					String biziEsperantza = herriaElement.getAttribute("BiziEsperantza");

					System.out.printf("%-10s %-20s %-15s %-20s %-15s %-20s%n", kodea, izena, populazioa, kapitala,
							sortzeData, biziEsperantza);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Erakutsi erabilgarri dauden kontinenteak.
	 */
	public void ErakutsiErabilgarriKontinenteak() {
		try {

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);
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

	/**
	 * Erakutsi XML modu egokian.
	 */
	public void ErakutsiXML() {
		try {

			String desktopPath = System.getProperty("user.home") + "/Desktop/kontinenteak.xml";
			File xmlFile = new File(desktopPath);
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

	/**
	 * Lortu herriaren kontinentea.
	 *
	 * @param herria gure herria
	 * @return herriaren kontinentea
	 */
	public Kontinenteak LortuHerriarenKontinentea(Herriak herria) {
		return herria.getKontinentea();
	}

	/**
	 * Erakutsi kontinenteak.
	 *
	 * @param kontinenteaks, gure kontinenteak
	 */
	public void erakutsiKontinenteak(List<Kontinenteak> kontinenteaks) {
		for (Kontinenteak kontinentea : kontinenteaks) {
			System.out.println(kontinentea.getIzenaString());
		}
	}
}
