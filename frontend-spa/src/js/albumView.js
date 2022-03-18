export default function albumView(album) {
  return `
    <main class="main-content">
        <section class="album-songs">
            
            <section class="album-songs">
                ${album.songs
                  .map((song) => {
                    return `<div class="songInfo">
                      <h2 class="song-title">${song.title}</h2>
                      <h3 class="song-length">${song.songLength}</h3>
                    </div>`;
                  })
                  .join("")}
            </section>
            <div class="newSongDiv">
                <input type="text" placeholder="Song Title" class="songTitleInput" \>
                <input type="text" placeholder="Song Length" class="songLengthInput" \>
                  
                <button class="addSongButton">Add Song</button>
            </div>
            <button class ="backButton">
              <a class="back-navigation">Back to Jukebox</a>
              </button>
        </section>
    </main>`;
}



// new-album
{/* <button class="newAlbum-button">Create New Album</button> */}