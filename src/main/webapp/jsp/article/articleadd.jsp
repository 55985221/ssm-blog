 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<rapid:override name="frame-content">
<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<blockquote class="layui-elem-quote">
					<span class="layui-breadcrumb" lay-separator="/"> 
						<a href="/admin">首页</a> <a href="/admin/article">文章列表</a> <a><cite>添加文章</cite></a>
					</span>
				</blockquote>
			
				<form class="layui-form" method="post" id="myForm" action="article/articleadd">
					<div class="layui-form-item">
						<label class="layui-form-label">标题 <span style="color: #FF5722;" >*</span></label>	
						<div class="layui-input-block">
							<input type="text" name="articleTitle" lay-verify="title" id="title"
								autocomplete="off" placeholder="请输入标题" class="layui-input">
						</div>
					</div>
			
					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">内容 <span style="color: #FF5722;">*</span></label>		
						<div class="layui-input-block">
							<textarea class="layui-textarea layui-hide" name="articleContent" lay-verify="content" id="content"></textarea>
						</div>
					</div>
			
					<div class="layui-form-item">
						<label class="layui-form-label">分类 <span
							style="color: #FF5722;">*</span>
						</label>
						<div class="layui-input-inline">
							    <select name="articleParentCategoryId" id="articleParentCategoryId" lay-filter="articleParentCategoryId" required>
			                 
			                    <option value="" >一级分类</option>
				                    	<c:forEach items="${category}" var="c">
								<option value="${c.categoryid }">${c.categoryname }</option>
								</c:forEach>
			                    </select>
						</div>
						<div class="layui-input-inline">
							<select name="articleChildCategoryId" id="articleChildCategoryId">
								<option value="0" selected>二级分类</option>
							</select>
						</div>
					</div>
			
					<div class="layui-form-item" pane="">
						<label class="layui-form-label">标签</label>
						<div class="layui-input-block">
						   <c:forEach items="${tag }" var="a">
								<input type="checkbox" name="articleTagIds" lay-skin="primary"
								title="${a.tagname }" value="${a.tagid }"> 
								</c:forEach>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">状态</label>
						<div class="layui-input-block">
							<input type="radio" name="articleStatus" value="1" title="发布"
								checked> <input type="radio" name="articleStatus" value="0"
								title="草稿">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary"
								onclick="getCateIds()">重置</button>
						</div>
					</div>
					<blockquote class="layui-elem-quote layui-quote-nm">
						温馨提示：<br> 1、文章内容的数据表字段类型为MEDIUMTEXT,每篇文章内容请不要超过500万字 <br>
						2、写文章之前，请确保标签和分类存在，否则可以先新建；请勿刷新页面，博客不会自动保存 <br> 3、插入代码前，可以点击 <a
							href="javascript:void(0)" target="_blank">代码高亮</a>,将代码转成HTML格式
					</blockquote>
				</form>
				</div>
		</div>
				
			</rapid:override>
			
			<rapid:override name="frame-script">
			    <script>
			        layui.use(['form', 'laydate'], function() {
			            var form = layui.form
			                , layer = layui.layer
			                , laydate = layui.laydate;
			
			
			         
			            layui.use('code', function() { //加载code模块
							layui.code();
						});
			       
			
			            //自定义验证规则
			            form.verify({
			                title: function (value) {
			                    if (value.length < 5) {
			                        return '标题至少得5个字符啊';
			                    }
			                }
			                , pass: [/(.+){6,12}$/, '密码必须6到12位']
			                , content: function (value) {
			              
			                }
			            });
			
			  
			
			           
			
			            //二级联动,将来要重写
			            form.on("select(articleParentCategoryId)",function () {
			                var optionstring = "";
			                var articleParentCategoryId = $("#articleParentCategoryId").val();
			                <c:forEach items="${category}" var="c1">
							if (articleParentCategoryId == 0) {
								optionstring += "<option name='childCategory' value='${c1.categoryid }'>${c1.categoryname }</option>";
								}
							<c:forEach items="${c1.category}" var="c2">
							if (articleParentCategoryId == ${c1.categoryid }) {
								optionstring += "<option name='childCategory' value='${c2.categoryid }'>${c2.categoryname }</option>";
													}
													</c:forEach>
													</c:forEach>
			                $("#articleChildCategoryId").html("<option value=''selected>二级分类</option>"+optionstring);
			                form.render('select'); //这个很重要
			            });
			       });
			
			    </script>
	 <link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
			<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
			<script charset="utf-8" src="resources/kindeditor/kindeditor-all-min.js"></script>  
			<script charset="utf-8" src="resources/kindeditor/lang/zh-CN.js"></script>
			<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
			<script>
						KindEditor.ready(function(K) {
							var editor1 = K.create('textarea[id="content"]', {   //指向了页面中 id=content 的那个元素 
						      //cssPath : '../plugins/code/prettify.css',
								uploadJson : '../jsp/upload_json.jsp',
								fileManagerJson : '../jsp/file_manager_json.jsp',
								allowFileManager : true,
								width:"1100xp",
								height:"420xp"
							});
							
							prettyPrint();
						});
				</script>
			 
			</rapid:override>
<%@ include file="../framework.jsp" %>