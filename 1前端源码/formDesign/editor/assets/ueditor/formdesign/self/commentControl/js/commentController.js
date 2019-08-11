$(".btn_send").on('click', function() {
	var now = time()
	//获取评论信息
	var text_send = $("#text_send").val();
	if (text_send == "") {
		return false;
	}

	//曾智宏
	// 	alert(text_send);
	// 	alert(now);
	var nodeId = $("#nodeId").val();
	var selectId = $("#selectId").val();
	var Cuid = $("#Cuid").val();
	// alert("这里是comm/*  */entCnt=="+Cuid);
	var data = {
		"nodeId": nodeId,
		"selectId": selectId,
		/* "pubUser": "范德萨发", */
		"pubContent": text_send,
		"pubTime": now,
		"uid": Cuid
	}

  //
  //return false;

	$.ajax({ // 这是 修改 功能要使用的 把id的数据获取。?nodeId='+nodeId+'&selectId='+selectId
		url: prevent_HOST + 'commentFacade/releaseComment',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(data),
		success: function(res) {
			// alert(res.status);
			var msg = res.msg;

			getComment(nodeId, selectId);

		}
	})








	/* var html;
	html = '<div class="col-md-12 col-sm-12 col-xl-12 one cont">'+
				'<div class="col-md-10 col-sm-10 col-xl-12 one commentContent">'+
				'<div class="comment-right">'+
					'<div style="display: inline-block;">匿名</div>'+
					'<div class="comment-content-header three" style="float: right;">'+
						'<span><i class="glyphicon glyphicon-time two"></i>'+now+'</span>&nbsp;&nbsp;&nbsp;&nbsp;'+
					'</div>'+
					'<p class="tent" style="margin:10px">'+text_send+'</p>'+

				'</div>'+
			'</div>';
	$(".tent_info").append(html);
	$(".text_send").val(""); */
})










$(".content_text").show();
$(".tent_info").on('click', '.btn_back', function() {

	var back_time = time()


	//获取评论信息
	var con_back = $(this).parent().parent().parent().find("#con_back").val();
	if (con_back == "") {
		return false;
	}




	var html_back;
	html_back = '<div class="reply">' +
		'<div class="three">' +
		'<a class="replyname">匿名</a>:<span >@brother</span><span>' + back_time + '</span>' +
		'</div>' +
		'</div>' +
		'<p><span>' + con_back + '</span></p>';
	$(this).parent().parent().parent().find(".reply-list").append(html_back);
	$(this).parent().parent().parent().find("#con_back").val("");
})

//评论提交
function time() {
	function time(s) {
		return s < 10 ? '0' + s : s;
	}
	var myDate = new Date();
	//获取当前年
	var year = myDate.getFullYear();
	//获取当前月
	var month = myDate.getMonth() + 1;
	//获取当前日
	var date = myDate.getDate();
	var h = myDate.getHours(); //获取当前小时数(0-23)
	var m = myDate.getMinutes(); //获取当前分钟数(0-59)
	var s = myDate.getSeconds();
	return year + '-' + time(month) + "-" + time(date) + " " + time(h) + ':' + time(m) + ":" + time(s);
}


//获取该记录的评论信息
function getComment(nodeId, selectId) {
	$.ajax({ // 这是 修改 功能要使用的 把id的数据获取。?nodeId='+nodeId+'&selectId='+selectId
		url: prevent_HOST + 'commentFacade/getComment?nodeId=' + nodeId + '&selectId=' + selectId,
		type: 'GET',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		/* data: data1, */
		success: function(res) {
			// alert(res.status);
			var msg = res.msg;

			$("#commentArea").empty();
			if (res.status == "200" && msg.length != null && msg.length != 0) {
				var html;
				// alert(msg.length)
				for (var i = 0; i < msg.length; i++) {
					html = '<div class="col-md-12 col-sm-12 col-xl-12 one cont">' +
						'<div class="col-md-10 col-sm-10 col-xl-12 one commentContent">' +
						'<div class="comment-right">' +
						'<div style="display: inline-block;">' + msg[i].pubUser + '</div>' +
						'<div class="comment-content-header three" style="float: right;">' +
						'<span><i class="glyphicon glyphicon-time two"></i>' + msg[i].pubTime + '</span>&nbsp;&nbsp;&nbsp;&nbsp;' +
						'</div>' +
						'<p class="tent" style="margin:10px">' + msg[i].pubContent + '</p>' +
						'</div>' +
						'</div>';

					$("#commentArea").append(html);

				}
			}

			$(".text_send").val("");
		}
	})


}
