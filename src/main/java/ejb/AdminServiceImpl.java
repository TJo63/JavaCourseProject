package ejb;

import domain.StudentDomain;
import jpa.Student;
import jpa.Secret_student;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful

public class AdminServiceImpl implements AdminService {
    @PersistenceContext
    EntityManager em;
    public void addStudent(StudentDomain student){
        System.out.println("The student to be added from admin service is "+ student.getFirstName()+" "+student.getLastName()+student.getEmail());
        Student s=new Student(student.getFirstName(),student.getLastName(),student.getEmail());
        em.persist(s);

    }
    public void addPassword(StudentDomain student){
        Secret_student ss=new Secret_student(student.getEmail(),student.getPassword());
        System.out.println("The pwd in admin service is : " + student.getPassword() );
        em.persist(ss);
    }
}
