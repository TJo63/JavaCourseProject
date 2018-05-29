package ejb;

import domain.StudentDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdminService {
    void addStudent(StudentDomain student);
    void addPassword(StudentDomain student);
    List<StudentDomain> viewAllStudents();
}
