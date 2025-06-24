package org.final_project.java.progetto_finale_java.dto;

import java.util.ArrayList;
import java.util.List;

import org.final_project.java.progetto_finale_java.model.Dlc;
import org.final_project.java.progetto_finale_java.model.Platform;
import org.final_project.java.progetto_finale_java.model.Videogame;

public class VideogameDTO {
    private Integer id;
    private String title;
    private String description;
    private String developerStudio;
    private String publisher;
    private String imageUrl;
    private List<PlatformDetailDTO> platforms = new ArrayList<>();
    private List<Dlc> dlcs = new ArrayList<>();

    public VideogameDTO() {};

    public VideogameDTO(Videogame videogame) {
        this.id = videogame.getId();
        this.title = videogame.getTitle();
        this.description = videogame.getDescription();
        this.developerStudio = videogame.getDeveloperStudio();
        this.publisher = videogame.getPublisher();
        this.imageUrl = videogame.getImageUrl();

        for (Platform platform : videogame.getPlatforms()) {
            this.platforms.add(new PlatformDetailDTO(platform));
        }

        for (Dlc dlc : videogame.getDlcs()) {
            this.dlcs.add(dlc);
        }
    }

    public static List<VideogameDTO> fromEntityToList(List<Videogame> videogames) {
        List<VideogameDTO> dtos = new ArrayList<>();

        for (Videogame videogame : videogames) {
            dtos.add(new VideogameDTO(videogame));
        }

        return dtos;
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

    public List<PlatformDetailDTO> getPlatforms() {
        return this.platforms;
    }

    public void setPlatforms(List<PlatformDetailDTO> platforms) {
        this.platforms = platforms;
    }

    public List<Dlc> getDlcs() {
        return this.dlcs;
    }

    public void setDlcs(List<Dlc> dlcs) {
        this.dlcs = dlcs;
    }
}
