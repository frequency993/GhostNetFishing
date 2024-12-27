import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class BverschollenController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Deklarationen
	private Geisternetz ausgewaeltesNetz;
	
	@Inject
	private GeisternetzGesamtListe geisternetzGesamtListe;
	
	@Inject
	private BergendePerson bergendePerson;
	
	// Leerer Konstruktor
	public BverschollenController() {
	}
	
	public void alsVerschollenMelden() {
		// Gibt man die ursprüngliche bergendePerson mit Id weiter, kommt JPA beim Merge durcheinander und speichert Null.
		// Deshalb wird eine neue Person erstellt und nur Vorname, Nachname und Telefonnummer übernommen.
		Person verschollenMeldendePerson = new Person(); 
		verschollenMeldendePerson.setVorname(bergendePerson.getVorname());
		verschollenMeldendePerson.setNachname(bergendePerson.getNachname());
		verschollenMeldendePerson.setTelefonnummer(bergendePerson.getTelefonnummer());
		
		geisternetzGesamtListe.verschollenEintragen(ausgewaeltesNetz, verschollenMeldendePerson);
		System.out.println("BverschollenController: Verschollen meldente Person: " + bergendePerson.getVorname() + " mit der ID: "
				+ bergendePerson.getId() + " für Geisternetz mit ID: " + ausgewaeltesNetz.getId());
		
		ausgewaeltesNetz = new Geisternetz();
	}

	// Getter und Setter
		
	public Geisternetz getAusgewaeltesNetz() {
		return ausgewaeltesNetz;
	}

	public void setAusgewaeltesNetz(Geisternetz ausgewaeltesNetz) {
		this.ausgewaeltesNetz = ausgewaeltesNetz;
	}

	public GeisternetzGesamtListe getGeisternetzGesamtListe() {
		return geisternetzGesamtListe;
	}

	public void setGeisternetzGesamtListe(GeisternetzGesamtListe geisternetzGesamtListe) {
		this.geisternetzGesamtListe = geisternetzGesamtListe;
	}

	public BergendePerson getBergendePerson() {
		return bergendePerson;
	}

	public void setBergendePerson(BergendePerson bergendePerson) {
		this.bergendePerson = bergendePerson;
	}
}