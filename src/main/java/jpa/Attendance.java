package jpa;

import javax.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean presence;

   // @ManyToOne
   // @JoinColumn(name = "CourseDateId", referencedColumnName = "ID")
   // public CourseDate courseDate;

    //@ManyToOne
    //@JoinColumn(name = "StudentId")
    //public Student student;

    public Attendance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPresence() {
        return presence;
    }

    public void setPresence(Boolean presence) {
        this.presence = presence;
    }

  //  public CourseDate getCourseDate() {
  //      return courseDate;
  //  }

   // public void setCourseDate(CourseDate courseDate) {
     //   this.courseDate = courseDate;
    //}

   // public Student getStudent() {
     //   return student;
  //  }

   // public void setStudent(Student student) {
       // this.student = student;
   // }


}
