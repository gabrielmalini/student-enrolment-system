public class Course {

    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private int enrolledStudents;

    public Course(String code, String name, int capacity) {
        this.courseCode = code;
        this.courseName = name;
        this.maxCapacity = capacity;
        this.enrolledStudents = 0;
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getEnrolledStudents() { return enrolledStudents; }

    public void addStudent() {
        enrolledStudents++;
    }

    public boolean isFull() {
        return enrolledStudents >= maxCapacity;
    }

    public void displayCourse() {
        System.out.println(courseCode + " - " + courseName +
                " (" + enrolledStudents + "/" + maxCapacity + ")");
    }
}
