package jsf;

import domain.CourseDomain;
import ejb.CourseService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class CourseBean {
    private Long id;
    private String stringId;
    private String courseName;

    @EJB
    CourseService cs;

public String addCourse(){
//    cs.createCourse( new Course(getStringId(),getCourseName()));
    cs.createCourse(new CourseDomain(getStringId(),getCourseName()));
    return "adminviewcourses";
}

public List<CourseDomain> getCourses(){
    return cs.readCourses();
}
//Convert List<CourseDomain> getCourses() above to Map<Long, String> dropDown()
public Map<Long, String> dropDown(){
    List<CourseDomain> listDomain = getCourses();
    Map<Long, String> dropDownMap = new HashMap<>();
    for (CourseDomain cD:listDomain) {
        dropDownMap.put(cD.getId(), cD.getStringId());
    }
        return dropDownMap;

}

public String addUppdatedCourse(){
    cs.uppdateCourse(new CourseDomain(getId(), getStringId(),getCourseName()));
    return "adminviewcourses";
}

public String getCourse(long id){
    CourseDomain cD = cs.getCourseById(id);
    setStringId(cD.getStringId());
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

    public CourseBean(String stringId, String courseName) {
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
