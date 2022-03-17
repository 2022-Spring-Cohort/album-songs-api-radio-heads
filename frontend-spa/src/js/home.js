export default function home(albums) {
    return `
<div class="Albums">
${albums.map(album => {
    return `<div class="albumArt">
    <input type="hidden" class="id_field" value="${album.id}" >
    <h2 class="artist-name">${album.artist}</h2>
    <img src="${album.image}" class="thumbnail">
    
    </div>`
}).join("")
}    


</div>
`
}