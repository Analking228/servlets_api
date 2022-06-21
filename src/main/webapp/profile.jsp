<%--
  Created by IntelliJ IDEA.
  User: penetrator3000
  Date: 15.06.2022
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLConnection" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.Properties" %>
<%@ page import="java.io.FileInputStream" %>

<%--
  Created by IntelliJ IDEA.
  User: snaomi
  Date: 15.01.2022
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@  page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <meta http-equiv='content-type' content='text/php; charset=windows-1251'>
    <link rel="icon" href="/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">

    <title>Profile page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/styles.css" type="text/css"><!-- Google Tag Manager -->
    <!-- End Google Tag Manager -->
    <style>
        body {
            box-sizing: border-box;
        }

        #Profile  {
            margin: 0 auto;
            display: block;
            width:  850px;
            background: white;
        }
        form, h1 {
            width: 300px;
            margin: 0 auto;
            padding-top: 20px;
        }

        h1 {
            margin: 40px auto;
        }

        .avatar {
            width: 200px;
        }

        .avatar img {
            width: 100%;
        }

        .avatar button {
            text-align: center;
            display: block;
            margin: 0 auto;
        }

        .wrapper {
            display: flex;
        }

        .table2, h2 {
            margin-left: 50px;
        }

        .table1, .table2 {
            display: flex;
            width: 610px;
        }

        .table1 div, .table2 div {
            width: 200px;
            display: block;
            border: 1px solid grey;
            border-right: none;

        }

        .table1 .right-border, .table2 .right-border {
            border-right: 2px solid grey;
        }

        .table1 p, .table2 p {
            padding: 2px;
            margin: 0;
            text-align: center;
        }

        .main-chars {
            font-weight: bold;
        }

        .main-chars p {
            margin-bottom: 5px;
        }

        .main-chars span {
            padding-left: 10px;
            font-weight: normal;
        }

        .table1 .colored, .table2 .colored {
            background: lightgray;
            box-sizing: border-box;

        }

        .table1 .right-border .colored, .table2 .right-border .colored {
            width: 197px;
            display: block;
        }
    </style>
</head>
<body>
<div id="Profile">
    <h1>
        Profile page
    </h1>
    <FORM NAME="form1" ACTION="logout" METHOD="post">
        <INPUT TYPE="SUBMIT" VALUE="Logout">
    </FORM>
    <div class="wrapper">
        <div>
            <div class="main-chars">
                <p>Name: <span><%= session.getAttribute("name")%></span></p>
                <p>Surname: <span><%= session.getAttribute("last_name")%></span></p>
                <p>E-mail:<span><%= session.getAttribute("email")%></span></p>
            </div>
            <div class="table1">
                <div>
                    <div class="colored"><p>Date</p></div>
                </div>
                <div>
                    <div class="colored"><p>Time</p></div>
                </div>
                <div class="right-border">
                    <div class="colored"><p>IP</p></div>
                </div>
            </div>
        </div>
    </div>
    <br><br>
</div>
</body>
</html>
