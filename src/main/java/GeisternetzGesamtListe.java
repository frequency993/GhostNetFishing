import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class GeisternetzGesamtListe implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von GeisternetzGesamtListe
	private static GeisternetzGesamtListe instance = new GeisternetzGesamtListe();
	private List<Geisternetz> liste = new ArrayList<Geisternetz>();
	
	// Leerer Public Konstruktor
	public GeisternetzGesamtListe() {
	}	
	
	public void netzHinzufuegen(Geisternetz geisternetz) {
		liste.add(geisternetz);
	}
	
	public int naechsteLfdNr() {
		int LfdNr;
		LfdNr = liste.size() + 1;
		return LfdNr;
	}
	
	public void statusAendern(int lfdNr, Status status, Person verschollenMeldendePerson) {
		int index = lfdNr - 1;
		liste.get(index).setStatus(status);
	}
	
	public void bergendePersonEintragen(int lfdNr, Person bergendePerson ) {
		int index = lfdNr -1;
		liste.get(index).setBergendePerson(bergendePerson);
		liste.get(index).setStatus(Status.BEVORSTEHEND);
	}
	
	public static GeisternetzGesamtListe getInstance() {
		return instance;
	}
	
	// Gibt eine Liste von allen Netzen zurück, die der anfragenden bergenden Person zuzuordnen sind.
	public List<Geisternetz> filterListe(Person bergendePerson) {
	    List<Geisternetz> gefilterteListe = new ArrayList<>();
	    
	    for (Geisternetz netz : liste) {
	        // Filtert Geisternetze mit Status != "Verschollen" und prüft die Zuordnung zur bergenden Person
	        if (bergendePerson.equals(netz.getBergendePerson())) {
	            gefilterteListe.add(netz);
	        }
	    }
	    
	    return gefilterteListe;
	}
	
	// Gibt eine Liste von allen Netzen zurück, die nicht als verschollen oder bereits geborgen gemeldet sind.
	// Gibt eine Liste von allen Netzen zurück, die nicht als verschollen oder bereits geborgen gemeldet sind.
	public List<Geisternetz> filterListe() {
	    List<Geisternetz> gefilterteListe = new ArrayList<>();
	    
	    for (Geisternetz netz : liste) {
	        // Filtert Geisternetze mit Status != VERSCHOLLEN und != GEBORGEN
	        if (netz.getStatus() != Status.VERSCHOLLEN && netz.getStatus() != Status.GEBORGEN) {
	            gefilterteListe.add(netz);
	        }
	    }
	    
	    return gefilterteListe;
	}

	
	public List<Geisternetz> getListe() {
		return liste;
	}
}