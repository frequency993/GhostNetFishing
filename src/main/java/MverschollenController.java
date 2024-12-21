import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MverschollenController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Deklarationen
	private String vorname;
	private String nachname ;
	private String telefonnummer;
	private Geisternetz ausgewaeltesNetz;
	
	@Inject
	GeisternetzGesamtListe geisternetzGesamtListe;
	
	// Leerer Konstruktor
	public MverschollenController() {
	}
	
	public void alsVerschollenMelden() {
		Person tmpVerschollenMeldendePerson = new Person(vorname, nachname,telefonnummer);
		int tmpLfdNr = ausgewaeltesNetz.getLfdNr();
		geisternetzGesamtListe.statusAendern(tmpLfdNr, Status.VERSCHOLLEN, tmpVerschollenMeldendePerson);
	}
	
// Danach die Felder wieder leeren
	public void felderLeeren() {
		this.vorname = null;
		this.nachname = null;
		this.telefonnummer = null;
	}

// Getter und Setter
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}

	public Geisternetz getAusgewaeltesNetz() {
		return ausgewaeltesNetz;
	}

	public void setAusgewaeltesNetz(Geisternetz ausgewaeltesNetz) {
		this.ausgewaeltesNetz = ausgewaeltesNetz;
	}
}