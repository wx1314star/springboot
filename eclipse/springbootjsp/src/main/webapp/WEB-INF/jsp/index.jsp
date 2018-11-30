<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-image: none;">
	<div class="body_wrap">
		<div class="container">
			<div class="alert alert-success text-center" role="alert">Spring
				Boot学习资源大奉送，爱我就关注嘟嘟公众号：嘟爷java超神学堂</div>
			<table class="table table-striped table-bordered">
				<tr>
					<td>作者</td>
					<td>教程名称</td>
					<td>地址</td>
				</tr>
				<c:forEach var="learn" items="${learnList }">
					<tr class="text-info">
						<td>${learn.author}</td>
						<td>${learn.title}</td>
						<td><a href="${learn.url}"
							class="btn btn-search btn-green" target="_blank"><span>点我</span></a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>