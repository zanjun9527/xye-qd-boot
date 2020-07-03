<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <script src="../static/jquery-1.8.3.js"></script>


    <style>
        .login{
            width: 50%;
            margin: 0 auto;
            text-align: center;
        }

    </style>


</head>
<body>




<form action="/test/login">
    <div class="login">

        <h1>后台登录</h1>
        用户名：<input type="text" id="cellPhone" name="cellPhone">
        密码：<input type="text" id="cellPhone" name="passWord">

        <button type="submit">点击登录</button>
    </div>

</form>

</body>


</html>