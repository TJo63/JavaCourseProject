package domain;

/* please leave for now: roger
cd /Users/roger/glassfish5/bin
*  ls
*  ./asadmin
* */

public class CourseDomain {
    private Long id;
    private String stringId;
    private String courseName;

    public CourseDomain() {
    }

    public CourseDomain(String stringId, String courseName) {
        this.stringId = stringId;
        this.courseName = courseName;
    }

    public CourseDomain(Long id, String stringId, String courseName) {
        this.id = id;
        this.stringId = stringId;
        this.courseName = courseName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
