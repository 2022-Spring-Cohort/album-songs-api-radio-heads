package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String review;

    @ManyToOne
    @JsonIgnore
    private Album album;

    public Comment() {
    }

    public Comment(String author, String review, Album album) {
        this.author = author;
        this.review = review;
        this.album = album;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return review;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
