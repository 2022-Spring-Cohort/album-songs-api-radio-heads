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

        const updateButton = album.querySelector(".update-button");
        updateButton.addEventListener("click", () => {
            const updateInput = album.querySelector(".update-artist");
            fetch("http://localhost:8080/albums/" + albumIdEl.value, {
                method: 'PATCH',
                body: updateInput.value
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
}

makeHomeView();
