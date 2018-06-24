package ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.AttendanceDomain;
import domain.CourseDomain;
import domain.DateDomain;
import domain.StudentDomain;
import jpa.Attendance;
import jpa.Course;
import jpa.Student;
import jpa.Date;

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

    @Override
    public void putAllAttendance(Long courseId,Long dateId){

        List<Long> attendanceIdDel =em.createQuery("SELECT a.id from Attendance a where a.dateId=:dateId").setParameter("dateId",dateId).getResultList();
        System.out.println("The attendence Ids to delete is "+attendanceIdDel);
        for (Long ad:attendanceIdDel) {
            Attendance a=em.find(Attendance.class,ad);
            em.remove(a);
        }


        List<Long> coursestudents=em.createQuery("SELECT distinct st.id from Student st where st.courseId=:courseId").setParameter("courseId",courseId).getResultList();
        for (Long stdid:coursestudents) {
            System.out.println("The std id in the loop to create attendance domain and persist is "+stdid);

            Attendance attendance=new Attendance(dateId,stdid, (long) 1);
            System.out.println("The attendance domain created is "+attendance);
            em.persist(attendance);
        }

    }

    @Override
    public List<DateDomain> getDates(Long courseId){
        List<Date> dlist=em.createQuery("SELECT d from Date d where d.courseId=:courseId").setParameter("courseId",courseId).getResultList();
        return dlist.stream().
                map(p-> new DateDomain(p.getId(),p.getCourseId(),p.getDate())).collect(Collectors.toList());
    }

    @Override
   public  void updateAbsence(Long selectedDateId,Long studentId){
        //Attendance attendance=new Attendance(selectedDateId,studentId,(long) 0);
       // em.merge(attendance);
       // em.createQuery("UPDATE Attendance a set a.presence=0 where a.dateId=:dateId and a.studentId=:stdId")
              //  .setParameter("dateId",selectedDateId).setParameter("stdId",studentId).executeUpdate();
        System.out.println("This is updateAbsence in Teacher service IMpl the selectedDateId and studentId is "+selectedDateId+" "+studentId);
        List<Long> attendanceIdList=em.createQuery("select distinct a.id from Attendance a where a.dateId=:dateId and a.studentId=:studentId").setParameter("dateId",selectedDateId).setParameter("studentId",studentId).getResultList();
        System.out.println("The attendance list and size is  "+attendanceIdList+" "+attendanceIdList.size());
        if (attendanceIdList.size()==1){
            Long attId=attendanceIdList.get(0);
            System.out.println("The attendance ID to change is "+attId);
            Attendance attendance=em.find(Attendance.class,attId);
            System.out.println("The Attendance row to update is "+attendance);
            attendance.setPresence((long) 0);
            em.merge(attendance);
        }

    }

}
