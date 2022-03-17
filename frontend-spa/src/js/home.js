export default function home(albums) {
    return `
<div class="Albums">
${albums.map(album => {
    return `<div class="albumArt">
    <input type="hidden" class="id_field" value="${album.id}" >
    <h2 class="album-title">${album.title}</h2>
    <img src="${album.image}" class="album-image">
    <h3 class="album-artist">${album.artist}</h3>
</div>`
}).join("")
}    


</div>
`
}