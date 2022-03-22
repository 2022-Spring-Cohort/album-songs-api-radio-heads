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
    private int rating;

    @ManyToOne
    @JsonIgnore
    private Album album;

    @ManyToOne
    @JsonIgnore
    private Song song;

    public Comment() {
    }

    public Comment(String author, String review, Album album, int rating) {
        this.author = author;
        this.review = review;
        this.album = album;
        this.rating = rating;
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

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {this.song = song;}

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
