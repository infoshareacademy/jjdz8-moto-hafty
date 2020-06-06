<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="container">
        <form class="needs-validation" id="editBookForm" action="edit-book?id=${bookId}" method="POST">
            <div class="form-group row">
                <label for="editTitle" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputTitle" name="editTitle" placeholder="Podaj tytuł" value="${bookTitle}">
                </div>
            </div>
            <div id="authors">
                <div class="form-group row mainAuthor" id="author">
                    <label for="editMainAuthor" class="col-sm-2 col-form-label">Autor</label>
                    <div class="input-group col-sm-10">
                        <input type="text" class="form-control" id="inputMainAuthor" name="author" placeholder="Autorzy" value="${bookAuthors[0]}">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" id="button_add_input_Another_Author" type="button">
                                Dodaj kolejnego autora
                            </button>
                        </div>
                    </div>
                </div>
                <#if bookAuthors?size != 1>
                    <#list 1..bookAuthors?size-1 as i>
                        <div class="form-group row anotherAuthor" id="author">
                            <label for="anotherAuthorField" class="col-sm-2 col-form-label">Kolejny Autor</label>
                            <div class="input-group col-sm-10">
                                <input type="text" class="form-control" id="anotherAuthorField" name="author" placeholder="Podaj kolejnego autora" value="${bookAuthors[i]}">
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
                <label for="editCategory" class="col-sm-2 col-form-label">Kategoria</label>
                <div class="col-sm-10">
                    <select class="custom-select" id="inputCategory" name="editCategory" required>
                        <option selected>${bookCategory}</option>
                        <#list categoryList>
                            <#items as category>
                                    <option value="${category}">${category}</option>
                            </#items>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="editIsbn" class="col-sm-2 col-form-label">ISBN</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIsbn" name="editIsbn" placeholder="ISBN" value="${bookISBN}">
                </div>
            </div>
            <div class="form-group row">
                <label for="editImgUrl" class="col-sm-2 col-form-label">Zdjęcie okładki</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="editImgUrl" name="editImgUrl"
                           placeholder="Link do zdjęcia okładki" value="${bookImgURL}">
                </div>
            </div>
            <div class="form-group row">
                <label for="editDescription" class="col-sm-2 col-form-label">Opis książki</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="inputDescription" name="editDescription" rows="3"
                              placeholder="Opis książki">${bookDescription}</textarea>
                </div>
            </div>
            <div class="form-group row">
                <label  class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                    <#if bookRead == true>
                    <input class="form-check-input col-md-auto" type="checkbox" id="inputRead" name="editRead" checked>
                    <#else>
                    <input class="form-check-input col-md-auto" type="checkbox" id="inputRead" name="editRead">
                    </#if>
                    <label class="form-check-label col-md-auto" for="gridCheck1">Przeczytana</label>
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