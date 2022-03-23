package org.wcci.apimastery.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Embeddable
public class Comment {


    private String author;
    private String review;
    private int rating;



    public Comment() {
    }

    public Comment(String author, String review, int rating) {
        this.author = author;
        this.review = review;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getReview() {
        return review;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
