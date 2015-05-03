package data;

import org.joda.time.DateTime;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by blobb on 03/05/2015.
 */
@XmlRootElement
public class NightOut {
    private DateTime start;
    private List<DateTime> breaks;

    public NightOut (DateTime start) {
        this.start = start;
        breaks = new ArrayList<DateTime>();
    }

    public void addBreak (DateTime time) {
        breaks.add(time);
    }

    @XmlElement
    public DateTime getStart () {
        return start;
    }
    @XmlElement
    public List<DateTime> getBreaks() {
        return breaks;
    }
}
