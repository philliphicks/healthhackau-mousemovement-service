package au.com.healthhack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by Phil on 10/15/2016.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "snippet")
public class Snippet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false, referencedColumnName = "id")
    private Video video;
    @NotNull
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String filename;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false)
    private String directory;
    @Size(min = 1, max = 100)
    @Column(length = 100, nullable = false)
    private String status;
    @NotNull
    @Column(nullable = false)
    private Date startTime;
    @NotNull
    @Column(nullable = false)
    private Date endTime;
    @Column(name = "duration")
    private Integer duration;
    @OneToMany(mappedBy = "snippet", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Tags> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Set<Tags> getTags() {
        return tags;
    }

    public void setTags(Set<Tags> tags) {
        this.tags = tags;
    }
}
