$(function() {

	$('.sidebarnavtoCla').each(function(i, n) {
		if (i == 0) { //首页链接赋值
			$(n).css('background', 'red');
			$(n).css('color', 'white');

			var leftNavToPage = $(n).attr('leftnavtopage');
			var nodeId = leftNavToPage.split(':')[0];
			var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
			$('#rightContentId').attr('src', toj);
		}
	})

  //选择蓝色
  $('.sidebarnavtoCla2').each(function(i, n) {
  	if (i == 0) { //首页链接赋值
  		$(n).css('background', 'skyblue');
  		$(n).css('color', 'white');

  		var leftNavToPage = $(n).attr('leftnavtopage');
  		var nodeId = leftNavToPage.split(':')[0];
  		var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
  		$('#rightContentId').attr('src', toj);
  	}
  })





	var ht = $('#rightContentId').contents().find("body").height() + 40;
	ht = 800;
	$('#rightContentId').attr('height', ht < 600 ? 600 : ht);


	setTimeout(s12138(), 500); //给iframe中的页面元素赋事件




	console.log("sidebarnav")


	$('.sidebarnavtoCla').on('click', function() {
		$('.sidebarnavtoCla').css('background', 'white');
		$('.sidebarnavtoCla').css('color', 'black');
		$(this).css('background', 'red');
		$(this).css('color', 'white');


		var leftNavToPage = $(this).attr('leftnavtopage');
		var nodeId = leftNavToPage.split(':')[0];
		var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
		$('#rightContentId').attr('src', toj);


		setTimeout(s12138(), 500);
	})

  $('.sidebarnavtoCla2').on('click', function() {
  	$('.sidebarnavtoCla2').css('background', 'white');
  	$('.sidebarnavtoCla2').css('color', 'black');
  	$(this).css('background', 'red');
  	$(this).css('color', 'white');


  	var leftNavToPage = $(this).attr('leftnavtopage');
  	var nodeId = leftNavToPage.split(':')[0];
  	var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
  	$('#rightContentId').attr('src', toj);


  	setTimeout(s12138(), 500);
  })
})



function s12138() {
	$('#rightContentId').height(0);
	var iframe = document.getElementById("rightContentId");
	if (iframe.attachEvent) {
		iframe.attachEvent("onload", function() {
			var thisScrollHeight = $('#rightContentId').contents().find(".container").get(0).scrollHeight;
			console.log(thisScrollHeight);
			$('#rightContentId').height(thisScrollHeight);
			//iframe加载完成后你需要进行的操作
			// $('#midContentId').contents().find(".container").attr('onscroll', 'testScroll(this)');
			$('#rightContentId').contents().find("body").on('click', function() {
				setTimeout(s22138(), 1000); //给iframe中的 页面的 a链接 跳转赋事件
			});
		});
	} else {
		iframe.onload = function() {
			var thisScrollHeight = $('#rightContentId').contents().find(".container").get(0).scrollHeight;
			console.log(thisScrollHeight);

			$('#rightContentId').height(thisScrollHeight<900?900:thisScrollHeight);
			//iframe加载完成后你需要进行的操作
			// $('#midContentId').contents().find(".container").attr('onscroll', 'testScroll(this)');
			$('#rightContentId').contents().find("body").on('click', function() {
				//setTimeout(s22138(), 1000); //给iframe中的 页面的 a链接 跳转赋事件
			});
		};
	}
}


function s22138() {
	thisScrollHeight = $('#rightContentId').contents().find(".container").get(0).scrollHeight;
	console.log(thisScrollHeight);
	$('#rightContentId').height(thisScrollHeight<900?900:thisScrollHeight);
	// $('#rightContentId').contents().find(".container").attr('onscroll', 'testScroll(this)');
}
