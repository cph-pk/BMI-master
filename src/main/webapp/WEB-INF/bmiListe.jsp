<%--
  Created by IntelliJ IDEA.
  User: Per
  Date: 10-03-2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>BMI liste</title>
</head>
<body>
<div class="container">
    <img src="images/bmi_skala.png" class="img-fluid">

    <h1 class="mt-4 mb-4 text-center text-primary">BMI liste</h1>
    <div class="row">
        <div class="col-md-2 col-lg-2"></div>
        <div class="col-md-8 col-lg-8">
            <table class="table">
                <tr>
                    <th>Dato</th>
                    <th>Højde</th>
                    <th>Vægt</th>
                    <th>BMI</th>
                    <th>Status</th>
                </tr>
                <c:forEach var="element" items="${requestScope.bmiliste}">
                    <tr>
                        <td>${element.dato}</td>
                        <td>${element.height}</td>
                        <td>${element.weight}</td>
                        <td>${element.bmi}</td>
                        <td><span class="${element.color}">${element.status}</span></td>
                    </tr>
                </c:forEach>


            </table>
        </div>
        <div class="col-md-2 col-lg-2"></div>
    </div>

    <div class="mt-4 mb-4 text-center">
        <form action="FrontController" method="post">
            <input type="hidden" name="taget" value="index">
            <button type="submit" class="btn btn-primary">Til forsiden</button>
        </form>
    </div>


</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>