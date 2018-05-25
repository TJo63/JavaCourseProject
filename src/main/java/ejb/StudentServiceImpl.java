package ejb;

import domain.StudentDomain;

import javax.ejb.Stateful;

@Stateful

public class StudentServiceImpl implements StudentService{
    public void addStudent(StudentDomain student){
        System.out.println("The student to be added is "+ student.getFirstName()+" "+student.getLastName());
    }
}
