export default function albumView(album) {
  console.log(album)
  return `

  <main class="main-content">
  
    <section class="album-info">
    
      <div class="songTitle">
        <h2>${album.title} - ${album.artist}</h2>
        <img src="${album.image}" class="albumViewArt">
        <h2>Rated:${album.rating}/10</h2>
        <input type ="text" class="update-album" placeholder="New Album Title">
        <button class="update-button">Update Album</button>
      </div>

      <div class="rightSide">

        <section class="album-songs">
      
          <div class = "song-list">
            ${album.songs
              .map((song) => {
                return `<div class="songInfo">
                  <input type="hidden" class="song_id_field" value="${song.id}">
                  <h2 class="song-title">${song.title}  -  ${song.songLength}</h2>
                
                  
                  <div class="songComment-list">
                    <h3>Song comments:</h3>
                    ${song.comments
                    .map((comment) => {
                      return `<div class="songComment">
                      <h3>"${comment.review}"</h3>
                      <h3>${comment.author}</h3>
                      </div>`
                    })
                    .join("")}
                  </div>

                  <div class="songFunction">
                  <input type ="text" class="update-song" placeholder="New Song Title">
                  <div class="songFunctionButtons">
                    <button class="updateSong-button">Update Song</button>
                    <button class="delete-song-button">Delete</button>
                  </div>
                  </div>

                  <div class="commentFunction">
                  <textarea class="songCommentInput" name="song-comment" rows="2" cols="50" placeholder="Leave comment on song:"></textarea>
                  <input type="text" class="songCommentAuthor" placeholder="Author's name:">
                  <button class="songCommentButton">Add Comment</button>
                  </div>

                </div>`;
              })
              .join("")}
          </div>
            
        </section>
        </div>
    
          <div class="furtherRight">
          <div class="albumComment-list">
          <h2>Album comments:</h2>
          ${album.comments
          .map((comment) => {
            return `<div class="albumComment">
            <h3>"${comment.review}"</h3>
            <h3>${comment.author}</h3>
            <h3>Rating: ${comment.rating}</h3>
            </div>`
          })
          .join("")}
          </div>

          <textarea class="albumCommentInput" name="album-comment" rows="2" cols="50" placeholder="Leave comment on album:"></textarea>
          <input type="text" class="albumCommentAuthor" placeholder="Author's name:">
          <input type ="text" class="albumCommentRating" placeholder="Enter rating 1-10">
          <button class="albumCommentButton">Add Comment</button>

          <section class="albumView_buttons"
    <div class="song_Info">
          <div class="newSongDiv">
          <input type="text" placeholder="Song Title" class="songTitleInput">
          <input type="text" placeholder="Song Length" class="songLengthInput">  
          <button class="addSongButton">Add Song</button>
          </div>
    

      <button class ="backButton">
          <a class="back-navigation">Back to Jukebox</a>
        </button>
      </div>
    </section>
    </div>
   
    
  </main>`

}