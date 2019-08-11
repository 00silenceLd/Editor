//初始化
var path = "/editor/assets/ueditor/formdesign/preview.html?link=";

var outUrl = "";
var flowuserid = null;
try{
  flowuserid = gUser.id;
}catch (e) {

}
var tokenValue = userToKen;

var orgJSONData = {
    "userId": flowuserid,
    // "userId": "543",
    "formData": "",
    "processDefinitionKey": "",
    "title": "",
    "formId": "",
    "roleId": "",
    "candidateUsers": ""
};
var form = [];
var getformdata = [];
var iframeSrc = "";



//模态框加载
function modalLoad(title, jumpUrl) {
    //自适应
    //setIframeHeight("operationType");
    //获取跳转链接
    outUrl = jumpUrl;
    $("#myModalLabel").html(title + " - 信息填写");
    ISNotNull_LoadInfo();
    orgJSONData.title = title;

}

//查找表单
function FindForm(title, jumpUrl, flowKey, formid) {
    orgJSONData.processDefinitionKey = flowKey;
    orgJSONData.formId = formid;
    iframeSrc = path + formid;
    $("#operationType").attr("src", iframeSrc);
    modalLoad(title, jumpUrl);
}

//Load表单信息
function ISNotNull_LoadInfo() {
    var $opt = $("#operationType");
    var $optForm = $opt.contents();
    if (getformdata.length <= 0) return false;
    if ($optForm.find("form")[0].length <= 0) return false;
    $.each($optForm.find("form")[0], function (i, formEle) {
        $.each(getformdata, function (i, val) {
            if (formEle.name == val.name) {
                $optForm.find(formEle.localName + "[name='" + val.name + "']").val(val.value);
            };
        });
    });

}

function openFlowModal(id) {
    console.log(id)

    // $("#btnSub").text("下一步");
    $.ajax({
        type: "get",
        headers: { "token": "" + tokenValue },
        url: DEFAULT_JOBURL + "htRoleService/getUserJoinRole?uId=" + flowuserid,
        success: function (res) {
            if (res.status == "3") {
                alert("对不起，你暂时没有组织，不能进行此操作！");
                return false;
            }
            $("#myModal_background").fadeIn(1000);
            if (orgJSONData.processInstanceId != $(id).attr("orgflow").toString()) {
                getformdata = [];
                FindForm($(id).attr("value"), $(id).attr("orgurl"), $(id).attr("orgflow"), $(id).attr("orgformid"));
            }
        }
    });
}

function hide_modal(id) {
    $(id).fadeOut(1000);
}

function submitFlow(id) {
    var val = $(id).text();
    if (val != "下一步") {
    //  if (val == "下一步") {
        // orgJSONData.roleId = $("#operationType").contents().find("#select_role").val();
        orgJSONData.roleId = flowuserid;
        if (orgJSONData.roleId == 0 || orgJSONData.roleId == "" || orgJSONData.roleId == undefined) {
            alert("对不起，请选择申请组织！");
            return false;
        }
        form = $("#operationType").contents().find("form").serializeArray();
        // $("#operationType").attr("src", "flow_user_role.html");
        if (form.length <= 0) {
            //同源、跨越
            alert("对不起，获取表单数据出现问题，请联系管理员！");
            return false;
        }

        orgJSONData.formData = JSON.stringify(form);
        try {
            $.ajax({
                type: "get",
                headers: { "token": "" + tokenValue },
                url: DEFAULT_JOBURL + 'htRoleService/getRoleEqual?roleId='+orgJSONData.roleId+'&uId='+orgJSONData.userId,
                success: function (res) {
                    orgJSONData.candidateUsers = "";
                    // if (res.status != 200) {
                    if (res.status == 200) {
                        orgJSONData.candidateUsers = 0;
                    } else {
                        // $.each(res.msg, function (i, obj) {
                            // orgJSONData.candidateUsers += obj.uid + ",";
                            orgJSONData.candidateUsers += 123934 + ",";
                        // });
                    }

                    if (orgJSONData.candidateUsers == 0) {
                        alert("对不起，您没有上级领导，不能进行此操作！");
                        return false;
                    }
                    var apiUrl = Flow_Host + "activiti-demo/leave/process-start";
                    // var apiUrl="192.168.0.173:8080/activiti-demo/leave/process-start";
                    $.post(apiUrl, orgJSONData, function (retdata) {
                        if (retdata.code == 0) {
                            alert("提交成功！");
                            hide_modal("#myModal_background");
                        } else {
                            alert("提交失败！");
                        }
                    });

                }
            });

        } catch (e) {
            alert("异常：" + e);
        }
    } else {
        // form = $("#operationType").contents().find("form").serializeArray();
        // $("#operationType").attr("src", "flow_user_role.html");
        // $(id).text("下一步");
    }

}


function loadFlowModal() {
    var app = navigator.userAgent.match(/(phone|pad|pod|iPhone|iPod|ios|iPad|Android|Mobile|BlackBerry|IEMobile|MQQBrowser|JUC|Fennec|wOSBrowser|BrowserNG|WebOS|Symbian|Windows Phone)/i);

    var modelFrame = "";
    if (app == null) {
        console.log("PC端：流程提交使用");
        modelFrame = '<div id="myModal_background" ondblclick="hide_modal(this);" style="left:0;top:0; display:none; width: 100%;min-height:900px;min-width: 700px; height: 100%;position: absolute; background-color: rgba(83, 83, 83, 0.61);">'+
        '<div class="container" style="background-color: #ffffff;position: relative;left: 50%;top:50%;width:600px;height: 650px;margin-left:-300px;margin-top: -350px; ">'+
            '<div class="row" style="margin: 0;width: 100%;height:6%;border-bottom: 1px solid #8b858562">'+
                '<div class="col-lg-12" style="height: 100%;line-height: 50px;">'+
                    '<span id="myModalLabel" style="user-select: none; font-size: 15pt;font-weight: 600;font-family: 宋体;">'+
                        '流程 - 模态框</span>'+
               '</div>'+
            '</div>'+
            '<div class="row" style="margin: 0; width: 100%;height:88%;">'+
                '<iframe style="padding-top:10px;" id="operationType" src="" height="100%" width="100%" frameborder="0"></iframe>'+
            '</div>'+
            '<div class="row" style="margin: 0;width: 100%;height:6%;border-top: 1px solid #8b858562">'+
                '<div class="col-lg-8 col-sm-8 col-xs-8" style="height: 100%;"></div>'+
                '<div class="col-lg-2  col-sm-2 col-xs-2" style="height: 100%;">'+
                    '<button  onclick="hide_modal(\'#myModal_background\');"  style="width: 100%;height: 70%;margin-top:5px; ">关闭</button>'+
                '</div>'+
                '<div class="col-lg-2  col-sm-2 col-xs-2" style=" height: 100%;">'+
                    // '<button id="btnSub" onclick="submitFlow(this);" style="width: 100%;height: 70%;margin-top:5px; ">下一步</button>'+
                    '<button id="btnSub" onclick="submitFlow(this);" style="width: 100%;height: 70%;margin-top:5px; ">提交</button>'+
                '</div>'+
            '</div>'+
        '</div>'+
    '</div>';
    }else{
        console.log("APP端：流程提交使用");
        $("html").css({"width":"100%","height":"100%"});
        $("body").css({"width":"100%","height":"100%"});
        modelFrame = '<div id="myModal_background" ondblclick="hide_modal(this);"  style="left:0;top:0;display:none; position: absolute;width:100%;height: 100%;">'+
        '<div class="container" style="background-color: #ffffff;position: relative;width:100%;height: 100%; ">'+
            '<div class="row" style="margin: 0;width: 100%;height:6%;border-bottom: 1px solid #8b858562">'+
                '<div class="col-lg-12" style="height: 100%;line-height: 50px;">'+
                    '<span id="myModalLabel" style="user-select: none; font-size: 15pt;font-weight: 600;font-family: 宋体;">'+
                        '流程 - 模态框</span>'+
                '</div>'+
            '</div>'+
            '<div class="row" style="margin: 0; width: 100%;height:88%;">'+
                '<iframe style="padding-top:10px;" id="operationType" src="" height="100%" width="100%" frameborder="0"></iframe>'+
            '</div>'+
            '<div class="row" style="margin: 0;width: 100%;height:6%;border-top: 1px solid #8b858562">'+
                '<div style="height: 100%;"></div>'+
                '<div  style=" height: 100%;">'+
                        // '<button id="btnSub" onclick="submitFlow(this);" style="width: 100%;height: 70%;margin-top:5px; ">下一步</button>'+
                        '<button id="btnSub" onclick="submitFlow(this);" style="width: 100%;height: 70%;margin-top:5px; ">提交</button>'+
                    '</div>'+
                '<div style="height: 100%;">'+
                    '<button  onclick="hide_modal(\'#myModal_background\');"  style="width: 100%;height: 70%;margin-top:5px; ">关闭</button>'+
                '</div>'+

            '</div>'+
        '</div>'+
    '</div>';
    }
    $("body").append(modelFrame);
    window.sessionStorage.setItem("iframe_exists", true);
}

$(function () {
    loadFlowModal();
    var iframe_exists = window.sessionStorage.getItem("iframe_exists");
    if (iframe_exists == "true") { } else { loadFlowModal(); }

    $(document).keydown(function (event) {
        if (event.keyCode == 116) {
            window.sessionStorage.setItem("iframe_exists", false)
            window.location.reload(true);
        }
    });
});
