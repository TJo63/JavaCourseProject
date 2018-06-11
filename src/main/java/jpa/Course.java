package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "getAllCourses", query = "select c from Course c")
        public class Course {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private String stringId;
            private String courseName;
//            @OneToMany
//            private List <CourseDate> courseDates;


            public Course(){}


            public Course(String stringId, String courseName) {
                this.stringId = stringId;
                this.courseName = courseName;
            }

            public Long getId() {
                return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
