<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>signIn</title>
</head>
<body>
    <div style="margin:0 auto;">
    <form style="margin:0 auto;" action="/loginIn" method="post">
        <table>
            <tr>
                <th>Username:</th>
                <th><label>
                    <input type="text" name="username"/>
                </label></th>
            </tr>
            <tr>
                <th>Password:</th>
                <th><label>
                    <input type="password" name="password"/>
                </label></th>
            </tr>
            <tr>
                <th></th>
                <th><input type="submit" value="loginIn"/></th>
            </tr>
        </table>
    </form>
    </div>
</body>
</html>
