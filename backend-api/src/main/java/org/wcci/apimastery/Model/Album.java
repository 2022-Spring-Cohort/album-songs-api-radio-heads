package org.wcci.apimastery.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    @ElementCollection
    private Collection<Comment>comments;

    public Album(String title, String image, String artist, Comment...comments) {
        this.title = title;
        this.image = image;
        this.artist = artist;
        this.rating = rating;
        this.comments = Arrays.asList(comments);
    }

    public Album() {
    }

    public void updateTitle(String newTitle) {
        title = newTitle;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void updateRating() {
        if (comments.size() > 0) {
            int sum = 0;
            for (Comment comment : comments) {
                sum += comment.getRating();
            }
            rating = sum / comments.size();
        }
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
        return rating;
    }

}

