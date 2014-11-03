package sample.data.jpa.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "test")
public class Test implements Serializable {

    private static final long serialVersionUID = 6429316483912915569L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int semester;

    private int points;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    
    public void setSemester(int semester) {
        this.semester = semester;
    }

    
    public int getPoints() {
        return points;
    }

    
    public void setPoints(int points) {
        this.points = points;
    }

}
