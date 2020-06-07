<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="container">
        <form class="needs-validation" id="addNewBookForm" novalidate method="post" action="/books">
            <div class="form-group row">
                <label for="title" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="title" placeholder="Podaj tytuł" required>
                    <div class="invalid-feedback">Tytuł jest wymagany</div>
                </div>
            </div>
            <div id="authors">
                <div class="form-group row" id="author">
                    <label for="author" class="col-sm-2 col-form-label">Autor</label>
                    <div class="input-group col-sm-10">
                        <input type="text" class="form-control" id="author" name="author" placeholder="Podaj autora" required>
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" id="button_add_input_Another_Author" type="button">
                                Dodaj kolejnego autora
                            </button>
                        </div>
                        <div class="invalid-feedback">Minimum 1 autor jest wymagany</div>
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <label for="category" class="col-sm-2 col-form-label">Kategoria</label>
                <div class="col-sm-10">
                    <select class="custom-select" id="category" name="category" required>
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
                <label for="isbn" class="col-sm-2 col-form-label">ISBN</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="isbn" name="isbn" placeholder="Podaj ISBN" required pattern="^(?=(?:\D*\d){10}(?:(?:\D*\d){3})?$)[\d-]+$">
                    <div class="invalid-feedback">Prawidłowy ISBN jest wymagany (dozwolone są tylko cyfry, numer musi mieć 10 lub 13 znaków)</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="imgUrl" class="col-sm-2 col-form-label">Zdjęcie okładki</label>
                <div class="col-sm-10">
                    <input type="text" name="imgUrl" class="form-control" id="imgUrl"
                           placeholder="Wklej link do zdjęcia okładki" pattern="^(+\.(jpg|JPG|jpeg|JPEG|png|PNG|gif|GIF))$">
                    <div class="invalid-feedback">Podaj adres url do obrazka kończący się .jpg / .jpeg / .png / .gif</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-2 col-form-label">Opis książki</label>
                <div class="col-sm-10">
                    <textarea class="form-control" name="description" id="description" rows="3"
                              placeholder="Wprowadź opis książki"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label  class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                    <input class="form-check-input col-md-auto" name="read" type="checkbox" id="read">
                    <label class="form-check-label col-md-auto" for="read">Przeczytana</label>
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