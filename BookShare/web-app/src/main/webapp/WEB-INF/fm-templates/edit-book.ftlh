<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="container">
        <form class="needs-validation" id="editBookForm" action="edit-book?id=${bookId}" method="POST">
            <div class="form-group row">
                <label for="title" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="title" name="title" placeholder="Podaj tytuł" value="${book.title}" required>
                    <div class="invalid-feedback">Tytuł jest wymagany</div>
                </div>
            </div>
            <div id="authors">
                <div class="form-group row mainAuthor" id="author">
                    <label for="author" class="col-sm-2 col-form-label">Autor</label>
                    <div class="input-group col-sm-10">
                        <input type="text" class="form-control" id="author" name="author" placeholder="Autorzy" value="${book.authors[0]}" required>
                        <div class="invalid-feedback">Minimum 1 autor jest wymagany</div>
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" id="button_add_input_Another_Author" type="button">
                                Dodaj kolejnego autora
                            </button>
                        </div>
                    </div>
                </div>
                <#if book.authors?size != 1>
                    <#list 1..book.authors?size-1 as i>
                        <div class="form-group row anotherAuthor" id="author">
                            <label for="author" class="col-sm-2 col-form-label">Kolejny Autor</label>
                            <div class="input-group col-sm-10">
                                <input type="text" class="form-control" id="author" name="author" placeholder="Podaj kolejnego autora" value="${book.authors[i]}">
                                <div class="input-group-append remove_button">
                                    <button class="btn btn-outline-secondary remove_additional_author" type="button">
                                        Usuń autora
                                    </button>
                                </div>
                            </div>
                        </div>
                    </#list>
                    </#if>
            </div>
            <div class="form-group row">
                <label for="category" class="col-sm-2 col-form-label">Kategoria</label>
                <div class="col-sm-10">
                    <select class="custom-select" id="category" name="category" required>
                        <option selected>${book.category}</option>
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
                    <input type="text" class="form-control" id="isbn" name="isbn" placeholder="ISBN" value="${book.isbn}" required pattern="^(?=(?:\D*\d){10}(?:(?:\D*\d){3})?$)[\d-]+$">
                    <div class="invalid-feedback">Prawidłowy ISBN jest wymagany (dozwolone są tylko cyfry, numer musi mieć 10 lub 13 znaków)</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="imgUrl" class="col-sm-2 col-form-label">Zdjęcie okładki</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="imgUrl" name="imgUrl"
                           placeholder="Link do zdjęcia okładki" value="${book.imgUrl}" pattern="^+\.(jpg|JPG|jpeg|JPEG|png|PNG|gif|GIF)$">
                    <div class="invalid-feedback">Podaj adres url do obrazka kończący się .jpg / .jpeg / .png / .gif</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="description" class="col-sm-2 col-form-label">Opis książki</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="description" name="description" rows="3"
                              placeholder="Opis książki">${book.description}</textarea>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                    <#if bookRead == true>
                    <input class="form-check-input col-md-auto" type="checkbox" id="read" name="read" checked>
                    <#else>
                    <input class="form-check-input col-md-auto" type="checkbox" id="read" name="read">
                    </#if>
                    <label class="form-check-label col-md-auto" for="read">Przeczytana</label>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg" id="editBookButton" value="${bookId}">Zapisz zmiany</button>
                </div>
            </div>
        </form>
    </div>
</main>
<#include "footer.ftlh">