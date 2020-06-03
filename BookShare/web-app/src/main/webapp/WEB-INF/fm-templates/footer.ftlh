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
<script>
    $(".addNewBook").on('click', function () {
        let id = $(this).val();
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
        })
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
    $("#button_add_input_Another_Author").on('click', function () {
        const textArea = '<label for="anotherAuthor" class="col-sm-2 col-form-label" id="anotherAuthorField">Kolejny Autor</label> ' +
            '<div class="col-sm-10"><input type="text" class="form-control" id="anotherAuthorField" placeholder="Kolejny Autor"></div>'
        $("#anotherAuthor").append(textArea);
    });
</script>
</body>
</html>