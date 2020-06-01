<#include "header.ftlh">
<#include "menu.ftlh">
<header class="jumbotron">
    <div class="container">
        <h1>Dodaj nową książkę</h1>
        <p>
            Wprowadź dane swojej książki!
        </p>
        <form method="post" action="/books">
            Tytuł: <input type="text" name="title"/><br/><br/>
            Autor: <input type="text" name="mainAuthorName"/><br/><br/>
            Kategoria: <input type="text" name="category"/><br/><br/>
            ISBN: <input type="text" name="isbn"/><br/><br/>
            Czy przeczytana: <input type="text" name="isRead"/><br/><br/>
            Opis: <input type="text" name="description"/><br/><br/>

            <button class="addNewBook" type="submit" value="Zapisz">Dodaj książkę</button>
        </form>
    </div>
</header>

<main role="main">
    <div class="container">
    </div>
</main>
<#include "footer.ftlh">