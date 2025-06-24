package org.final_project.java.progetto_finale_java.dto;

import org.final_project.java.progetto_finale_java.model.Platform;

public class PlatformDetailDTO {
    private Integer id;
    private String name;
    private String manufacturer;
    private String iconUrl;

    public PlatformDetailDTO() {
    };

    public PlatformDetailDTO(Platform platform) {
        this.id = platform.getId();
        this.name = platform.getName();
        this.manufacturer = platform.getManufacturer();
        this.iconUrl = platform.getIconUrl();
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
}
