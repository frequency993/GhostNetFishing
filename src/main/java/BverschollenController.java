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
		int tmpLfdNr = ausgewaeltesNetz.getLfdNr();
		geisternetzGesamtListe.statusAendern(tmpLfdNr, Status.VERSCHOLLEN, bergendePerson);
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