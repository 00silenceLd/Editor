var localHost = window.location.host;
// localHost = "192.168.0.213";
var URL = "http://" + localHost + ":20890/";


var setting = {
	data: {
		simpleData: {
			enable: true
		}
	},
	view: {
		selectedMulti: true
	},
	edit: {
		enable: true,
		showRemoveBtn: false,
		showRenameBtn: false,
		drag: {
			isCopy: false
		}
	},
	callback: {
		beforeDrag: beforeDrag,
		beforeDrop: beforeDrop,
		onDrop: onDrop,
		onRename: onRename,
		onClick: showD
	}
};


//这是进行拖拽之前的函数
function beforeDrag(treeId, treeNodes) {
	// console.log("treeId=" + treeId)
	return true;
}

//这是拖拽结束之前的函数
function beforeDrop(treeId, treeNodes, targetNode, moveType) {
	// console.log(targetNode.id);
	//不能将节点移动到数据节点下
	if (targetNode.id == null) {
		return false;
	}
	return targetNode ? targetNode.drop !== false : true;
}

//这是拖拽结束之后的函数
function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
	var param;
	var classifyNodeList = [];
	for (var i = 0; i < treeNodes.length; i++) {
		var treeNode = treeNodes[i];
		var id = treeNode.id;
		var c = {
			"id": id,
			"pId": targetNode.id
		}
		classifyNodeList.push(c);
	}
	param = {
		"nodeId": nodeId,
		"classifyNodeList": classifyNodeList
	}
	updateClassify(param);
	return true;
}

//这是名字修改之后结束之后的函数
function onRename(event, treeId, treeNode, isCancel) {
	var id = treeNode.id;

	var param;
	var classifyNodeList = [{
		"id": id,
		"nodeName": treeNode.name
	}];
	param = {
		"nodeId": nodeId,
		"classifyNodeList": classifyNodeList

	}
	updateClassify(param)
	return true;
}

//点击节点的回调函数
function showD(event, treeId, treeNode, clickFlag) {
	if (treeNode.id != null) return false;
	/* $("#showDataIframeId").attr("src","showData/classifyTableData.html");
	$("#showDataIframeId").attr("tableCnName",treeNode.tableCnName);
	$("#showDataIframeId").attr("tableName",treeNode.tableName);
	$("#showDataIframeId").attr("dataTableId",treeNode.dataTableId);
	$("#showDataIframeId").attr("fields",treeNode.fields); */

	$("#showDataIframeId").attr("src", "showData/classifyTableData.html");
	$("#showDataIframeId").attr("tableCnName", treeNode.tableCnName);
	$("#showDataIframeId").attr("tableName", treeNode.tableName);
	$("#showDataIframeId").attr("dataTableId", treeNode.dataTableId);
	$("#showDataIframeId").attr("fields", treeNode.fields);


	console.log(treeNode);

}








var treeId;
var nodeId;
var isWhat;
// isWhat = "one";
// isWhat = "two";

window.onload = function() {
	// nodeId = window.location.search.split("?")[1].split("&")[0].split("=")[1];
	isWhat = window.location.search.split("?")[1].split("&")[1].split("=")[1];
	// isWhat = "two";
	// isWhat = "one"; 

	switch (isWhat) {
		case "one":
			nodeId = window.location.search.split("?")[1].split("&")[0].split("=")[1];
			break;
		case "two":
			nid = window.location.search.split("?")[1].split("&")[0].split("=")[1];
			getClassifyByNodeId(nid);
			break;
	}
	// var nid;
	// 	if (isWhat == "two") {
	// 		nid = 20126;
	// 		getClassifyByNodeId(nid);
	// 	}

	// if (isWhat == "two") $("#addLeaf").hide();

	// $("#addLeaf").hide();
	// nodeId = 20052;
	// nodeId = 20084;
	// 	alert(nodeId);
	// 	alert(isWhat);

	//初始化树形图

	if (nodeId != undefined) {
		initTree(nodeId);
	}




	$("#addParent").bind("click", {
		isParent: true
	}, addClassifyNode);
	$("#addLeaf").bind("click", {
		isParent: false
	}, addDataNode);
	$("#edit").bind("click", edit);
	$("#remove").bind("click", remove);
}



var newCount = 1;

function addClassifyNode(e) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		isParent = e.data.isParent,
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
	console.log(treeNode);

	var param;
	var classifyNodeList;
	if (treeNode) {
		classifyNodeList = [{
			"pId": treeNode.id,
			"nodeName": "父节点"
		}];

	} else {
		classifyNodeList = [{
			"pId": 0,
			"nodeName": "父节点"
		}];


	}
	param = {
		"nodeId": nodeId,
		"classifyNodeList": classifyNodeList
	};


	createClassify(param, treeNode, isParent, zTree);
};



function addDataNode(e) {
	$('#dataNodesId').show();
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		isParent = false,
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
	//判断如果父节点是数据节点,的不添加
	// console.log(treeNode);
	if (treeNode != null && treeNode.id == null) return false;
	if (nodes.length == 0) return false;

	getThisTreeDataNode(treeId);
	layui.use('layer', function() {
		var layer = layui.layer;
		layer.open({
			type: 1,
			content: $('#selectDataNodeId'),
			area: ['250px', '200px'],
			offset: 'l',
			btn: ['确认', '取消'],
			closeBtn: 0,
			yes: function(index, layero) {


				//后台添加数据节点
				var dataNodeId = $('#dataNodesId').val();

				if (dataNodeId == "" || dataNodeId == null || dataNodeId == undefined) {
					layer.close(index);
					$('#dataNodesId').hide();
					return false;
				}


				// alert(dataNodeId);


				var dataNodeName = $('option[value=' + dataNodeId + ']').text();
				var tableCnName = $('option[value=' + dataNodeId + ']').attr('tableCnName');
				var tableName = $('option[value=' + dataNodeId + ']').attr('tableName');
				var dataTableId = $('option[value=' + dataNodeId + ']').attr('dataTableId');
				var fields = $('option[value=' + dataNodeId + ']').attr('fields');
				var treeId = $('option[value=' + dataNodeId + ']').attr('treeId');

				// alert(fields)
				var param = [{
					"id": dataNodeId,
					"pId": treeNode.id
				}];
				// alert(treeNode.id)

				moveDataNode(param);

				//前端添加数据节点
				if (treeNode) {
					treeNode = zTree.addNodes(treeNode, {
						id: null,
						pId: treeNode.id,
						name: dataNodeName,
						tableCnName: tableCnName,
						tableName: tableName,
						dataTableId: dataTableId,
						fields: fields,
						treeId: treeId,
						thisId: dataNodeId,
						isParent: false
					});
				}
				// console.log(treeNode);
				layer.close(index);

				$('#dataNodesId').hide();

			},
			btn2: function(index, layero) {
				// alert("这是启取消")
				layer.close(index);
				$('#dataNodesId').hide();
			}
		});
	});
};


//修改名字点击事件
function edit() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getSelectedNodes(),
		treeNode = nodes[0];
	if (nodes.length == 0) {
		alert("请先选择一个节点");
		return;
	}
	zTree.editName(treeNode);
};




//删除点击事件
function remove(e) {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getSelectedNodes();
	// treeNode = nodes[0];
	if (nodes.length == 0) {
		alert("请先选择一个节点");
		return;
	}
	//将选择节点中的分类节点与数据节点区分开来,并把id保存在各自数组中,父节点
	var idTemp;
	var classifyNodeParam = [];
	for (var i = 0; i < nodes.length; i++) {
		var treeNode = nodes[i];
		idTemp = {
			"id": treeNode.id
		}
		//为分类节点
		classifyNodeParam.push(idTemp);

	}
	//删除子节点
	for (var i = 0; i < nodes.length; i++) {
		var treeNode = nodes[i];
		//递归children
		var allNode = getChildrenObj(treeNode);
		for (var l = 0; l < allNode.length; l++) {
			var node = allNode[l];
			//为分类节点
			idTemp = {
				"id": node.id
			}
			classifyNodeParam.push(idTemp);

		}
	}

	console.log("classifyNodeParam=" + classifyNodeParam);

	var param = {
		"nodeId": nodeId,
		"classifyNodeList": classifyNodeParam
	}

	//各数组若不为零,就发送请求
	if (classifyNodeParam.length != 0) deleteClassify(param);

	//删除前端页面节点
	for (var i = 0; i < nodes.length; i++) {
		var node = nodes[i];
		zTree.removeNode(node, false);
	}
};


//递归获取所有子节点对象
function getChildrenObj(treeNode) {
	var allnode = [];

	var chilNodes = treeNode.children;
	if (chilNodes != null) {
		for (var i = 0; i < chilNodes.length; i++) {
			var children = chilNodes[i];
			allnode.push(children);
			var no = getChildrenObj(children);
			if (no.length != 0) {
				for (var l = 0; l < no.length; l++) {
					allnode.push(no[l]);
				}
			}
		}
	}

	return allnode;
}






/* --------------------ajax请求方法--------------------------- */




//初始化树形
function initTree(nodeId) {
	$.ajax({
		url: URL + 'classifyFacade/getAllClassifyNodeByNodeId?nodeId=' + nodeId,
		// type: 'POST',
		// 					dataType: 'json',
		// 					contentType: 'application/json; charset=UTF-8',
		// data: JSON.stringify(data),
		success: function(res) {
			// alert(res.status);

			if (res.status == "200") {
				var classifyNodes = res.msg;
				if (classifyNodes.length != 0) {
					var zNodes = [];
					//遍历返利的树形图
					for (var i = 0; i < classifyNodes.length; i++) {
						var classifyNode = classifyNodes[i];
						// var dataNodeList = classifyTrees[i].dataNodeList;
						console.log(classifyNode.nodeName)
						//遍历每一个树形图中的分类节点
						var zNode;
						zNode = {
							id: classifyNode.id,
							pId: classifyNode.pId,
							name: classifyNode.nodeName,
							isParent: true
						};
						zNodes.push(zNode);

					}

					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				} else {

					var param = {
						"nodeId": nodeId,
						"classifyNodeList": [{
							"pId": 0,
							"nodeName": "父节点1"
						}, {
							"pId": 0,
							"nodeName": "父节点2"
						}, {
							"pId": 0,
							"nodeName": "父节点3"
						}, {
							"pId": 0,
							"nodeName": "父节点4"
						}]
					}

					createClassify(param, null, null, null);
					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				}


			}

		}
	})
}



//获取当前树形图下所有数据节点
function getThisTreeDataNode(treeId) {
	// treeId = 2;
	$.ajax({
		url: URL + 'classifyFacade/getThisTreeDataNode?treeId=' + treeId,
		// type: 'POST',
		// 					dataType: 'json',
		// 					contentType: 'application/json; charset=UTF-8',
		// data: JSON.stringify(data),
		success: function(res) {
			var dataNodes = res.msg;

			$('#dataNodesId').empty();

			if (dataNodes.length == 0) return false;


			var option = '<option value="">请选择...</option>';
			for (var i = 0; i < dataNodes.length; i++) {
				var dataNode = dataNodes[i];
				option += '<option value="' + dataNode.id + '" tableCnName="' + dataNode.tableCnName + '" tableName="' +
					dataNode.tableName + '" dataTableId="' + dataNode.dataTableId + '" fields="' + dataNode.fields +
					'" treeId="' + dataNode.treeId + '">' + dataNode.nodeName + '</option>'

			}

			$('#dataNodesId').append(option);



		}
	})

}

//创建分类节点
function createClassify(param, treeNode, isParent, zTree) {
	// 	{
	// 		"nodeId": "1077",
	// 		"classifyNodeList": [{
	// 				"pId": "8",
	// 				"nodeName": "测试节点"
	// 			}
	// 
	// 		]
	// 	}
	var id = 0;
	$.ajax({
		url: URL + 'classifyFacade/createClassify',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {
			var status = res.status;
			if (status == "200") {
				// var nodeId = 1077;
				// initTree(nodeId);
				var ids = res.msg;

				if (treeNode != null) {
					if (treeNode) {
						//该树形图id
						treeNode = zTree.addNodes(treeNode, {
							id: ids[0],
							pId: treeNode.id,
							isParent: isParent,
							name: "父节点"
						});
					} else {
						treeNode = zTree.addNodes(null, {
							id: ids[0],
							pId: 0,
							isParent: isParent,
							name: "父节点"
						});
					}
				}
			}

		}
	})



}


//修改分类节点
function updateClassify(param) {
	//移动就传pId，改名就传nodeName

	/* {
		"nodeId": "1077",
		"classifyNodeList": [{
				"id": "22",
				"pId": "8",
				或者 "nodeName": "测试节点"
			}

		]
	} */
	$.ajax({
		url: URL + 'classifyFacade/updateClassify',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {

		}
	})

}


//移动数据节点
function moveDataNode(param) {
	// 				param = [{
	// 						"id": "88",
	// 						"pId": "24"
	// 					},
	// 					{
	// 						"id": "90",
	// 						"pId": "24"
	// 					}
	// 				];
	$.ajax({
		url: URL + 'classifyFacade/moveDataNode',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {

		}
	})
}

//删除分类节点
function deleteClassify(param) {
	/* {
		"nodeId": "1077",
		"classifyNodeList": [{
				"id": "22"
			}
		]
	} */
	$.ajax({
		url: URL + 'classifyFacade/deleteClassify',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {

		}
	})
}

//删除数据节点
function deleteDataNode(param) {
	// param = [28, 30];
	$.ajax({
		url: URL + 'classifyFacade/deleteDataNode',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {

		}
	})
}

//删除树形图
function deleteClassifyTree(param) {
	// param = [28, 30];
	$.ajax({
		url: URL + 'classifyFacade/deleteClassifyTree',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {

		}
	})
}









//修改数据节点名字
function renameDataNode(param) {
	/* 	 param = {
				"id":"2",
				"nodeName":"恐怖片"
			}; */
	$.ajax({
		url: URL + 'classifyFacade/renameDataNode',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {

		}
	})
}


//修改数据节点名字
function getClassifyByNodeId(nid) {
	/* 	 param = {
				"id":"2",
				"nodeName":"恐怖片"
			}; */
	$.ajax({
		url: URL + 'classifyFacade/getClassifyByNodeId?nodeId=' + nid,
		/* type: 'GET',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param), */
		success: function(res) {
			if (res.status == "200") {
				var classifySource = res.msg;
				console.log(classifySource);
				if (classifySource.length != 0) {
					$("#selectClassify").append("<option value=''>请选择。。。</option>");
					for (var i = 0; i < classifySource.length; i++) {

						$("#selectClassify").append("<option value=" + classifySource[i].nodeId + ">" + classifySource[i].treeName +
							"</option>");

					}



				}
			}
		}
	})
}




$("#selectClassify").change(function() {
	nodeId = $("#selectClassify").val();

	initTree(nodeId);

})
