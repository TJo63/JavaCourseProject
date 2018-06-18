package jsf;
import domain.CourseDomain;
import domain.StudentDomain;
import ejb.StudentService;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.bootsfaces.component.ComponentsEnum.alert;

@ManagedBean
@SessionScoped

public class StudentBean {

    private String email;
    private String password;
    private Long id;

    private Long selectedStudent;
    private String selectedStudentEmail;
    private Long courseId;

    @EJB
    StudentService studentService;

    public Long getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Long selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

//// public List<CourseDomain> getCurrentCourses(Long id){

public String gotoD(){
        selectedStudent = id;

        System.out.println("The id set is "+selectedStudent);
        return  "studentviewcourses";
    }
    public String gotoC(){
        selectedStudentEmail = email;

        System.out.println("The email in gotoc set is "+selectedStudentEmail);
                return  "studentviewcourses";
    }




   public List<CourseDomain> getCurrentCourses(){
       //System.out.println(studentService.viewCurrentCourses(id));
       //System.out.println("This is in getCurrentCourses and set id is "+selectedStudent);
       System.out.println("This is getCurrentCourses in student bean , email is "+email);
         return studentService.viewCurrentCourses(selectedStudentEmail);

    }

    public Map<String,Long> getDropDown(){
        List<CourseDomain> listDomain = getCoursesToRegister();
        Map<String,Long> dropDownMap = new HashMap<>();
        for (CourseDomain cD:listDomain) {
            dropDownMap.put(cD.getStringId(),cD.getId());
        }
        return dropDownMap;

    }

    public List<CourseDomain> getCoursesToRegister(){
        System.out.println("This is student bean getcourses to register and student email is "+selectedStudentEmail);
        return studentService.readCoursesToRegister(selectedStudentEmail);
    }

    public String unregister(Long courseId){
        System.out.println("This is in studentbean unreginter course id and student email are "+courseId+" "+selectedStudentEmail);
        studentService.unregister(courseId,selectedStudentEmail);

        return "studentviewcourses";
    }



//    public String checkLogin(){
//
//        if((email==email)&&(password==password) ){
//           return "studentpage1";
//        }
//        else{
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("You are not authorized."));
//        return "studentLogin";
//    }

    public String checkLogin() {
        System.out.println("In studentbean, login check");
//        if((getEmail()==getEmail())&&(getPassword()==getPassword())){
//            System.out.println("In the if condition");
//            return "studentpage1";
//        }
//        else{
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("You are not authorized."));
//            System.out.println("In the else condition");
//            return "studentlogin";
//        }
        return "j001";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getSelectedStudentEmail() {
        return selectedStudentEmail;
    }

    public void setSelectedStudentEmail(String selectedStudentEmail) {
        this.selectedStudentEmail = selectedStudentEmail;
    }
}