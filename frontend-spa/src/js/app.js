import home from "./home.js";
import header from "./header.js";

fetch("http://localhost:8080/albums")
.then(res => res.json())
.then(albums => {
    console.log(albums)
    const containerEl = document.querySelector(".container");
    containerEl.innerHTML = header(albums);
    containerEl.innerHTML += home(albums);
    
    const albumsEl = containerEl.querySelectorAll(".Albums");
    
    // albumsEl.forEach(album =>{
    //     album.addEventListener("click", ()=>{
    //         let albumIdEl = album.querySelector(".id_field")
    //         alert("You clicked me: "+ albumIdEl.value);
    //     })
    // })
})