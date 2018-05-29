package jsf;
import domain.StudentDomain;
import ejb.AdminService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
//import ejb.adminservice;

@ManagedBean
@SessionScoped
public class AdminBean {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @EJB
    AdminService adminService;

    public String addStudent(){
//        if(getId()==null)

       adminService.addStudent(new StudentDomain(getFirstName(),getLastName(),getEmail()));
        System.out.println("This is in admin bean, email is : "+getEmail());

        addPassword();
        return "createUser";

    }
    public String addPassword(){
        adminService.addPassword(new StudentDomain(getEmail(),getPassword()));
        System.out.println("This is in admin bean, pwd is : "+ getPassword());
        return "createUser";
    }
    public List<StudentDomain> getAllStudents(){
        System.out.println(adminService.viewAllStudents());
        return adminService.viewAllStudents();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
