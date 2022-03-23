package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Comment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@RestController
public class SongController {
    private AlbumRepository albumRepo;
    private SongRepository songRepo;


    public SongController(AlbumRepository albumRepo, SongRepository songRepo) {
        this.albumRepo = albumRepo;
        this.songRepo = songRepo;
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
        song.addComment(comment);
        songRepo.save(song);
        return albumRepo.findById(song.getAlbum().getId()).get();
    }
    
    @DeleteMapping("/songs/{id}")
    public Album deleteSong(@PathVariable long id) {
        Song song = songRepo.findById(id).get();
        songRepo.delete(songRepo.findById(id).get());
        return albumRepo.findById(song.getAlbum().getId()).get();
    }



}
