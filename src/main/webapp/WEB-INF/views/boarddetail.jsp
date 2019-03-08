<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="./resources/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="./resources/css/board.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
////ajax좋아요
function like_func(){
	var frm_read = $("#frm_read");
	var b_seq = $('#b_seq').val();
	var m_nick=$('#m_nick').val();
	var b_like=$('#b_like').val();
	var writer=$('#writer').val();

	
	$.ajax({
		url: "like.do",
		data: {'b_seq':b_seq,'m_nick':m_nick,'b_like':b_like,'writer':writer},
		dataType:"json",
		cache: false,
		type:"GET",
		traditional:true,
		success:function(data){
			var msg='';
			msg+=data.msg;
			alert(msg);
			
			if(data.like_check==0){
				$('#like_img').attr('src',"./resources/images/dislike.png");
			}else{
				$('#like_img').attr('src',"./resources/images/like.png");
			}
		},
		error:function(){
			alert("서버에러");
		}
	});
}
</script>

</head>
<body>
<%@include file="header.jsp" %>
<h2 style="text-align:center">게시글 상세보기</h2>
<br /><br />

<form id="frm_read" name="frm_read" method="get">
<input type="hidden" id="b_seq" name="b_seq" value="${dto.b_seq }" />
<input type="hidden" id="m_nick" name="m_nick" value="${sessionScope.member.nickname}" />
<table class="table table-bordered"id="table-container">
	
	<tr>
		<th>작성자</th>
		<td><input type="text" id="writer" name="writer" value="${dto.m_nick}" readonly="readonly" class="form-control"/></td>
	</tr>
	
	<tr>
		<th>제목</th>
		<td><input type="text" value="${dto.b_title}" readonly="readonly" class="form-control" /></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="20" cols="50" readonly="readonly" class="form-control">${dto.b_content}</textarea>
		<div style="text-align:center">
			<a href='javascript:like_func();'><img src="./resources/images/${dto.like_check==1?'like.png':'dislike.png'}" id="like_img" alt="하트사진"></a>Likes		
		</div>
		
		</td>
	</tr>
	<tr>
		<th></th>
		<td colspan="2">
			<div style="text-align:center">
			<c:if test="${sessionScope.member.nickname eq dto.m_nick or sessionScope.member.grade == 'A'}">			
				<button type="button" onclick="updateForm('${dto.b_seq}')" class="btn btn-default" >수정</button>
				<button type="button" onclick="delBoard('${dto.b_seq}')" class="btn btn-default">삭제</button>					
			</c:if>
				<button type="button" onclick="location.href='boardlist.do?page=${cri.page}&pagelist=${pagelist}'" class="btn btn-default">글목록</button>
			</div>
		</td>
	</tr>
</table>
</form>
<br /><br />
<%@include file="reply.jsp" %>


<script type="text/javascript">
	//수정폼으로 이동하는 함수
	function updateForm(b_seq){
		location.href="updateform.do?page=${cri.page}&b_seq="+b_seq;
	}
	//게시글 삭제로 이동
	function delBoard(b_seq){
		location.href="delboard.do?page=${cri.page}&pagelist=${pagelist}&b_seq="+b_seq;
	}
	
</script>
</body>
</html>