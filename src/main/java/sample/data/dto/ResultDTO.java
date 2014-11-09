package sample.data.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ResultDTO implements Serializable{

    private static final long serialVersionUID = -8550555921518285541L;

    private boolean [] isCorrect;
    
    private int points;
    
    private int maxPoints;

    private String mark;
    
    private String percent;
    
    public ResultDTO(boolean [] isCorrect, int points, int maxPoints, String mark) {
        this.isCorrect = isCorrect;
        this.points = points;
        this.maxPoints = maxPoints;
        
        BigDecimal roundedValue = new BigDecimal(100. * ((float)points / (float)maxPoints));
        roundedValue = roundedValue.setScale(4, BigDecimal.ROUND_HALF_UP);
        
        this.percent = roundedValue.toString();
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

    
    public String getPercent() {
        return percent;
    }

    
    public void setPercent(String percent) {
        this.percent = percent;
    }
}
