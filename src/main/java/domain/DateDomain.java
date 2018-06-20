package domain;

public class DateDomain {
    private Long id;
    private Long courseId;
    private String date;

    public DateDomain(Long courseId,String date ) {
        //this.id = id;
        this.courseId=courseId;
        this.date=date;

    }
    public DateDomain(Long id,Long courseId,String date ) {
        this.id = id;
        this.courseId=courseId;
        this.date=date;

    }

    public DateDomain() {
    }



    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
