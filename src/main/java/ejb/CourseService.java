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

    List<CourseDomain> readCourses();

    void uppdateCourse(CourseDomain courseDomain);

    CourseDomain getCourseById(Long id);

//    Course deleteCourse();
//    List<Course> seeCourses();
//    Course seeAttendedCourses();


}
