package domain;

public class AttendanceDomain {
    private Long id;
    private Long dateId;
    private Long studentId;
    private Long presence;

    public AttendanceDomain() {
    }

    public AttendanceDomain(Long id,Long dateId,Long studentId,Long presence) {
        this.id = id;
        this.dateId=dateId;
        this.studentId=studentId;
        this.presence=presence;
    }
    public AttendanceDomain(Long dateId,Long studentId,Long presence){
        this.dateId=dateId;
        this.presence=presence;
        this.studentId=studentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseDateId() {
        return dateId;
    }

    public void setCourseDateId(Long courseDateId) {
        this.dateId = courseDateId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getPresence() {
        return presence;
    }

    public void setPresence(Long presence) {
        this.presence = presence;
    }

    public Long getDateId() {
        return dateId;
    }

    public void setDateId(Long dateId) {
        this.dateId = dateId;
    }
}
