<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Boas-vindas ao nosso serviço</title>
    <style type="text/css">
        .section_area {
            position: relative;
            color: #6E6E6D;
            background-color: #69C6DE; /* Cor de fundo da área externa */
            width: 100%;
            padding-bottom: 50px;
        }
        .top_image {
            text-align: center;
            padding-bottom: 20px;
            padding-top: 20px;
            margin: 0 auto;
            width: 100%;
        }
        .content {
            margin: 20px auto;
            position: relative;
            text-align: center;
            background-color: #ffffff;
            border-radius: 30px;
            padding: 20px;
            width: 40%;
        }

        .header {
            position: relative;
            text-align: center;
            padding-bottom: 20px;
        }

        .content_paragrafo {
            position: relative;
            text-align: left;
            padding: 20px;
            margin-top: 20px;
        }
        .button {
            position: relative;
            display: inline-block;
            background-color: #E7216A;
            color: white;
            font-weight: bold;
            text-decoration: none;
            padding: 10px 20px;
            border-radius: 10px;
        }
        .button span {
            color: white; /* Cor branca aplicada ao texto dentro do span */
        }
        .button:hover {
            background-color: #e97aa8;
        }








    </style>
</head>
<body>

    <div class="section_area">
        <div class="top_image">
            <img src="${headers.pathStaticContentImage}/images/png/LogoFeriazName.png" alt="Logo"/>
        </div>
        <div class="content">
            <div class="header">
                <h1>Bem-vindo ao nosso serviço!</h1>
            </div>
            <div class="content_paragrafo">
                <#if body.specification.detail.nameTo?has_content>
                    <p>Olá, ${body.specification.detail.nameTo}</p>
                <#else>
                    <p>Olá</p>
                </#if>
                <p>Agradecemos por se cadastrar em nosso serviço. Para finalizar a criação da sua conta, clique no botão abaixo para confirmar seu email:</p>
            </div>

            <#if body.specification.detail.urlConfirmation?has_content>
                <a class="button" href="${body.specification.detail.urlConfirmation}"><span>Confirmar minha conta</span></a>
            <#else>
                <a class="button" href="#"><span>Confirmar minha conta</span></a>
            </#if>
            <div class="content_paragrafo">
                <p>Se você não se cadastrou em nosso serviço, por favor, ignore este email.</p>
                <p>Atenciosamente,</p>
                <p>A equipe do nosso serviço</p>
            </div>


        </div>

    </div>


</body>
</html>
