<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<rapid:override name="frame-content">
  <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding:15px;">
            <blockquote class="layui-elem-quote">
				        <span class="layui-breadcrumb" lay-separator="/">
				              <a href="/admin">首页</a>
				              <a href="/admin/category">分类列表</a>
				              <a><cite>添加分类</cite></a>
				        </span>
				    </blockquote>
   
    
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form"  method="post" id="myForm" action="/admin/category/insertSubmit">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>添加分类</strong>
                    </div>
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="categoryName" placeholder="请输入分类名称" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        父节点 <span style="color: #FF5722; ">*</span>
                        <select name="categoryPid" class="layui-input" required>
                            <option value="0">无</option>
                            <c:forEach items="${category }" var="catege">
                            
                             <option value="${catege.categoryid }">${catege.categoryname }</option>
                            </c:forEach>
                                </select>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        分类描述
                        <input type="text" name="categoryDescription" placeholder="请输入分类描述" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        图标样式
                        <input type="text" name="categoryIcon" placeholder="请输入图标样式,如 fa fa-coffee" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="300">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="50">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>文章数</th>
                    <th>操作</th>
                    <th>ID</th>
                    <th>pid</th>
                </tr>
                </thead>
                <tbody>
              
                    <c:forEach items="${category }" var="categ">
                     <tr>
                            <td>
                                <a href="/category/1" target="_blank">${categ.categoryname }</a>
                            </td>
                            <td>
                                <a href="/category/1" target="_blank">${categ.articlenumber }</a>
                            </td>
                            <td>
                                <a href="/admin/category/edit/${categ.categoryid }" class="layui-btn layui-btn-mini">编辑</a>
                              <c:if test="${categ.articlenumber==0 }">
                              <a href="/admin/category/delete/${categ.categoryid }" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                              </c:if>  
                                </td>
                            <td>${categ.categoryid }</td>
                            <td>${categ.categorypid }</td>
                        </tr>
                    <c:forEach items="${categ.category }" var="catega">
                     <tr>
                            <td>
                                <a href="/category/1" target="_blank">${catega.categoryname }</a>
                            </td>
                            <td>
                                <a href="/category/1" target="_blank">${catega.articlenumber }</a>
                            </td>
                            <td>
                                <a href="/admin/category/edit/${catega.categoryid }" class="layui-btn layui-btn-mini">编辑</a>
                                <c:if test="${catega.articlenumber==0 }">
                              <a href="/admin/category/delete/${catega.categoryid }" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                              </c:if>  
                                </td>
                            <td>${catega.categoryid }</td>
                            <td>${catega.categorypid }</td>
                        </tr>
                    
                    
                    </c:forEach>
                    
                    </c:forEach>
                            </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>分类最多只有两级，一级分类pid=0，二级分类pid=其父节点id</li>
                    <li>如果该分类包含文章，将不可删除</li>
                </ul>
            </blockquote>
        </div>
    </div>






</div>
    </div>
</rapid:override>
<%@ include file="../framework.jsp" %>