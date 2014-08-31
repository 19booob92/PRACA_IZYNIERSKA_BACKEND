package sample.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mark")
public class Mark implements Serializable {

    private static final long serialVersionUID = 6429316483965915577L;

    @Id
    @GeneratedValue
    private long id;
    
    private String value;

    @OneToOne
    private Test test;

    private User user;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
