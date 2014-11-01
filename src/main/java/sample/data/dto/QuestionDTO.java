package sample.data.dto;

import java.io.Serializable;


public class QuestionDTO implements Serializable {

    private static final long serialVersionUID = 145687987564798L;

    private int id;
    private String tick;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTick() {
        return tick;
    }

    public void setTick(String tick) {
        this.tick = tick;
    }
}
