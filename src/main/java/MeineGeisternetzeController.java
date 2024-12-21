import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MeineGeisternetzeController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private BergendePerson bergendePerson;

    /**
     * Verknüpft jedes Geisternetz mit einem Boolean-Wert (true/false).
     * - Key:   Geisternetz
     * - Value: true (Checkbox angehakt), false (nicht angehakt)
     */
    private Map<Geisternetz, Boolean> selectedNetsMap = new HashMap<>();

    /**
     * Wird aufgerufen, wenn der Nutzer auf "Als geborgen melden!" klickt.
     * Setzt den Status aller angehakten Geisternetze auf "Geborgen".
     * Aktuell ist die zusätzliche Abfrage nach dem Status überflüssig ("Geborgen" hat keine Checkbox),
     * bleibt allerdings zur Sicherheit drin, falls zukünftige Änderungen diesen Fall zulassen würden.
     */
    public void alsGeborgenMelden() {
        // Durch alle Einträge in selectedNetsMap iterieren
        for (Map.Entry<Geisternetz, Boolean> entry : selectedNetsMap.entrySet()) {
            Geisternetz netz = entry.getKey();
            Boolean istAusgewaehlt = entry.getValue();

            // Nur wenn Checkbox = true und Status noch nicht "Geborgen"
            if (Boolean.TRUE.equals(istAusgewaehlt) 
                && !"Geborgen".equalsIgnoreCase(netz.getStatus())) {
                netz.setStatus("Geborgen");
            }
        }
        // Die Map leeren, um die Checkboxen zurückzusetzen
        selectedNetsMap.clear();
    }

    // Getter und Setter
    public Map<Geisternetz, Boolean> getSelectedNetsMap() {
        return selectedNetsMap;
    }

    public void setSelectedNetsMap(Map<Geisternetz, Boolean> selectedNetsMap) {
        this.selectedNetsMap = selectedNetsMap;
    }

    public BergendePerson getBergendePerson() {
        return bergendePerson;
    }

    public void setBergendePerson(BergendePerson bergendePerson) {
        this.bergendePerson = bergendePerson;
    }
}
