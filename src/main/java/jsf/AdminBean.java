package jsf;
import domain.CourseDomain;
import domain.StudentDomain;
import domain.TeacherDomain;
import ejb.AdminService;
import jpa.Student;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;
//import ejb.adminservice;

@ManagedBean
@SessionScoped
public class AdminBean {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private  Long selectedStudent;
    private Long courseid;

    @EJB
    AdminService adminService;

    public String addStudent(){
//        if(getId()==null)

        adminService.addStudent(new StudentDomain(getFirstName(),getLastName(),getEmail(),getCourseid()));
        System.out.println("This is in admin bean, courseid is : "+getCourseid());

        addStudentPassword();
        return "createUser";

    }

    public String saveStudent(){
        adminService.saveStudent(new StudentDomain(getId(),getFirstName(),getLastName(),getEmail(),getCourseid()));
        System.out.println("This is in admin bean,the student saved is :"+getId()+getFirstName()+getLastName()+getEmail());

        return "adminviewstudents";

    }
    public String editStudent(Long id){
        StudentDomain studentDomain= adminService.getStudent(id);
//        System.out.println("The id given is :"+ id);
        setId(studentDomain.getId());
        setFirstName(studentDomain.getFirstName());
        setLastName(studentDomain.getLastName());
        setEmail(studentDomain.getEmail());
        return "updatestudentpage";
    }

    public String deleteStudent(Long id){
        adminService.deleteStudent(id);
        System.out.println("This is admin bean to delete student with id :"+id);
        return "adminviewstudents";
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Student Selected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    public String addTeacher(){
//        if(getId()==null)

        adminService.addTeacher(new TeacherDomain(getFirstName(),getLastName(),getEmail(),getCourseid()));
        System.out.println("This is in admin bean,  teacher email is : "+getEmail());

        addTeacherPassword();
        return "createUser";

    }
    public String editTeacher(Long id){
        TeacherDomain teacherDomain= adminService.getTeacher(id);
//        System.out.println("The id given is :"+ id);
        setId(teacherDomain.getId());
        setFirstName(teacherDomain.getFirstName());
        setLastName(teacherDomain.getLastName());
        setEmail(teacherDomain.getEmail());
        return "updateteacherpage";
    }
    public String saveTeacher(){
        adminService.saveTeacher(new TeacherDomain(getId(),getFirstName(),getLastName(),getEmail(),getCourseid()));
        System.out.println("This is in admin bean,the teacher saved is :"+getId()+getFirstName()+getLastName()+getEmail());

        return "adminviewteachers";

    }
    public String deleteTeacher(Long id){
        adminService.deleteTeacher(id);
        System.out.println("This is admin bean to delete teacher with id :"+id);
        return "adminviewteachers";
    }
    public String addStudentPassword(){
        adminService.addStudentPassword(new StudentDomain(getEmail(),getPassword()));
//        System.out.println("This is in admin bean, pwd is : "+ getPassword());
        System.out.println("this is in adminbean.addstudentpassword email and  password is "+getEmail()+getPassword());
        return "createUser";
    }
    public String addTeacherPassword(){
        adminService.addTeacherPassword(new TeacherDomain(getEmail(),getPassword()));
        System.out.println("This is in admin bean, pwd is : "+ getPassword());
        return "createUser";
    }
    public List<StudentDomain> getAllStudents(){
        System.out.println("The view students from admin bean is "+ adminService.viewAllStudents());
        return adminService.viewAllStudents();
    }
    public List<TeacherDomain> getAllTeachers(){
        System.out.println(adminService.viewAllTeachers());
        return adminService.viewAllTeachers();
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Long getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Long selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
}
