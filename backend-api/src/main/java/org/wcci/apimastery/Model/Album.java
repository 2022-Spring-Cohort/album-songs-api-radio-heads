package org.wcci.apimastery.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String image;

    @ManyToOne
    private Artist artist;

    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;

    @ManyToMany
    private Collection<Comments>comments;

    public Album() {
    }

    public Album(Long id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
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
}

