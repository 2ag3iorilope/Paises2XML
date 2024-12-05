package PaisesXML2;

import java.time.LocalDate;
import java.util.List;

public class HerrialdeakKudeatu {
	
	public static void kudeatuHerrialdeak() {
       
        Kontinenteak africa = new Kontinenteak("Africa", 30370000, 54, 1460000000);
        Kontinenteak america = new Kontinenteak("America", 42549000, 35, 1050000000);
        Kontinenteak asia = new Kontinenteak("Asia", 44579000, 49, 475000000);
        Kontinenteak europa = new Kontinenteak("Europa", 10180000, 44, 750000000);
        Kontinenteak oceania = new Kontinenteak("Oceania", 8526000, 14, 44000000);
        
        List<Kontinenteak> kontinenteaks = List.of(africa, america, asia, europa, oceania);

     
        Herriak andorra = new Herriak("376", "Andorra", 0, LocalDate.of(1993, 3, 14), 64000, "Andorra La Vieja", europa);
        Herriak argelia = new Herriak("213", "Argelia", 70, LocalDate.of(1962, 3, 3), 27959000, "Argel", africa);
        Herriak azerbayan = new Herriak("994", "Azerbayan", 70, LocalDate.of(1991, 8, 30), 7510000, "Baku", asia);
        Herriak eritre = new Herriak("291", "Eritrea", 0, LocalDate.of(1993, 5, 24), 3400000, "Asmara", africa);
        Herriak grecia = new Herriak("30", "Grecia", 78, LocalDate.of(1830, 2, 3), 10467000, "Atenas", europa);
        Herriak holanda = new Herriak("31", "Holanda", 78, LocalDate.of(1581, 7, 26), 15460000, "Amsterdam", europa);
        Herriak irak = new Herriak("964", "Irak", 66, LocalDate.of(1958, 7, 14), 20097000, "Bagdad", asia);
        Herriak madagascar = new Herriak("261", "Madagascar", 52, LocalDate.of(1960, 6, 26), 13651000, "Antananarivo", africa);
        Herriak mali = new Herriak("223", "Mali", 50, LocalDate.of(1960, 9, 22), 9788000, "Bamaco", africa);
        Herriak paraguay = new Herriak("595", "Paraguay", 68, LocalDate.of(1811, 5, 14), 4828000, "Asuncion", america);
        Herriak samoa = new Herriak("684", "Samoa Occidental", 68, LocalDate.of(1962, 1, 1), 165000, "Apia", oceania);
        Herriak turquia = new Herriak("90", "Turquia", 67, LocalDate.of(1923, 10, 29), 61058000, "Ankara", asia);
        
        System.out.println(turquia);

}
	
	public static Kontinenteak LortuHerriarenKontinentea(Herriak herria) {
        return herria.getKontinentea();
    }
	
	public static void erakutsiKontinenteak(List<Kontinenteak> kontinenteaks) {
        for (Kontinenteak kontinentea : kontinenteaks) {
            System.out.println(kontinentea.getIzenaString()); 
        }
    }
	
}

