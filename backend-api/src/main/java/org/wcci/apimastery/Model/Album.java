package org.wcci.apimastery.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String image;
    private String artist;

    private int rating;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Song> songs;

    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Comment>comments;

    public Album(String title, String image, String artist) {
        this.title = title;
        this.image = image;
        this.artist = artist;
        this.rating = 3;
    }

    public Album() {
    }

    public void updateTitle(String newTitle) {
        title = newTitle;
    }

    public void updateRating() {
        int sum = 0;
        for (Comment comment: comments) {
            sum += comment.getRating();
        }
        rating = Math.round(sum/comments.size());

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getArtist() {
        return artist;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public int getRating() {
//        updateRating();
        return rating;
    }

}

