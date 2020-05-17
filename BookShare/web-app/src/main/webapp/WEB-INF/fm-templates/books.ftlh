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
        <#list books>
            <ul>
                <#items as bookKey, bookValue>
                    <li>
                        <p>${bookKey}</p>
                        <p>Tytuł: ${bookValue.title}</p>
                        <p>ISBN: ${bookValue.isbn}</p>
                    </li>
                </#items>
            </ul>
        </#list>
    </div>
</main>
<#include "footer.ftlh">
