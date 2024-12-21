import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("breitengradConverter")
public class BreitengradConverter implements Converter {

    private static final String REGEX = "^-?\\d{1,3}\\.\\d{3,}$"; // Maximal 3 Vorkommastellen

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

        // 4) Bereichsprüfung -90..90
        if (parsed < -90.0 || parsed > 90.0) {
            throw new ConverterException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                 "Wertebereich überschritten", 
                                 "Breitengrad muss zwischen -90 und 90 liegen.")
            );
        }

        return parsed;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";
        }

        // Typprüfung: Ist value ein Double?
        if (!(value instanceof Double)) {
            throw new ConverterException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                                 "Typfehler", 
                                 "Der Wert ist kein gültiges Double.")
            );
        }

        // Formatierung: genau 3 Nachkommastellen
        return String.format("%.3f", (Double) value);
    }
}
