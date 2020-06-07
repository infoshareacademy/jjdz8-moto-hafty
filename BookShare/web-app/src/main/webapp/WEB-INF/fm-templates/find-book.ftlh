<#include "header.ftlh">
<#include "menu.ftlh">
<#include "jumbotron.ftlh">
<main role="main">
    <div class="container">
        <form class="needs-validation" id="inputBookForm" action="find-book" method="POST">
            <div class="row">Wyszukiwanie proste:</div>
            <div class="form-group row">
                <label for="inputAny" class="col-sm-2 col-form-label">Wyszukaj gdziekolwiek</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputAny" name="findAny" placeholder="Fragment do wyszukania">
                </div>
            </div>
            <div class="row">Wyszukiwanie zaawansowane:</div>
            <div class="form-group row">
                <label for="inputTitle" class="col-sm-2 col-form-label">Tytuł</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputTitle" name="findTitle" placeholder="Podaj fragment tytułu">
                </div>
            </div>
                <div class="form-group row mainAuthor" id="author">
                    <label for="inputAuthor" class="col-sm-2 col-form-label">Autor</label>
                    <div class="find-group col-sm-10">
                        <input type="text" class="form-control" id="inputAuthor" name="findAuthor" placeholder="Podaj fragment imienia lub nazwiska autora">
                    </div>
            </div>
            <div class="form-group row">
                <label for="inputCategory" class="col-sm-2 col-form-label">Kategoria</label>
                <div class="find-group col-sm-10">
                    <input type="text" class="form-control" id="inputCategory" name="findCategory" placeholder="Podaj fragment kategorii">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputIsbn" class="col-sm-2 col-form-label">ISBN</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputIsbn" name="findIsbn" placeholder="Podaj fragment kodu ISBN" pattern="^?\d?$">

                    <div class="invalid-feedback">Prawidłowy ISBN jest wymagany - wpisz same cyfry</div>
                </div>
            </div>
            <div class="form-group row">
                <label for="inputDescription" class="col-sm-2 col-form-label">Opis książki</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="inputDescription" name="findDescription" rows="3"
                              placeholder="Podaj fragment opisu książki"></textarea>
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary btn-lg" id="inputBookButton">Szukaj</button>
                </div>
            </div>
        </form>
    </div>
</main>
<#include "footer.ftlh">