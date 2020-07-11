<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<% String path=request.getContextPath();
path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base  href="<%=path%>">
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>博客登录</title>
    <link rel="stylesheet" href="resources/plugin/font-awesome/css/font-awesome.min.css">
    <link rel="shortcut icon" href="resources/img/logo.png">
    <link rel='stylesheet' id='dashicons-css'  href='resources/plugin/login/dashicons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='buttons-css'  href='resources/plugin/login/buttons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='forms-css'  href='resources/plugin/login/forms.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='l10n-css'  href='resources/plugin/login/l10n.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='login-css'  href='resources/plugin/login/login.min.css' type='text/css' media='all' />
     <link rel='stylesheet'  href='resources/css/login.css' type='text/css' media='all' />
   
    
    <meta name='robots' content='noindex,follow' />
    <meta name="viewport" content="width=device-width" />
</head>

<script >

<c:if test="${!empty msg }">
alert("${msg }")
</c:if>
</script>

<body class="login login-action-login wp-core-ui  locale-zh-cn">
<base  href="<%=path%>">
<div id="login">
    <br /> <br /> 
    <form name="loginForm" id="loginForm"  action="user/login"  method="post">
        <p>
            <label for="user_login">用户名或电子邮件地址<br />
                <input type="text" name="username" id="user_login" class="input" value="${param.username }" size="20" required/></label>
        </p>
        <p>
            <label for="user_pass">密码<br />
                <input type="password" name="password" id="user_pass" class="input" value="${param.password }" size="20" required/>
            </label>
        </p>
        <p class="forgetmenot"><label for="rememberme"><input name="rememberme" type="checkbox" id="rememberme" value="1" checked /> 记住密码</label></p>
        <p class="submit">
            <input type="submit" name="wp-submit" id="submit-btn" class="button button-primary button-large" value="登录" />
        </p>
    </form>

    <p id="backtoblog"><a href="#">&larr; 去往博客前台</a></p>

</div>


<div class="clear"></div>

</body>
</html>
