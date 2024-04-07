import javax.swing.*;
import java.awt.*;

public class KalenderView {
    private final JFrame frame;
    private final JList<Ereignis> ereignisListe;
    private final DefaultListModel<Ereignis> ereignisListModel;
    private final JButton hinzufuegenButton;
    private final JButton bearbeitenButton;
    private final JButton loeschenButton;

    public KalenderView() {
        ereignisListModel = new DefaultListModel<>();
        ereignisListe = new JList<>(ereignisListModel);

        frame = new JFrame("Kalender Anwendung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(ereignisListe), BorderLayout.CENTER);

        JPanel knopfPanel = new JPanel();
        hinzufuegenButton = new JButton("Ereignis Hinzufügen");
        bearbeitenButton = new JButton("Ereignis Bearbeiten");
        loeschenButton = new JButton("Ereignis Löschen");
        knopfPanel.add(hinzufuegenButton);
        knopfPanel.add(bearbeitenButton);
        knopfPanel.add(loeschenButton);
        frame.add(knopfPanel, BorderLayout.SOUTH);
    }

    public void zeigeFenster() {
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JList<Ereignis> getEreignisListe() {
        return ereignisListe;
    }

    public DefaultListModel<Ereignis> getEreignisListModel() {
        return ereignisListModel;
    }

    public JButton getHinzufuegenButton() {
        return hinzufuegenButton;
    }

    public JButton getBearbeitenButton() {
        return bearbeitenButton;
    }

    public JButton getLoeschenButton() {
        return loeschenButton;
    }
}
