<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
            name="description"
            content=${pageDescription}
    />
    <title>${pageTitle}</title>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
            crossorigin="anonymous"
    />

    <style>
        *, *:before, *:after {
            box-sizing:border-box;
        }

        .table-container {
            max-width: 1000px;
            margin-right:auto;
            margin-left:auto;
            display:flex;
            justify-content:center;
            align-items:center;
        }

        .table {
            width:100%;
            border:1px solid #EEEEEE;
        }

        .table-header {
            font-weight:  bold;
            display:flex;
            width:100%;
            background:#000;
            padding:18px;
        }

        .header__item {
            color: white;
            position: relative;
            display: inline-block;
        }

        .table-row {
            display: flex;
            width: 100%;
            padding: 18px;
        }

        .table-row:nth-of-type(odd) {
            background:#EEEEEE;
        }


        .table-data, .header__item {
            /*flex: 1 1 20%;*/
            text-align:center;
            padding:0.5%;
        }

        .options {
            width: 10%;
        }

        .title {
            width: 70%;
        }

        .mainAuthorName {
            width: 20%;
        }

    </style>
<#--    <link-->
<#--            rel="stylesheet2"-->
<#--            type="text/css"-->
<#--            href="style.css"-->
<#--    />-->
</head>

<body>