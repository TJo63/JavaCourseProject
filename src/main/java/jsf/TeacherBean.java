package jsf;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.StudentDomain;
import ejb.TeacherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped

public class TeacherBean {
    private String email;
    private String password;

    private String selectedTeacherEmail;
    private Long courseId;
    private Long selectedCourseId;
    private Long presence;
    private  Long dateId;
    private Long studentId;

    @EJB
    TeacherService teacherService;

    public String gotoC(){
        selectedTeacherEmail = email;

        System.out.println("The email in gotoc set is "+selectedTeacherEmail);
        return  "teacherviewcourses";
    }
    public String gotoD(Long courseId){
        System.out.println("The course ID got in gotoD is "+courseId);
        selectedCourseId = courseId;

        System.out.println("The courseId in gotoD set is "+selectedCourseId);
        return  "teacherviewstudents";
    }

    public List<CourseDomain> getCurrentCourses(){
        System.out.println("This is getCurrentCourses in Teacher bean , email is "+email);
        return teacherService.viewCurrentCourses(selectedTeacherEmail);

    }

    public List<StudentDomain> getStudents(){
        System.out.println("This is getCStudents in Teacher bean , email and course ID is "+email+" "+courseId);
        return teacherService.viewStudents(selectedTeacherEmail,selectedCourseId);

    }
    public String saveAttendance(Long studentId){

        System.out.println("This is teacher bean and dateId,studentId,presence are "+dateId+" "+studentId+" "+presence);
        teacherService.saveAttendance(new AttendanceDomain(dateId,studentId,presence));
        return "teacherenterattendance";
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

    public String getSelectedTeacherEmail() {
        return selectedTeacherEmail;
    }

    public void setSelectedTeacherEmail(String selectedTeacherEmail) {
        this.selectedTeacherEmail = selectedTeacherEmail;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getSelectedCourseId() {
        return selectedCourseId;
    }

    public void setSelectedCourseId(Long selectedCourseId) {
        this.selectedCourseId = selectedCourseId;
    }

    public Long getPresence() {
        return presence;
    }

    public void setPresence(Long presence) {
        this.presence = presence;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
