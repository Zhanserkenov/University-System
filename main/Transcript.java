package main;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Vector;
import java.util.Map.Entry;

public class Transcript implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private HashMap<Course, Vector<Mark>> grades = new HashMap<Course, Vector<Mark>>();
	
	public Transcript() {
		
	}
	
	public HashMap<Course, Vector<Mark>> getGrades() {
		return grades;
	}
	
	public void addGradeForCourse(Course c, Mark m) {
		grades.get(c).add(m);
	}
	
	public double getTotalForCourse(Course c) {
		double res = 0;
		for(Mark m : grades.get(c)) {
			res += m.getScore();
		}
		return res;
	}
	
    public double getTotalScore(Student student) {
        double sum = 0;
        int totalCredits = student.getTotalCredits();

        if (totalCredits == 0) {
            System.out.println("Cannot calculate GPA. Total credits are 0.");
            return 0;
        }

        for (Entry<Course, Vector<Mark>> entry : grades.entrySet()) {
            int credit = entry.getKey().getCredit();
            double totalMark = getTotalForCourse(entry.getKey());
            sum += totalMark * credit;
        }

        return sum / totalCredits;
    }
	
	public String toString() {
		String res = "";
		for(Entry<Course, Vector<Mark>> i : grades.entrySet()) {
			res += i.getKey() + " - " + i.getValue().toString() + "\n";
		}
		return res;
	}
	
}
