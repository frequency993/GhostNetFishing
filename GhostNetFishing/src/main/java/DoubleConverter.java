import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("DoubleConverter")
public class DoubleConverter implements Converter<Double> {

    @Override
    public Double getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        try {
            // Ersetzt Komma durch Punkt, falls notwendig
        	// Wenn beim Parsen ein Fehler auftritt, wird eine ConverterException geworfen
            value = value.replace(',', '.');
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                "Ungültiger Wert: Bitte geben Sie eine Dezimalzahl ein.", null));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Double value) {
        if (value == null) {
            return "";
        }
        // Einfach die Standard-String-Darstellung verwenden, die Punkt als Dezimaltrennzeichen nutzt
        return Double.toString(value);
    }
}
