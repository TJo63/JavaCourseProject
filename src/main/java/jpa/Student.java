package jpa;


import domain.StudentDomain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//

@Entity
@NamedQueries({
        @NamedQuery(name="selectAllStudents",query="SELECT s FROM Student s"),
//        @NamedQuery(name="selectSome",query="SELECT t FROM Person t WHERE LOCATE(:filt,t.firstName) >0 ")
//        @NamedQuery(name = "saveStudent",query = "Update Student set firstname="")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;
//    private List<StudentDomain> studentArrayList=new ArrayList<>();


    @ManyToMany(fetch= FetchType.EAGER,cascade = CascadeType.REMOVE)
   // @JoinTable(
       //     name="STUD_COURSE",
      //      joinColumns=@JoinColumn(name="STUD_ID", referencedColumnName="courseId"),
       //     inverseJoinColumns=@JoinColumn(name="COURSE_ID", referencedColumnName="id"))
    private List<Course> courses;

    public Student(){

    }

    //public Student(String firstName,String lastName,String email){
       // this.firstName=firstName;
        //this.lastName=lastName;
       // this.email=email;

    //}

    public Student(String firstName,String lastName,String email,Long courseId){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.courseId=courseId;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
//        System.out.println("The email from the student jpa class is :"+ email);
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }
//    public List<StudentDomain> getStudents() {
//        return new ArrayList(Student.values());
//    }
//    public List<StudentDomain> viewAllStudents(){
//        for (Object o:Student) {
//            studentArrayList.add(o);
//        }
//        return studentArrayList;
//    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
