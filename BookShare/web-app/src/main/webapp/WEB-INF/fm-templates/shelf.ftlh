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
    <div class="container">
        <div class="card bg-dark text-white">
            <div class="card-body">Użytkownik ${user.login} (${user.name} ${user.surname}) przekazał te książki do wypożyczenia innym użytkownikom</div>
        </div>
            <div class="table" id="tableHeaders">
                <div class="table-header">
                    <div class="mainAuthorName header__item">
                        GŁÓWNY AUTOR
                    </div>
                    <div class="title header__item">
                        TYTUŁ KSIĄŻKI
                    </div>
                    <div class="options header__item">
                        USUŃ
                    </div>
                </div>
                <div class="table-content">
                    <#list shelfBooks>
                        <#items as bookKey, bookValue>
                            <div class="table-row">
                                <div class="mainAuthorName table-data">${bookValue.mainAuthorName}</div>
                                <div class="title table-data">${bookValue.title}</div>
                                <div class="options table-data">
                                    <button class="delete-book-from-shelf" type="submit" value="${bookKey}">Usuń z półki</button>
                                </div>
                            </div>
                        </#items>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</main>
<#include "footer.ftlh">
