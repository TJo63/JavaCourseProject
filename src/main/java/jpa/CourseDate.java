package jpa;

import javax.persistence.*;
import java.util.List;


@Entity
@NamedQuery(name = "getAllCourseDates", query = "select c from CourseDate c")
public class CourseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateName;

    @ManyToOne
    Course course;

//    @OneToMany
//    List<Attendance> attendances;

    public CourseDate() {
    }

    public CourseDate(String dateName) {
        this.dateName = dateName;
    }

    public CourseDate(String dateName, Course course) {
        this.dateName = dateName;
        this.course = course;
    }

//    public CourseDate(String dateName, Course course, List<Attendance> attendances) {
//        this.dateName = dateName;
//        this.course = course;
//        this.attendances = attendances;
//    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

//    public List<Attendance> getAttendances() {
//        return attendances;
//    }
//
//    public void setAttendances(List<Attendance> attendances) {
//        this.attendances = attendances;
//    }
}
