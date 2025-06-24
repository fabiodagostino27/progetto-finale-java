package org.final_project.java.progetto_finale_java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "dlcs")
public class Dlc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "The dlc's title cannot be empty, null or blank")
    private String title;

    @NotBlank(message = "The dlc's image url cannot be empty, null or blank")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "videogame_id", nullable = false)
    @JsonBackReference
    private Videogame videogame;

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

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Videogame getVideogame() {
        return this.videogame;
    }

    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }
}
