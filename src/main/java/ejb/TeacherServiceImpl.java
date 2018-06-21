package ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.StudentDomain;
import jpa.Attendance;
import jpa.Course;
import jpa.Student;

import java.util.List;
import java.util.stream.Collectors;

@Stateful

public class TeacherServiceImpl implements TeacherService {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<CourseDomain> viewCurrentCourses(String email){
        System.out.println("This is Teacherservice impl, the email is "+email);
        List<Course> courses= em.createQuery("select cr from Teacher tc,Course cr where tc.email=:email and cr.id=tc.courseId").setParameter("email",email).getResultList();
        System.out.println("courses em createquery is "+courses);
        return courses.stream().
                map(p->new CourseDomain(p.getId(),p.getCourseName(),p.getStringId())).collect(Collectors.toList());
    }

    @Override
    public List<StudentDomain> viewStudents(String email, Long courseId){
        System.out.println("This is TeacherServiceImpl , email and course ID is "+email+" "+courseId);
        List<Student> students=em.createQuery("SELECT st from Teacher tc,Student st where tc.email=:email and tc.courseId=:courseId and st.courseId=tc.courseId").setParameter("email",email).setParameter("courseId",courseId).getResultList();
        return students.stream().
                map(p-> new StudentDomain(p.getId(),p.getFirstName(),p.getLastName(),p.getEmail(),p.getCourseId())).collect(Collectors.toList());
    }

    @Override
    public void saveAttendance(AttendanceDomain attendanceDomain){
        Attendance a= new Attendance(attendanceDomain.getDateId(),attendanceDomain.getStudentId(),attendanceDomain.getPresence());
        em.persist(a);
    }

}
