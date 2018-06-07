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
    List<TeacherDomain> viewAllTeachers();
    void addTeacher(TeacherDomain teacher);
    void addTeacherPassword(TeacherDomain teacher);
    void saveStudent(StudentDomain student);
    void saveTeacher(TeacherDomain teacher);
    void deleteStudent(Long id);
    void deleteTeacher(Long id);
//    void editStudent(StudentDomain student);
//    String updateStudent(int selectedStudent);
    StudentDomain getStudent(Long id);
    TeacherDomain getTeacher(Long id);
}
