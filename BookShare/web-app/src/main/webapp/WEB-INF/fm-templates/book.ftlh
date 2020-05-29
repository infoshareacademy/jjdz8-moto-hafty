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
            <img class="img-fluid" src="${book.imgUrl}" alt="bookCover">
        </div>
        <div class="d-flex flex-column ">
            <div class="p-2">
                <h1 class="book_title ">${book.title}
                </h1>
            </div>
            <div class="p-2">
                <h2 class="d-flex flex-column">${book.mainAuthorName}
                </h2>
            </div>
            <div class="p-2">
                <#list authors>
                    <#items as author>
                        <h2 class="d-flex flex-column">${author}</h2>
                    </#items>
                </#list>
            </div>
            <div class="p-2">
                <h2 class="d-flex flex-column">${book.category}
                </h2>
            </div>
            <div class="p-2">
                <h2 class="d-flex flex-column">${book.isbn}
                </h2>
            </div>
            <div class="p-2">
                <h2 class="d-flex flex-column">${book.inputDate}
                </h2>
            </div>
            <div class="p-2">
                <#if book.read><h2>Książka przeczytana</h2>
                <#else><h2>Książka nieprzeczytana</h2> </#if>
            </div>
            <div class="p-2">
                <h2 class="d-flex flex-column">${book.description}
                </h2>
            </div>
        </div>
    </div>
</main>
<#include "footer.ftlh">
