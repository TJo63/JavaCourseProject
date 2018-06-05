package jpa;

import javax.persistence.*;

@Entity
@NamedQuery(name = "getAllCourses", query = "select c from Course c")
        public class Course {

            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private String courseId;
            private String courseName;

            public Course(){}


            public Course(String courseId, String courseName) {
                this.courseId = courseId;
                this.courseName = courseName;
            }

            public Long getId() {
                return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
