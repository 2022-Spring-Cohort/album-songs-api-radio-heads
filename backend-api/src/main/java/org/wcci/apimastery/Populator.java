package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.Model.Album;
import org.wcci.apimastery.Model.Comment;
import org.wcci.apimastery.Model.Song;
import org.wcci.apimastery.Repositories.AlbumRepository;
import org.wcci.apimastery.Repositories.CommentRepository;
import org.wcci.apimastery.Repositories.SongRepository;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private SongRepository songRepo;

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public void run(String... args) throws Exception {
        Album album1 = new Album("Purgatory", "https://www.childersImage.com", "Tyler Childers");
        albumRepo.save(album1);
        Song song1 = new Song("Feathered Indians", "3:49", "Tyler Childers", album1);
        songRepo.save(song1);
        Comment comment1 = new Comment("Joe", "This album slaps.", album1);
        commentRepo.save(comment1);

    }
}
