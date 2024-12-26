import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MverschollenController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Deklarationen
	private MeldendePerson verschollenMeldendePerson = new MeldendePerson();
	private Geisternetz ausgewaeltesNetz = new Geisternetz();
	
	@Inject
	GeisternetzGesamtListe geisternetzGesamtListe;
	
	// Leerer Konstruktor
	public MverschollenController() {
	}
	
	public void alsVerschollenMelden() {
		geisternetzGesamtListe.verschollenEintragen(ausgewaeltesNetz, verschollenMeldendePerson);
		
	    verschollenMeldendePerson = new MeldendePerson();
		ausgewaeltesNetz = new Geisternetz();
	}
	
	// Getter und Setter

	public Geisternetz getAusgewaeltesNetz() {
		return ausgewaeltesNetz;
	}

	public Person getVerschollenMeldendePerson() {
		return verschollenMeldendePerson;
	}

	public void setVerschollenMeldendePerson(MeldendePerson verschollenMeldendePerson) {
		this.verschollenMeldendePerson = verschollenMeldendePerson;
	}

	public GeisternetzGesamtListe getGeisternetzGesamtListe() {
		return geisternetzGesamtListe;
	}

	public void setGeisternetzGesamtListe(GeisternetzGesamtListe geisternetzGesamtListe) {
		this.geisternetzGesamtListe = geisternetzGesamtListe;
	}

	public void setAusgewaeltesNetz(Geisternetz ausgewaeltesNetz) {
		this.ausgewaeltesNetz = ausgewaeltesNetz;
	}
}