package ejb;

import domain.AttendanceDomain;
import domain.CourseDomain;
import jpa.Attendance;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentService {

    List<CourseDomain> viewCurrentCourses(String email);
    void unregister(Long courseID,String email);
    List<CourseDomain> readCoursesToRegister(String email);
    void registerCourse(String email, Long courseId);
    List<AttendanceDomain> viewAttendance(String selectedStudentEmail,Long selectedCourseId);
}
