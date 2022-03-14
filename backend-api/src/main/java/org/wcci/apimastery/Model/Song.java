package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String songLength;

    @ManyToOne
    private Album album;

    public Song() {
    }

    public Song(Long id, String title, String songLength) {
        this.id = id;
        this.title = title;
        this.songLength = songLength;
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
}
