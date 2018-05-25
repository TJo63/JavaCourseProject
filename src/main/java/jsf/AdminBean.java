package jsf;
import domain.StudentDomain;
import ejb.StudentService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import ejb.adminservice;

@ManagedBean
@SessionScoped
public class AdminBean {
    private Long id;
    private String firstName;
    private String lastName;

    @EJB
    StudentService studentService;

    public String addStudent(){
//        if(getId()==null)

        studentService.addStudent(new StudentDomain(getFirstName(),getLastName()));


        return "student";

    }

    public long getId() {
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
}
