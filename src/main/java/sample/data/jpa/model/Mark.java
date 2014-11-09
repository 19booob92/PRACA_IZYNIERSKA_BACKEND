package sample.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mark")
public class Mark implements Serializable {

    private static final long serialVersionUID = 6429316483965915577L;

    public static final String CELUJACY = "CELUJACY";
    public static final String BARDZO_DOBRY = "BARDZO DOBRY";
    public static final String DOBRY = "DOBRY";
    public static final String DOSTATECZNY = "DOSTATECZNY";
    public static final String NIEDOPUSZCZAJACY = "NIEDOPUSZCZAJACY";

    @Id
    @GeneratedValue
    private long id;

    private int tresholdA;
    private int tresholdB;
    private int tresholdC;
    private int tresholdD;
    private int tresholdE;
    
    public int getTresholdA() {
        return tresholdA;
    }
    
    public void setTresholdA(int tresholdA) {
        this.tresholdA = tresholdA;
    }
    
    public int getTresholdB() {
        return tresholdB;
    }
    
    public void setTresholdB(int tresholdB) {
        this.tresholdB = tresholdB;
    }
    
    public int getTresholdC() {
        return tresholdC;
    }
    
    public void setTresholdC(int tresholdC) {
        this.tresholdC = tresholdC;
    }
    
    public int getTresholdD() {
        return tresholdD;
    }
    
    public void setTresholdD(int tresholdD) {
        this.tresholdD = tresholdD;
    }
    
    public int getTresholdE() {
        return tresholdE;
    }
    
    public void setTresholdE(int tresholdE) {
        this.tresholdE = tresholdE;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
