package ejb;

import domain.CourseDomain;
import jpa.Course;
import jpa.Student;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateful

public class StudentServiceImpl implements StudentService {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<CourseDomain> viewCurrentCourses(String email){
       // System.out.println("This is in student service impl and selected student is "+selectedStudent);
//Student s = em.find(Student.class,selectedStudent);
        System.out.println("This is studentservice impl, the email is "+email);
        //System.out.println("The selected student is "+s);
        //List<Course> coursesX = s.getCourses();
        //System.out.println("CoursesX is "+coursesX);
        List<Course> courses= em.createQuery("select cr from Student st,Course cr where st.email=:email and cr.id=st.courseId").setParameter("email",email).getResultList();
       // List<Object[]> results = em.createQuery("select st.id,cr from Student st,Course cr where st.email='gayathri@gmail.com' and cr.id=st.courseId").getResultList();
        System.out.println("courses em createquery is "+courses);
       return courses.stream().
                map(p->new CourseDomain(p.getId(),p.getCourseName(),p.getStringId())).collect(Collectors.toList());

        //return results.stream().forEach((record)-> {
         //   Long studentId=(Long) record[0];
          //  Long courseId=(Long)record[1];
          //  String courseName=(String)record[2];


       // });
    }

    @Override
    public void unregister(Long courseId,String email){
        System.out.println("The selected studentemail to unregister is "+email);
        System.out.println("The selected course to unregister is "+courseId);
        List<Student> studentslist=em.createQuery("select st from Student st,Course cr where st.email=:email and st.courseId=cr.id and cr.id=:courseId").setParameter("email",email).setParameter("courseId",courseId).getResultList();
        System.out.println("The size of studentlist "+studentslist.size());
        if(studentslist.size()==1) {
            Student studentx=studentslist.get(0);
            em.remove(studentx);
        }
        //for (Student studentx:studentslist
        //     ) {
          //  em.remove(studentx);
        //}
    }

    @Override
    public List<CourseDomain> readCoursesToRegister(String email) {
        System.out.println("This is student service implto readcources to register the recieved email is "+email);
        List<Course> cL = em.createQuery("select cr from Course cr where cr.id not in (select st.courseId from Student st where st.email=:email)").setParameter("email",email).getResultList();
        List<CourseDomain> cDL = new ArrayList();
        for (Course c: cL){
            cDL.add( new CourseDomain(c.getId(), c.getStringId(), c.getCourseName()));
        }
        return cDL;
    }

    @Override
    public void registerCourse(String email, Long courseId){
        //List<Student> newStudentR= em.createQuery("select distinct st.email,st.firstName,st.lastName from Student st where st.email=:email",Student.class).setParameter("email",email).getResultList();
       // System.out.println("This is studentserviceimpl and the selected studen/s and size of list is  "+newStudentR+" "+newStudentR.size());
       // if ( newStudentR.size()==1){
       //     System.out.println("get(0) is "+newStudentR.get(0));
        //    Student newStudent = (Student) newStudentR.get(0);
        //    System.out.println("New student is "+newStudent);
        //    newStudent.setCourseId(courseId);
         //   em.merge(newStudent);

        List<String> fnameL= em.createQuery("SELECT distinct st.firstName from Student st where st.email=:email").setParameter("email",email).getResultList();
        String fname=fnameL.get(0);
        List<String> lnameL= em.createQuery("SELECT distinct st.lastName from Student st where st.email=:email").setParameter("email",email).getResultList();
        String lname=lnameL.get(0);
        //List<Long> idL=em.createQuery("select nextval('student_id_seq')").getResultList();
        //Long id=idL.get(0);

        Student newStudent= new Student(fname,lname,email,courseId);
        em.merge(newStudent);
    }


}
