var localHost = window.location.host;
// localHost = "192.168.0.213";
var URL = "http://" + localHost + ":20890/";




var nodeId;
var selectId;
var scoreResult;
var method = null; //当前页面数据的状态
// var isReadly;

$(function() {

	var params = decodeURI(window.location.search); //（?xxx=ddd&xxx=ddd）
	console.log(params)
	if (params) {
		//从params中获取method的参数值
		var urlValues = params.split("?")[1].split("&"); //xxx=dd,xxx=dd数组
		for (var i=0;i<urlValues.length;i++) {
			var urlValue = urlValues[i];
			var proName = urlValue.split("=")[0]; //属性名
			var proValue = urlValue.split("=")[1]; //属性值
			if (proName == "method") {
				method = proValue;
			}
			if (proName == "id") {
				nodeId = proValue;
			}
			if (proName == "selectId") {
				selectId = proValue;
			}
		}
	}

	switch (method) {
		case 'watch':
			getScoreResultToOneRecord();
			break;
		default:
			layui.use(['rate'], function() {
				var rate = layui.rate;
				//显示文字
				rate.render({
					elem: '#scoreId',
					value: 0, //初始值
					text: true, //开启文本
					readonly: false,
					theme: "#f31111",
					choose: function(value) {
						$('#scoreId').attr('scoreResult', value);
					}
				});
			});
			break;
	}

	/* if (params) { //不可编辑状态
		console.log(params)
		nodeId = params.split('&')[0].split('=')[1];
		selectId = params.split('&')[3].split('=')[1];
		getScoreResultToOneRecord();
	} else { //可编辑状态
		layui.use(['rate'], function() {
			var rate = layui.rate;
			//显示文字
			rate.render({
				elem: '#scoreId',
				value: 0, //初始值
				text: true, //开启文本
				readonly: false,
				theme: "#f31111",
				choose: function(value) {
					$('#scoreId').attr('scoreResult', value);
				}
			});
		});

	} */

})



/* -----------------ajax请求----------------------------------- */

//保存评分控件设置
function saveScoreInfo(param) {
	/* {
		"nodeId":"1078",
		"selectId":"22",
		"scoreResult":"4"
	}
	 */
	$.ajax({
		url: URL + 'scoreFacade/saveScoreInfo',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {}
	})

}
//删除评分信息
function deleteScoreInfo(param) {
	//[32,34]
	$.ajax({
		url: URL + 'scoreFacade/deleteScoreInfo',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {



		}
	})


}

//查询单条记录的评分结果
function getScoreResultToOneRecord() {
	/* 	{
			"nodeId": "1077",
			"selectId": "23"
		} */

	console.log(selectId);

	$.ajax({
		url: URL + 'scoreFacade/getScoreResultToOneRecord?nodeId=' + nodeId + '&selectId=' + selectId,
		/* type: 'GET',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param), */
		success: function(res) {

			if (res.status == "200") {
				scoreResult = res.msg;
				// alert(isReadly)
				// $('#scoreArea').append('<div id="scoreId"></div>');
				layui.use(['rate'], function() {
					var rate = layui.rate;
					//显示文字
					rate.render({
						elem: '#scoreId',
						value: scoreResult, //初始值
						text: true, //开启文本
						readonly: true,
						theme: "#f31111",
						choose: function(value) {
							/* scoreResult = value;
							var param = {
								"nodeId": nodeId,
								"selectId": selectId,
								"scoreResult": scoreResult
							}
							saveScoreInfo(param) */
						}
					});
				});


			}





		}
	})


}


//查询当前数据源下，各级评分的人数。
function getScoreResultAndRecordCount() {
	//?nodeId=1078
	$.ajax({
		url: URL + 'scoreFacade/getScoreResultAndRecordCount?nodeId=' + nodeId,
		/* type: 'GET',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param), */
		success: function(res) {}
	})
}


//查询当前数据源该级分数下所有记录id
function getSelectIdByNodeIdAndscoreResult() {

	/* 	{
			"nodeId": "1077",
			"scoreResult": "3"
		} */


	$.ajax({
		url: URL + 'scoreFacade/getSelectIdByNodeIdAndscoreResult?nodeId=' + nodeId +
			'&scoreResult=' + scoreResult,
		success: function(res) {



		}
	})


}
