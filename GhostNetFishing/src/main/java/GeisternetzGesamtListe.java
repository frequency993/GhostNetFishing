import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class GeisternetzGesamtListe implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von GeisternetzGesamtListe
	private static GeisternetzGesamtListe instance = new GeisternetzGesamtListe();
	private static final GeisternetzDAO dao = new GeisternetzDAO();
	private List<Geisternetz> liste = new ArrayList<Geisternetz>();
	
	// Leerer Public Konstruktor
	public GeisternetzGesamtListe() {
	}	
	
	@PostConstruct // Nicht im Konstruktur, da die Initialisierung der Liste sonst nicht funktioniert 
	public void init() {
		liste = dao.getAlleGeisternetze();
		System.out.println("GeisternetzGesamtListe: Liste geladen");
	}
	
	public void netzHinzufuegen(Geisternetz geisternetz) {
		liste.add(geisternetz);
		dao.speichern(geisternetz);
		System.out.println("GeisternetzGesamtListe: Geisternetz ID nach Speichern: " + geisternetz.getId());
	}
	
	public Integer naechsteLfdNr() {
		Integer LfdNr;
		LfdNr = liste.size() + 1;
		return LfdNr;
	}
		
	public void verschollenEintragen(Geisternetz geisternetz, Person verschollenMeldendePerson) {
        geisternetz.setStatus(Status.VERSCHOLLEN);
        geisternetz.setVerschollenMeldendePerson(verschollenMeldendePerson);
		System.out.println("GeisternetzGesamtListe: Verschollen meldende Person: " +verschollenMeldendePerson.getVorname()+" und Status: 'Verschollen' für Geisternetz mit ID: " + geisternetz.getId());
		dao.update(geisternetz);
	}
	
	public void bergendePersonEintragen(Geisternetz geisternetz, BergendePerson bergendePerson) {
		geisternetz.setStatus(Status.BEVORSTEHEND);
		System.out.println("GeisternetzGesamtListe: Bergende Person: "+ bergendePerson.getVorname() + " mit der ID: " + bergendePerson.getId() + " für Geisternetz mit ID: " + geisternetz.getId());
		dao.updateBergendePerson(geisternetz, bergendePerson);
	}
	
	public void geborgenEintragen(Geisternetz geisternetz) {
		geisternetz.setStatus(Status.GEBORGEN);
		System.out.println("GeisternetzGesamtListe: Status 'geborgen' für Geisternetz mit ID: " + geisternetz.getId());
		dao.update(geisternetz);
	}
	
	public static GeisternetzGesamtListe getInstance() {
		return instance;
	}
	
	// Gibt eine Liste von allen Netzen zurück, die der anfragenden bergenden Person zuzuordnen sind.
	public List<Geisternetz> filterListe(Object bergendePerson) {
	    // Überprüfen, ob der Parameter vom Typ BergendePerson ist
	    if (bergendePerson instanceof BergendePerson) {
	        BergendePerson person = (BergendePerson) bergendePerson;
	        List<Geisternetz> gefilterteListe = new ArrayList<>();
	        
	        for (Geisternetz netz : liste) {
	            // Filtert Geisternetze nach der passenden bergenden Person
	            if (netz.getBergendePerson() != null && person.getId() == netz.getBergendePerson().getId()) {
	                gefilterteListe.add(netz);
	            }
	        }
	        
	        return gefilterteListe;
	    }
	    // Gibt eine leere Liste zurück, wenn der Parameter nicht vom Typ BergendePerson ist
	    return new ArrayList<>();
	}
	
	// Gibt eine Liste von allen Netzen zurück, die nicht als verschollen oder bereits geborgen gemeldet sind.
	public List<Geisternetz> getfilterListe() {
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