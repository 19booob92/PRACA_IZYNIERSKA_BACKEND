package sample.data.dto;



public class EditQuestionDTO {
    private long id;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    
    private String courseGenere;

    private String content;

    private String correctAnswer;
    
    private int points;

    
    public long getId() {
        return id;
    }

    
    public void setId(long id) {
        this.id = id;
    }

    
    public String getAnswerA() {
        return answerA;
    }

    
    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    
    public String getAnswerB() {
        return answerB;
    }

    
    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    
    public String getAnswerC() {
        return answerC;
    }

    
    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    
    public String getAnswerD() {
        return answerD;
    }

    
    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    
    public String getCourseGenere() {
        return courseGenere;
    }

    
    public void setCourseGenere(String courseGenere) {
        this.courseGenere = courseGenere;
    }

    
    public String getContent() {
        return content;
    }

    
    public void setContent(String content) {
        this.content = content;
    }

    
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    
    public int getPoints() {
        return points;
    }

    
    public void setPoints(int points) {
        this.points = points;
    }
}
