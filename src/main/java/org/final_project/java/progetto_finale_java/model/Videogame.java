package org.final_project.java.progetto_finale_java.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "videogames")
public class Videogame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The videogame's title cannot be null, empty or blank")
    private String title;

    @Lob
    private String description;

    @NotBlank(message = "The developer studio's name cannot be null, empty or blank")
    private String developerStudio;

    @NotBlank(message = "The publisher's name cannot be null, empty or blank")
    private String publisher;

    @NotBlank(message = "The image's url cannot be null, empty or blank")
    private String imageUrl;

    @ManyToMany
    @JoinTable(
        name = "platform_videogame",
        joinColumns = @JoinColumn(name = "videogame_id"),
        inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    private List<Platform> platforms;

    @OneToMany(mappedBy = "videogame")
    private List<Dlc> dlcs;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeveloperStudio() {
        return this.developerStudio;
    }

    public void setDeveloperStudio(String developerStudio) {
        this.developerStudio = developerStudio;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public List<Platform> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<Dlc> getDlcs() {
        return this.dlcs;
    }

    public void setDlcs(List<Dlc> dlcs) {
        this.dlcs = dlcs;
    }

}
