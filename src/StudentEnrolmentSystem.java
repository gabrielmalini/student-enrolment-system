import java.util.*;

public class StudentEnrolmentSystem implements ReportGenerator {

    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        courses.add(new Course("CS101", "OOP", 2));
        courses.add(new Course("SE102", "Software Engineering", 3));

        while (true) {
            System.out.println("\n==== STUDENT ENROLMENT SYSTEM ====");
            System.out.println("1. Register Student");
            System.out.println("2. Enrol Student in Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. View Student Report");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> registerStudent();
                    case 2 -> enrolStudent();
                    case 3 -> assignGrade();
                    case 4 -> viewReport();
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid option.");
                }
            } catch (SESException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void registerStudent() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();

        System.out.println("Enter Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Email:");
        String email = scanner.nextLine();

        students.add(new Student(id, name, email));
        System.out.println("Student Registered Successfully.");
    }

    private static Student findStudent(String id) throws SESException {
        return students.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new SESException("Student not found."));
    }

    private static Course findCourse(String code) throws SESException {
        return courses.stream()
                .filter(c -> c.getCourseCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new SESException("Course not found."));
    }

    private static void enrolStudent() throws SESException {
        System.out.println("Enter Student ID:");
        Student student = findStudent(scanner.nextLine());

        displayCourses();
        System.out.println("Enter Course Code:");
        Course course = findCourse(scanner.nextLine());

        student.enrolCourse(course);
        System.out.println("Enrolment Successful.");
    }

    private static void assignGrade() throws SESException {
        System.out.println("Enter Student ID:");
        Student student = findStudent(scanner.nextLine());

        for (Enrolment e : student.getEnrolments()) {
            System.out.println("Assign grade for " + e.getCourse().getCourseName());
            double marks = scanner.nextDouble();
            scanner.nextLine();
            e.assignGrade(marks);
        }
        System.out.println("Grades Assigned.");
    }

    private static void viewReport() throws SESException {
        System.out.println("Enter Student ID:");
        Student student = findStudent(scanner.nextLine());

        student.displayInfo();
        for (Enrolment e : student.getEnrolments()) {
            e.displayEnrolment();
            System.out.println("-------------------");
        }
    }

    private static void displayCourses() {
        for (Course c : courses) {
            c.displayCourse();
        }
    }

    @Override
    public void generateReport() {
        System.out.println("System Report Generated.");
    }
}
