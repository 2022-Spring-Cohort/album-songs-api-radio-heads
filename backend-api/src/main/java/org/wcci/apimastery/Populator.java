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
        Album album1 = new Album("Purgatory", "/AlbumCovers/tyler_childers_-_purgatory.png", "Tyler Childers");
        albumRepo.save(album1);
        Song song1 = new Song("Feathered Indians", "3:49", "Tyler Childers", album1);
        songRepo.save(song1);
        Song song2 = new Song("Lady May", "3:03", "Tyler Childers", album1);
        songRepo.save(song2);
        Comment comment1 = new Comment("Joe", "This album slaps.", album1);
        commentRepo.save(comment1);
        

        Album album2 = new Album("A Fever You Can't Sweat Out", "/AlbumCovers/A_Fever_you_cant_sweat_out.jpg", "P!ATD");
        albumRepo.save(album2);
        Song song3 = new Song("I Write Sins Not Tragedies", "3:06", "P!ATD", album2);
        songRepo.save(song3);
        Song song4 = new Song("Build God, Then We'll Talk", "3:40", "P!ATD", album2);
        songRepo.save(song4);
        Comment comment2 = new Comment("Dylan","Those emo days", album2);
        commentRepo.save(comment2);

        
        Album album3 = new Album("A Beautiful Lie", "/AlbumCovers/a_beautiful_lie.jpg", "Thirty Seconds To Mars");
        albumRepo.save(album3);
        Song song5 = new Song("The Kill", "3:51", "Thirty Seconds To Mars", album3);
        songRepo.save(song5);
        Song song6 = new Song("From Yesterday", "4:07", "Thirty Seconds To Mars", album3);
        songRepo.save(song6);
        Comment comment3 = new Comment("Dylan","Those emo days", album3);
        commentRepo.save(comment3);


        Album album4 = new Album("Artificial Selection", "/AlbumCovers/ArtificialSelectionAlbumCover.jpg", "Dance Gavin Dance");
        albumRepo.save(album4);
        Song song7 = new Song("Story Of My Bros", "3:14", "Dance Gavin Dance", album4);
        songRepo.save(song7);
        Song song8 = new Song("Evaporate", "4:57", "Dance Gavin Dance", album4);
        songRepo.save(song8);
        Comment comment4 = new Comment("Dylan","Those emo days", album4);
        commentRepo.save(comment4);

        Album album5 = new Album("Audioslave", "/AlbumCovers/Audioslave.jpg", "Audioslave");
        albumRepo.save(album5);
        Song song9 = new Song("Like A Stone", "4:53", "Audioslave", album5);
        songRepo.save(song9);
        Song song10 = new Song("Show Me How To Live", "4:37", "Audioslave", album5);
        songRepo.save(song10);
        Comment comment5 = new Comment("Dylan","Those emo days", album5);
        commentRepo.save(comment5);

        Album album6 = new Album("Good Kid Mad city", "/AlbumCovers/good_kid_mad_city.jpg", "Kendrick Lamar");
        albumRepo.save(album6);
        Song song11 = new Song("Backseat Freestyle", "3:32", "Kendrick Lamar", album6);
        songRepo.save(song11);
        Song song12 = new Song("Money Trees", "6:26", "Kendrick Lamar, Jay Rock", album6);
        songRepo.save(song12);
        Comment comment6 = new Comment("Joe","This album slaps", album6);
        commentRepo.save(comment6);

        Album album7 = new Album("In The Aeroplane Over The Sea", "/AlbumCovers/in_the_aeroplane_over_the_sea.jpg", "Neutral Milk Hotel");
        albumRepo.save(album7);
        Song song13 = new Song("King of Carrot Flowers pt.1", "2:00", "Neutral Milk Hotel", album7);
        songRepo.save(song13);
        Song song14 = new Song("Two-headed Boy", "4:26", "Neutral Milk Hotel", album7);
        songRepo.save(song14);
        Comment comment7 = new Comment("Joe","This album slaps", album7);
        commentRepo.save(comment7);

        Album album8 = new Album("Long.Live.ASAP", "/AlbumCovers/long-live-asap.jpg", "A$AP Rocky");
        albumRepo.save(album8);
        Song song15 = new Song("Phoenix", "3:54", "A$AP Rocky", album8);
        songRepo.save(song15);
        Song song16 = new Song("One Train", "6:12", "A$AP Rocky", album8);
        songRepo.save(song16);
        Comment comment8 = new Comment("Aweys","Its a great song.", album7);
        commentRepo.save(comment8);

        Album album9 = new Album("Life Of Pablo", "/AlbumCovers/the_life_of_pablo_alternate.jpg", "Ye");
        albumRepo.save(album9);
        Song song17 = new Song("Saint Pablo", "6:13", "Ye", album9);
        songRepo.save(song17);
        Song song18 = new Song("Real Friends", "4:12", "Ye", album9);
        songRepo.save(song18);
        Comment comment9 = new Comment("Aweys","Its a great song.", album9);
        commentRepo.save(comment9);

        Album album10 = new Album("This Place Will Become Your Tomb", "/AlbumCovers/This_place_will_beome_your_tomb.jpg", "Sleep Token");
        albumRepo.save(album10);
        Song song19 = new Song("The Love You Want", "4:23", "Sleep Token", album10);
        songRepo.save(song19);
        Song song20 = new Song("Akaline", "3:34", "Sleep Token", album10);
        songRepo.save(song20);
        Comment comment10 = new Comment("Dylan","Those emo days", album5);
        commentRepo.save(comment10);












    }
}





// Album album1 = new Album("", "", "");
//         albumRepo.save(album1);


// Song song4 = new Song("", "", "", album2);
//         songRepo.save(song4);


// Comment comment1 = new Comment("", album1);
// commentRepo.save(comment1);