package sample.data.jpa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author booob
 *
 */
@Entity
@Table(name="questions")
public class Question implements Serializable {

    private static final long serialVersionUID = 6429316483965915569L;

    @Id
    @GeneratedValue
    private long id;
    
    private String content;

    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", content=" + content + "]";
    }
   
}
