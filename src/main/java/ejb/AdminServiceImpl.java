package ejb;

import domain.StudentDomain;
import jpa.Student;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful

public class AdminServiceImpl implements AdminService {
    @PersistenceContext
    EntityManager em;
    public void addStudent(StudentDomain student){
        System.out.println("The student to be added is "+ student.getFirstName()+" "+student.getLastName());
        Student s=new Student(student.getFirstName(),student.getLastName());
        em.persist(s);
    }
}
