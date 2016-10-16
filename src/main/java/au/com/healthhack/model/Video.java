package au.com.healthhack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Phil on 10/15/2016.
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "video")
public class Video implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false)
    private String filename;
    @NotNull
    @Size(min = 1, max = 255)
    @Column(length = 255, nullable = false)
    private String directory;
    @OneToMany(mappedBy = "video", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Snippet> snippets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Snippet> getSnippets() {
        return snippets;
    }

    public void setSnippets(Set<Snippet> snippets) {
        this.snippets = snippets;
    }
}