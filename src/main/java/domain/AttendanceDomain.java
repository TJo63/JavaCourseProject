package domain;

public class AttendanceDomain {
    private Long id;
    private Long courseDateId;
    private Long studentId;
    private Boolean presence;

    public AttendanceDomain() {
    }

    public AttendanceDomain(Long id,Long courseDateId,Long studentId,Boolean presence) {
        this.id = id;
        this.courseDateId=courseDateId;
        this.studentId=studentId;
        this.presence=presence;
    }
    public AttendanceDomain(Long id,Boolean presence){
        this.id=id;
        this.presence=presence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseDateId() {
        return courseDateId;
    }

    public void setCourseDateId(Long courseDateId) {
        this.courseDateId = courseDateId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Boolean getPresence() {
        return presence;
    }

    public void setPresence(Boolean presence) {
        this.presence = presence;
    }
}
