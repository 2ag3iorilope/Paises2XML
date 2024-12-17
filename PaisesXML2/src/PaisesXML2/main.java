package PaisesXML2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

	 public static void main(String[] args) {

	        HerrialdeakKudeatu sortuHerrialdeakKudeatu = new HerrialdeakKudeatu();
	        Scanner scanner = new Scanner(System.in);
	        int aukera = -1;
	        boolean xmlSortua = false;

	        do {
	            System.out.println("\n********** HERRIALDEAK KUDEATU MENUA **********");
	            System.out.println("1. Sortu XML fitxategia");
	            System.out.println("2. Erakutsi XML fitxategia");
	            System.out.println("3. Gehitu herrialdea kontinente batera");
	            System.out.println("4. Ikusi Kontinenteko Herrialdeak");
	            System.out.println("5. Bilatu Herrialdea Kode Bidez");
	            System.out.println("6. Bilatu Herrialdea Izen Bidez");
	            System.out.println("0. Irten");
	            System.out.print("Aukeratu aukera: ");

	          
	            try {
	                aukera = scanner.nextInt();
	                scanner.nextLine(); 

	                switch (aukera) {
	                    case 1:
	                        sortuHerrialdeakKudeatu.SortuXML();
	                        
	                        xmlSortua = true;
	                        break;

	                    case 2:
	                        if (xmlSortua) {
	                            sortuHerrialdeakKudeatu.ErakutsiXML();
	                        } else {
	                            System.out.println("Lehenengo XML fitxategia sortu behar duzu!");
	                        }
	                        break;

	                    case 3:
	                        if (xmlSortua) {
	                            sortuHerrialdeakKudeatu.addPaisToContinent();
	                            System.out.println("Herrialdea gehitu da kontinente batera.");
	                        } else {
	                            System.out.println("Lehenengo XML fitxategia sortu behar duzu!");
	                        }
	                        break;

	                    case 4:
	                        if (xmlSortua) {
	                            sortuHerrialdeakKudeatu.BilatuEtaErakutsiKodeBidez();
	                        } else {
	                            System.out.println("Lehenengo XML fitxategia sortu behar duzu!");
	                        }
	                        break;
	                    case 5:
	                        if (xmlSortua) {
	                            sortuHerrialdeakKudeatu.BilatuHerriaKodea();
	                        } else {
	                            System.out.println("Lehenengo XML fitxategia sortu behar duzu!");
	                        }
	                        break;
	                    case 6:
	                        if (xmlSortua) {
	                            sortuHerrialdeakKudeatu.BilatuHerriaIzena();
	                        } else {
	                            System.out.println("Lehenengo XML fitxategia sortu behar duzu!");
	                        }
	                        break;

	                    case 0:
	                        System.out.println("Programatik irteten...");
	                        break;

	                    default:
	                        System.out.println("Aukera okerra! Saiatu berriro.");
	                        break;
	                }
	            } catch (InputMismatchException e) {
	                System.out.println("Errorea: Mesedez, zenbaki oso bat sartu (0-4).");
	                scanner.nextLine(); 
	            }

	        } while (aukera != 0);

	        scanner.close();
	    }
	}