package sample.data.dto;

import java.io.Serializable;

public class ResultDTO implements Serializable{

    private static final long serialVersionUID = -8550555921518285541L;

    private boolean [] isCorrect;
    
    private int points;
    
    private int maxPoints;

    private String mark;
    
    private int percent;
    
    public ResultDTO(boolean [] isCorrect, int points, int maxPoints, String mark) {
        this.isCorrect = isCorrect;
        this.points = points;
        this.maxPoints = maxPoints;
        this.percent = 100 * (points / maxPoints);
        this.mark = mark;
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

    
    public int getMaxPoints() {
        return maxPoints;
    }

    
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    
    public String getMark() {
        return mark;
    }

    
    public void setMark(String mark) {
        this.mark = mark;
    }

    
    public int getPercent() {
        return percent;
    }

    
    public void setPercent(int percent) {
        this.percent = percent;
    }
}
