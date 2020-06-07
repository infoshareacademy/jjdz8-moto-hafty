<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="container">
        <form class="needs-validation" id="addNewBookForm" novalidate method="post" action="/books">
            <div class="form-group row">
                <label for="inputTitle" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputTitle" name="newTitle" placeholder="Podaj tytuł" required>
                    <div class="invalid-feedback">Tytuł jest wymagany</div>
                </div>
            </div>
            <div id="authors">
                <div class="form-group row" id="author">
                    <label for="inputMainAuthor" class="col-sm-2 col-form-label">Autor</label>
                    <div class="input-group col-sm-10">
                        <input type="text" class="form-control" id="inputMainAuthor" name="author" placeholder="Podaj autora" required>
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" id="button_add_input_Another_Author" type="button">
                                Dodaj kolejnego autora
                            </button>
                        </div>
                        <div class="invalid-feedback">Autor jest wymagany</div>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputCategory" class="col-sm-2 col-form-label">Kategoria</label>
                <div class="col-sm-10">
                    <select class="custom-select" id="inputCategory" name="newCategory" required>
                        <option selected value="" disabled>Wybierz Kategorię</option>
                        <#list categoryList>
                            <#items as category>
                                <option value="${category}">${category}</option>
                            </#items>
                        </#list>
                    </select>
                    <div class="invalid-feedback">Kategoria jest wymagana</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputIsbn" class="col-sm-2 col-form-label">ISBN</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIsbn" name="newIsbn" placeholder="Podaj ISBN" required pattern="^(?=(?:\D*\d){10}(?:(?:\D*\d){3})?$)[\d-]+$">
                    <div class="invalid-feedback">Prawidłowy ISBN jest wymagany</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputImgUrl" class="col-sm-2 col-form-label">Zdjęcie okładki</label>
                <div class="col-sm-10">
                    <input type="text" name="newImgUrl" class="form-control" id="inputImgUrl"
                           placeholder="Wklej link do zdjęcia okładki">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputDescription" class="col-sm-2 col-form-label">Opis książki</label>
                <div class="col-sm-10">
                    <textarea class="form-control" name="newDescription" id="inputDescription" rows="3"
                              placeholder="Wprowadź opis książki"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label  class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                    <input class="form-check-input col-md-auto" name="newRead" type="checkbox" id="gridCheck1">
                    <label class="form-check-label col-md-auto" for="gridCheck1">Przeczytana</label>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg" id="addNewBookButton" value="${bookId}">Dodaj książkę</button>
                </div>
            </div>
        </form>
    </div>
</main>
<#include "footer.ftlh">