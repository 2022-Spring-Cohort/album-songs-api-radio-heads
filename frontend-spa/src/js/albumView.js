export default function albumView(album) {
  console.log(album)
  return `

  <main class="main-content">
    <section class="album-info">
      <h2>${album.title} - ${album.artist}</h2>
      <input type ="text" class="update-album" placeholder="New Album Title">
      <button class="update-button">Update Album</button>
    <section class="album-songs">
      <div class = "song-list">
        ${album.songs
          .map((song) => {
            return `<div class="songInfo">
              <h2 class="song-title">${song.title}</h2>
              <h3 class="song-length">${song.songLength}</h3>
              <input type ="text" class="update-song" placeholder="New Song Title">
              <button class="updateSong-button">Update Song</button>
            </div>`;
          })
          .join("")}
      </div>
    </section>
    <section class="albumView_buttons"
      <div class="newSongDiv">
          <input type="text" placeholder="Song Title" class="songTitleInput" \>
          <input type="text" placeholder="Song Length" class="songLengthInput" \>
            
          <button class="addSongButton">Add Song</button>
      <button class ="backButton">
          <a class="back-navigation">Back to Jukebox</a>
        </button>
      </div>
    </section>
  </main>`

}