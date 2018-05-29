package ejb;

import domain.StudentDomain;

import javax.ejb.Local;

@Local
public interface AdminService {
    void addStudent(StudentDomain student);
    void addPassword(StudentDomain student);
}
