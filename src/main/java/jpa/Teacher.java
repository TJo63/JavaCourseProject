package jpa;


import domain.TeacherDomain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//

@Entity
@NamedQueries({
        @NamedQuery(name="selectAllTeachers",query="SELECT t FROM Teacher t"),
//        @NamedQuery(name="selectSome",query="SELECT t FROM Person t WHERE LOCATE(:filt,t.firstName) >0 ")
})
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private Long courseId;
//    private List<TeacherDomain> TeacherArrayList=new ArrayList<>();

    public Teacher(){

    }

    public Teacher(String firstName,String lastName,String email,Long courseId){
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
        System.out.println("The email from the Teacher jpa class is :"+ email);
        return email;

    }

    public void setEmail(String email) {
        this.email = email;
    }
//    public List<TeacherDomain> getTeachers() {
//        return new ArrayList(Teacher.values());
//    }
//    public List<TeacherDomain> viewAllTeachers(){
//        for (Object o:Teacher) {
//            TeacherArrayList.add(o);
//        }
//        return TeacherArrayList;
//    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
