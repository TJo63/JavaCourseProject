package ejb;

import domain.StudentDomain;
import domain.TeacherDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AdminService {
    void addStudent(StudentDomain student);
    void addStudentPassword(StudentDomain student);
    List<StudentDomain> viewAllStudents();
    void addTeacher(TeacherDomain teacher);
    void addTeacherPassword(TeacherDomain teacher);
    void saveStudent(StudentDomain student);
    void deleteStudent(Long id);
//    void editStudent(StudentDomain student);
//    String updateStudent(int selectedStudent);
    StudentDomain getStudent(Long id);
}
