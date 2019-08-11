$(function() {

  // let iframe_exists = window.sessionStorage.getItem("iframe_exists");
  // if (iframe_exists == "true") { } else { loadFlowModal(); }

  // $(document).keydown(function (event) {
  //     if (event.keyCode == 116) {
  //         window.sessionStorage.setItem("iframe_exists", false)
  //         window.location.reload(true);
  //     }
  // });


  //控制文本显示
  $("input[value_2]").click(function() {
    if ($(this).val() != $(this).attr("value_2")) { //值不是value_2，显示value_2
      $(this).val($(this).attr("value_2"));
    } else {
      $(this).val($(this).attr("value"));
    }
  });
  $("textarea[value_2]").click(function() {
    if ($(this).val() != $(this).attr("value_2")) { //值不是value_2，显示value_2
      $(this).val($(this).attr("value_2"));
    } else {
      $(this).val($(this).attr("value"));
    }
  });
  /**
   * isLogin - 判断用户是否登录
   *
   * 是否登录依据：
   * 1. window.localstorage 是否存在 user 的字段
   *
   * @return String 返回用户的登录信息, 如果没登陆则返回 '' 空字符串
   */

  function isLogin() {
    var user;
    if (window.localStorage.getItem('user') !== null) {
      user = JSON.parse(window.localStorage.getItem('user'));
    } else user = '';

    return user;
  }

  /**
   * imgPlaceholder - 设置图像的占位符
   *
   * 判断依据：
   * 1. 看元素的子元素IMG的SRC是否为空, 为空就设置一个占位符图片
   *
   * @param String elem IMG元素的父元素. 是要 jQuery Dom 选择器的格式来传
   * 比如：  imgPlaceholder( '.contains.contains_img' );
   */
  function imgPlaceholder(elem) {
    if ($(elem).length !== 0) {
      var groupEl = $(elem);
      for (var i = 0; i < groupEl.length; i++) {
        if ($(groupEl[i]).find('img').attr('src') === '') {
          $(groupEl[i]).find('img').attr('src', './images/placeholder.jpg')
        }
      }
    }
  }

  /**
   * getNodeGid - 获取 NodeID 和 Gid
   *
   * @return Object 返回一个对象组合
   */
  function getNodeGid() {
    var info = {
      'nodeId': location.search.split('=')[1].split('&')[0],
      'gId': window.location.search.split('=')[2]
    };

    return info;
  }


  /*
   * iframeRouter - 内嵌路由控件
   *
   */
  $('.iframeRouterContainer .bottom').on('click', '.btnContainer', function(e) {
    var loginControl = e.currentTarget.dataset.logincontrol;
    $('.btnContainer p').removeClass('routerClick');
    $(e.currentTarget).find('p').addClass('routerClick');
    if (loginControl === '0') {
      if (window.localStorage.getItem('user') !== null) {
        $('#iframeRouter').attr('src', e.currentTarget.dataset.url);
      } else {
        $('#iframeRouter').attr('src', 'http://' + localhost + '/login2/');
      }
    } else {
      $('#iframeRouter').attr('src', e.currentTarget.dataset.url);
    }
  })

  /*
   * wifiblock
   * 点击热区进行跳转
   * 利用热区div的 orgurl 树形进行跳转
   *
   */
  $('body').on('click', '.wifiblock', function(e) {
    // e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    if ($(e.currentTarget).data('allowjump') !== false) {
      if (source !== "datatable") {
        var urlJump = e.currentTarget.getAttribute('orgJump'),
          orgUrl = e.currentTarget.getAttribute('orgurl');
        if (urlJump === 'parent') {
          window.parent.location.href = orgUrl;
        } else if (urlJump === 'top') {
          window.top.location.href = orgUrl;
        } else {
          window.location.href = orgUrl;
        }
      };
    }
  })



  $('body').on("click", "#getMsgUserInfo", function() {
    getJobTree();
    $('#getMsgUserInfoModal').modal('show');
  });

  $('body').on("click", "#getPowerJobInfo", function() {
    if (curRoleType == null) getJobTree();
    curRoleType = 'job';
    $("#openSwJob").show();
    $("#jobRoleUserWin").show();
    //$('#getMsgUserInfoModal').modal('show');
  });
  $('body').on("click", "#getPowerRoleInfo", function() {
    if (curRoleType == null) getJobTree();
    curRoleType = 'role';
    $("#openSwRole").show();
    $("#jobRoleUserWin").show();
  });
  $('body').on("click", "#wxCanlBtn", function() {
    $("#jobRoleUserWin .panel").hide();
    $("#jobRoleUserWin").hide();
  });
  $('body').on("click", "#getPowerRoleUserInfo", function() {
    if (curRoleType == null) getJobTree();
    curRoleType = 'user';
    $("#openSwRoleUser").show();
    $("#jobRoleUserWin").show();
  });
  $('body').on('click', '#wxCfrBtn', function() {
    var wxjobid = '';
    var wxjoblist = '';
    var wxroleid = '';
    var wxrolelist = '';
    var wxuserid = '';
    var wxuserlist = '';
    if (curRoleType == 'job') {
      var arr = manager.getChecked();
      for (var i = 0; i < arr.length; i++) {
        wxjobid += arr[i].data.id + ',';
        wxjoblist += "<span>" + arr[i].data.name + "</span>";
      }

      var pjob = $("[name='swPowerJob']");
      if (pjob.length > 0) {
        pjob.val(wxjobid);
      } else {
        $("#getPowerJobInfo").before("<input type='hidden' name='swPowerJob' value='" + wxjobid + "'>");
      }
      $('.swjoblist').html(wxjoblist);
    } else if (curRoleType == 'role') {
      $('.wxroleselect input[type="checkbox"]:checked').each(function() {
        wxroleid += $(this).val() + ',';
        wxrolelist += "<span>" + this.nextSibling.nodeValue + "</span>";
      });
      wxroleid = wxroleid.substring(0, wxroleid.length - 1);
      var prole = $("[name='swPowerRole']");
      if (prole.length > 0) {
        prole.val(wxroleid);
      } else {
        $("#getPowerRoleInfo").before("<input type='hidden' name='swPowerRole' value='" + wxroleid + "'>");
      }
      $('.swrolelist').html(wxrolelist);
    } else if (curRoleType == 'user') {
      $('.wxuserselect input[type="checkbox"]:checked').each(function() {
        wxuserid += $(this).val() + ',';
        wxuserlist += "<span>" + this.nextSibling.nodeValue + "</span>";
      });
      wxuserid = wxuserid.substring(0, wxuserid.length - 1);
      var pruser = $("[name='swPowerRoleUser']");
      if (pruser.length > 0) {
        pruser.val(wxuserid);
      } else {
        $("#getPowerRoleUserInfo").before("<input type='hidden' name='swPowerRoleUser' value='" + wxuserid +
          "'>");
      }
      $('.swroleuserlist').html(wxuserlist);
    }
    $("#jobRoleUserWin .panel").hide();
    $("#jobRoleUserWin").hide();
  });

  function getFromData() {

    $('.searchData').removeAttr('disabled');

    var record = $("#insertForm").serializeObject();
    record = doStrMarks(record);
    var gid = getQueryString('gid');
    var uid = null;
    var uname = null;
    try {
      uid = gUser.id;
      uname = gUser.username;
    } catch (error) {}
    if (gid) record.gid = gid; // 如果有关联的话 就添加 gid 字段
    record.node_id = currNode.id; // 数据表点击 修改 的时候要用的。
    delete record.leipiNewField; // 我也不知道为什么提交取值的时候会添加这个东西，貌似就是没用的，所以就把它删除了。
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
    //if (record.msgflag != undefined) {
    record.uId = uid;
    //}
    var data = {
      "record": record,
      "classname": currNode.value,
      "method": "insert",
      "user_account": uname
    }
    if (isSrc) data.src = isSrcs;
    data.record.isDelete = 0;
    return data;
  }
  $('body').on('click', '.frm-submit', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    var data = getFromData();
    if (urlMethod == 'watch') {

    } else if (urlMethod == 'change') {

      //
      //return false;

      data.method = "updateByPrimaryKeySelective";
      data.record.id = selectId; // 数据表点击 修改 的时候要用的。
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


    } else {



      //
      //return false;



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
          if (res['status'] == '200') {

            if ($('#scoreId')) {
              var scoreResult = $('#scoreId').attr('scoreResult');
              var selectId = res.msg;
              var nodeId = currNode.id;

              var param = {
                "nodeId": nodeId,
                "selectId": selectId,
                "scoreResult": scoreResult
              }
              var param2 = {
                "nodeId": nodeId,
                "selectId": selectId,
                "isApprove": "0"
              }
              saveScoreInfo(param);

              //保存关系
              $.ajax({
                url: prevent_HOST + 'approveInfoFacae/insertApproveInfo',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(param2),
                success: function(res) {
                  if (res.status == "200") {
                    console.log("保存关系成功")
                  }
                }
              })

              var schoolNoticeParam = {
                "title": "消息通知",
                "school": "测试",
                "notifier": "赵情森",
                "time": "2019-07-24",
                "content": "测试",
                "remark": "测试"
              }

              $.ajax({
                url: DEFAULT_JOBURL + 'htMsgPushService/schoolNotice',
                type: 'POST',
                dataType: 'json',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(schoolNoticeParam),
                success: function(res) {



                }
              })






            }



            alert('恭喜您！' + res['statusMsg']);
            window.location.reload();
          } else {
            alert('抱歉！插入单条数据失败，请重试');
          }
        }
      })
    }









  });


  //保存评分控件设置
  function saveScoreInfo(param) {
    /* {
    	"nodeId":"1078",
    	"selectId":"22",
    	"scoreResult":"4"
    }
     */
    $.ajax({
      url: prevent_HOST + 'scoreFacade/saveScoreInfo',
      type: 'POST',
      dataType: 'json',
      contentType: 'application/json; charset=UTF-8',
      data: JSON.stringify(param),
      success: function(res) {

        if (res.status == "200") {
          console.log("fdfdfdf")
        }


      }
    })

  }

  $('body').on('click', '.frm-edit', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    var data = getFromData();
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
  });

  $('body').on('click', '.frm-rest', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    $('#insertForm')[0].reset();
  });

  /*列表事件*/

  $('body').on('click', '.formlist-edit-btn', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    var link = $(this).data('link');
    window.location.href = link;
  });

  $('body').on('click', '.formlist-del-btn', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    if (!confirm("确定删除？")) return false;
    var me = $(this);
    var nid = $(this).data('nid');
    var name = $(this).data('name');
    var type = $(this).data('type');
    if (nid != '' && nid != undefined && name != '' && name != undefined) {
      var data = {
        "record": nid,
        "classname": name,
        "method": "updateDelete",
        "flag": 1
      };

      //
      //return false;

      $.ajax({
        url: prevent_HOST + 'pageDesignOperatorFacade/deleteFormRecord',
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json; charset=UTF-8',
        headers: {
          "token": userToKen
        },
        data: JSON.stringify(data),
        async: true,
        success: function(res) {
          if (res.status == '200') {
            switch (type) {
              case 'li':
                me.parent().remove();
                break;
              case 'table_td':
                me.parent().parent().remove();
                break;
              case 'table_vd':
                me.parent().parent().remove();
                break;
              case 'listone':
                me.parent().parent().remove();
                break;
            }
          }
        }
      })
    }
  });


  /*
   * 注册按钮
   * 登录后，注册和登录按钮不可点击
   * 没登录登录时，退出不可用
   *
   */
  if (JSON.parse(localStorage.getItem('user')) != null) {
    $("#buttonreg").css('display', 'none');
    $("#buttonLogin").css('display', 'none');
    $('.loginTxt').html(JSON.parse(localStorage.getItem('user')).username);
    $('.loginTxt').css('color', '#fff')
  }
  /*
   *
   * 点击注册
   *
   */
  $('body').on('click', '#buttonreg', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    if (source !== "datatable") {
      var orgUrl = e.currentTarget.getAttribute('orgurl');
      window.location.href = orgUrl;
    };
  })
  /*
   *点击退出登录
   *
   */
  $('body').on('click', '#exitLogin', function(e) {
    if (JSON.parse(localStorage.getItem('user')) != null) {
      localStorage.removeItem('user');
      $("#buttonreg").css('display', 'block');
      $("#buttonLogin").css('display', 'block');
      window.location.href = "/";
      //window.location.reload();
    }
  })
  /*
   *  点击登录
   *
   */
  $('body').on('click', '#buttonLogin', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    if (source !== "datatable") {
      var orgUrl = e.currentTarget.getAttribute('orgurl');
      window.location.href = orgUrl;
    };
  })
  /*
   * =======  组合控件  =======
   * 点赞功能
   *
   */
  var count = parseInt($('.orgCollect').html());
  $('body').on('click', '.orgCollect', function(e) {
    $(this).addClass('Colactive');
    $(this)[0].innerHTML = count + 1;
    e.stopPropagation();
  })


  /*
   * 点击导航添加 选中导航 效果
   *
   */
  $(document).ready(function() {
    if (window.location.href == $('.jinpin').attr("href")) {
      $(".jinpin").addClass('navActive');
    } else if (window.location.href == $('.tuijian').attr("href")) {
      $(".tuijian").addClass('navActive');
    } else if (window.location.href == $('.yidu').attr("href")) {
      $(".yidu").addClass('navActive');
    } else if (window.location.href == $('.shoucang').attr("href")) {
      $(".shoucang").addClass('navActive');
    }
  })

  /*
   * 组合控件 如果没有上传图片
   * 就上传一个占位图片
   *
   */
  imgPlaceholder('.wifiblockBox .wifiblock .wfImg');

  /*
   * =======  详情页 Tpl1  =======
   *
   */
  // 导航切换
  $('.audio_con, .video_con, .question_con, .books_con').hide();
  $('.books_con').show();
  $('body').on('click', '.nav_container div', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    $(this).siblings().removeClass('nav_btnActive');
    $(this).addClass('nav_btnActive');
    $('.audio_con, .video_con, .question_con, .books_con').hide();
    var name = $(this).attr('id');
    $('.' + name + '_con').show();
  })

  $(function() {
    // 获取文件名
    var audioLength = $('.nav_audio div[leipiplugins="addimage"]').length,
      videoLength = $('.nav_video video').length,
      booksLength = $('.nav_books div[leipiplugins="addimage"]').length;

    for (var i = 0; i < audioLength; i++) {
      if ($('.nav_audio div[leipiplugins="addimage"]')[i].innerHTML) {
        $('.audio')[i].setAttribute('src', $('.nav_audio div[leipiplugins="addimage"]')[i].innerHTML);
        $('.nav_audio div[leipiplugins="addimage"]')[i].innerHTML = $(
          '.nav_audio div[leipiplugins="addimage"]')[i].innerHTML.split('/')[4].split('.')[0];
      }
    }

    for (var i = 0; i < videoLength; i++) {
      $('.nav_video video')[i].setAttribute('style', 'height: 100px;');
      $('.nav_video video')[i].setAttribute('src', $('.nav_video video')[i].innerHTML);
      $('.nav_video video')[i].setAttribute('controls', 'controls');
      var videoSrc = '';
      if ($('.nav_video video')[i].innerHTML !== '') {
        videoSrc = $('.nav_video video')[i].innerHTML.split('/')[4].split('.')[0];;
      }
      $('.nav_video .video')[i].innerHTML = videoSrc;
    }

    for (var i = 0; i < booksLength; i++) {
      var content = $('.nav_books div[leipiplugins="addimage"]')[i].innerHTML;
      $('.nav_books div[leipiplugins="addimage"]')[i].innerHTML = '';
      var node = document.createElement('a');
      var textnode = document.createTextNode(content.split('/')[4].split('.')[0]);
      if (content.split('.')[2] === 'pdf') {
        node.setAttribute('href',
          '/editor/assets/ueditor/formdesign/self/pdfjs/web/viewer.html?file=' + content);
      } else {
        node.setAttribute('href', content);
      }
      node.appendChild(textnode);
      $('.nav_books div[leipiplugins="addimage"]')[i].appendChild(node);
    }
  })

  // 播放功能
  $('body').on('click', '.icon-bofang1', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    $(this).prev().find('.audio').get(0).play();
    $(this).css('display', 'none');
    $(this).next().css('display', 'inline-block');
  })

  // 暂停功能
  $('body').on('click', '.icon-tingzhi', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    $(this).prev().prev().find('.audio').get(0).pause();
    $(this).prev().css('display', 'inline-block');
    $(this).css('display', 'none');
  })

  /*
   * 如果没有上传图片
   * 就上传一个占位图片
   *
   */
  imgPlaceholder('.contains .contains_img');

  $(function() {

    /**
     * =======  详情页 Tpl2  =======
     * 针对 详情页 Tpl2 的分享功能
     * 设置 title 为标题
     * 设置 meta description 为正文内容提取前30文字
     *
     */
    if ($('.tpl2').length !== 0) {
      if ($('#data1').html() !== '')
        window.document.title = '党建 - 新闻 | ' + $('#data1').html()
      else
        window.document.title = '党建 - 新闻';

      var dec;
      if ($('#data4').html() !== undefined) {
        if ($('#data4').html() !== '')
          dec = $('#data4').html().substr(0, 30) + '...';
        else
          dec = '党建 - 新闻详情...';
      } else
        dec = '党建 - 新闻详情...';

      var metaDec = '<meta name="description" content=' + dec.replace(/\s/g, "") + '>';
      $('head').append(metaDec)
    }

    /**
     * 点赞功能 - 可复用
     *
     * 点赞机制：
     * 1. 判断有没有登陆, 有则判断有没有点赞过, 没则允许点赞, 已经点赞的就取消点击事件
     *
     * 点赞功能要求：
     * 1. 同一个页面只允许有一处点赞按钮。
     * 2. 点赞图标必须为 iconfont 可以变色的图标
     * 3. 触发点赞按钮的className为 sw_likes
     * 4. 点赞计数的className为 sw_likesCount (可选择添加或不添加)
     */

    $('body').on('click', '.sw_likes', function() {
      var user = isLogin();
      var nodeGid = getNodeGid();
      if (user !== '') {
        $.ajax({
          url: prevent_HOST + 'article/thumbsUp?nodeId=' + nodeGid.nodeId + '&gId=' + nodeGid.gId +
            '&uId=' + user.id,
          type: 'GET',
          headers: {
            "token": userToKen
          },
          dataType: 'json',
          success: function(res) {
            res['status'] === '0' ? $('.sw_likes').css('color', 'red') : $('.sw_likes').css('color',
              '#333333');
            if ($('.sw_likesCount').length !== 0) $('.sw_likesCount').html(res['msg']);
          }
        })
      } else alert('抱歉, 您没有登录, 暂时不能点赞！');
    })

    /**
     * 点赞功能 - 点赞数统计
     * 判断有没有点赞统计框, 如果有则加载目前点赞数。
     */
    if ($('.sw_likesCount').length !== 0) {
      var user = isLogin(),
        userId;
      var nodeGid = getNodeGid();
      user !== '' ? userId = user.id : userId = '';
      $.ajax({
        url: prevent_HOST + 'article/selectThumbsUp?nodeId=' + nodeGid.nodeId + '&gId=' + nodeGid.gId +
          '&uId=' + userId,
        type: 'GET',
        headers: {
          "token": userToKen
        },
        dataType: 'json',
        success: function(res) {
          $('.sw_likesCount').html(res['msg']['count']);
          if (res['msg']['istrue']) $('.sw_likes').css('color', 'red');
        }
      })
    }

    /**
     * 收藏功能 - 可复用
     *
     * 收藏机制：
     * 1. 判断有没有登陆, 有则判断有没有收藏过, 没则允许收藏
     *
     * 收藏功能要求：
     * 1. 同一个页面只允许有一处收藏按钮。
     * 2. 收藏图标必须为 iconfont 可以变色的图标
     * 3. 触发收藏按钮的className为 sw_collect
     */

    $('body').on('click', '.sw_collect', function() {
      var user = isLogin();
      var nodeGid = getNodeGid();
      if (user !== '') {
        var data = {
          'nodeId': nodeGid.nodeId,
          'gid': nodeGid.gId,
          'uid': user.id,
          'title': window.document.title,
          'imgUrl': $('img').eq(0).attr('src')
        };

        $.ajax({
          url: prevent_HOST + 'article/collection',
          type: 'POST',
          dataType: 'json',
          data: JSON.stringify(data),
          contentType: 'application/json;charset=utf-8',
          headers: {
            "token": userToKen
          },
          success: function(res) {
            if (res.status === '0') {
              $('.sw_collect').css('color', '#FF5722');
              $('.sw_collect').data('isCollect', true);
            } else {
              $('.sw_collect').css('color', '#000');

            }
          }
        })
      } else alert('抱歉, 您没有登录, 暂时不能收藏！');
    })

    /**
     * 收藏功能
     * 判断有没有收藏过本文章，如果有则标识已收藏
     */

    if ($('.sw_collect').length !== 0) {
      var user = isLogin();
      var nodeGid = getNodeGid();
      $.ajax({
        url: prevent_HOST + 'article/getCollectionGid?nodeId=' + nodeGid.nodeId + '&gId=' + nodeGid.gId +
          '&uId=' + user.id,
        type: 'GET',
        headers: {
          "token": userToKen
        },
        dataType: 'json',
        success: function(res) {
          if (res.msg) $('.sw_collect').css('color', '#FF5722');
        }
      })
    }

    /**
     * 评论功能
     *
     * 评论功能说明：
     *
     */

    function getComments(callback) {
      // 首次请求是在页面加载时已经请求，所以为了节省一次请求，所以取SessionStorage的值
      if (window.sessionStorage.getItem('commentsInfo') !== null) {
        callback(JSON.parse(window.sessionStorage.getItem('commentsInfo')));
        window.sessionStorage.removeItem('commentsInfo');
      } else {
        var nodeGid = getNodeGid();
        $.ajax({
          url: prevent_HOST + 'article/selectComment?nodeId=' + nodeGid.nodeId + '&gId=' + nodeGid.gId,
          type: 'GET',
          headers: {
            "token": userToKen
          },
          dataType: 'json',
          success: function(res) {
            callback(res);
            if ($('.sw_commentsCount').length !== 0) $('.sw_commentsCount').html(res['msg'].length);
          }
        })
      }
    }

    function insertComments(content, callback) {
      var user = isLogin();
      var nodeGid = getNodeGid();
      user !== '' ? userId = user.id : userId = '0';

      if (user !== '') {
        var data = {
          'nodeId': nodeGid.nodeId,
          'gid': nodeGid.gId,
          'uid': user.id,
          'content': content
        }
        $.ajax({
          url: prevent_HOST + 'article/comment',
          type: 'POST',
          dataType: 'json',
          contentType: 'application/json;charset=utf-8',
          headers: {
            "token": userToKen
          },
          data: JSON.stringify(data),
          success: function(res) {
            if (res['status'] !== '2') callback(res)
            else alert(res['statusMsg']);
          }
        })
      } else alert('抱歉, 您没有登录, 暂时不能评论！');
    }

    function deleteComments(commentId, pElem) {
      if (confirm('确认删除这条评论吗？')) {
        $.ajax({
          url: prevent_HOST + 'article/delComment?id=' + commentId,
          type: 'GET',
          headers: {
            "token": userToKen
          },
          dataType: 'json',
          success: function(res) {
            res.status === '0' ? pElem.remove() : alert('删除失败');
          }
        })
      }
    }

    function showComments(res, pElem, sElem) {
      var resBak,
        deleteClone; // 这是要来判断是不是需要删除最后一个克隆的节点的
      $(sElem).length === 1 ? deleteClone = true : deleteClone = false;
      $(sElem).length > 1 ? resBak = resultUnique(res, sElem) : resBak = res;
      if (window.sessionStorage.getItem('commentsElem') === null) window.sessionStorage.setItem(
        'commentsElem', $(sElem).clone(true)[0].outerHTML);
      for (var i = 0; i < resBak.length; i++) {
        $(pElem).append(window.sessionStorage.getItem('commentsElem'));
        var flag = resBak[i]['id'] + '-' + resBak[i]['content'];
        deleteClone ? $(sElem)[i].dataset.commentFlag = flag : $(sElem).last()[0].dataset.commentFlag = flag;

        var user = isLogin();
        if (user !== '') {
          // 判断用户登录和评论是不是同一. 是就可以删除评论.
          var userCanDelete;
          deleteClone ? userCanDelete = user.id !== res[i]['uid'] : userCanDelete = user.id !== $(res).last()[
            0]['uid'];
          userCanDelete ?
            deleteClone ?
            $('.sw_deleteComments').eq(i).hide().data('canDelete', false) : $('.sw_deleteComments').last().hide()
            .data('canDelete', false) :
            deleteClone ?
            $('.sw_deleteComments').eq(i).show().data('canDelete', true) : $('.sw_deleteComments').last().show()
            .data('canDelete', true);
        } else $('.sw_deleteComments').hide();
      }
      if (deleteClone) $(sElem).last().remove(); // 删除最后一个多clone出来的元素。
    }

    function resultUnique(res, sElem) {
      var returnRes = [];
      for (var i = 0; i < res.length; i++) {
        var
          flag,
          resFlag = res[i]['id'] + '-' + res[i]['content'];
        $(sElem)[i] !== undefined ? flag = $(sElem)[i].dataset.commentFlag : flag = '';
        if (flag !== resFlag) returnRes.push(res[i]);
      }
      return returnRes;
    }

    /**
     * 评论功能 - 评论数统计
     * 判断有没有评论统计框, 如果有则加载目前评论数。
     */

    if ($('.sw_commentsCount').length !== 0) {
      var nodeGid = getNodeGid();
      $.ajax({
        url: prevent_HOST + 'article/selectComment?nodeId=' + nodeGid.nodeId + '&gId=' + nodeGid.gId,
        type: 'GET',
        headers: {
          "token": userToKen
        },
        dataType: 'json',
        success: function(res) {
          $('.sw_commentsCount').html(res['msg'].length);
          window.sessionStorage.setItem('commentsInfo', JSON.stringify(res));
        }
      })
    }


    /**
     * Tpl2 - 详情页逻辑处理
     *
     */

    $('body').on('click', '.sw_comments', function() {
      $('.sw_comments_container').fadeIn();
      getComments(tpl2_comments);
    })

    $('body').on('click', '.sw_comments_back', function() {
      $('.sw_comments_container').fadeOut();
    })

    $('body').on('click', '#commentSend', function(e) {
      e.preventDefault();
      if ($('#commentText').val() !== '') {
        var val = $('#commentText').val();
        insertComments(val, tpl2_comments);
      } else {
        alert('您好！请输入你要评论的内容！');
        $('#commentText').focus();
        return false;
      }
    })

    $('body').on('click', '.sw_deleteComments', function(e) {
      if ($(e.target).data('canDelete')) deleteComments(e.target.dataset.commentId, $(e.target).parents(
        '.commentContent'))
      else alert('抱歉！您没有权限删除别人的评论！别调皮啦！');
    })

    function tpl2_comments(result) {
      if (result['msg'].length === 0) $('.comment .noComment').fadeIn()
      else {
        $('.comment .noComment').hide();
        $('.comment .hasComment').fadeIn();
        $('#commentText').val(''); // 把input的值清空
        var res = result['msg'];
        showComments(res, '.comment .hasComment', '.comment .hasComment .commentContent');

        // 循环遍历数据
        for (var i = 0; i < result['msg'].length; i++) {
          var elem = $('.comment .hasComment .commentContent')[i];
          var date = new Date(res[i]['createTime']),
            commentTime = ((date.getMonth() + 1) < 10 ? '0' + (date.getMonth() + 1) : (date.getMonth() + 1)) +
            '-' +
            (date.getDate() < 10 ? '0' + date.getDate() + ' ' : date.getDate() + ' ') +
            (date.getHours() < 10 ? '0' + date.getHours() + ':' : date.getHours() + ':') +
            (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes());
          $(elem).find('.userIconImg').attr('src', './images/placeholder.jpg'); // 因为现在用户信息没有头像，所以暂时用默认的替代
          $(elem).find('.userName').html(res[i]['uid']); // 显示 用户昵称
          $(elem).find('.content').html(res[i]['content']); // 显示 评论内容
          $(elem).find('.commentTime').html(commentTime); // 显示 评论时间
          $(elem).find('.sw_deleteComments')[0].dataset.commentId = res[i]['id'];
        }
      }
    }

    /* Tpl3 - 详情页逻辑处理 */
    if ($('.tpl3').length !== 0) {
      var script = '<script src="./self/swiper/swiper-4.2.2.min.js">',
        css = '<link rel="stylesheet" href="./self/swiper/swiper-4.2.2.min.css">';
      $('head').append(script);
      $('head').append(css);

      var tpl3_swiper = new Swiper('.swiper-container', {
        autoplay: true,
        loop: true,
        slidesPerview: 'auto',
        pagination: {
          el: '.swiper-pagination'
        }
      });
    }

    // Tpl4 - 详情页逻辑处理
    if ($('#lc-main').length !== 0) {
      var script = '<script src="./self/swiper/swiper-4.2.2.min.js">',
        css = '<link rel="stylesheet" href="./self/swiper/swiper-4.2.2.min.css">';
      $('head').append(script).append(css);
      var navSwiper = new Swiper('#lc-tab', { //内容页的切换
        preventLinksPropagation: false, //触摸滑动
        initialSlide: 0, //初始页
        on: {
          slideChangeTransitionEnd: function() { //切换到下一页完成的时候触发
            $('#lc-navbar a').eq($('#lc-tab .swiper-slide-active').index()).addClass('nav-active').siblings()
              .removeClass('nav-active');
          },
          init: function() { //初始化完成就执行这个
            $('#lc-tab').find('.swiper-wrapper').css({
              'height': '100%'
            });
          }
        }
      });
      $('#lc-navbar a').unbind().click(function() {
        $(this).addClass('nav-active').siblings().removeClass('nav-active');
        navSwiper.slideTo($(this).index());
      });
      $('#lc-study-btn button').unbind().click(function() { //打开视频页
        $('#lc-banner').hide();
        $('#lc-study-btn').hide();
        $('#lc-video').show();
        $('#lc-title-bar .title').show();
        $('#lc-video video')[0].play();
        var time = setInterval(function() {
            if (left < $('#lc-title-bar .title span').width()) {
              left++;
            } else {
              left = 0;
            }
            $('#lc-title-bar .title span').css('margin-left', '-' + left + 'px');
          }, 100),
          left = 0;
      });
      $('#lc-video').unbind().click(function() { //点击视频的时候出现返回键
        $('#lc-video img').fadeIn('fast');
        setTimeout(function() {
          $('#lc-video img').fadeOut('fast');
        }, 1000);
      });
      $('#lc-video img').unbind().click(function() {
        $('#lc-banner').show();
        $('#lc-study-btn').show();
        $('#lc-video').hide();
        $('#lc-title-bar .title').hide();
        $('#lc-video video')[0].pause();
        clearInterval(time);
      });
      $('.video-hide').hide(); //打开的时候将video隐藏
      $('body').off(); //移除默认的热区跳转事件
      $('#lc-contents .li').unbind().click(function() {
        $('#lc-video video').attr('src', $(this).find('video').html());
        $('#lc-study-btn button').click();
      });
      $('#lc-video video').attr('src', $('#lc-contents .li').eq(0).find('video').html()); //默认第一个视频
    }

    //搜索
    $('body').on('click', '.frm-search', function() {
      var s_title = $('input[name="sousuokuang"]').val();
      doTextSearch(s_title);
    })
  })

  var toolbtn = true;
  var rtl = $("#rtoptool");
  $(document).on("click", "#rtoptooloff", function() {
    if (toolbtn) {
      rtl.animate({
        width: "458px",
        opacity: 1
      }, 1000);
      toolbtn = false;
    } else {
      rtl.animate({
        width: "38px",
        opacity: 0.5
      }, 1000);
      toolbtn = true;
    }
  });
  /*添加、修改、删除按键*/
  $('body').on('click', 'span.gomethod', function(e) {
    e.preventDefault(); // 阻止默认事件
    e.stopPropagation(); // 阻止冒泡
    //var fw=$("#maincontent");
    var method = $(this).data("method");
    var url = null;
    //console.log("index currNodeId:"+currNodeId);
    if (method == "add") {
      url = '/editor/assets/ueditor/formdesign/preview.html?id=' + curreditnode +
        '&name=测试站点&method=add&selectId=' +
        curreditnode;
    } else if (method == "list") {
      url = '/editor/assets/ueditor/formdesign/preview.html?id=' + curreditnode + '&name=测试列表&method=watch';
    } else if (method == "edit") {
      url = '/editor/assets/ueditor/formdesign/preview.html?id=' + curreditnode +
        '&name=测试站点&method=change&selectId=' +
        curreditnode;
    } else if (method == "del") {
      url = '/editor/assets/ueditor/formdesign/preview.html?id=' + curreditnode +
        '&name=测试站点&method=add&selectId=' +
        curreditnode;
    }
    window.location.href = url;
    console.log(url);
    //fw.attr('src',url);
  })

  //二级菜单
  $(".second_nav_list").hover(
    function() {
      $(this).find(".second_nav_children_box").css("display", "block");
    },
    function() {
      $(this).find(".second_nav_children_box").css("display", "none");
    }
  )

  //评分控件
  //初始化解析界面
  /*function frmDateTime(ctime) {
    var d = new Date(ctime);
    var dformat = [ d.getFullYear(), d.getMonth() + 1, d.getDate() ].join('-')
      + ' ' + [ d.getHours(), d.getMinutes(), d.getSeconds() ].join(':');
    return dformat;
  };*/
  $("span.display_none").css("display", "none");
  $("span[leipiplugins='score']").css("border", "none");
  var starnumber;
  $("[leipiplugins='score'] a").bind({
    //鼠标移入
    mouseover: function() {
      var index = "";
      index = $(this).index();
      var curstonNode = $(this).parent()
      // $(curstonNode).find("a").removeClass("color_orange_plus");
      $(curstonNode).find("a").removeClass("color_red_plus");
      for (var i = 0; i <= index; i++) {
        // $(curstonNode).find("a").eq(i).addClass("color_orange");
        $(curstonNode).find("a").eq(i).addClass("color_red");
      }
      //console.log( $(this).index() )
    },
    //鼠标移出
    mouseleave: function() {
      var curstonNode = $(this).parent()
      // $(curstonNode).find("a").removeClass("color_orange");
      $(curstonNode).find("a").removeClass("color_red");
      for (var i = 0; i < starnumber; i++) {
        // $(curstonNode).find("a").eq(i).addClass("color_orange_plus");
        $(curstonNode).find("a").eq(i).addClass("color_red_plus");
      }
    },
    //鼠标点击
    click: function() {
      // starnumber = $("[leipiplugins='score'] a.color_orange").length;
      starnumber = $("[leipiplugins='score'] a.color_red").length;
      var index = "";
      index = $(this).index();
      var curstonNode = $(this).parent()
      for (var i = 0; i <= index; i++) {
        // $(curstonNode).find("a").eq(i).addClass("color_orange_plus");
        $(curstonNode).find("a").eq(i).addClass("color_red_plus");
      }
    }
  });
  /*kenzo代码区开始 DEFAULT_URL*/
  var plujobrow = $('#plujobrow');
  if (plujobrow.length > 0) {
    var plujobrowlist = localStorage.getItem('plujobrow');
    var curUserJobObj = localStorage.getItem('curUserJob');
    if (plujobrowlist == null) {
      if (curUserJobObj == null) {
        $.get(DEFAULT_JOBURL + "htRoleService/getRoleTreeByUser?user_id=" + gUser.id, function(res) {
          if (res.status == "1") {
            var r = res.msg;
            if (r.length > 0) {
              var tmplist = doJobRow(r);
              localStorage.setItem('curUserJob', JSON.stringify(res.msg));
              localStorage.setItem('plujobrow', tmplist);
              plujobrow.html(tmplist);
            }
          }
        });
      } else {
        var tmplist = doJobRow(JSON.parse(curUserJobObj));
        localStorage.setItem('plujobrow', tmplist);
        plujobrow.html(tmplist);
      }
    } else {
      plujobrow.html(plujobrowlist);
    }
  }
  /*kenzo代码区结束*/
});

$(function() {
  /*
	var key1 = Symbol('description');
	var key2 = Symbol();

	var obj = {
	    [key1]() { },
	    [key2]() { }
	}
	*/
  /* console.log( obj[ key1 ].name );

   console.log( obj[ key2 ].name );
   console.log( Object.is( NaN, NaN ) );*/
  /*
    Object.defineProperty(Object, 'is', {
        value(x, y) {
            if (x === y) {
                return x != 0 || 1 / x === 1 / y;
            }
            return x !== x && y !== y
        }
    })

    var obj1 = { 'a': 1 };
    var obj2 = { "b": 2 };
    var obj3 = { "c": 3 };
    Object.assign(obj1, obj2, obj3)
    //console.log( obj1 )
    var arr1 = { "a": { "b": 1 } };
    var arr2 = Object.assign({}, arr1);
    //console.log( arr1.a.b, arr2 )
    var source = {
        get foo() {
            return 1
        }
    }
    var target = {};
    Object.assign(target, source);
    // console.log( target.foo )

    function clone(arr) {
        return Object.assign({}, arr)
    }
    var s = new Set();
    */
})
window.onload = function() {
  //console.log($("html").html());
  /*var htmldata={
    "record":document.documentElement.outerHTML,
    "name":$('#node_name', window.opener.document).val()
  }*/
  if ($('#container').length > 0) {
    var cx = $('#container').data('x');
    var cy = $('#container').data('y');
    cEacht('container', cx, cy);
  }
  console.log("test")
  if (gUser != '' && gUser != null && gUser != undefined) {
    var plusername = gUser.user.chinese_name;
    if (plusername == '' || plusername == null || plusername == undefined) plusername = gUser.user.username;
    $(".pl_username").html(plusername);
    if (gUser.user.face) {
      $(".pl_userface").attr("src", gUser.user.face);
    }

  }
  if ($('.image_val').length > 0) {
    var image_val = $('.image_val').val();
    if (image_val != '') {
      var image_imgext = "jpg|jpeg|gif|bmp|png|";
      var image_fileExt = image_val.substring(image_val.lastIndexOf(".") + 1, image_val.length);
      if (image_imgext.indexOf(image_fileExt + "|") != -1) {
        var image = new Image();
        image.src = image_val;
        $('.image_val').val(get64Image(image));
      }
    }
  }
  setTimeout(function() {
    if (window.source == 'ueditor') {
      var htmlcon = document.documentElement.outerHTML;
      var htmldata = {
        "record": htmlcon.replace('alert(\"页面预览失败！请关闭页面并重新尝试预览！\");', ''),
        "name": currNode.value,
        "nodeId": currNode.id
      }
      $.ajax({
        type: 'POST',
        url: prevent_HOST + 'pageDesignOperatorFacade/creatStaticPage',
        contentType: 'application/json; charset=UTF-8',
        headers: {
          "token": userToKen
        },
        dataType: 'json',
        data: JSON.stringify(htmldata),
        success: function(res) {
          //console.log(res);
        }
      })
    }
  }, 3000);


  //删除所有img标签的title
  //   $("img").prop("title","");
  var $imgs = $('img');
  if ($imgs.length !== 0) {
    for (var i = 0; i < $imgs.length; i++) {
      $imgs[i].title = '';
    }
  }

}
