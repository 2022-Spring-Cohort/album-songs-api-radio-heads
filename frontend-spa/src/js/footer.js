const albumCommentButton = containerEl.querySelector(".albumCommentButton")
    const albumCommentInput = containerEl.querySelector(".albumCommentInput")
    const albumCommentAuthor = containerEl.querySelector(".albumCommentAuthor")
    albumCommentButton.addEventListener("click", () => {
       const newCommentJson = {
        
        author: albumCommentAuthor.value,
        review: albumCommentInput.value
    }

        fetch(`http://localhost:8080/albums/${album.id}/addComment`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(newCommentJson),
        })
        .then(res => res.json())
        .then(album => {
            makeAlbumView(album)
        })

    }) 