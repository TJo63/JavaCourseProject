package domain;

public class TeacherDomain {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long courseid;

    public TeacherDomain(String firstName, String lastName,String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;

    }

    public TeacherDomain(String firstName,String lastName,String email,Long courseid) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.email=email;
        this.courseid=courseid;
    }

    public TeacherDomain(long id, String firstName, String lastName, String email, String password, Long courseid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.password=password;
        this.courseid=courseid;
    }

    public TeacherDomain(long id, String firstName, String lastName, String email,Long courseid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.courseid=courseid;

    }
    public TeacherDomain(String email,String password) {
        this.email = email;
        this.password=password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }
}
