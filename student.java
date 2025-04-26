

import java.util.List;
import java.util.Objects;

public class Student extends User {

    private String studentId;
    private String course;
    private int academicYear;

    private static final int MAX_BORROW_LIMIT = 5;

    public Student(String username, String password, String name, String email,
                   String studentId, String course, int academicYear) {
        super(username, password, name, email, Role.STUDENT);
        this.studentId = studentId;
        this.course = course;
        this.academicYear = academicYear;
    }

    public List<String> getDashboardOptions() {
        return List.of(
                "Borrow Books",
                "Return Books",
                "View Status",
                "Request New Books",
                "Reissue Books",
                "Notifications",
                "Logout"
        );
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public static int getMaxBorrowLimit() {
        return MAX_BORROW_LIMIT;
    }

    public String getProfileSummary() {
        return String.format("📘 %s (%s - Year %d)", getName(), course, academicYear);
    }

    @Override
    public String toString() {
        return "Student {" +
                "Name='" + getName() + '\'' +
                ", ID='" + studentId + '\'' +
                ", Course='" + course + '\'' +
                ", Year=" + academicYear +
                ", Email='" + getEmail() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return academicYear == student.academicYear &&
                Objects.equals(studentId, student.studentId) &&
                Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentId, course, academicYear);
    }
}
