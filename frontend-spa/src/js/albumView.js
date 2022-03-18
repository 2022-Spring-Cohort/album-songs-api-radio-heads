export default function albumView(album) {
  console.log(album)
  return `
  <main class="main-content">
    <h2 class="singleAlbum-title">${album.title}</h1>
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
    <section class="newSongDiv">
      <input type="text" placeholder="Song Title" class="songTitleInput">
      <input type="text" placeholder="Song Length" class="songLengthInput">
      <button class="addSongButton">Add Song</button>
    </section>
    <a class="back-navigation">Back to Jukebox</a>
  </main>`;
}
