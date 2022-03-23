package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String songLength;
    private String artist;

    @ManyToOne
    @JsonIgnore
    private Album album;

    @ElementCollection
    private Collection<Comment>comments;

    public Song() {
    }

    public Song(String title, String songLength, String artist, Album album, Comment...comments) {
        this.title = title;
        this.songLength = songLength;
        this.artist = artist;
        this.album = album;
        this.comments = Arrays.asList(comments);
    }

    public void updateTitle(String newTitle) {
        title = newTitle;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSongLength() {
        return songLength;
    }

    public String getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Collection<Comment> getComments() {
        return comments;
    }
}
