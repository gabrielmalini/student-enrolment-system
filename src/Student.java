import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<Enrolment> enrolments;

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.enrolments = new ArrayList<>();
    }

    public void enrolCourse(Course course) throws SESException {
        if (course.isFull()) {
            throw new SESException("Course is full.");
        }

        Enrolment enrolment = new Enrolment(this, course);
        enrolments.add(enrolment);
        course.addStudent();
    }

    public List<Enrolment> getEnrolments() {
        return enrolments;
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }
}
