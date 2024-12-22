import java.io.Serializable;

public class GPS implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von Geisternetzen
	private double breitengrad;
	private double laengengrad;

	//	Leerer Public Konstruktor
	public GPS() {
	}
	
	// Konstruktor mit breitengrad und laengengrad
	public GPS(double breitengrad, double laengengrad) {
		this.breitengrad = breitengrad;
		this.laengengrad = laengengrad;
	}

	// Getter und Setter
	public double getBreitengrad() {
		return breitengrad;
	}

	public void setBreitengrad(double breitengrad) {
		this.breitengrad = breitengrad;
	}

	public double getLaengengrad() {
		return laengengrad;
	}

	public void setLaengengrad(double laengengrad) {
		this.laengengrad = laengengrad;
	}

	
}