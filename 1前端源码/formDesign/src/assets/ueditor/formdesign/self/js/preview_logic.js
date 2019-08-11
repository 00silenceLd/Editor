/**
 * 获取URL参数
 * @param str
 * @returns {*}
 * @constructor
 */
function GetUrl(str) {
  var this_str = location.href;
  var this_num = this_str.indexOf("?");
  if (this_num < 0) return false;
  var this_option = this_str.substr(this_num + 1);
  if (this_option.indexOf("#") > -1) {
    this_option = this_option.substr(0, this_option.indexOf("#"));
  }
  var this_optionarr = this_option.split("&");
  var returnstr = null;
  for (this_cout = 0; this_cout < this_optionarr.length; this_cout++) {
    var this_canshu = this_optionarr[this_cout].split("=");
    if (this_canshu < 2) continue;
    if (this_canshu[0] == str) returnstr = this_canshu[1];
  }
  if (returnstr == null) return false;
  else return returnstr;
}
/*
 * 预览页面 - 逻辑处理
 *
 */
//  模拟本地用户
var storage = window.localStorage;
var gUser = null;
try {
  gUser = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
} catch (e) {}
// var user = { "id": 442, "username": "15729112830", "companyExit": false, "jsessionid": "363F968896C0B4C7EA1FBF8834C925EF" }
// localStorage.setItem( "user", JSON.stringify( user ) )
// console.log(JSON.parse(localStorage.getItem('user')))
if (browser.versions.mobile === true || browser.versions.android === true) {
  $('.container').addClass('phone').removeClass('pc');
  $('body').addClass('phone').removeClass('pc');
  $('.btn').addClass('btn-small');
} else $('.container').addClass('pc').removeClass('phone');
if (JSON.parse(localStorage.getItem('user')) == null) {
  if ($('#buttonBtn').attr('orgtitle') == '注册') {

  }
}



function rep(str) {
  str = str.replace(/"http:\/\/*\/editor\/assets\/"/g, "\/editor\/assets\/");
  return str;
}
var tempc = null;
var tempIscolor = null;
$(function() {
  var w = window.innerWidth;
  console.log(w);

  // $('.container').css('padding-left','0');

  //以下定时函数用于生涯博士（8081）
  /* <p>
      <iframe id="beikeIframeId" scrolling="no" frameborder="0"></iframe>
  </p> */
  setTimeout(function() {
    var tempUserInfo = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
    var f = $('#beikeIframeId');
    if (tempUserInfo) {
      if (f) {
        f.attr('src', 'http://47.112.25.185:8081/WebOfficeEdit?userId=' + tempUserInfo.id);
        // var height = $(window).height();
        var height = f.contents().find("body").height() + 40;
        var width = $(window).width();
        f.attr('height', height);
        f.attr('width', width);

        $(window).resize(function() {
          // height = $(window).height();
          height = f.contents().find("body").height() + 40;
          width = $(window).width();
          // f.attr('height', height);
          f.attr('height', height < 600 ? 600 : height);
          f.attr('width', width);
        });
      }

    } else {
      /* alert("您未登陆~~")
       window.location.href = window.location.href; */
    }
    console.log(tempUserInfo);
  }, 500)


  /* try {
  	gUser = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
  } catch (e) {} */

  var nodeId, parseData, // 解析的对象
    parseStauts, // 返回的信息
    DataJson = [], //数据格式
    fields = [], // 所有的字段
    content = $(".bodyContent"), // 装载内容的容器
    checkboxs = 0, // div的id，循环生成唯一值
    source, // 来源地
    isAddImageSrc, //判断图片控件
    wifiBlock = false,
    numTimes = false, // 判断图形执行
    reportId = [], // 图表的Id
    reportData = []; // 图表的数据
  isSrc = false; // 如果有 图片控件 就增加 Src 字段。
  // console.log( source )
  try {
    // alert("这里是72行");
    window.location.search !== "" ?
      nodeId = window.location.search.split('?')[1].split('=')[1] :
      nodeId = window.location.hash.split('#')[1].split('=')[1];
    $.ajax({ // 这是 修改 功能要使用的 把id的数据获取。
      url: prevent_HOST + 'nodeQueryFacade/getByNodeName?nodeId=' + nodeId,
      type: 'GET',
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      headers: {
        "token": userToKen
      },
      async: false,
      success: function(res) {
        if (res.status == '0') {
          currNode = res.msg;
          window.document.title = res.msg.value;
        }
      }
    });
  } catch (e) {}

  try {
    if (window.location.search !== "" || window.location.hash !== "") { // 在数据表页面跳转过来的
      // alert("这里是96行")
      var urlInfo,
        urlDot;
      if (window.location.search !== "") {
        urlInfo = 'search';
        urlDot = '?';
      } else {
        urlInfo = 'hash';
        urlDot = '#';
      }
      if (window.location[urlInfo].split(urlDot)[1].split('=')[0] !== 'link') { // 跳转时url传参数link，就是仅仅查看表单作用
        var params = decodeURI(window.location.search), // 在数据表按 增加 然后ajax请求数据进来的
          nodeId = params.split('&')[0].split('=')[1],
          nodeName = params.split('&')[1].split('=')[1],
          method = params.split('&')[2].split('=')[1],
          idData; // 根据SelectId单条查询出来的数据
        isSrcs = ""; // 给后台判断哪个是要将 图片控件 转为Src路径
        urlMethod = method;

        //曾智宏
        //评分插件1.0版本，根据需求，取消
        var isscore;
        for (var i = 0; i < params.split('&').length; i++) {
          if (params.split('&')[i].split('=')[0] == 'isscore') {
            isscore = params.split('&')[i].split('=')[1];
          }
        }
        /* if (isscore == "score") {
        	var script = $(
        		'<script src="./self/js/score.js" type="text/javascript" charset="utf-8" defer="defer"></script>'
        	);
        	$('body').append(script);
        } */
        //评分插件1.0版本，根据需求，取消

        var iscomment;
        for (var i = 0; i < params.split('&').length; i++) {
          if (params.split('&')[i].split('=')[0] == 'iscomment') {
            iscomment = params.split('&')[i].split('=')[1];
            // alert(iscomment);
          }
        }
        if (iscomment == 'show') {
          var oinsertForm = document.getElementById("insertForm");
          oinsertForm.style.height = "auto";
          var ocommentControl = document.getElementById("commentControl");
          ocommentControl.style.display = "";

          //将nodeId与selectId保存在页面
          $("#nodeId").val(nodeId);
          $("#selectId").val(params.split('&')[3].split('=')[1]);
          var u;
          if (gUser == null) {
            u = 0;
          } else {
            u = gUser.id;
          }
          // u = gUser.id;
          $("#Cuid").val(u);
          // alert($("#Cuid").val());
          // alert("进入ajax");
          let selectId = params.split('&')[3].split('=')[1];
          // 					nodeId = 1077;
          // 					selectId = 22;
          var data1 = {
            'nodeId': nodeId,
            'selectId': selectId
          }
          $.ajax({ // 这是 修改 功能要使用的 把id的数据获取。?nodeId='+nodeId+'&selectId='+selectId
            url: prevent_HOST + 'commentFacade/getComment?nodeId=' + nodeId + '&selectId=' + selectId,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            /* data: data1, */
            success: function(res) {
              // alert(res.status);
              var msg = res.msg;

              if (res.status == "200" && msg.length != null && msg.length != 0) {
                var html;
                // alert(msg.length)
                for (var i = 0; i < msg.length; i++) {
                  html = '<div class="col-md-12 col-sm-12 col-xl-12 one cont">' +
                    '<div class="col-md-10 col-sm-10 col-xl-12 one commentContent">' +
                    '<div class="comment-right">' +
                    '<div style="display: inline-block;">' + msg[i].pubUser + '</div>' +
                    '<div class="comment-content-header three" style="float: right;">' +
                    '<span><i class="glyphicon glyphicon-time two"></i>' + msg[i].pubTime +
                    '</span>&nbsp;&nbsp;&nbsp;&nbsp;' +
                    '</div>' +
                    '<p class="tent" style="margin:10px">' + msg[i].pubContent + '</p>' +
                    '</div>' +
                    '</div>';

                  $("#commentArea").append(html);

                }
              }

            }
          })




          $('head').append(
            '<script type="text/javascript" defer="defer" src="./self/commentControl/js/commentController.js"></script>'
          )

          $('head').append(
            '<link rel="stylesheet" type="text/css" href="./self/commentControl/css/commentController.css">')

        }


        if ($(window).width() < 700) {
          $("#commentControl").removeClass('comtcla');
          $("#commentControl").removeClass('comtcla');

          $("#comOutBor").css('margin-left', 'auto');

          $("#text_send").css('width', '85%');
          $("#text_send").css('height', '40px');

          $("#tijiaoId").css('height', '40px');
          $("#tijiaoId").css('width', '15%');
          $("#tijiaoId").css('padding-top', '9px');
          $("#commentArea").css('margin-left', '0px');

        } else {
          $("#commentControl").addClass('comtcla');
          $("#commentControl").addClass('comtcla');

          $("#comOutBor").css('margin-left', ' ');

          $("#text_send").css('width', '100%');
          $("#text_send").css('height', '80px');

          $("#tijiaoId").css('height', ' ');
          $("#tijiaoId").css('width', '120px');
          $("#tijiaoId").css('padding-top', ' ');

          $("#commentArea").css('margin-left', '170px');
        }


        $(window).resize(function() { //当浏览器大小变化时
          console.log($(window).width()); //浏览器时下窗口可视区域高度

          if ($(window).width() < 700) {
            $("#commentControl").removeClass('comtcla');
            $("#commentControl").removeClass('comtcla');

            $("#comOutBor").css('margin-left', 'auto');

            $("#text_send").css('width', '85%');
            $("#text_send").css('height', '40px');

            $("#tijiaoId").css('height', '40px');
            $("#tijiaoId").css('width', '15%');
            $("#tijiaoId").css('padding-top', '9px');
            $("#commentArea").css('margin-left', '0px');

          } else {
            $("#commentControl").addClass('comtcla');
            $("#commentControl").addClass('comtcla');

            $("#comOutBor").css('margin-left', ' ');

            $("#text_send").css('width', '100%');
            $("#text_send").css('height', '80px');

            $("#tijiaoId").css('height', ' ');
            $("#tijiaoId").css('width', '120px');
            $("#tijiaoId").css('padding-top', ' ');


          }
        });















        // alert(params);
        if (params.split('&')[3] !== undefined) var gid = params.split('&')[3].split('=')[1];
        // alert(gid);22
        $('#submitBtn').show(); // 预览界面把提交按钮显示出来。
        method !== 'add' ? selectId = params.split('&')[3].split('=')[1] : null;
        // alert(selectId);22
        source = 'datatable';
        if (method == "add") {
          try {
            $("#submitBtn").text(params.split('&')[4].split('=')[1]);
          } catch (e) {}
        }
        var useMethod; // 使用的方法
        method === 'add' || method === 'addAgain' ? useMethod = 'insert' : useMethod = 'update';

        // $( '.container.head' ).hide(); // 数据表跳转过来的话 最上面的文字就不要了 （预览表单）
        if (method !== 'add') {
          var data = {
            "record": selectId,
            "node_id": nodeId,
            "classname": nodeName,
            "method": "getById"
          };

          $.ajax({ // 这是 修改 功能要使用的 把id的数据获取。
            url: prevent_HOST + 'pageDesignOperatorFacade/selectFormRecord',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            headers: {
              "token": userToKen
            },
            async: false,
            data: JSON.stringify(data),
            success: function(res) {
              idData = res;
            }
          })
          console.log("data===" + data)
          $(function() {
            if (method === 'watch') {
              // 如果是在 数据表 里面点击 查看 进来的话，就把所有东西都禁用，只能查看，不能修改。
              $('[id^="data"]').attr('readonly', 'readonly');
              $('[id^="data"]').attr('disabled', 'disabled');
              $('input').attr('readonly', 'readonly');
              $('button').attr('disabled', 'disabled');
              $('#submitBtn').hide();
              $('.frm-submit').hide();
              $('.frm-rest').hide();
              $('input[name="sousuokuang"]').removeAttr('readonly');
            }
          })
        }

        $.ajax({ // 这是获取模板。
          url: prevent_HOST + 'pageDesignQueryFacade/getPageContent?id=' + nodeId,
          type: 'GET',
          dataType: 'json',
          contentType: 'application/json; charset=UTF-8',
          headers: {
            "token": userToKen
          },
          async: false,
          success: function(res) {
            parseData = res['msg'];
            parseStauts = res.status;
            if (parseData == "java.lang.NullPointerException") {
              window.location.href = prevent_Url + '404/index.html';
            }
          }
        })

        $("#insertForm").submit(function(e) {
          e.preventDefault();
          var record = $("#insertForm").serializeObject();
          record = doStrMarks(record);
          if (gid) record.gid = gid; // 如果有关联的话 就添加 gid 字段

          record.id = selectId; // 数据表点击 修改 的时候要用的。
          delete record.leipiNewField; // 我也不知道为什么提交取值的时候会添加这个     东西，貌我也不知道为什么提交取值的时候会添加这个东西，貌似就是没用的，所以就把它删除了。
          isSrcs = isSrcs.substring(0, isSrcs.length - 1);
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
            "classname": nodeName,
            "method": useMethod,
            "user_account": gUser.username
          }
          // console.log(data)
          if (isSrc) data.src = isSrcs; // 如果有 图片控件 就添加 Src 字段
          var tgurlinfo = '';
          var tgnodereg = new RegExp("(^|&)tgurl=([^&]*)(&|$)", "i");
          var rrr = window.location.search.substr(1).match(tgnodereg);
          if (rrr != null) tgurlinfo = unescape(rrr[2]);

          if (method === 'add') { // 点击 添加数据 的请求
            data.record.isDelete = 0; // 添加要增加一个 isDelete字段。
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
                console.log(200)
                if (res['status'] == 0) {
                  alert('恭喜您！' + res['statusMsg']);
                  if ($('.wifiblock').length !== 0) { // 代表有关联控件。要进行跳转到第二个页面添加数据。

                    var orgUrl = $('.wifiblock').attr('orgurl').split('?')[1].split('=')[1].split('&')[0],
                      orgUrlName = $('.wifiblock').attr('orgurlname');
                    if (window.location.href.split('&').length > 3) {
                      var gid = window.location.href.split('&')[3].split('=')[1];
                      window.location.href = prevent_Url +
                        'editor/assets/ueditor/formdesign/preview.html?id=' + orgUrl + '&name=' +
                        orgUrlName + '&method=add&gid=' + gid;
                    } else {
                      window.location.href = prevent_Url +
                        'editor/assets/ueditor/formdesign/preview.html?id=' + orgUrl + '&name=' +
                        orgUrlName + '&method=add&gid=' + res['msg'];
                    }
                  } else if (tgurlinfo != '') {
                    window.location.href = tgurlinfo;
                  } else window.location.reload();
                } else {
                  alert('抱歉！插入单条数据失败，请重试');
                }
              }
            })
          } else { // 点击 修改数据 的请求
            data.record.isDelete = 0; // 添加要增加一个 isDelete字段。
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
                //console.log( res );
                if (res['status'] == 0) {
                  alert('恭喜您！' + res['statusMsg']);
                  window.location.reload();
                } else {
                  alert('抱歉！更新数据失败，请重试');
                }
              }
            })
          }

        })
      } else {
        var nodeId,
          gid,
          url;
        source = 'link';
        var thisScoreIds = [];
        //查询已评级的记录Id(3~5星记录)
        var threeToFiveScoreIds = [];
        /* 	window.location.search !== "" ?
        		nodeId = window.location.search.split('?')[1].split('=')[1] :
        		nodeId = window.location.hash.split('#')[1].split('=')[1]; */
        window.location.search !== "" ?
          nodeId = window.location.search.split('?')[1].split('&')[0].split('=')[1] :
          nodeId = window.location.hash.split('#')[1].split('=')[1];

        if (window.location.search.split('?')[1].split('&').length >= 2) {
          if (window.location.search.split('?')[1].split('&')[1].split('=')[0] == 'nId') {
            var nId = window.location.search.split('?')[1].split('&')[1].split('=')[1];
            var scoreResult = window.location.search.split('?')[1].split('&')[2].split('=')[1];
            scoreResult = parseInt(scoreResult);
            if (scoreResult == 0) { //非星级查询（即显示0,1,2星记录）
              for (var df = 3; df <= 5; df++) { //查出3,4,5星的记录，用于反向求出非星级
                $.ajax({
                  url: prevent_HOST + 'scoreFacade/getSelectIdByNodeIdAndscoreResult?nodeId=' + nId +
                    '&scoreResult=' + df,
                  async: false,
                  success: function(res) {
                    if (res.status == '200' && res.msg.length != 0) {
                      // thisScoreIds = res.msg;
                      for (var dff = 0; dff < res.msg.length; dff++) {
                        var tempId = res.msg[dff];
                        threeToFiveScoreIds.push(tempId)
                      }
                    }
                  }
                })
              }
            } else { //为正常查询1~5星
              $.ajax({
                url: prevent_HOST + 'scoreFacade/getSelectIdByNodeIdAndscoreResult?nodeId=' + nId +
                  '&scoreResult=' + scoreResult,
                async: false,
                success: function(res) {
                  if (res.status == '200') {
                    thisScoreIds = res.msg;
                    console.log(thisScoreIds);
                  }
                }
              })
            }




          }
          console.log('thisScoreIds=' + thisScoreIds);
          console.log('threeToFiveScoreIds=' + threeToFiveScoreIds)
        }


        // alert(123)

        var gid = getQueryString('gid');
        if (gid !== null)
          //url = prevent_HOST + 'pageDesignQueryFacade/getPageContentGid?id=${nodeId}&gid=${gid}';
          url = prevent_HOST + 'pageDesignQueryFacade/getPageContentGid?id=' + nodeId + '=' + gid;
        else
          url = prevent_HOST + 'pageDesignQueryFacade/getPageContent?id=' + nodeId;


        $.ajax({ // 这是获取模板。
          url: url,
          type: 'GET',
          dataType: 'json',
          contentType: 'application/json; charset=UTF-8',
          async: false,
          success: function(res) {

            parseData = res['msg'];
            parseStauts = res.status;

          }
        })

        getNodeConent(nodeId);
      }
    } else {
      if (window.opener) { // 在百度编辑器按 预览 进来的
        source = 'ueditor';
        nodeId = $('#node_id', window.opener.document).val();
        parseData = JSON.parse(window.opener.parseData()); // 从父窗口获取解析的数据 - parseData() 该方法在 ueditor.all.js 里面
        getNodeConent(nodeId);
        if (window.opener.isPhone() === true) {
          $('body').addClass('mnPhone');
          $('.container').addClass('phone').removeClass('pc');
          $('.btn').addClass('btn-small');
        };
        //明细表 ww
        for (var i = 0; i < parseData.data.length; i++) {
          if (!selectId) {
            selectId = 0;
          }
          if (parseData.data[i].leipiplugins === 'mingxibiao') {
            /*
                        let orgurl = parseData.data[i].orgurl;
                        let villageId = parseData.data[i].orgid;
                        let recordId = parseData.data[i].recordid;
                        let myurl = orgurl + '?villageId=' + villageId + '&recordId=' + recordId + '&uid=' + $("#Cuid").val() +
                          '&nodeId=' + nodeId + '&selectId=' + selectId;

                        location.href = myurl;
                        return;
                      */
          }


          if (parseData.data[i].leipiplugins === 'jobprogress') {
            let orgurl = parseData.data[i].orgurl;
            let villageId = parseData.data[i].villageid;
            let recordId = parseData.data[i].recordid;
            let myurl = orgurl + '?villageId=' + villageId + '&recordId=' +
              recordId + '&uid=' + $("#Cuid").val() + '&nodeId=' + nodeId + '&selectId=' + selectId;
            location.href = myurl;
            return;
          }



        }

        //明细表 ww end
        $("#insertForm").submit(function(e) {
          e.preventDefault();
          /* 将列表控件新增的列保存起来 */
          $.each(parseData.data, function(index, value) {
            if (value.leipiplugins === 'listctrl') {
              $('#submitBtn').show();
              // 这是将新添加的数据保存到 orgrowvalue
              var allInput = $('#' + value.name + ' .cContainer.add').find('input'),
                tmp = ''; // 用来存放所有Input的值的临时变量
              for (var i = 0; i < allInput.length; i++) {
                tmp += allInput[i].value + '`';
              }
              value.orgrowvalue = tmp;

              // 这是将默认的第一行数据保存回 orgcolvalue
              var defaultInput = $('#' + value.name + ' .cContainer.template').find('input'),
                tmp = '';
              for (var i = 0; i < defaultInput.length; i++) {
                tmp += defaultInput[i].value + '`';
              }
              value.orgcolvalue = tmp;

              // 这是将总计的数量保存，方便下次打开能显示
              var total = $('#' + value.name + ' .total'),
                tmp = '';
              for (var i = 0; i < total.length; i++) {
                tmp += total[i].value + '`';
              }
              value.orgsumvalue = tmp;

            } else if (value.leipiplugins === 'addimage') {
              // 添加一个src去addimage里
              value.src = $('#' + value.name).val();
            }
          })
          //异步提交数据
          $.ajax({
            type: 'POST',
            url: prevent_HOST + 'pageDesignOperatorFacade/saveDesignPage',
            dataType: 'json',
            data: JSON.stringify(parseData),
            contentType: "application/json; charset=UTF-8;",
            // headers:{"token":userToKen},
            beforeSend: function(XMLhttpRequest) {
              $('body').addClass('spinnerContainer');
              $('.resValue').html('请稍等，正在为您保存中...');
              $('.spinner').fadeIn();
              //console.log( XMLhttpRequest );
            },
            complete: function(XMLhttpRequest, status) {
              if (XMLhttpRequest.status === 200) {
                $('.resValue').css('animation', 'font 1s').html('恭喜您，保存成功哦！:)');
                setTimeout(function() {
                  $('.spinner').fadeOut();
                  $('body').removeClass('spinnerContainer');
                  $('.resValue').css('animation', '');
                }, 1500);
              } else {
                $('.resValue').css('animation', 'font 1s').html('抱歉，保存失败，请重试！:(');
                setTimeout(function() {
                  $('.spinner').fadeOut();
                  $('body').removeClass('spinnerContainer');
                  $('.resValue').css('animation', '');
                }, 3000);
              }
            }
          });
        });

        for (var i = 0; i < parseData.data.length; i++) {
          if (parseData.data[i].leipiplugins === 'sort') {
            // 如果有分类控件 就要往后台去取数据
            $.ajax({ // 这是获取模板。
              url: prexvent_HOST + 'pageDesignQueryFacade/getPageContent?id=' + nodeId,
              type: 'GET',
              dataType: 'json',
              contentType: 'application/json; charset=UTF-8',
              headers: {
                "token": userToKen
              },
              async: false,
              success: function(res) {
                parseData = res['msg'];
              }
            })
          }
        }
        if (parseData.parse.indexOf('wifiblock') !== -1 || parseData.parse.indexOf('sort') !== -1) {
          // 如果有热区控件 就要往后台去取数据
          if (parseData.parse.indexOf('wifiblock') !== -1) {
            wifiBlock = true;
          }
          $.ajax({ // 这是获取模板。
            url: prevent_HOST + 'pageDesignQueryFacade/getPageContent?id=' + nodeId,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            headers: {
              "token": userToKen
            },
            async: false,
            success: function(res) {
              parseData = res['msg'];
            }
          })
        }
      }
      //否则为静态页跳转


    }

    if (parseData) { //用于静态资源进入
      if (parseData.data.length == 0) {
        //如果没有控件，就删除这几个标签，用于曹江党建页面速度优化
        // $('#avatar-modal').remove();
        // $('#spinner').remove();
        // $('#video-modal').remove();
        // $('#commentControl').remove();
        // $('#loginbox').remove();
        // $('#over').remove();

        //如果没有控件，就删除js文件引用
        // $('#md5JsId').remove();
        // $('#RSAJSId').remove();
        // $('#httpDataConfigJs').remove();
        // $('#ueditorParseJs').remove();
        // $('#ueditorConfigJs').remove();
        // $('#ueditorAllJs').remove();
        // $('#isMobileJs').remove();
        // $('#funJs').remove();
        // $('#use_top_previewJs').remove();
        // $('#use_bottom_previewJs').remove();
        // $('#preview_other_configJs').remove();
        // $('#preview_logicJs').remove();
      }



      var parse, // 数据字段内容
        nowDataSource; // 现在在用 parse 还是
      if (parseData.phoneParse !== null) {
        if (browser.versions.mobile === true || browser.versions.android === true) { // 根据不同终端显示不同东西.
          if (parseData.phoneParse !== null) {
            parse = parseData.phoneParse;
            nowDataSource = 'phoneParse';
          } else {
            parse = parseData.parse
            nowDataSource = 'parse';
          }
        } else {
          if (parseData.parse !== null) {
            parse = parseData.parse;
            nowDataSource = 'parse';
          } else {
            parse = parseData.phoneParse;
            nowDataSource = 'phoneParse';
            $('.container').addClass('phone').removeClass('pc');
          }
        }
      } else {
        parse = parseData.parse;
        nowDataSource = 'parse';
      }
      var datas = parseData.data; //  当前数据详细内容
      console.log(datas)
      //获取热区中是否有groupcon属性
      for (var i = 0; i < datas.length; i++) {
        if (!selectId) {
          selectId = 0;
        }
        if (parseData.data[i].leipiplugins === 'mingxibiao') {
          /*
                    let orgurl = parseData.data[i].orgurl;
                    let villageId = parseData.data[i].orgid;
                    let recordId = parseData.data[i].recordid;
                    let myurl = orgurl + '?villageId=' + villageId + '&recordId=' + recordId + '&uid=' + $("#Cuid").val() +
                      '&nodeId=' + nodeId + '&selectId=' + selectId;

                    location.href = myurl;
                    return;
                  */
        } else if (parseData.data[i].leipiplugins === 'jobprogress') {
          let orgurl = parseData.data[i].orgurl;
          let villageId = parseData.data[i].villageid;
          let recordId = parseData.data[i].recordid;
          let myurl = orgurl + '?villageId=' + villageId + '&recordId=' +
            recordId + '&uid=' + $("#Cuid").val() + '&nodeId=' + nodeId + '&selectId=' + selectId;
          location.href = myurl;
          return;
        } else if (parseData.data[i].hasOwnProperty("groupcon")) {
          groupcon = parseData.data[datas.length - 1].groupcon;
        } else {
          groupcon = null;
        }
      }


      if (parseData.fields != 0) {
        /*
         * 这里开始是把所有 控件的字段 都解析 拼接出来。
         *
         */

        //科普列表---搜索功能
        $('body').on('click', '.search_btn', function(e) {
          var key = $(".searchData").val(),
            searchUrl = $('.wifiblock').attr('orgurl').split('&')[0];
          // if ($('.wifiblockBox').children().length != 0) {
          //     $('.wifiblockBox').children().remove();
          // }
          var searchData = {
            "key": key,
            "groupcon": groupcon,
            "nodeId": nodeId,
            'wifiField': searchUrl
          };
          $.ajax({
            url: prevent_HOST + 'pageDesignQueryFacade/searchWifiKey',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            headers: {
              "token": userToKen
            },
            data: JSON.stringify(searchData),
            async: false,
            success: function(res) {
              parseData = res['msg'];

              //wifiblock();
              var html = '';
              var searchLength = JSON.parse(parseData.data[1].sqldata).length;
              for (var i = 0; i < searchLength; i++) {
                html +=
                  '<div class="wifiblock" groupcon="' + parseData.data[1].groupcon + '" orgurlname="' +
                  parseData.node_name +
                  '" orgurlid="' + parseData.node_id + '" orgvalue="' + parseData.data[1].groupcon +
                  '" orgtitle="" orgurl="' + parseData.wifiField + '&gid=' + JSON.parse(parseData.data[1]
                    .sqldata)[i].id +
                  '" style="display: flex;display: -webkit-flex;color: #333;margin-top:10px">' +
                  '<div class="wfImg"><img src="' + JSON.parse(parseData.data[1].sqldata)[i][JSON.parse(
                      parseData.data[1]
                      .datasource)
                    .field
                  ] + '" leipiplugins="addimage" groupcon="' + parseData.data[1].groupcon + '" name="' +
                  parseData.data[1]
                  .name + '" id="' + parseData.data[1].name + '"></div>' +
                  '<div class="wfDetail"><div class="title"><p leipiplugins="text" groupcon="' +
                  parseData.data[1].groupcon +
                  '" type="text" max="undefined" title="' + parseData.data[2].title + '" id="' +
                  parseData.data[2].name +
                  '" name="' + parseData.data[2].name + '" orgheight="' + parseData.data[2].orgheight +
                  '" orgwidth="' +
                  parseData.data[2].orgwidth + '" placeholder="" orgthide="' + parseData.data[2].orgthide +
                  '" orgbghide="' + parseData.data[2].orgbghide + '" datasource="' + parseData.data[2].datasource +
                  '">' +
                  JSON.parse(parseData.data[2].sqldata)[i][JSON.parse(parseData.data[2].datasource).field] +
                  '</p></div>' +
                  '<div class="detail"><div groupcon="' + parseData.data[1].groupcon +
                  '" leipiplugins="textarea" id="' +
                  parseData.data[3].name + '" name="' + parseData.data[3].name + '" title="' + parseData.data[
                    3].title +
                  '" style="font-size:;width:px;height:px;" datasource="' + parseData.data[3].datasource +
                  '" sqldata="' +
                  parseData.data[3].sqldata + '">' + JSON.parse(parseData.data[3].sqldata)[i][JSON.parse(
                    parseData.data[3]
                    .datasource).field] + '</div>' +
                  '</div><div class="autor"><p leipiplugins="text" groupcon="' + parseData.data[1].groupcon +
                  '" type="text" max="undefined" title="' + parseData.data[4].title + '" id="' +
                  parseData.data[4].name +
                  '" name="' + parseData.data[4].name + '" orgheight="' + parseData.data[4].orgheight +
                  '" orgwidth="' +
                  parseData.data[4].orgwidth + '" placeholder="" orgthide="' + parseData.data[4].orgthide +
                  '" orgbghide="' + parseData.data[4].orghbghide + '" datasource="' + parseData.data[4].datasource +
                  '">' +
                  JSON.parse(parseData.data[4].sqldata)[i][JSON.parse(parseData.data[4].datasource).field] +
                  '</p></div>' +
                  '<div class="confscource"><p leipiplugins="text" groupcon="' + parseData.data[1].groupcon +
                  '" type="text" max="undefined" title="' + parseData.data[5].title + '" id="' +
                  parseData.data[5].name +
                  '" name="' + parseData.data[5].name + '" orgheight="' + parseData.data[5].orgheight +
                  '" orgwidth="' +
                  parseData.data[5].orgwidth + '" placeholder="" orgthide="' + parseData.data[5].orgthide +
                  '" orgbghide="' + parseData.data[5].orgbghide + '" datasource="' + parseData.data[5].datasource +
                  '0">' +
                  JSON.parse(parseData.data[5].sqldata)[i][JSON.parse(parseData.data[5].datasource).field] +
                  '</p></div><div class="orgCollect"></div></div></div>';
              }
              $('.wifiblockBox').append(html);
            }
          })
        })

        //搜索控件
        $(document).on('click', '#searchControl', function(e) {
          var sortingConditions = "";
          searchAjax(sortingConditions);
        })

        //点击搜索排序条件
        $(document).on('click', '.navk', function(e) {
          $(this).addClass('active').siblings().removeClass('active');
          var sortingConditions = $(this).attr('searchKeyValue');
          searchAjax(sortingConditions);
        })
        var isShow = false;
        if (urlMethod == "watch") isShow = true;
        //去空
        function tempNull(arr) {
          for (var i = 0; i < arr.length; i++) {
            if (arr[i] === "" || typeof(arr) === "undefind") {
              arr.splice(i, 1);
            }
          }
        }

        function searchAjax(sortingConditions) {
          var table_name = $("#searchControl").attr('data-id'),
            searchContent = $("#searchItem .searchData").val(),
            tableField = [],
            searchId = $($('.wifiblock').find('[name^=data]')[0]).attr('searchid'),
            currentPage = 1;
          tableField = $('#productSort').attr('searchfieldvalue').split('`');
          tempNull(tableField); //去空
          var searchAllData = {
            "table_name": table_name,
            "searchContent": searchContent,
            "table_field": tableField,
            "sortingConditions": sortingConditions,
            "currentPage": currentPage,
            "searchId": searchId
          }
          $.ajax({
            url: prevent_HOST + 'pageDesignQueryFacade/selectDynamicSearch',
            type: "POST",
            dataType: "json",
            contentType: 'application/json;charset=UTF-8',
            headers: {
              "token": userToKen
            },
            async: false,
            data: JSON.stringify(searchAllData),
            success: function(res) {
              //console.log( res.msg.map )
            }
          })
        }
        $.each(datas, function(index, value) {
          if (value.parse_name) { // chekcbox 解析出来的name是不一样的
            fields.push(value.parse_name);
          } else {
            fields.push(value.name);
          }
        })
        var NODENAME = parseData[nowDataSource].indexOf('wifiblockBox')
        // console.log( fields )
        // 热区控件逻辑
        if (wifiBlock) {
          var sqlDataLen = [];
          for (var i = 0; i < fields.length; i++) {
            sqlDataLen.push(JSON.parse(datas[i].sqldata).length);
            var sqlmax = sqlDataLen[0];
            for (var j = 0; j < sqlDataLen.length; j++) {
              if (sqlDataLen[j] > sqlmax) {
                sqlmax = sqlDataLen[j];
              }
            }
          }
        }

        if (parseData[nowDataSource].indexOf('wifiblockBox') !== -1) {
          var html = '';
          DataJson.forEach(function(item, array) {
            html += '<img src="' + item.data1 + '">';
          })

        } else {
          // 在parse里面匹配fields字段并替换
        }
        for (var i = 0; i < fields.length; i++) {
          var dataType = datas[i].leipiplugins,
            showData = '', // 变为预览状态的临时变量
            data = datas[i],
            // numTimes = false,
            inputValue = '';
          var isWhat;
          // console.log( data )
          // 将解析的数据变为预览状态
          switch (dataType) {
            case "assetdetail":
              var method = null;
              if (window.location.search) {
                var urlParamArray = window.location.search.split('?')[1].split('&');
                for (var upa = 0; upa < urlParamArray.length; upa++) {
                  var urlParam = urlParamArray[upa];
                  var proName = urlParam.split('=')[0];
                  var proValue = urlParam.split('=')[1];
                  if (proName == 'method') {
                    method = proValue;
                  }
                }
              }

              if (method == 'watch') {

                //如果为浏览模式，则为以下表格不可编辑模式

                showData +=
                  '<table lay-filter="assetTableFilter" id="assetDetailTableId" class="layui-table" lay-data="{id:\'assetTableId\'}">' +
                  '<thead>' +
                  '<tr>' +
                  '<th lay-data="{field:\'orderNum\', width:60,align:\'center\',unresize:true}" rowspan="3">编号</th>' +
                  '<th lay-data="{field:\'assetName\', width:90,align:\'center\',unresize:true }" rowspan="3">资产名称</th>' +
                  '<th lay-data="{field:\'totalArea\', width:75,align:\'center\',unresize:true,totalRow: true}" rowspan="3">总面积(亩)</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="9">未承包到户</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="3">已承包到户</th>' +
                  '<th lay-data="{field:\'remark\', width:100,align:\'center\',unresize:true }" rowspan="3">备注1</th>' +
                  '<th lay-data="{align: \'center\', toolbar: \'#assetTool\',unresize:true}" rowspan="3">备注2</th>' +
                  '</tr>' +
                  '<tr>' +
                  '<th lay-data="{field:\'noContractArea\',width:75,align:\'center\',unresize:true,totalRow: true }" rowspan="2">面积(亩)</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="2">集体自主经营</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="4">出租经营</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="2">其他经营方式</th>' +
                  '<th lay-data="{field:\'contractArea\',width:75,align:\'center\',unresize:true ,totalRow: true}" rowspan="2">面积(亩)</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="2">其中：流转入集体统一经营</th>' +
                  '</tr>' +
                  '<tr>' +
                  '<th lay-data="{field:\'independentManagementArea\',width:60,align:\'center\',unresize:true ,totalRow: true}">面积(亩)</th>' +
                  '<th lay-data="{field:\'independentManagementIncome\',width:75,align:\'center\',unresize:true ,totalRow: true}">年收益(元)</th>' +
                  '<th lay-data="{field:\'rentoutManagementArea\',width:60,align:\'center\',unresize:true ,totalRow: true}">面积(亩)</th>' +
                  '<th lay-data="{field:\'rentoutMan\',width:120,align:\'center\',unresize:true }">承租人</th>' +
                  '<th lay-data="{field:\'rentoutTime\',width:200,align:\'center\',unresize:true }">起止时间</th>' +
                  '<th lay-data="{field:\'rentoutMoney\',width:75,align:\'center\',unresize:true ,totalRow: true}">年租金(元)</th>' +
                  '<th lay-data="{field:\'otherManagementArea\',width:60,align:\'center\',unresize:true ,totalRow: true}">面积(亩)</th>' +
                  '<th lay-data="{field:\'otherManagementIncome\',width:75,align:\'center\',unresize:true ,totalRow: true}">年收益(元)</th>' +
                  '<th lay-data="{field:\'unificationManagementArea\',width:60,align:\'center\',unresize:true ,totalRow: true}">面积(亩)</th>' +
                  '<th lay-data="{field:\'unificationManagementIncome\',width:75,align:\'center\',unresize:true ,totalRow: true}">年收益(元)</th>' +
                  '</tr>' +
                  '</thead>' +
                  '</table>' +
                  '<script type="text/html" id="assetTool">' +
                  '<a class="assetOperateCla layui-btn layui-btn-primary layui-btn-xs" lay-event="textInfo">资料</a>' +
                  '<a class="assetOperateCla layui-btn layui-btn-primary layui-btn-xs" lay-event="videoInfo">视频</a>' +
                  '</script>' +
                  '<div id="videoInfoAreaId">' +
                  '<div id="videoInfoTitleDivId">' +
                  '<input id="videoInfoTitleId" type="text" name="videoInfoTitle" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">' +
                  '</div>' +
                  '<div id="videoInfoDateDivId">' +
                  '<input id="videoInfoDateId" type="text" class="layui-input" placeholder="yyyy-MM-dd">' +
                  '</div>' +
                  '<div id="videoInfoContentDivId">' +
                  '<video id="videoInfoContentId" src="" controls="controls" height="500px" width="500px" preload="auto">' +
                  '您的浏览器不支持 video 标签。' +
                  '</video>' +
                  '<button id="uploadVideoBtnId" class="layui-btn">上传文件</button>' +
                  '</div>' +
                  '</div>' +
                  '<div id="textInfoAreaId">' +
                  '<div id="textInfoTitleDivId">' +
                  '<input id="textInfoTitleId" type="text" name="textInfoTitle" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">' +
                  '</div>' +
                  '<div id="textInfoDateDivId">' +
                  '<input id="textInfoDateId" type="text" class="layui-input" placeholder="yyyy-MM-dd">' +
                  '</div>' +
                  '<div id="textInfoContentDivId">' +
                  '<textarea id="textInfoContentId" name="textInfoContent" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>' +
                  '</div>' +

                  '<div id="textInfoImgDivId">' +
                  '<img id="textInfoImgId" style="width: 600px;" src="">' +
                  '<button id="uploadImgBtnId" class="layui-btn">上传图片</button>' +
                  '</div>' +

                  '</div>';
              } else {
                showData +=
                  '<table lay-filter="assetTableFilter" id="assetDetailTableId" class="layui-table" lay-data="{id:\'assetTableId\'}">' +
                  '<thead>' +
                  '<tr>' +
                  '<th lay-data="{type:\'checkbox\'}" rowspan="3"></th>' +
                  '<th lay-data="{field:\'orderNum\', width:60,align:\'center\',unresize:true}" rowspan="3">编号</th>' +
                  '<th lay-data="{field:\'assetName\', width:90,align:\'center\',unresize:true,edit: \'text\'}" rowspan="3">资产名称</th>' +
                  '<th lay-data="{field:\'totalArea\', width:75,align:\'center\',unresize:true ,totalRow: true,edit: \'text\'}" rowspan="3">总面积(亩)</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="9">未承包到户</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="3">已承包到户</th>' +
                  '<th lay-data="{field:\'remark\', width:100,align:\'center\',unresize:true,edit: \'text\' }" rowspan="3">备注1</th>' +
                  '<th lay-data="{align: \'center\', toolbar: \'#assetTool\',unresize:true}" rowspan="3">备注2</th>' +
                  '</tr>' +
                  '<tr>' +
                  '<th lay-data="{field:\'noContractArea\',width:75,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}" rowspan="2">面积(亩)</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="2">集体自主经营</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="4">出租经营</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="2">其他经营方式</th>' +
                  '<th lay-data="{field:\'contractArea\',width:75,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}" rowspan="2">面积(亩)</th>' +
                  '<th lay-data="{align:\'center\',unresize:true}" colspan="2">其中：流转入集体统一经营</th>' +
                  '</tr>' +
                  '<tr>' +
                  '<th lay-data="{field:\'independentManagementArea\',width:60,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">面积(亩)</th>' +
                  '<th lay-data="{field:\'independentManagementIncome\',width:75,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">年收益(元)</th>' +
                  '<th lay-data="{field:\'rentoutManagementArea\',width:60,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">面积(亩)</th>' +
                  '<th lay-data="{field:\'rentoutMan\',width:120,align:\'center\',unresize:true,edit: \'text\'}">承租人</th>' +
                  '<th lay-data="{field:\'rentoutTime\',width:200,align:\'center\',unresize:true,edit: \'text\'}">起止时间</th>' +
                  '<th lay-data="{field:\'rentoutMoney\',width:75,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">年租金(元)</th>' +
                  '<th lay-data="{field:\'otherManagementArea\',width:60,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">面积(亩)</th>' +
                  '<th lay-data="{field:\'otherManagementIncome\',width:75,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">年收益(元)</th>' +
                  '<th lay-data="{field:\'unificationManagementArea\',width:60,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">面积(亩)</th>' +
                  '<th lay-data="{field:\'unificationManagementIncome\',width:75,align:\'center\',unresize:true,totalRow: true,edit: \'text\'}">年收益(元)</th>' +
                  '</tr>' +
                  '</thead>' +
                  '</table>' +
                  '<script type="text/html" id="assetToolbar">' +
                  '<div class="layui-btn-container">' +
                  '<button class="layui-btn layui-btn-sm" lay-event="addAssetDetailBtn">添加资产记录</button>' +
                  '<button class="layui-btn layui-btn-sm" lay-event="delAssetDetailBtn">删除选中记录</button>' +
                  '</div>' +
                  '</script>' +
                  '<script type="text/html" id="assetTool">' +
                  '<a class="assetOperateCla layui-btn layui-btn-primary layui-btn-xs" lay-event="textInfo">资料</a>' +
                  '<a class="assetOperateCla layui-btn layui-btn-primary layui-btn-xs" lay-event="videoInfo">视频</a>' +
                  '</script>' +
                  '<div id="videoInfoAreaId">' +
                  '<div id="videoInfoTitleDivId">' +
                  '<input id="videoInfoTitleId" type="text" name="videoInfoTitle" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">' +
                  '</div>' +
                  '<div id="videoInfoDateDivId">' +
                  '<input id="videoInfoDateId" type="text" class="layui-input" placeholder="yyyy-MM-dd">' +
                  '</div>' +
                  '<div id="videoInfoContentDivId">' +
                  '<video id="videoInfoContentId" src="" controls="controls" height="500px" width="500px" preload="auto">' +
                  '您的浏览器不支持 video 标签。' +
                  '</video>' +
                  '<button id="uploadVideoBtnId" class="layui-btn">上传文件</button>' +
                  '</div>' +
                  '</div>' +
                  '<div id="textInfoAreaId">' +
                  '<div id="textInfoTitleDivId">' +
                  '<input id="textInfoTitleId" type="text" name="textInfoTitle" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">' +
                  '</div>' +
                  '<div id="textInfoDateDivId">' +
                  '<input id="textInfoDateId" type="text" class="layui-input" placeholder="yyyy-MM-dd">' +
                  '</div>' +
                  '<div id="textInfoContentDivId">' +
                  '<textarea id="textInfoContentId" name="textInfoContent" required lay-verify="required" placeholder="请输入" class="layui-textarea"></textarea>' +
                  '</div>' +

                  '<div id="textInfoImgDivId">' +
                  '<img id="textInfoImgId" style="width: 600px;" src="">' +
                  '<button id="uploadImgBtnId" class="layui-btn">上传图片</button>' +
                  '</div>' +

                  '</div>';
              }










              showData +=
                '<script src="./self/assetDetail/assetDetail.js" type="text/javascript" charset="utf-8"></script>';

              var link = $(
                '<link rel="stylesheet" type="text/css" href="./self/assetDetail/assetDetail.css"/>'
              );
              // $('body').append(script);
              $('head').append(link);

              break;
              /**
               * 袁君选
               * 自助机点餐
               */
            case "vemorderfood":
              window.location.href = "/editor/assets/ueditor/formdesign/self/htevmorderfood/html/homepage.html";
              break;

              /**
               * 订单中心
               * 袁君选
               */
            case "orderscentre":
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/htorderscentre/html/orderscentrepage.html";
              break;

              //预览餐品页面
            case "previewproducts":
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/previewproducts/homepage.html?status=0";
              break;


              // 餐品上传
            case "productsupload":
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/productsupload/productsuploadhomepage.html";
              break;

              //添加类别
            case "addcategory":
              window.location.href = "/editor/assets/ueditor/formdesign/self/productsupload/caategory.html";
              break;




            case "multidatasourcepublic":
              showData += '<select class="watch_remove" id="selectPublicSourceId" thisnodeid="' + parseData.node_id +
                '"></select>';
              showData +=
                '<script src="./self/multidatasourcepublic/multidatasourcepublic.js" type="text/javascript" charset="utf-8"></script>';


              break;
            case "sidebarnav":
              var leftNavDefinitions = datas[i].leftnavdefinitions;
              var bluestyle = data.bluestyle;
              leftNavDefinitions = leftNavDefinitions.replace(/&quot;/g, '"');
              leftNavDefinitions = JSON.parse(leftNavDefinitions);
              console.log("leftNavDefinitions=" + leftNavDefinitions)
              console.log("bluestyle====" + bluestyle)

              showData += '<div id="containerId">' +
                '<div id="sidebarnavId">' +
                '<ul>';


              for (var ln = 0; ln < leftNavDefinitions.length; ln++) {
                var leftNavDefinition = leftNavDefinitions[ln];

                var leftNavName = leftNavDefinition.leftNavName;
                var leftNavToPage = leftNavDefinition.leftNavToPage;

                /* showData += '<li><a class="sidebarnavtoCla" href="#">曹江镇<span class="indexLogoCla">></span></a></li>' +
                	'<li><a class="sidebarnavtoCla" href="#">机关支部<span class="indexLogoCla">></span></a></li>' +
                	'<li><a class="sidebarnavtoCla" href="#">农村支部<span class="indexLogoCla">></span></a></li>' +
                	'<li><a class="sidebarnavtoCla" href="#">两新支部<span class="indexLogoCla">></span></a></li>'; */

                if (bluestyle == "1") {
                  showData += '<li><a class="sidebarnavtoCla2" whatstyle="bluestyle" leftnavtopage="' +
                    leftNavToPage +
                    '" href="javascript:void(0);">' + leftNavName +
                    '</a></li>'; //<span class="indexLogoCla">></span>
                  $('body').ready(function() {
                    $('.sidebarnavtoCla2').css('background', '#ffffff');
                  })
                  $('body').on('click', '.sidebarnavtoCla2', function() {
                    $(this).css("background", "skyblue none repeat scroll 0% 0%");
                  })
                } else {
                  showData += '<li><a class="sidebarnavtoCla" leftnavtopage="' + leftNavToPage +
                    '" href="javascript:void(0);">' + leftNavName +
                    '<span class="indexLogoCla">></span></a></li>';
                }


              }





              showData += '</ul>' +
                '</div>' +
                '<iframe id="rightContentId" frameborder="0" src="" width="89%" styple="margin-left:5px" height="200"></iframe>' +
                '</div>' +
                '<script src="/editor/assets/ueditor/formdesign/self/sidebarnav/sidebarnav.js" type="text/javascript" charset="utf-8"></script>';





              // var script = $(
              // 	'<script src="./self/sidebarnav/sidebarnav.js" type="text/javascript" charset="utf-8" defer="defer"></script>'
              // );
              var link = $(
                '<link rel="stylesheet" type="text/css" href="/editor/assets/ueditor/formdesign/self/sidebarnav/sidebarnav.css"/>'
              );
              // $('body').append(script);
              $('head').append(link);

              break;
            case "headerandfooter":
              var headerDefinitions = datas[i].headerdefinitions;
              var footerDefinitions = datas[i].footerdefinitions;

              headerDefinitions = headerDefinitions.replace(/&quot;/g, '"');
              headerDefinitions = JSON.parse(headerDefinitions);
              footerDefinitions = footerDefinitions.replace(/&quot;/g, '"');
              footerDefinitions = JSON.parse(footerDefinitions);





              showData += '<div id="headerId">' +
                '<div id="rowoneId">' +
                '<span style="margin-left: 12%;"></span>' +
                '<img id="dangjianlogo" src="/editor/assets/ueditor/formdesign/self/headerandfooter/dangjianlogo.png" >' +
                '<div id="themeId">曹江智慧党建</div>' +
                '</div>' +
                '<span style="padding: 2px 10px;border-radius:3px;' +
                'cursor: pointer;' +
                'background-color: #0080ff;color: #ffffff;font-size: 16px;"' +
                'id="dl" toaccount="notoaccount" fromwhere="headerAndFooter" onclick="dologin()">登录</span>' +
                '<div id="indexId">' +
                '<ul id="indextoId">';

              for (var la = 0; la < headerDefinitions.length; la++) {
                var headerDefinition = headerDefinitions[la];
                var headerNavName = headerDefinition.headerNavName;
                var headerNavToPage = headerDefinition.headerNavToPage;
                var isJumpToUrl = headerDefinition.isJumpToUrl;
                showData += '<li><a class="indexcla" onclick="indexclaCli(this)" isjumptourl="' + isJumpToUrl +
                  '" headerNavToPage="' + headerNavToPage +
                  '" href="#">' + headerNavName +
                  '</a></li>';


              }

              /* 	'<li><a class="indexcla" href="#">首页</a></li>' +
              	'<li><a class="indexcla" href="#">组织建设</a></li>' +
              	'<li><a class="indexcla" href="#">党员管理</a></li>' +
              	'<li><a class="indexcla" href="#">教育学习</a></li>' +
              	'<li><a class="indexcla" href="#">主题活动</a></li>' +
              	'<li><a class="indexcla" href="#">党建三年行动计划</a></li>' +
              	'<li><a class="indexcla" href="#">廉政建设</a></li>' +
              	'<li><a class="indexcla" href="#">党建考核</a></li>' +
              	'<li><a class="indexcla" href="#">党建+</a></li>' + */



              showData += '</ul>' +
                '</div>' +
                '</div>' +
                '<iframe frameborder="0" style="overflow: scroll;overflow-x: hidden;" allowtransparency="true" id="midContentId" width="" height="" ></iframe>' +
                '<div id="footerId">' +
                '<div style="color: white;font-size: 15px;padding: 20px 0px 0px 20px;">网站导航</div>' +
                '<div id="findexArea">' +
                '<ul id="findextoId">';


              for (var la = 0; la < footerDefinitions.length; la++) {
                var footerDefinition = footerDefinitions[la];
                var footerNavName = footerDefinition.footerNavName;
                var footerNavToPage = footerDefinition.footerNavToPage;
                var isJumpToUrl = footerDefinition.isJumpToUrl;
                showData += '<li><a class="findexcla" onclick="findexclaCli(this)" isjumptourl="' + isJumpToUrl +
                  '" footerNavToPage="' + footerNavToPage + '" href="#">' + footerNavName +
                  '</a></li>';


              }


              /* 	'<li><a class="findexcla" href="#">首页</a></li>' +
              	'<li><a class="findexcla" href="#">组织建设</a></li>' +
              	'<li><a class="findexcla" href="#">党员管理</a></li>' +
              	'<li><a class="findexcla" href="#">教育学习</a></li>' +
              	'<li><a class="findexcla" href="#">主题活动</a></li>' +
              	'<li><a class="findexcla" href="#">党建三年行动计划</a></li>' +
              	'<li><a class="findexcla" href="#">廉政建设</a></li>' +
              	'<li><a class="findexcla" href="#">党建考核</a></li>' +
              	'<li><a class="findexcla" href="#">党建+</a></li>' + */

              showData += '</div>' +
                '</ul>' +
                '</div>' +
                '<script src="/editor/assets/ueditor/formdesign/self/headerandfooter/headerandfooter.js" type="text/javascript" charset="utf-8"></script>';




              /* var script = $(
              	'<script src="./self/headerandfooter/headerandfooter.js" defer="defer" type="text/javascript" charset="utf-8"></script>'
              ); */
              var link = $(
                '<link rel="stylesheet" type="text/css" href="./self/headerandfooter/headerandfooter.css"/>'
              );
              // $('body').append(script);
              $('head').append(link);

              break;




            case "score":

              showData += '<div id="scoreId"></div>' +
                '<script src="/editor/assets/ueditor/formdesign/self/js/score.js" type="text/javascript" charset="utf-8"></script>';


              /* 	var script = $(
              		'<script src="./self/js/score.js" type="text/javascript" charset="utf-8" defer="defer"></script>'
              	);
              	$('body').append(script); */

              break;
            case "classifytree04":
              var nd4 = datas[i].node_id;
              isWhat = 'two';
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/classifyTree2/classifyTree.html?nodeId=" + nd4 +
                "&isWhat=" + isWhat;

              break;
            case "classifytree03":
              var nd3 = datas[i].node_id;
              isWhat = 'one';
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/classifyTree2/classifyTree.html?nodeId=" + nd3 +
                "&isWhat=" + isWhat;

              break;


            case "classifytree02":
              var nd2 = datas[i].node_id;
              isWhat = 'two';
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/classifyTree/classifyTree.html?nodeId=" + nd2 +
                "&isWhat=" + isWhat;

              break;
            case "classifytree":
              var nd = datas[i].node_id;
              isWhat = 'one';
              window.location.href =
                "/editor/assets/ueditor/formdesign/self/classifyTree/classifyTree.html?nodeId=" + nd +
                "&isWhat=" + isWhat;

              break;
            case "pagekeywords":
              // alert("进来了");
              // 					alert("pagetitle="+data.pagetitle)
              // 					alert("keywords="+data.keywords)
              // 					alert("description="+data.description)
              var pagetitle = data.pagetitle;
              var keywords = data.keywords;
              var description = data.description;
              $('title').html(pagetitle);
              var ohead = $('head');
              ohead.append('<meta name="keywords" content="' + keywords + '"/>')
              ohead.append('<meta name="description" content="' + description + '"/>')
              break;
            case "text":
              // alert("是进入这里吗？")
              if (isShow && data.name != 'sousuokuang') {
                if (idData.msg != null) {
                  var textcontent = idData.msg.data[data.name];
                  if (textcontent == undefined) textcontent = '';
                  if (data.fontset != "默认" && data.fontset != "null") {
                    showData = '<span style="font-size:' + data.orgfontsize + 'px;font-family:\'' + data.fontset +
                      '\';line-height: ' + (parseInt(data.orgfontsize) + 5) + 'px;">' + textcontent + "</span>";
                  } else {
                    showData = '<span style="font-size:' + data.orgfontsize + 'px;line-height: ' + (parseInt(data.orgfontsize) +
                      5) + 'px;">' + idData.msg.data[data.name] + "</span>";
                  }
                }
              } else {
                // orgtype -- 没用
                var dataHide, // input是否隐藏
                  dataThide, // input边框是否隐藏
                  dataBghide, // input底色是否隐藏
                  type, // input的类型判断
                  max, min, disabled,
                  placeholder;
                switch (data.orgtype) {
                  case 'email':
                    // placeholder = '请输入正确的 “邮箱” 地址';
                    type = 'email';
                    break;
                  case 'int':
                    // placeholder = '请输入 “整数” 类型';
                    type = 'number';
                    break;
                  case 'float':
                    // placeholder = '请输入 “浮点数” 类型';
                    type = 'text';
                    break;
                  case 'idcard':
                    // placeholder = '请输入正确的 “身份证” 号码';
                    type = 'number';
                    max = 999999999999999999;
                    break;
                  default:
                    // placeholder = '请输入 “文本” ';
                    type = 'text';
                    break;
                }
                data.value === '' ? placeholder = '' : placeholder = data.value;
                //console.log( data.value_2 );
                data.orghide == 0 ? dataHide = "inline-block" : dataHide = "none";
                data.orgdisabled === '1' ? disabled = "disabled" : disabled = "";
                var textValue = '';
                var tUs = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
                if (data.writenickname == '1') {
                  if (tUs != null) {
                    if (tUs.chinaName) {
                      textValue = tUs.chinaName;
                    } else {
                      textValue = tUs.userName;
                    }
                  } else {
                    textValue = '当前用户未登录';
                  }
                  data.value_2 = textValue;
                }


                if (datas[i].groupcon != null && datas[i].groupcon != "null" && source !== 'datatable' && datas[i].searchId !=
                  "null") { //如果是组合控件中的热区

                  showData = "<p " + disabled + " leipiplugins='" + data.leipiplugins + "' groupCon='" + data.groupcon +
                    "'type=" + type +
                    " max='" + max + "' maxlength='" + data.maxlength + "' title='" + data.title + "' id='" +
                    data.name + "' name='" + data.name + "' orgheight='" + data.orgheight + "' orgwidth='" + data.orgwidth +
                    "' placeholder='" + placeholder + "' orgthide='" + data.orgthide + "' orgbghide='" +
                    data.orgbghide + "' datasource = " + data.datasource + " style='line-clamp:" + data.lineClamp +
                    ";'  value='" + textValue + "'></p>"
                } else if (datas[i].groupcon === '' && source !== 'datatable' && datas[i].datasource === "") { //如果是组合控件中的热区
                  showData = "<p " + disabled + " leipiplugins='" + data.leipiplugins + "' groupCon='" + data.groupcon +
                    "'type=" + type +
                    " max='" + max + "' maxlength='" + data.maxlength + "'  title='" + data.title + "' id='" +
                    data.name + "' value_2='" + data.value_2 + "' name='" + data.name + "' orgheight='" + data.orgheight +
                    "' orgwidth='" + data.orgwidth +
                    "' placeholder='" + placeholder + "' orgthide='" + data.orgthide + "' orgbghide='" +
                    data.orgbghide + "' datasource = " + data.datasource + " style='line-clamp:" + data.lineClamp +
                    ";'  value='" + textValue + "'></p>"
                } else {
                  if (!data.value_2) { //如果没有文本显示限制就不加value_2属性，之后JQ事件有用到
                    showData = "<input class='searchData' " + disabled + " leipiplugins='" + data.leipiplugins +
                      "' onclick='clearInputValue(event)' orgtype=" + data.orgtype + " type=" + type +
                      " max='" + max + "' maxlength='" + data.maxlength + "' title='" + data.title + "' id='" +
                      data.name + "' name='" + data.name + "' orgheight='" + data.orgheight + "' orgwidth='" + data
                      .orgwidth +
                      "' style='line-clamp:" + data.lineClamp + ";" + data.style + "' placeholder='" + placeholder +
                      "' orgthide='" + data.orgthide +
                      "' orgbghide='" +
                      data.orgbghide + "' datasource = " + data.datasource + "  value='" + textValue + "'>";
                  } else {

                    showData = "<input class='searchData' " + disabled + " leipiplugins='" + data.leipiplugins +
                      "' onclick='clearInputValue(event)' orgtype=" + data.orgtype + " type=" + type +
                      " max='" + max + "' maxlength='" + data.maxlength + "' title='" + data.title + "' id='" +
                      data.name + "' name='" + data.name + "' orgheight='" + data.orgheight + "' orgwidth='" + data
                      .orgwidth +
                      "' value_2='" + data.value_2 + "' style='line-clamp:" + data.lineClamp + ";" + data.style +
                      "' placeholder='" + placeholder + "' orgthide='" + data.orgthide +
                      "' orgbghide='" +
                      data.orgbghide + "' datasource = " + data.datasource + " value='" + textValue + "'>";

                  }
                }
              }


              break;
            case "textarea":
              // alert("照理说葛发");



              if (isShow) {
                var lineheight = "26px";
                if (data.listheight != 'null') lineheight = data.listheight;
                if (idData.msg != null) showData = '<p style="line-height:' + lineheight + '">' + doDeStrMarks(
                  idData.msg.data[
                    data.name]) + '</p>';
              } else {
                if (data.orgrich == '1') {
                  var style = "width:100%;";
                  if (data.orgwidth != '' && data.orgwidth != 'null') style = "width:" + data.orgwidth + ";";
                  if (data.orgheight != '' && data.orgheight != 'null') style += "height:" + data.orgheight + ";";
                  showData = '<script id="' + data.name + '" type="text/plain" style="' + style + '"></script>';
                } else {
                  if (NODENAME > -1) {
                    numTimes = false;
                    // !!!!!!!!!!!!!  ordrich -- 是否富文本格式  暂时没弄 迟点弄
                    showData = "<div leipiplugins='" + data.leipiplugins + "' id='" + data.name + "' name='" + data
                      .name +
                      "' title='" + data.title +
                      "' wrap='hard' cols='50' style='font-size:" + data.orgfontsize + ";width:" + data.orgwidth +
                      "px;height:" +
                      data.orgheight +
                      "px;box-sizing:border-box;" + data.style + "' datasource=" + data.datasource + " sqldata=" +
                      data.sqldata +
                      ">" + data.value + "</div>";

                  } else {
                    numTimes = false;
                    //var disabled=data.orgdisabled == 1? true : " ";
                    //console.log( data.orgdisabled );
                    // !!!!!!!!!!!!!  ordrich -- 是否富文本格式  暂时没弄 迟点弄
                    showData = "<textarea maxlength='" + data.maxlength + "' leipiplugins='" + data.leipiplugins +
                      "' value='' id='" + data.name + "' name='" + data.name +
                      "' title='" + data.title + "'";
                    if (data.orgdisabled == 1) {
                      showData += "disabled";
                    }
                    if (data.value_2) {
                      showData += " value_2='" + data.value_2 + "'";
                    }
                    showData += " style='resize:none;font-size:" + data.orgfontsize + ";width:" + data.orgwidth +
                      "px;height:" +
                      data.orgheight +
                      "px;box-sizing:border-box;" + data.style + "' datasource=" + data.datasource + " sqldata=" +
                      data.sqldata +
                      " placeholder='" + data.title + "'></textarea>"
                  }
                }
              }
              break;
            case "flowbtn":
              //! 下拉菜单
              var htype = data.orgvarfontheight === "0" ? "px" : "%";
              var wtype = data.orgvarfontwidth === "0" ? "px" : "%";
              var bgcolor = data.orgbgcolor === "" ? "" : "background:" + data.orgbgcolor + ";";
              var fncolor = data.orgfontcolor === "" ? "" : "color:" + data.orgfontcolor + ";";
              showData = "<input data-toggle='modal' orgformid='" + data.orgformid +
                "' data-target='#myFlowModal' orgflow='" +
                data.orgflow + "' orgfontcolor='" + data.orgfontcolor + "' orgbgcolor='" + data.orgbgcolor +
                "' orgurl='" +
                data.orgurl +
                "' orgname='" + data.orgname + "' name='" + data.name + "' leipiplugins='" + data.leipiplugins +
                "' type='" +
                data.type + "' " +
                "title='" + data.title + "' value='" + data.value + "' onclick='" + data.onclick + "' " +
                " style='padding:0 !important; height:" + data.orgheight + htype + " ;width:" + data.orgwidth +
                wtype + " ;" +
                bgcolor + fncolor + "' >" +
                "<script src='/editor/assets/ueditor/formdesign/self/js/allflow.js'></script>";

              /* 	var script = $("<script src='./self/js/allflow.js' defer='defer'></script>");
              	$('body').append(script); */
              break;
            case "select":
              //! 下拉菜单
              var dataValue = data.value.split(","); // 控件内容 -- 把字符串分割为数组 isShow &&
              var conhide = data.conhide;
              var dSource = data.datasources;
              var dSourceName = data.datatitle;
              if (isShow && conhide == "1") {
                showData = "";
              } else if (isShow && conhide == "2") {
                if (idData !== undefined && idData['msg']['data'] != null) {
                  showData = idData['msg']['data'][data.name];
                }
              } else if (data.isstate == "1") {
                showData = "";
                var rec_title = '';
                var rec_nodename = '';
                if (currNode != undefined && currNode != null && currNode != '') rec_nodename = currNode.value;
                if (data.datatitle != '0' && data.datatitle != 'null') {
                  if (idData !== undefined && idData['msg']['data'] != null) {
                    rec_title = idData['msg']['data'][data.datatitle];
                  }
                }
                $.each(dataValue, function(key, value) {
                  //doUrge(&quot;15062&quot;,&quot;下拉控件&quot;,&quot;&quot;,&quot;null&quot;,&quot;未完成&quot;)
                  showData += "<span class='plu_select_state' value='" + value + "' onclick='doUrge(\"" +
                    nodeId + "\",\"" +
                    rec_nodename + "\",\"" + rec_title + "\",\"" + selectId + "\",\"" + value + "\")'>" + value +
                    "</span>";
                })
              } else if (isShow) {
                // selected -- 没用
                showData = "<select leipiplugins='" + data.leipiplugins + "' datasource='" + data.datasource +
                  "' id='" +
                  data.name + "' name='" + data.name + "' title='" + data.title +
                  "' size='" + data.size +
                  "' selected='" + data.selected + "' style='" + data.style + "' onchange='doSelect(this.value)'>";
                $.each(dataValue, function(key, value) {
                  if (value == data.selected) {
                    showData += "<option value='" + value + "' selected='" + value + "'>" + value + "</option>"
                  } else {
                    showData += "<option value='" + value + "'>" + value + "</option>"
                  }
                })

                showData += "</select>";
              } else {
                showData = "<select leipiplugins='" + data.leipiplugins + "' datasource='" + data.datasource +
                  "' id='" +
                  data.name + "' name='" + data.name + "' title='" + data.title +
                  "' size='" + data.size +
                  "' selected='" + data.selected + "' style='" + data.style + "'>";
                $.each(dataValue, function(key, value) {
                  if (value == data.selected) {
                    showData += "<option value='" + value + "' selected='" + value + "'>" + value + "</option>"
                  } else {
                    showData += "<option value='" + value + "'>" + value + "</option>"
                  }
                })
                if (dSource != null && dSource != 'null' && dSourceName != 'null') {
                  dSource = dSource.split(":");
                  if (dSource.length > 1) {
                    var ajaxData = {
                      "node_id": dSource[0],
                      "classname": dSource[1],
                      "page": 1,
                      "pagesize": 100,
                      "orderby": "desc",
                      "table_field_all": null,
                      "searchContent": null,
                      "method": "getQueryPage"
                    };
                    $.ajax({
                      url: prevent_HOST + 'pageDesignOperatorFacade/selectFormRecord',
                      type: 'POST',
                      dataType: 'json',
                      contentType: 'application/json; charset=UTF-8',
                      headers: {
                        "token": userToKen
                      },
                      data: JSON.stringify(ajaxData),
                      async: false,
                      success: function(res) {
                        if (res.status == '200') {

                          var tdata = res.msg.data;

                          for (var ti = 0; ti < tdata.length; ti++) {
                            showData += "<option value='" + tdata[ti][dSourceName] + "'>" + tdata[ti][
                              dSourceName
                            ] + "</option>"
                          }

                        } else {}
                      }
                    })
                  }
                }
                showData += "</select>";
              }
              break;
            case "radios":
              //! 单选框
              var orderby = "inline-block"; // 排序方式
              data.orderby == 0 ? orderby = "block" : orderby = "inline-block";
              //console.log(data.orderby,data.style);
              showData = "";
              showData += "<div leipiplugins='" + data.leipiplugins + "' style='display: block'" + data.style +
                ";>";
              $.each(data.options, function(key, value) {
                if (value.checked != undefined) {
                  showData += "<label style='display:" + orderby + ";" + data.style +
                    "'><input type='radio' name='" +
                    value.name + "' value='" + value.value +
                    "' checked='checked'>" + value.value + "&nbsp;&nbsp;</label>";
                } else {
                  showData += "<label style='" + data.style + ";display:" + orderby +
                    ";'><input type=radio name=" +
                    value.name + " value='" + value.value +
                    "'>" + value.value + "&nbsp;&nbsp;</label>";
                }
              })
              showData += '</div>';
              break;
            case "checkboxs":
              //! 复选框
              var orderby = "inline-block"; // 排序方式
              data.orderby == "0" ? orderby = "block" : orderby = "inline-block";
              checkboxs++;
              showData = "";
              showData += "<div leipiplugins='" + data.leipiplugins + "' id='checkboxs" + checkboxs +
                "' style='display:block'>";
              $.each(data.options, function(key, value) {
                //nfgconsole.log(data.options.length);
                if (value.checked != undefined) {
                  showData += "<label style='" + data.style + ";" + "display:" + orderby +
                    "'><input style=' width:" + data.width +
                    ";height:" + data.height + "' type='" + value.type +
                    "' name='" +
                    value.name + "' value='" + value.value +
                    "' checked='checked' onchange='selectChange(event)'>" + value.value +
                    "&nbsp;&nbsp;</label>";
                } else {
                  showData += "<label style='" + data.style + ";" + "display:" + orderby + ";'><input type='" +
                    value.type +
                    "' name='" +
                    value.name + "' value='" + value.value +
                    "' onchange='selectChange(event)'>" + value.value + "&nbsp;&nbsp;</label>";
                }
              })
              showData += '<input type="hidden" name=' + data.name1 + ' types="checkboxs" value="" />'
              showData += '</div>';
              break;
            case "secondnav":
              //! 轮播控件
              showData = "";
              showData += "<div leipiplugins='" + data.leipiplugins + "' id='slidebox' style='display:block'>";
              break;
            case "macros":
              //! 宏控件
              var dataHide; // 隐藏属性
              data.orghide == 0 ? dataHide = "inline-block" : dataHide = "none";
              var orgType = data.orgtype, // 数据orgtype
                dataOrgType; // 属于哪种形式
              var d = new Date(); // 获取时间
              switch (orgType) {
                case "sys_datetime":
                  dataOrgType = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate() + "&nbsp;" + d.getHours() +
                    ":" + d.getMinutes() + "";
                  break;

                case "sys_date":
                  dataOrgType = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
                  break;

                case "sys_date_cn":
                  dataOrgType = d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日";
                  break;

                case "sys_date_cn_short1":
                  dataOrgType = d.getFullYear() + "年" + (d.getMonth() + 1) + "月";
                  break;

                case "sys_date_cn_short2":
                  dataOrgType = (d.getMonth() + 1) + "月" + d.getDate() + "日"
                  break;

                case "sys_date_cn_short3":
                  dataOrgType = d.getFullYear() + "年";
                  break;

                case "sys_date_cn_short4":
                  dataOrgType = d.getFullYear();
                  break;

                case "sys_time":
                  dataOrgType = d.getHours() + ":" + d.getMinutes()
                  break;

                case "sys_week":
                  switch (d.getDay()) {
                    case 1:
                      dataOrgType = "星期一";
                      break;
                    case 2:
                      dataOrgType = "星期二";
                      break;
                    case 3:
                      dataOrgType = "星期三";
                      break;
                    case 4:
                      dataOrgType = "星期四";
                      break;
                    case 5:
                      dataOrgType = "星期五";
                      break;
                    case 6:
                      dataOrgType = "星期六";
                      break;
                    default:
                      dataOrgType = "星期日"
                      break;
                  }
                  break;

                default:
                  dataOrgType = "出错啦~请重试..."
                  break;
              }

              data.orgfontsize ? data.orgfontsize : data.orgfontsize = "14px";
              if (datas[i].groupcon === null && source !== 'datatable') {
                showData = "<p leipiplugins='" + data.leipiplugins + "' groupCon='" + data.groupcon + "' name=" +
                  data.name +
                  ">" + dataOrgType + "</p>"
              } else {
                showData = "<input leipiplugins='" + data.leipiplugins + "' name=" + data.name + " type=" + data.type +
                  " title=" + data.title +
                  " value=" + dataOrgType + " style='display:" + dataHide + ";font-size:" + data.orgfontsize +
                  ";width:" + data.orgwidth + ";height:" + data.orgheight +
                  ";'>";
              }
              break;
            case "progressbar":
              //! 进度条
              if (source === 'datatable') {
                showData = "<input name='" + data.name + "' type='text'>";
              } else {
                showData = "<div leipiplugins='" + data.leipiplugins +
                  "' class='progress progress-striped'><div class='bar " + data.orgsigntype +
                  "' style='width:" + data.orgvalue + "%;" + data.style + ";'></div></div>"
              }
              break;
            case "qrcode":
              //! 二维码
              // !!!!!!!!!!!!!  目前只是个假的二维码 只有图片
              if (source === 'datatable') {
                showData = "<input name='" + data.name + "' type='text'>";
              } else {
                showData = "<img leipiplugins='" + data.leipiplugins + "' src='images/qrcode.gif' id=" + data.name +
                  " name=" + data.name + " style='width:" +
                  data.orgwidth + ";height:" + data.orgheight + ";'>";
              }
              break;
            case "listctrl":
              //! 列表控件
              var dataColtype = data.orgcoltype.split('`'), // 类型
                dataColtypeLen = dataColtype.length - 1, // 类型的长度
                dataColvalue = data.orgcolvalue.split('`'), // 默认值
                dataSum = data.orgsum.split('`'), // 合计数据
                dataTitle = data.orgtitle.split('`'), // 表头名称
                dataUnit = data.orgunit.split('`'), // 单位
                dataRowvalue = data.orgrowvalue.split('`'), // 追加的内容的数据
                sumDisplay = 'none', // 最后一行合计的显示
                dataSumvalue = data.orgsumvalue.split('`');
              $('#submitBtn').show(); // 列表控件的时候，将提交按钮显示出来。
              for (var j = 0; j < dataSum.length; j++) {
                if (dataSum[j] === '1') sumDisplay = 'table-footer-group';
              }
              dataRowvalue.pop(); // 把最后多的一个删除
              var dataAverValueLen = dataRowvalue.length / dataColtypeLen; // 用 默认值的长度 除 类型的长度，知道分了几组

              showData = "<table leipiplugins='" + data.leipiplugins + "' name=" + data.name + " id=" + data.name +
                " cellspacing='0' class='table table-bordered table-condensed' style='width:" + data.orgwidth +
                "'>";
              showData += "<thead><tr><th colspan=" + (dataColtypeLen + 1) + " style='text-align:left;'>" + data.title +
                "<span class='pull-right'><button class='btn btn-small btn-primary' type='button' onclick='tdAddRow(" +
                data.name + ", event)'>新增一行</button></span></th></td><tr>";
              // --------- 第一行标题
              for (var j = 0; j < dataColtypeLen; j++) {
                showData += "<th>" + dataTitle[j] + "</th>";
              }
              showData += "<th>操作</th>";
              showData += "</tr></thead><tbody class='template cContainer'><tr>";
              // --------- 第二行内容
              for (var j = 0; j < dataColtypeLen; j++) {
                if (dataColtype[j] == "text") {
                  showData += "<td><input class='input-medium' name='list0" + j + "' type=" + dataColtype[j] +
                    " value=" + dataColvalue[j] +
                    "> " + dataUnit[j] + "</td>"
                } else if (dataColtype[j] == "textarea") {
                  showData += "<td><textarea class='input-medium' name='list0" + j + "' type=" + dataColtype[j] +
                    ">" + dataColvalue[j] +
                    "</textarea> " + dataUnit[j] + "</td>"
                } else {
                  showData += "<td><input onchange='changeSum(event)' class='input-medium sum' name='list0" + j +
                    "' type='number' value=" +
                    dataColvalue[j] +
                    " > " +
                    dataUnit[j] +
                    "</td> ";
                }
              }
              showData += "<td></td></td></tbody>";
              // --------- 第二行追加的内容
              var tmpLen = 0;
              for (var j = 0; j < dataAverValueLen; j++) {
                var valueArr = dataRowvalue.slice(tmpLen, (tmpLen + dataColtypeLen));
                tmpLen = tmpLen + dataColtypeLen;
                showData += "<tbody class='cContainer add'><tr>";
                for (var k = 0; k < valueArr.length; k++) {
                  if (dataColtype[k] === 'text') {
                    showData += "<td><input class='input-medium' name='list" + (j + 1) +
                      k + "' type=" + dataColtype[k] + " value=" + valueArr[k] + "></td>";
                  } else {
                    showData += "<td><input onchange='changeSum(event)' class='input-medium sum' name='list" + (j +
                        1) +
                      k + "' type=" + dataColtype[k] + " value=" + valueArr[k] + "></td>";
                  }
                }
                showData += "<td><a href='javascript:;' onclick='tdDelRow(this)'>删除</a></td></tbody></tr>";
              }
              showData += "<tbody class='fContainer' style='display:" + sumDisplay + "'><tr>";

              // --------- 第三行合计
              for (var j = 0; j < (dataColtypeLen + 1); j++) {
                // if( dataSumvalue[ j ] !== null || dataSumvalue[ j ] !== '' ) sumValue = dataSumvalue[ j ];

                if (dataSum[j] == "1") {
                  var sumValue = dataColvalue[j];
                  // --------- 第三行合计的数量的赋值
                  if (dataSumvalue[j]) {
                    sumValue = dataSumvalue[j];
                  }

                  showData += "<td>合计：<input class='total' readonly='readonly' type='text' name='list" + j +
                    "total' class='input-small' value=" +
                    sumValue + "> " +
                    dataUnit[j] + "</td> "
                } else {
                  showData += "<td><input class='total' type='hidden' value=''></td>";
                }
              }
              showData += "</tr></tbody></table>";
              break;
            case "addimage":

              //! 图片上传
              if (isShow) {
                //showData=doFormListImg(idData.msg.data[data.name]);
                if (idData.msg.data != null) {
                  var style = '';
                  var htype = '';
                  var wtype = '';
                  if (data.orgpicheight != '' && data.orgpicheight != undefined && data.orgpicheight != 'auto') {
                    htype = data.sethtype == 0 ? 'px' : '%';
                    style += "height:" + data.orgpicheight + htype + ";";
                  }
                  if (data.orgpicwidth != '' && data.orgpicwidth != undefined && data.orgpicheight != 'auto') {
                    wtype = data.setwtype == 0 ? 'px' : '%';
                    style += "width:" + data.orgpicwidth + wtype + ";";
                  }
                  if (data.identity === '图片上传') {
                    showData = "<img src='" + idData.msg.data[data.name] + "' style='" + style + "'>";
                  } else if (data.identity === '视频上传') {
                    showData = "<video controls='controls' leipiplugins='" + data.leipiplugins + "' datasource='" +
                      data.datasource +
                      "' allowupload='" + data.allowupload + "' style='" + style + "' src=" +
                      idData.msg.data[data.name] + "></video>";
                  } else if (data.identity === '文件上传') {

                    var srcArray = idData.msg.data[data.name].split(";");
                    for (var l = 0; l < srcArray.length; l++) {
                      // alert("123")
                      // alert("第" + l + "个src=" + srcArray[l]);
                      // var fileurl = idData.msg.data[data.name];
                      var fileurl = srcArray[l];
                      var audioext = "mp3|wav|ogg|";
                      var FileExt = fileurl.substring(fileurl.lastIndexOf(".") + 1, fileurl.length);
                      if (audioext.indexOf(FileExt + "|") != -1) {
                        /* showData += '<audio src="' + fileurl + '" controls="controls">您的浏览器不支持 audio 标签</audio>'; */ //曾智宏注释，用于用户没有上传文件，就什么都不显示
                      } else {
                        showData += '<br><a href="' + fileurl + '">' + fileurl.substring(fileurl.lastIndexOf("/") +
                            1, fileurl.length) +
                          '</a>';
                      }
                    }

                  }
                }
              } else {
                // alert("这里是文件上传123");
                isSrc = true;
                isAddImageSrc = (data.identity);
                if (isAddImageSrc === '图片上传' || data.title === '图片上传') {
                  isSrcs += data.name + ",";
                }
                var setHWType = ["px", "%"];
                var htStr = '';
                if (idData) {
                  console.log(idData.msg.data[data.name]);
                  var fcontext = idData.msg.data[data.name];

                  if (fcontext) {

                    fcontext = fcontext.split(";");
                    /* 	function cenfile() {
                    		// var tC = $(e).attr('class');
                    		// $('.' + tC).remove();

                    	} */
                    var cou = 0;
                    for (var fc = 0; fc < fcontext.length; fc++) {
                      var fname = fcontext[fc].split("/");
                      fname = fname[fname.length - 1];

                      cou += 1;

                      htStr += '<a id="fname' + cou + '" href="' + fcontext[fc] + '">' + fname + '<\/a>';
                      htStr += '&nbsp&nbsp&nbsp<a value="' + fcontext[fc] + '" thisdataid="' + data.name +
                        '" tid="fname' + cou +
                        '" href="#" onclick="cenfile(this)">X<\/a><br\/>';
                    }

                  }
                }




                if (data.identity === '图片上传' || data.title === '图片上传') {
                  showData = "<div>" + htStr + "<input name=" + data.name + " id=" + data.name +
                    " type='hidden' class='image_val'><a leipiplugins='" + data.leipiplugins +
                    "' class='btn btn-primary btn-small uploadImage' data-toggle='modal'>" + data.title +
                    "</a>";
                  if (urlMethod == 'change') {
                    // alert("这里是preview_logic.js-1498")
                    var changeimgfile = idData['msg']['data'][data.name];
                    if (changeimgfile != '' && changeimgfile != undefined) {
                      showData += ' <img width=80 height=60 src="' + changeimgfile + '" />';
                    }
                  }
                  showData += '</div>';
                } else if (data.identity === '视频上传' || data.title === '视频上传') {
                  showData = "<div>" + htStr + "<input name=" + data.name + " id=" + data.name +
                    " type='hidden'><a leipiplugins='" + data.leipiplugins +
                    "' class='btn btn-primary btn-small uploadVideo' data-toggle='modal'>" + data.title +
                    "</a></div>";
                } else if (data.identity === '文件上传' || data.title === '文件上传') {
                  // alert("有来到这里吗？")
                  showData = "<div>" + htStr + "<input name=" + data.name + " id=" + data.name + " type='hidden'>" +
                    "<img src='../../images/2964c767d5798be6c8f83739fb5689b9.gif' width='30px' height='30px' style='display:none;'/><label class='btn btn-primary btn-small' for='uploadData' title=" +
                    data.title + ">" + data.title +
                    "<input leipiplugins='" + data.leipiplugins +
                    "' type='file' id='uploadData' style='display: none;' name='fileVideo'>" +
                    "</label></div>";

                }
              }

              /*  */
              break;
            case "pinglun":
              //评论
              showData = "<ul leipiplugins='" + data.leipiplugins + "' groupCon='" + nodeId + "' name='" + data.name +
                "'id='" + data.name + "'datasource='" + data.datasource + "'></ul>"
              break;
            case "iframerouter":
              //! 内嵌路由控件
              var nWidth = [];
              var nHeight = [];

              var nChecked = data.orgchecked.split('`'),
                nSrc = data.orgsrc.split('`'),
                nTarget = data.orgtarget.split('`'),
                nTitle = data.orgtitle.split('`');
              try {
                nWidth = data.orgwidth.split('`');
                nHeight = data.orgheight.split('`');
                nWidth.pop();
                nHeight.pop();
              } catch (e) {
                // window.close(); //关闭当前页面
              }

              // nLogin = data.orglogin.split( '`' );
              var routerPosition, // 路由位置
                defaultUrl = ''; // 默认选择的Urla
              nTitle.pop();
              nSrc.pop();
              nTarget.pop();
              nChecked.pop();

              // nLogin.pop();
              showData = '';
              for (var j = 0; j < nTitle.length; j++) {
                if (nChecked[j] === 'true') {
                  defaultUrl = nTarget[j];
                }
              }
              if (data.orderby === '0') routerPosition = 'bottom';
              else routerPosition = 'top';
              showData += "<div class='iframeRouterContainer " + routerPosition +
                "'><div class='top'><iframe allowfullscreen='true' allowtransparency='true' id='iframeRouter' src='" +
                defaultUrl + "'></iframe></div>";
              showData += "<div class='bottom' >";
              for (var j = 0; j < nTitle.length; j++) {
                var url = nTarget[j];
                // showData += "<div class='btnContainer' data-url='" + url + "' data-loginControl='" + nLogin[ j ] + "'><span>";
                if (nWidth.length < 1) {
                  showData += "<div class='btnContainer' data-url='" + url + "'><span>";
                } else {
                  showData += "<div style='width:" + nWidth[j] + ";height:" + nHeight[j] +
                    "' class='btnContainer' data-url='" +
                    url + "'><span>";
                }

                if (nSrc[j] !== '') {
                  showData += "<img src='" + nSrc[j] + "'></img>";
                }
                if (nChecked[j] === 'true') {
                  showData += "<p class='routerClick'>" + nTitle[j] + "</p></span></div>"
                } else {
                  showData += "<p>" + nTitle[j] + "</p></span></div>";
                }
              }
              showData += "</div></div>";
              break;
            case "reportcontrol":
              // alert("这里是reportcontrol");
              // 报表控件
              var parsingData, // 后台传入数据
                dataBody, // 表格内容
                dataHead, // 表头
                fieldsHead, // 列头
                columnsLength; // 列长
              if (source === 'ueditor') {
                var nodeId = window.opener.document.getElementById('node_id').value
                $.ajax({ // 这是获取模板。
                  url: prevent_HOST + 'pageDesignQueryFacade/getPageContent?id=' + nodeId,
                  type: 'GET',
                  dataType: 'json',
                  contentType: 'application/json; charset=UTF-8',
                  headers: {
                    "token": userToKen
                  },
                  async: false,
                  success: function(res) {
                    parsingData = res['msg'];
                  }
                })
              } else parsingData = parseData;


              for (var ze = 0; ze < parsingData.data.length; ze++) {
                if (parsingData.data[ze]['leipiplugins'] === 'reportcontrol') {
                  dataBody = parsingData.data[ze].data; /* alert("这里是dataBody="+dataBody); */
                  dataHead = parsingData.data[ze];
                }
              }



              switch (dataHead.visualreport) {
                case 'score':
                  break;
                case 'sourceResult':
                  break;
                default:
                  columnsLength = Object.keys(fieldsHead).length;
                  break;
              }



              var childrendata = [];
              $.ajax({
                url: prevent_HOST + 'nodeQueryFacade/getThisSlavePage?nodeId=' + dataHead.scoresourceid,

                async: false,
                success: function(res) {
                  //得到所有数据源的数据
                  childrendata = res.msg;

                }
              })


              //定义一个变量 存储即将查询的id
              var queryId = null;
              //定义一个变量  存储名字
              var sourceNames2 = null;
              if (window.sessionStorage.getItem('tempNid') != null) {
                queryId = JSON.parse(window.sessionStorage.getItem('tempNid')).nodeId;
                console.log("queryId===========" + queryId)
              }

              //延时加载数据源
              var mulsourcedataarray = [];
              setTimeout(function() {
                var nodeId = null;
                if (childrendata != null) {
                  console.log("进入方法了" + childrendata.length + "======" + JSON.stringify(childrendata));
                  console.log("data.scoreSourceIddata.scoreSourceIddata.scoreSourceId" + data.scoresourceid)
                  $("#lineChart0").before("<p id='proom' style='text-align: center'></p>")
                  for (var we = 0; we < childrendata.length; we++) {
                    var nodeName = childrendata[we].nodeName.split("n")[0];
                    mulsourcedataarray.push(childrendata[we]);

                    if (data.scoresourceid == "20246") {
                      $("#proom").append(
                        "<a class='scoreSourceStyle' style='background: rgb(255, 164, 152) none repeat scroll 0% 0%' href='javascript:void(0)'  onclick='scoreSourceCli(this)' thisnodeid='" +
                        childrendata[we].nodeId + "'><span font-color='white'>" + nodeName + "</span></a>")
                    }
                    if (we % 8 == 0 && we != 0) {
                      $("#proom").append("<br>")
                    }
                    var namesourcetemp = null;
                    namesourcetemp = childrendata[we].nodeId;
                    if (namesourcetemp == queryId) {
                      sourceNames2 = childrendata[we].nodeName;
                    }



                  }


                }




              }, 500);


              /* window.sessionStorage.setItem('myiframsrc',123);
              //iframe  用于显示数据
              $("#lineChart0").after(

                )
 */



              var inx;
              if (dataHead.visualreport === 'tableCommon' || dataHead.visualreport === 'tableCommones') {
                inx = 'bb';
                numTimes = false;
                showData =
                  "<table class='tableT' style='text-align:center;'>" +
                  // 表头
                  "<td class='titleT' style='font-weight:bold' colspan=" + columnsLength + ">" + dataHead.title +
                  "</td>" +
                  // 标题
                  "<tr class='menuT'>";
                // 标题数据
                for (var j = 0; j < columnsLength; j++) {
                  showData += "<th>" + fieldsHead[Object.keys(fieldsHead)[j]] + "</th>";
                }
                showData += "</tr>";
                // 表格内容数据
                for (var j = 0; j < dataBody.length; j++) {
                  var columns = Object.keys(dataBody[j]).filter(function(e) {
                    return e.indexOf("data") === 0;
                  })
                  showData += "<tr>"
                  for (var x = 0; x < columns.length; x++) {
                    var y = columns[x]
                    showData += "<td>" + dataBody[j][y] + "</td>"
                    // console.log( dataBody[ j ][ y ] )
                  }
                  showData += "</tr>"
                }
                showData += "</table>";
              } else {
                inx = 'tb';
                showData = '<div style="height:250px;width:100%;" id="lineChart' + i + '"></div>' +
                  '<script src="/editor/assets/ueditor/formdesign/self/echarts/echarts.min.js" defer="defer"></script>';
                /* var script = $('<script src="./self/echarts/echarts.min.js" defer="defer"></script>');
                $('body').append(script); */
                numTimes = true;
                elemId = 'lineChart';
                var legendData = [],
                  items, columnData = [],
                  sumArr = []
                // 图例数据
                // 							for (var j = 0; j < columnsLength; j++) {
                // 								legendData.push(fieldsHead[Object.keys(fieldsHead)[j]]); /* alert("这里是legendData="+legendData[j]); */
                // 							}
                // 							for (var j = 0; j < dataBody.length; j++) {
                // 								var columns = Object.keys(dataBody[j]).filter(function(e) {
                // 									return e.indexOf("data") === 0;
                // 								})
                // 							}
                // 							if (columns != undefined) {
                // 								alert("这里是columns=");
                // 								for (var j = 0; j < columns.length; j++) {
                // 									columnData[j] = [];
                // 									for (var k = 0; k < dataBody.length; k++) {
                // 										columnData[j].push(dataBody[k][columns[j]])
                // 									}
                // 								}
                // 							}


                showCharts = function() {
                  reportId.push('lineChart' + i); // 保存对应图表Id，以便有多个图表的时候重新渲染。
                  // alert(reportId);


                  var statisticsData = dataHead.data; //统计数据
                  var fieldArray = dataHead.field.split(";");
                  var statisticsTheme = fieldArray[0]; //统计主题
                  var statisticsNodeId = []; //统计数据源id
                  var statisticsNodeName = []; //统计数据源中文名
                  var statisticsFieldChineseName = []; //统计素材的中文（就是那些字段的中文名）

                  var tps;
                  if (dataHead.tps != undefined) {
                    var tps = dataHead.tps.split(";");
                  }

                  for (var s = 1; s < fieldArray.length; s++) {

                    var znode = fieldArray[s].split(",")[0]; //nodeId
                    var znodeName = fieldArray[s].split(",")[1]; //nodeName
                    var zfieldChineseName = fieldArray[s].split(",")[3]; //fieldChineseName

                    statisticsNodeId.push(znode);
                    statisticsNodeName.push(znodeName);
                    statisticsFieldChineseName.push(zfieldChineseName);

                  }

                  console.log(statisticsNodeId);
                  console.log(statisticsNodeName);
                  console.log(statisticsFieldChineseName);
                  console.log(statisticsData);

                  var lineOption = {
                    title: {
                      text: dataHead.title
                    },
                    tooltip: {},
                    legend: {
                      // data: ['销量']
                    },
                    series: []
                    /*
									title: {
										text: dataHead.title
									},
									tooltip: {
										trigger: 'axis'
									},
									legend: {
										// data: []
										// data: [ "多行文本框123", "多行文本框456" ]
									},
									grid: {
										left: '3%',
										right: '4%',
										bottom: '3%',
										containLabel: true
									},
									toolbox: {
										feature: {
											saveAsImage: {}
										},
										right: '4%'
									},
									xAxis: {
										show: true,
										type: 'category',
										// boundaryGap: false,
										data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
									},
									yAxis: {
										show: true,
										type: 'value'
									},
									series: []
								 */
                  };
                  // 折线图、柱状图
                  switch (dataHead.visualreport) {
                    case 'line':
                      var paramArray = {
                        name: statisticsTheme,
                        type: 'line',
                        data: statisticsData
                      }

                      var x = {
                        data: statisticsFieldChineseName
                      };
                      var y = {};
                      lineOption.xAxis = x;
                      lineOption.yAxis = y;
                      lineOption.series.push(paramArray);
                      break;

                    case 'bar':
                      var paramArray = {
                        name: statisticsTheme,
                        type: 'bar',
                        data: statisticsData
                      };
                      var x = {
                        data: statisticsFieldChineseName
                      };
                      var y = {};
                      lineOption.xAxis = x;
                      lineOption.yAxis = y;
                      lineOption.series.push(paramArray);
                      break;

                    case 'pie':
                      var paramArray = {
                        name: statisticsTheme,
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '50%'],
                        data: []
                      }


                      for (var t = 0; t < statisticsFieldChineseName.length; t++) {
                        var pData = {
                          value: statisticsData[t],
                          name: statisticsFieldChineseName[t]
                        }
                        paramArray.data.push(pData);
                      }




                      lineOption.series.push(paramArray);
                      break;
                    case 'score':
                      var paramArray = {
                        name: statisticsTheme,
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '50%'],
                        data: []
                      }

                      //查询当前数据源下，各级评分的人数。
                      if (queryId == null) {
                        queryId = "20272";
                      }
                      $.ajax({
                        //url: prevent_HOST + 'scoreFacade/getScoreResultAndRecordCount?nodeId=' + dataHead.scoresourceid,
                        url: prevent_HOST + 'scoreFacade/getScoreResultAndRecordCount?nodeId=' + queryId,

                        /* type: 'GET',
                        dataType: 'json',
                        contentType: 'application/json; charset=UTF-8',
                        data: JSON.stringify(param), */
                        async: false,
                        success: function(res) {
                          if (res.status == "200") {
                            /* paramArray.data = [{
                            	value: res.msg.lv1,
                            	name: '一' + tps[0] + tps[1],
                            	scoreResult: 1
                            }, {
                            	value: res.msg.lv2,
                            	name: '二' + tps[0] + tps[1],
                            	scoreResult: 2
                            }, {
                            	value: res.msg.lv3,
                            	name: '三' + tps[0] + tps[1],
                            	scoreResult: 3
                            }, {
                            	value: res.msg.lv4,
                            	name: '四' + tps[0] + tps[1],
                            	scoreResult: 4
                            }, {
                            	value: res.msg.lv5,
                            	name: '五' + tps[0] + tps[1],
                            	scoreResult: 5
                            }]; */
                            //根据需求，将0、1、2星级统称非星级
                            paramArray.data = [{
                              value: res.msg.lv0 + res.msg.lv1 + res.msg.lv2,
                              name: '非' + tps[0] + tps[1],
                              scoreResult: 0
                            }, {
                              value: res.msg.lv3,
                              name: '三' + tps[0] + tps[1],
                              scoreResult: 3
                            }, {
                              value: res.msg.lv4,
                              name: '四' + tps[0] + tps[1],
                              scoreResult: 4
                            }, {
                              value: res.msg.lv5,
                              name: '五' + tps[0] + tps[1],
                              scoreResult: 5
                            }];


                            lineOption.series.push(paramArray);
                          }
                        }
                      })



                      /* for (var t = 0; t < statisticsFieldChineseName.length; t++) {
                      	var pData = {
                      		value: statisticsData[t],
                      		name: statisticsFieldChineseName[t]
                      	}
                      	paramArray.data.push(pData);
                      }
                      lineOption.series.push(paramArray); */
                      break;


                    case 'sourceResult':
                      var statisticalmaterials = dataHead.statisticalmaterials;

                      statisticalmaterials = statisticalmaterials.replace(/&quot;/g, '"');
                      statisticalmaterials = JSON.parse(statisticalmaterials);


                      $.ajax({
                        url: prevent_HOST + 'scoreFacade/getCountsByStatisticalMaterials',
                        type: 'POST',
                        dataType: 'json',
                        contentType: 'application/json; charset=UTF-8',
                        data: JSON.stringify(statisticalmaterials),
                        async: false,
                        success: function(res) {
                          if (res.status == "200") {
                            var sm = res.msg;
                            var stitle = [];
                            var tdata = [];
                            var sourceNodeIds = [];
                            var sourceNames = [];
                            for (var z = 0; z < sm.length; z++) {
                              stitle.push(sm[z].statisticsTitle);

                              var dat = {
                                "value": sm[z].resultCount,
                                "sourceNodeIds": sm[z].sourceNodeIds,
                                "sourceNames": sm[z].sourceNames,
                                "titlefields": sm[z].titlefields,
                                "contextfields": sm[z].contextfields
                              }

                              tdata.push(dat);

                            }
                            var paramArray = {
                              name: statisticsTheme,
                              type: 'bar',
                              barWidth: 50,
                              data: tdata,
                              sourcenodeids: sourceNodeIds,
                              sourcenames: sourceNames
                            };

                            var x = {
                              data: stitle
                            };
                            var y = {};
                            lineOption.xAxis = x;
                            lineOption.yAxis = y;
                            lineOption.series.push(paramArray);
                          }
                        }
                      })

                      break;
                  }
                  reportData.push(lineOption); // 保存对应图表数据，以便有多个图表的时候重新渲染。

                  var myChart;
                  var listoneclass;
                  for (var k = 0; k < reportId.length; k++) {
                    // alert(reportId[k]);
                    myChart = echarts.init(document.getElementById(reportId[k]));



                    var oreport = $(document.getElementById(reportId[k]));
                    var showHt = '';
                    var listoneclass = Date.parse(new Date());
                    listoneclass = 'plu' + listoneclass / 1000 + Math.floor(Math.random() * 1000 + 1);
                    var isheader = "no";
                    var tpltype = 'type-five';
                    if (outborder == 'on') {
                      if (isheader == "yes" && tpltype == 'type-five') {
                        showHt += '<div class="listonetpl listone-list ' +
                          listoneclass +
                          ' outborder" style="border-style: hidden;"></div>';
                      } else if (isheader == "no" && tpltype == 'type-five') {
                        showHt += '<div class="listonetpl listone-list ' +
                          listoneclass +
                          ' outborder"></div>';
                      } else {
                        showHt += '<div class="listonetpl listone-list ' +
                          listoneclass +
                          ' outborder" style="padding:0px 20px 0px 20px;"></div>';
                      }
                    } else {
                      showHt += '<div class="listonetpl listone-list ' +
                        listoneclass +
                        '"></div>';
                    }
                    oreport.after(showHt);






                    // myChart.setOption(lineOption);
                    myChart.setOption(reportData[k]);
                  }


                  switch (dataHead.visualreport) {
                    case 'score':


                      var threeToFiveScoreIds2 = [];
                      var listoneclass = Date.parse(new Date());
                      listoneclass = 'plu' + listoneclass / 1000 + Math.floor(Math.random() * 1000 + 1);


                      showHt += '<div id ="listonetpl2" class="listonetpl listone-list ' + listoneclass +
                        '"></div>';
                      $("#lineChart0").after(showHt);
                      myChart.on('click', function(params) {
                          var content = $("#listonetpl2").html();
                          if (content != null && content.length != 0) {
                            $("#listonetpl2").empty();

                          }






                          var scoreResult = params.data.scoreResult;

                          /* var nodeId = dataHead.scoresourceid;
                           var toj = '/assets/ueditor/formdesign/preview.html?link=' +
                             tps[2] + '&nId=' + nodeId + '&sR=' + scoreResult;
                              console.log("scoreResult"+ scoreResult); */
                          var thisScoreIds2 = [];
                          $.ajax({
                            url: prevent_HOST + 'scoreFacade/getSelectIdByNodeIdAndscoreResult?nodeId=' +
                              queryId +
                              '&scoreResult=' + scoreResult,
                            // 本次链接是查询出某个星级的记录数
                            async: false,
                            success: function(res) {
                              if (res.status == '200' && res.msg.length != 0) {
                                thisScoreIds2 = res.msg;
                                /* for (var dff = 0; dff < res.msg.length; dff++) {
                                  var tempId = res.msg[dff];
                                  threeToFiveScoreIds2 = [];
                                  threeToFiveScoreIds2.push(tempId)
                                } */

                              }
                            }
                          })




                          /* var sourceNames = data.scoresourcename;
                           console.log("呜呜呜呜"+sourceNames) */
                          //var sourceNames = "测试多数据源发布标识控件";
                          //var titlefields = "wenbenkuang";
                          //var contextfields = "duoxingwenbenkuang";
                          var statistical = 'statistical';

                          var titlefields = "wenbenkuang";
                          var contextfields = "duoxingwenbenkuang";


                          /* 怡保 */


                          console.log("sourceNames2sourceNames2sourceNames2sourceNames2" + sourceNames2)
                          getListOne(queryId, sourceNames2, listoneclass, 1, 1000, "off",
                            titlefields,
                            titlefields, contextfields, "type-five", "0", "0",
                            "",
                            "",
                            "", "", "", "0", "0", "14px", null, null, 0,
                            '26px', "0",
                            "", "no", "", "", "null", "null", "hide", "customize", "",
                            "pagingstyle2",
                            "score", thisScoreIds2, null, null, null);

                        }

                        /*      var dept = window.sessionStorage.getItem('myiframsrc');
                                               if( dept != null){
                                                 console.log("xzvzzzzzzzzzzz"+dept)
                                                   $("#lineChart0").after(
                                                 "<iframe height='300px' width='100%' frameborder='0'src='"+ toj +"'></iframe>"
                                                    )

                                                }else{
                                                   window.location.href = toj;
                                                }
 */




                      );

                      break;
                    case 'sourceResult':
                      myChart.on('click', function(params) {
                        var ocla = $("." + listoneclass);
                        ocla.empty();
                        var data = params.data;

                        console.log(JSON.stringify(data));
                        var statistical = 'statistical';
                        var sourceNodeIds = data.sourceNodeIds;
                        console.log("idididi" + sourceNodeIds);
                        var sourceNames = data.sourceNames;
                        var titlefields = data.titlefields;
                        var contextfields = data.contextfields;

                        if (sourceNodeIds) {
                          for (var kd = 0; kd < sourceNodeIds.length; kd++) {
                            getListOne(sourceNodeIds[kd], sourceNames[kd], listoneclass, 1, 1000, "off",
                              titlefields[kd],
                              titlefields[kd], contextfields[kd], "type-five", "0", "0",
                              "",
                              "",
                              "", "", "", "0", "0", "14px", null, null, 0,
                              '26px', "0",
                              "", "no", "", "", "null", "null", "hide", "customize", "",
                              "pagingstyle2",
                              "score", null, null, statistical, null);
                          }

                          var count = $(".listone-list").length - 1;
                          console.log(count);

                          if (count <= 15) {

                          } else {
                            var olistClas = $('.listone-list');

                            olistClas.hide();
                            olistClas.each(function(i, n) {
                              if (i <= 15) {
                                $(n).show();
                              }
                            });

                            // var total = res.msg.count;
                            var pnumer = Math.ceil(count / parseInt(15));
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
                                pagecon +=
                                  '<li class="pagenum cur_page pagingcolor" onclick="jumpToPage(this)">' + i +
                                  '</li>';
                              } else {
                                pagecon += '<li class="pagenum" onclick="jumpToPage(this)">' + i + '</li>';
                              }

                            }

                            pagecon += '<li onclick="jumpToPage(this)" class="">下一页</li>';
                            //最后一页
                            pagecon += '<li onclick="jumpToPage(this)" class="">最后一页</li>';
                            pagecon += '</ul></div>';

                            ocla.append(pagecon);

                            $('.pagenum').each(function(i, n) {
                              if (pnumer >= 5) {
                                if (i >= 5) {
                                  $(n).hide();
                                }
                              }
                            });
                          }




                        }
                      });
                      break;
                  }
                }
              }
              break;
            case "button":
              var flexDirection;
              var tbtntype = '';
              var tgnode = '';
              var winname = '';
              try {
                if (data.btntype != '' && data.btntype != null && data.btntype != 'null') {
                  tbtntype = data.btntype;
                }
              } catch (e) {
                // window.close(); //关闭当前页面
              }
              try {
                if (data.tgnode != '' && data.tgnode != null && data.tgnode != 'null') {
                  tgnode = data.tgnode;
                }
              } catch (e) {
                // window.close(); //关闭当前页面
              }
              try {
                if (data.winname != '' && data.winname != null && data.winname != 'null') {
                  winname = data.winname;
                }
              } catch (e) {
                // window.close(); //关闭当前页面
              }
              if (tbtntype == '') {
                var url = '';
                /*if(data.orgurl!='' || data.orgurl!="null"){
                url=data.orgurl;
                if(url.indexOf("?")){
                    url+="&"+urlinfo;
                }else {
                    url+="?"+urlinfo;
                }
                }*/

                data.orderby === '1' ? flexDirection = 'column-reverse' : flexDirection = 'column';
                if (data.mode === '0') showData =
                  "<div id='buttonBtn' btntype='null' style='margin: 3px;border-radius: 3px;color:" + data.orgfontcolor +
                  ";";
                else showData = "<div id='buttonBtn' btntype='null' style='border-radius: 3px;color:" + data.orgfontcolor +
                  ";background:" + data.orgbgcolor +
                  ";";
                showData += "box-sizing:border-box;padding:3px;width:" + data.orgwidth + "; height:" + data.orgheight +
                  "; display:inline-block;" + data.style + "' name='leipiNewField' leipiplugins='button' orgname='" +
                  data.orgname + "' orderby='" + data.orderby + "' mode='" + data.mode + "' orgtitle='" + data.orgtitle +
                  "'";
                showData += "orgwidth='" + data.orgwidth + "' orgheight='" + data.orgheight + "' orgsrc='" + data.orgsrc +
                  "' orgurl='" + data.orgurl + "' tgnode='" + tgnode + "' winname='" + winname + "' ";
                showData += "orgwidth='" + data.orgwidth + "' orgheight='" + data.orgheight
                showData += "orgbgcolor='" + data.orgbgcolor + "' orgFontColor='" + data.orgfontcolor + "'>";
                showData += "<div id='" + data.orgid + "' style='display:flex;flex-direction:" + flexDirection +
                  "'>";
                if (data.mode === '0') showData +=
                  "<div style='width:100%;height:100%;text-align:center;'><img src='" +
                  data.orgsrc + "' style='width:auto;'></div>";
                showData +=
                  "<div style='display:inline-block;width:100%;height:100%;text-align:center;'><p style='font-size:1rem;margin-top:5px;'>" +
                  data.orgtitle + "</p></div>"
                showData += "</div></div>";
              } else {
                var btntype = data.btntype.split(",");
                var formnode = data.formnode.split(":");
                var orgurl = '';
                var tgurl = '';
                showData = "";
                for (var via = 0; via < btntype.length - 1; via++) {
                  orgurl = '';
                  var btntypeval = btntype[via].split(":");
                  if (btntypeval[0] == 'add') {
                    orgurl = '/editor/assets/ueditor/formdesign/preview.html?id=' + formnode[0] + '&name=' +
                      formnode[1] +
                      '&method=add&selectId=' + formnode[0] + "&btnname=" + btntypeval[1];

                  } else if (btntypeval[0] == 'list') {
                    //orgurl = '/form/#/home/'+formnode[0]+'/'+formnode[1];
                    orgurl = '/editor/assets/ueditor/formdesign/preview.html?link=' + formnode[0];
                  } else if (btntypeval[0] == 'frmedit') {
                    orgurl = '';
                  } else if (btntypeval[0] == 'frmsubmit') {
                    orgurl = '';
                    //showData += '<button type="submit" class="btn btn-success" id="submitBtn">'+btntypeval[ 1 ]+'</button>';
                  } else if (btntypeval[0] == 'edit') {
                    orgurl = '/editor/assets/ueditor/formdesign/preview.html?id=' + formnode[0] + '&name=' +
                      formnode[1] +
                      '&method=change&selectId=' + formnode[0];
                  } else if (btntypeval[0] == 'del') {} else if (btntypeval[0] == 'flow') {}

                  if (data.orgurl != '' && data.orgurl != 'null' && data.orgurl != null) {
                    tgurl = data.orgurl;
                  } else if (tgnode != '') {
                    var tgnodes = tgnode.split(":");
                    if (tgnodes[0] != '0')
                      tgurl = "/editor/assets/ueditor/formdesign/preview.html?link=" + tgnodes[0];
                  } else {
                    tgurl = '';
                  }
                  data.orderby === '1' ? flexDirection = 'column-reverse' : flexDirection = 'column';
                  if (data.mode === '0') showData += "<div id='buttonBtn' btntype='" + btntypeval[0] +
                    "' style='border-radius: 3px;cursor: pointer;margin: 3px;border-radius: 3px;color:" + data.orgfontcolor +
                    ";";
                  else showData += "<div id='buttonBtn' btntype='" + btntypeval[0] +
                    "' style='border-radius: 3px;cursor: pointer;margin: 3px;color:" + data.orgfontcolor +
                    ";background:" +
                    data
                    .orgbgcolor +
                    ";";
                  showData += "box-sizing:border-box;padding:3px;width:" + data.orgwidth + "; height:" + data.orgheight +
                    "; display:inline-block;" + data.style +
                    "' name='leipiNewField' leipiplugins='button' orgname='" +
                    data.orgname + "' orderby='" + data.orderby + "' mode='" + data.mode + "' orgtitle='" + data.orgtitle +
                    "'";
                  showData += "orgwidth='" + data.orgwidth + "' orgheight='" + data.orgheight + "' orgsrc='" + data
                    .orgsrc +
                    "' orgurl='" + orgurl + "' winname='" + winname + "' tgurl='" + tgurl + "' ";
                  showData += "orgbgcolor='" + data.orgbgcolor + "' orgFontColor='" + data.orgfontcolor + "'>";
                  showData += "<div style='display:flex;flex-direction:" + flexDirection + "'>";
                  if (data.mode === '0') showData +=
                    "<div style='width:100%;height:100%;text-align:center;'><img src='" +
                    data.orgsrc + "' style='width:60%;height:100%;'></div>";
                  showData +=
                    "<div style='display:inline-block;width:100%;height:100%;text-align:center;'><p style='font-size:1rem;margin-top:5px;'>" +
                    btntypeval[1] + "</p></div>"
                  showData += "</div></div>";

                }
              }
              break;
            case "buylabel":
              // 购买标签
              var tbtntype = data.mode;
              var bl_link = data.orgurl;
              var bl_style = "";

              // var selectId = '';
              if (bl_link == '' || bl_link == 'null') {
                var bl_sou = data.orgfurl;
                if (bl_sou != '' && bl_sou != 'unll') {
                  var bl_sous = bl_sou.split(":");
                  bl_link = '/editor/assets/ueditor/formdesign/preview.html?link=' + bl_sous[0] + '&name=' +
                    bl_sous[1] +
                    '&method=watch&selectId=' + selectId + '&fid=' + nodeId + '';
                }
              }
              if (data.orgwidth != '' && data.orgwidth != 'null') {
                bl_style += "width:" + data.orgwidth + ";";
              }
              if (data.orgheight != '' && data.orgheight != 'null') {
                bl_style += "height:" + data.orgheight + ";";
              }

              if (tbtntype == '0') {
                showData = '<a href="' + bl_link + '" class="buylabel_a"><img src="' + data.orgsrc + '" style="' +
                  bl_style +
                  '" /></a>';
              } else {
                if (data.orgbgcolor != '' && data.orgbgcolor != 'null') {
                  bl_style += "background-color:" + data.orgbgcolor + ";";
                }
                if (data.orgfontcolor != '' && data.orgfontcolor != 'null') {
                  bl_style += "color:" + data.orgfontcolor + ";";
                }
                if (data.orgfontsize != '' && data.orgfontsize != 'null') {
                  bl_style += "font-size:" + data.orgfontsize + ";";
                }
                showData = '<a href="' + bl_link + '" class="buylabel_a" style="' + bl_style + '">' + data.orgtitle +
                  '</a>';
              }
              break;
            case "exchange":
              // 兑换
              var tbtntype = data.mode;
              var bl_link = data.orgurl;
              var bl_style = "border-radius: 3px;";
              var style1 = "text-align:center";

              if (bl_link == '' || bl_link == 'null') {
                var bl_sou = data.orgfurl;
                if (bl_sou != '' && bl_sou != 'unll') {
                  var bl_sous = bl_sou.split(":");
                  bl_link = '/editor/assets/ueditor/formdesign/preview.html?id=' + bl_sous[0] + '&name=' + bl_sous[
                      1] +
                    '&method=watch&selectId=' + selectId + '&fid=' + nodeId + '';
                }
              }
              if (data.orgwidth != '' && data.orgwidth != 'null') {
                bl_style += "width:" + data.orgwidth + ";";
              }
              if (data.orgheight != '' && data.orgheight != 'null') {
                bl_style += "height:" + data.orgheight + ";line-height:" + data.orgheight + ";";
              }

              if (tbtntype == '0') {
                showData = '<div id="exchange_a" onclick="test()"><img src="' + data.orgsrc + '" style="' +
                  bl_style + '' +
                  style1 + '" /></div>';
              } else {
                if (data.orgbgcolor != '' && data.orgbgcolor != 'null') {
                  bl_style += "background-color:" + data.orgbgcolor + ";";
                }
                if (data.orgfontcolor != '' && data.orgfontcolor != 'null') {
                  bl_style += "color:" + data.orgfontcolor + ";";
                }
                if (data.orgfontsize != '' && data.orgfontsize != 'null') {
                  bl_style += "font-size:" + data.orgfontsize + ";";
                }
                showData = '<div id="exchange_a" onclick="test()" style="' + bl_style + '' + style1 + '">' + data.orgtitle +
                  '</div>';
              }
              break;
            case "scheduling":
              showData = "";
              var listoneclass = Date.parse(new Date());
              listoneclass = 'plu' + listoneclass / 1000 + Math.floor(Math.random() * 1000 + 1);
              showData = '<div class="biblock ' + listoneclass + '"></div>';
              if (data.tpl == 'span' || (data.datafield != '' && data.datafield != null)) {
                //var datafile = data.datafield.substr(1).split(",");
                var dSource = data.datasource.split(":");
                getScheduling(dSource[0], dSource[1], data.tpl, 1, data.pagesize, data.showpage, data.datafield,
                  data.headshow,
                  data.frmedit, data.frmdel, listoneclass, data.listpicw, data.listpich);
              }
              break;
            case "formlist":
              showData = "";
              var searchbyidorname = data.searchbyidorname;
              //需要查询的内容 文本框输入的 或者 id 或者 name
              if (searchbyidorname == 'byid') {
                data.seardelval = JSON.parse(window.localStorage.getItem("user")).id;
              }
              if (searchbyidorname == 'byname' && JSON.parse(window.localStorage.getItem("user")).chinaName != null) {
                data.seardelval = JSON.parse(window.localStorage.getItem("user")).chinaName;
              }
              /* if(searchbyidorname == 'byname' && JSON.parse(window.localStorage.getItem("user")).userName !=null ){
              	data.seardelval=JSON.parse(window.localStorage.getItem("user")).userName;
              } */
              console.log("searchByIdOrName=" + searchbyidorname);
              console.log("data.seardelval=" + data.seardelval);


              var searchlist = "searchlist";
              var listoneclass = Date.parse(new Date());
              listoneclass = 'plu' + listoneclass / 1000 + Math.floor(Math.random() * 1000 + 1);
              if (data.searchcon != 'null')
                showData = '<div class="biblock ' + searchlist + ' ' + listoneclass + '"></div>';

              if (data.tpl == 'span' || (data.datafield != '' && data.datafield != null)) {
                var dSource = data.datasource.split(":");
                var listlineheight = "26px";
                if (data.listheight != 'null') listlineheight = data.listheight;
                searchlists = {
                  "formNid": dSource[0],
                  "formName": dSource[1],
                  "formTpl": data.tpl,
                  "page": 1,
                  "pagesize": data.pagesize,
                  "showpage": data.showpage,
                  "datafields": data.datafield,
                  "headshow": data.headshow,
                  "frmedit": data.frmedit,
                  "frmdel": data.frmdel,
                  "cla": listoneclass,
                  "url": data.url,
                  "listpicw": data.listpicw,
                  "listpich": data.listpich,
                  "searchfile": data.searchcon,
                  "fsize": data.listfontsize,
                  "listlineheight": listlineheight,
                  "searchcon": null,
                  "personage_info": data.personage_info
                };
                console.log("login-search")
                if (data.searchcon != '' && data.searchcon != 'null' && data.seardelval != 'null' && data.seardelval !=
                  '') {
                  getFormList(dSource[0], dSource[1], data.tpl, 1, data.pagesize, data.showpage, data.datafield,
                    data.headshow,
                    data.frmedit, data.frmdel, data.frmexa, listoneclass, data.url, data.listpicw, data.listpich,
                    data.searchcon,
                    data.seardelval,
                    data.listfontsize, listlineheight, data.personage_info, data.theaderbackground);
                } else {
                  getFormList(dSource[0], dSource[1], data.tpl, 1, data.pagesize, data.showpage, data.datafield,
                    data.headshow,
                    data.frmedit, data.frmdel, data.frmexa, listoneclass, data.url, data.listpicw, data.listpich,
                    null, null,
                    data.listfontsize,
                    listlineheight, data.personage_info, data.theaderbackground);
                }
              }
              break;
            case "sort":
              // 分类控件
              showData = "<ul leipiplugins='" + data.leipiplugins + "' id='nodeTree' name='" + data.name +
                "' nodeId='" + data.nodeid + "' class='ztree'></ul>";
              showData +=
                "<div id='treeView' class='treeView'><iframe id='treeViewIframe' name='treeViewIframe' frameborder='0' src=''></iframe></div>"
              break;
            case "glc":
              curreditnode = data.nodeid;
              showData = "<div id=\"rtoptool\">\n" +
                "      <span class=\"rtoptooloff\" aria-label=\"Left Align\" id=\"rtoptooloff\">\n" +
                "        &rsaquo;\n" +
                "      </span>\n" +
                "      <span data-method=\"add\" class=\"gomethod\"><img class=\"btn-img\" src=\"./self/icon/add.png\">添加数据</span>\n" +
                "      <span data-method=\"list\" class=\"gomethod\"><img class=\"btn-img\" src=\"./self/icon/watch.png\">查看数据</span>\n" +
                "      <span data-method=\"del\" class=\"gomethod\"><img class=\"btn-img\" src=\"./self/icon/delete.png\">删除数据</span>\n" +
                "      <span data-method=\"edit\" class=\"gomethod\"><img class=\"btn-img\" src=\"./self/icon/change.png\">修改数据</span>\n" +
                "    </div>";
              break;
            case "mtpl":
            case "tpl":
              showData = "";
              break;
            case "daydate":
              if (isShow) {
                if (idData.msg.data != null) showData = idData.msg.data[data.name];
              } else {
                showData = '<input name="' + data.name + '" id="' + data.name + '" dateid="' + data.dateid +
                  '" placeholder="请输入日期" type="date" title="日期控件" class="date_input" leipiplugins="daydate" style="width:' +
                  data.orgwidth + ';height:' + data.orgheihgt + ';font-size:' + data.orgfontsize + '" />'
              }
              break;
            case "timedate":
              if (isShow) {
                if (idData.msg.data != null) showData = idData.msg.data[data.name];
              } else {
                showData = '<input name="' + data.name + '" id="' + data.name + '" dateid="' + data.dateid +
                  '" placeholder="请输入时间" type="time" title="时间控件" class="date_input" leipiplugins="timedate" style="width:' +
                  data.orgwidth + '; height:' + data.orgheight + ';font-size:' + data.orgfontsize + '" /> ~' +
                  '<input name="' + data.name + '" id="' + data.name + '" dateid="' + data.dateid +
                  '" placeholder="请输入时间" type="time" title="时间控件" class="date_input" leipiplugins="timedate" style="width:' +
                  data.orgwidth + '; height:' + data.orgheight + ';font-size:' + data.orgfontsize + '" />'
              }
              break;
            case "searchcontrol":
              $(function() {
                var searchCheck = [];
                searchCheck = $('#productSort').attr('orgchecked').split('`');
                for (var k = 0; k < searchCheck.length; k++) {
                  if (searchCheck[k] === "true") {
                    $($('#productSort').find('span')[k]).addClass('active');
                  }
                }
                $('.search-btn').attr('id', 'searchControl');
                if ($(".wifiblock") != undefined && source !== 'datatable') {
                  var wifiBlockElem = [],
                    wifiTemp;
                  for (var i = 0; i < $('.wifiblock').length; i++) {
                    wifiBlockElem.push($('.wifiblock')[i])
                  }
                  for (var s = 0; s < wifiBlockElem.length; s++) {
                    wifiTemp = $(wifiBlockElem[s]).find('[name^="data"]');
                  }
                  for (var j = 0; j < wifiTemp.length; j++) {
                    $(wifiTemp[j]).attr("searchID", getpluId())
                  }
                }

                function getpluId() { //时间戳生成唯一id var
                  timestamp = Date.parse(new Date());
                  timestamp = 'plu' + timestamp / 1000;
                  return timestamp;
                }
                console.log($('.wifiblock').find('[name^=data]'))
              })
              break;
            case "wxgrouptag":
              showData = '<input type="hidden" name="msgflag" value=' + data.msgflag + '>';
              break;
            case "wxlist":
              var wxurl = '';
              var fdata = '{"uId":' + gUser.id + ',"msgflag":' + data.msgflag + '}';
              var wxsendtype = data.wxsendtype;
              showData = '<div class="wx_msglist_' + wxsendtype + '">没有通知</div>';
              getWxList(data.wxsendtype, fdata);
              break;
            case "listone":
              // alert("这里是Preview_logic.js")
              var listoneclass = Date.parse(new Date());
              listoneclass = 'plu' + listoneclass / 1000 + Math.floor(Math.random() * 1000 + 1);
              var bottomline = '';
              var tpltype = data.tpl;
              var tsize = data.titlesize;
              var csize = data.consize;
              var fontsize = data.fontsize;
              var titlelabel = data.titlelabel,
                conlabel = data.conlabel;
              var frmedit = data.frmedit,
                frmdel = data.frmdel;
              var searchcon = data.searchcon;
              var seardelval = data.seardelval;
              var picfontsize = data.picfontsize;
              var listheight = data.listheight;
              var isnotuser = data.isnotuser;

              //曾智宏
              var prefix = data.prefix;
              var isheader = data.isheader;
              var headertitle = data.headertitle;
              var moreurl = data.moreurl;
              var headercolor = data.headercolor;
              var titlecolor = data.titlecolor;
              var iscomment = data.iscomment;
              var outborder = data.outborder;
              var prefixcolor = data.prefixcolor;
              var headimgsrc = data.headimgsrc;
              var headstyle = data.headstyle;
              var pagingstyle = data.pagingstyle;
              var isscore = data.isscore;
              var onlyShowOne = data.onlyshowone;

              var multisource = data.multisource;
              var multititles = data.multititles; //标题
              var multisourcenames = data.multisourcenames; //数据源名字
              var multinodeids = data.multinodeids; //数据源nodeId

              var multidatapics = data.multidatapics;
              var multidatatitles = data.multidatatitles;
              var multidatacontents = data.multidatacontents;
              var multititlesizes = data.multititlesizes;
              var multiconsizes = data.multiconsizes;
              var multititlelabels = data.multititlelabels;
              var multiconlabels = data.multiconlabels;
              var multifontsizes = data.multifontsizes;
              var multilistpicws = data.multilistpicws;
              var multilistpichs = data.multilistpichs;
              var multilisturls = data.multilisturls;
              var multisearchcons = data.multisearchcons;
              var multiseardelvals = data.multiseardelvals;
              var multipicfontsizes = data.multipicfontsizes;
              var multilistheights = data.multilistheights;
              var multirowsourcecount = data.multirowsourcecount;
              var tempNum = parseInt(multirowsourcecount);
              var typesevenurl = data.typesevenurl;
              var typesevendate = data.typesevendate;
              var statistical;


              // var thisScoreIds = thisScoreIds
              console.log(thisScoreIds)
              console.log("选中的类型" + tpltype)


              if (prefixcolor == undefined || prefixcolor == '' || prefixcolor == 'null') prefixcolor = "c1";


              if (prefix == undefined || prefix == '' || prefix == 'noneShape' || prefix == 'null') prefix = '';
              if (prefix != undefined && prefix != '' && prefix != 'noneShape' && prefix != 'null') prefix = prefix +
                prefixcolor;
              if (isheader == undefined || isheader == '') isheader = 'no';
              if (headertitle == undefined || headertitle == '') headertitle = '头部栏标题';
              if (moreurl == undefined || moreurl == '') moreurl = 'www.jd.com';
              if (headercolor == undefined || headercolor == '') headercolor = '#ffffff';
              if (titlecolor == undefined || titlecolor == '') titlecolor = '#000000';
              if (iscomment == undefined || iscomment == '') iscomment = 'hide';
              if (isscore == undefined || isscore == '') isscore = 'noscore';
              if (outborder == undefined || outborder == '') outborder = 'off';
              if (headstyle == undefined || headstyle == '' || headstyle == 'null') headstyle = 'customize';
              if (headimgsrc == undefined || headimgsrc == '' || headimgsrc == 'null') headimgsrc = '';
              if (pagingstyle == undefined || pagingstyle == '' || pagingstyle == 'null' || pagingstyle ==
                "undefined")
                pagingstyle = 'pagingstyle1';
              // alert(pagingstyle);

              if (tpltype == undefined || tpltype == '') tpltype = 'type-one';
              if (tsize == undefined || tsize == '') tsize = 0;
              if (csize == undefined || csize == '') csize = 0;
              if (picfontsize == undefined || picfontsize == '') picfontsize = 0;
              if (listheight == undefined || listheight == '') listheight = "26px";
              if (fontsize == undefined || fontsize == '' || fontsize == 'null') fontsize = "";
              if (data.titlelabel == undefined || data.titlelabel == '' || data.titlelabel == 'null') titlelabel =
                "";
              if (data.conlabel == undefined || data.conlabel == '' || data.conlabel == 'null') conlabel = "";
              if (data.typesevendate == undefined || data.typesevendate == '' || data.typesevendate == 'null')
                typesevendate = "";
              if (frmedit == undefined || frmedit == '' || frmedit == 'null') frmedit = "0";
              if (frmdel == undefined || frmdel == '' || frmdel == 'null') frmdel = "0";
              if (searchcon == undefined || searchcon == '' || searchcon == 'null') searchcon = null;
              if (seardelval == undefined || seardelval == '' || seardelval == 'null') seardelval = null;
              if (data.bottomline == 'on') bottomline = 'listone-list-line';






              var listoneclasses = [];
              if (multisource == 'multisource') { //开启多数据源显示模式
                multititles = multititles.split(","); //标题
                multisourcenames = multisourcenames.split(","); //数据源名字
                multinodeids = multinodeids.split(","); //数据源nodeId

                multidatapics = multidatapics.split(',');
                multidatatitles = multidatatitles.split(',');
                multidatacontents = multidatacontents.split(',');
                multititlesizes = multititlesizes.split(',');
                multiconsizes = multiconsizes.split(',');
                multititlelabels = multititlelabels.split(',');
                multiconlabels = multiconlabels.split(',');
                multifontsizes = multifontsizes.split(',');
                multilistpicws = multilistpicws.split(',');
                multilistpichs = multilistpichs.split(',');
                multilisturls = multilisturls.split(',');
                multisearchcons = multisearchcons.split(',');
                multiseardelvals = multiseardelvals.split(',');
                multipicfontsizes = multipicfontsizes.split(',');
                multilistheights = multilistheights.split(',');



                var multititle;
                var multisourcename;
                var multinodeid;

                var multidatapic;
                var multidatatitle;
                var multidatacontent;
                var multititlesize;
                var multiconsize;
                var multititlelabel;
                var multiconlabel;
                var multifontsize;
                var multilistpicw;
                var multilistpich;
                var multilisturl;
                var multisearchcon;
                var multiseardelval;
                var multipicfontsize;
                var multilistheight;



                console.log(listoneclass);

                var count = 0;
                for (var mi = 0; mi < multinodeids.length; mi++) {
                  // var listoneclass2 = Date.parse(new Date());
                  // listoneclass2 = 'plu' + listoneclass2 / 1000 + Math.floor(Math.random() * 1000 + 1);
                  var listoneclass2 = "plu" + _getRandomString(8);
                  listoneclasses.push(listoneclass2);

                  multititle = multititles[mi];
                  multisourcename = multisourcenames[mi];
                  multinodeid = multinodeids[mi];

                  multidatapic = multidatapics[mi];
                  multidatatitle = multidatatitles[mi];
                  multidatacontent = multidatacontents[mi];
                  multititlesize = multititlesizes[mi];
                  multiconsize = multiconsizes[mi];
                  multititlelabel = multititlelabels[mi];
                  multiconlabel = multiconlabels[mi];
                  multifontsize = multifontsizes[mi];
                  multilistpicw = multilistpicws[mi];
                  multilistpich = multilistpichs[mi];
                  multilisturl = multilisturls[mi];
                  multisearchcon = multisearchcons[mi];
                  multiseardelval = multiseardelvals[mi];
                  multipicfontsize = multipicfontsizes[mi];
                  multilistheight = multilistheights[mi];

                  if (data.multititlelabel == undefined || data.multititlelabel == '' || data.multititlelabel ==
                    'null')
                    multititlelabel = "";
                  if (data.multiconlabel == undefined || data.multiconlabel == '' || data.multiconlabel == 'null')
                    multiconlabel = "";
                  if (multipicfontsize == undefined || multipicfontsize == '') multipicfontsize = 0;
                  if (multifontsize == undefined || multifontsize == '' || multifontsize == 'null') multifontsize =
                    "";
                  if (multisearchcon == undefined || multisearchcon == '' || multisearchcon == 'null')
                    multisearchcon = null;
                  if (multiseardelval == undefined || multiseardelval == '' || multiseardelval == 'null')
                    multiseardelval =
                    null;
                  if (multilistheight == undefined || multilistheight == '') multilistheight = "26px";

                  if (onlyShowOne == 'noonlyShowOne') {
                    showData +=
                      '<a class="selectdatasource"' +
                      'onclick="getListOne(\'' + multinodeid + '\',\'' + multisourcename + '\',\'' + listoneclass2 +
                      '\',1,\'' +
                      data.pagesize +
                      '\',\'' + data.showpage + '\',\'' + multidatapic + '\',\'' + multidatatitle + '\',\'' +
                      multidatacontent + '\',\'' + tpltype + '\',\'' + multititlesize + '\',\'' + multiconsize +
                      '\',\'' + data.url +
                      '\',\'' +
                      multilistpicw +
                      '\',\'' + multilistpich + '\',\'' + multititlelabel + '\',\'' + multiconlabel + '\',\'' +
                      frmedit + '\',\'' + frmdel + '\',\'' + multifontsize + '\',' + multisearchcon + ',' +
                      multiseardelval +
                      ',' +
                      multipicfontsize +
                      ',\'' +
                      multilistheight + '\',\'' + isnotuser + '\',\'' +
                      prefix + '\',\'' + isheader + '\',\'' + headertitle + '\',\'' + moreurl + '\',\'' +
                      headercolor + '\',\'' +
                      titlecolor +
                      '\',\'' + iscomment + '\',\'' + headstyle + '\',\' ' + headimgsrc + '\',\'' +
                      pagingstyle + '\',\'' + isscore + '\',\'' + thisScoreIds + '\',\'' + multisource + '\',\'' +
                      statistical +
                      '\',\'' + threeToFiveScoreIds + '\',\'' + typesevenurl + '\',\'' + data.datacontent2 +
                      '\',\'' + typesevendate + '\')' +
                      '" title="' + multisourcename + '" value="' + multinodeid +
                      '" href="javascript:void(0);"><span id="">' +
                      multititle +
                      '</span></a>';

                    if (tempNum == mi + 1) {
                      showData += '<br>';
                      tempNum = parseInt(tempNum) + parseInt(multirowsourcecount);
                    }

                  }


                }
              }






              var showOneId = _getRandomString(5);
              if (listoneclasses.length > 0) {
                var onlyShowOneOutborder = '';
                console.log(onlyShowOne)
                if (onlyShowOne == 'onlyShowOne' && outborder == 'on') {
                  outborder = 'off';
                  onlyShowOneOutborder = "outborder";
                }
                showData += '<div id="' + showOneId + '" class="' + onlyShowOneOutborder + '">';

                for (var lc = 0; lc < listoneclasses.length; lc++) {
                  if (lc == data.pagesize && onlyShowOne == 'onlyShowOne') {
                    break;
                  }

                  if (outborder == 'on') {
                    if (isheader == "yes" && tpltype == 'type-five') {
                      showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                        listoneclasses[lc] +
                        ' outborder" style="border-style: hidden;display: none;"></div>';
                    } else if (isheader == "no" && tpltype == 'type-five') {
                      showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                        listoneclasses[lc] +
                        ' outborder" style="display: none;"></div>';
                    } else {
                      showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                        listoneclasses[lc] +
                        ' outborder" style="padding:0px 20px 0px 20px;display: none;"></div>';
                    }
                  } else {
                    showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                      listoneclasses[lc] +
                      '" style="display: none;"></div>';
                  }
                }


                // setTimeout(function() { //延时加载数据源第一条数据
                for (var me = 0; me < multinodeids.length; me++) {
                  if (me == multinodeids.length - 1) {
                    if (onlyShowOne == 'onlyShowOne') {
                      getListOne(multinodeids[me], multisourcenames[me], listoneclasses[me], 1, "1", "off",
                        multidatapics[me],
                        multidatatitles[me],
                        multidatacontents[me], tpltype, multititlesizes[me], multiconsizes[me], data.url,
                        multilistpicws[me], multilistpichs[me], multititlelabels[me], multiconlabels[me],
                        frmedit, frmdel, multifontsizes[me], multisearchcons[me] == "" ? null :
                        multisearchcons[me], multiseardelvals[me] == "" ? null : multiseardelvals[me],
                        multipicfontsizes[me],
                        multilistheights[me], isnotuser,
                        prefix, "no", headertitle, moreurl, "null",
                        "null", "hide", "customize", "",
                        "pagingstyle2", "noscore", thisScoreIds, "nomultisource", statistical,
                        threeToFiveScoreIds, typesevenurl, data.datacontent2, typesevendate);
                      count += 1;
                    }
                    break;
                  }
                  if (onlyShowOne == 'onlyShowOne' && me <= data.pagesize - 1) {
                    if (me == data.pagesize) {
                      break;
                    }

                    getListOne(multinodeids[me], multisourcenames[me], listoneclasses[me], 1, "1", "off",
                      multidatapics[me],
                      multidatatitles[me],
                      multidatacontents[me], tpltype, multititlesizes[me], multiconsizes[me], data.url,
                      multilistpicws[me], multilistpichs[me], multititlelabels[me], multiconlabels[me],
                      frmedit, frmdel, multifontsizes[me], multisearchcons[me] == "" ? null : multisearchcons[
                        me], multiseardelvals[me] == "" ? null : multiseardelvals[me],
                      multipicfontsizes[me],
                      multilistheights[me], isnotuser,
                      prefix, me == 0 ? "yes" : "no", headertitle, moreurl, me == 0 ? headercolor : "null",
                      me == 0 ? titlecolor : "null", "hide", "customize", headimgsrc,
                      "pagingstyle2", "noscore", thisScoreIds, "nomultisource", statistical,
                      threeToFiveScoreIds, typesevenurl, data.datacontent2, typesevendate);
                    count += 1;
                  }
                }
                // }, 800)


                listoneclasses = [];






                if (onlyShowOne == 'onlyShowOne' && data.showpage == 'on') {
                  setTimeout(function() {
                    var oonlyShowOneArea = $('#' + showOneId);
                    var count = $(".listone-list").length;
                    console.log(count);
                    if (count <= 15) {} else {
                      var olistClas = $('.listone-list');

                      olistClas.hide();
                      olistClas.each(function(i, n) {
                        if (i <= 15) {
                          $(n).show();
                        }
                      });

                      // var total = res.msg.count;
                      var pnumer = Math.ceil(count / parseInt(15));
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

                      oonlyShowOneArea.append(pagecon);

                      $('.pagenum').each(function(i, n) {
                        if (pnumer >= 5) {
                          if (i >= 5) {
                            $(n).hide();
                          }
                        }
                      });
                    }
                  }, 3000)
                }




                showData += '</div>';

              } else {

                if (outborder == 'on') {
                  if (isheader == "yes" && tpltype == 'type-five') {
                    showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                      listoneclass +
                      ' outborder" style="border-style: hidden;"></div>';
                  } else if (isheader == "no" && tpltype == 'type-five') {
                    showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                      listoneclass +
                      ' outborder"></div>';
                  } else {
                    showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                      listoneclass +
                      ' outborder" style="padding:0px 20px 0px 20px;"></div>';
                  }
                } else {
                  showData += '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' +
                    listoneclass +
                    '"></div>';
                }
              }


              /* showData = '<div class="listonetpl listone-list' + data.colnumber + ' ' + bottomline + ' ' + listoneclass +
              								'"></div>'; */ //这是原版

              var nodeinfo = data.datasource.split(":");
              searchlists = {
                "nid": nodeinfo[0],
                "name": nodeinfo[1],
                "cla": listoneclass,
                "page": 1,
                "pagesize": data.pagesize,
                "showpage": data.showpage,
                "pic": data.datapic,
                "ctitle": data.datatitle,
                "con": data.datacontent,
                "con2": data.datacontent2,
                "tpl": tpltype,
                "tsize": tsize,
                "csize": csize,
                "listurl": data.url,
                "listpicw": data.listpicw,
                "listpich": data.listpich,
                "titlelabel": titlelabel,
                "conlabel": conlabel,
                "typesevendate": typesevendate,
                "frmedit": frmedit,
                "frmdel": frmdel,
                "fontsize": fontsize,
                "searchfile": searchcon,
                "searchcon": seardelval,
                "picfontsize": picfontsize,
                "listheight": listheight
              };
              getListOne(nodeinfo[0], nodeinfo[1], listoneclass, 1, data.pagesize, data.showpage, data.datapic,
                data.datatitle,
                data.datacontent, tpltype, tsize, csize, data.url, data.listpicw, data.listpich, titlelabel,
                conlabel,
                frmedit, frmdel, fontsize, searchcon, seardelval, picfontsize, listheight, isnotuser,
                prefix, isheader, headertitle, moreurl, headercolor, titlecolor, iscomment, headstyle, headimgsrc,
                pagingstyle, isscore, thisScoreIds, "nomultisource", statistical, threeToFiveScoreIds,
                typesevenurl, data.datacontent2, typesevendate);




              break;
            case "getuserid":
              showData = "<input value='" + gUser.id + "' style='display:none;" + data.style + "' name='" + data.name +
                "' type='text'>";
              break;
            case "classify":
              showData = '';
              if (data.classtype == "class") {
                var classifytypec = Date.parse(new Date());
                classifytypec = 'plu' + classifytypec / 1000 + Math.floor(Math.random() * 1000 + 1);
                showData = '<div class="classifytypec" id="' + classifytypec + '"></div>';
                doClassifyClass(data.nid, classifytypec, data.datafiled);
              } else if (!isShow && data.classtype == "relation") {
                if (data.nid == '0') {
                  showData = "<select name='" + data.name + "' id='classify_" + data.cid +
                    "' class='myclassselect'><option value=''>----请选择----</option></select>";
                } else {
                  $.ajax({
                    url: prevent_HOST + 'pageDesignQueryFacade/getclassifyByParentId?pid=' + data.nid,
                    type: 'GET',
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8',
                    headers: {
                      "token": userToKen
                    },
                    async: false,
                    success: function(res) {
                      if (res.status == '200') {
                        var tagdata = res.msg;
                        if (data.sonid == '') {
                          showData = "<select name='" + data.name + "' id='classify_" + data.cid +
                            "' class='myclassselect'><option value=''>----请选择----</option>";
                        } else {
                          showData = "<select name='" + data.name + "' class='myclassselect' id='classify_" +
                            data.cid +
                            "' onchange=classifyClassChang(this.value,'" + data.sonid +
                            "')><option value=''>----请选择----</option>";
                        }
                        for (var i = 0; i < tagdata.length; i++) {
                          showData += "<option value='" + tagdata[i].id + "'>" + tagdata[i].name +
                            "</option>";
                        }
                        showData += "<\/select>";
                      } else {
                        showData += "数据更新中...";
                      }
                    }
                  })
                }
              } else if (data.classtype == "relation2") {
                if (data.nid == '0') {
                  showData = "<div data-name='" + data.datafiled + "' id='classify_" + data.cid +
                    "' class='mydivclassselect'><\/div>";
                } else {
                  $.ajax({
                    url: prevent_HOST + 'pageDesignQueryFacade/getclassifyByParentId?pid=' + data.nid,
                    type: 'GET',
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8',
                    headers: {
                      "token": userToKen
                    },
                    async: false,
                    success: function(res) {
                      if (res.status == '200') {
                        var tagdata = res.msg;
                        showData = "<div data-name='" + data.datafiled + "' id='classify_" + data.cid +
                          "' class='mydivclassselect' data-sonid='" + data.sonid + "'>";
                        for (var i = 0; i < tagdata.length; i++) {
                          showData += "<span class='srelation2' data-id='" + tagdata[i].id + "'>" + tagdata[i]
                            .name + "</span>";
                        }
                        showData += "<\/div>";
                      } else {
                        showData += "数据更新中...";
                      }
                    }
                  })
                }
              }
              break;
            case "settimeout":
              showData = '';
              break;
            case "reportline":
              showData = '';
              break;
            case "popup":
              showData = '';
              var tbtntype = data.mode;
              var bl_link = data.orgurl;
              var bl_style = "";
              if (bl_link == '' || bl_link == 'null') {
                var bl_sou = data.orgfurl;
                if (bl_sou != '' && bl_sou != 'unll') {
                  var bl_sous = bl_sou.split(":");
                  bl_link = '/editor/assets/ueditor/formdesign/preview.html?link=' + bl_sous[0];
                }
              }
              if (data.orgwidth != '' && data.orgwidth != 'null') {
                bl_style += "width:" + data.orgwidth + ";";
              }
              if (data.orgheight != '' && data.orgheight != 'null') {
                bl_style += "height:" + data.orgheight + ";";
              }
              if (tbtntype == '0') {
                showData = '<img onclick="doPopup(' + bl_link + ')" src="' + data.orgsrc + '" style="' + bl_style +
                  '" />';
              } else {
                if (data.orgbgcolor != '' && data.orgbgcolor != 'null') {
                  bl_style += "background-color:" + data.orgbgcolor + ";";
                }
                if (data.orgfontcolor != '' && data.orgfontcolor != 'null') {
                  bl_style += "color:" + data.orgfontcolor + ";";
                }
                if (data.orgfontsize != '' && data.orgfontsize != 'null') {
                  bl_style += "font-size:" + data.orgfontsize + ";";
                }
                showData = '<span  onclick="doPopup(\'' + bl_link + '\',\'' + data.orgtitle + '\')" style="' +
                  bl_style +
                  '">' +
                  data.orgtitle + '</span>';
              }
              break;
            case "recordlabel":
              showData = '';
              var rec_userid = null;
              if (gUser != null) rec_userid = gUser.id;
              var rec_title = '';
              var rec_nodename = '';
              if (currNode != undefined && currNode != null && currNode != '') rec_nodename = currNode.value;
              if (data.datatitle != '0') {
                if (idData !== undefined && idData['msg']['data'] != null) {
                  rec_title = idData['msg']['data'][data.datatitle];
                }
              }
              var recordData = {
                "nodeId": nodeId,
                "nodeName": rec_nodename,
                "title": rec_title,
                "selectId": selectId,
                "userId": rec_userid,
                "url": window.location.href,
              };
              $.ajax({
                url: DEFAULT_JOBURL + 'htUserService/insertUserInfo',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                // headers:{"token":userToKen},
                async: true,
                data: JSON.stringify(recordData),
                success: function(res) {
                  if (res.status == '200') {
                    currRecord = res.msg.id;
                  }
                }
              })
              break;
            case "officeEntrance":
              showData = '';
              break;
            case "lunbo":
              showData = '';
              var pluId = getPLid();
              var nodeinfo = data.datasource.split(":");
              var pagesize = data.limtvalue;
              if (nodeinfo.length > 1) {
                showData = '<div id="' + pluId +
                  '" style="position:relative;display:inline-block;margin:0 auto;width:' +
                  data
                  .orgwidth + ';height:' + data.orgheight + ';"></div>' +
                  '<script src="/editor/assets/ueditor/formdesign/self/swiper/swiper-4.2.2.min.js"></script>';
                var ajaxData = {
                  "node_id": nodeinfo[0],
                  "classname": nodeinfo[1],
                  "page": 1,
                  "pagesize": pagesize,
                  "orderby": "desc",
                  "method": "getQueryPage"
                };
                setLunBo(pluId, ajaxData, data);
              }

              // $('head').append('<link rel="stylesheet" href="./self/swiper/swiper-4.2.2.min.css">')

              /* var script = $('<script src="./self/swiper/swiper-4.2.2.min.js" defer="defer"></script>');
						$('body').append(script);
 */
              break;
            case "addnumber":
              // 报名标签
              var tbtntype = data.mode;
              var bl_style = "padding:2px 10px;border-radius:3px;cursor: pointer;";

              if (data.orgwidth != '' && data.orgwidth != 'null') {
                bl_style += "width:" + data.orgwidth + ";";
              }
              if (data.orgheight != '' && data.orgheight != 'null') {
                bl_style += "height:" + data.orgheight + ";";
              }

              if (tbtntype == '0') {
                showData = '<img src="' + data.orgsrc + '" style="' + bl_style + '" onclick="doAddNumber(\'' + data
                  .datasource +
                  '\',\'' + data.datafiled + '\',\'' + data.addvalue + '\',\'' + selectId + '\')" />';
              } else {
                if (data.orgbgcolor != '' && data.orgbgcolor != 'null') {
                  bl_style += "background-color:" + data.orgbgcolor + ";";
                }
                if (data.orgfontcolor != '' && data.orgfontcolor != 'null') {
                  bl_style += "color:" + data.orgfontcolor + ";";
                }
                if (data.orgfontsize != '' && data.orgfontsize != 'null') {
                  bl_style += "font-size:" + data.orgfontsize + ";";
                }
                showData = '<span style="' + bl_style + '" onclick="doAddNumber(\'' + data.datasource + '\',\'' +
                  data.datafiled +
                  '\',\'' + data.addvalue + '\',\'' + selectId + '\')">' + data.orgtitle + '</span>';
              }
              break;
            case "login":
              // 登录标签
              var tbtntype = data.mode;
              var bl_style = "padding:2px 10px;border-radius:3px;cursor: pointer;";



              if (data.orgwidth != '' && data.orgwidth != 'null') {
                bl_style += "width:" + data.orgwidth + ";";
              }
              if (data.orgheight != '' && data.orgheight != 'null') {
                bl_style += "height:" + data.orgheight + ";";
              }

              if (tbtntype == '0') {
                /* showData = '<img src="' + data.orgsrc + '" style="' + bl_style + '" onclick="dologin(\'' + data.datasource +
                	'\',\'' + data.datafiled + '\',\'' + data.addvalue + '\',\'' + selectId + '\')">'; */
                showData = '<img src="' + data.orgsrc + '" style="' + bl_style + '" onclick="dologin()">';
              } else {
                if (data.orgbgcolor != '' && data.orgbgcolor != 'null') {
                  bl_style += "background-color:" + data.orgbgcolor + ";";
                }
                if (data.orgfontcolor != '' && data.orgfontcolor != 'null') {
                  bl_style += "color:" + data.orgfontcolor + ";";
                }
                if (data.orgfontsize != '' && data.orgfontsize != 'null') {
                  bl_style += "font-size:" + data.orgfontsize + ";";
                }
                /* 	showData = '<span style="' + bl_style + '" id="dl" toaccount="' + data.toaccount + '" onclick="dologin(\'' +
                		data.datasource + '\',\'' + data.datafiled +
                		'\',\'' + data.addvalue + '\',\'' + selectId + '\')">' + data.orgtitle + '</span>'; */
                // onclick="dologin(\''+data.datasource+'\',\''+data.datafiled+'\',\''+data.addvalue+'\',\''+selectId+'\')"
                showData = '<span style="' + bl_style + '" id="dl" toaccount="' + data.toaccount +
                  '" onclick="dologin()">' +
                  data.orgtitle + '</span>';
              }
              break;
            case "liannanzugong":
              // 连南组工
              var tbtntype = data.mode;
              var bl_style = "position:absolute;bottom:105px;left:180px;";



              if (data.orgwidth != '' && data.orgwidth != 'null') {
                bl_style += "width:" + data.orgwidth + ";";
              }
              if (data.orgheight != '' && data.orgheight != 'null') {
                bl_style += "height:" + data.orgheight + ";";
              }

              if (tbtntype == '0') {
                showData = '<img src="' + data.orgsrc + '" style="' + bl_style + '" onclick="liannan(\'' + data.datasource +
                  '\',\'' + data.datafiled + '\',\'' + data.addvalue + '\',\'' + selectId + '\')">';
              } else {
                if (data.orgbgcolor != '' && data.orgbgcolor != 'null') {
                  bl_style += "background-color:" + data.orgbgcolor + ";";
                }
                if (data.orgfontcolor != '' && data.orgfontcolor != 'null') {
                  bl_style += "color:" + data.orgfontcolor + ";";
                }
                if (data.orgfontsize != '' && data.orgfontsize != 'null') {
                  bl_style += "font-size:" + data.orgfontsize + ";";
                }
                showData = '<div style="' + bl_style + '" onclick="liannan(\'' + data.datasource + '\',\'' + data.datafiled +
                  '\',\'' + data.addvalue + '\',\'' + selectId + '\')">' + data.orgtitle + '</div>';

              }
              break;
            case "background":
              //背景控件
              var bagcolor = data.bagcolor;
              var bagpic = data.bagpic;
              var bagstyle = "<style>body{";
              if (bagcolor != '') bagstyle += "background-color: " + bagcolor + ";";
              if (bagpic != '') {
                bagstyle += "background:url(" + bagpic +
                  ") no-repeat center top;-webkit-background-origin:content-box;background-origin:content-box;";
              }
              bagstyle += "}</style>";
              showData = bagstyle;
              break;
            case "export":
              //导出Excel
              var bgcolor = data.bgcolor;
              var fontcolor = data.fontcolor;
              var fontsize = data.fontsize;
              var pluwidth = data.pluwidth;
              var pluheight = data.pluheight;
              var exstyle = "<style>body{";
              showData = "<span onclick='domExcel(\"" + data.datasource + "\",\"" + data.datafield +
                "\")' style='text-align: center;line-height: " + pluheight +
                ";cursor: pointer;display: inline-block;width: " +
                pluwidth + ";height: " + pluheight + ";background-color: " + bgcolor + ";color: " + fontcolor +
                ";font-size: " +
                fontsize + ";'>" + data.title + "</span>";
              break;
            case "internal":
              //  积分兑换记录
              var fontsize = data.fontsize;
              var pluheight = data.pluheight;
              var itgdata = {
                "userid": gUser.id
              }; //604测试
              $.ajax({
                url: DEFAULT_JOBURL + 'integralService/getIntergralList?userid=' + gUser.id,
                method: "GET",
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                // headers:{"token":userToKen},
                async: false,
                success: function(res) {
                  if (res.status == '200') {
                    showData = '';
                    var style = "padding:3px;height:" + pluheight + ";line-height:" + pluheight +
                      ";font-size:" + fontsize +
                      ";";
                    var intest = '';
                    showData += "<table class='integrallist'>";
                    showData +=
                      "<tr><th style='padding:3px;'>ID</th><th style='padding:3px;'>产品图</th><th style='padding:3px;'>商品</th><th style='padding:3px;'>数量</th><th style='padding:3px;'>兑换积分</th><th style='padding:3px;'>时间</th><th style='padding:3px;'>状态</th></tr>";
                    $.each(res.msg, function(index, value) {
                      intest = value.status == 1 ? "成功" : "失败";
                      showData += "<tr>";
                      showData += "<td style='" + style + "'>" + value.itemId + "</td>";
                      showData += "<td align='center' style='" + style + "'><a href='" + value.url + "'>" +
                        doFormListImgWH(
                          value.picPath, "60px", "36px") + "</a></td>";
                      showData += "<td style='" + style + "'><a href='" + value.url + "'>" + value.title +
                        "</a></td>";
                      showData += "<td style='" + style + "'><a href='" + value.url + "'>" + value.num +
                        "</a></td>";
                      showData += "<td style='" + style + "'><a href='" + value.url + "'>" + value.totalIntegral +
                        "</a></td>";
                      showData += "<td style='" + style + "'><a href='" + value.url + "'>" + frmDateTime(
                          value.exchangetime) +
                        "</a></td>";
                      showData += "<td style='" + style + "'><a href='" + value.url + "'>" + intest +
                        "</a></td>";
                      showData += "</tr>";
                    })
                    showData += "</table>";
                  }
                }
              })
              break;
            case "shenpi":
              //审批列表控件
              var fontsize = data.fontsize;
              var pluheight = data.pluheight;
              var datasource = data.datasource;
              var datafiled = data.datafiled;
              var spstate = data.spstate;
              var spdbox = data.spdbox;
              var spdel = data.spdel;
              var requ = '';
              var spdelbtn = '';
              var spurl = prevent_HOST + 'pageDesignQueryFacade/selectFormRecordByNodeId';
              // if (spstate == '完成' || spstate == '未完成') {
              //     requ = 'userstate=' + spstate;
              // } else if (spstate == '通过' || spstate == '催办') {
              //     requ = 'state=' + spstate;
              // }
              if (spdbox == '1' && datasource != '0' && datasource != 'null' && datafiled != '0' && datafiled !=
                'null') {
                var datasources = datasource.split(":");
                window.spajaxData = {
                  "nodeId": datasources[0],
                  "classname": datasources[1],
                  "page": 1,
                  "pageSize": 999,
                  "table_field_all": null,
                  "searchContent": null,
                  "orderby": "desc"
                };
                $.ajax({
                  url: prevent_HOST + 'pageDesignQueryFacade/selectFormRecordByNodeId',
                  type: 'POST',
                  dataType: 'json',
                  contentType: 'application/json; charset=UTF-8',
                  async: false,
                  data: JSON.stringify(window.spajaxData),
                  success: function(res) {
                    if (res.status == '200') {
                      showData = '<div class="spdrop_down_box"><select onchange="spChang(' + datasources[0] +
                        ',\'' +
                        datasources[1] + '\',\'' + datafiled + '\',\'' + spstate + '\',this.value,\'' +
                        pluheight + '\',\'' +
                        fontsize + '\',\'' + spdel + '\')"><option value="0">全部</option>';
                      for (var spi = 0; spi < res.msg.data.length; spi++) {
                        showData += '<option value=' + res.msg.data[spi].id + '>' + res.msg.data[spi][
                          datafiled
                        ] + '</option>';
                      }
                      showData += '</select></div>';
                    }
                  }
                });
              }
              // if (requ != '') {
              //     spurl += '?' + requ;
              // }

              $.ajax({
                url: spurl,
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                async: false,
                data: JSON.stringify(window.spajaxData),
                success: function(res) {
                  if (res.status == '200') {
                    var style = "height:" + pluheight + ";line-height:" + pluheight + ";font-size:" +
                      fontsize + ";";
                    showData += "<div class='shenpicontent'>";
                    $.each(res.msg.data, function(index, value) {

                      showData += "<div class='shenpilist' style='" + style + "'>";
                      showData += "<div>" + value[res.msg.selecteds[0]] + "</div>";
                      showData += "<div>" + value[res.msg.selecteds[3]] + "</div>";
                      showData += "<div>" + value[res.msg.selecteds[1]] + "</div>";
                      if (spdel == '1') {
                        spdelbtn = " <span id='shenpilist_cb" + value.id +
                          "' class='btn shenpilist_del' onclick='doDelShenPi(" + value.id + "," + window.spajaxData
                          .nodeId +
                          ")'>删除</span>"
                      }
                      if (value[res.msg.selecteds[6]] == "通过") {
                        showData += "<div><font style='color: #ff0000;'>通过</font>" + spdelbtn + "</div>";
                      } else if (value[res.msg.selecteds[6]] == "催办") {
                        showData +=
                          "<div><font style='color: #ff0000;'>已经催办</font> <span class='btn shenpilist_pass' onclick='setShenPi(" +
                          value.id + ",\"" + value[res.msg.selecteds[1]] + "\",\"通过\"," + index +
                          ")'>通过</span> <span class='btn shenpilist_cb' onclick='setShenPi(" + value.id +
                          ",\"" + value[res.msg
                            .selecteds[1]] + "\",\"催办\"," + index + ")'>催办</span>" + spdelbtn + "</div>";
                      } else {
                        showData += "<div><span class='btn shenpilist_pass' onclick='setShenPi(" + value.id +
                          ",\"" + value[
                            res.msg.selecteds[1]] + "\",\"通过\"," + index +
                          ")'>通过</span> <span class='btn shenpilist_cb' onclick='setShenPi(" + value.id +
                          ",\"" + value[res.msg
                            .selecteds[1]] + "\",\"催办\"," + index + ")'>催办</span>" + spdelbtn + "</div>";
                      }
                      showData += "</div>";

                    })
                    showData += "</div>";
                  }
                }
              })
              break;
            case "meetinglist":
              showData = "";
              var listclass = getPLid();
              showData = '<div class="biblock ' + listclass + '"></div>';
              if (data.tpl == 'span' || (data.datafield != '' && data.datafield != null)) {
                var dSource = data.datasource.split(":");
                var listlineheight = "26px";
                if (data.listheight != 'null') listlineheight = data.listheight;
                if (data.searchcon != '' && data.searchcon != 'null' && data.seardelval != 'null' && data.seardelval !=
                  '') {
                  getMeetingList(dSource[0], dSource[1], data.tpl, 1, data.pagesize, data.showpage, data.datafield,
                    data.headshow,
                    data.mtype, listclass, data.roomurl, data.listpicw, data.listpich, data.searchcon, data.seardelval,
                    data.listfontsize,
                    listlineheight, data.mtitle);
                } else {
                  getMeetingList(dSource[0], dSource[1], data.tpl, 1, data.pagesize, data.showpage, data.datafield,
                    data.headshow,
                    data.mtype, listclass, data.roomurl, data.listpicw, data.listpich, null, null, data.listfontsize,
                    listlineheight, data.mtitle);
                }
              }
              break;
            default:
              showData = "";
              break;
          }

          function parseShow(obj) {
            console.log(showData);
            return obj.replace('{' + fields[i] + '}', showData);
          }
          var parsen, // parse临时变量 i 为 0 1 时使用
            parsec; // 临时变量
          if (i == 0) {
            parsen = parseShow(parse);
            content.html(parsen);
          } else if (i == 1) {
            parsec = parseShow(parsen);
          } else {
            parsec = parseShow(parsec);
          }

          //曾智宏
          //如果已经循环到最后一个字段了，就开始
          // 				console.log("进入下循环之前parsec=" + parsec);
          // 				console.log("进入下循环之前parsen=" + parsen);
          // 				 if (i == fields.length - 1&&window.location.search !== "") {
          // 					 console.log(i);
          //
          // 					  // parsec = parsec+ '123';
          //
          // 					 parsec = parsec+ '<div id="commentControl">' +
          // 						'<section class="tent_info">' +
          // 						'<div class="col-md-12 col-sm-12 col-xl-12 textarea one">' +
          // 						'<textarea class="text_send" id="text_send"></textarea>' +
          // 						'<div class="col-md-12 col-sm-12 col-xl-12 btn btn_send">提交</div>' +
          // 						'</div>' +
          // 						'</section> ' +
          // 						'</div>';
          // 				}
          // 				console.log("进入下循环之后parsec=" + parsec);
          // 				console.log("进入下循环之后parsen=" + parsen);
          // console.log(fields.length - 1);
          content.html(parsec);
          // console.log(parsen);
          if (numTimes) showCharts();
          if (dataType == "textarea" && !isShow && data.orgrich == '1') {
            var textcurr = '';
            try {
              textcurr = idData.msg.data[data.name];
              if (textcurr) { //曾智宏，返回的图片地址出现问题
                textcurr = textcurr.replace(/:/g, '=');
                textcurr = textcurr.replace(/&quot;/g, '"');
              }
            } catch (e) {}
            createMtext(data.name, textcurr);
          }
          if (data.multisource == 'multisource') {
            $('.selectdatasource').parent().css('text-align', 'center');
            if (data.multirowsourcecount <= 4) {
              $('.selectdatasource').css('padding', '6px 45px 0px 45px');
              $('.selectdatasource').css('margin', '0px 10px 10px 10px');
              if (data.isheader == "no") {
                $('.listonetpl').addClass('tempMarginLeft150px')
              }

            } else {
              // $('.listonetpl').css('text-align', 'center');
              // $('.listonetpl').css('margin-left', '-470px')
            }
          } else {
            $('.listonetpl').css('text-align', '');
            $('.listonetpl').removeClass('tempMarginLeft150px')
          }



          $('body').ready(function() {
            if (data.iscolor == 2) {
              $('.selectdatasource').css('background', '#bec6ff');
              $(this).css('background', '#7e8dff');
            } else {
              $('.selectdatasource').css('background', '#ffa498');
              $(this).css('background', '#ff4a32');
            }
          })
          //用于多数据源查询，修改器样式
          $('body').on('click', '.selectdatasource', function() {
            console.log("dasfdasfdsafdsafdsa颜色" + data.iscolor)
            if (data.iscolor == 2) {
              $('.selectdatasource').css('background', '#bec6ff');
              $(this).css('background', '#7e8dff');
            } else {
              $('.selectdatasource').css('background', '#ffa498');
              $(this).css('background', '#ff4a32');
            }

          })


          setTimeout(function() {
            /*是否显示居中的字段*/
            var center = data.center;
            console.log("shifouxianshijuzhong=" + center);
            if (center == "1") {
              $(".formlist_table_td th").css("text-align", "center");
              $(".formlist_table_td td").css("text-align", "center");

            }
          }, 800)



          if ($('.container').width() < 450) { //如果当页面为手机页

            if (data.multirowsourcecount == "2" || tempc == "2") { //在手机端一行两个的
              tempc = multirowsourcecount;
              $('.selectdatasource').css({
                'height': '40px',
                'width': '185px',
                'margin': '0px 0px 10px 10px'
              });

              $('.selectdatasource').append('<span style="float:right;">></span>')


              $('.selectdatasource').each(function(i, n) {
                var clickFunStr = $(n).attr('onclick'); //获取点击函数
                var clickFunParamStr = clickFunStr.split('(')[1];
                $(n).attr('onclick', 'multiSourcePhoneCli(' + clickFunParamStr);
              })

            } else if (data.multirowsourcecount == "1" || tempc == "1") { //在手机端一行1个的
              tempc = multirowsourcecount;
              $('.selectdatasource').css({
                'height': '40px',
                'width': '380px',
                'margin': '0px 0px 10px 10px'
              });

              $('.selectdatasource').append('<span style="float:right;">></span>')


              $('.selectdatasource').each(function(i, n) {
                var clickFunStr = $(n).attr('onclick'); //获取点击函数
                var clickFunParamStr = clickFunStr.split('(')[1];
                $(n).attr('onclick', 'multiSourcePhoneCli(' + clickFunParamStr);
              })

            } else if (data.multirowsourcecount == "5" || tempc == "5") {
              tempc = multirowsourcecount;
              $('.selectdatasource').each(function(i, n) {
                var clickFunStr = $(n).attr('onclick'); //获取点击函数
                var clickFunParamStr = clickFunStr.split('(')[1];
                $(n).attr('onclick', 'multiSourcePhoneCli(' + clickFunParamStr);

                var a = $(n).find('span').html();
                var b = $(n).find('span').html().length;
                switch (b) {
                  case 2:
                    $(n).css({
                      'height': '50px',
                      'width': '65px'
                    });
                    break;
                  case 3:
                    $(n).css({
                      'height': '50px',
                      /*'width': '0px' ,*/
                      'padding-right': '8px',
                      'padding-left': '9px'
                    });
                    break;
                  case 4:
                    $(n).css({
                      'height': '50px',
                      /*  'width': '85px' */
                      'padding-right': '1px',
                      'padding-left': '0px'
                    });
                    break;
                }
              })

              var op = $('.selectdatasource').parent();
              op.find('br').remove();
              $('.selectdatasource').css({
                'text-align': 'center',
                'border-radius': '0px',
                'margin': '0px 0px 10px 10px'
              });


              $('.selectdatasource span').css({
                'position': 'relative',
                'top': '5px'

              })
            }

          }


          if (data.iscolor == 2 || tempIscolor == 2) {
            tempIscolor = data.iscolor;
            $('.selectdatasource').css('background', '#7fa0ff');
          } else {
            $('.selectdatasource').css('background', '#ffa498');
          }

        }

        $('body').on('click', 'a', function() {
          var thisHref = $(this).attr('href');
          console.log(thisHref);
          if (!thisHref) {
            return true;
          }
          if (thisHref.indexOf('/editor/') != -1) {
            return true;
          }
          if (thisHref.indexOf(window.location.host) != -1) {
            return true;
          }
          if (thisHref.indexOf('javascript') != -1 || thisHref.indexOf('javaScript') != -1) {
            return true;
          }
          if (thisHref.indexOf('#') != -1) {
            return true;
          }

          var webUrls = getAllWebUrl();
          console.log(webUrls)
          if (webUrls && webUrls.length > 0) {
            var isPass = 0;
            for (var i = 0; i < webUrls.length; i++) {
              var webUrl = webUrls[i].webUrl;
              if (thisHref.indexOf(webUrl) != -1) {
                isPass = 1;
              }
            }
            if (isPass == 0) {
              alert("该跳转链接不安全，已阻止");
              // window.location.href = "http://" + window.location.host + "/account";
              // window.location.href = window.location.href;
              // window.location.href = "http://192.168.0.213/account/";
              return false;
            }
          }
        })


        // 数据源 -- 热区
        $(document).ready(function() {
          if ($(".wifiblock") != undefined && source !== 'datatable') {
            var sqlDataLen = [], // 控件数据的长度
              sqlData = [], // 控件的数据
              wifiblock = $(".wifiblock").length,
              dataVal = [], // 储存该热区里面的控件的val
              dataField,
              nowNum = 0, // 防止重复循环同一个数值
              sqlMax, // 选择出数值最大的一个
              isDelete = false, // 判断是否已经删除原有的dom对象
              chooseNum = 0, // 要取的元素的下标，默认是0，当前一个热区循环3个后，就应该取第4个元素了
              chooseNumBak = 0; // 楼上的备份值
            var parseElem = $(parseData[nowDataSource]),
              wifiBlockElem = [];
            for (var k = 0; k < $('.wifiblock').length; k++) {
              wifiBlockElem.push($('.wifiblock')[k]);
            }
            for (var s = 0; s < wifiblock; s++) { // 循环有多少个热区
              if (s !== 0) chooseNum++; //
              chooseNumBak = chooseNum; // 防止第二次循环的时候被重新覆盖。
              var fieldLen = wifiBlockElem[s].innerHTML.match(/leipiplugins/ig).length; // 每一个热区有多少个控件

              var sqlDataTemp = $(wifiBlockElem[s]).find('[name^="data"]');
              for (var j = 0; j < sqlDataTemp.length; j++) {
                var dot = sqlDataTemp[0]['id'].split('data')[1];
                if (typeof sqlDataTemp[j] === 'object') sqlData.push(sqlDataTemp[j]);
              }
              var html = $(".wifiblock")[chooseNumBak].outerHTML;
              for (var j = 0; j < fieldLen; j++) {
                var num = $($('.wifiblock')[s]).find('[name^="data"]')[j].id.split('data')[1];
                //  if ( s === 0 ) {
                //      sqlDataLen.push( JSON.parse( datas[ j ].sqldata ).length )
                //  } else {
                //      sqlDataLen.push( JSON.parse( datas[ nowNum ].sqldata ).length )
                //  }
                sqlDataLen.push(JSON.parse(datas[num - 1].sqldata).length)

                sqlMax = sqlDataLen.sort(function(x, y) {
                  if (x > y) {
                    return -1;
                  } else {
                    return 1;
                  }
                })[0];
                nowNum++;
              };
              for (var j = 0; j < sqlData.length; j++) {
                for (k = 0; k < datas.length; k++) {
                  if (sqlData[j].id === datas[k].name) {
                    var val = JSON.parse(datas[k].sqldata);
                    dataVal.push(val);
                  }
                }
              }
              sqlDataLen = [];
              if (sqlMax === 0) sqlMax = 1;
              isDelete = false;
              for (var k = 0; k < sqlMax; k++) {
                $('.wifiblock')[chooseNum].after($(html).get(0));
                if (!isDelete) $('.wifiblock')[chooseNum].remove();
                isDelete = true;
                chooseNum = k + chooseNumBak;
              }

              //  往已有的控件循环添加数据
              for (var j = 0; j < dataVal.length; j++) {
                var dataValLen = dataVal[j].length;
                if (dataValLen !== 0) {
                  dataField = Object.keys(dataVal[j][0]);

                  for (var k = 0; k < dataValLen; k++) {
                    if (s === 0) {
                      if (j === 0 && k === 0) var elem = $('[name="data' + [dot] + '"]')[k]
                      else var elem = $('[name="data' + [j + parseInt(dot)] + '"]')[k];
                    } else {
                      if ($('.wifiblockBoxs') != undefined) {
                        var elem = $('[name="data' + [dot] + '"]')[k];
                      } else {
                        var elem = $('[name="data' + [lastFieldLen + 1] + '"]')[k];
                      }

                    }
                    var setDataVal = dataVal[j][k][dataField[0]];
                    var pinglunID = dataVal[j][k][dataField[1]];
                    // console.log( elem.tagName )
                    switch (elem.tagName) { // 判断是什么类型的，进行怎么样的赋值
                      case 'INPUT':
                        elem.value += setDataVal;
                        break;
                      case 'UL': //如果是UL，则是评论控件，根据总评论内容，进行单列评论循环
                        $(elem).attr('cid', pinglunID)
                        if (!!setDataVal) { //判断setDataVal中是否拥有值
                          //数组
                          var arr = JSON.parse(setDataVal);
                          //获取数组中的ID放入UL中，方便获取ID值
                          arr.forEach(function(item, array) {
                            //根据数组值进行循环渲染
                            $(elem).append('<li><span>' + item.username + '&nbsp;:&nbsp;</span>' + item.content +
                              '</li>')
                          })
                        }
                        break;
                      case 'IMG':
                        elem.src = setDataVal;
                        break;

                      default:
                        elem.innerHTML += setDataVal;
                        break;
                    }

                    // var wifiblockLinkId = $('.wifiblock')[k + chooseNumBak].getAttribute('orgurlid'),
                    //     wifiblockUrl = '/editor/assets/ueditor/formdesign/preview.html?link=' +
                    //     wifiblockLinkId + '&gid=' + dataVal[j][k]['id'];
                    var wifiblockLinkId = $('.wifiblock')[k + chooseNumBak].getAttribute('orgurlid'),
                      wifiblockUrl = '/editor/assets/ueditor/formdesign/preview.html?link=' +
                      wifiblockLinkId;
                    $('.wifiblock')[k + chooseNumBak].setAttribute('orgurl', wifiblockUrl);
                  }

                }
              }
              var lastFieldLen = fieldLen; // 保存上一个控件数量
              dataVal = []; // 重置存储值的数组，以免下一个循环错误
              sqlData = []; // 重置存储值的数组，以免下一个循环错误
            }

            // 为节点添加事件
            /* if ( parseData[ nowDataSource ].indexOf( 'wifiblockBox' ) datas[i].sqldata!== -1 ) {

            } */
          }
        })
        // 数据表修改功能 -- 把获取的值循环到表上
        $(document).ready(function() {
          if (idData !== undefined && idData['msg']['data'] != null) {
            //console.log( idData[ 'msg' ] )

            var newArr = [];
            newArr = Object.keys(JSON.parse(idData['msg']['selected']));
            $.each(newArr, function(index, value) { // 第一次循环。 循环 遍历 除了radio和checkboxs的 value 属性。
              var element = $('[name=' + value + ']');

              if (element.length === 1) {
                element.val(idData['msg']['data'][value]);
              } else if (element.length > 1) { // 处理 radios
                element.each(function(index, elem) { // 第二次循环。 循环 radio 中的属性。
                  if (idData['msg']['data'][value] === elem.value) elem.checked = true;
                })
              }

              if (element.attr('types') == 'checkboxs') { // 处理 checkboxs
                var parentDiv = element.parent()[0].id,
                  selectValue = element.val().split(',');

                $("#" + parentDiv + " label > input[type='checkbox']").each(function(index, value) {
                  $.each(selectValue, function(sIndex, sVallue) {
                    if (value.value == selectValue[sIndex]) value.checked = true;
                  })
                });
              }
            })
          }
        })
        // 热区关联跳转 -- gid 为 1 就 显示 1 的数据，这里是把数据循环上去
        $(document).ready(function() {
          if (source !== 'datatable') {
            for (var i = 0; i < fields.length; i++) {
              if (datas[i].sqldata !== "[]" && datas[i].sqldata != undefined) {
                var $target = $('#' + datas[i].name),
                  tagName = $target.prop('tagName'),
                  gfiled = JSON.parse(datas[i].datasource),
                  val;
                if (datas[i].sqldata) {
                  val = JSON.parse(datas[i].sqldata)[0][gfiled.field];
                }


                if (datas[i].writenickname == "1") {
                  continue;
                }



                // val = JSON.parse( datas[ i ].sqldata )[ 0 ][ 'data' + ( i + 1 ) ];
                switch (tagName) {
                  case 'INPUT':
                    $target.val(val);
                    break;
                  case 'IMG':
                    $target.prop('src', val);
                    break;
                  case 'TEXTAREA':
                    $target.html(val);
                    break;
                  case 'VIDEO':
                    $target.prop('src', val);
                    break;
                  default:
                    $target.html(val.split("\n").join("<br />"));
                    break;
                }
              }
            }
          }
        })
        // 图文控件DOM事件
        $(document).ready(function() {
          $('body').on('touchstart', '.seebtn', function(e) {
            e.stopPropagation(); // 阻止冒泡
            e.preventDefault()
            alert('已成功关注该用户');
          })
          // 转发功能
          $('body').on('touchstart', '.zhuanfa', function(e) {
            e.stopPropagation(); // 阻止冒泡
            e.preventDefault()
            alert('ic-zhuanfa');
          })
          // 点赞功能
          $('body').on('touchstart', '.dianzan', function(e) {
            e.stopPropagation(); // 阻止冒泡
            e.preventDefault()
            var color = $(this).css('color')
            if (color == 'rgb(255, 0, 0)') {
              this.style.color = 'rgb(54, 52, 52)'
            } else if (color == 'rgb(54, 52, 52)') {
              this.style.color = 'rgb(255, 0, 0)'
            }
          })
          // 评论功能
          var pinglunbox;
          $('body').on('click', '.pinglun', function(e) {
            e.stopPropagation(); // 阻止冒泡
            //                console.log($(window).scrollTop())
            //                console.log(window.innerHeight)
            //                var h = $(window).scrollTop()+window.innerHeight
            setTimeout(function() {
              var Wh = $(window).height()
              $('.inputKeys').css({
                'display': 'block',
                'top': Wh - 40 + 'px'
              })
            }, 500)
            pinglunbox = $(this).parent().next()
            $('.inputKeys input').focus()
            //                console.log(pinglunbox.children( 'ul' ).children())
          })
          $(document).click(function(e) {

            var name = e.target.className
            if ($('.inputKeys').css('bottom') == '2px' && name != 'inputKeys' && name != 'inputbox' && name !=
              'inputbtn' && name != 'txt') {
              $('.inputKeys').animate({
                'bottom': '-40px'
              })
            }
          })

          // 点击发表评论
          $('body').on('touchstart', '.inputbtn', function(e) {
            e.preventDefault()
            e.stopPropagation(); //阻止冒泡
            var txt = $('.inputKeys input').val() //表单值
            var user = JSON.parse(localStorage.getItem('user')) //用户名
            $('.inputKeys').css({})
            if (!user && !txt) {
              alert('亲输入回复内容')
            } else {
              var htm = '<li><span>' + user.username + '</span>&nbsp:&nbsp' + txt + '</li>'
              pinglunbox.children('ul').append(htm)
            }

            if (!pinglunbox.children('ul').attr('cid')) {
              var contentId = ''
            } else {
              var contentId = pinglunbox.children('ul').attr('cid')
            }
            ajaxData = {
              content: txt,
              contentId: contentId,
              field: pinglunbox.children('ul').attr('name'),
              userName: user.username,
              datasource: pinglunbox.children('ul').attr('datasource'),
              nodeId: nodeId
            }

            if (!!user && !!txt) {
              $.ajax({
                data: JSON.stringify(ajaxData),
                url: prevent_HOST + 'pageDesignOperatorFacade/insertComment',
                type: 'POST',
                contentType: 'application/json;chartset=UTF-8',
                headers: {
                  "token": userToKen
                },

                success: function(data) {
                  //console.log( data )
                }
              })
            } else {
              alert('发送失败')
            }
            $('.inputKeys input').val('');
          })
        })
        // 分类控件树形控件
        $(document).ready(function() {
          (function() {
            var YZM = document.getElementById('YZM');
            if (YZM) {
              YZM.innerHTML = '<span>' +
                '<input type="button" id="code" value="点我验证" class="btn-list-btn" onclick="createCode()">' +
                '</span>';
            }

          })()

          //修改用户名
          $("#buttonBtn").click(function() {
            var yonghuming = $("#yonghuming").val();
            var data = {
              "chinese_name": yonghuming,
              "uId": gUser.id,
            };
            $.ajax({
              type: "post",
              url: DEFAULT_JOBURL + 'htLoginService/updateUser',
              contentType: 'application/json; charset=UTF-8',
              async: true,
              dataType: 'json',
              data: JSON.stringify(data),
              success: function(data) {
                if (data.status == '200') {
                  alert(data.statusMsg);
                  window.location.href =
                    "http://xxt.kz38.cn/editor/assets/ueditor/formdesign/preview.html?link=16214";
                } else {
                  alert('修改失败');
                }
              }
            })
          });

          //修改密码
          $(".btn").click(function() {
            var oldpwd = $("#yuanshouji").val();
            var newpwd = $("#xinshouji").val();
            var shoujihao = $("#shoujihao").val();
            if (oldpwd == "") {
              alert('原密码为空!');
              return false;
            }
            if (newpwd == "") {
              alert('新密码为空!');
              return false;
            }
            if (shoujihao == "") {
              alert('手机号为空!');
              return false;
            }
            var data = {
              "uid": gUser.id,
              "oldPassword": oldpwd,
              "password": newpwd,
            };
            /* $.ajax({
            	type: "post",
            	url: DEFAULT_JOBURL + 'htLoginService/updateNewPwd',
            	contentType: 'application/json; charset=UTF-8',
            	async: true,
            	dataType: 'json',
            	data: JSON.stringify(data),
            	success: function(data) {
            		if (data.status == '200') {
            			alert(data.statusMsg);
            		} else if (data.status == '500') {
            			alert(data.statusMsg);
            		}
            	}
            }) */
          });

          if ($('#nodeTree').length !== 0) {

            // 与后台交互对接
            function treeMain(type, data) {
              $.ajax({
                url: prevent_HOST + 'pageDesignOperatorFacade/' + type,
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json;charset=UTF-8',
                headers: {
                  "token": userToKen
                },
                data: JSON.stringify(data),
                success: function(res) {
                  // console.log( res );
                }
              })
            }

            var setting = {
              view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
              },
              check: {
                enable: false
              },
              data: {
                simpleData: {
                  enable: true
                }
              },
              edit: {
                enable: true,
                renameTitle: '重命名',
                removeTitle: '删除'
              },
              callback: {
                beforeClick: function(treeId, treeNode) {
                  var zTree = $.fn.zTree.getZTreeObj("nodeTree");
                  $('#treeViewIframe').attr("src", treeNode.url);
                  return true;
                },
                beforeRename: function(treeId, treeNode, newName) {
                  var data = {
                    'id': treeNode.id,
                    'pid': treeNode.pId,
                    'name': newName,
                    'url': treeNode.url,
                    'nodeId': nodeId
                  };
                  treeMain('upSort', data);
                },
                beforeRemove: function(treeId, treeNode) {
                  $.ajax({
                    url: prevent_HOST + 'pageDesignOperatorFacade/delSort?id=' + treeNode.id,
                    type: 'GET',
                    headers: {
                      "token": userToKen
                    },
                    dataType: 'json',
                    success: function(res) {
                      // console.log( res );
                    }
                  })
                }
              }
            };
            var sortTreeNode;
            for (var i = 0; i < parseData.data.length; i++) {
              if (parseData.data[i].leipiplugins === 'sort') {
                sortTreeNode = parseData.data[i].children;
                sortTreeNode[0].isParent = true;
                sortTreeNode[0].open = true;
              }
            }

            $(document).ready(function() {
              $.fn.zTree.init($("#nodeTree"), setting, sortTreeNode);
            });

            var newCount = 1;
            var nodeId = window.location.search.split('=')[1].split('&')[0];

            function addHoverDom(treeId, treeNode) {
              var sObj = $("#" + treeNode.tId + "_span");
              if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0) return;
              // add
              var addStr = "<span class='button add' id='addBtn_" + treeNode.tId +
                "' title='添加节点' onfocus='this.blur();'></span>";
              sObj.after(addStr);
              var addBtn = $("#addBtn_" + treeNode.tId);
              if (addBtn) addBtn.bind("click", function() {
                var zTree = $.fn.zTree.getZTreeObj("nodeTree");
                var nodeName = prompt('输入节点名称', "new node" + (newCount++));
                var data = {
                  'pid': treeNode.id,
                  'name': nodeName,
                  'url': null,
                  'nodeId': nodeId
                };
                $.ajax({
                  url: prevent_HOST + 'pageDesignOperatorFacade/addSort',
                  type: 'POST',
                  dataType: 'json',
                  contentType: 'application/json;charset=UTF-8',
                  headers: {
                    "token": userToKen
                  },
                  data: JSON.stringify(data),
                  success: function(res) {
                    // console.log( res );
                    zTree.addNodes(treeNode, {
                      id: res.msg.id,
                      pId: treeNode.id,
                      name: nodeName
                    });
                  }
                })
                return false;
              });
              // addUrl
              var urlStr = "<span class='button url' id='addUrl_" + treeNode.tId +
                "' title='添加跳转链接' onfocus='this.blur();'></span>";
              sObj.after(urlStr);
              var addUrl = $("#addUrl_" + treeNode.tId);
              if (addUrl) addUrl.bind("click", function() {
                var url = prompt('输入您的跳转链接', '/editor/assets/ueditor/formdesign/preview.html?link=');
                treeNode.url = url;
                var data = {
                  'id': treeNode.id,
                  'pid': treeNode.pId,
                  'name': treeNode.name,
                  'url': url,
                  'nodeId': nodeId
                };
                treeMain('upSort', data);
                return false;
              });
            };

            function removeHoverDom(treeId, treeNode) {
              $("#addBtn_" + treeNode.tId).unbind().remove();
              $("#addUrl_" + treeNode.tId).unbind().remove();
            };
          }
        })


      } else {
        content.html(parse);

      }
      // 记录报告
      $(document).ready(function() {
        if (gUser != null) {
          if ($("#recordinfo")) {
            // $.ajax({
            // 	url: DEFAULT_JOBURL + 'htUserService/selectByIdInfo?userId=' + gUser.id,
            // 	type: 'GET',
            // 	dataType: 'json',
            // 	contentType: 'application/json; charset=UTF-8',
            // 	// headers:{"token":userToKen},
            // 	async: true,
            // 	success: function(res) {
            // 		var rechtml = '';
            // 		if (res.status == '200') {
            // 			var redlist = res.msg;
            // 			var title = '';
            // 			var xstime = 0;
            // 			for (var i = 0; i < redlist.length; i++) {
            // 				title = redlist[i].title;
            // 				if (title == '') title = redlist[i].nodeName;
            // 				rechtml += '<div class="reclist"><h1>主题：' + title + '</h1><ul><li> 学习时间：<span>' + redlist[i].totaltime +
            // 					'</span> 分</li><li>登录次数：<span>' + redlist[i].count +
            // 					'</span></li><li>考试成绩：<span>暂无</span></li></ul></div>';
            // 			}

            // 		}
            // 		$("#recordinfo").html(rechtml);
            // 	}
            // })
          }
        } else {
          if ($("#recordinfo")) $("#recordinfo").html('');
        }

        if (urlMethod == "watch") {
          $('.watch_remove').remove();
          $('.watch_100').css("width", "100%");
          if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
            $('.mobile_hide').remove();
          } else {
            $('.pc_hide').remove();
          }
        }
        if ($('.totalIntegral').length > 0) {
          $.ajax({
            url: DEFAULT_JOBURL + 'htMemberService/getMember?userid=' + gUser.id,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            // headers:{"token":userToKen},
            async: true,
            success: function(res) {
              var totalIntegral = '0';
              if (res.status == '200') {
                totalIntegral = res.msg.memberNumber;
              }
              $(".totalIntegral").html(totalIntegral);
            }
          })
        }
        $(document).on('click', '.srelation2', function() {
          $(this).siblings().removeClass("select-relation");
          $(this).addClass('select-relation');
          var selectname = $(this).parent().data('name');
          var sid = $(this).parent().data('sonid');
          var id = $(this).data('id');
          if (sid != '' && sid != 'null') {
            classifyRelationChang(id, sid);
          }
          if (searchlists != null)
            getListOne(searchlists.nid, searchlists.name, searchlists.cla, searchlists.page, searchlists.pagesize,
              searchlists.showpage, searchlists.pic, searchlists.ctitle, searchlists.con, searchlists.tpl,
              searchlists.tsize,
              searchlists.csize, searchlists.listurl, searchlists.listpicw, searchlists.listpich,
              searchlists.titlelabel,
              searchlists.conlabel, searchlists.frmedit, searchlists.frmdel, searchlists.fontsize,
              selectname, id,
              searchlists.picfontsize, searchlists.listheight);
        });
        if ($('.meetinglist').length > 0) {
          var meetinginfo = null;
          var lsg = window.localStorage.getItem('meeting');
          if (lsg != null && lsg != '') {
            meetinginfo = JSON.parse(lsg);
            console.log(meetinginfo);
            $.ajax({
              url: DEFAULT_JOBURL + 'chatService/selectChatRecord?chatid=' + meetinginfo.selectId,
              type: 'GET',
              dataType: 'json',
              contentType: 'application/json; charset=UTF-8',
              // headers:{"token":userToKen},
              async: true,
              success: function(res) {
                var meetinghtml = '';
                if (res.status == '200') {
                  var msgs = res.msg;
                  for (var mi = 0; mi < msgs.length; mi++) {
                    meetinghtml += '<div class="meetinglist-block">' +
                      '<div class="userinfo">' +
                      '<span>' + msgs[mi].name + '：</span>' +
                      '</div>' +
                      '<div class="user-chat">' +
                      '<p class="meeting-time">日期：' + frmDateTime(msgs[mi].createtime) + '</p>' +
                      '' + msgs[mi].content + '' +
                      '</div>' +
                      '</div>';
                  }
                }
                $(".meetinglist").html(meetinghtml);
              }
            })
          }
        }

      })
    }


  } catch (e) {
    console.log(e);
    alert("页面预览失败！请关闭页面并重新尝试预览！");
    // window.close(); //关闭当前页面
  }
  window.source = source;
  //isLogInState
  if (gUser != null && source != "ueditor") {
    $('.noIsLogInState').remove();
    $('#nologin').remove();
    $('#userName').html(gUser.userName);
    var userPos = gUser.posName.join(',');
    if (userPos == '') {
      userPos = "无";
    }
    $('#userPosition').html("职位：" + userPos);
    $('.isLogInState').show();
    if (gUser.user.isadmin == "1") {
      $('.isadmin').show();
    }
  } else {
    $('#islogin').remove();
    $('.isLogInState').remove();
    $('.noIsLogInState').show();
  }

});
/* var cenfile = */
function cenfile(e) {
  var tC = $(e).attr('tid');
  var thisdataid = $(e).attr('thisdataid');
  $(e).remove();
  $('#' + tC).remove();

  var thisdata = $('#' + thisdataid).attr("value");
  var srcs = thisdata.split(";");
  var newdatas = '';
  if (srcs) {
    for (var df = 0; df < srcs.length; df++) {
      if (srcs[df] != $(e).attr('value')) {
        newdatas += srcs[df] + ';';
      }
    }

    var newdata = newdatas.substr(0, newdatas.length - 1)

    $('#' + thisdataid).attr("value", newdata);
  }
}

function _getRandomString(len) { //生成随机数
  len = len || 32;
  var $chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678'; // 默认去掉了容易混淆的字符oOLl,9gq,Vv,Uu,I1
  var maxPos = $chars.length;
  var pwd = '';
  for (i = 0; i < len; i++) {
    pwd += $chars.charAt(Math.floor(Math.random() * maxPos));
  }
  return pwd;
}
