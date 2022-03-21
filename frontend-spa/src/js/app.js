import home from "./home.js";
import header from "./header.js";
import albumView from "./albumView.js";

const containerEl = document.querySelector(".container");

function makeHomeView() {
    fetch("http://localhost:8080/albums")
    .then(res => res.json())
    .then(albums => {
        makeHomeViewFromJSON(albums);
    })
}

function makeHomeViewFromJSON(albums) {
    console.log(albums);
    containerEl.innerHTML = header();
    containerEl.innerHTML += home(albums);

    const albumsEl = containerEl.querySelectorAll(".albumArt");

    albumsEl.forEach(album => {
        let albumIdEl = album.querySelector(".id_field");
        const albumThumbnail = album.querySelector(".thumbnail");
        albumThumbnail.addEventListener("click", () => {
            albums.forEach(albumJson => {
                if (albumJson.id == albumIdEl.value) {
                makeAlbumView(albumJson);
                }
            })
        })

        const deleteButton = album.querySelector(".delete-button");
        deleteButton.addEventListener("click", () => {
            fetch("http://localhost:8080/albums/" + albumIdEl.value, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(newAlbums => {
                makeHomeViewFromJSON(newAlbums);
            })
        })
    })

    const newTitle = containerEl.querySelector(".newAlbum-title")
    const newArtist = containerEl.querySelector(".newAlbum-artist")
    const newAlbumButton = containerEl.querySelector(".newAlbum-button");
    newAlbumButton.addEventListener("click", () => {
        const newAlbumJson = {

            "title": newTitle.value,
            "image": "/AlbumCovers/orange_record - Copy.png",
            "artist": newArtist.value,
            "songs" : [],
            "comments" : []
        }

        fetch(`http://localhost:8080/albums/addAlbum`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newAlbumJson),
        })
        .then(res => res.json())
        .then(newAlbums => {
            makeHomeViewFromJSON(newAlbums);
        })
    })
}

function makeAlbumView(album) {
  // fetch("http://localhost:8080/albums/" + albumId)
  //     .then(res => res.json())
  //     .then(album => {
    console.log(album);
    containerEl.innerHTML = header();
    containerEl.innerHTML += albumView(album);

    const backButton = containerEl.querySelector(".back-navigation");
    backButton.addEventListener("click", () => {
        makeHomeView();
    })

    const songTitleInput = containerEl.querySelector(".songTitleInput");
    const songLengthInput = containerEl.querySelector(".songLengthInput");

    const addSongBtn = containerEl.querySelector(".addSongButton");
    addSongBtn.addEventListener("click", () => {
        const newSongJson = {
            title: songTitleInput.value,
            songLength: songLengthInput.value,
        }

        fetch(`http://localhost:8080/albums/${album.id}/addSong`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newSongJson),
        })
        .then((res) => res.json())
        .then((album) => {
            makeAlbumView(album);
        })
    })

    const updateButton = containerEl.querySelector(".update-button");
    updateButton.addEventListener("click", () => {
        const updateInput = containerEl.querySelector(".update-album");
        fetch("http://localhost:8080/albums/" + album.id, {
            method: 'PATCH',
            body: updateInput.value
        })
        .then(res => res.json())
        .then((newAlbums) => {
            newAlbums.forEach(newAlbum => {
                if (newAlbum.id == album.id) {
                    makeAlbumView(newAlbum);
                }
            })
            
        })
    })

    const updateSongButton = containerEl.querySelector(".updateSong-button")
    updateSongButton.addEventListener("click", () => {
        let songContainerEl = event.target.parentElement
        let songId = songContainerEl.querySelector(".song_id_field").value
        
        const updateSongInput = songContainerEl.querySelector(".update-song")
        fetch("http://localhost:8080/songs/" + songId, {
            method: 'PATCH',
            body: updateSongInput.value
        })
        .then(res => res.json())
        .then((album) => {
            makeAlbumView(album);
                
        })
        
    })

    const deleteSongButton = containerEl.querySelector(".delete-song-button");
        deleteSongButton.addEventListener("click", () => {
            let songContainerEl = event.target.parentElement
            let songId = songContainerEl.querySelector(".song_id_field").value
            fetch("http://localhost:8080/songs/" + songId, {
                method: 'DELETE'
            })
            .then(res => res.json())
            .then(album => {
                makeAlbumView(album);
            })
        })

}

makeHomeView();
