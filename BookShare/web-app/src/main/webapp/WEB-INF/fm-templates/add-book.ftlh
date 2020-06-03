<#include "header.ftlh">
<#include "menu.ftlh">
<header class="jumbotron">
    <div class = "container">
        <h1 class="display-5">BookShare</h1>
        <p>Dodaj nową książkę</p>
    </div>
</header>

<main role="main">
    <div class="container">
        <form class = "needs-validation" novalidate>
            <div class="form-group row">
                <label for="inputTitle" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputTitle" placeholder="Tytuł">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputMainAuthor" class="col-sm-2 col-form-label">Autor</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputTitle" placeholder="Autor">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                <button class="btn btn-secondary" id="button_add_input_Another_Author" type="button">Dodaj kolejnego autora</button>
                </div>
            </div>
            <div class="form-group row" id="anotherAuthor"></div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck1">
                        <label class="form-check-label" for="gridCheck1">
                            Przeczytana
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
            </div>
        </form>
        </div>
<#--        <form method="post" action="/books">-->
<#--            Tytuł: <input type="text" name="title"/><br/><br/>-->
<#--            Autor: <input type="text" name="mainAuthorName"/><br/><br/>-->
<#--            Kategoria: <input type="text" name="category"/><br/><br/>-->
<#--            ISBN: <input type="text" name="isbn"/><br/><br/>-->
<#--            Czy przeczytana: <input type="text" name="isRead"/><br/><br/>-->
<#--            Opis: <input type="text" name="description"/><br/><br/>-->

<#--            <button class="addNewBook" type="submit" value="${bookId}">Dodaj książkę</button>-->
<#--        </form>-->
<#--    </div>-->
</main>
<#include "footer.ftlh">