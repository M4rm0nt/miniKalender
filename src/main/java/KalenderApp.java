import javax.swing.*;

public class KalenderApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KalenderView view = new KalenderView();
            EreignisVerwaltung verwaltung = new EreignisVerwaltung();
            new KalenderController(view, verwaltung);
            view.zeigeFenster();
        });
    }
}
