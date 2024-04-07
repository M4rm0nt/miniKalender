import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KalenderController {
    private final KalenderView view;
    private final EreignisVerwaltung verwaltung;

    public KalenderController(KalenderView view, EreignisVerwaltung verwaltung) {
        this.view = view;
        this.verwaltung = verwaltung;
        this.initController();
    }

    private void initController() {
        view.getHinzufuegenButton().addActionListener(e -> ereignisHinzufuegen());
        view.getBearbeitenButton().addActionListener(e -> ereignisBearbeiten());
        view.getLoeschenButton().addActionListener(e -> ereignisLoeschen());
    }

    private void ereignisHinzufuegen() {
        String name = JOptionPane.showInputDialog(view.getFrame(), "Ereignisname eingeben:");
        if (name != null && !name.trim().isEmpty()) {
            String datumStr = JOptionPane.showInputDialog(view.getFrame(), "Ereignisdatum eingeben (dd-MM-yyyy):");
            datumStr = datumStr.replaceAll("\\D", "-");

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            try {
                Date datum = dateFormat.parse(datumStr);
                Ereignis ereignis = new Ereignis(name, datum);
                verwaltung.hinzufuegen(ereignis);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(view.getFrame(), "Ungültiges Datumsformat. Ereignis nicht hinzugefügt.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
        aktualisiereEreignisListe();
    }

    private void ereignisBearbeiten() {
        Ereignis ausgewaehltesEreignis = view.getEreignisListe().getSelectedValue();
        if (ausgewaehltesEreignis != null) {
            String neuerName = JOptionPane.showInputDialog(view.getFrame(), "Neuen Ereignisnamen eingeben:", ausgewaehltesEreignis.getName());
            if (neuerName != null && !neuerName.trim().isEmpty()) {
                String neuesDatumStr = JOptionPane.showInputDialog(view.getFrame(), "Neues Ereignisdatum eingeben (dd-MM-yyyy):", new SimpleDateFormat("dd-MM-yyyy").format(ausgewaehltesEreignis.getDatum()));

                neuesDatumStr = neuesDatumStr.replaceAll("\\D", "-");

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);

                try {
                    Date neuesDatum = dateFormat.parse(neuesDatumStr);
                    ausgewaehltesEreignis.setName(neuerName);
                    ausgewaehltesEreignis.setDatum(neuesDatum);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view.getFrame(), "Ungültiges Datumsformat. Ereignis nicht bearbeitet.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(view.getFrame(), "Bitte ein Ereignis aus der Liste auswählen.", "Fehler", JOptionPane.WARNING_MESSAGE);
        }
        aktualisiereEreignisListe();
    }



    private void ereignisLoeschen() {
        Ereignis ausgewaehltesEreignis = view.getEreignisListe().getSelectedValue();
        if (ausgewaehltesEreignis != null) {
            verwaltung.loeschen(ausgewaehltesEreignis);
            aktualisiereEreignisListe();
        }
    }

    private void aktualisiereEreignisListe() {
        DefaultListModel<Ereignis> model = view.getEreignisListModel();
        model.clear();
        for (Ereignis ereignis : verwaltung.getEreignisListe()) {
            model.addElement(ereignis);
        }
    }
}
