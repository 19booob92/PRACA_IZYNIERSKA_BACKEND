package sample.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="test")
public class Test implements Serializable {

    private static final long serialVersionUID = 6429316483912915569L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany
    Question question;    

    private int semester;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
