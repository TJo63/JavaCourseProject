package ejb;

import domain.CourseDateDomain;
import domain.CourseDomain;
import jpa.Course;
import jpa.CourseDate;

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
        Course cource = new Course(courseDomain.getStringId(),courseDomain.getCourseName());
        em.persist(cource);
    }

    @Override
    public List<CourseDomain> readCourses() {
        List<Course> cL = em.createNamedQuery("getAllCourses").getResultList();
    List<CourseDomain> cDL = new ArrayList();
    for (Course c: cL){
        cDL.add( new CourseDomain(c.getId(), c.getStringId(), c.getCourseName()));
    }
        return cDL;
    }

    @Override
    public void uppdateCourse(CourseDomain cD) {
        Course c = em.find(Course.class ,cD.getId());
        c.setStringId(cD.getStringId());
        c.setCourseName(cD.getCourseName());
        em.merge(c);

    }

    @Override
    public CourseDomain getCourseById(Long id) {
        Course c =em.find(Course.class, id );
        return new CourseDomain(c.getId(), c.getStringId(), c.getCourseName());
    }

    @Override
    public void deleteCourse(long id) {
    Course c = em.find(Course.class, id);
    em.remove(c);
    }

    // Coursdate Implementation

    @Override
    public void createCourceDate(CourseDateDomain courseDateDomain) {
        CourseDate courseDate = new CourseDate(courseDateDomain.getDateName());
        em.persist(courseDate);
    }

    @Override
    public List<CourseDateDomain> readCourseDates() {
        List<CourseDate> cDateL = em.createNamedQuery("getAllCourseDates").getResultList();
        List<CourseDateDomain>cDateDL = new ArrayList();
        for (CourseDate c: cDateL)
            cDateDL.add( new CourseDateDomain(c.getId(), c.getDateName()));

        return cDateDL;
    }
}
