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
}
