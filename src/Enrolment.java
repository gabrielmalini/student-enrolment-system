public class Enrolment {

    private Student student;
    private Course course;
    private Grade grade;

    public Enrolment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void assignGrade(double marks) throws SESException {
        this.grade = new Grade(marks);
    }

    public void displayEnrolment() {
        System.out.println("Course: " + course.getCourseName());
        if (grade != null) {
            System.out.println("Marks: " + grade.getMarks());
            System.out.println("Grade: " + grade.getLetterGrade());
        } else {
            System.out.println("Grade not assigned.");
        }
    }

    public Course getCourse() {
        return course;
    }
}
