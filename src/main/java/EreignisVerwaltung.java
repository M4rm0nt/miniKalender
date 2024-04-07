import java.util.ArrayList;
import java.util.List;

public class EreignisVerwaltung {
    private final List<Ereignis> ereignisListe = new ArrayList<>();

    public void hinzufuegen(Ereignis ereignis) {
        ereignisListe.add(ereignis);
    }

    public void loeschen(Ereignis ereignis) {
        ereignisListe.remove(ereignis);
    }

    public List<Ereignis> getEreignisListe() {
        return new ArrayList<>(ereignisListe);
    }
}
