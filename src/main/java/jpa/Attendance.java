package jpa;

import javax.persistence.*;

@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long dateId;
    private Long studentId;
    private Long presence;

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

    public Attendance(Long dateId,Long studentId,Long presence) {
        this.dateId = dateId;
        this.presence=presence;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }

    public Long getPresence() {
        return presence;
    }

    public void setPresence(Long presence) {
        this.presence = presence;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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
