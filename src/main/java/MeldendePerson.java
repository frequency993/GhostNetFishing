import java.io.Serializable;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.*;

@Entity
@Named
@ApplicationScoped
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