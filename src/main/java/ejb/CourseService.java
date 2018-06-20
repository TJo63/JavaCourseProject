package ejb;

import domain.CourseDateDomain;
import domain.CourseDomain;
import domain.DateDomain;

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

    void uppdateCourseDate(CourseDateDomain courseDateDomain);

    void addDates(DateDomain dd);

//    List<Course> seeCourses();
//    Course seeAttendedCourses();

    List<DateDomain> readDates(Long gotCourseId);


}
