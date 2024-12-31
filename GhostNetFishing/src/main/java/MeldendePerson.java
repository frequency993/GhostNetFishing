import java.io.Serializable;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Entity
@Named
public class MeldendePerson extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von MeldendePersonen
	private boolean istAnonym;
	
	// Leerer Public Konstruktor
	public MeldendePerson() {
	}

    //Getter und Setter
	public boolean isIstAnonym() {
		return istAnonym;
	}

	public void setIstAnonym(boolean istAnonym) {
		this.istAnonym = istAnonym;
	}
}