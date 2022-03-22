package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Comment>comments;

    public Song() {
    }

    public Song(String title, String songLength, String artist, Album album) {
        this.title = title;
        this.songLength = songLength;
        this.artist = artist;
        this.album = album;
    }

    public void updateTitle(String newTitle) {
        title = newTitle;
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
