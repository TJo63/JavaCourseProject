package jsf;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.DateDomain;
import domain.StudentDomain;
import ejb.TeacherService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private  Long selectedDateId;
    private Long dId;
    private Long date;
    private Long selectedStudentId;

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

    public String gotoE(){
        System.out.println("The dateId got is "+dateId);
        selectedDateId = dateId;
        System.out.println("The dateId set is "+selectedDateId);
        return  "teacherviewcourses";
    }

    public void gotoF(){
        System.out.println("The studentId got is "+studentId);
        selectedStudentId = studentId;
        System.out.println("The studentId set is "+selectedStudentId);

    }


    public List<CourseDomain> getCurrentCourses(){
        System.out.println("This is getCurrentCourses in Teacher bean , email is "+email);
        return teacherService.viewCurrentCourses(selectedTeacherEmail);

    }

    public List<StudentDomain> getStudents(){
        System.out.println("This is getCStudents in Teacher bean , email and course ID is "+email+" "+selectedCourseId);
        return teacherService.viewStudents(selectedTeacherEmail,selectedCourseId);

    }
    public String saveAttendance(Long studentId){

        System.out.println("This is teacher bean and dateId,studentId,presence are "+dateId+" "+studentId+" "+presence);
        teacherService.saveAttendance(new AttendanceDomain(dateId,studentId,presence));
        return "teacherenterattendance";
    }

    public String putAllAttendance(Long courseId){
       // gotoD(courseId);
        //gotoE();
        System.out.println("This is put all attendance and course Id and date id is "+courseId+" "+dateId);
        teacherService.putAllAttendance(courseId,dateId);
        return "teacherenterattendance";
    }

    public Map<String, Long> getDropDown(){
        List<DateDomain> listDomain = teacherService.getDates(selectedCourseId);
        Map<String,Long> dropDownMap = new HashMap<>();
        for (DateDomain aD:listDomain) {
            dropDownMap.put(aD.getDate(),aD.getId());
            System.out.println("This is in getDropdown the date and id from database are "+aD.getDate()+" "+aD.getId());
        }
        System.out.println("The dropdown map is "+dropDownMap);
        return dropDownMap;

    }

    public String updateAbsence(Long studentId){
        //gotoF();
        System.out.println("This is updateAbsence in TeacherBean selectedDateId and studentId are "+dateId+" "+studentId);
        teacherService.updateAbsence(dateId,studentId);
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


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSelectedDateId() {
        return selectedDateId;
    }

    public void setSelectedDateId(Long selectedDateId) {
        this.selectedDateId = selectedDateId;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getSelectedStudentId() {
        return selectedStudentId;
    }

    public void setSelectedStudentId(Long selectedStudentId) {
        this.selectedStudentId = selectedStudentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }
}
