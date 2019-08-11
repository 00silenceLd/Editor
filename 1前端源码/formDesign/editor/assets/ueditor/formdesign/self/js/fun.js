var curRoleType = null;
var curUserJob = null;
var currRecord = null;
var manager = null;
var gUser = null;
var userToKen = null;
var searchlists = null;
var myforllisttime = null;
var myMtext = null;
var uecon = null;
try {
  gUser = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
  if (gUser.token != '' && gUser.token != null) {
    userToKen = gUser.token;
  }
} catch (e) {}





//餐品上传提交
function productsuploadti() {
  // debugger;
  alert("进入餐品上传提交按钮");
  var productsName = $('input[name="mingcheng"]').val();
  var prodyctsPrice = $('input[name="jiaqian"]').val();
  var productsInfo = $('input[name= "xiangqing"]').val();
  var productsCategory = $("#leibie").val();
  var productsComment = $("#duoxingwenbenkuang").val();
  var productsPicture = $("#shangchuantupian").val();
  alert(productsCategory);
  if (productsName != '' && prodyctsPrice != '' && productsInfo != '' && productsCategory != '' && productsComment !=
    '') {
    // alert(productsComment+""+productsCategory+""+productsInfo+""+prodyctsPrice+""+productsName)
    var data = {
      "productsName": productsName,
      "prodyctsPrice": prodyctsPrice,
      "productsInfo": productsInfo,
      "productsCategory": productsCategory,
      "productsComment": productsComment,
      "productsPicture": productsPicture
    }
    $.ajax({
      url: prevent_HOST + "htProductsFacade/insertSelectiveProducts",
      type: 'post',
      data: JSON.stringify(data),
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      async: false,
      success: function(res) {
        alert(res.statusMsg);
      },
      error: function(res) {
        alert("请求失败!");
      }
    })
  } else {
    alert("信息不完善,请完善信息!");
  }
}

// 添加类别提交操作
function addcategoryti() {
  // alert("进入提交方法");
  var searchData = $(".searchData").val();
  // alert(searchData);
  var data = {
    "record": searchData
  }
  $.ajax({
    url: prevent_HOST + "htCategoryFacade/insertSelectiveIn",
    type: 'post',
    data: JSON.stringify(data),
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    async: false,
    success: function(res) {
      alert(res.statusMsg);
    },
    error: function(res) {
      alert("请求失败!");
    }
  })


}
// 餐品上传跳转添加类别提交操作
function addcategorytian() {
  // alert("进入提交方法");
  var searchData = $(".searchData").val();
  // alert(searchData);
  var data = {
    "record": searchData
  }
  $.ajax({
    url: prevent_HOST + "htCategoryFacade/insertSelectiveIn",
    type: 'post',
    data: JSON.stringify(data),
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    async: false,
    success: function(res) {
      alert(res.statusMsg);
      window.location.href = "../../../../../assets/ueditor/formdesign/preview.html";
    },
    error: function(res) {
      alert("请求失败!");
    }
  })


}




//级联分类
function classifyClassChang(id, sonclass) {
  //console.log(id,sonclass);
  if (id == '' || id == undefined) {
    $("#classify_" + sonclass).html("<option value=''>---请选择---</option>");
    return false;
  }
  if (sonclass != '' || sonclass != undefined) {
    $.ajax({
      url: prevent_HOST + "pageDesignQueryFacade/getclassifyByParentId?pid=" + id,
      type: 'GET',
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      async: false,
      success: function(res) {
        if (res.status == '200') {
          var tagdata = res.msg;
          var sonlist = '';
          for (var i = 0; i < tagdata.length; i++) {
            sonlist += "<option value='" + tagdata[i].id + "'>" + tagdata[i].name + "</option>";
          }
          $("#classify_" + sonclass).html(sonlist);
        } else {

        }
      }
    })
  }
}

//级联分类
function classifyRelationChang(id, sonclass) {
  $("#classify_" + sonclass).html("");
  if (id == '' || id == undefined) {
    return false;
  }
  if (sonclass != '' || sonclass != undefined) {
    $.ajax({
      url: prevent_HOST + "pageDesignQueryFacade/getclassifyByParentId?pid=" + id,
      type: 'GET',
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      async: false,
      success: function(res) {
        if (res.status == '200') {
          var tagdata = res.msg;
          var sonlist = '';
          for (var i = 0; i < tagdata.length; i++) {
            sonlist += "<span class='srelation2' data-id='" + tagdata[i].id + "'>" + tagdata[i].name + "</span>";
          }
          $("#classify_" + sonclass).html(sonlist);
        } else {

        }
      }
    })
  }
}

function doClassifyClass(nid, treeId, datafiled) {
  if (nid == 'null' || nid == undefined || nid == '') return false;
  $.ajax({
    url: prevent_HOST + 'pageDesignQueryFacade/getCascadeClassifyRecord?rootId=' + nid,
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    async: true,
    success: function(res) {
      if (res.status == '200') {
        var tagdata = res.msg;
        var classhtml = '';
        if (tagdata.children.length > 0) {
          var treeData = {
            onchange: function(input, yntree) {},
            checkStrictly: true,
            data: tagdata.children
          };
          var yntree = new YnTree(document.getElementById(treeId), treeData, datafiled);
        }
      } else {}
    }
  })
}

function doClassify(key, val) {
  console.log("fun-searcch")
  if (key == "null" || key == 'undefined') return false;
  getListOne(searchlists.nid, searchlists.name, searchlists.cla, searchlists.page, searchlists.pagesize, searchlists.showpage,
    searchlists.pic, searchlists.ctitle, searchlists.con, searchlists.tpl, searchlists.tsize, searchlists.csize,
    searchlists.listurl, searchlists.listpicw, searchlists.listpich, searchlists.titlelabel, searchlists.conlabel,
    searchlists.frmedit, searchlists.frmdel, searchlists.fontsize, key, val, searchlists.picfontsize, searchlists.listheight
  );
}


//下拉影响
function doSelect(val) {
  console.log("fun-searcch")
  var dosearchfile = searchlists.searchfile;
  if (val == "全部" || val == 'all' || val == '') {
    val = null;
    dosearchfile = null;
  }
  getFormList(searchlists.formNid, searchlists.formName, searchlists.formTpl, searchlists.page, searchlists.pagesize,
    searchlists.showpage, searchlists.datafields, searchlists.headshow, searchlists.frmedit, searchlists.frmdel,
    searchlists.cla, searchlists.url, searchlists.listpicw, searchlists.listpich, dosearchfile, val, searchlists.fsize,
    searchlists.listlineheight, searchlists.personage_info);
  //doTime(searchlists.formNid,searchlists.formName,searchlists.formTpl,searchlists.page,searchlists.pagesize,searchlists.showpage,searchlists.datafields,searchlists.headshow,searchlists.frmedit,searchlists.frmdel,searchlists.cla,searchlists.url,searchlists.listpicw,searchlists.listpich,dosearchfile,val);
}
//搜索
function doTextSearch(val) {
  console.log("fun-searcch")
  var dosearchfile = searchlists.searchfile;
  if (val == "全部" || val == 'all' || val == '') {
    val = null;
    dosearchfile = null;
  }

  if ($('.searchlist').length > 0) {
    getFormList(searchlists.formNid, searchlists.formName, searchlists.formTpl, searchlists.page, searchlists.pagesize,
      searchlists.showpage, searchlists.datafields, searchlists.headshow, searchlists.frmedit, searchlists.frmdel,
      searchlists.cla, searchlists.url, searchlists.listpicw, searchlists.listpich, dosearchfile, val, searchlists.fsize,
      searchlists.listlineheight, searchlists.personage_info);
  } else if ($('.listonetpl').length > 0) {
    getListOne(searchlists.nid, searchlists.name, searchlists.cla, searchlists.page, searchlists.pagesize, searchlists.showpage,
      searchlists.pic, searchlists.ctitle, searchlists.con, searchlists.tpl, searchlists.tsize, searchlists.csize,
      searchlists.listurl, searchlists.listpicw, searchlists.listpich, searchlists.titlelabel, searchlists.conlabel,
      searchlists.frmedit, searchlists.frmdel, searchlists.fontsize, dosearchfile, val, searchlists.picfontsize,
      searchlists.listheight);
  }

  // doTime(searchlists.formNid,searchlists.formName,searchlists.formTpl,searchlists.page,searchlists.pagesize,searchlists.showpage,searchlists.datafields,searchlists.headshow,searchlists.frmedit,searchlists.frmdel,searchlists.cla,searchlists.url,searchlists.listpicw,searchlists.listpich,dosearchfile,val);
}

function doJobRow(arr) {
  var list = '';
  for (var i = 0; i < arr.length; i++) {
    list += '<tr><td>' + arr[i].name + '</td><td>加入时间：' + arr[i].CreationTime + '</td></tr>';
    if (arr[i].children.length > 0) {
      list += doJobRow(arr[i].children);
    }
  }
  return list;
}

function myfn(arr) {
  var list = '';
  for (var i = 0; i < arr.length; i++) {
    list += '<option value="' + arr[0].id + '">' + arr[i].name + '</option>';
    if (arr[i].children.length > 0) {
      list += myfn(arr[i].children);
    }
  }
  return list;
}

function myfn2(arr) {
  var list = '';
  for (var i = 0; i < arr.length; i++) {
    list += '<span><input type="checkbox" value="' + arr[0].id + '">' + arr[i].name + '</span>';
    if (arr[i].children.length > 0) {
      list += myfn2(arr[i].children);
    }
  }
  return list;
}
/*获取机构*/
function getJobTree() {
  if (gUser == null) {
    return false;
  }

  $.get(DEFAULT_JOBURL + "htRoleService/getRoleTreeByUser?user_id=" + gUser.id, function(res) {
    if (res.status == "1") {
      var r = res.msg;
      if (r.length > 0) {
        var tmplist = myfn(r);
        localStorage.setItem('curUserJob', JSON.stringify(res.msg));
        var joblist = '<option value="0">---机构选择---</option>';
        $(".wxmsgjob").html(joblist + tmplist);
        manager = $("#wxjobtree").ligerTree({
          data: res.msg,
          idFieldName: 'id',
          textFieldName: 'name',
          slide: false,
          parentIDFieldName: 'parentId',
          checkbox: true,
          parentIcon: null,
          childIcon: null,
          isExpand: 1,
          nodeWidth: 312,
          onclick: function(node) {}
        });
      }
    }
  });
}
/*获取机构下角色*/
function setRoleSelect(rid) {
  $.get(DEFAULT_JOBURL + "htRoleService/getRolePosName?role_id=" + rid, function(res) {
    var html = "";
    if (res.position.length > 0) {
      for (var i = 0; i < res.position.length; i++)
        html += '<span><input type="checkbox" value="' + res.position[i].pos_id + '">' + res.position[i].posName +
        '</span>';
    }
    $(".wxroleselect").html(html);
  });
}
/*获取角色下所有用户*/
function getUserTree(urid) {
  $.get(DEFAULT_JOBURL + "htPostionService/showApplyPosUserByPageByPass?posId=" + urid, function(res) {
    var html = "";
    if (res.status == '0') {
      var msguser = res.msg.userList;
      for (var i = 0; i < msguser.length; i++)
        html += '<span><input type="checkbox" value="' + msguser[i].uId + '">' + msguser[i].username + '</span>';
    }
    $(".wxuserselect").html(html);
  });
}

function getRoleTree(jobid) {
  $.get(DEFAULT_JOBURL + "htRoleService/getRolePosName?role_id=" + jobid, function(res) {
    var html = "";
    if (res.position.length > 0) {
      for (var i = 0; i < res.position.length; i++)
        html += '<option value="' + res.position[i].pos_id + '">' + res.position[i].posName + '</option>';
      getUserTree(res.position[0].pos_id);
    }
    $("[name='userroleselect']").html(html);
  });
}

function doFormListImg(str) {
  if (str == null || str == '') return '';
  var imgext = "jpg|jpeg|gif|bmp|png|";
  var FileExt = str.substring(str.lastIndexOf(".") + 1, str.length);
  var dowext = "doc|docx|txt|RAR|rar|zip|pdf|xls|xlsx|gz|";
  if (FileExt.length < 3) {
    return str;
  }
  if (imgext.indexOf(FileExt + "|") != -1) {
    return '<img src="' + str + '">';
  } else if (dowext.indexOf(FileExt + "|") != -1) {

    return '<a href="http://' + localHost + '/' + str + '">' + str.substring(str.lastIndexOf("/") + 1, str.length) +
      '</a>';
  }
  return str;
}

function doFormListImgWH(str, picW, picH) {
  if (str == null || str == '') return '';
  if (!isNaN(str)) return str;
  var imgext = "jpg|jpeg|gif|bmp|png|";
  var FileExt = str.substring(str.lastIndexOf(".") + 1, str.length);
  var dowext = "doc|docx|txt|RAR|rar|zip|pdf|xls|xlsx|gz|ppt|pptx|";
  var videoext = "MP4|mp4|mov|mpeg|mpg|avi|";
  if (FileExt.length < 3) {
    return str;
  }
  if (imgext.indexOf(FileExt + "|") != -1) {
    var style = '';

    if (picH != '' && picH != undefined && picH != 'autopx' && picH != 'null') {
      style += "height:" + picH + ";";
    }
    if (picW != '' && picW != undefined && picW != 'autopx' && picW != 'null') {
      style += "width:" + picW + ";";
    }
    return '<img src="' + str + '" style="' + style + '">';
  } else if (dowext.indexOf(FileExt + "|") != -1) {
    return '<a href="' + str + '">' + str.substring(str.lastIndexOf("/") + 1, str.length) + '</a>';
  } else if (videoext.indexOf(FileExt + "|") != -1) {
    return '<img src="self/formlist/img/video.jpg" style="width:30px;height:30px;">';
  }
  return str;
}

function getNodeConent(nid) {
  var url = DEFAULT_URL + 'nodeQueryFacade/getByNodeName?nodeId=' + nid;
  $.ajax({ // 这是获取模板。
    url: url,
    type: 'GET',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    async: false,
    success: function(res) {
      if (res.status == '0') {
        currNode = res.msg;
      }
    }
  })
}

function getQueryString(name) {
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
  var r = decodeURI(window.location.search).substr(1).match(reg);
  if (r != null) return (r[2]);
  return null;
}

function GR() {
  var url = location.search;
  var r = new Object();
  if (url.indexOf("?") != -1) {
    var str = url.substr(1);
    strs = str.split("&");
    for (var i = 0; i < strs.length; i++) {
      r[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
    }
  }
  return r;
}

function frmDateTime(ctime) {
  var d = new Date(ctime);
  var dformat = [d.getFullYear(), d.getMonth() + 1, d.getDate()].join('-') +
    ' ' + [d.getHours(), d.getMinutes(), d.getSeconds()].join(':');
  return dformat;
};

function getWxList(wxsendtype, fdata) {
  var wxurl = '';
  if (wxsendtype == 'send') {
    wxurl = DEFAULT_JOBURL + 'htWeiXinService/getListSendWxPushByUid';
  } else {
    wxurl = DEFAULT_JOBURL + 'htWeiXinService/getListWxPushByUid';
  }
  $.ajax({
    type: "POST",
    url: wxurl,
    data: fdata,
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    success: function(res) {
      var html = '';
      if (res.msg == null || res.msg.length < 1) {
        html = "没有通知";
      } else {
        var m = res.msg;
        var label = '';
        var dtime = '';
        var content = null;
        var tag = '';
        var infourl = '';
        for (var k = 0; k < m.length; k++) {
          label = '';
          dtime = '';
          content = JSON.parse(m[k].content);
          dtime = frmDateTime(m[k].addTime);
          tag = '';
          infourl = 'wxmsg.html?flag=' + m[k].msgflag + '&id=' + m[k].id;
          if (m[k].msgflag == 1) {
            label = '学校通知';
            if (content.data8 != '') tag = '<span>' + content.data8 + '</span>';
            html += '<div class="wx_list_block"><a href="' + infourl +
              '"><div class="wx_list_conent"><div class="wx_list_label wx_list_msgflag' + m[k].msgflag + '">' +
              label +
              '</div><div class="wx_list_right"><h1>' + tag + m[k].title + '</h1><div class="wx_list_con">' +
              content.data2 +
              '</div><div class="wx_list_user"><em>' + content.data3 + '</em><em>' + dtime +
              '</em></div></div></div></a></div>';
          } else if (m[k].msgflag == 2) {
            label = '请假通知';
            if (content.data8 != '') tag = '<span>' + content.data8 + '</span>';
            html += '<div class="wx_list_block">' +
              '<a href="' + infourl + '"><div class="wx_list_conent">' +
              '<div class="wx_list_label wx_list_msgflag' + m[k].msgflag + '">' + label + '</div>' +
              '<div class="wx_list_right">' +
              '<h1>' + tag + m[k].title + '</h1>' +
              '<div class="wx_list_con">请假人：' + content.data3 + '&nbsp;&nbsp; ' + content.data2 + '<br/>' +
              '请假时间：' + content.data4 + '<br/>' +
              '请假事由：' + content.data5 + '<br/> ' + content.data6 + '</div>' +
              '<div class="wx_list_user"><em>' + content.data3 + '</em><em>' + dtime + '</em></div>' +
              '</div>' +
              '</div></a>' +
              '</div>';
          } else if (m[k].msgflag == 3) {
            label = '家庭作业';
            if (content.data8 != '') tag = '<span>' + content.data8 + '</span>';
            html += '<div class="wx_list_block">' +
              '<a href="' + infourl + '"><div class="wx_list_conent">' +
              '<div class="wx_list_label wx_list_msgflag' + m[k].msgflag + '">' + label + '</div>' +
              '<div class="wx_list_right">' +
              '<h1>' + tag + m[k].title + '[' + content.data4 + ']</h1>' +
              '<div class="wx_list_con">' + content.data2 + '时间：' + content.data3 + '<br/>' +
              '科目：' + content.data4 + ' <br/>' +
              '作业简介：' + content.data5 + ' <br/>' +
              '作业详情：' + content.data6 + '<br/>' + content.data7 + '</div>' +
              '<div class="wx_list_user"><em>管理员老师</em><em>' + dtime + '</em></div>' +
              '</div>' +
              '</div></a>' +
              '</div>';
          } else if (m[k].msgflag == 4) {
            label = '年级通知';
            if (content.data8 != '') tag = '<span>' + content.data8 + '</span>';
            html += '<div class="wx_list_block">' +
              '<a href="' + infourl + '"><div class="wx_list_conent">' +
              '<div class="wx_list_label wx_list_msgflag' + m[k].msgflag + '">' + label + '</div>' +
              '<div class="wx_list_right">' +
              '<h1>' + tag + m[k].title + '</h1>' +
              '<div class="wx_list_con">' + content.data2 + '</div>' +
              '<div class="wx_list_user"><em>管理员老师</em><em>' + dtime + '</em></div>' +
              '</div>' +
              '</div></a>' +
              '</div>';
          } else if (m[k].msgflag == 5) {
            label = '班级通知';
            html += '<div class="wx_list_block">' +
              '<a href="' + infourl + '"><div class="wx_list_conent">' +
              '<div class="wx_list_label wx_list_msgflag' + m[k].msgflag + '">' + label + '</div>' +
              '<div class="wx_list_right">' +
              '<h1>' + m[k].title + '</h1>' +
              '<div class="wx_list_con">' + content.data2 + '</div>' +
              '<div class="wx_list_user"><em>管理员老师</em><em>' + dtime + '</em></div>' +
              '</div>' +
              '</div></a>' +
              '</div>';
          }
        }
      }
      $(".wx_msglist_" + wxsendtype).html(html);
      //showData = html;
    }
  });
}

function doStrMarks(arr) {
  for (var key in arr) {
    arr[key] = arr[key].replace(/"/g, "&quot;");
  }
  return arr;
}

function doDeStrMarks(str) {
  if (str == undefined) return '';
  if (str != '' && str != null) {
    str = str.replace(/:&quot;/g, '="');
    str = str.replace(/&quot;/g, '"');
  }
  return str;
}

function getPage(total, pagesize, page) {
  var pnumer = Math.ceil(total / pagesize);
  var pagecon = '<ul class="listpage">';
  for (var i = 1; i <= page; i++) {
    if (page == i) {
      pagecon = '<li class="cur_page">' + i + '</li>';
    } else {
      pagecon = '<li>' + i + '</li>';
    }
  }
  pagecon += '</ul>';
}

function setStringLength(str, len) {
  if (str == null || str == undefined || str == '') return str;
  if (len != '' && len > 0) {
    if (str.length > len) {
      return str.substring(0, len) + "...";
    } else {
      return str.substring(0, len);
    }

  }
  return str;
}

function getListOne(nid, name, cla, page, pagesize, showpage, pic, ctitle, con, tpl, tsize, csize, listurl, listpicw,
  listpich, titlelabel, conlabel, frmedit, frmdel, fontsize, searchfile, searchcon, picfontsize, listheight, isnotuser,
  prefix, isheader, headertitle, moreurl, headercolor, titlecolor, iscomment, headstyle, headimgsrc, pagingstyle,
  isscore, thisScoreIds, multisource, statistical, threeToFiveScoreIds,typesevenurl,con2,typesevendate) {
  //用于多数据源查询，修改器样式
  /* $('body').on('click', '.selectdatasource', function() {
    $('.selectdatasource').css('background', '#ffa498');
    $(this).css('background', '#ff4a32');
  }) */

  console.log("connnnn"+con+" eeeeeeeee"+con2)
  var fla = true;
  if (statistical == "statistical") {
    fla = false;
  }
  var params = decodeURI(window.location.search); //（?xxx=ddd&xxx=ddd）
  if (params) {
    //从params中获取method的参数值
    var urlValues = params.split("?")[1].split("&"); //xxx=dd,xxx=dd数组
    for (var i = 0; i < urlValues.length; i++) {
      var urlValue = urlValues[i];
      var proName = urlValue.split("=")[0]; //属性名
      var proValue = urlValue.split("=")[1]; //属性值
      if (proName == "sR") {
        // fla = false;
      }
    }
  }






  var scoreUrlStr;
  if (isscore == 'noscore') {
    scoreUrlStr = "";
  } else {
    scoreUrlStr = '&isscore=' + isscore;
  }
  if (thisScoreIds != undefined && thisScoreIds != 'undefined' && thisScoreIds.length != 0) {
    pagesize = 1000;
    showpage = "off";
  }
  if (threeToFiveScoreIds != undefined && threeToFiveScoreIds != 'undefined' && threeToFiveScoreIds.length != 0) {
    pagesize = 1000;
    showpage = "off";
  }



  var listonehtml = '';
  var ajaxData = {
    "node_id": nid,
    "classname": name,
    "page": page,
    "pagesize": pagesize,
    "orderby": "desc",
    "table_field_all": searchfile,
    "searchContent": searchcon,
    "method": "getQueryPage",
    "userid": ""
  };
  var tempPage = page;

  $.ajax({
    url: prevent_HOST + 'pageDesignOperatorFacade/selectFormRecord',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    data: JSON.stringify(ajaxData),
    async: fla,
    success: function(res) {
      if (res.status == '200') {

        var listonelist = res.msg.data;

        //在显示评分星级数据的状态下，用于保存该星级记录总数的变量
        var scoreCount = 0;
        //正常情况下，点击1~5星级后，查询出来的当前星级的记录id
        if (thisScoreIds != undefined && thisScoreIds != 'undefined' && thisScoreIds.length != 0) {
          var tem = [];
          for (var er = 0; er < listonelist.length; er++) {
            var lis = listonelist[er];
            for (var re = 0; re < thisScoreIds.length; re++) {
              if (lis.id == thisScoreIds[re]) {
                tem.push(lis);
              }
            }
          }
          scoreCount = thisScoreIds.length;
          listonelist = tem;
          console.log(listonelist)
        }
        //threeToFiveScoreIds为4，5星级的记录id，用于反向查询0~2星级的记录id（根据需求临时加上的特殊情况）
        if (threeToFiveScoreIds != undefined && threeToFiveScoreIds != 'undefined' && threeToFiveScoreIds.length !=
          0) { //根据3,4,5星的记录id反向显示0~2星记录
          var tem = [];
          for (var er = 0; er < listonelist.length; er++) {
            var lis = listonelist[er];
            //作为是否3~5星级的id
            var isExist = 0;
            for (var re = 0; re < threeToFiveScoreIds.length; re++) {
              if (lis.id == threeToFiveScoreIds[re]) {
                isExist = 1
              }
            }
            if (isExist == 0) { //为非星级（0~2星）
              tem.push(lis);
            }
          }
          scoreCount = listonelist.length - threeToFiveScoreIds.length;
          listonelist = tem;
          console.log("listonelist---------" + listonelist)
        }


        // var temp;
        /* for (var i = 0; i < listonelist.length - 1; i++) {
        	for (var j = 0; j < listonelist.length - 1 - i; j++) {
        		//当前时间
        		var t1 = setStringLength(listonelist[j][con], csize);
        		console.log("转换前t1=" + t1)
        		t1 = new Date(t1.replace(/-/, "/"));
        		console.log("转换后t1=" + t1)
        		//下一个时间
        		var t2 = setStringLength(listonelist[j+1][con], csize);
        		console.log("转换前t2=" + t2)
        		t2 = new Date(t2.replace(/-/, "/"));
        		console.log("转换后t2=" + t2)
        		if(t1=="Invalid Date"||t1==null)break;
        		if (t1 < t2) {
        			// alert(123)
        			temp = listonelist[j];
        			listonelist[j] = listonelist[j + 1];
        			listonelist[j + 1] = temp;
        		}
        	}
        } */










        var url = '';
        var title = '';
        var content = '';
        var date='';
        var other = '';
        var editlink = '';
        var fonitstyle = '';
        var wenbenkuang1 = '';
        // console.log(listonelist);
        if (fontsize != '') fonitstyle = 'style="font-size: ' + fontsize + ';line-height:' + listheight + ';"';
        if (listonelist.length > 0) {
          // alert("这里是fun.js的tpl=" + tpl);
          if (parseInt(isnotuser) == 1) {
            for (var lo = 0; lo < listonelist.length; lo++) {
              if (listonelist[lo].getuserid == gUser.id) {
                other = '';
                url = '/editor/assets/ueditor/formdesign/preview.html?id=' + nid + '&name=' + name +
                  '&method=watch&selectId=' + listonelist[lo].id + '&iscomment=' + iscomment + scoreUrlStr;
                // url="/folder/staticPage/"+getPYFC(name)+".html";
                if (listurl != '' && listurl != 'null' && listurl != undefined) {
                  url = listurl;
                }

                //frmedit,frmdel
                editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + nid + '&name=' + name +
                  '&method=change&selectId=' + listonelist[lo].id;
                if (frmedit == '1') {
                  other = "<span data-link='" + editlink +
                    "' class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                }
                if (frmdel == '1') {
                  other += " &nbsp;<span data-nid=" + listonelist[lo].id + " data-name='" + name +
                    "' data-type='listone' class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                }
                title = setStringLength(listonelist[lo][ctitle], tsize);
                content = setStringLength(listonelist[lo][con], csize);
                date =setStringLength(listonelist[lo][con2], csize);
                wenbenkuang1 = setStringLength(listonelist[lo]['wenbenkuang1']);

                if (title == undefined || title == null || title == "") continue;
                title = title.replace(" ", "");
                // content = content.replace(" ", "");
                if (title == "") continue;
                switch (tpl) {
                  case 'type-one':
                    listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                      '<div class="listone-pic">' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) +
                      '</div>' +
                      '<div class="listone-info">' +
                      '<div><span ' + fonitstyle + '>' + titlelabel + title + '</span></div>' +
                      '<div><span ' + fonitstyle + '>' + conlabel + content + '</span></div>' +
                      '</div>' +
                      '</a>' +
                      '<div class="listone-other">' + other + '</div>' +
                      '</div>';
                    break;
                  case 'type-two':
                    listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                      '<dl>' +
                      '<dt>' +
                      doFormListImgWH(listonelist[lo][pic], listpicw, listpich) + '</dt>' +
                      '<dd ' + fonitstyle + '>' + titlelabel + title + '</dd>' +
                      '<dd ' + fonitstyle + '>' + conlabel + content + '</dd>' +
                      '</dl>' +
                      '</a><div class="listone-other">' + other + '</div>' +
                      '</div>';
                    break;
                  case 'type-three':
                    listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                      '<dl>' +
                      '<dt>' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) +
                      '</dt>' +
                      '<dd ' + fonitstyle + '>' + titlelabel + title + '</dd>' +
                      '</dl>' +
                      '</a><div class="listone-other">' + other + '</div>' +
                      '</div>';
                    break;
                  case 'type-four':
                    listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                      '<dl class="listone-type-four">' +
                      '<dt ' + fonitstyle + '>' +
                      setStringLength(listonelist[lo][pic], picfontsize) +
                      '</dt>' +
                      '<dd style="color:#afacac;font-size:12px;">' + titlelabel + title + '</dd>' +
                      '<dd style="color:#afacac;font-size:12px;">' + conlabel + content + '</dd>' +
                      '</dl>' +
                      '</a><div class="listone-other">' + other + '</div>' +
                      '</div>';
                    break;
                  case 'type-five':
                    if (prefix == undefined || prefix == '') { //不要行前缀
                      if (isheader == "no") { //不要头部栏
                        listonehtml +=
                          "<div class='listone-list' style='width: 98%;margin-left: 20px;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li style='margin-left: -20px;'><a href='" +
                          url + "'><span  " + fonitstyle + " >" +
                          titlelabel + title +
                          "</span></a><span id='' style='float: right;'><span " + fonitstyle + ">" + conlabel +
                          content + "</span></span></li></ul><div class='listone-other'>" +
                          other +
                          "</div></div>";
                      }
                      if (isheader == "yes") { //要头部栏
                        if (lo == 0) {
                          switch (headstyle) { //判断头部栏方式
                            case "customize":
                              listonehtml +=
                                "<div class='' style='width: 100%;'><div id='header' style='background-color:" +
                                headercolor +
                                ";padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'><div id='' style='font-size: 18px;display: inline-block;color:" +
                                titlecolor + "'>" +
                                headertitle + "</div><a href='" +
                                moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                                "'>更多》</a></div><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><a href='" +
                                url + "'><span  " + fonitstyle + " >" +
                                titlelabel + title +
                                "</span></a><span id='' style='float: right;'><span " +
                                fonitstyle + ">" +
                                conlabel +
                                content + "</span></span></li></ul><div class='listone-other'>" +
                                other +
                                "</div></div>";

                              break;
                            case "headImg":

                              listonehtml +=
                                "<div class='' style='width: 100%;'><div id='header' style='background-image:url(" +
                                headimgsrc +
                                ");padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'>" +
                                "<div id='' style='font-size: 18px;display: inline-block;color:" +
                                titlecolor + "'>" +
                                headertitle + "</div><a href='" +
                                moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                                "'>更多》</a></div>" +
                                "<ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><a href='" +
                                url + "'><span  " + fonitstyle + " >" +
                                titlelabel + title +
                                "</span></a><span id='' style='float: right;'><span " +
                                fonitstyle + ">" +
                                conlabel +
                                content + "</span></span></li></ul><div class='listone-other'>" +
                                other +
                                "</div></div>";
                              break;
                          }


                        } else {
                          listonehtml +=
                            "<div class='listone-list' style='width: 100%;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><a href='" +
                            url + "'><span  " + fonitstyle + " >" +
                            titlelabel + title +
                            "</span></a><span id='' style='float: right;'><span " + fonitstyle + ">" + conlabel +
                            content + "</span></span></li></ul><div class='listone-other'>" +
                            other +
                            "</div></div>";
                        }


                      }
                    } else { //要行前缀
                      if (isheader == "no") { //不要头部栏
                        listonehtml +=
                          "<div class='listone-list' style='width: 98%;margin-left: 20px;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li style='margin-left: -20px;'><div style='display:inline-block;float: left;'><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                          prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                          url + "'><span  " +
                          fonitstyle + " >" +
                          titlelabel + title +
                          "</span></a></div><span id='' style='float: right;'><span " +
                          fonitstyle + ">" + conlabel +
                          content + "</span></span></li></ul><div class='listone-other'>" +
                          other +
                          "</div></div>";
                      }
                      if (isheader == "yes") { //要头部栏
                        // 										alert(headimgsrc);
                        // 										alert(headstyle);
                        if (lo == 0) {
                          switch (headstyle) { //判断头部栏方式
                            case "customize":

                              listonehtml +=
                                "<div class='' style='width: 100%;'><div id='header' style='background-color:" +
                                headercolor +
                                ";padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'><div id='' style='font-size: 18px;display: inline-block;color:" +
                                titlecolor + "'>" +
                                headertitle + "</div><a href='" +
                                moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                                "'>更多》</a></div><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                                prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                                url + "'><span  " + fonitstyle + " >" +
                                titlelabel + title +
                                "</span></a><span id='' style='float: right;'><span " +
                                fonitstyle + ">" +
                                conlabel +
                                content + "</span></span></li></ul><div class='listone-other'>" +
                                other +
                                "</div></div>";
                              break;
                            case "headImg":

                              listonehtml +=
                                "<div class='' style='width: 100%;'><div id='header' style='background-image:url(" +
                                headimgsrc +
                                ");padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'>" +
                                "<div id='' style='font-size: 18px;display: inline-block;color:" +
                                titlecolor + "'>" +
                                headertitle + "</div><a href='" +
                                moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                                "'>更多》</a></div>" +
                                "<ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                                prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                                url + "'><span  " + fonitstyle + " >" +
                                titlelabel + title +
                                "</span></a><span id='' style='float: right;'><span " +
                                fonitstyle + ">" +
                                conlabel +
                                content + "</span></span></li></ul><div class='listone-other'>" +
                                other +
                                "</div></div>";

                              break;
                          }

                        } else {
                          listonehtml +=
                            "<div class='listone-list' style='width: 100%;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                            prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                            url + "'><span  " + fonitstyle + " >" +
                            titlelabel + title +
                            "</span></a><span id='' style='float: right;'><span " + fonitstyle + ">" + conlabel +
                            content + "</span></span></li></ul><div class='listone-other'>" +
                            other +
                            "</div></div>";



                        }



                      }
                    }

                    /* 	listonehtml +=
										'<span leipiplugins="score" style="display:inline-block;width:;height:;font-size:16px" orgwidth="" orgheight=""' +
										'orgfontsize="16px" name="cupy">&nbsp;<a title="1分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a' +
										'title="2分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a title="3分" class="color_gray"><span' +
										'class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a title="4分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a' +
										'title="5分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a></span>';


 */








                    break;
                  case 'type-six':
                    listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                      '<dl>' +
                      '<dt style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;font-size:14px;">' +
                      wenbenkuang1 +
                      '</dt>' +
                      '<dd>' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) + '</dd>' +
                      '<dd style="width:40%;color:#D3D3D3;float:left;font-size:12px;">' + titlelabel + title +
                      '</dd>' +
                      '<dd style="width:60%;color:#D3D3D3;float:left;font-size:12px;">' + conlabel + content +
                      '</dd>' +
                      '</dl>' +
                      '</a><div class="listone-other">' + other + '</div>' +
                      '</div>';

                    break;
                  case 'type-seven':
                    listonehtml += '<div class="typeseven-list" style="width: 300px;height: 300px;margin: 10px;"  > ' +
                      '<div class="typeseven-pic" height="200px" width="100%">' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) +
                      '</div>' +
                      '<div class="typeseven-info" style="margin-left: 5px"  >' +
                      '<p id="title" type="text"><font size="3" >' + titlelabel + title + '</font> </p>' +
                      '<p id="text" type="text"><font size="2" color="darkgray">' + conlabel + content + '</font> </p>' +
                      '</div>' +
                      '<div class="typeseven-other" style="margin: 5px"  > <hr style="height:1px;none;border-top:1px solid #555555;"/>'+
                      '<div class="typeseven_other_date" style="float: left">'+  date +'</div>'+
                      '<div class="typeseven_other_more" style="float: right"><a href="'+typesevenurl+'">MORE+</a></div>'+
                      '</div>' +
                      '</div>';
                    break;
                }
              }
            }
          } else {
            for (var lo = 0; lo < listonelist.length; lo++) {
              other = '';
              url = '/editor/assets/ueditor/formdesign/preview.html?id=' + nid + '&name=' + name +
                '&method=watch&selectId=' + listonelist[lo].id + '&iscomment=' + iscomment + scoreUrlStr;
              // url="/folder/staticPage/"+getPYFC(name)+".html";
              if (listurl != '' && listurl != 'null' && listurl != undefined) {
                url = listurl;
              }

              //frmedit,frmdel
              editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + nid + '&name=' + name +
                '&method=change&selectId=' + listonelist[lo].id;
              if (frmedit == '1') {
                other = "<span data-link='" + editlink +
                  "' class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
              }
              if (frmdel == '1') {
                other += " &nbsp;<span data-nid=" + listonelist[lo].id + " data-name='" + name +
                  "' data-type='listone' class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
              }
              title = setStringLength(listonelist[lo][ctitle], tsize);
              content = setStringLength(listonelist[lo][con], csize);
              date = setStringLength(listonelist[lo][con2], csize);
              wenbenkuang1 = setStringLength(listonelist[lo]['wenbenkuang1']);

              if (title == undefined || title == null || title == "") continue;
              title = title.replace(" ", "");
              // content = content.replace(" ", "");
              if (title == "") continue;


              switch (tpl) {
                case 'type-one':
                  listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                    '<div class="listone-pic">' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) +
                    '</div>' +
                    '<div class="listone-info">' +
                    '<div><span ' + fonitstyle + '>' + titlelabel + title + '</span></div>' +
                    '<div><span ' + fonitstyle + '>' + conlabel + content + '</span></div>' +
                    '</div>' +
                    '</a>' +
                    '<div class="listone-other">' + other + '</div>' +
                    '</div>';
                  break;
                case 'type-two':
                  listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                    '<dl>' +
                    '<dt>' +
                    doFormListImgWH(listonelist[lo][pic], listpicw, listpich) + '</dt>' +
                    '<dd ' + fonitstyle + '>' + titlelabel + title + '</dd>' +
                    '<dd ' + fonitstyle + '>' + conlabel + content + '</dd>' +
                    '</dl>' +
                    '</a><div class="listone-other">' + other + '</div>' +
                    '</div>';
                  break;
                case 'type-three':
                  listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                    '<dl>' +
                    '<dt>' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) +
                    '</dt>' +
                    '<dd ' + fonitstyle + '>' + titlelabel + title + '</dd>' +
                    '</dl>' +
                    '</a><div class="listone-other">' + other + '</div>' +
                    '</div>';
                  break;
                case 'type-four':
                  listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                    '<dl class="listone-type-four">' +
                    '<dt ' + fonitstyle + '>' +
                    setStringLength(listonelist[lo][pic], picfontsize) +
                    '</dt>' +
                    '<dd style="color:#afacac;font-size:12px;">' + titlelabel + title + '</dd>' +
                    '<dd style="color:#afacac;font-size:12px;">' + conlabel + content + '</dd>' +
                    '</dl>' +
                    '</a><div class="listone-other">' + other + '</div>' +
                    '</div>';
                  break;
                case 'type-five':
                  if (prefix == undefined || prefix == '') { //不要行前缀
                    if (isheader == "no") { //不要头部栏
                      listonehtml +=
                        "<div class='listone-list' style='width: 98%;margin-left: 20px;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li style='margin-left: -20px;'><a href='" +
                        url + "'><span  " + fonitstyle + " >" +
                        titlelabel + title +
                        "</span></a><span id='' style='float: right;'><span " + fonitstyle + ">" + conlabel +
                        content + "</span></span></li></ul><div class='listone-other'>" +
                        other +
                        "</div></div>";
                    }
                    if (isheader == "yes") { //要头部栏
                      if (lo == 0) {
                        switch (headstyle) { //判断头部栏方式
                          case "customize":
                            listonehtml +=
                              "<div class='' style='width: 100%;'><div id='header' style='background-color:" +
                              headercolor +
                              ";padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'><div id='' style='font-size: 18px;display: inline-block;color:" +
                              titlecolor + "'>" +
                              headertitle + "</div><a href='" +
                              moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                              "'>更多》</a></div><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><a href='" +
                              url + "'><span  " + fonitstyle + " >" +
                              titlelabel + title +
                              "</span></a><span id='' style='float: right;'><span " +
                              fonitstyle + ">" +
                              conlabel +
                              content + "</span></span></li></ul><div class='listone-other'>" +
                              other +
                              "</div></div>";

                            break;
                          case "headImg":

                            listonehtml +=
                              "<div class='' style='width: 100%;'><div id='header' style='background-image:url(" +
                              headimgsrc +
                              ");padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'>" +
                              "<div id='' style='font-size: 18px;display: inline-block;color:" +
                              titlecolor + "'>" +
                              headertitle + "</div><a href='" +
                              moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                              "'>更多》</a></div>" +
                              "<ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><a href='" +
                              url + "'><span  " + fonitstyle + " >" +
                              titlelabel + title +
                              "</span></a><span id='' style='float: right;'><span " +
                              fonitstyle + ">" +
                              conlabel +
                              content + "</span></span></li></ul><div class='listone-other'>" +
                              other +
                              "</div></div>";
                            break;
                        }


                      } else {
                        listonehtml +=
                          "<div class='listone-list' style='width: 100%;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><a href='" +
                          url + "'><span  " + fonitstyle + " >" +
                          titlelabel + title +
                          "</span></a><span id='' style='float: right;'><span " + fonitstyle + ">" + conlabel +
                          content + "</span></span></li></ul><div class='listone-other'>" +
                          other +
                          "</div></div>";
                      }


                    }
                  } else { //要行前缀
                    if (isheader == "no") { //不要头部栏
                      listonehtml +=
                        "<div class='listone-list' style='width: 98%;margin-left: 20px;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li style='margin-left: -20px;'><div style='display:inline-block;float: left;'><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                        prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                        url + "'><span  " +
                        fonitstyle + " >" +
                        titlelabel + title +
                        "</span></a></div><span id='' style='float: right;'><span " +
                        fonitstyle + ">" + conlabel +
                        content + "</span></span></li></ul><div class='listone-other'>" +
                        other +
                        "</div></div>";
                    }
                    if (isheader == "yes") { //要头部栏
                      // 										alert(headimgsrc);
                      // 										alert(headstyle);
                      if (lo == 0) {
                        switch (headstyle) { //判断头部栏方式
                          case "customize":

                            listonehtml +=
                              "<div class='' style='width: 100%;'><div id='header' style='background-color:" +
                              headercolor +
                              ";padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'><div id='' style='font-size: 18px;display: inline-block;color:" +
                              titlecolor + "'>" +
                              headertitle + "</div><a href='" +
                              moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                              "'>更多》</a></div><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                              prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                              url + "'><span  " + fonitstyle + " >" +
                              titlelabel + title +
                              "</span></a><span id='' style='float: right;'><span " +
                              fonitstyle + ">" +
                              conlabel +
                              content + "</span></span></li></ul><div class='listone-other'>" +
                              other +
                              "</div></div>";
                            break;
                          case "headImg":

                            listonehtml +=
                              "<div class='' style='width: 100%;'><div id='header' style='background-image:url(" +
                              headimgsrc +
                              ");padding: 10px;width: 100%;-webkit-border-radius: 5px;border-radius: 5px;margin-top: 5px;'>" +
                              "<div id='' style='font-size: 18px;display: inline-block;color:" +
                              titlecolor + "'>" +
                              headertitle + "</div><a href='" +
                              moreurl + "' style='font-size: 18px;float: right;color:" + titlecolor +
                              "'>更多》</a></div>" +
                              "<ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                              prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                              url + "'><span  " + fonitstyle + " >" +
                              titlelabel + title +
                              "</span></a><span id='' style='float: right;'><span " +
                              fonitstyle + ">" +
                              conlabel +
                              content + "</span></span></li></ul><div class='listone-other'>" +
                              other +
                              "</div></div>";

                            break;
                        }

                      } else {
                        listonehtml +=
                          "<div class='listone-list' style='width: 100%;'><ul style='list-style:none;margin-left: 25px;display: block;margin-top: 10px;width:95%;'><!-- 圆形：不写；正方形：square；三角形： --><li><img src='/editor/assets/ueditor/formdesign/self/tpl/img/" +
                          prefix + ".png' style='margin-top: -6px;' >&nbsp&nbsp<a href='" +
                          url + "'><span  " + fonitstyle + " >" +
                          titlelabel + title +
                          "</span></a><span id='' style='float: right;'><span " + fonitstyle + ">" + conlabel +
                          content + "</span></span></li></ul><div class='listone-other'>" +
                          other +
                          "</div></div>";



                      }



                    }
                  }

                  /* 	listonehtml +=
										'<span leipiplugins="score" style="display:inline-block;width:;height:;font-size:16px" orgwidth="" orgheight=""' +
										'orgfontsize="16px" name="cupy">&nbsp;<a title="1分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a' +
										'title="2分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a title="3分" class="color_gray"><span' +
										'class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a title="4分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a>&nbsp;&nbsp;<a' +
										'title="5分" class="color_gray"><span class="glyphicon glyphicon-star"></span></a></span>';


 */








                  break;
                case 'type-six':
                  listonehtml += '<div class="listone-list"><a href="' + url + '">' +
                    '<dl>' +
                    '<dt style="overflow:hidden;text-overflow:ellipsis;white-space:nowrap;font-size:14px;">' +
                    wenbenkuang1 +
                    '</dt>' +
                    '<dd>' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) + '</dd>' +
                    '<dd style="width:40%;color:#D3D3D3;float:left;font-size:12px;">' + titlelabel + title +
                    '</dd>' +
                    '<dd style="width:60%;color:#D3D3D3;float:left;font-size:12px;">' + conlabel + content +
                    '</dd>' +
                    '</dl>' +
                    '</a><div class="listone-other">' + other + '</div>' +
                    '</div>';

                  break;
                  case 'type-seven':
                    listonehtml += '<div class="typeseven-list" style="width: 300px;height: 300px;margin: 10px;"  > ' +
                      '<div class="typeseven-pic" height="200px" width="100%">' + doFormListImgWH(listonelist[lo][pic], listpicw, listpich) +
                      '</div>' +
                      '<div class="typeseven-info" style="margin-left: 5px"  >' +
                      '<p id="title" type="text"><font size="3" >' + titlelabel + title + '</font> </p>' +
                      '<p id="text" type="text"><font size="2" color="darkgray">' + conlabel + content + '</font> </p>' +
                      '</div>' +
                      '<div class="typeseven-other" style="margin: 5px"  > <hr style="height:1px;none;border-top:1px solid #555555;"/>'+
                      '<div class="typeseven_other_date" style="float: left">'+ date +'</div>'+
                      '<div class="typeseven_other_more" style="float: right"><a href="'+typesevenurl+'">MORE+</a></div>'+
                      '</div>' +
                      '</div>';
                    break;

              }
            }
          }

          if (showpage == 'on') {
            // alert(pagingstyle)
            switch (pagingstyle) {
              case "pagingstyle1":
                var total = res.msg.count;
                var pnumer = Math.ceil(total / parseInt(pagesize));
                var pagecon = '<ul class="listpage">';
                for (var i = 1; i <= pnumer; i++) {
                  if (page == i) {
                    pagecon += '<li class="cur_page">' + i + '</li>';
                  } else {
                    pagecon += '<li onclick="getListOne(\'' + nid + '\',\'' + name + '\',\'' + cla + '\',' + i +
                      ',\'' +
                      pagesize +
                      '\',\'' + showpage + '\',\'' + pic + '\',\'' + ctitle + '\',\'' + con + '\',\'' + tpl +
                      '\',\'' + tsize +
                      '\',\'' + csize + '\',\'' + listurl + '\',\'' + listpicw + '\',\'' + listpich + '\',\'' +
                      titlelabel +
                      '\',\'' + conlabel + '\',\'' + frmedit + '\',\'' + frmdel + '\',\'' + fontsize + '\',' +
                      searchfile + ',' +
                      searchcon + ',' + picfontsize + ',\'' + listheight + '\',\'' + isnotuser + '\',\'' +
                      prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                      headercolor + '\',\'' + titlecolor + '\',\'' + iscomment + '\',\'' + headstyle + '\',\'' +
                      headimgsrc +
                      '\',\'' + pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource +
                      '\',\'' +
                      statistical + '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + con2 + '\',\'' + typesevendate + '\')">' + i +
                      '</li>';
                  }
                }
                pagecon += '<li class="page_msg">总共' + total + '条记录</li>';
                pagecon += '</ul>';
                listonehtml += pagecon;
                break;
              case "pagingstyle2":

                var total = res.msg.count;
                var pnumer = Math.ceil(total / parseInt(pagesize));
                var pagecon = '<ul class="listpage pagingstyle2">';
                //首页
                pagecon += '<li onclick="getListOne(\'' + nid + '\',\'' + name + '\',\'' + cla + '\',' + 1 +
                  ',\'' +
                  pagesize +
                  '\',\'' + showpage + '\',\'' + pic + '\',\'' + ctitle + '\',\'' + con + '\',\'' + tpl + '\',\'' +
                  tsize +
                  '\',\'' + csize + '\',\'' + listurl + '\',\'' + listpicw + '\',\'' + listpich + '\',\'' +
                  titlelabel +
                  '\',\'' + conlabel + '\',\'' + frmedit + '\',\'' + frmdel + '\',\'' + fontsize + '\',' +
                  searchfile + ',' +
                  searchcon + ',' + picfontsize + ',\'' + listheight + '\',\'' + isnotuser + '\',\'' +
                  prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                  headercolor + '\',\'' + titlecolor + '\',\'' + iscomment + '\',\'' + headstyle + '\',\'' +
                  headimgsrc +
                  '\',\'' + pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource +
                  '\',\'' +
                  statistical +
                  '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + con2 + '\',\'' + typesevendate + '\')" class="">首页</li>';
                //上一页
                var i2 = 1;
                if (page != 1) {
                  i2 = page - 1;
                }
                pagecon += '<li onclick="getListOne(\'' + nid + '\',\'' + name + '\',\'' + cla + '\',' + i2 +
                  ',\'' +
                  pagesize +
                  '\',\'' + showpage + '\',\'' + pic + '\',\'' + ctitle + '\',\'' + con + '\',\'' + tpl + '\',\'' +
                  tsize +
                  '\',\'' + csize + '\',\'' + listurl + '\',\'' + listpicw + '\',\'' + listpich + '\',\'' +
                  titlelabel +
                  '\',\'' + conlabel + '\',\'' + frmedit + '\',\'' + frmdel + '\',\'' + fontsize + '\',' +
                  searchfile + ',' +
                  searchcon + ',' + picfontsize + ',\'' + listheight + '\',\'' + isnotuser + '\',\'' +
                  prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                  headercolor + '\',\'' + titlecolor + '\',\'' + iscomment + '\',\'' + headstyle + '\',\'' +
                  headimgsrc +
                  '\',\'' + pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource +
                  '\',\'' +
                  statistical +
                  '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + con2 + '\',\'' + typesevendate + '\')" class="">上一页</li>';

                var endnum = 0; //循环的最后一个页码
                var beginnum = 0; //循环的第一个页码


                if (page >= 3 && pnumer > 5) {
                  beginnum = page - 2;
                } else {
                  beginnum = 1;
                }

                if (pnumer <= 5) {
                  endnum = pnumer;
                } else {
                  endnum = beginnum + 4;
                  if (endnum > pnumer) {
                    endnum = pnumer;
                  }
                }

                if (beginnum != 1) {
                  pagecon += '<strong id="fdf">...</strong>';
                }

                for (var i = beginnum; i <= endnum; i++) {
                  if (page == i) {
                    pagecon += '<li class="cur_page pagingcolor">' + i + '</li>';
                  } else {
                    pagecon += '<li onclick="getListOne(\'' + nid + '\',\'' + name + '\',\'' + cla + '\',' + i +
                      ',\'' +
                      pagesize +
                      '\',\'' + showpage + '\',\'' + pic + '\',\'' + ctitle + '\',\'' + con + '\',\'' + tpl +
                      '\',\'' + tsize +
                      '\',\'' + csize + '\',\'' + listurl + '\',\'' + listpicw + '\',\'' + listpich + '\',\'' +
                      titlelabel +
                      '\',\'' + conlabel + '\',\'' + frmedit + '\',\'' + frmdel + '\',\'' + fontsize + '\',' +
                      searchfile + ',' +
                      searchcon + ',' + picfontsize + ',\'' + listheight + '\',\'' + isnotuser + '\',\'' +
                      prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                      headercolor + '\',\'' + titlecolor + '\',\'' + iscomment + '\',\'' + headstyle + '\',\'' +
                      headimgsrc +
                      '\',\'' + pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource +
                      '\',\'' +
                      statistical + '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + con2 + '\',\'' + typesevendate + '\')">' + i +
                      '</li>';
                  }
                }


                if (endnum != pnumer) {
                  pagecon += '<strong id="fdf">...</strong>';
                }





                //下一页
                var i3 = pnumer;
                if (page != pnumer) {
                  i3 = page + 1;
                }
                pagecon += '<li onclick="getListOne(\'' + nid + '\',\'' + name + '\',\'' + cla + '\',' + i3 +
                  ',\'' +
                  pagesize +
                  '\',\'' + showpage + '\',\'' + pic + '\',\'' + ctitle + '\',\'' + con + '\',\'' + tpl + '\',\'' +
                  tsize +
                  '\',\'' + csize + '\',\'' + listurl + '\',\'' + listpicw + '\',\'' + listpich + '\',\'' +
                  titlelabel +
                  '\',\'' + conlabel + '\',\'' + frmedit + '\',\'' + frmdel + '\',\'' + fontsize + '\',' +
                  searchfile + ',' +
                  searchcon + ',' + picfontsize + ',\'' + listheight + '\',\'' + isnotuser + '\',\'' +
                  prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                  headercolor + '\',\'' + titlecolor + '\',\'' + iscomment + '\',\'' + headstyle + '\',\'' +
                  headimgsrc +
                  '\',\'' + pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource +
                  '\',\'' +
                  statistical +
                  '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + con2 + '\',\'' + typesevendate + '\')" class="">下一页</li>';
                //最后一页
                pagecon += '<li onclick="getListOne(\'' + nid + '\',\'' + name + '\',\'' + cla + '\',' + pnumer +
                  ',\'' +
                  pagesize +
                  '\',\'' + showpage + '\',\'' + pic + '\',\'' + ctitle + '\',\'' + con + '\',\'' + tpl + '\',\'' +
                  tsize +
                  '\',\'' + csize + '\',\'' + listurl + '\',\'' + listpicw + '\',\'' + listpich + '\',\'' +
                  titlelabel +
                  '\',\'' + conlabel + '\',\'' + frmedit + '\',\'' + frmdel + '\',\'' + fontsize + '\',' +
                  searchfile + ',' +
                  searchcon + ',' + picfontsize + ',\'' + listheight + '\',\'' + isnotuser + '\',\'' +
                  prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                  headercolor + '\',\'' + titlecolor + '\',\'' + iscomment + '\',\'' + headstyle + '\',\'' +
                  headimgsrc +
                  '\',\'' + pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource +
                  '\',\'' +
                  statistical +
                  '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + con2 + '\',\'' + typesevendate + '\')" class="">最后一页</li>';
                pagecon += '<li class="page_msg">总共' + total + '条记录</li>';
                pagecon += '</ul>';
                listonehtml += pagecon;
                break;
            }
          }
        } else {
          // listonehtml = "没有数据哦~";
        }


        // var params = decodeURI(window.location.search); //（?xxx=ddd&xxx=ddd）
        console.log(params)
        //对数据进行分页，用于点击评分饼状统计后，显示的数据
        if (params) {
          //从params中获取method的参数值
          var urlValues = params.split("?")[1].split("&"); //xxx=dd,xxx=dd数组
          for (var i = 0; i < urlValues.length; i++) {
            var urlValue = urlValues[i];
            var proName = urlValue.split("=")[0]; //属性名
            var proValue = urlValue.split("=")[1]; //属性值
            if (proName == "sR") {
              //记录总数
              console.log(scoreCount);
              if (scoreCount <= 15) {

              } else {
                var olistClas = $('.listone-list');

                olistClas.hide();
                olistClas.each(function(i, n) {
                  if (i <= 15) {
                    $(n).show();
                  }
                });
                // var total = res.msg.count;
                var pnumer = Math.ceil(scoreCount / parseInt(15));
                var pagecon = '<div><ul class="listpage pagingstyle2">';
                var page = 1;
                //首页
                pagecon += '<li onclick="jumpToPage(this)" class="">首页</li>';
                //上一页
                var i2 = 1;
                if (page != 1) {
                  i2 = page - 1;
                }
                pagecon += '<li onclick="jumpToPage(this)" class="">上一页</li>';
                //每一页
                for (var i = 1; i <= pnumer; i++) {
                  if (page == i) {
                    pagecon += '<li class="pagenum cur_page pagingcolor" onclick="jumpToPage(this)">' + i +
                      '</li>';
                  } else {
                    pagecon += '<li class="pagenum" onclick="jumpToPage(this)">' + i + '</li>';
                  }
                }
                pagecon += '<li onclick="jumpToPage(this)" class="">下一页</li>';
                //最后一页
                pagecon += '<li onclick="jumpToPage(this)" class="">最后一页</li>';
                pagecon += '</ul></div>';
                listonehtml += pagecon;


                $('.pagenum').each(function(i, n) {
                  if (pnumer >= 5) {
                    if (i >= 5) {
                      $(n).hide();
                    }
                  }
                });
              }




            }
          }
        }









        if (multisource == 'multisource') {
          console.log("这里是列表清空");
          $('.listonetpl').hide();
          $('.listonetpl').empty();
        }
        console.log(statistical)
        var Pcla = $('.' + cla);
        Pcla.show();
        if (statistical == 'statistical') {
          if (Pcla.length > 0) {
            Pcla.append(listonehtml);
          }
        } else {
          if (Pcla.length > 0) {
            Pcla.html(listonehtml);
          }
        }

      } else {}
    }
  })
}



function jumpToPage(e) {
  var opage = $(e);

  var thispage = opage.html();
  var tonumindex = null;

  switch (thispage) {
    case '首页':
      $('.pagenum').removeClass('cur_page');
      $('.pagenum').removeClass('pagingcolor');
      $('.pagenum').hide();
      $('.pagenum').each(function(i, n) {
        if (i == 0) {
          $(n).addClass('cur_page');
          $(n).addClass('pagingcolor');
        }
        if (i <= 4) {
          $(n).show();
        }

      })



      var olistClas = $('.listone-list');
      olistClas.hide();
      olistClas.each(function(i, n) {
        if (i <= 15) {
          $(n).show();
        }
      });


      break;
    case '上一页':
      $('.cur_page').each(function(i, n) {

        var tnum = $(n).html();
        console.log(tnum)
        if (tnum == 1) return false;
        tonumindex = tnum - 2;
        $(n).removeClass('cur_page');
        $(n).removeClass('pagingcolor');

      })

      if (tonumindex == null) break;

      var showbeginnum = null;
      var showendnum = null;
      $('.pagenum').each(function(i, n) {
        if (i == tonumindex) {
          $(n).addClass('cur_page');
          $(n).addClass('pagingcolor');
          showbeginnum = parseInt($(n).html()) - 2;
          showendnum = parseInt($(n).html()) + 2;
        }


      })
      $('.pagenum').hide();
      $('.pagenum').each(function(i, n) {
        if (i >= showbeginnum && i <= showendnum) {
          $(n).show();
        }
        if (showbeginnum <= 1 && i <= 4) {
          $(n).show();
        }
      })

      var olistClas = $('.listone-list');
      olistClas.hide();
      olistClas.each(function(i, n) {
        if (i == 0) {
          $(n).show();
        }

        if (i > (tonumindex + 1) * 15 - 15 && i <= (tonumindex + 1) * 15) {
          $(n).show();
        }
      });


      break;
    case '下一页':


      $('.cur_page').each(function(i, n) {

        var tnum = $(n).html();
        tnum = parseInt(tnum);
        if (tnum == $('.pagenum').length) return false;
        tonumindex = tnum;
        $(n).removeClass('cur_page');
        $(n).removeClass('pagingcolor');

      })

      if (tonumindex == null) break;
      var showbeginnum = null;
      var showendnum = null;
      $('.pagenum').each(function(i, n) {
        if (i == tonumindex) {
          $(n).addClass('cur_page');
          $(n).addClass('pagingcolor');
          showbeginnum = parseInt($(n).html()) - 2;
          showendnum = parseInt($(n).html()) + 2;
        }

      })

      $('.pagenum').hide();
      $('.pagenum').each(function(i, n) {
        if (i >= showbeginnum && i <= showendnum) {
          $(n).show();
        }
        if (showendnum >= $('.pagenum').length && i >= $('.pagenum').length - 6) {
          $(n).show();
        }


      })

      var olistClas = $('.listone-list');
      olistClas.hide();
      olistClas.each(function(i, n) {
        if (i == 0) {
          $(n).show();
        }
        var d = 1 + parseInt(tonumindex);
        if (i > d * 15 - 15 && i <= d * 15) {
          console.log(i);
          $(n).show();
        }
      });


      break;
    case '最后一页':

      $('.pagenum').removeClass('cur_page');
      $('.pagenum').removeClass('pagingcolor');
      $('.pagenum').hide();
      $('.pagenum').each(function(i, n) {
        if (i == $('.pagenum').length - 1) {
          $(n).addClass('cur_page');
          $(n).addClass('pagingcolor');
        }
        if (i >= $('.pagenum').length - 5) {
          $(n).show();
        }

      })



      var olistClas = $('.listone-list');
      olistClas.hide();
      olistClas.each(function(i, n) {
        if (i == 0) {
          $(n).show();
        }
        if (i > $('.pagenum').length * 15 - 15 && i <= $('.pagenum').length * 15) {
          $(n).show();
        }
      });

      break;
    default:
      $('.pagenum').removeClass('cur_page');
      $('.pagenum').removeClass('pagingcolor');
      opage.addClass('cur_page');
      opage.addClass('pagingcolor');

      var showbeginnum = parseInt(thispage) - 2;
      var showendnum = parseInt(thispage) + 2;
      // if (showbeginnum > 1 && showendnum < $('.pagenum').length) {
      $('.pagenum').hide();
      $('.pagenum').each(function(i, n) {
        if (i >= showbeginnum && i <= showendnum) {
          $(n).show();
        }

      })
      // }





      var olistClas = $('.listone-list');
      olistClas.hide();
      olistClas.each(function(i, n) {
        if (i == 0) {
          $(n).show();
        }
        if (i > thispage * 15 - 15 && i <= thispage * 15) {
          $(n).show();
        }
      });
      break;
  }







}





function pageToOther(data) {
  alert(data.innerText)

}




function doTime(formNid, formName, formTpl, page, pagesize, showpage, datafields, headshow, frmedit, frmdel, cla, url,
  listpicw, listpich, searchfile, searchcon, fsize, llineheight, personage_info) {
  clearInterval(myforllisttime);
  myforllisttime = setInterval(function() {
    getFormList(formNid, formName, formTpl, 1, pagesize, showpage, datafields, headshow, frmedit, frmdel, cla, url,
      listpicw, listpich, searchfile, searchcon, fsize, llineheight, personage_info);
  }, 5000);
}






//审核
function updateIsApprove(formNid, selectId) {
  console.log("进入方法")
  document.getElementById('btn-update').innerHTML = "已审核";
  /* var val = document.getElementById("btn-update");
      if (val.innerHTML == "审核") {
          obj.innerHTML = "已审核";
        } */
  // 1点击时改变内容为  已审核
  // id.innerHTML = "已审核";

  //  2  修改审核字段为1  已审核
  //   approveInfoFacae/updataApproveInfo
  var updatedata = {
    "nodeId": formNid,
    "selectId": selectId,
    "isApprove": "1"
  }
  var tempData3 = null;
  $.ajax({
    url: prevent_HOST + 'approveInfoFacae/updataApproveInfo',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    async: true,
    data: JSON.stringify(updatedata),
    success: function(res3) {
      if (res3.status == "200") {

        tempData3 = res3.msg;


        console.log("更新审核" + tempData3);
      }
    }
  })


}



function getFormList(formNid, formName, formTpl, page, pagesize, showpage, datafields, headshow, frmedit, frmdel,
  frmexa, cla,
  url, listpicw, listpich, searchfile, searchcon, fsize, llineheight, personage_info, theaderbackground) {
  var formLists = '';
  var datafile = datafields.substr(1).split(",");
  var ajaxData = {
    "nodeId": formNid,
    "classname": formName,
    "page": page,
    "pageSize": pagesize,
    "table_field_all": searchfile,
    "searchContent": searchcon,
    "orderby": "desc"
  };
  $.ajax({
    url: prevent_HOST + 'pageDesignQueryFacade/selectFormRecordByNodeId',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    async: true,
    data: JSON.stringify(ajaxData),
    success: function(res) {









      if (res.status == '200') {
        if (frmexa == '1') {
          /* /**
           * 进行二次查询
           */
          var queryData = {
            "nodeId": 0,
            "selectId": 0,
            "isApprove": 0
          };
          var tempData1 = null;
          var tempData2 = null;
          $.ajax({
            url: prevent_HOST + 'approveInfoFacae/queryApproveInfo',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            async: false,
            data: JSON.stringify(queryData),
            success: function(res2) {
              if (res2.status == "200") {
                tempData1 = res.msg.data;
                tempData2 = res2.msg;
                console.log("1次查询的数据是" + tempData1);
                console.log("2次查询的数据是" + tempData2);
              }
            }
          })



          var data3 = [];
          for (var as = 0; as < tempData1.length; as++) {
            // tempData1[as].id
            for (var ae = 0; ae < tempData2.length; ae++) {
              //tempData2[ae].selectId
              if (tempData1[as].id == tempData2[ae].selectId) {
                data3.push(tempData1[as]);
              }
            }


          }
          console.log("二次查询的数据是" + data3);
          console.log("是否选中审核按钮" + frmexa);

        }




        if (datafile.length > 0) {
          if (frmexa == '1') {
            var tdata = data3;
          } else {
            var tdata = res.msg.data;
          }

          var listhtml = '';
          var listlink = '';
          var editlink = '';
          var dellink = '';
          var dfs = null;
          var frmexahtml = '';
          var mystyle = "padding:5px;height:" + llineheight + ";line-height:" + llineheight + ";";
          if (fsize != 'null' && fsize != '') mystyle += "font-size: " + fsize + ";";
          switch (formTpl) {
            case "li":
              formLists = '<div class="list-group">';
              for (var i = 0; i < tdata.length; i++) {
                listhtml = '';
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  for (var j = 0; j < datafile.length; j++) {
                    listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                  }

                  editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=change&selectId=' + tdata[i].id;
                  // approvelink='/approveInfoFacae/updataApproveInfo?nodeId=' + formNId +'&selectId='+ tdata[i].id +'&isApprove='+ 1;
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                    "' class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";

                  if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" +
                    formNid + "," + tdata[i].id +
                    ")'class=' btn btn-info btn-xs badge'>待审核</span>";

                  if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                    formName +
                    "' data-type='li' class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";



                  formLists += '<a href="' + listlink + '" class="list-group-item" style=\'' + mystyle + '\'>' +
                    listhtml +
                    '</a>';
                } else {
                  if (parseInt(personage_info) == 0) {
                    for (var j = 0; j < datafile.length; j++) {
                      listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                    }

                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "' class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";

                    if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" +
                      formNid + "," + tdata[i].id +
                      ")'class=' btn btn-info btn-xs badge'>待审核</span>";
                    if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='li' class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";

                    formLists += '<a href="' + listlink + '" class="list-group-item" style=\'' + mystyle + '\'>' +
                      listhtml +
                      '</a>';
                  }
                }
              }
              if (tdata.length == 0) formLists += "没有数据哦~";
              formLists += '</div>';
              break;
            case "table_td":
              formLists = '<table class="formlist_table_td">';
              if (headshow == "1" && theaderbackground == "1") {
                //如果选择显示表格背景颜色
                formLists += '<tr>';
                for (var j = 0; j < datafile.length; j++) {
                  dfs = datafile[j].split(":");
                  formLists += "<th style='border: solid #ffffff 1px;  background:#f6f6f6;" + mystyle + "'>" +
                    dfs[1] + "</th>";
                }
                if (frmedit == '1' || frmdel == '1') {
                  formLists += "<th style='border: solid #ffffff 1px;  background:#f6f6f6;" + mystyle +
                    "'>操作</th>";
                }
                formLists += '</tr>';
              } else if (headshow == "1") {
                //不显示表格背景颜色
                formLists += '<tr>';
                for (var j = 0; j < datafile.length; j++) {
                  dfs = datafile[j].split(":");
                  formLists += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                }
                if (frmedit == '1' || frmdel == '1') {
                  formLists += "<th style='" + mystyle + "'>操作</th>";
                }
                formLists += '</tr>';
              }
              for (var i = 0; i < tdata.length; i++) {
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  listhtml = '<tr>';
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  for (var j = 0; j < datafile.length; j++) {
                    dfs = datafile[j].split(":");
                    listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(tdata[
                        i][dfs[0]],
                      listpicw, listpich) + "</a></td>";
                  }
                  if (frmedit == '1' || frmdel == '1' || frmexa == '1') {
                    listhtml += "<td>";
                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" +
                      formNid + "," + tdata[i].id +
                      ")'class=' btn btn-info btn-xs badge'>待审核</span>";

                    if (frmdel == '1') listhtml += "&nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='table_td'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                    listhtml += "</td>";
                  }
                  listhtml += '</tr>';
                  formLists += listhtml;
                } else {
                  if (parseInt(personage_info) == 0) {
                    listhtml = '<tr>';
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    for (var j = 0; j < datafile.length; j++) {
                      dfs = datafile[j].split(":");
                      listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(
                        tdata[i][dfs[0]],
                        listpicw, listpich) + "</a></td>";
                    }
                    if (frmedit == '1' || frmdel == '1' || frmexa == '1') {
                      listhtml += "<td>";
                      editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                        formName +
                        '&method=change&selectId=' + tdata[i].id;
                      if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                        "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                      if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" + formNid +
                        "," + tdata[i].id +
                        ")'class=' btn btn-info btn-xs badge'>待审核</span>";
                      if (frmdel == '1') listhtml += "&nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                        formName +
                        "' data-type='table_td'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                      listhtml += "</td>";
                    }
                    listhtml += '</tr>';
                    formLists += listhtml;
                  }
                }
              }
              if (tdata.length == 0) formLists += "<tr><td colspan='" + datafile.length + "'>没有数据哦~<td></tr>";
              formLists += '</table>';
              break;
            case "table_vd":
              formLists = '<table class="formlist_table_vd">';
              for (var i = 0; i < tdata.length; i++) {
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  listhtml = '<tr>';
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  for (var j = 0; j < datafile.length; j++) {
                    dfs = datafile[j].split(":");
                    if (headshow == "1") {
                      listhtml += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                    }
                    listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(tdata[
                        i][dfs[0]],
                      listpicw, listpich) + "</a></td>";
                  }
                  if (frmedit == '1' || frmdel == '1' || frmexa == '1') {
                    listhtml += "<td>";
                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" +
                      formNid + "," + tdata[i].id +
                      ")'class=' btn btn-info btn-xs badge'>待审核</span>";
                    if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='table_vd'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                    listhtml += "</td>";
                  }
                  listhtml += '</tr>';
                  formLists += listhtml;
                } else {
                  if (parseInt(personage_info) == 0) {
                    listhtml = '<tr>';
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    for (var j = 0; j < datafile.length; j++) {
                      dfs = datafile[j].split(":");
                      if (headshow == "1") {
                        listhtml += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                      }
                      listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(
                        tdata[i][dfs[0]],
                        listpicw, listpich) + "</a></td>";
                    }
                    if (frmedit == '1' || frmdel == '1' || frmexa == '1') {
                      listhtml += "<td>";
                      editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                        formName +
                        '&method=change&selectId=' + tdata[i].id;
                      if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                        "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                      if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" + formNid +
                        "," + tdata[i].id +
                        ")'class=' btn btn-info btn-xs badge'>待审核</span>";
                      if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                        formName +
                        "' data-type='table_vd'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                      listhtml += "</td>";
                    }
                    listhtml += '</tr>';
                    formLists += listhtml;
                  }
                }
              }
              if (tdata.length == 0) formLists += "<tr><td>没有数据哦~<td></tr>";
              formLists += '</table>';
              break;
            case "span":
              formLists = '';
              for (var i = 0; i < tdata.length; i++) {
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  listhtml = '<span class="formlist_span">';
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  listhtml += '<a href="' + listlink + '"  style="' + mystyle + '" >';
                  for (var j = 0; j < datafile.length; j++) {
                    listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                  }
                  listhtml += '</a>';
                  editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=change&selectId=' + tdata[i].id;
                  if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                    "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                  if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" +
                    formNid + "," + tdata[i].id +
                    ")'class=' btn btn-info btn-xs badge'>待审核</span>";
                  if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                    formName +
                    "' data-type='span'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                  listhtml += "</span>";
                  formLists += listhtml;
                } else {
                  if (parseInt(personage_info) == 0) {
                    listhtml = '<span class="formlist_span">';
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    listhtml += '<a href="' + listlink + '"  style="' + mystyle + '" >';
                    for (var j = 0; j < datafile.length; j++) {
                      listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                    }
                    listhtml += '</a>';
                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmexa == '1') listhtml += "<span id='btn-update' onclick='updateIsApprove(" +
                      formNid + "," + tdata[i].id +
                      ")'class=' btn btn-info btn-xs badge'>待审核</span>";
                    if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='span'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                    listhtml += "</span>";
                    formLists += listhtml;
                  }
                }

              }
              if (tdata.length < 1) {
                editlink = '/editor/assets/ueditor/formdesign/preview.html?link=' + formNid;
                if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                  "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
              }
              if (tdata.length == 0) formLists += "没有数据哦~";
              //formLists += '</div>';
              break;
          }


          if (showpage == 'on') {
            //getPage(listonelist.length,data.pagesize);
            var total = res.msg.count;
            var pnumer = Math.ceil(total / parseInt(pagesize));
            var pagecon = '<ul class="listpage">';
            for (var i = 1; i <= pnumer; i++) {
              if (page == i) {
                pagecon += '<li class="cur_page">' + i + '</li>';
              } else {
                pagecon += '<li onclick="getFormList(' + formNid + ',\'' + formName + '\',\'' + formTpl + '\',' +
                  i + ',' +
                  pagesize + ',\'' + showpage + '\',\'' + datafields + '\',\'' + headshow + '\',\'' + frmedit +
                  '\',\'' +
                  frmdel + '\',\'' + cla + '\',\'' + url + '\',\'' + listpicw + '\',\'' + listpich + '\',' +
                  searchfile + ',' +
                  searchcon + ',\'' + fsize + '\',\'' + llineheight + '\',\'' + personage_info + '\')">' + i +
                  '</li>';
              }
            }
            pagecon += '<li class="page_msg">总共' + total + '条记录</li>';
            pagecon += '</ul>';
            formLists += pagecon;
          }
        }
      } else {
        formLists += "没有数据哦~";
      }
      //showData=formLists;
      var Pcla = $('.' + cla);
      if (Pcla.length > 0) {
        Pcla.html(formLists);
      } else {}

    }
  })

}

function getScheduling(formNid, formName, formTpl, page, pagesize, showpage, datafields, headshow, frmedit, frmdel, cla,
  listpicw, listpich) {
  var formLists = '';
  var url = '';
  var datafile = datafields.substr(1).split(",");
  var ajaxData = {
    "nodeId": 14942,
    "classname": "排课管理",
    "page": page,
    "pageSize": pagesize
  };
  $.ajax({
    url: prevent_HOST + 'pageDesignQueryFacade/selectFormRecordByNodeId',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    // headers:{"token":userToKen},
    async: true,
    data: JSON.stringify(ajaxData),
    success: function(res) {
      if (res.status == '200') {
        if (datafile.length > 0) {
          var tdata = res.msg.data;
          var listhtml = '';
          var listlink = '';
          var editlink = '';
          var dellink = '';
          var dfs = null;
          var frmexahtml = '';
          var mystyle = "padding:0px;height:" + llineheight + ";line-height:" + llineheight + ";";
          if (fsize != 'null' && fsize != '') mystyle += "font-size: " + fsize + ";";
          switch (formTpl) {
            case "li":
              formLists = '<div class="list-group">';
              for (var i = 0; i < tdata.length; i++) {
                listhtml = '';
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  for (var j = 0; j < datafile.length; j++) {
                    listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                  }

                  editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=change&selectId=' + tdata[i].id;
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                    "' class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                  if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                    formName +
                    "' data-type='li' class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";

                  formLists += '<a href="' + listlink + '" class="list-group-item" style=\'' + mystyle + '\'>' +
                    listhtml +
                    '</a>';
                } else {
                  if (parseInt(personage_info) == 0) {
                    for (var j = 0; j < datafile.length; j++) {
                      listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                    }

                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "' class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='li' class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";

                    formLists += '<a href="' + listlink + '" class="list-group-item" style=\'' + mystyle + '\'>' +
                      listhtml +
                      '</a>';
                  }
                }
              }
              if (tdata.length == 0) formLists += "没有数据哦~";
              formLists += '</div>';
              break;
            case "table_td":
              formLists = '<table class="formlist_table_td">';
              if (headshow == "1") {
                formLists += '<tr>';
                for (var j = 0; j < datafile.length; j++) {
                  dfs = datafile[j].split(":");
                  formLists += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                }
                if (frmedit == '1' || frmdel == '1') {
                  formLists += "<th style='" + mystyle + "'>操作</th>";
                }
                formLists += '</tr>';
              }
              for (var i = 0; i < tdata.length; i++) {
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  listhtml = '<tr>';
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  for (var j = 0; j < datafile.length; j++) {
                    dfs = datafile[j].split(":");
                    listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(tdata[
                        i][dfs[0]],
                      listpicw, listpich) + "</a></td>";
                  }
                  if (frmedit == '1' || frmdel == '1') {
                    listhtml += "<td>";
                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmdel == '1') listhtml += "&nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='table_td'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                    listhtml += "</td>";
                  }
                  listhtml += '</tr>';
                  formLists += listhtml;
                } else {
                  if (parseInt(personage_info) == 0) {
                    listhtml = '<tr>';
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    for (var j = 0; j < datafile.length; j++) {
                      dfs = datafile[j].split(":");
                      listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(
                        tdata[i][dfs[0]],
                        listpicw, listpich) + "</a></td>";
                    }
                    if (frmedit == '1' || frmdel == '1') {
                      listhtml += "<td>";
                      editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                        formName +
                        '&method=change&selectId=' + tdata[i].id;
                      if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                        "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                      if (frmdel == '1') listhtml += "&nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                        formName +
                        "' data-type='table_td'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                      listhtml += "</td>";
                    }
                    listhtml += '</tr>';
                    formLists += listhtml;
                  }
                }
              }
              if (tdata.length == 0) formLists += "<tr><td colspan='" + datafile.length + "'>没有数据哦~<td></tr>";
              formLists += '</table>';
              break;
            case "table_vd":
              formLists = '<table class="formlist_table_vd">';
              for (var i = 0; i < tdata.length; i++) {
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  listhtml = '<tr>';
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  for (var j = 0; j < datafile.length; j++) {
                    dfs = datafile[j].split(":");
                    if (headshow == "1") {
                      listhtml += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                    }
                    listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(tdata[
                        i][dfs[0]],
                      listpicw, listpich) + "</a></td>";
                  }
                  if (frmedit == '1' || frmdel == '1') {
                    listhtml += "<td>";
                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='table_vd'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                    listhtml += "</td>";
                  }
                  listhtml += '</tr>';
                  formLists += listhtml;
                } else {
                  if (parseInt(personage_info) == 0) {
                    listhtml = '<tr>';
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    for (var j = 0; j < datafile.length; j++) {
                      dfs = datafile[j].split(":");
                      if (headshow == "1") {
                        listhtml += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                      }
                      listhtml += "<td><a href='" + listlink + "' style='" + mystyle + "'>" + doFormListImgWH(
                        tdata[i][dfs[0]],
                        listpicw, listpich) + "</a></td>";
                    }
                    if (frmedit == '1' || frmdel == '1') {
                      listhtml += "<td>";
                      editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                        formName +
                        '&method=change&selectId=' + tdata[i].id;
                      if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                        "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                      if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                        formName +
                        "' data-type='table_vd'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                      listhtml += "</td>";
                    }
                    listhtml += '</tr>';
                    formLists += listhtml;
                  }
                }
              }
              if (tdata.length == 0) formLists += "<tr><td>没有数据哦~<td></tr>";
              formLists += '</table>';
              break;
            case "span":
              formLists = '';
              for (var i = 0; i < tdata.length; i++) {
                if (parseInt(personage_info) == 1 && tdata[i].getuserid == gUser.id) {
                  listhtml = '<span class="formlist_span">';
                  listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=watch&selectId=' + tdata[i].id;
                  if (url != '' && url != 'null' && url != undefined) {
                    listlink = url;
                  }
                  listhtml += '<a href="' + listlink + ' " style="' + mystyle + '">';
                  for (var j = 0; j < datafile.length; j++) {
                    listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                  }
                  listhtml += '</a>';
                  editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                    '&method=change&selectId=' + tdata[i].id;
                  if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                    "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                  if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                    formName +
                    "' data-type='span'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                  listhtml += "</span>";
                  formLists += listhtml;
                } else {
                  if (parseInt(personage_info) == 0) {
                    listhtml = '<span class="formlist_span">';
                    listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=watch&selectId=' + tdata[i].id;
                    if (url != '' && url != 'null' && url != undefined) {
                      listlink = url;
                    }
                    listhtml += '<a href="' + listlink + ' " style="' + mystyle + '">';
                    for (var j = 0; j < datafile.length; j++) {
                      listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                    }
                    listhtml += '</a>';
                    editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' +
                      formName +
                      '&method=change&selectId=' + tdata[i].id;
                    if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                      "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
                    if (frmdel == '1') listhtml += " &nbsp;<span data-nid=" + tdata[i].id + " data-name='" +
                      formName +
                      "' data-type='span'  class='formlist-del-btn btn btn-danger btn-xs badge'>删除</span>";
                    listhtml += "</span>";
                    formLists += listhtml;
                  }
                }

              }
              if (tdata.length < 1) {
                editlink = '/editor/assets/ueditor/formdesign/preview.html?link=' + formNid;
                if (frmedit == '1') listhtml += "<span data-link='" + editlink +
                  "'  class='formlist-edit-btn btn btn-info btn-xs badge'>编辑</span>";
              }
              if (tdata.length == 0) formLists += "没有数据哦~";
              //formLists += '</div>';
              break;
          }


          if (showpage == 'on') {
            //getPage(listonelist.length,data.pagesize);
            var total = res.msg.count;
            var pnumer = Math.ceil(total / parseInt(pagesize));
            var pagecon = '<ul class="listpage">';
            for (var i = 1; i <= pnumer; i++) {
              if (page == i) {
                pagecon += '<li class="cur_page">' + i + '</li>';
              } else {
                pagecon += '<li onclick="getFormList(' + formNid + ',\'' + formName + '\',\'' + formTpl + '\',' +
                  i + ',' +
                  pagesize + ',\'' + showpage + '\',\'' + datafields + '\',\'' + headshow + '\',\'' + frmedit +
                  '\',\'' +
                  frmdel + '\',\'' + cla + '\',\'' + url + '\',\'' + listpicw + '\',\'' + listpich + '\',' +
                  searchfile + ',' +
                  searchcon + ',\'' + fsize + '\',\'' + llineheight + '\',\'' + personage_info + '\')">' + i +
                  '</li>';
              }
            }
            pagecon += '<li class="page_msg">总共' + total + '条记录</li>';
            pagecon += '</ul>';
            formLists += pagecon;
          }
        }
      } else {
        formLists += "没有数据哦~";
      }
      //showData=formLists;
      var Pcla = $('.' + cla);
      if (Pcla.length > 0) {
        Pcla.html(formLists);
      } else {}

    }
  })
}


function formListDelLink(nid, name) {

  var data = {
    "record": nid,
    "classname": name,
    "method": "updateDelete",
    "flag": 1
  };
  $.ajax({
    url: prevent_HOST + 'pageDesignOperatorFacade/deleteFormRecord',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify(data),
    async: true,
    success: function(res) {

    }
  })
}

/*单个菜单*/
function showSingLenavCh(pluId) {
  var pluchid = $('#' + pluId);
  if (pluchid.css('display') == 'none') {
    pluchid.show();
  } else {
    pluchid.hide();
  }
}





$(function() {

  if (window.parent.location.href != window.location.href) {
    if ($("#dl", window.parent.document)) {
      $("#dl", window.parent.document).empty();
      $("#dl", window.parent.document).css({
        'padding': '2px 10px',
        'border-radius': '3px',
        'cursor': 'pointer',
        'background-color': '#0080ff',
        'color': '#ffffff',
        'font-size': '16px'
      });
      $("#dl", window.parent.document).html("登录");
    }
    if ($("#dl")) {
      $("#dl").empty();
      $("#dl").css({
        'padding': '2px 10px',
        'border-radius': '3px',
        'cursor': 'pointer',
        'background-color': '#0080ff',
        'color': '#ffffff',
        'font-size': '16px'
      });
      $("#dl").html("登录");
    }


  } else {

    var dl = document.getElementById('dl');
    if (dl) {
      $(dl).empty();
      $(dl).css({
        'padding': '2px 10px',
        'border-radius': '3px',
        'cursor': 'pointer',
        'background-color': '#0080ff',
        'color': '#ffffff',
        'font-size': '16px'
      });
      $(dl).html("登录");
    }

  }



  setTimeout(function() {

    var dl = document.getElementById('dl');
    if (window.parent.location.href != window.location.href) {
      dl = window.parent.document.getElementById('dl');
    } else {
      dl = document.getElementById('dl');
    }

    if (dl) {
      var user = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
      if (user) {
        dlStyle = 'height:20px;background:#fff;color:#333;';

        if (dl.getAttribute('fromwhere') == 'headerAndFooter') {
          // dlStyle = 'height:20px;background:#fff;color:#333;position: absolute;top: 20px;right: 100px;';
        }
        console.log(dlStyle)

        if (dl.getAttribute('toaccount') == 'toaccount') {
          loginbox.style.display = 'none';
          over.style.display = 'none';
          //window.location.href="http://47.106.39.210/editor/assets/ueditor/formdesign/preview.html?link=15662";
          dl.style = dlStyle;
          /* dl.innerHTML = '<span onclick="users()">' + user.userName + '</span>' +
          	'<span class="isadmin" onclick="fen()">' +
          	"&nbsp" + "|" + "&nbsp" + '</span>' + '<span id="hou" class="isadmin" onclick="houtai()">' +
          	'<a href="http://47.112.25.185/editor/assets/ueditor/formdesign/preview.html?link=15970"  target = "_blank" style="font-size:16px;text-decoration:none;">' +
          	"进入后台" + '</a>' + '</span>' + '<span onclick="fen()">' + "&nbsp" + "|" + "&nbsp" + '</span>' +
          	'<span id="exit" onclick="exit()" style="cursor:pointer;">' + "退出" + '</span>'; */

          dl.innerHTML = '<span onclick="users()">' + user.userName + '</span>' +
            '<span onclick="fen()">&nbsp|&nbsp</span><span onclick="toaccount()">个人中心</span><span onclick="fen()">&nbsp|&nbsp</span><span id="exit" onclick="exit()" style="cursor:pointer;">' +
            "退出" + '</span>';
        } else {
          loginbox.style.display = 'none';
          over.style.display = 'none';
          dl.style = dlStyle;
          dl.innerHTML = '<span onclick="users()">' + user.userName + '</span>' +
            '<span onclick="fen()">&nbsp|&nbsp</span><span id="exit" onclick="exit()" style="cursor:pointer;">' +
            "退出" +
            '</span>';

        }

        if (gUser.user.isadmin == "1") {
          $('.isadmin').show();
        }
      } else {

      }
    }
  }, 800);







  /*
   * button
   * 点击 按钮 进行跳转
   * 利用 按钮div的 orgurl 树形进行跳转
   *
   */
  $('body').on('click', '#buttonBtn', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    //if (source !== "datatable") {
    var orgUrl = e.currentTarget.getAttribute('orgurl');
    var tgurl = e.currentTarget.getAttribute('tgurl');
    var winname = e.currentTarget.getAttribute('winname');

    var btntype = e.currentTarget.getAttribute('btntype');
    if (btntype == 'frmsubmit' || btntype == 'frmedit') {
      e.preventDefault();
      var record = $("#insertForm").serializeObject();
      record = doStrMarks(record);
      var gid = getQueryString('gid');
      if (gid) record.gid = gid; // 如果有关联的话 就添加 gid 字段
      record.id = currNode.id; // 数据表点击 修改 的时候要用的。
      delete record.leipiNewField; // 我也不知道为什么提交取值的时候会添加这个东西，貌似就是没用的，所以就把它删除了。
      //isSrcs = isSrcs.substring( 0, isSrcs.length - 1 );
      if (record.wxtags != undefined) {
        obj = document.getElementsByName("wxtags");
        check_val = [];
        for (k in obj) {
          if (obj[k].checked)
            check_val.push(obj[k].value);
        }
        record.wxtags = check_val.join(",");
      }
      if (record.msgflag != undefined) {
        record.uId = gUser.id;
      }
      var data = {
        "record": record,
        "classname": currNode.value,
        "method": "insert",
        "user_account": gUser.username
      }
      // console.log(data)
      //if ( isSrc ) data.src = isSrcs; // 如果有 图片控件 就添加 Src 字段
      var tgurlinfo = '';
      var tgnodereg = new RegExp("(^|&)tgurl=([^&]*)(&|$)", "i");
      var rrr = window.location.search.substr(1).match(tgnodereg);
      if (rrr != null) tgurlinfo = unescape(rrr[2]);

      data.record.isDelete = 0; // 添加要增加一个 isDelete字段。
      if (btntype == 'frmsubmit') {
        $.ajax({
          type: 'POST',
          url: prevent_HOST + 'pageDesignOperatorFacade/insertFormRecord',
          contentType: 'application/json; charset=UTF-8',
          headers: {
            "token": userToKen
          },
          dataType: 'json',
          data: JSON.stringify(data),
          success: function(res) {
            if (res['status'] == "200") {
              alert('恭喜您！' + res['statusMsg']);
              window.location.reload();
            } else {
              alert('抱歉！插入单条数据失败，请重试');
            }
          }
        })
      } else if (btntype == 'frmedit') {
        data.method = "update";
        $.ajax({
          url: prevent_HOST + 'pageDesignOperatorFacade/updateFormRecord',
          type: 'POST',
          dataType: 'json',
          contentType: 'application/json; charset=UTF-8',
          headers: {
            "token": userToKen
          },
          data: JSON.stringify(data),
          success: function(res) {
            if (res['status'] == "200") {
              alert('恭喜您！' + res['statusMsg']);
              window.location.reload();
            } else {
              alert('抱歉！更新数据失败，请重试');
            }
          }
        })
      }
    } else {
      if (tgurl != '' && tgurl != null) {
        if (orgUrl.indexOf("?")) {
          orgUrl += "&tgurl=" + tgurl;
        } else {
          orgUrl += "?tgurl=" + tgurl;
        }
      }
      if (winname != '') {
        $("#" + winname).attr("src", orgUrl);
      } else {
        if (orgUrl != '')
          window.location.href = orgUrl;
      }
    }
    //};
  })
})
//弹窗
function doPopup(url, title) {
  $.ligerDialog.open({
    text: title,
    url: url,
    width: null,
    height: 300,
    modal: false
  });
}
//创建富文本
function createMtext(pId, con) {
  uecon = UE.getEditor(pId, {
    toolbars: [
      ['source', 'undo', 'redo', 'bold', 'italic', 'underline', 'strikethrough', 'removeformat',
        'forecolor', 'insertunorderedlist', '|',
        'fontfamily', 'fontsize', 'justifyleft', 'justifycenter', 'justifyright', 'link', 'unlink', 'insertimage',
        'insertvideo', 'cleardoc'
      ]
    ],
    textarea: pId
  });
  if (con != '') {
    setTimeout(function() {
      uecon.setContent(con);
    }, 3000);
  }
}

//报名
function doAddNumber(dadatasource, dadatafiled, daaddvalue, daselectId) {
  console.log(dadatasource, dadatafiled, daaddvalue, daselectId);
  if (daselectId == 'null' || daselectId == '') return;
  if (daaddvalue == 'null' || daaddvalue == '') daaddvalue = 1;
  var dadatasources = dadatasource.split(':');
  var ajaxData = {
    "nodeId": dadatasources[0],
    "nodeName": dadatasources[1],
    "field": dadatafiled,
    "value": daaddvalue,
    "selectid": selectId
  };
  $.ajax({
    url: DEFAULT_JOBURL + 'hdnrService/update',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    data: JSON.stringify(ajaxData),
    async: true,
    success: function(res) {

      if (res.status == '200') {
        alert('报名成功');
      } else {}
    }
  })
}

//下载
function domExcel(dadatasource, dadatafiled) {
  if (dadatasource == 'null' || dadatasource == '') return false;
  if (dadatafiled == 'null' || dadatafiled == '') return false;
  dadatafiled = dadatafiled.substr(1);
  var dadatasources = dadatasource.split(':');
  var ajaxData = {
    "nodeId": dadatasources[0],
    "classname": dadatasources[1],
    "datafield": dadatafiled
  };

  $.ajax({
    url: DEFAULT_URL + 'pageDesignOperatorFacade/derivedForm',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    data: JSON.stringify(ajaxData),
    async: true,
    success: function(res) {
      if (res.status == '200') {
        //http://192.168.0.213/folder/Excel/template1.xls
        open(ROOT_HOST + "/folder/Excel/template1.xls");
      } else {
        alert("导出失败");
      }
    }
  })
}

//记录任务
function doUrge(nodeId, rec_nodename, rec_title, selectId, userstate) {
  showData = '';
  var rec_userid = null;
  var rec_username = null;
  if (gUser != null) {
    rec_userid = gUser.id;
    if (gUser.chinaName == '' || gUser.chinaName == null) {
      rec_username = gUser.chinaName;
    } else {
      rec_username = gUser.userName;
    }
  }

  var recordData = {
    "nodeId": nodeId,
    "nodeName": rec_nodename,
    "title": rec_title,
    "selectId": selectId,
    "userId": rec_userid,
    "username": rec_username,
    "userstate": userstate,
    "state": ""
  };

  $.ajax({
    url: DEFAULT_JOBURL + 'urge/addUrge',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    // headers:{"token":userToKen},
    async: true,
    data: JSON.stringify(recordData),
    success: function(res) {
      if (res.status == '200') {
        alert("提交完成!");
      } else {
        alert("提交失败!");
      }
    }
  })
}

//审批
function setShenPi(id, ust, st, ind) {
  var rec_userid = null;
  if (gUser != null) rec_userid = gUser.id;
  var recordData = {
    "id": id,
    "userId": rec_userid,
    "userstate": ust,
    "state": st
  };

  $.ajax({
    url: DEFAULT_JOBURL + 'urge/update',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    // headers:{"token":userToKen},
    async: true,
    data: JSON.stringify(recordData),
    success: function(res) {
      if (res.status == '200') {
        var spdom = $(".shenpilist:nth-of-type(" + (ind + 1) + ") div").eq(3);
        if (st == "通过") {
          spdom.find('font,.shenpilist_pass,.shenpilist_cb').remove();
          spdom.prepend('<font style="color: #ff0000;">通过</font>');
        } else if (st == '催办') {
          spdom.find('font').remove();
          spdom.prepend('<font style="color: #ff0000;">已经催办</font>');
        }
      }
    }
  })
}

function spChang(spNId, spNname, spFild, spstate, seId, pluheight, fontsize, spdel) {
  var requ = '';
  var spurl = DEFAULT_URL + 'pageDesignQueryFacade/selectTableByNodeIdAndId';
  // var spurl=DEFAULT_JOBURL+'urge/selectUrge';
  if (spstate == '完成' || spstate == '未完成') {
    requ = 'userstate=' + spstate;
  } else if (spstate == '通过' || spstate == '催办') {
    requ = 'state=' + spstate;
  }
  if (requ != '') {
    spurl += "?" + requ;
  }
  if (seId != '0') {
    if (spstate == "全部") {
      spurl += "?nodeId=" + spNId + "&selectId=" + seId;
    } else {
      spurl += "&nodeId=" + spNId + "&selectId=" + seId;
    }

    $.ajax({
      url: spurl,
      method: "GET",
      async: false,
      success: function(res) {
        var shenpicontent = '';
        if (res.status == '200') {
          var style = "height:" + pluheight + ";line-height:" + pluheight + ";font-size:" + fontsize + ";";
          $.each(res.msg.data, function(index, value) {
            shenpicontent += "</div>";
            shenpicontent += "<div class='shenpilist' style='" + style + "'>";
            shenpicontent += "<div>" + value[res.msg.selecteds[0]] + "</div>";
            shenpicontent += "<div>" + value[res.msg.selecteds[3]] + "</div>";
            shenpicontent += "<div>" + value[res.msg.selecteds[1]] + "</div>";
            if (spdel == '1') {
              spdelbtn = " <span id='shenpilist_cb" + value.id +
                "' class='btn shenpilist_del' onclick='doDelShenPi(" +
                value.id + "," + window.spajaxData.nodeId + ")'>删除</span>"
            }
            if (value[res.msg.selecteds[6]] == "通过") {
              shenpicontent += "<div><font style='color: #ff0000;'>通过</font>" + spdelbtn + "</div>";
            } else if (value[res.msg.selecteds[6]] == "催办") {
              shenpicontent +=
                "<div><font style='color: #ff0000;'>已经催办</font> <span class='btn shenpilist_pass' onclick='setShenPi(" +
                value.id + ",\"" + value[res.msg.selecteds[1]] + "\",\"通过\"," + index +
                ")'>通过</span> <span class='btn shenpilist_cb' onclick='setShenPi(" + value.id + ",\"" + value[
                  res.msg.selecteds[
                    1]] + "\",\"催办\"," + index + ")'>催办</span>" + spdelbtn + "</div>";
            } else {
              shenpicontent += "<div><span class='btn shenpilist_pass' onclick='setShenPi(" + value.id +
                ",\"" + value[
                  res.msg.selecteds[1]] + "\",\"通过\"," + index +
                ")'>通过</span> <span class='btn shenpilist_cb' onclick='setShenPi(" + value.id + ",\"" + value[
                  res.msg.selecteds[
                    1]] + "\",\"催办\"," + index + ")'>催办</span>" + spdelbtn + "</div>";
            }
            shenpicontent += "</div>";

          })
        } else {
          shenpicontent = '<b>没有相关信息</b>';
        }
        $('.shenpicontent').html(shenpicontent);
      }
    })

  } else {
    spurl = prevent_HOST + 'pageDesignQueryFacade/selectFormRecordByNodeId';
    $.ajax({
      url: spurl,
      type: 'POST',
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      async: false,
      data: JSON.stringify(window.spajaxData),
      success: function(res) {
        var shenpicontent = '';
        if (res.status == '200') {
          var style = "height:" + pluheight + ";line-height:" + pluheight + ";font-size:" + fontsize + ";";
          $.each(res.msg.data, function(index, value) {
            shenpicontent += "</div>";
            shenpicontent += "<div class='shenpilist' style='" + style + "'>";
            shenpicontent += "<div>" + value[res.msg.selecteds[0]] + "</div>";
            shenpicontent += "<div>" + value[res.msg.selecteds[3]] + "</div>";
            shenpicontent += "<div>" + value[res.msg.selecteds[1]] + "</div>";
            if (spdel == '1') {
              spdelbtn = " <span id='shenpilist_cb" + value.id +
                "' class='btn shenpilist_del' onclick='doDelShenPi(" +
                value.id + "," + window.spajaxData.nodeId + ")'>删除</span>"
            }
            if (value[res.msg.selecteds[6]] == "通过") {
              shenpicontent += "<div><font style='color: #ff0000;'>通过</font>" + spdelbtn + "</div>";
            } else if (value[res.msg.selecteds[6]] == "催办") {
              shenpicontent +=
                "<div><font style='color: #ff0000;'>已经催办</font> <span class='btn shenpilist_pass' onclick='setShenPi(" +
                value.id + ",\"" + value[res.msg.selecteds[1]] + "\",\"通过\"," + index +
                ")'>通过</span> <span class='btn shenpilist_cb' onclick='setShenPi(" + value.id + ",\"" + value[
                  res.msg.selecteds[
                    1]] + "\",\"催办\"," + index + ")'>催办</span>" + spdelbtn + "</div>";
            } else {
              shenpicontent += "<div><span class='btn shenpilist_pass' onclick='setShenPi(" + value.id +
                ",\"" + value[
                  res.msg.selecteds[1]] + "\",\"通过\"," + index +
                ")'>通过</span> <span class='btn shenpilist_cb' onclick='setShenPi(" + value.id + ",\"" + value[
                  res.msg.selecteds[
                    1]] + "\",\"催办\"," + index + ")'>催办</span>" + spdelbtn + "</div>";
            }
            shenpicontent += "</div>";

          })
        } else {
          shenpicontent = '<b>没有相关信息</b>';
        }
        $('.shenpicontent').html(shenpicontent);
      }
    })
  }

}

function doDelShenPi(spid, nodeid) {
  if (!confirm("确定删除？")) return false;
  $.ajax({
    // url: DEFAULT_JOBURL + "urge/delete?id=" + spid,
    url: DEFAULT_URL + `pageDesignQueryFacade/deleteTableByNodeIdAndId?id=${spid}&nodeId=${nodeid}`,
    method: "GET",
    async: false,
    success: function(res) {
      if (res.status == '200') {
        $("#shenpilist_cb" + spid).parent().parent().remove();
      }
    }
  })
}

function getRid() {
  return Math.round(Math.random() * (999 - 100)) + 100;
}


// function duihuanonClick(selectId){
//   var selectId='';
//   $.ajax({
//       url: DEFAULT_JOBURL + 'integralService/integralExchange',
//       type: 'POST',
//       dataType: 'json',
//       contentType: 'application/json; charset=UTF-8',
//       // headers:{"token":userToKen},
//       async: true,
//       data: JSON.stringify(recordData),
//       success: function (res) {
//         // if(res.status=='200'){
//         //   var spdom=$(".shenpilist:nth-of-type("+(ind+1)+") div").eq(3);
//         //   if(st=="通过"){
//         //     spdom.find('font,.shenpilist_pass,.shenpilist_cb').remove();
//         //     spdom.prepend('<font style="color: #ff0000;">通过</font>');
//         //   }else if(st=='催办'){
//         //     spdom.find('font').remove();
//         //     spdom.prepend('<font style="color: #ff0000;">已经催办</font>');
//         //   }
//         // }
//       }
//   })
// }
//积分兑换
function test() {
  var url = window.location.href;
  //'editor/assets/ueditor/formdesign/preview.html?id=*&name=*&method=watch&selectId='+selectId

  var frmdata = {
    "itemId": selectId,
    "userid": gUser.id,
    "url": url.substring(url.indexOf('/editor'))
  };
  $.ajax({
    url: DEFAULT_JOBURL + 'integralService/integralExchange',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    // headers:{"token":userToKen},
    async: true,
    data: JSON.stringify(frmdata),
    success: function(res) {
      if (res.status == '200') {
        alert("兑换成功");
      } else {
        alert(res.statusMsg);
      }
    }
  });
}

//弹窗登录
function dologin() {
  var loginbox = document.getElementById('loginbox');
  var close = document.getElementById('close');
  var over = document.getElementById('over');
  loginbox.style = 'display:block';
  over.style = 'display:block';
  loginbox.style.zIndex = 7;
  close.onclick = function() {
    loginbox.style.display = 'none';
    over.style.display = 'none'
  };
}
//登录按钮点击事件
// btn.onclick=function(){
//   var username=$("#username").val();
//   var password=$("#password").val();
//   console.log(username);
//   console.log(password);
// }
//验证用户名
function check_name() {
  var input = document.getElementById("username");
  var p = document.getElementById("username_msg");
  var name = input.value;
  // console.log(name);
  var mobileYzm = /^1(3|4|5|7|8)\d{9}$/i;
  if (!mobileYzm.test(name)) {
    username_msg.style.display = "block";
    return false;
  } else {
    username_msg.style.display = "none";
    return true;
  }
}
//验证密码
function check_pwd() {
  var input = document.getElementById("password");
  var p = document.getElementById("password_msg");
  var pwd = input.value;
  // console.log(pwd);
  var pwdYzm = /^[a-zA-Z0-9]{9,24}/;
  if (!pwdYzm.test(pwd)) {
    password_msg.style.display = "block";
    return false;
  } else {
    password_msg.style.display = "none";
    return true;
  }
}

function login() {
  var username = $("#username").val();
  var password = $("#password").val();
  if (username == "") {
    alert("用户名不能为空");
    return false;
  } else if (password == "") {
    alert("密码不能为空");
    return false;
  }

  $.get(DEFAULT_JOBURL + 'htLoginService/getRASKey', function(r) {
    if (r.status == '200') {
      setMaxDigits(130);
      var ret = r.msg.rasKey;
      var kid = ret.rasId;
      var rkey = new RSAKeyPair(ret.exponent, '', ret.modulus);
      var pwd = encryptedString(rkey, $.md5(password));

      var data = {
        "username": username,
        "password": pwd,
        "rasKey": kid
      };
      $.ajax({
        type: "POST",
        url: DEFAULT_JOBURL + "htLoginService/login",
        contentType: "application/json; charset=UTF-8",
        data: JSON.stringify(data),
        // data:"username="+$("#username").val().toString()+"&password="+$("#password").val().toString(),
        success: function(data) {
          if (data.status == '200') {

            var user = data.msg;
            user = JSON.stringify(user);
            var u = navigator.userAgent;
            if (u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) {
              //window.loginMessage.getLoginMsg(user)
            }
            localStorage.setItem("user", user);
            user = JSON.parse(user);
            if (data.msg.indexPage == null) {
              var dl = document.getElementById('dl');

              dlStyle = 'height:20px;background:#fff;color:#333;';

              if (dl.getAttribute('fromwhere') == 'headerAndFooter') {
                // dlStyle = 'height:20px;background:#fff;color:#333;position: absolute;top: 20px;right: 100px;';
              }

              if (dl.getAttribute('toaccount') == 'toaccount') {
                loginbox.style.display = 'none';
                over.style.display = 'none';
                //window.location.href="http://47.106.39.210/editor/assets/ueditor/formdesign/preview.html?link=15662";
                dl.style = dlStyle;
                /* dl.innerHTML = '<span onclick="users()">' + user.userName + '</span>' +
                	'<span class="isadmin" onclick="fen()">' +
                	"&nbsp" + "|" + "&nbsp" + '</span>' + '<span id="hou" class="isadmin" onclick="houtai()">' +
                	'<a href="http://47.112.25.185/editor/assets/ueditor/formdesign/preview.html?link=15970"  target = "_blank" style="font-size:16px;text-decoration:none;">' +
                	"进入后台" + '</a>' + '</span>' + '<span onclick="fen()">' + "&nbsp" + "|" + "&nbsp" + '</span>' +
                	'<span id="exit" onclick="exit()" style="cursor:pointer;">' + "退出" + '</span>'; */

                dl.innerHTML = '<span onclick="users()">' + user.userName + '</span>' +
                  '<span onclick="fen()">&nbsp|&nbsp</span><span onclick="toaccount()">个人中心</span><span onclick="fen()">&nbsp|&nbsp</span><span id="exit" onclick="exit()" style="cursor:pointer;">' +
                  "退出" + '</span>';
              } else {
                loginbox.style.display = 'none';
                over.style.display = 'none';
                dl.style = dlStyle;
                dl.innerHTML = '<span onclick="users()">' + user.userName + '</span>' +
                  '<span onclick="fen()">&nbsp|&nbsp</span><span id="exit" onclick="exit()" style="cursor:pointer;">' +
                  "退出" + '</span>';

              }






              if (gUser.user.isadmin == "1") {
                $('.isadmin').show();
              }
            } else {
              window.location.href = "/editor/assets/ueditor/formdesign/preview.html?link=" + data.msg.indexPage;
            }
          } else {
            alert(data.statusMsg);
          }
          if (data.status == 1) {
            pwd = false;
          }
        }
      })
    }

  })

}

function users() {
  window.event.stopPropagation();
}

function houtai() {
  window.event.stopPropagation();
}

function fen() {
  window.event.stopPropagation();
}

function toaccount() {
  window.event.stopPropagation();
  var ur = window.location.host;
  window.location.href = "http://" + ur + "/account";
}

function exit() {
  window.event.stopPropagation();
  if (confirm('系统提示:您确定要退出本次登录吗?')) {
    window.localStorage.removeItem('user');
    window.location.reload();
    // location.href = "http://47.112.25.185/editor/assets/ueditor/formdesign/preview.html?link=15662";
  }
}



function liannan() {
  var lian = document.getElementById('lian');
  var close1 = document.getElementById('close1');
  console.log(lian);
  lian.style.display = 'block';
  $("#close1").click(function() {
    lian.style.display = 'none';
  })
}

function get64Image(img) {
  var canvas = document.createElement("canvas");
  canvas.width = img.width;
  canvas.height = img.height;
  var ctx = canvas.getContext("2d");
  ctx.drawImage(img, 0, 0, img.width, img.height);
  var ext = img.src.substring(img.src.lastIndexOf(".") + 1).toLowerCase();
  var dataURL = canvas.toDataURL("image/" + ext);
  return dataURL;
}

function getPLid() {
  var plutime = Date.parse(new Date());
  return 'plu' + plutime / 1000 + Math.floor(Math.random() * 1000 + 1);
}

function setLunBo(PLid, frmdata, lunbodata) {
  $.ajax({
    url: prevent_HOST + 'pageDesignOperatorFacade/selectFormRecord',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    data: JSON.stringify(frmdata),
    async: true,
    success: function(res) {
      if (res.status == '200') {
        var listonelist = res.msg.data;
        var lunbohtml = '';
        var wtime = parseInt(lunbodata.wtime) * 1000;
        if (lunbodata.client == "mobile") {
          lunbohtml = '';
          var lunboid = getRid();
          var lunbonum = "swiper" + lunboid;
          var lunbopag = "pagination" + lunboid;
          var imgstyle = ' style="width:' + lunbodata.orgwidth + ';height:' + lunbodata.orgheight + ';"';
          lunbohtml = '<div class="swiper-container ' + lunbonum + '"><div class="swiper-wrapper">';
          for (var lo = 0; lo < listonelist.length; lo++) {
            lunbohtml += '<div class="swiper-slide"><a href="' + listonelist[lo][lunbodata.dataurl] +
              '"><img name="' +
              listonelist[lo][lunbodata.datatitle] + '"' +
              ' type="slidebox" src="' + listonelist[lo][lunbodata.datapic] + '" ' + imgstyle + ' />' +
              "</a></div>";
          }
          lunbohtml += '</div><div class="swiper-pagination ' + lunbopag + '"></div>';
          if (lunbodata.arrowselect == "1") {
            lunbohtml += '<div class="swiper-button-prev"></div><div class="swiper-button-next"></div>';
          }
          lunbohtml += '</div>';
          lunbohtml += '<script>';
          lunbohtml += "var swiper" + lunboid + " = new Swiper('.swiper" + lunboid +
            "', {spaceBetween: 30,centeredSlides: true,autoplay: {delay: " + wtime +
            ",disableOnInteraction: false,},pagination: {el: '." + lunbopag +
            "',clickable: true},navigation: {nextEl: '.swiper-button-next',prevEl: '.swiper-button-prev'}});";
          lunbohtml += '</script>';
        } else {
          var botstr = getRid();
          var timestamp = Date.parse(new Date());
          timestamp = 'slbox' + (timestamp / 1000) + botstr;
          lunbohtml = "<span id='" + timestamp +
            "' class='slidebox' style='position:relative;display:block;margin:0 auto;width:" + lunbodata.orgwidth +
            ";height:" + lunbodata.orgheight + ";' datasource='" + lunbodata.datasource + "'orgwidth='" +
            lunbodata.orgwidth +
            "'orgheight='" + lunbodata.orgheight + "' title='" + lunbodata.title + "' name='" + lunbodata.name +
            "' " +
            ">";
          //小圆点
          lunbohtml +=
            "<span style='position:absolute; height: 16px;left: 50%;margin-left: -30px;bottom: 5%;cursor: pointer;z-index: 5;'>";
          for (var len = 0; len < lunbodata.limtvalue; len++) {
            lunbohtml += "<b class='go' index='" + len +
              "'style='position: relative;display: inline-block;margin:0 5px;width: 10px;height: 10px;border-radius: 50%;border: 1px solid black;background-color: #fff;cursor: pointer;'>";
            lunbohtml += "</b>";
          }
          lunbohtml += "</span>";
          if (lunbodata.arrowselect == "1") {
            //左箭头
            lunbohtml += "<a id='" + timestamp +
              "prev'  style='position:absolute;left:20px;top:50%;margin-top:-20px;display:block;font-size:36px;width:40px;height:40px;border-radius: 50%;background-color: RGBA(0,0,0, .1);text-align: center;color: #fff;line-height: 40px;font-weight: bold;cursor: pointer;z-index: 5;' " +
              " >";
            lunbohtml += " &lt ";
            lunbohtml += "</a>";
            //右箭头
            lunbohtml += "<a id='" + timestamp +
              "next'   style='position: absolute;right:20px;top:50%;margin-top:-20px;display:block;font-size: 36px;width:40px;height: 40px;border-radius: 50%;background-color: RGBA(0,0,0, .1);text-align: center;color: #fff;line-height: 40px;font-weight: bold;cursor: pointer;z-index: 5;'" +
              ">";
            lunbohtml += " &gt  ";
            lunbohtml += "</a>";
          }
          for (var lo = 0; lo < listonelist.length; lo++) {
            lunbohtml += '<a href="' + listonelist[lo][lunbodata.dataurl] + '"><img name="' + listonelist[lo][
                lunbodata.datatitle
              ] +
              '"style="position:absolute;left:0;width:100%;height:100%;"' +
              ' type="slidebox" src="' + listonelist[lo][lunbodata.datapic] + '"/>' + "</a>";
          }
          lunbohtml += '</span> ';
          lunbohtml += '<script type="text/javascript">$("#' + timestamp + ' span b").removeClass("go");' +
            '$("#' + timestamp + ' img").css("display", "none");' +
            '$("#' + timestamp + ' img").eq(0).css("display", "inline-block");' +
            '$("#' + timestamp + ' span b").eq(0).addClass("go");';

          lunbohtml += 'var ' + timestamp + 'index = 0;' +
            'var ' + timestamp + 'timer=null;' +
            'var ' + timestamp + 'animatime = ' + wtime + ';' +
            'var ' + timestamp + 'preindex;' +
            'function ' + timestamp + 'anima() {' +
            '$("#' + timestamp + ' img").fadeOut(100);' +
            '$("#' + timestamp + ' img").eq(' + timestamp + 'index).fadeIn(100);' +
            '$("#' + timestamp + ' span b").removeClass("go");' +
            '$("#' + timestamp + ' span b").eq(' + timestamp + 'index).addClass("go");' +
            '};';

          lunbohtml += 'function ' + timestamp + 'aclick(number) {' +
            timestamp + 'index += number;console.log("' + timestamp + 'index:"+' + timestamp + 'index);' +
            'if (' + timestamp + 'index < 0) {' +
            timestamp + 'index = $("#' + timestamp + ' img").length - 1;' +
            '} else if (' + timestamp + 'index > $("#' + timestamp + ' img").length - 1) {' +
            timestamp + 'index = 0;' +
            '}' +
            timestamp + 'anima();' +
            '};';
          lunbohtml += '$(document).ready(function () {' +
            'clearInterval(' + timestamp + 'timer);' +
            timestamp + 'timer = setInterval(function () {' +
            timestamp + 'aclick(1);' +
            '},' + wtime + ');' +
            '});';
          lunbohtml += '$("#' + timestamp + ' #' + timestamp + 'prev").click(function () {' +
            timestamp + 'aclick(-1);' +
            '});' +
            '$("#' + timestamp + ' #' + timestamp + 'next").bind("click", function () {' +
            timestamp + 'aclick(1);' +
            '});';
          lunbohtml += '$("#' + timestamp + '").bind("mouseenter", function () { clearInterval(' + timestamp +
            'timer); });' +
            '$("#' + timestamp + '").bind("mouseleave", function () {' +
            timestamp + 'timer = setInterval(function () {' +
            timestamp + 'aclick(1);' +
            '}, ' + timestamp + 'animatime);' +
            '});' +
            '$("#' + timestamp + ' span b").bind({' +
            'mouseenter: function () {' +
            'clearInterval(' + timestamp + 'timer);' +
            'var spanindex = Number($(this).index());' +
            timestamp + 'index = spanindex;' +
            '$("#' + timestamp + ' span b").removeClass("go");' +
            '$(this).addClass("go");' +
            'if (' + timestamp + 'preindex == ' + timestamp + 'index) { }' +
            'else {' +
            '$("#' + timestamp + ' img").fadeOut(1000);' +
            '$("#' + timestamp + ' img").eq(' + timestamp + 'index).fadeIn(1000);' +
            timestamp + 'preindex = ' + timestamp + 'index;' +
            '}' +
            '},' +
            'mouseleave: function () {' +
            '}' +
            '});</script>';
        }
        $("#" + PLid).html(lunbohtml);
      } else {}
    }
  })
}

function getMeeAddr(str) {
  var addrUrl = '';
  switch (str) {
    case '视频会议':
      addrUrl = '/editor/assets/ueditor/formdesign/preview.html?link=16322';
      break;
    case '视频直播':
      addrUrl = '/editor/assets/ueditor/formdesign/preview.html?link=16316';
      break;
    case '文字会议':
      addrUrl = '/editor/assets/ueditor/formdesign/preview.html?link=16352';
      break;
  }
  return addrUrl;
}
//会议列表
function getMeetingList(formNid, formName, formTpl, page, pagesize, showpage, datafields, headshow, mtype, cla, url,
  listpicw, listpich, searchfile, searchcon, fsize, llineheight, mtitle) {
  var formLists = '';
  var datafile = datafields.substr(1).split(",");
  var ajaxData = {
    "nodeId": formNid,
    "classname": formName,
    "page": page,
    "pageSize": pagesize,
    "table_field_all": searchfile,
    "searchContent": searchcon,
    "orderby": "desc"
  };
  $.ajax({
    url: prevent_HOST + 'pageDesignQueryFacade/selectFormRecordByNodeId',
    type: 'POST',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    headers: {
      "token": userToKen
    },
    async: true,
    data: JSON.stringify(ajaxData),
    success: function(res) {
      if (res.status == '200') {
        if (datafile.length > 0) {
          var tdata = res.msg.data;
          var listhtml = '';
          var listlink = '';
          var editlink = '';
          var dellink = '';
          var dfs = null;
          var frmexahtml = '';
          var meeingtitle = '';
          var mystyle = "padding:0px;height:" + llineheight + ";line-height:" + llineheight + ";";
          if (fsize != 'null' && fsize != '') mystyle += "font-size: " + fsize + ";";
          switch (formTpl) {
            case "li":
              formLists = '<div class="list-group">';
              for (var i = 0; i < tdata.length; i++) {
                listhtml = '';
                meeingtitle = tdata[i][mtitle];
                for (var j = 0; j < datafile.length; j++) {
                  listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                }

                editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                  '&method=change&selectId=' + tdata[i].id;
                listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                  '&method=watch&selectId=' + tdata[i].id;
                if (url != '' && url != 'null' && url != undefined) {
                  listlink = getMeeAddr(tdata[i][url]);
                }
                formLists += '<a href="javascript:void();" onclick="goMeeting(\'' + listlink + '\',\'' + mtype +
                  '\',\'' +
                  formNid + '\',\'' + formName + '\',\'' + tdata[i].id + '\',\'' + meeingtitle +
                  '\')" class="list-group-item" target="_blank" style=\'' + mystyle + '\'>' + listhtml + '</a>';
              }
              if (tdata.length == 0) formLists += "没有数据哦~";
              formLists += '</div>';
              break;
            case "table_td":
              formLists = '<table class="formlist_table_td">';
              if (headshow == "1") {
                formLists += '<tr>';
                for (var j = 0; j < datafile.length; j++) {
                  dfs = datafile[j].split(":");
                  formLists += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                }
                formLists += '</tr>';
              }
              for (var i = 0; i < tdata.length; i++) {
                meeingtitle = tdata[i][mtitle];
                listhtml = '<tr>';
                listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                  '&method=watch&selectId=' + tdata[i].id;
                if (url != '' && url != 'null' && url != undefined) {
                  listlink = getMeeAddr(tdata[i][url]);
                }
                for (var j = 0; j < datafile.length; j++) {
                  dfs = datafile[j].split(":");
                  listhtml += '<td><a href="javascript:void();" onclick="goMeeting(\'' + listlink + '\',\'' +
                    mtype + '\',\'' +
                    formNid + '\',\'' + formName + '\',\'' + tdata[i].id + '\',\'' + meeingtitle +
                    '\')" target="_blank" style="' + mystyle + '">' + doFormListImgWH(tdata[i][dfs[0]], listpicw,
                      listpich) +
                    '</a></td>';
                }
                listhtml += '</tr>';
                formLists += listhtml;
              }
              if (tdata.length == 0) formLists += "<tr><td colspan='" + datafile.length + "'>没有数据哦~<td></tr>";
              formLists += '</table>';
              break;
            case "table_vd":
              formLists = '<table class="formlist_table_vd">';
              for (var i = 0; i < tdata.length; i++) {
                listhtml = '<tr>';
                listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                  '&method=watch&selectId=' + tdata[i].id;
                if (url != '' && url != 'null' && url != undefined) {
                  listlink = getMeeAddr(tdata[i][url]);
                }
                for (var j = 0; j < datafile.length; j++) {
                  dfs = datafile[j].split(":");
                  if (headshow == "1") {
                    listhtml += "<th style='" + mystyle + "'>" + dfs[1] + "</th>";
                  }
                  listhtml += '<td><a href="javascript:void();" onclick="goMeeting(\'' + listlink + '\',\'' +
                    mtype + '\',\'' +
                    formNid + '\',\'' + formName + '\',\'' + tdata[i].id + '\',\'' + meeingtitle +
                    '\')" target="_blank" style="' + mystyle + '">' + doFormListImgWH(tdata[i][dfs[0]], listpicw,
                      listpich) +
                    '</a></td>';
                }
                listhtml += '</tr>';
                formLists += listhtml;
              }
              if (tdata.length == 0) formLists += "<tr><td>没有数据哦~<td></tr>";
              formLists += '</table>';
              break;
            case "span":
              formLists = '';
              for (var i = 0; i < tdata.length; i++) {
                listhtml = '<span class="formlist_span">';
                listlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                  '&method=watch&selectId=' + tdata[i].id;
                if (url != '' && url != 'null' && url != undefined) {
                  listlink = getMeeAddr(tdata[i][url]);
                }
                listhtml += '<a href="javascript:void();" onclick="goMeeting(\'' + listlink + '\',\'' + mtype +
                  '\',\'' +
                  formNid + '\',\'' + formName + '\',\'' + tdata[i].id + '\',\'' + meeingtitle +
                  '\')" target="_blank">';
                for (var j = 0; j < datafile.length; j++) {
                  listhtml += doFormListImgWH(tdata[i][datafile[j].split(":")[0]], listpicw, listpich) + " ";
                }
                listhtml += '</a>';
                editlink = '/editor/assets/ueditor/formdesign/preview.html?id=' + formNid + '&name=' + formName +
                  '&method=change&selectId=' + tdata[i].id;
                listhtml += "</span>";
                formLists += listhtml;
              }
              if (tdata.length == 0) formLists += "没有数据哦~";
              break;
          }


          if (showpage == 'on') {
            var total = res.msg.count;
            var pnumer = Math.ceil(total / parseInt(pagesize));
            var pagecon = '<ul class="listpage">';
            for (var i = 1; i <= pnumer; i++) {
              if (page == i) {
                pagecon += '<li class="cur_page">' + i + '</li>';
              } else {
                pagecon += '<li onclick="getMeetingList(' + formNid + ',\'' + formName + '\',\'' + formTpl +
                  '\',' + i + ',' +
                  pagesize + ',\'' + showpage + '\',\'' + datafields + '\',\'' + headshow + '\',\'' + mtype +
                  '\',\'' + cla +
                  '\',\'' + url + '\',\'' + listpicw + '\',\'' + listpich + '\',' + searchfile + ',' + searchcon +
                  ',\'' +
                  fsize + '\',\'' + llineheight + '\',\'' + mtitle + '\')">' + i + '</li>';
              }
            }
            pagecon += '<li class="page_msg">总共' + total + '条记录</li>';
            pagecon += '</ul>';
            formLists += pagecon;
          }
        }
      } else {
        formLists += "没有数据哦~";
      }
      //showData=formLists;
      var Pcla = $('.' + cla);
      if (Pcla.length > 0) {
        Pcla.html(formLists);
      } else {}

    }
  })
}

function goMeeting(url, mtype, formNid, formName, id, meeingtitle) {
  var nodedata = {
    "nodeId": formNid,
    "nodeName": formName,
    "selectId": id,
    "title": meeingtitle
  };
  window.localStorage.setItem("chatRoom", JSON.stringify(nodedata));
  window.location.href = '/model_lib/#/im';
}


function toBeiKe() {
  // var tempUserInfo = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
  var tempUserInfo = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
  if (!tempUserInfo) {
    alert("请先登录");
    return;
  }

  // var enUserId = compile(tempUserInfo.id);
  $.cookie("ud", tempUserInfo.id, {
    expires: 7,
    path: '/'
  });


  if (tempUserInfo) {
    // window.location.href = 'http://47.112.25.185:8081/WebOfficeEdit/?userId=' + tempUserInfo.id;
    // window.location.href = 'http://47.112.25.185:8081/WebOfficeEdit/?userId=' + tempUserInfo.id;
    // window.location.href = 'http://47.112.25.185:8081/WebOfficeEdit/';
    // window.open('http://47.112.25.185:8081/WebOfficeEdit/?userId=' + tempUserInfo.id);
    // window.open('http://47.112.25.185:8081/WebOfficeEdit/?userId=' + enUserId);
    window.location.href = 'http://sybs101.com/WangwenEdit/WangwenEdit.html';
    // window.open('/editor/assets/ueditor/formdesign/preview.html?link=16245');
    // window.open('/editor/assets/ueditor/formdesign/forBeiKe.html?userId=' + tempUserInfo.id);

  }
}


//网上随便找的加密代码
function compile(code) {
  var c = String.fromCharCode(code.charCodeAt(0) + code.length);
  for (var i = 1; i < code.length; i++) {
    c += String.fromCharCode(code.charCodeAt(i) + code.charCodeAt(i - 1));
  }
  c = escape(c)
  return c;
}
//网上随便找的解密代码
function uncompile(code) {
  code = unescape(code);
  var c = String.fromCharCode(code.charCodeAt(0) - code.length);
  for (var i = 1; i < code.length; i++) {
    c += String.fromCharCode(code.charCodeAt(i) - c.charCodeAt(i - 1));
  }
  return c;
}


function multiSourcePhoneCli(nid, name, cla, page, pagesize, showpage, pic, ctitle, con, tpl, tsize, csize, listurl,
  listpicw,
  listpich, titlelabel, conlabel, frmedit, frmdel, fontsize, searchfile, searchcon, picfontsize, listheight, isnotuser,
  prefix, isheader, headertitle, moreurl, headercolor, titlecolor, iscomment, headstyle, headimgsrc, pagingstyle,
  isscore, thisScoreIds, multisource, statistical, threeToFiveScoreIds) {

  var op = $('.selectdatasource').parent();
  op.find('br').remove();
  $('.selectdatasource').hide();

  // $('#backPageId').after('<span style="font-size: 20px;display: inline-block;margin-left: 50px;">' + name.split('nid')[0] + '</span>')
$('#backPageId').parent().parent().next().find('span').html(name.split('nid')[0])


  getListOne(nid, name, cla, page, pagesize, showpage, pic, ctitle, con, tpl, tsize, csize, listurl, listpicw,
    listpich, titlelabel, conlabel, frmedit, frmdel, fontsize, searchfile, searchcon, picfontsize, listheight,
    isnotuser,
    prefix, isheader, headertitle, moreurl, headercolor, titlecolor, iscomment, headstyle, headimgsrc, pagingstyle,
    isscore, thisScoreIds, multisource, statistical, threeToFiveScoreIds);
}




function getAllWebUrl() {
  var webUrls = null;
  $.ajax({
    url: prevent_HOST + 'webUrlManageFacade/getAllWebUrl?page=1&limit=1000',
    async: false,
    /*type: 'GET',
	 	contentType: 'application/json; charset=UTF-8',
		data: JSON.stringify(data), */
    success: function(res) {
      if (res.status == "200") {
        webUrls = res.msg;
      }
    }
  })
  return webUrls;
}
//点击数据源  显示饼状图评分情况
function scoreSourceCli(e) {
  var nodeId = $(e).attr('thisnodeid');
  var df = {
    'nodeId': nodeId
  }
  $('.selectdatasource').css('background', '#ffa498');
  $(this).css('background', '#ff4a32');
  window.sessionStorage.setItem('tempNid', JSON.stringify(df));
  location.reload()
}
