package ejb;

import jpa.Course;

import javax.ejb.Local;
import java.util.List;
@Local
public interface CourseService {
    void createCourse();
    void removeCourse();
    void updateCourse();
    void deleteCourse();
    List<Course> seeCourses();
    void seeAttendedCourses();


}
