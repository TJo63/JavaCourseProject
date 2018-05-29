package ejb;

import domain.CourseDomain;
import jpa.Course;

import javax.ejb.Local;
import javax.persistence.Id;
import java.util.List;
@Local
public interface CourseService {
//    void createCourse(Course course);
    void createCourse(CourseDomain courseDomain);
//    Course readCourse();
//    void updateCourse(String courseId, String courseName);
//    Course deleteCourse();
//    List<Course> seeCourses();
//    Course seeAttendedCourses();


}
