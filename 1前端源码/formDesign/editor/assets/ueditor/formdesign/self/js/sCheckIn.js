$(document).ready(function () {
  var nodeId = null;
  var result = false;
  function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
  }
  nodeId = getQueryString("link");
  if (nodeId == null) {
      nodeId = getQueryString("id");
  }
  if (nodeId != null) {
    $.ajax({
      type: "get",
      url: DEFAULT_JOBURL + "htRoleService/getTouristPermission?nodeId=" + nodeId,
      success: function (data) {
        if (data.status == '200') {
          if (data.msg == 'true') {
            result = true;
            getStaticPage(nodeId);
          }
          if (!result) {
            var user = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
            if (user == null) {
              alert("你还没有登录!");
              if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
                window.location.href = '/mobile/tpl/login?v=' + Math.random();
              } else {

                if (window.parent.location.href != window.location.href) {
                  window.parent.location.href = '/login2';
                } else {
                  window.location.href = '/login2';
                }
              }
              return false;
            } else {
              var json = JSON.stringify(user);
              var jsonObj = JSON.parse(json);
              var isadmin = jsonObj.user.isadmin;
        
              if (isadmin=='1') {
                //getStaticPage(nodeId);
                return false;
              }
              $.ajax({
                type: "get",
                url: DEFAULT_JOBURL + "htUserService/getUserPermission?uid=" + user.id + "&nodeId=" + nodeId,
                success: function (data) {
                  if (data.status == '200') {
                    if (data.msg == 'true') {
                      //getStaticPage(nodeId);
                    } else {
                      alert("对不起，权限不足");
                      window.history.go(-1);
                    }

                  }
                }
              });

            }
          } //result
          //程序500返回到登陆页面
        } else if (data.status == '500') {
          if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
            window.location.href = '/mobile/tpl/login?v=' + Math.random();
          } else {
            window.location.href = '/login2';
          }

        }
      }
    });
  } //nodeid
  function getStaticPage(nodeId) {
    // $.ajax({
    //   type: "GET",
    //   url: DEFAULT_URL + "pageDesignQueryFacade/getPageContent?id=" + nodeId,
    //   contentType: "application/json; charset=UTF-8",
    //   success: function (data) {
    //     var json = JSON.stringify(data);
    //     var jsonObj = JSON.parse(json);
    //     var dataArray=jsonObj.msg.data;
    //     if(dataArray.length==0){
    //       $.ajax({
    //         type: "GET",
    //         url: DEFAULT_JOBURL + "htNodeService/getStaticPage?nodeId=" + nodeId,
    //         contentType: "application/json; charset=UTF-8",
    //         success: function (res) {
    //           if (res.status == '200') {
    //             window.location.href = page_root_url + res.msg;
    //           }
    //         }
    //       });
    //     }
    //   }
    // });    
    
    
  }



})
