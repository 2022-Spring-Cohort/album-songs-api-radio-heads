export default function home(albums) {
    return `
<section class="Albums">
${albums.map(album => {
    return `<div class="albumArt">
    <input type="hidden" class="id_field" value="${album.id}" >
    <h2 class="artist-name">${album.artist}</h2>
    <img src="${album.image}" class="thumbnail">
    
    <button class="delete-button">Delete</button>
    
    </div>`
}).join("")
}    
</section>

<section class="new-album">
<input type="text" class="newAlbum-title" placeholder="Title">
<input type="text" class="newAlbum-artist" placeholder="Artist">
<button class="newAlbum-button">Create New Album</button>
`
}