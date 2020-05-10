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
        <ul>
            <li></li>
        <#list books?keys as key>
                   <li>
                       <p>Tytuł: ${books[key].title}</p>
                       <p>ISBN: ${books[key].isbn}</p>
                       <p></p>
                   </li>
        </#list>
           </ul>
    </div>
</main>
<#include "footer.ftlh">
