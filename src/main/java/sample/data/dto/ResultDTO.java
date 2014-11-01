package sample.data.dto;

import java.io.Serializable;


public class ResultDTO implements Serializable{

    private static final long serialVersionUID = -8550555921518285541L;

    private boolean [] isCorrect;
    
    private int points;

    
    
    public ResultDTO(boolean [] isCorrect, int points) {
        this.isCorrect = isCorrect;
        this.points = points;
    }

    public boolean[] getIsCorrect() {
        return isCorrect;
    }


    public void setIsCorrect(boolean[] isCorrect) {
        this.isCorrect = isCorrect;
    }


    public int getPoints() {
        return points;
    }


    public void setPoints(int points) {
        this.points = points;
    }
}
