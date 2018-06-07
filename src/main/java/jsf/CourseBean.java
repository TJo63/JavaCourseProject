package jsf;

import domain.CourseDomain;
import ejb.CourseService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class CourseBean {
    private Long id;
    private String courseId;
    private String courseName;

    @EJB
    CourseService cs;

public String addCourse(){
//    cs.createCourse( new Course(getCourseId(),getCourseName()));
    cs.createCourse(new CourseDomain(getCourseId(),getCourseName()));
    return "adminviewcourses";
}

public List<CourseDomain> getCourses(){
    return cs.readCourses();
}

public String addUppdatedCourse(){
    cs.uppdateCourse(new CourseDomain(getId(),getCourseId(),getCourseName()));
    return "adminviewcourses";
}

public String getCourse(long id){
    CourseDomain cD = cs.getCourseById(id);
    setCourseId(cD.getCourseId());
    setId(cD.getId());
    setCourseName(cD.getCourseName());
    System.out.println(getCourseName());
    return "adminviewcourses";

}

public String removeCoursew(long id){
    cs.deleteCourse(id);
    return "adminviewcourses";
}

    public CourseBean() {
    }

    public CourseBean(String courseId, String courseName) {
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
