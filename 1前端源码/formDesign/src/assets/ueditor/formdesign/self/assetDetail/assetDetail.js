var localhost = null;
var URL = null;
var nodeId = null;
var firstNodeId = null;
var layuiUploadObj = null;
var layuiUploadImg = null;
var isassetfirst = null;
var assetDetailUrlMethod = null;
var videoInfoLayDateInit = null;
var textInfoLayDateInit = null;
$(function() {
  localhost = window.location.host;
  // localhost = "127.0.0.1";
  // localhost = "192.168.0.213";
  // localhost = "47.106.147.174";
  URL = prevent_HOST;
  nodeId = currNode.id;
  firstNodeId = currNode.id;
  isassetfirst = 1;



  if (window.location.search) {
    var urlParamArray = window.location.search.split('?')[1].split('&');
    for (var upa = 0; upa < urlParamArray.length; upa++) {
      var urlParam = urlParamArray[upa];
      var proName = urlParam.split('=')[0];
      var proValue = urlParam.split('=')[1];
      if (proName == 'method') {
        assetDetailUrlMethod = proValue;
      }
    }
  }

  if (assetDetailUrlMethod == 'watch') {
    //如果为浏览模式，右侧操作列的弹框则为不可编辑模式（清除数据按钮也要删除）
    $('#textInfoTitleId').attr('disabled', 'disabled');
    $('#textInfoTitleId').css({
      'border': 'none',
      'background': 'white'
    });
    $('#textInfoDateId').attr('disabled', 'disabled');
    $('#textInfoDateId').css({
      'border': 'none',
      'background': 'white'
    });
    $('#textInfoContentId').attr('disabled', 'disabled');
    $('#textInfoContentId').css({
      'border': 'none',
      'background': 'white'
    });
    $('#videoInfoTitleId').attr('disabled', 'disabled');
    $('#videoInfoTitleId').css({
      'border': 'none',
      'background': 'white'
    });
    $('#videoInfoDateId').attr('disabled', 'disabled');
    $('#videoInfoDateId').css({
      'border': 'none',
      'background': 'white'
    });
    $('#videoInfoContentId');
    $('#uploadVideoBtnId').hide();
    $('#uploadImgBtnId').hide();
  }



  assetDetailLayuiInit();
})






function assetDetailLayuiInit() {
  URL = prevent_HOST;
  nodeId = currNode.id;

  if ($('#selectPublicSourceId') && $('#selectPublicSourceId').val() == '0') {
    nodeId = firstNodeId;
  }

  layui.use(['upload', 'table', 'layer', 'laydate'], function() {
    var layer = layui.layer;
    var table = layui.table;
    var laydate = layui.laydate;
    var upload = layui.upload;

    assetDetailLayuiTableReload(table);

    //头工具栏事件
    table.on('toolbar(assetTableFilter)', function(obj) {
      var checkStatus = table.checkStatus(obj.config.id);
      // console.log(checkStatus.data)
      switch (obj.event) {
        case 'addAssetDetailBtn':
          var data = checkStatus.data;
          var data = {
            'nodeId': nodeId
          }
          saveAssetDetail(data, table)
          break;
        case 'delAssetDetailBtn':
          var data = checkStatus.data;
          if (data.length > 0) {
            var idList = [];
            for (var i = 0; i < data.length; i++) {
              var id = data[i].id;
              idList.push(id);
            }
            deleteAssetDetail(idList, table)
          } else {
            layer.msg("未选中记录");
          }
          break;
      };
    });


    //监听行工具事件
    table.on('tool(assetTableFilter)', function(obj) {
      var data = obj.data;
      console.log(obj);
      console.log(data);
      var t = {
        'textInfoTitle': '',
        'textInfoDate': '',
        'textInfoContent': '',
        'textInfoImg': ''
      };
      var v = {
        'videoInfoTitle': '',
        'videoInfoDate': '',
        'videoInfoContent': ''
      };
      var remarks = {
        'textInfo': JSON.stringify(t),
        'videoInfo': JSON.stringify(v)
      };
      if (data.remarks) {
        remarks = JSON.parse(data.remarks);
      }


      console.log(remarks);
      if (obj.event === 'textInfo') {
        //回写数据
        var textInfo = JSON.parse(remarks.textInfo);
        $('#textInfoTitleId').val(textInfo.textInfoTitle);
        $('#textInfoDateId').val(textInfo.textInfoDate);
        $('#textInfoContentId').val(textInfo.textInfoContent);
        $('#textInfoImgId').hide();
        if (textInfo.textInfoImg) {
          $('#textInfoImgId').show();
          $('#textInfoImgId').attr('src', textInfo.textInfoImg);
        }


        if (textInfo.textInfoTitle == '' && textInfo.textInfoDate == '' && textInfo.textInfoContent == '' &&
          textInfo.textInfoImg == '' &&
          assetDetailUrlMethod == 'watch') {
          layer.msg('无相关资料信息');
          return false;
        }



        //资料录入弹框
        textInfoEject(layer, remarks, data, table);


      } else if (obj.event === 'videoInfo') {
        //回写数据
        var videoInfo = JSON.parse(remarks.videoInfo);
        $('#videoInfoTitleId').val(videoInfo.videoInfoTitle);
        $('#videoInfoDateId').val(videoInfo.videoInfoDate);
        $('#videoInfoContentId').hide();
        if (videoInfo.videoInfoContent) {
          $('#videoInfoContentId').show();
          $('#videoInfoContentId').attr('src', videoInfo.videoInfoContent);
        }

        if (videoInfo.videoInfoTitle == '' && videoInfo.videoInfoDate == '' && videoInfo.videoInfoContent == '' &&
          assetDetailUrlMethod == 'watch') {
          layer.msg('无相关视频信息');
          return false;
        }

        //视频录入弹框
        videoInfoEject(layer, remarks, data, table);



      }
    });

    //监听单元格编辑
    table.on('edit(assetTableFilter)', function(obj) {
      var value = obj.value, //得到修改后的值
        data = obj.data, //得到所在行所有键值
        field = obj.field; //得到字段
      // layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：' + value);
      var data = {
        'id': data.id
      }
      data[field] = value;
      updateAssetDetail(data, table);
    });



    //常规用法
    videoInfoLayDateInit = laydate.render({
      elem: '#videoInfoDateId'
    });
    //常规用法
    textInfoLayDateInit = laydate.render({
      elem: '#textInfoDateId'
    });

    if (isassetfirst == 1) {



      layuiUploadObj = upload.render({
        elem: '#uploadVideoBtnId',
        url: URL + 'ueditor/uoloadFile',
        accept: 'video',
        field: 'fileVideo',
        done: function(res) {
          console.log(res)
          if (res.status == "0") {
            $('#videoInfoContentId').attr('src', res.msg);
            $('#videoInfoContentId').show();
            // $('#uploadVideoBtnId').hide();
            layer.msg('上传成功')
          } else {
            layer.msg('上传失败')
          }

          layer.closeAll('loading'); //关闭loading
        },
        before: function(obj) {
          //将每次选择的文件追加到文件队列
          // var files = obj.pushFile();

          //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
          obj.preview(function(index, file, result) {
            console.log(file.name); //file为得到文件对象
            console.log(file.type);
            console.log(file.size);

          });
          layer.load(); //上传loading
        },
      });


      layuiUploadImg = upload.render({
        elem: '#uploadImgBtnId',
        url: URL + 'ueditor/uoloadFile',
        accept: 'images',
        field: 'fileVideo',
        done: function(res) {
          console.log(res)
          if (res.status == "0") {
            $('#textInfoImgId').attr('src', res.msg);
            $('#textInfoImgId').show();
            // $('#uploadVideoBtnId').hide();
            layer.msg('上传成功')
          } else {
            layer.msg('上传失败')
          }

          layer.closeAll('loading'); //关闭loading
        },
        before: function(obj) {
          //将每次选择的文件追加到文件队列
          // var files = obj.pushFile();

          //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
          obj.preview(function(index, file, result) {
            console.log(file.name); //file为得到文件对象
            console.log(file.type);
            console.log(file.size);

          });
          layer.load(); //上传loading
        },
      });






      isassetfirst = 0;
    }

    /* videoInfoLayDateInit.reload({
       elem: '#videoInfoDateId'
     });
     textInfoLayDateInit.reload({
       elem: '#textInfoDateId'
     }); */
    //重载
    layuiUploadObj.reload({
      elem: '#uploadVideoBtnId',
      url: URL + 'ueditor/uoloadFile',
      accept: 'video',
      field: 'fileVideo',
      done: function(res) {
        console.log(res)
        if (res.status == "0") {
          $('#videoInfoContentId').attr('src', res.msg);
          $('#videoInfoContentId').show();
          // $('#uploadVideoBtnId').hide();
          layer.msg('上传成功')
        } else {
          layer.msg('上传失败')
        }

        layer.closeAll('loading'); //关闭loading
      },
      before: function(obj) {
        //将每次选择的文件追加到文件队列
        // var files = obj.pushFile();

        //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
        obj.preview(function(index, file, result) {
          console.log(file.name); //file为得到文件对象
          console.log(file.type);
          console.log(file.size);

        });
        layer.load(); //上传loading
      },
    });

    layuiUploadImg.reload({
      elem: '#uploadImgBtnId',
      url: URL + 'ueditor/uoloadFile',
      accept: 'images',
      field: 'fileVideo',
      done: function(res) {
        console.log(res)
        if (res.status == "0") {
          $('#textInfoImgId').attr('src', res.msg);
          $('#textInfoImgId').show();
          // $('#uploadVideoBtnId').hide();
          layer.msg('上传成功')
        } else {
          layer.msg('上传失败')
        }

        layer.closeAll('loading'); //关闭loading
      },
      before: function(obj) {
        //将每次选择的文件追加到文件队列
        // var files = obj.pushFile();

        //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
        obj.preview(function(index, file, result) {
          console.log(file.name); //file为得到文件对象
          console.log(file.type);
          console.log(file.size);

        });
        layer.load(); //上传loading
      },
    });



  });

}




function assetDetailLayuiTableReload(table) {
  table.reload('assetTableId', {
    toolbar: '#assetToolbar',
    // size: 'sm',
    // height:50,
    parseData: function(res) {
      if ($('#selectPublicSourceId') && $('#selectPublicSourceId').val() == '0') {
        res.count = 0;
        res.msg = [];
      }
      if (res.msg && res.msg.length > 0) {
        for (var i = 0; i < res.msg.length; i++) {
          res.msg[i].orderNum = i + 1;
        }
      }

      /*  var t = {
        'textInfoTitle': '',
        'textInfoDate': '',
        'textInfoContent': ''
      };
      var v = {
        'videoInfoTitle': '',
        'videoInfoDate': '',
        'videoInfoContent': ''
      };
      var remarks = {
        'textInfo': JSON.stringify(t),
        'videoInfo': JSON.stringify(v)
      };
      if (data.remarks) {
        remarks = JSON.parse(data.remarks);
      } */


      return {
        'code': res.status == '200' ? 0 : 1,
        'msg': res.statusMsg,
        'count': res.count,
        'data': res.msg
      };
    },
    url: URL + 'assetDetailFacae/getAssetDetailByNodeId?nodeId=' + nodeId,
    cellMinWidth: 80,
    page: true,
    totalRow: true,
    done: function() {
      $('.layui-table-cell').each(function(i, n) {
        var s = $(n).parent().get(0).tagName;
        console.log(s)
        if (s == 'TH') {
          $(n).css({
            'height': 'auto',
            'overflow': 'visible',
            'text-overflow': 'inherit',
            'white-space': 'normal'
          })
        }

      })
    }
  });
}




//保存资产明细
function saveAssetDetail(data, table) {
  $.ajax({
    url: URL + 'assetDetailFacae/saveAssetDetail',
    type: 'POST',
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify(data),
    success: function(res) {
      assetDetailLayuiTableReload(table);
    }
  })
}
//删除资产明细
function deleteAssetDetail(data, table) {
  $.ajax({
    url: URL + 'assetDetailFacae/deleteAssetDetail',
    type: 'POST',
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify(data),
    success: function(res) {
      assetDetailLayuiTableReload(table);
    }
  })
}

//修改资产明细
function updateAssetDetail(data, table) {
  $.ajax({
    url: URL + 'assetDetailFacae/updateAssetDetail',
    type: 'POST',
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify(data),
    success: function(res) {
      assetDetailLayuiTableReload(table);
    }
  })
}



function textInfoEject(layer, remarks, data, table) {

  if (assetDetailUrlMethod == 'watch') {
    //以下用于不可编辑状态
    //打开资料信息录入页面
    layer.open({
      type: 1,
      title: '',
      area: ['700px', '700px'],
      // btn: ['确定'],
      content: $('#textInfoAreaId'),
      // offset: 'r',
      closeBtn: 0,
      shade: [0.8, '#393D49'],
      shadeClose: true
      // move: false,
      /* yes: function(index, layero) {
         layer.close(index);
       } */
    });

  } else {

    //打开资料信息录入页面
    layer.open({
      type: 1,
      title: '资料信息录入',
      area: ['700px', '700px'],
      btn: ['确定', '清空数据'],
      content: $('#textInfoAreaId'),
      // offset: 'r',
      // closeBtn: 0,
      // move: false,
      yes: function(index, layero) {
        var textInfoTitle = $.trim($('#textInfoTitleId').val());
        var textInfoDate = $.trim($('#textInfoDateId').val());
        var textInfoContent = $.trim($('#textInfoContentId').val());
        var textInfoImg = $.trim($('#textInfoImgId').attr('src'));
        /* if (!textInfoTitle) {
        	alert('资料标题不能为空');
        	return false;
        }
        if (!textInfoDate) {
        	alert('资料时间不能为空');
        	return false;
        }
        if (!textInfoContent) {
        	alert('资料内容不能为空');
        	return false;
        } */
        var textInfo = {
          'textInfoTitle': textInfoTitle,
          'textInfoDate': textInfoDate,
          'textInfoContent': textInfoContent,
          'textInfoImg': textInfoImg
        };
        console.log(textInfo)
        var updateRemark = {
          'textInfo': JSON.stringify(textInfo),
          'videoInfo': remarks.videoInfo
        };
        console.log(updateRemark)
        var da = {
          'id': data.id,
          'remarks': JSON.stringify(updateRemark)
        }
        console.log(da)
        updateAssetDetail(da, table)
        layer.close(index);
      },
      btn2: function(index, layero) {
        $('#textInfoTitleId').val('');
        $('#textInfoDateId').val('');
        $('#textInfoContentId').val('');
        $('#textInfoImgId').attr('src', '');
        $('#textInfoImgId').hide();
        return false;
      }
    });
  }

}

function videoInfoEject(layer, remarks, data, table) {

  if (assetDetailUrlMethod == 'watch') {
    //以下用于不可编辑状态
    //打开视频信息录入页面
    layer.open({
      type: 1,
      title: '',
      area: ['700px', '700px'],
      // btn: ['确定'],
      content: $('#videoInfoAreaId'),
      // offset: 'r',
      closeBtn: 0,
      shade: [0.8, '#393D49'],
      shadeClose: true
      // move: false,
      //       yes: function(index, layero) {
      //
      //         layer.close(index);
      //       }
    });

  } else {

    //打开视频信息录入页面
    layer.open({
      type: 1,
      title: '视频信息录入',
      area: ['700px', '700px'],
      btn: ['确定', '清空数据'],
      content: $('#videoInfoAreaId'),
      // offset: 'r',
      // closeBtn: 0,
      // move: false,
      yes: function(index, layero) {
        var videoInfoTitle = $.trim($('#videoInfoTitleId').val());
        var videoInfoDate = $.trim($('#videoInfoDateId').val());
        var videoInfoContent = $.trim($('#videoInfoContentId').attr('src'));
        /* if (!videoInfoTitle) {
        	alert('视频标题不能为空');
        	return false;
        }
        if (!videoInfoDate) {
        	alert('视频时间不能为空');
        	return false;
        }
        if (!videoInfoContent) {
        	alert('视频内容不能为空');
        	return false;
        } */
        /* var df = {"videoInfo": "dfdf","textInfo": "dfdf"} */
        var videoInfo = {
          'videoInfoTitle': videoInfoTitle,
          'videoInfoDate': videoInfoDate,
          'videoInfoContent': videoInfoContent
        };
        console.log(videoInfo)
        var updateRemark = {
          'videoInfo': JSON.stringify(videoInfo),
          'textInfo': remarks.textInfo
        };
        console.log(updateRemark)
        var da = {
          'id': data.id,
          'remarks': JSON.stringify(updateRemark)
        }
        console.log(da)
        updateAssetDetail(da, table)
        layer.close(index);
      },
      btn2: function(index, layero) {
        $('#videoInfoTitleId').val('');
        $('#videoInfoDateId').val('');
        $('#videoInfoContentId').attr('src', '');
        $('#videoInfoContentId').hide();
        return false;
      }
    });
  }








}
