<%-- 
    Document   : filmes
    Created on : 16/08/2024, 17:07:38
    Author     : Senai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <h1>Filmes</h1>
        
        <table>
                <thead>
                    <th>
                        <td>id</td>
                        <td>titulo</td>
                        <td>descrição</td>
                        <td>ano</td>
                        <td>ações</td>
                    </th>
                </thead>
                <tbody>
                    <c:forEach var="filme" items="${filmes}">
                    <tr>
                        <td></td>
                        <td>${filme.film_id}</td>
                        <td>${filme.title}</td>
                        <td>${filme.description}</td>
                        <td>${filme.release_year}</td>
                        <td>
                            <a href="./editar?filme=${filme.film_id}">
                                <button type="button" class="btn btn-outline-info">Editar</button>
                            </a>

                            <a href="./deletar?filme=${filme.film_id}">
                            <button type="button" class="btn btn-outline-danger"><i class="fa-solid fa-trash"></i></button>
                            </a>

                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <script src="https://kit.fontawesome.com/d4af064d29.js" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
