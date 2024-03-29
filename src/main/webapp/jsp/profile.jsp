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
<%@ page import="edu.school.cinema.models.Log" %>
<%@ page import="java.util.Arrays" %>
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
    <form name="form1" action="logout" method="post">
        <INPUT type="submit" value="Logout">
    </form>
    <div class="wrapper">
        <div class="avatar">
            <%
                Properties property = new Properties();
                property.load(new FileInputStream("/Users/penetrator3000/Documents/42coding/Java/Spring/Cinema/src/main/resources/application.properties"));
                String savePath = property.getProperty("images.upload.path");
                String defaultAvatar = property.getProperty("images.avatar.default");
                String path = savePath+session.getAttribute("id");
                File dir = new File(path);
                File[] arrFiles = dir.listFiles();
                List<String> lstAvatar = new ArrayList<>();
                List<Long> lstFileSize = new ArrayList<>();
                List<String> mimeTypes = new ArrayList<>();

                if (arrFiles != null) {
                    for (int i = 0; i < Objects.requireNonNull(arrFiles).length; i++) {
                        if(arrFiles[i].getName().contentEquals(Arrays.stream(arrFiles).findFirst().toString())){
                            throw new ServletException("This filename already exists");
                        }
                        lstAvatar.add(arrFiles[i].getName());
                        lstFileSize.add(arrFiles[i].length()/1024);
                        mimeTypes.add(URLConnection.guessContentTypeFromName(arrFiles[i].getName()));
                    }
                }
                else {
                    lstAvatar.add("");
                    lstFileSize.add(0L);
                    mimeTypes.add("");
                }

                request.setAttribute("urls", lstAvatar);
                request.setAttribute("sizes",lstFileSize);
                request.setAttribute("mimeTypes",  mimeTypes);
                request.setAttribute("urlPath", path);
                String avatar = (String)session.getAttribute("defaultAvatar");
                if (avatar == null){session.setAttribute("defaultAvatar", defaultAvatar);}
            %>
            <img src="<%=request.getContextPath()%>/images/<%=session.getAttribute("defaultAvatar")%>" alt="Avatar" title="Avatar">
        </div>
        <div>
            <div class="main-chars">
                <p>Name: <span><%= session.getAttribute("name")%></span></p>
                <p>Surname: <span><%= session.getAttribute("last_name")%></span></p>
                <p>E-mail:<span><%= session.getAttribute("email")%></span></p>
            </div>
            <div class="table1">
                <%
                    List<Log> logs = (List<Log>)session.getAttribute("logs");
                    request.setAttribute("logsList", logs);
                %>
                <div>
                    <div class="colored"><p>Date</p></div>
                    <c:forEach var="item" items="${logsList}">
                        <p>${item.date}</p>
                    </c:forEach>
                </div>
                <div>
                    <div class="colored"><p>Time</p></div>
                    <c:forEach var="item" items="${logsList}">
                        <p>${item.time}</p>
                    </c:forEach>
                </div>
                <div class="right-border">
                    <div class="colored"><p>IP</p></div>
                    <c:forEach var="item" items="${logsList}">
                        <c:if test = "${item.ip == '0:0:0:0:0:0:0:1'}">
                            <p>${'127.0.0.1'}</p>
                        </c:if>
                        <c:if test = "${item.ip != '0:0:0:0:0:0:0:1'}">
                            <p>${item.ip}</p>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <br><br>
    <h2>Uploaded files</h2>
    <br>
    <div class="table2">
        <div>
            <div class="colored"><p>File name</p></div>
            <c:forEach var = "url" items="${urls}">
                <c:if test="${url !=''}">
                    <div><p>
                        <a href="/images/<%= session.getAttribute("id")%>/${url}" target="_blank">${url}</a>
                    </p></div>
                </c:if>
            </c:forEach>
        </div>
        <div>
            <div class="colored"><p>Size</p></div>
            <c:forEach var = "size" items="${sizes}">
                <c:if test="${size != 0}">
                    <div><p>
                            ${size} Kb
                    </p></div>
                </c:if>
            </c:forEach>
        </div>
        <div class="right-border">
            <div class="colored"><p>MIME</p></div>
            <c:forEach var = "mimeType" items="${mimeTypes}">
                <c:if test="${mimeType !=''}">
                    <div><p>
                            ${mimeType}
                    </p></div>
                </c:if>
            </c:forEach>
        </div>
    </div>
</div>

<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/images" method="post">

    <input type="file" name="file" size="100" />
    <input type="submit" value="Upload new picture" />
    <br />

</form>

</body>
</html>
