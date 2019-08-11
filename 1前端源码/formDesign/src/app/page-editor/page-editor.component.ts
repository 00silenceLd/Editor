import { HttpDataService } from './../service/httpData.service';
import { Http, Headers, RequestOptions } from '@angular/http';
import { Component, OnInit, ViewEncapsulation, AfterViewInit, ViewChild, ElementRef, Input } from '@angular/core';
import { UEditorComponent } from 'ngx-ueditor';
import { FormManageComponent } from '../form-manage/form-manage.component';
import { InsertDataService } from '../service/insertData.service';
import * as $ from 'jquery';

declare const UE: any;

@Component({
  selector: 'app-page-editor',
  templateUrl: './page-editor.component.html',
  styleUrls: ['./page-editor.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class PageEditorComponent {
    @ViewChild(UEditorComponent) editor: UEditorComponent;
    // @Input() nodeId: number;
    @Input() nodeType: number;
    @Input() nodeName: string;
    @Input() nodeParentId: number;
    @Input() nodeParentId2x: number;

// 	@Input() shareTo_name: string;
// 	@Input() shareTo_nodeId: number;
	nodeId;
	@Input()
	set node_id(nodeId:number){
		// alert("nodeId="+nodeId);
		this.nodeId = nodeId;
// 		alert("this.nodeId="+this.nodeId);
// 		alert("$('#shareTo_nodeId').val()="+$("#shareTo_nodeId").val());
		$("#shareTo_nodeId").val(0);
		// alert("$('#shareTo_nodeId').val(0)="+$("#shareTo_nodeId").val());
	}
	@Input() is_approve: number;
  @Input() page_classify: number;
  @Input() module_classify: number;
	is_public;
	@Input()
	set isPublic(is_public: number) {
		// alert(this.is_approve);
		this.is_public = is_public;
		// alert(this.is_public);
		var oPublic1 = document.getElementById("public1");
		var oPublic2= document.getElementById("public2");

		var onoPublic1 = document.getElementById("noPublic1");
		var onoPublic2 = document.getElementById("noPublic2");
		var onoPublic3 = document.getElementById("noPublic3");

		if(this.is_public==0){
			oPublic1.className = "";
			oPublic2.className = "";

			onoPublic1.className = "noPublic";
			onoPublic2.className = "noPublic";
			onoPublic3.className = "noPublic";

		}
		if(this.is_public==1){

			oPublic1.className = "public";
			oPublic2.className = "public";

			onoPublic1.className = "";
			onoPublic2.className = "";
			onoPublic3.className = "";
		}
		if(this.is_public!=0&&this.is_public!=1){

			oPublic1.className = "";
			oPublic2.className = "";

			onoPublic1.className = "";
			onoPublic2.className = "";
			onoPublic3.className = "";
		}

	}




    toggle = true;
    toggleValue = '隐藏';
    toggleVersion = true;
    versionEditor = '电脑';
    nowSelect = 'iphone6';
    lastSelect = 'iphone6';
    swPluginTool=true;

    headers = new Headers({ 'Content-Type': 'application/json;charset=UTF-8' });
    options = new RequestOptions({ headers: this.headers });

    custom: any = {
        // 配置工具栏
        iframeCssUrl: './assets/ueditor/formdesign/self/css/style.css', // 给编辑器内部引入一个css文件
        allowDivTransToP: false,      // 允许进入编辑器的div标签自动变成p标签
        initialFrameWidth: 'auto' ,  // 初始化编辑器宽度,默认1000
        initialFrameHeight: 500,  // 初始化编辑器高度,默认320
        enableAutoSave: false, //启用自动保存
        saveInterval: 0 //自动保存间隔时间， 单位ms
    };
    constructor(private el: ElementRef, private http: Http, private httpData: HttpDataService, private insertData: InsertDataService) {

      sessionStorage.setItem('editorStyle', 'pc');
      /*console.log(this.nodeType);*/
       if(this.nodeType==7){
         sessionStorage.setItem('editorStyle', 'pc');
       }else{
         sessionStorage.setItem('editorStyle', 'phone');
       }
    }

    onPreReady(comp: UEditorComponent) {
        /*
         * 在百度编辑器里面添加小按钮
         *
         */

        // 表单设计器
        UE.registerUI('button_active', function(editor, uiName){

            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function(){
                    editor.execCommand('activewidget');
                }
            });
            // 创建一个button
            const btn = new UE.ui.Button({
                // 按钮的名字
                name: uiName,
                // 提示
                title: '表单设计器 ',
                // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
                cssRules : 'background-position: -401px -40px;',
                // 点击时执行的命令
                onclick: function () {
                    // 这里可以不用执行命令,做你自己的操作也可
                   editor.execCommand(uiName);
                }
            });

            // 因为你是添加button,所以需要返回这个button
            return btn;
        });

        // 预览按钮
        UE.registerUI('button_preview', function(editor, uiName){

            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function(){
                    try {
                        editor.execCommand('preview');
                    } catch ( e ) {
                        alert('预览异常');
                    }
                }
            });
            // 创建一个button
            const btn = new UE.ui.Button({
                // 按钮的名字
                name: uiName,
                // 提示
                title: '预览',
                // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
                cssRules : 'background-position: -420px -19px;',
                // 点击时执行的命令
                onclick: function () {
                    // 这里可以不用执行命令,做你自己的操作也可
                   editor.execCommand(uiName);
                }
            });

            // 因为你是添加button,所以需要返回这个button
            return btn;
        });

        // 保存按钮
        UE.registerUI('button_save', function(editor, uiName){

            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function(){
                    try {
                        editor.execCommand('save');
                    } catch ( e ) {
                        alert('保存异常');
                    }
                }
            });
            // 创建一个button
            const btn = new UE.ui.Button({
                // 按钮的名字
                name: uiName,
                // 提示
                title: '保存表单',
                // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
                cssRules: 'background-position: -481px -20px;',
                // 点击时执行的命令
                onclick: function () {
                    // 这里可以不用执行命令,做你自己的操作也可
                   editor.execCommand(uiName);
                }
            });

            // 因为你是添加button,所以需要返回这个button
            return btn;
        });



		//  外链接
        UE.registerUI('button_outlink', function(editor, uiName){

          // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
          editor.registerCommand(uiName, {
              execCommand: function(){
                  try {
                      editor.execCommand('outlink');
                  } catch ( e ) {
                      alert('外链接异常');
                  }
              }
          });
          // 创建一个button
          const btn = new UE.ui.Button({
              // 按钮的名字
              name: uiName,
              // 提示
              title: '外链接',
              // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
              cssRules : 'background-position: -500px 0;',
              // 点击时执行的命令
              onclick: function () {
                  // 这里可以不用执行命令,做你自己的操作也可
                 editor.execCommand(uiName);
              }
          });

          // 因为你是添加button,所以需要返回这个button
          return btn;
      });






    }

    exec(data: any) {
        /*
         * 执行 page-editor 模块的方法，实现点击按钮的操作
         *
         */
        this.editor.Instance.execCommand(data);
    }
    setHtml(){
      var html="";
      this.editor.Instance.setContent(html);
    }
    setGlc(){
      var html=`<input name="leipiNewField" type="text" title="管理条控件" value="管理 - 控件" leipiplugins="glc" nodeid="`+this.nodeId+`" classname="`+this.nodeName+`" style="width: 80px;height: 30px;">`;
      this.editor.Instance.setContent(html,true);
    }
    setMyPlugins(tag){
      var html="";
      switch (tag){
          case "uid":
          html=`<span class="pl_userid">用户ID</span>`;
          break;
        case "wxgrouptag":
          html=`<input name="leipiNewField" type="text" title="微信分组标签" value="微信分组标签" leipiplugins="wxgrouptag" style="width: 90px;height: 30px;">`;
          break;
        case "username":
          html=`<span class="pl_username">用户名</span>`;
          break;
        case "userface":
          // html=`<img class="pl_userface" src="../assets/ueditor/formdesign/self/icon/userface.png">`;
		  html=`<img class="pl_userface" src="/editor/assets/ueditor/formdesign/self/icon/userface.png">`;
          break;
        case "classifymg":
          html=`<iframe name="frclassifymg" id="frclassifymg" src="/classifymg" width="100%" height="100%" scrolling="no" frameborder="0" align=""></iframe>`;
          break;
        case "newclassifymg":
          html=`<iframe name="newclassifymg" id="newclassifymg" src="/newclassifymg" width="100%" height="100%" scrolling="no" frameborder="0" align=""></iframe>`;
          break;
        case "jobview":
          html=`<iframe name="frclassifymg" id="frclassifymg" src="/jobview" width="100%" height="100%" scrolling="no" frameborder="0" align=""></iframe>`;
          break;
        case "jobrow":
          html=`<table id="plujobrow"><tr><td>组织</td><td>加入时间：2018-10-18</td></tr></table>`;
          break;
        case "job":
          //<input type='hidden' name='swPowerJob' value=''>
          html=`<div class="swjoblist"></div><span id='getPowerJobInfo'>点击选择机构</span>`;
          break;
        case "role":
          //<input type='hidden' name='swPowerRole' value=''>
          html=`<div class="swrolelist"></div><span id='getPowerRoleInfo'>点击选择角色</span>`;
          break;
        case "roleuser":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<div class="swroleuserlist"></div><span id='getPowerRoleUserInfo'>点击选择角色用户</span>`;
          break;
        case "richtext":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<div class="richtextlist"></div><span id='richTextUserInfo'>富文本框</span>`;
          break;
        case "wxlist":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<div id="wx_msglist">
                    <div class="wx_list_block">
                      <div class="wx_list_conent">
                          <div class="wx_list_label wx_list_msgflag4">年级通知</div>
                          <div class="wx_list_right">
                              <h1>测试</h1>
                              <div class="wx_list_con">信息内容</div>
                              <div class="wx_list_user"><em>管理员老师</em><em>2018-07-03 14:23</em></div>
                          </div>
                      </div>
                    </div>
                </div>`;
          break;
        case "frmSubmit":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<span class="frm-submit btn btn-success">提交</span>`;
          break;
        case "frmEdit":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<span class="frm-edit btn btn-info">编辑</span>`;
          break;
        case "frmReset":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<span class="frm-rest btn btn-default">重置</span>`;
          break;
        case "frmSearch":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<span class="frm-search btn btn-default">搜索</span>`;
          break;
        case "recordinfo":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<div id="recordinfo">记录报告</div>`;
          break;
        case "integral":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<span class="totalIntegral">总积分</span>`;
          break;
        case "meetinglist":
          //<input type='hidden' name='swPowerRoleUser' value=''>
          html=`<div class="meetinglist">会议记录内容</div>`;
          break;
      }
      if(html!='')this.editor.Instance.execCommand( 'insertHtml',html);
    }

    public setContent(content: string) {
        /*
         * 执行 page-editor 模块的方法，插入用户模板内容
         *
         */
        this.editor.Instance.setContent(content);
    }

    toggleShow() {
        /*
         * 隐藏/显示 编辑器 - 点击按钮
         *
         */
        this.toggle ? this.editor.Instance.setHide() : this.editor.Instance.setShow();
        this.toggle ? this.toggleValue = '显示' : this.toggleValue = '隐藏';
        this.toggle = !this.toggle;
    }

    changeEditor() {
        /*
         * 手机/电脑版编辑 - 点击按钮
         *
         */
        let saveConfirm = true;
        if ( this.editor.Instance.hasContents() ) {
            saveConfirm = confirm('请确认是否已经保存数据！');
        }

        if ( saveConfirm ) {
            this.toggleVersion ? this.versionEditor = '电脑' : this.versionEditor = '手机';
            this.toggleVersion = !this.toggleVersion;
            sessionStorage.setItem('editorcontent', this.editor.Instance.getContent());
        }

        if ( !this.toggleVersion ) {
            sessionStorage.setItem('editorStyle', 'phone');
            $('.ueditor-textarea.edui-default').addClass('phone').addClass(this.nowSelect);
        } else {
            sessionStorage.setItem('editorStyle', 'pc');
            $('.ueditor-textarea.edui-default').removeClass('phone').removeClass(this.lastSelect);
        }

        if ( this.nodeId !== undefined ) {
			// alert("这里是手机/电脑版编辑 - 点击按钮，是吗？");
			alert("是否发布"+this.is_public);
            this.insertData.insertData(this.nodeId,this.nodeId, this.editor,this.is_public,this.page_classify,this.module_classify);
        }
    }
    changeNEditor(type) {






        /*
         * 手机/电脑版编辑 - 点击按钮
         *
         */
        let saveConfirm = true;
        if ( this.editor.Instance.hasContents() ) {
            saveConfirm = confirm('请确认是否已经保存数据！');
        }

        if ( saveConfirm ) {
            sessionStorage.setItem('editorcontent', this.editor.Instance.getContent());
            if(type=='PC'){
                this.versionEditor = '电脑';
                sessionStorage.setItem('editorStyle', 'pc');
                $('.ueditor-textarea.edui-default').removeClass('phone').removeClass(this.lastSelect);
            }else if(type=='PHONE'){
                this.versionEditor = '手机';
                sessionStorage.setItem('editorStyle', 'phone');
                $('.ueditor-textarea.edui-default').addClass('phone').addClass(this.nowSelect);
            }
            if ( this.nodeId !== undefined ) {
				// alert("这里也是手机/电脑版编辑 - 点击按钮，什么情况！！多了的type参数");
				// alert("是否发布"+this.is_public);
                this.insertData.insertData(this.nodeId,this.nodeId, this.editor,this.is_public,this.page_classify,this.module_classify);
            }
        }
    }

  changeEditor2(type) {
    this.toggleVersion=!type;
    this.toggleVersion ? this.versionEditor = '电脑' : this.versionEditor = '手机';

    if ( !this.toggleVersion ) {
      sessionStorage.setItem('editorStyle', 'phone');
      $('.ueditor-textarea.edui-default').addClass('phone').addClass(this.nowSelect);
    } else {
      sessionStorage.setItem('editorStyle', 'pc');
      $('.ueditor-textarea.edui-default').removeClass('phone').removeClass(this.lastSelect);
    }
  }

    phoneChange (e) {
        /*
         * 手机版编辑 - 选择不同的手机屏幕功能
         *
         */
        this.lastSelect = this.nowSelect;
        this.nowSelect = e.target.value;
        $('.ueditor-textarea.edui-default').addClass(this.nowSelect).removeClass(this.lastSelect);
    }

		getText() {
			console.log(this.editor.Instance.selection.getRange().cloneContents())
		}
		setPluginTool(b){
			this.swPluginTool=b;
		}
}
