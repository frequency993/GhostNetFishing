import java.io.Serializable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class MeldendePerson extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von MeldendePersonen
	private boolean istAnonym;
	
	// Leerer Public Konstruktor
	public MeldendePerson() {
	}
	
	// Konstruktor für anonym bzw. nicht anonym. Wurde die Telefonnummer frei gelassen, werden alle Werte auf "Anonym" gesetzt.
	public MeldendePerson(String vorname, String nachname, String telefonnummer, boolean istAnonym) {
	    super(vorname, nachname, telefonnummer);
	    this.istAnonym = istAnonym;
	}

    //Getter und Setter
	public boolean isIstAnonym() {
		return istAnonym;
	}

	public void setIstAnonym(boolean istAnonym) {
		this.istAnonym = istAnonym;
	}
}