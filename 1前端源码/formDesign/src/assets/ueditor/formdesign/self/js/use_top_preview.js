//级联分类
function classifyClassChang(id, sonclass) {
    //console.log(id,sonclass);
    if (id == '' || id == undefined) {
        $("#classify_" + sonclass).html("<option value=''>---请选择---</option>");
        return false;
    }
    if (sonclass != '' || sonclass != undefined) {
        $.ajax({ // 这是获取模板。http://htjy.kz38.cn:20890/pageDesignQueryFacade/selectFormRecordByNodeId?nodeId=2897
            url: prevent_HOST + "pageDesignQueryFacade/getclassifyByParentId?pid=" + id,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            headers:{"token":gUser.token},
            async: false,
              success: function (res) {
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
window.onbeforeunload=function(){ 
    if(currRecord != null && currRecord != undefined){        
        $.ajax({
            url: DEFAULT_JOBURL + 'htUserService/userOut?id=' + currRecord,
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',            
            async: false,
              success: function (res) {
                currRecord=null;
              }
        })
    }
}