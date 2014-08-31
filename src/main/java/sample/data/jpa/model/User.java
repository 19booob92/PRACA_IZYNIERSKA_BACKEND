package sample.data.jpa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 6429316483965915578L;

    @Id
    @GeneratedValue
    private long id;
    
    private int indexNo;

    private String name;

    private String surname;

    private String address;
    
    private String semester;

    private Date dateOfBirth;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
