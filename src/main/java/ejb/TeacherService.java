package ejb;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.StudentDomain;

import javax.ejb.Local;
import java.util.List;

@Local

public interface TeacherService {
    List<CourseDomain> viewCurrentCourses(String email);
    List<StudentDomain> viewStudents(String email,Long courseId);
    void saveAttendance(AttendanceDomain attendanceDomain);
}
