package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.Model.Comment;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.CommentRepository;

@RestController
public class CommentController {
    private AlbumRepository albumRepo;
    private CommentRepository commentRepo;

    public CommentController(AlbumRepository albumRepo, CommentRepository commentRepo) {
        this.albumRepo = albumRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/comments")
    public Iterable<Comment> getComments() {
        return commentRepo.findAll();
    }

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable long id) {
        return commentRepo.findById(id).get();
    }
}
