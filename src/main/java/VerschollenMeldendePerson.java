import java.io.Serializable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class VerschollenMeldendePerson extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Aktuell keine Eigenschaften
	
	// Leerer Public Konstruktor
	public VerschollenMeldendePerson() {
	}
	
	// Konstruktor für Anonym bzw. nicht anonym
    public VerschollenMeldendePerson(String vorname, String nachname, String telefonnummer) {
    	super();
    }
}