import java.text.SimpleDateFormat;
import java.util.Date;

public class Ereignis {
    private String name;
    private Date datum;

    public Ereignis(String name, Date datum) {
        this.name = name;
        this.datum = datum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    public String toString() {
        return name + " am " + dateFormat.format(datum);
    }
}

