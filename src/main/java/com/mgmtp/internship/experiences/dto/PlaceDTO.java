package com.mgmtp.internship.experiences.dto;

public class PlaceDTO {
    private long id;
    private String title;

    public PlaceDTO(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public PlaceDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PlaceDTO setTitle(String title) {
        this.title = title;
        return this;
    }
}

