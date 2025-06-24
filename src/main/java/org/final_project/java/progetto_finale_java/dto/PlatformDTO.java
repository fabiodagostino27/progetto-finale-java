package org.final_project.java.progetto_finale_java.dto;

import java.util.ArrayList;
import java.util.List;

import org.final_project.java.progetto_finale_java.model.Platform;
import org.final_project.java.progetto_finale_java.model.Videogame;

public class PlatformDTO {
    private Integer id;
    private String name;
    private String manufacturer;
    private String iconUrl;
    private List<VideogameDetailDTO> videogames = new ArrayList<>();

    public PlatformDTO() {};

    public PlatformDTO(Platform platform) {
        this.id = platform.getId();
        this.name = platform.getName();
        this.manufacturer = platform.getManufacturer();
        this.iconUrl = platform.getIconUrl();

        for (Videogame videogame : platform.getVideogames()) {
            videogames.add(new VideogameDetailDTO(videogame));
        }
    }

    public static List<PlatformDTO> fromEntityToList(List<Platform> platforms) {
        List<PlatformDTO> dtos = new ArrayList<>();

        for (Platform platform : platforms) {
            dtos.add(new PlatformDTO(platform));
        }

        return dtos;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<VideogameDetailDTO> getVideogames() {
        return this.videogames;
    }

    public void setVideogames(List<VideogameDetailDTO> videogames) {
        this.videogames = videogames;
    }

}
