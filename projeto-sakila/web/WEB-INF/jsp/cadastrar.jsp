<%-- 
    Document   : cadastrar
    Created on : 13/08/2024, 17:14:29
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="./Styles/style.css">
    
    </head>
    <body>
        <h1>Novo Cadastro</h1>
        
        <form action="./cadastrar" class="form-container" method="post">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" name="titulo" placeholder="Titulo">
                <label for="floatingInput">Titulo</label>
            </div>
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" name="desc" placeholder="Descrição">
                <label for="floatingInput">Descrição</label>
            </div>
            <div class="form-floating mb-3">
                <input type="number" class="form-control" id="floatingInput" name="ano" placeholder="Ano">
                <label for="floatingInput">Ano</label>
            </div>
            <div class="btn-container">
                <br>
                <button class="btn btn-secondary" type="submit">Cadastrar</button>
            </div>
        </form>
        
        
        
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
