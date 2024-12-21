import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("laengengradConverter")
public class LaengengradConverter implements Converter {

    private static final String REGEX = "^-?\\d+\\.\\d{3,}$";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // 1) Leere Eingabe abfangen
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        // 2) Regex-Prüfung: mindestens 3 Nachkommastellen
        if (!value.matches(REGEX)) {
            throw new ConverterException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                 "Ungültiges Format", 
                                 "Bitte mindestens 3 Nachkommastellen unter Verwendung von '.' angeben, z.B. 123.456!")
            );
        }

        // 3) Double parse
        double parsed;
        try {
            parsed = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new ConverterException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                 "Konvertierungsfehler", 
                                 "Ungültige Zahl: " + value)
            );
        }

        // 4) Bereichsprüfung -180..180
        if (parsed < -180.0 || parsed > 180.0) {
            throw new ConverterException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                 "Wertebereich überschritten", 
                                 "Längengrad muss zwischen -180 und 180 liegen.")
            );
        }

        return parsed;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }
        // Formatierung: genau 3 Nachkommastellen
        return String.format("%.3f", value);
    }
}
