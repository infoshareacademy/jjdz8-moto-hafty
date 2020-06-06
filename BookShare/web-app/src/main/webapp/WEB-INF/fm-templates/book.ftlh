<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="d-flex flex-row">
        <div class="p-3">
            <img class="book-cover" src="${book.imgUrl}" alt="bookCover" height="256" width="160">
        </div>
        <div class="d-flex flex-column">
            <div class="p-1">
                <h2 class="book_title">${book.title}
                </h2>
            </div>
            <div class="p-1">
                <h3 class="d-flex flex-column">${book.mainAuthorName}
                </h3>
            </div>
            <div class="p-1">
                <#list authors>
                    <#items as author>
                        <#if author == book.mainAuthorName>
                        <#else><h4 class="d-flex flex-column">${author}</h4>
                        </#if>
                    </#items>
                </#list>
            </div>
            <div class="p-1">
                <h4 class="d-flex flex-column">${book.category}
                </h4>
            </div>
            <div class="p-1">
                <h4 class="d-flex flex-column">${book.isbn}
                </h4>
            </div>
            <div class="p-1">
                <h4 class="d-flex flex-column">${book.inputDate}
                </h4>
            </div>
            <div class="p-1">
                <h4 class="d-flex flex-column">
                    <button class ="addToShelfButton" type="submit" value="${bookId}">Dodaj do wypożyczalni</button>
                </h4>
            </div>
            <div class="p-1">
                <#if book.read><h4>Książka przeczytana</h4>
                <#else><h4>Książka nieprzeczytana</h4> </#if>
            </div>
            <div class="p-1">
                <h4 class="d-flex flex-column">${book.description}
                </h4>
            </div>
        </div>
    </div>
</main>
<#include "footer.ftlh">
