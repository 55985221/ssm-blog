
<html>
<% String path=request.getContextPath();
path=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base  href="<%=path%>">
<body>
<jsp:forward page="jsp/login.jsp" />
</body>
</html>
