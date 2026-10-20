public class Grade {

    private double marks;
    private String letterGrade;

    public Grade(double marks) throws SESException {
        if (marks < 0 || marks > 100) {
            throw new SESException("Invalid marks entered.");
        }
        this.marks = marks;
        this.letterGrade = calculateGrade(marks);
    }

    private String calculateGrade(double marks) {
        if (marks >= 70) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        if (marks >= 40) return "D";
        return "F";
    }

    public double getMarks() { return marks; }
    public String getLetterGrade() { return letterGrade; }
}
