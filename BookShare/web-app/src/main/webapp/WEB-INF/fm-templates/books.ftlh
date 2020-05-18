<#include "header.ftlh">
<#include "menu.ftlh">
<header class="jumbotron">
    <div class="container">
        <h1 class="display-3">BookShare</h1>
        <p>
            Aplikacja BookShare pozwala na zarządzanie twoja domową biblioteką książek.
        </p>
    </div>
</header>

<main role="main">
    <div class="container">
        <div class="table-container">
            <div class="table">
                <div class="table-header">
                    <div class="mainAuthorName header__item">
                        GŁÓWNY AUTOR
                    </div>
                    <div class="title header__item">
                        TYTUŁ KSIĄŻKI
                    </div>
                    <div class="options header__item">
                        OPCJE
                    </div>
                </div>
                <div class="table-content">
                    <#list books>
                    <#items as bookKey, bookValue>
                    <div class="table-row">
                        <div class="mainAuthorName table-data">${bookValue.mainAuthorName}</div>
                        <div class="title table-data">${bookValue.title}</div>
                        <div class="options table-data">
                            <a href="/book-edit?book=${bookKey}">Edytuj</a> <a href="/book-delete?book=${bookKey}">Usuń</a>
                        </div>
                    </div>
                    </#items>
                    </#list>
                </div>
            </div>
        </div>
    </div>
</main>
<script>
    var properties = [
        'mainAuthorName',
        'title'
    ];

    $.each( properties, function( i, val ) {

        var orderClass = '';

        $("#" + val).click(function(e){
            e.preventDefault();
            $('.filter__link.filter__link--active').not(this).removeClass('filter__link--active');
            $(this).toggleClass('filter__link--active');
            $('.filter__link').removeClass('asc desc');

            if(orderClass == 'desc' || orderClass == '') {
                $(this).addClass('asc');
                orderClass = 'asc';
            } else {
                $(this).addClass('desc');
                orderClass = 'desc';
            }

            var parent = $(this).closest('.header__item');
            var index = $(".header__item").index(parent);
            var $table = $('.table-content');
            var rows = $table.find('.table-row').get();
            var isSelected = $(this).hasClass('filter__link--active');
            var isNumber = $(this).hasClass('filter__link--number');

            rows.sort(function(a, b){

                var x = $(a).find('.table-data').eq(index).text();
                var y = $(b).find('.table-data').eq(index).text();

                if(isNumber == true) {

                    if(isSelected) {
                        return x - y;
                    } else {
                        return y - x;
                    }

                } else {

                    if(isSelected) {
                        if(x < y) return -1;
                        if(x > y) return 1;
                        return 0;
                    } else {
                        if(x > y) return -1;
                        if(x < y) return 1;
                        return 0;
                    }
                }
            });

            $.each(rows, function(index,row) {
                $table.append(row);
            });

            return false;
        });

    });
</script>
<#include "footer.ftlh">
