<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Boas-vindas ao nosso serviço</title>
    <style>
        /* Estilos gerais */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
        }

        /* Estilos do cabeçalho */
        .header {
            text-align: center;
            padding: 20px 0;
            background-color: #f1f1f1;
        }

        .header h1 {
            color: #333333;
            margin: 0;
        }

        /* Estilos do conteúdo */
        .content {
            padding: 20px;
        }

        .content p {
            margin-bottom: 10px;
        }

        .content a {
            display: inline-block;
            background-color: #4caf50;
            color: #ffffff;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 4px;
        }

        .content a:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Bem-vindo ao nosso serviço!</h1>
    </div>
    <div class="content">
        <#if body.specification.detail.nameTo?has_content>
            <p>Olá, ${body.specification.detail.nameTo}</p>
        <#else>
            <p>Olá</p>
        </#if>
        <p>Agradecemos por se cadastrar em nosso serviço. Para finalizar a criação da sua conta, clique no botão abaixo para confirmar seu email:</p>
        <#if body.specification.detail.urlConfirmation?has_content>
            <p><a href="${body.specification.detail.urlConfirmation}">Confirmar minha conta</a></p>
        <#else>
            <p><a href="#">Confirmar minha conta</a></p>
        </#if>

        <p>Se você não se cadastrou em nosso serviço, por favor, ignore este email.</p>
        <p>Atenciosamente,</p>
        <p>A equipe do nosso serviço</p>
    </div>
</div>
</body>
</html>
