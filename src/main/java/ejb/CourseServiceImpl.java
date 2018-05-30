package ejb;

import domain.CourseDomain;
import jpa.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
@Stateless
public class CourseServiceImpl implements CourseService {
@PersistenceContext
    EntityManager em;
//    @Override
//    public void createCourse(Course course) {
//        em.persist(course);
//    }
    @Override
    public void createCourse(CourseDomain courseDomain){
        Course cource = new Course(courseDomain.getCourseId(),courseDomain.getCourseName());
        em.persist(cource);
    }

    @Override
    public List<CourseDomain> readCourses() {
        return null;
    }

    @Override
    public void uppdateCourse(CourseDomain cD) {
        Course c = em.find(Course.class ,cD.getId());
        c.setCourseId(cD.getCourseId());
        c.setCourseName(cD.getCourseName());
        em.merge(c);

    }
}
