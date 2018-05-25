package ejb;

import domain.StudentDomain;

import javax.ejb.Local;

@Local
public interface StudentService {
    void addStudent(StudentDomain student);

}
