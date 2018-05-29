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
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
//    private List<StudentDomain> studentArrayList=new ArrayList<>();

    public Student(){

    }

    public Student(String firstName,String lastName,String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;

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
        System.out.println("The email from the student jpa class is :"+ email);
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

}
