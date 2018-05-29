package jsf;

import domain.CourseDomain;
import ejb.CourseService;
import jpa.Course;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CourseBean {

    private String courseId;
    private String courseName;

    @EJB
    CourseService cs;

public String submitCourse(){
//    cs.createCourse( new Course(getCourseId(),getCourseName()));
    cs.createCourse(new CourseDomain(getCourseId(),getCourseName()));
    return "index";
}

    public CourseBean(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
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
