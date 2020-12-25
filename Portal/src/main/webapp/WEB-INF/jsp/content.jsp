<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>MrGeek</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="resources/MrGeek_files/bootstrap.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="resources/MrGeek_files/hux-blog.css">
</head>

</head>
<body>
	<%-- 	<c:forEach items="${fileContentList}" var="fileContent" varStatus="sta"> --%>
	<!-- 		<tr align="center"> -->
	<!-- 			<br> -->
	<!-- 			<br> -->
	<!-- 			<br> -->
	<!-- 			<td> -->
	<%-- 				${sta.index+1} --%>
	<!-- 			</td> -->
	<%-- 			<td>${fileContent}</td> --%>
	<!-- 		</tr>				 -->
	<%-- 	</c:forEach> --%>

	<c:forEach items="${fileContentList}" var="fileContent" varStatus="sta">
		<tr align="center">
			<br>
			<br>
			<br>
			<td>${sta.index+1}</td>
			<td>
				<div class="container">
					<div class="post-preview">
						<a
							href="https://mrgeek-zrh.gitee.io/2020/10/17/solr%E5%8D%95%E6%9C%BA%E7%89%88-%E9%85%8D%E7%BD%AE%E4%B8%AD%E6%96%87%E5%88%86%E6%9E%90%E5%99%A8-%E8%87%AA%E5%AE%9A%E4%B9%89%E4%B8%9A%E5%8A%A1%E5%9F%9F/">

							<div class="post-content-preview">${fileContent}</div>
						</a>
					</div>
					<hr>
					<hr>
				</div>
			</td>
		</tr>
	</c:forEach>

</body>
</html>