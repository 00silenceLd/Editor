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
	for (var i = 0; i < treeNodes.length; i++) {
		var treeNode = treeNodes[i];
		var id = treeNode.id;
		var param = {};
		if (id == null) { //数据节点
			param = [{
				"id": treeNode.thisId,
				"pId": targetNode.id
			}]
			moveDataNode(param);
		} else { //分类节点
			param = [{
				"id": id,
				"pId": targetNode.id
			}]
			moveClassifyNode(param);
		}
	}
	return true;
}

//这是名字修改之后结束之后的函数
function onRename(event, treeId, treeNode, isCancel) {
	var id = treeNode.id;

	var param = {};
	if (id == null) { //数据节点
		param = {
			"id": treeNode.thisId,
			"nodeName": treeNode.name
		}
		renameDataNode(param)
	} else { //分类节点

		param = {
			"id": id,
			"nodeName": treeNode.name
		}
		renameClassifyNode(param)
	}
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
	nodeId = window.location.search.split("?")[1].split("&")[0].split("=")[1];
	isWhat = window.location.search.split("?")[1].split("&")[1].split("=")[1];

	if (isWhat == "two") $("#addLeaf").hide();

	// nodeId = 20052;
	// nodeId = 20084;
// 	alert(nodeId);
// 	alert(isWhat);

	//初始化树形图
	initTree(nodeId);
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
	//判断如果父节点是数据节点,的不添加
	console.log(treeNode);
	var thisTreeId;
	if (treeNode) {
		//该树形图id
		thisTreeId = treeNode.treeId;
		treeNode = zTree.addNodes(treeNode, {
			id: (100 + newCount),
			pId: treeNode.id,
			isParent: isParent,
			name: "new node" + (newCount++)
		});
	} else {
		treeNode = zTree.addNodes(null, {
			id: (100 + newCount),
			pId: 0,
			isParent: isParent,
			name: "new node" + (newCount++)
		});
	}
	var param;
	if (isWhat == "two") {
		param = {
			"pId": treeNode[0].pId ? treeNode[0].pId : 0,
			"nodeName": treeNode[0].name,
			"tree2Id": treeId
		};
	} else {
		param = {
			"pId": treeNode[0].pId ? treeNode[0].pId : 0,
			"nodeName": treeNode[0].name,
			"treeId": treeId
		};
	}


	createClassifyNode(param);
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
	var classifyNodeParam = [];
	var dataNodeParam = [];
	for (var i = 0; i < nodes.length; i++) {
		var treeNode = nodes[i];
		if (treeNode.id == null) { //为数据节点
			dataNodeParam.push(treeNode.thisId);
		} else { //为分类节点
			classifyNodeParam.push(treeNode.id);
		}
	}
	// console.log(classifyNodeParam);
	// console.log(dataNodeParam);
	//删除子节点
	for (var i = 0; i < nodes.length; i++) {
		var treeNode = nodes[i];
		// console.log(treeNode)
		//递归children
		var allNode = getChildrenObj(treeNode);
		// console.log(allNode)
		for (var l = 0; l < allNode.length; l++) {
			var node = allNode[l];
			if (node.id == null) { //为数据节点
				dataNodeParam.push(node.thisId);
			} else { //为分类节点
				classifyNodeParam.push(node.id);
			}

		}
	}

	console.log("classifyNodeParam=" + classifyNodeParam);
	console.log("dataNodeParam=" + dataNodeParam);

	//各数组若不为零,就发送请求
	if (classifyNodeParam.length != 0) deleteClassifyNode(classifyNodeParam);
	if (dataNodeParam.length != 0) deleteDataNode(dataNodeParam);

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


	switch (isWhat) {
		case "one":
			$.ajax({
				url: URL + 'classifyFacade/getThisTreeAllNode?nodeId=' + nodeId,
				// type: 'POST',
				// 					dataType: 'json',
				// 					contentType: 'application/json; charset=UTF-8',
				// data: JSON.stringify(data),
				success: function(res) {
					// alert(res.status);
					var classifyTrees = res.msg;
					treeId = classifyTrees[0].id;
					var zNodes = [];
					//遍历返利的树形图
					for (var i = 0; i < classifyTrees.length; i++) {
						var classifyNodeList = classifyTrees[i].classifyNodeList;
						var dataNodeList = classifyTrees[i].dataNodeList;
						console.log(classifyTrees[i].treeName)
						console.log(classifyNodeList)
						console.log(dataNodeList)
						//遍历每一个树形图中的分类节点
						var zNode;
						for (var g = 0; g < classifyNodeList.length; g++) {
							var classifyNode = classifyNodeList[g];
							zNode = {
								id: classifyNode.id,
								pId: classifyNode.pId,
								name: classifyNode.nodeName,
								treeId: classifyNode.treeId,
								isParent: true
							};
							zNodes.push(zNode);
						}

						for (var l = 0; l < dataNodeList.length; l++) {
							var dataNode = dataNodeList[l];
							if (dataNode.pId == null) continue;
							zNode = {
								id: null,
								pId: dataNode.pId,
								name: dataNode.nodeName,
								tableCnName: dataNode.tableCnName,
								tableName: dataNode.tableName,
								dataTableId: dataNode.dataTableId,
								fields: dataNode.fields,
								treeId: dataNode.treeId,
								thisId: dataNode.id,
								isParent: false
							};
							zNodes.push(zNode);
						}
					}

					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				}
			})

			break;
		case "two":
			$.ajax({
				url: URL + 'classifyFacade/getThisTree02AllNode?nodeId='+nodeId,
				// type: 'POST',
				// 					dataType: 'json',
				// 					contentType: 'application/json; charset=UTF-8',
				// data: JSON.stringify(data),
				success: function(res) {
					// alert(res.status);
					var classifyTree02 = res.msg;
					treeId = classifyTree02.id;
					var zNodes = [];
					//遍历返利的树形图
					var classifyNodeList = classifyTree02.classifyNodeList;
					var dataNodeList = classifyTree02.dataNodeList;
					console.log(classifyTree02.treeName)
					console.log(classifyNodeList)
					console.log(dataNodeList)
					//遍历每一个树形图中的分类节点
					var zNode;
					for (var g = 0; g < classifyNodeList.length; g++) {
						var classifyNode = classifyNodeList[g];
						zNode = {
							id: classifyNode.id,
							pId: classifyNode.pId,
							name: classifyNode.nodeName,
							treeId: classifyNode.treeId,
							isParent: true
						};
						zNodes.push(zNode);
					}

					for (var l = 0; l < dataNodeList.length; l++) {
						var dataNode = dataNodeList[l];
						if (dataNode.pId == null) continue;
						zNode = {
							id: null,
							pId: dataNode.pId,
							name: dataNode.nodeName,
							tableCnName: dataNode.tableCnName,
							tableName: dataNode.tableName,
							dataTableId: dataNode.dataTableId,
							fields: dataNode.fields,
							treeId: dataNode.treeId,
							thisId: dataNode.id,
							isParent: false
						};
						zNodes.push(zNode);
					}

					$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				}
			})

			break;
	}










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
function createClassifyNode(param) {
	// 				param = {
	// 					"pId": "2",
	// 					"nodeName": "恐怖中带有一丝丝甜的片",
	// 					"treeId": "2"
	// 				};
	var id = 0;
	$.ajax({
		url: URL + 'classifyFacade/createClassifyNode',
		type: 'POST',
		dataType: 'json',
		contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(param),
		success: function(res) {
			var status = res.status;
			if (status == "200") {
				// var nodeId = 1077;
				initTree(nodeId);
			}

		}
	})



}


//移动分类节点
function moveClassifyNode(param) {
	// 				param = [{
	// 						"id": "26",
	// 						"pId": "2"
	// 					},
	// 					{
	// 						"id": "8",
	// 						"pId": "0"
	// 					}
	// 
	// 
	// 				];
	$.ajax({
		url: URL + 'classifyFacade/moveClassifyNode',
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
function deleteClassifyNode(param) {
	// param = [88, 89];
	$.ajax({
		url: URL + 'classifyFacade/deleteClassifyNode',
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








//修改分类节点名字
function renameClassifyNode(param) {
	/* 	 param = {
	"id":"2",
	"nodeName":"恐怖片"
}; */
	$.ajax({
		url: URL + 'classifyFacade/renameClassifyNode',
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
