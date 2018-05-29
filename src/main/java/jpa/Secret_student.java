package jpa;


import javax.persistence.*;

@Entity
@NamedQueries({
//        @NamedQuery(name="selectAll",query="SELECT s FROM Student s"),
})
public class Secret_student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public Secret_student(){

    }

    public Secret_student(String email,String password){

        this.email=email;
        this.password=password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getEmail() {
        System.out.println("The email from the student jpa class is :"+ email);
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
