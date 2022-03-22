export default function albumView(album) {
  console.log(album)
  return `

  <main class="main-content">
    <section class="album-info">
      <h2>${album.title} - ${album.artist}</h2>
      <h2>Rated:${album.rating}/5</h2>
      <input type ="text" class="update-rating" placeholder="Enter rating 1-5">
      <button class="rating-button">Update Rating</button>
      <input type ="text" class="update-album" placeholder="New Album Title">
      <button class="update-button">Update Album</button>
    <section class="album-songs">
      <div class = "song-list">
        ${album.songs
          .map((song) => {
            return `<div class="songInfo">
              <input type="hidden" class="song_id_field" value="${song.id}">
              <h2 class="song-title">${song.title}</h2>
              <h3 class="song-length">${song.songLength}</h3>
              
              <div class="songComment-list">
                <h2>Song comments:</h2>
                ${song.comments
                .map((comment) => {
                  return `<div class="songComment">
                  <h3>${comment.review}</h3>
                  <h3>${comment.author}</h3>
                  </div>`
                })
                .join("")}
              </div>

              <input type ="text" class="update-song" placeholder="New Song Title">
              <button class="updateSong-button">Update Song</button>
              <button class="delete-song-button">Delete</button>

              <textarea class="songCommentInput" name="song-comment" rows="2" cols="50" placeholder="Leave comment on song:"></textarea>
              <input type="text" class="songCommentAuthor" placeholder="Author's name:">
              <button class="songCommentButton">Add Comment</button>

            </div>`;
          })
          .join("")}
      </div>
    </section>
    <section class="albumView_buttons"
      <div class="newSongDiv">
          <input type="text" placeholder="Song Title" class="songTitleInput">
          <input type="text" placeholder="Song Length" class="songLengthInput">  
          <button class="addSongButton">Add Song</button>

          <div class="albumComment-list">
          <h2>Album comments:</h2>
          ${album.comments
          .map((comment) => {
            return `<div class="albumComment">
            <h3>${comment.review}</h3>
            <h3>${comment.author}</h3>
            </div>`
          })
          .join("")}
          </div>

          <textarea class="albumCommentInput" name="album-comment" rows="2" cols="50" placeholder="Leave comment on album:"></textarea>
          <input type="text" class="albumCommentAuthor" placeholder="Author's name:">
          <button class="albumCommentButton">Add Comment</button>


      <button class ="backButton">
          <a class="back-navigation">Back to Jukebox</a>
        </button>
      </div>
    </section>
  </main>`

}