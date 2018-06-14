package ejb;

import domain.StudentDomain;
import domain.TeacherDomain;
import jpa.Student;
import jpa.Teacher;
import jpa.Secret_student;
import jpa.Secret_teacher;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateful

public class AdminServiceImpl implements AdminService {
    @PersistenceContext
    EntityManager em;
    public void addStudent(StudentDomain student){
        System.out.println("The student to be added from admin service is "+ student.getFirstName()+" "+student.getLastName()+student.getEmail());
        Student s=new Student(student.getFirstName(),student.getLastName(),student.getEmail(),student.getCourseid());
        em.persist(s);

    }
    public void saveStudent(StudentDomain student){

        System.out.println("The student to be save from admin service is "+ student.getId()+student.getFirstName()+" "+student.getLastName()+student.getEmail());
//        Student s=new Student(student.getFirstName(),student.getLastName(),student.getEmail());
        Student s= em.find(Student.class,student.getId());
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setEmail(student.getEmail());
        em.merge(s);

    }


    @Override
    public StudentDomain getStudent(Long id) {
        Student s= em.find(Student.class,id);
        return new StudentDomain(s.getId(),s.getFirstName(),s.getLastName(),s.getEmail(),s.getCourseId());
    }
    @Override
    public TeacherDomain getTeacher(Long id) {
        Teacher t= em.find(Teacher.class,id);
        return new TeacherDomain(t.getId(),t.getFirstName(),t.getLastName(),t.getEmail(),t.getCourseId());
    }


    @Override
    public void deleteStudent(Long id){
        Student s=em.find(Student.class,id);
        em.remove(s);
    }
    @Override
    public void deleteTeacher(Long id){
        Teacher t=em.find(Teacher.class,id);
        em.remove(t);
    }

    //    public String updateStudent(int selectedStudent){
//        Student s= em.find(Student.class,)
//    }
    public void addTeacher(TeacherDomain teacher){
        System.out.println("The teacher to be added from admin service is "+ teacher.getFirstName()+" "+teacher.getLastName()+teacher.getEmail());
        Teacher t=new Teacher(teacher.getFirstName(),teacher.getLastName(),teacher.getEmail(),teacher.getCourseid());
        em.persist(t);

    }
    public void saveTeacher(TeacherDomain teacher){

        System.out.println("The teacher to be save from admin service is "+ teacher.getId()+teacher.getFirstName()+" "+teacher.getLastName()+teacher.getEmail());
//        Student s=new Student(student.getFirstName(),student.getLastName(),student.getEmail());
        Teacher t= em.find(Teacher.class,teacher.getId());
        t.setFirstName(teacher.getFirstName());
        t.setLastName(teacher.getLastName());
        t.setEmail(teacher.getEmail());
        em.merge(t);

    }
    public void addStudentPassword(StudentDomain student){
        Secret_student ss=new Secret_student(student.getEmail(),student.getPassword());
        System.out.println("The pwd in admin service is : " + student.getPassword() );
        System.out.println("The email in admin service is : " + student.getEmail() );
        em.persist(ss);
    }
    public void addTeacherPassword(TeacherDomain teacher){
        Secret_teacher st=new Secret_teacher(teacher.getEmail(),teacher.getPassword());
        System.out.println("The pwd in admin service is : " + teacher.getPassword() );
        em.persist(st);
    }
    @Override
    public List<StudentDomain> viewAllStudents(){
        List<Student> students = em.createNamedQuery("selectAllStudents").getResultList();
//        List<StudentDomain> studentDomains = new ArrayList<>();
//        for (Student student : students)
//            studentDomains.add(student.);
//        return studentDomains;

        return students.stream().
                map(p->new StudentDomain(p.getId(),p.getFirstName(),p.getLastName(),p.getEmail(),p.getCourseId())).
                collect(Collectors.toList());

    }
    @Override
    public List<TeacherDomain> viewAllTeachers(){
        List<Teacher> teachers = em.createNamedQuery("selectAllTeachers").getResultList();
//        List<StudentDomain> studentDomains = new ArrayList<>();
//        for (Student student : students)
//            studentDomains.add(student.);
//        return studentDomains;
        return teachers.stream().
                map(p->new TeacherDomain(p.getId(),p.getFirstName(),p.getLastName(),p.getEmail(),p.getCourseId())).
                collect(Collectors.toList());
    }

}
