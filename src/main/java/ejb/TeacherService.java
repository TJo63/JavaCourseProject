package ejb;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.DateDomain;
import domain.StudentDomain;

import javax.ejb.Local;
import java.util.List;

@Local

public interface TeacherService {
    List<CourseDomain> viewCurrentCourses(String email);
    List<StudentDomain> viewStudents(String email,Long courseId);
    void saveAttendance(AttendanceDomain attendanceDomain);
    void putAllAttendance(Long courseId,Long dateId);
    List<DateDomain> getDates(Long courseId);
    void updateAbsence(Long selectedDateId,Long studentId);
}
