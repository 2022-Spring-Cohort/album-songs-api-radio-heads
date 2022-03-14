package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private  Long id;
    private String name;
    private String recordLabel;
    private String artistImage;

    @OneToMany(mappedBy = "artist")
    private Collection<Album>albums;

    public Artist() {
    }

    public Artist(Long id, String name, String recordLabel, String artistImage) {
        this.id = id;
        this.name = name;
        this.recordLabel = recordLabel;
        this.artistImage = artistImage;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public String getArtistImage() {
        return artistImage;
    }
}
