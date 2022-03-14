package org.wcci.apimastery.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Comments {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String review;

    @ManyToMany (mappedBy = "comments")
    private Collection<Album> albums;

    public Comments() {
    }

    public Comments(Long id, String author, String review) {
        this.id = id;
        this.author = author;
        this.review = review;
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
}
