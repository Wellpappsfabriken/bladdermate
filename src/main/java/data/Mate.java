package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blobb on 03/05/2015.
 */
@XmlRootElement (name = "mate")
public class Mate {
    private String mateID;
    private List<NightOut> record;

    public Mate (String id) {
        mateID = id;
        record = new ArrayList<NightOut>();
    }

    @XmlElement
    public String getMateId() {
        return mateID;
    }

    @XmlElement
    public List<NightOut> getRecord () {
        return record;
    }

    public void addRecord (NightOut no) {
        record.add(no);
    }
}
