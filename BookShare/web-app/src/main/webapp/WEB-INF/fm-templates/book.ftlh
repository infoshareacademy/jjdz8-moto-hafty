<#include "header.ftlh">
<#include "menu.ftlh">
<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">BookShare</h1>
        <p>
            Tutaj możesz zarządzać książkami przekazanymi do wypożyczenia
        </p>
    </div>
</header>
<main role="main">
    <div class="d-flex flex-row">
        <div class="p-3">
            <img class="img-fluid" src="${book.imgUrl}">
        </div>
        <div class="d-flex flex-column align-self-start">
            <div class="p-2">
                <h1 class="book_title js-book-title-scale">${book.title}
                </h1>
            </div>
            <div class="p-2">
                <h2 class="d-flex flex-column">${book.mainAuthorName}
                </h2>
            </div>
        </div>
    </div>
</main>
<#include "footer.ftlh">
