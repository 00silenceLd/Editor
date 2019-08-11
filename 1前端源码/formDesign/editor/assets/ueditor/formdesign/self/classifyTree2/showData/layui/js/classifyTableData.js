var localHost = window.location.host;
// localHost = "192.168.0.213";
var URL = "http://"+localHost+":20890";



var colArray = [];
// var tableCnName = "这只是个测试节点";
// var tableName = "Zzsgcsjd";
// var dataTableId = "20052";
// var fields = "文本框:zzgg,文本框:wenbenkuang,多行文本框:duoxingwenbenkuang";

var tableName;
var fields;


//向后端传的参数
var fieldStr;


window.onload = function() {
	
	// var oshowDataIframe = window.parent.document.getElementById("showDataIframeId");
	var oshowDataIframe = $("#showDataIframeId" ,window.parent.document);
	tableName = oshowDataIframe.attr("tablename");
	fields = oshowDataIframe.attr("fields");
	
// 	console.log(tableName);
// 	console.log(fields);
	
	initDataTable();
	
	
	
	
}










function initDataTable(){
	layui.use('table', function() {
	
		initLayuiData();
	
	
	
	
		console.log(fieldStr)
		var table = layui.table;
		var tableIns = table.render({
			elem: '#showTableDatatab',
			url: URL + '/classifyFacade/getDataTableData',
			method: "post",
			where: {
				tableName: tableName,
				fields: fieldStr
			},
			contentType: 'application/json',
			response: {
				statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
			},
			parseData: function(res) { //res 即为原始返回的数据
				var msg = res.msg;
	
				var countIndex = msg.length - 1;
				var count = msg[countIndex].count
	
				msg.splice(countIndex, 1);
	
				return {
					"code": res.status, //解析接口状态
					"msg": res.statusMsg, //解析提示文本
					"count": count, //解析数据长度
					"data": msg //解析数据列表
				};
			},
			title: '未审核的评论',
			// cellMinWidth:120,
			cols: [colArray
				/* 
				[{
					type: 'checkbox',
					fixed: 'left'
				}, {
					field: 'username',
					title: '账号',
					width: 120
				}, {
					field: 'chineseName',
					title: '用户名',
					width: 150,
					sort: true
				}, {
					field: 'pubTime',
					title: '发布时间',
					width: 120,
					sort: true
				}, {
					field: 'theme',
					title: '主题',
					width: 120,
					sort: true
				}, {
					field: 'pubContent',
					title: '评论内容',
					width: 700
				}, {
					fixed: 'right',
					title: '操作',
					toolbar: '#barDemo',
					width: 160
				}]
			 */
			],
			page: true,
			toolbar: '#toolbarDemo'
		});
	
		//头工具栏事件
	
		table.on('toolbar(showTableDatatab)', function(obj) {
			var checkStatus = table.checkStatus(obj.config.id);
			switch (obj.event) {
				case 'deleteSelect':
	
					var datas = checkStatus.data;
					var da = []
					if (datas == null || datas.length == 0) return false;
					for (var i = 0; i < datas.length; i++) {
						var pa = {
							"tableName": tableName,
							"id": datas[i].id
						}
						da.push(pa);
					}
	
					console.log(da)
	
	
					deleteTableData(da, tableIns);
	
					break;
	
			};
		});
	
		//监听行工具事件
		table.on('tool(showTableDatatab)', function(obj) {
			var data = obj.data;
			console.log(obj)
			if (obj.event === 'deleteTableData') {
				var da = []
				var pa = {
					"tableName": tableName,
					"id": data.id
				}
				da.push(pa);
	
				console.log(da)
				deleteTableData(da, tableIns);
			}
		});
	
	
		//监听单元格编辑
		table.on('edit(showTableDatatab)', function(obj) {
			var value = obj.value, //得到修改后的值
				data = obj.data, //得到所在行所有键值
				field = obj.field; //得到字段
			// layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
			var fieldsContext = "{'" + field + "':'" + value + "'}";
			var pa = [{
				"tableName": tableName,
				"fields": field,
				"id": data.id,
				"fieldsContext": fieldsContext
			}];
	
			editData(pa);
	
		});
	});
	
}



function initLayuiData() {
	//获取字段和表头
	var cols = fields.split(","); //[文本框:zzgg,文本框:wenbenkuang,多行文本框:duoxingwenbenkuang]
	var f = {
		type: 'checkbox',
		fixed: 'left'
	};
	colArray.push(f);
	//字段信息
	var fieldInfo = [];
	fieldInfo.push("id");
	for (var i = 0; i < cols.length; i++) {
		var col = cols[i]; //"文本框:zzgg"
		var colCnName = col.split(":")[0];
		var colName = col.split(":")[1];
		colName = "swprefix" + colName;
		f = {
			field: colName,
			title: colCnName,
			edit: 'text',
			width: 150
		}
		colArray.push(f);
		fieldInfo.push(colName);
	}
	/* 	if (isEdit) {
			f = {
				fixed: 'right',
				title: '',
				toolbar: '#barDemo',
				width: 65
			};
			colArray.push(f);
		} */
	f = {
		fixed: 'right',
		title: '',
		toolbar: '#barDemo',
		width: 80
	};
	colArray.push(f);

	console.log(colArray);
	fieldStr = fieldInfo.join(",");
	console.log(fieldStr)
}








//编辑记录
function editData(data) {
	/* var data = [{
		"tableName": "Zzsgcsjd",
		"fields": "swprefixzzgg,swprefixwenbenkuang,swprefixduoxingwenbenkuang",
		"id": "102",
		"fieldsContext": "{'swprefixzzgg':'发大发','swprefixwenbenkuang':'发大发','swprefixduoxingwenbenkuang':'CVC'}"
	}]; */


	$.ajax({
		url: URL + '/classifyFacade/updateTableData',
		type: 'POST',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(data),
		success: function(res) {
			// tableIns.reload();
		}
	})


}



function deleteTableData(data, tableIns) {

	/* 	var data = [{
			"tableName": "Zzsgcsjd",
			"id": "102"
		}]
	 */
	$.ajax({
		url: URL + '/classifyFacade/deleteTableData',
		type: 'POST',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(data),
		success: function(res) {
			tableIns.reload();
		}
	})
}



