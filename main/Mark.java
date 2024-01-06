package main;

public class Mark {

    private ExamType examType;
    private double score;

    public Mark(ExamType examType, double score) {
    	this.examType = examType;
    	this.score = score;
    }

	public double getScore() {
		return score;
	}
	public String toString() {
		return "Mark [markType=" + examType + ", score=" + score + "]";
	}
    
}
