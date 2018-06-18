package ejb;

import domain.CourseDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface StudentService {

    List<CourseDomain> viewCurrentCourses(String email);
    void unregister(Long courseID,String email);
    List<CourseDomain> readCoursesToRegister(String email);
}
