//$(".container").get(0).scrollHeight;



$(function() {

$('html').css('overflow','auto');
$('.container').css('padding-right','0px')

	//根据themeId中的文本，赋值给页面title
	var theme = $('#themeId').html();
	$('title').html(theme);



	//默认宽高度
	var ht = 900;
	$('#midContentId').attr('height', ht);
	var tempwidth = $(window).width();
	$('#midContentId').attr('width', tempwidth);

	//获取刷新前导航中显示的页面
	// var thisHeaderNavToPage = window.localStorage.getItem("thisHeaderNavToPage");
	var thisHeaderNavToPage = window.sessionStorage.getItem("thisHeaderNavToPage");

	$('.indexcla').each(function(i, n) {
		if (i == 0) { //首页链接赋值
			$(n).css('color', 'red');
			$(n).css('background', 'white');
			var headerNavToPage = $(n).attr('headerNavToPage');
			var nodeId = headerNavToPage.split(':')[0];
			var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
			$('#midContentId').attr('src', toj);
		}

		if ($(n).attr('headerNavToPage') == thisHeaderNavToPage) {
			$('.indexcla').css('color', 'white');
			$('.indexcla').css('background', 'red');
			$(n).css('color', 'red');
			$(n).css('background', 'white');


			//根据themeId中的文本，赋值给页面title
			var theme = $(n).html();
			$('title').html(theme);
			var headerNavToPage = $(n).attr('headerNavToPage');
			var nodeId = headerNavToPage.split(':')[0];
			var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
			$('#midContentId').attr('src', toj);
		}
	})

	setTimeout(s1(), 500);



	$(window).resize(function() { //当浏览器大小变化时
		tempwidth = $(window).width();
		$('#midContentId').attr('width', tempwidth);
	});


	console.log(tempwidth);
})



function indexclaCli(e) {

	//修改该导航栏样式
	$('.indexcla').css('color', 'white');
	$('.indexcla').css('background', 'red');
	$(e).css('color', 'red');
	$(e).css('background', 'white');



	var headerNavToPage = $(e).attr('headerNavToPage');
	var nodeId = headerNavToPage.split(':')[0];
	var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;

	var isJumpToUrl = $(e).attr('isjumptourl');
	if (isJumpToUrl == "on") { //为打开新链接显示
		// window.open(toj);
		window.location.href = toj;
	} else { //为当前页iframe中显示
		$('#midContentId').attr('src', toj);
		//将该导航的目的页面保存进本地存储中
		window.sessionStorage.setItem('thisHeaderNavToPage', headerNavToPage);
	}





	setTimeout(s1(e), 500);
}

function findexclaCli(e) {


	//获取该导航的文本，赋值给title标签
	var thisText = $(e).html();
	$('title').html(thisText);



	var footerNavToPage = $(e).attr('footerNavToPage');
	var nodeId = footerNavToPage.split(':')[0];
	var toj = '/editor/assets/ueditor/formdesign/preview.html?link=' + nodeId;
	// window.open(toj);
	var isJumpToUrl = $(e).attr('isjumptourl');
	if (isJumpToUrl == "on") { //为打开新链接显示
		// window.open(toj);
		window.location.href = toj;
	} else { //为当前页iframe中显示
		$('#midContentId').attr('height', 0);
		$('#midContentId').attr('src', toj);

		//需求：点击底部栏跳转后，头部栏若存在相同内容的导航，则对应的头部栏导航也自动变成点击后状态
		//即footerNavToPage与headerNavToPage相等的时候
		$('.indexcla').each(function(i, n) {
			//遍历出所有头部导航栏的标签，获取其中的headerNavToPage属性的值
			var headerNavToPage = $(n).attr('headerNavToPage');
			if (headerNavToPage == footerNavToPage) { //修改样式
				$('.indexcla').css('color', 'white');
				$('.indexcla').css('background', 'red');
				$(n).css('color', 'red');
				$(n).css('background', 'white');
			}
		})
	}
	setTimeout(s1(e), 500);
}


function s1(e) {
	var iframe = document.getElementById("midContentId");
	if (iframe.attachEvent) {
		iframe.attachEvent("onload", function() {
			$('#midContentId').attr('height', 0);
			// var thisScrollHeight = $('#midContentId').contents().find(".container").get(0).scrollHeight;

			var thisScrollHeight = 0;
			if($('#midContentId').contents().find(".container").get(0)){
				 thisScrollHeight = $('#midContentId').contents().find(".container").get(0).scrollHeight;
			}else{
				 thisScrollHeight = 1100;
			}

			console.log(thisScrollHeight);

			$('#midContentId').attr('height', thisScrollHeight < 900 ? 900 : thisScrollHeight);

			//根据iframe的高度设置滚动条的高度
			$(".container").height(0);
			var winheight = $(".container").get(0).scrollHeight;
			$(".container").height(winheight)


			//iframe加载完成后你需要进行的操作
			$('#midContentId').contents().find("a").on('click', function() {

				setTimeout(s2(), 1000); //给iframe中的 页面的 a链接 跳转赋事件
			});
		});
	} else {
		iframe.onload = function() {
			if (e) {
				//获取该导航的文本，赋值给title标签
				var thisText = $(e).html();
				$('title').html(thisText);
			}



			$('#midContentId').attr('height', 0);

			var thisScrollHeight = 0;
			if($('#midContentId').contents().find(".container").get(0)){
				 thisScrollHeight = $('#midContentId').contents().find(".container").get(0).scrollHeight;
			}else{
				 thisScrollHeight = 1100;
			}

			console.log(thisScrollHeight);

			$('#midContentId').attr('height', thisScrollHeight < 900 ? 900 : thisScrollHeight);

			//根据iframe的高度设置滚动条的高度
			$(".container").height(0);
			var winheight = $(".container").get(0).scrollHeight;
			$(".container").height(winheight)

			//iframe加载完成后你需要进行的操作
			$('#midContentId').contents().find("a").on('click', function() {
				setTimeout(s2(), 1000); //给iframe中的 页面的 a链接 跳转赋事件
			});
		};
	}
}


function s2() {



	$('#midContentId', window.parent.document).attr('height', 0);
	// thisScrollHeight = $('#midContentId').contents().find(".container").get(0).scrollHeight;

	var thisScrollHeight = 0;
	if($('#midContentId').contents().find(".container").get(0)){
		 thisScrollHeight = $('#midContentId').contents().find(".container").get(0).scrollHeight;
	}else{
		 thisScrollHeight = 1100;
	}



	console.log(thisScrollHeight);
	$('#midContentId', window.parent.document).attr('height', thisScrollHeight < 900 ? 900 : thisScrollHeight);


	//根据iframe的高度设置滚动条的高度
	$(".container", window.parent.document).height(0);
	var winheight = $(".container", window.parent.document).get(0).scrollHeight;
	$(".container", window.parent.document).height(winheight)




}



/* $("#midContentId").scroll(function() {
	var thisheight = $("#midContentId").attr('height',);
	console.log(thisheight);
	$("#midContentId").attr('height', thisheight + 100);
}); */


// function GetIframeStatus() {
// 	console.log(123)
// 	var iframe = document.getElementById("midContentId");
// 	var iframeWindow = iframe.contentWindow;
// 	//内容是否加载完
// 	if (iframeWindow.document.readyState == "complete") {
// 		var iframeWidth, iframeHeight;
// 		//获取Iframe的内容实际宽度
// 		iframeWidth = iframeWindow.document.documentElement.scrollWidth;
// 		//获取Iframe的内容实际高度
// 		iframeHeight = iframeWindow.document.documentElement.scrollHeight;
// 		//设置Iframe的宽度
// 		iframe.width = iframeWidth;
// 		//设置Iframe的高度
// 		iframe.height = iframeHeight;
// 	} else {
// 		timeIframe = setTimeout(GetIframeStatus, 1000);
// 	}
// }
//

/* function setIframeattr('height',) {
	var ifm = document.getElementById("midContentId");
	var subWeb = document.frames ? document.frames["midContentId"].document : ifm.contentDocument;
	if (ifm != null && subWeb != null) {
		ifm.style.height = 'auto'; //关键这一句，先取消掉之前iframe设置的高度
		ifm.style.height = subWeb.body.scrollHeight + 'px';
	}
}
 */
