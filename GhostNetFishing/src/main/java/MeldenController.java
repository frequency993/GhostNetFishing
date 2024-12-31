import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MeldenController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Deklarationen
	private Geisternetz geisternetz = new Geisternetz();
	private MeldendePerson meldendePerson = new MeldendePerson();
	
	@Inject
	GeisternetzGesamtListe geisternetzGesamtListe;
	
	// Leerer Konstruktor
	public MeldenController() {
	}
	
	public void hinzufuegen() {
		// Wenn keine Telefonnummer angegeben wurde, wird die Person als anonym markiert
	    if (meldendePerson.getTelefonnummer() == "") {
		        meldendePerson.setIstAnonym(true);
		} else {
			meldendePerson.setIstAnonym(false);
		}
		//Nächste laufende Nummer holen und setzen, im Anschluss Status/meldende Person setzen und Netz hinzufügen
		Integer tempLfdNr = geisternetzGesamtListe.naechsteLfdNr();
		geisternetz.setLfdNr(tempLfdNr);
		geisternetz.setStatus(Status.GEMELDET);
		geisternetz.setMeldendePerson(meldendePerson);

		geisternetzGesamtListe.netzHinzufuegen(geisternetz);
		
		//Objekte zurücksetzen und dadurch auch Felder leeren.
		geisternetz = new Geisternetz();
		meldendePerson = new MeldendePerson();
	}

	// Getter und Setter
	public Geisternetz getGeisternetz() {
		return geisternetz;
	}

	public void setGeisternetz(Geisternetz geisternetz) {
		this.geisternetz = geisternetz;
	}

	public MeldendePerson getMeldendePerson() {
		return meldendePerson;
	}

	public void setMeldendePerson(MeldendePerson meldendePerson) {
		this.meldendePerson = meldendePerson;
	}

	public GeisternetzGesamtListe getGeisternetzGesamtListe() {
		return geisternetzGesamtListe;
	}

	public void setGeisternetzGesamtListe(GeisternetzGesamtListe geisternetzGesamtListe) {
		this.geisternetzGesamtListe = geisternetzGesamtListe;
	}
	
}