package domain;

/* please leave for now: roger
cd /Users/roger/glassfish5/bin
*  ls
*  ./asadmin
* */

public class CourseDomain {
    private Long id;
    private String courseId;
    private String courseName;

    public CourseDomain() {
    }

    public CourseDomain(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public CourseDomain(Long id, String courseId, String courseName) {
        this.id = id;
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
