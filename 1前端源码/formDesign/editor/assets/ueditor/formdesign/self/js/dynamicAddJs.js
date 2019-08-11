$(function() {
	//根据/folder/staticPage/dzzfbtpc.html?static=1中 static参数，动态添加该页面的js文件
	
	
	
	/* 	if (!window.location.search) {
			if (nodeId == null && window.opener) { // 在百度编辑器按 预览 进来的
				nodeId = $('#node_id', window.opener.document).val();
			}
	
		} */
		var thisUrl = window.location.href;
		var catalos = thisUrl.split('/');//目录
	if(catalos[catalos.length-1]=='preview.html'){//如果是预览页面，就添加js文件
		// $('head').append('<script id="ueditorParseJs" src="../ueditor.parse.js"></script><script id="ueditorConfigJs" src="../ueditor.config.js"></script><script id="ueditorAllJs" src="../ueditor.all.js"></script><script id="isMobileJs" src="./self/js/isMobile.js"></script><script id="funJs" src="./self/js/fun.js"></script><script id="use_top_previewJs" src="./self/js/use_top_preview.js"></script><script id="use_bottom_previewJs" src="./self/js/use_bottom_preview.js"></script><script id="preview_logicJs" src="./self/js/preview_logic.js"></script><script id="preview_other_configJs" src="./self/js/preview_other_config.js"></script>');
	}
	
	// $.ajax({
	// 	type: "GET",
	// 	url: DEFAULT_URL + "pageDesignQueryFacade/getPageContent?id=" + nodeId,
	// 	contentType: "application/json; charset=UTF-8",
	// 	success: function(data) {
	// 		var json = JSON.stringify(data);
	// 		var jsonObj = JSON.parse(json);
	// 		var dataArray = jsonObj.msg.data;
	// 		if (dataArray.length == 0) {
	// 			$('head').append('<script src="./self/md5/jquery.md5.js"></script>' +
	// 				'<script src="./self/rsa/RSA.js"></script>' + '<script src="../httpData.config.js"></script>' +
	// 				'<script src="../ueditor.parse.js"></script>' + '<script src="../ueditor.config.js"></script>' +
	// 				'<script src="../ueditor.all.js"></script>' + '<script src="./self/js/isMobile.js"></script>' +
	// 				'<script src="./self/js/fun.js"></script>' + ' <script src="./self/js/use_top_preview.js"></script>' +
	// 				'<script src="./self/js/use_bottom_preview.js"></script>' +
	// 				'<script src="./self/js/preview_logic.js"></script>' +
	// 				'<script src="./self/js/preview_other_config.js"></script>');
	// 		}
	// 	}
	// });





})
