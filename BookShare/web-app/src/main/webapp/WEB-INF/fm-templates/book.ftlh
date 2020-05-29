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
    <div class="container book">
        <div id="book-info" class="col-md-12">
            <div class="title-container relative" title="${book.title}">
                <h1 class="book_title js-book-title-scale">
                    ${book.title}
                </h1>
            </div>
        </div>
    </div>
</main>
<#include "footer.ftlh">
