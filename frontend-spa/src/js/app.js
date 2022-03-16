fetch("http://localhost:8080/albums")
.then(res => res.json())
.then(albums => {
    console.log(albums)
})