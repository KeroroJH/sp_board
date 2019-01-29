<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>
<style>

.replyPageNavi li{
  list-style: none;
  float: left; 
  padding: 3px; 
  border: 1px solid blue;
  margin:3px;  
}
.replyPageNavi li.active{
  border: 1px solid red;
}
.reply li{
  margin:5px;
}

</style>
<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

<form role="form" method="post">

	<input type='hidden' name='bno' value="${boardVO.bno}">
	<input type='hidden' name='page' value="${pageinfo.page} }">

</form>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label> <input type="text"
			name='title' class="form-control" value="${boardVO.title}"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="exampleInputPassword1">Content</label>
		<textarea class="form-control" name="content" rows="3"
			readonly="readonly">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label> <input type="text"
			name="writer" class="form-control" value="${boardVO.writer}"
			readonly="readonly">
	</div>
</div>
<!-- /.box-body -->

<div class="box-footer">
	<button class="btn btn-warning">Modify</button>
	<button class="btn btn-danger">REMOVE</button>
	<button class="btn btn-primary">LIST</button>
</div>


<script>

$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$(".btn-warning").on("click", function(){
		formObj.attr("action", "/board/modify");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$(".btn-danger").on("click", function(){
		if(! confirm("delete?"))
			return;
		$.ajax({
			  url: "/board/remove",
			  data: $(formObj).serialize(),
			  type: "POST",
			  success : function(data){
				if(data == 1){
					alert("success");
					location.href = "listPage${pageinfo.makeQueryUri()}";
					}else{
							alert("fail"); 
							location.reload();
						  }
				}
		});
	});
	
	$(".btn-primary").on("click", function(){
		self.location = "listPage${pageinfo.makeQueryUri()}";
	});
	
});

</script>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>

<section class="reply">
	<div style="margin:20px;">
		<input type="text" name="replyer" style="width:300px;height:30px;font-size:20px; display:block;" placeholder="name">
		<input type="text" name="replyMsg" style="width:300px;height:100px;font-size:20px;" placeholder="content">
		<input type="button" name="replySend" value="send">
	</div>
	<div>
		<ul class="ul-reply">
			<li></li>
		</ul>
		<ul class='replyPageNavi'></ul>
	</div>
	<script>
	$(document).ready(function(){
		//replyLoad
		getReplyPage(${boardVO.bno}, 1);
		
		//replyNavigationFunctionLoad
		$('.replyPageNavi').on("click", "li a", function(event){
			event.preventDefault();
			getReplyPage(${boardVO.bno}, $(this).text());
		});
	});
	
	//replyRegist
	$('input[name=replySend]').click(function(){
		let replyer = $('input[name=replyer]').val();
		let replytext = $('input[name=replyMsg]').val();
		$.ajax({
			type : 'POST',
			url : '/replies/',
			headers : {
				'Content-Type' : 'application/json',
				'X-HTTP-Method-Override' : 'POST'
			},
			dataType : 'text',
			data : JSON.stringify({
				bno : ${boardVO.bno},
				replyer : replyer,
				replytext : replytext
			}),
			success : function(result) {
				if(result == 1) {
					getReplyPage(${boardVO.bno}, 1);
				}
			}
		});
	});
	
	function getReplyPage(bno, page){
		$.getJSON("/replies/"+bno+"/"+page, function(data){
			let str = "";
			$(data.list).each(function(){
				str += "<li>"+ this.replyer +"//"+ this.replytext +"</li>";
			});
			$('.ul-reply').html(str);
			printPaging(data.pageMaker);
		});
	}
	function printPaging(pageMaker) {
		var str = "";
		if(pageMaker.prev){
			str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
		}
		for(var i=pageMaker.startPage, len = pageMaker.endPage; i <= len; i++){				
				var strClass= pageMaker.pageinfo.page == i?'class=active':'';
			  str += "<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>";
		}
		if(pageMaker.next){
			str += "<li><a href='"+(pageMaker.endPage + 1)+"'> >> </a></li>";
		}
		$('.replyPageNavi').html(str);	
	}
	</script>
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<%@include file="../include/footer.jsp"%>
