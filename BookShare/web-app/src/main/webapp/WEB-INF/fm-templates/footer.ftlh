<footer class="container">
    <p>BookShare Copyright © ${.now?string('yyyy')}</p>
</footer>

<script
        src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
        crossorigin="anonymous"></script>

<script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"
></script>

<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"
></script>
<script src="https://cdn.rawgit.com/PascaleBeier/bootstrap-validate/v2.2.0/dist/bootstrap-validate.js"></script>
<script>
    $("#addNewBookButton").on('click', function () {
        let id = $("#addNewBookButton").val()
        let isValid = $("#addNewBookForm").reportValidity()
        if (isValid) {
            $("#addNewBookButton").attr("disabled", false)
        $.ajax({
            "url": '/books?id=' + id,
            "method": 'POST',
            "success": function () {
                alert("Książka została dodana do biblioteczki.");
                location.reload();
            },
            "error": function () {
                alert("Coś poszło nie tak.");
                location.reload();
            }
        })}
    })
</script>
<script>
    $("#editBookButton").on('click', function () {
        let id = $("#editBookButton").val()
        let isValid = $("#editBookForm").reportValidity()
        if (isValid) {
            $("#editBookButton").attr("disabled", false)
            $.ajax({
                "url": '/edit-book?id=' + id,
                "method": 'POST',
                "content-type": 'text/html;charset=UTF-8',
                "success": function () {
                    alert("Książka została edytowana");
                    location.reload();
                },
                "error": function () {
                    alert("Coś poszło nie tak.");
                    location.reload();
                }
            })}
    })
</script>
<script>
    $(".clear-shelf").on('click', function () {
        let id = $(this).val();
        const r = confirm("Czy na pewno chcesz usunąć wszystkie książki z półki?");
        if (r === true) {
            $.ajax({
                "url": '/shelf?id=' + id,
                "method": 'POST',
                "success": function () {
                    alert("Półka została wyczyszczona");
                    location.reload();
                },
                "error": function () {
                    alert("Nie wprowadzono żadnych zmian");
                    location.reload();
                }
            })
        }
    })
</script>
<script>
    $(".delete-book-from-shelf").each(function () {
        $(this).on('click', function () {
            let id = $(this).val();
            $.ajax({
                "url": '/shelf?id=' + id,
                "method": 'DELETE',
                "success": function () {
                    alert("Książka została usunięta z półki.");
                    location.reload();
                },
                "error": function () {
                    alert("Coś poszło nie tak.");
                    location.reload();
                }
            })
        });
    })
</script>
<script>
    $(".addToShelfButton").on('click', function () {
        let id = $(this).val();
        $.ajax({
            "url": '/shelf?id=' + id,
            "method": 'PUT',
            "success": function () {
                alert("Książka została dodana do wypożyczalni");
                location.reload();
            },
            "error": function () {
                alert("Nie wprowadzono żadnych zmian");
                location.reload();
            }
        })
    })
</script>
<script>
    $("#button_add_input_Another_Author").on('click', function (e) {
        e.preventDefault();
        const textArea = '<div class="form-group row anotherAuthor" id="author">\n' +
                '<label for="anotherAuthorField" class="col-sm-2 col-form-label">Kolejny Autor</label>\n' +
                '<div class="input-group col-sm-10">\n' +
                '<input type="text" class="form-control" id="anotherAuthorField" name="author" placeholder="Podaj kolejnego autora">\n' +
                '<div class="input-group-append remove_button">\n' +
                '<button class="btn btn-outline-secondary remove_additional_author" type="button">\n' +
                'Usuń autora\n' +
                '</button>\n' +
                '</div>\n' +
                '</div>\n' +
                '</div>\n'
        $("#authors").append(textArea);
    });
</script>
<script>
        $("#authors").on('click','.remove_additional_author', function (e) {
            e.preventDefault();
            $(this).parent().parent().parent().remove();
        });
</script>
<script>
    bootstrapValidate(['#inputTitle', '#inputMainAuthor', '.anotherAuthorField'], 'max:150:Maksymalnie 150 znaków|required:Pole jest wymagane', function (isValid) {
    });
</script>
<script>
    bootstrapValidate('#inputIsbn', 'required:Pole jest wymagane|regex:^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$:Wprowadź prawidłowy ISBN', function (isValid) {
    });
</script>
</body>
</html>