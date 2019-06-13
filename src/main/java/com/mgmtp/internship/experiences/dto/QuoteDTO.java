package com.mgmtp.internship.experiences.dto;

public class QuoteDTO {
    private long id;
    private String title;
    private String author;
    private String image;

    public QuoteDTO(){

    }

    public QuoteDTO(long id, String title, String author, String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public long getId() {
        return id;
    }

    public QuoteDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public QuoteDTO setTitle(String title) {
        this.title = title;
        return this;
    }
}
