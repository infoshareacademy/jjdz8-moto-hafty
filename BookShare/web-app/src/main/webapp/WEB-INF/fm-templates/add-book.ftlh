<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="container">
        <form class="needs-validation" novalidate>
            <div class="form-group row">
                <label for="inputTitle" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputTitle" placeholder="Podaj tytuł">
                </div>
            </div>

            <div class="form-group row">
                <label for="inputMainAuthor" class="col-sm-2 col-form-label">Autor</label>
                <div class="input-group col-sm-10">
                    <input type="text" class="form-control" placeholder="Podaj autora">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" id="button_add_input_Another_Author" type="button">
                            Dodaj kolejnego autora
                        </button>
                    </div>
                </div>
            </div>
            <div class="form-group row" id="anotherAuthor"></div>
            <div class="form-group row">
                <label for="inputCategory" class="col-sm-2 col-form-label">Kategoria</label>
                <div class="col-sm-10">
                    <select class="custom-select">
                        <option selected>Wybierz Kategorię</option>
                        <#list categoryList>
                            <#items as category>
                                <option value="${category}">${category}</option>
                            </#items>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputIsbn" class="col-sm-2 col-form-label">ISBN</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIsbn" placeholder="Podaj ISBN">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputImgUrl" class="col-sm-2 col-form-label">Zdjęcie okładki</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputImgUrl"
                           placeholder="Wklej link do zdjęcia okładki">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputDescription" class="col-sm-2 col-form-label">Opis książki</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="inputDescription" rows="3"
                              placeholder="Wprowadź opis książki"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <label  class="col-sm-2 col-form-label"></label>
                <div class="col-sm-10">
                    <input class="form-check-input col-md-auto" type="checkbox" id="gridCheck1">
                    <label class="form-check-label col-md-auto" for="gridCheck1">Przeczytana</label>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg">Dodaj książkę</button>
                </div>
            </div>
        </form>
    </div>
</main>
<#include "footer.ftlh">