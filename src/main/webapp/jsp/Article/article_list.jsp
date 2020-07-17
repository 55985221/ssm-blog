<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<rapid:override name="frame-content">
   <div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<!-- 下面这里的内容是要重写的 -->
				<blockquote class="layui-elem-quote">
					<span class="layui-breadcrumb" lay-separator="/"> <a
						href="/admin">首页</a> <a><cite>文章列表</cite></a>
					</span>
				</blockquote>

				<div class="layui-tab layui-tab-card">
					<form id="articleForm" method="post">
						<input type="hidden" name="currentUrl" id="currentUrl" value="">
						<table class="layui-table">
							<colgroup>
								<col width="300">
								<col width="150">
								<col width="100">
								<col width="150">
								<col width="100">
								<col width="50">
							</colgroup>
							<thead>
								<tr>
									<th>标题</th>
									<th>所属分类</th>
									<th>状态</th>
									<th>发布时间</th>
									<th>操作</th>
									<th>id</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="article" items="${pageInfo.list}">
							<tr>
									<td><a href="/article/${article.articleId }" target="_blank"> ${article.articleTitle}</a></td>
									<td><a href="/category/10" target="_blank">计算机科学</a>
										&nbsp; <a href="/category/13" target="_blank">数据库</a> &nbsp;</td>
									<td><a href="/admin/article?status=1"> <span
											style="color: #5FB878;">已发布</span>
									</a></td>
									<td>2018-11-25 21:06:52</td>
									<td><a href="/admin/article/edit/33"
										class="layui-btn layui-btn-mini">编辑</a> <a
										href="javascript:void(0)" onclick="deleteArticle(${article.articleId })"
										class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>
									<td>${article.articleId }</td>
								</tr>
							
							</c:forEach>
							</tbody>
						</table>
					</form>
					<%@ include file="../page.jsp" %>
				</div> 
           

</rapid:override>
<%@ include file="../framework.jsp" %>