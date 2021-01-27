package eu.lengarski.nlpostcode.models.entity;

import javax.persistence.*;

@Entity(name = "logging")
public class LoggingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_postcode")
    private String startPostcode;
    @Column(name = "end_postcode")
    private String endPostCode;
    @Column(name = "status")
    private String status;
    @Column(name = "time")
    private Long time;
    @Column(name = "user")
    private String username;


    public LoggingEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartPostcode() {
        return startPostcode;
    }

    public void setStartPostcode(String startPostcode) {
        this.startPostcode = startPostcode;
    }

    public String getEndPostCode() {
        return endPostCode;
    }

    public void setEndPostCode(String endPostCode) {
        this.endPostCode = endPostCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
