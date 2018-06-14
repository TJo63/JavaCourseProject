package jsf;

import domain.CourseDateDomain;
import domain.CourseDomain;
import ejb.CourseService;
import jpa.CourseDate;

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
    private List<CourseDateDomain> courseDates;
    private Long selectedCourseId;
    @EJB
    CourseService cs;



// Lägger till en ny kurs
    public String addCourse(){
//    cs.createCourse( new Course(getStringId(),getCourseName()));
    cs.createCourse(new CourseDomain(getStringId(),getCourseName()));
    return "adminviewcourses";
}

//Hämtar lista på alla kurser och kan visas i dropdownmeny i adminvy
public List<CourseDomain> getCourses(){
    return cs.readCourses();
}

//Convert List<CourseDomain> getCourses() above to Map<Long, String> dropDown()..
public Map<String,Long> getDropDown(){
    List<CourseDomain> listDomain = getCourses();
    Map<String,Long> dropDownMap = new HashMap<>();
    for (CourseDomain cD:listDomain) {
        dropDownMap.put(cD.getStringId(),cD.getId());
    }
        return dropDownMap;

}

//Lägger till uppdaterad kurs i tabellen
public String addUppdatedCourse(){
    cs.uppdateCourse(new CourseDomain(getId(), getStringId(),getCourseName()));
    return "adminviewcourses";
}

//Hämtar alla kurser från tabell
public String getCourse(long id){
    CourseDomain cD = cs.getCourseById(id);
    setStringId(cD.getStringId());
    setId(cD.getId());
    setCourseName(cD.getCourseName());
    return "adminviewcourses";

}
//Tar bort kurs från tabellök
public String removeCourse(long id){
    cs.deleteCourse(id);
    return "adminviewcourses";
}

//CoursDates CRUD
    public String getSelectedCourse(){
        CourseDomain cD2 = cs.getCourseById(selectedCourseId);
        return cD2.getCourseName() + " " + cD2.getStringId();
    }

    public String getCourseForDates(){
        CourseDomain cD2 = cs.getCourseById(id);
        setStringId(cD2.getStringId());
        setCourseName(cD2.getCourseName());
        return "adminviewcoursedate";
    }

    public String goToSelectedCourse(Long kalle){
        this.selectedCourseId = kalle;
        return "adminviewcoursedates";
    }

    public String addCourseDate(){

       cs.createCourceDate( new CourseDateDomain());
        return "adminviewcoursedates";
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

    public List<CourseDateDomain> getCourseDates() {
        return courseDates;
    }

    public void setCourseDates(List<CourseDateDomain> courseDates) {
        this.courseDates = courseDates;
    }
    public Long getSelectedCourseId() {
        return selectedCourseId;
    }

    public void setSelectedCourseId(Long selectedCourseId) {
        this.selectedCourseId = selectedCourseId;
    }
}
