package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Comment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.CommentRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@RestController
public class SongController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;
    private CommentRepository commentRepo;

    public SongController(AlbumRepository albumRepo, SongRepository songRepo, CommentRepository commentRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
        this.commentRepo = commentRepo;
    }

    @GetMapping("/songs")
    public Iterable<Song> getSongs() {
        return songRepo.findAll();
    }

    @GetMapping("/songs/{id}")
    public Song getSong(@PathVariable long id) {
        return songRepo.findById(id).get();
    }

    @PatchMapping("/songs/{id}")
    public Album changeSongTitle(@PathVariable long id, @RequestBody String title) {
        Song song = songRepo.findById(id).get();
        song.updateTitle(title);
        songRepo.save(song);
        return albumRepo.findById(song.getAlbum().getId()).get();
    }

    @PostMapping("/songs/{id}/addComment")
    public Album addCommentToSong(@PathVariable long id, @RequestBody Comment comment) {
        Song song = songRepo.findById(id).get();
        comment.setSong(song);
        commentRepo.save(comment);
        return albumRepo.findById(song.getAlbum().getId()).get();
    }

//    @PostMapping("/albums/{id}/addComment")
//    public Album addCommentToAlbum(@PathVariable long id, @RequestBody Comment comment) {
//        Album album = albumRepo.findById(id).get();
//        comment.setAlbum(album);
//        commentRepo.save(comment);
//        return album;
//    }


    @DeleteMapping("/songs/{id}")
    public Album deleteSong(@PathVariable long id) {
        Song song = songRepo.findById(id).get();
        songRepo.delete(songRepo.findById(id).get());
        return albumRepo.findById(song.getAlbum().getId()).get();
    }



}
