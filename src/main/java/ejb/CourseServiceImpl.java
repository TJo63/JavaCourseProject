package ejb;

import domain.CourseDateDomain;
import domain.CourseDomain;
import domain.DateDomain;
import jpa.Course;
import jpa.CourseDate;
import jpa.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void createCourceDate(CourseDateDomain cDD) {
        CourseDate cD = new CourseDate(cDD.getDateName());
        em.persist(cD);
    }

    @Override
    public List<CourseDateDomain> readCourseDates() {
        List<CourseDate> cDateL = em.createNamedQuery("getAllCourseDates").getResultList();
        List<CourseDateDomain>cDateDL = new ArrayList();
        for (CourseDate c: cDateL)
            cDateDL.add( new CourseDateDomain(c.getId(), c.getDateName()));

        return cDateDL;
    }

    @Override
    public void uppdateCourseDate(CourseDateDomain cDD) {
        CourseDate c = em.find(CourseDate.class ,cDD.getId());
        c.setDateName(cDD.getDateName());
        em.merge(c);
    }

    @Override
    public void addDates(DateDomain dd){
        Date d=new Date(dd.getCourseId(),dd.getDate());
        em.persist(d);
    }

    @Override
    public List<DateDomain> readDates(Long gotCourseId) {
        List<Date> dlist = em.createQuery("select d from Date d where d.courseId=:cid").setParameter("cid",gotCourseId).getResultList();

        return dlist.stream().map(p->new DateDomain(p.getId(),p.getCourseId(),p.getDate())).collect(Collectors.toList());
      //  List<CourseDateDomain>cDateDL = new ArrayList();
        //for (CourseDate c: cDateL)
          //  cDateDL.add( new CourseDateDomain(c.getId(), c.getDateName()));

     //   return cDateDL;
    }
}
