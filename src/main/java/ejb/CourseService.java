package ejb;

import domain.CourseDateDomain;
import domain.CourseDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CourseService {
    //    void createCourse(Course course);
    void createCourse(CourseDomain courseDomain);

    List<CourseDomain> readCourses();

    void uppdateCourse(CourseDomain courseDomain);

    CourseDomain getCourseById(Long id);

    void deleteCourse(long id);

//Create CourceDates

    void createCourceDate(CourseDateDomain courseDateDomain);

    List<CourseDateDomain> readCourseDates();

//    List<Course> seeCourses();
//    Course seeAttendedCourses();


}
