package domain;

import jpa.Attendance;
import jpa.Course;

import java.util.List;

public class CourseDateDomain {

    private Long id;
    private String dateName;
    Course course;
    List<Attendance> Attendances;

    public CourseDateDomain() {
    }

    public CourseDateDomain(Long id, String dateName) {
        this.id = id;
        this.dateName = dateName;
    }

    public CourseDateDomain(Long id, String dateName, Course course) {
        this.id = id;
        this.dateName = dateName;
        this.course = course;
    }

    public CourseDateDomain(Long id, String dateName, Course course, List<Attendance> attendances) {
        this.id = id;
        this.dateName = dateName;
        this.course = course;
        Attendances = attendances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateName() {
        return dateName;
    }

    public void setDateName(String dateName) {
        this.dateName = dateName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Attendance> getAttendances() {
        return Attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        Attendances = attendances;
    }
}
