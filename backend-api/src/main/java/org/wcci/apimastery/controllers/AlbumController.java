package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Comment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@RestController
public class AlbumController {

    private AlbumRepository albumRepo;
    private SongRepository songRepo;

    public AlbumController(AlbumRepository albumRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
    }

    @GetMapping("/albums")
    public Iterable<Album> getAlbums() {
        return albumRepo.findAll();
    }

    @PostMapping("/albums/addAlbum")
    public Iterable<Album> addAlbum(@RequestBody Album album){
        albumRepo.save(album);
        return albumRepo.findAll();
    }

    @GetMapping("/albums/{id}")
    public Album getAlbum(@PathVariable long id) {
        Album album = albumRepo.findById(id).get();
        album.updateRating();
        albumRepo.save(album);
        return album;
    }

    @PostMapping("/albums/{id}/addSong")
    public Album addSongToAlbum(@PathVariable long id, @RequestBody Song song) {
        Album album = albumRepo.findById(id).get();
        song.setAlbum(album);
        songRepo.save(song);
        return albumRepo.findById(id).get();
    }

    @PostMapping("/albums/{id}/addComment")
    public Album addCommentToAlbum(@PathVariable long id, @RequestBody Comment comment) {
        Album album = albumRepo.findById(id).get();
        album.addComment(comment);
        album.updateRating();
        albumRepo.save(album);
        return album;
    }

//    @PostMapping("/albums/{id}/addRating")
//    public Album addRatingToAlbum(@PathVariable long id, @RequestBody int rating) {
//        Album album = albumRepo.findById(id).get();
//        album.comm
//    }

    @DeleteMapping("/albums/{id}")
    public Iterable<Album> deleteAlbum(@PathVariable long id) {
        albumRepo.delete(albumRepo.findById(id).get());
        return albumRepo.findAll();
    }

    @PatchMapping("/albums/{id}")
    public Iterable<Album> changeTitle(@PathVariable long id, @RequestBody String title) {
        Album album = albumRepo.findById(id).get();
        album.updateTitle(title);
        albumRepo.save(album);
        return albumRepo.findAll();
    }

}
