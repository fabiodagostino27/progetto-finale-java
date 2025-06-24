package org.final_project.java.progetto_finale_java.dto;

import org.final_project.java.progetto_finale_java.model.Videogame;

public class VideogameDetailDTO {
    private Integer id;
    private String title;
    private String description;
    private String developerStudio;
    private String publisher;
    private String imageUrl;

    public VideogameDetailDTO() {};

    public VideogameDetailDTO(Videogame videogame) {
        this.id = videogame.getId();
        this.title = videogame.getTitle();
        this.description = videogame.getDescription();
        this.developerStudio = videogame.getDeveloperStudio();
        this.publisher = videogame.getPublisher();
        this.imageUrl = videogame.getImageUrl();
    }

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
}
