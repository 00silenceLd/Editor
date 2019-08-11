webpackJsonp(["main"],{

/***/ "../../../../../src/$$_gendir lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_gendir lazy recursive";

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<app-form-manage ></app-form-manage>\r\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = (function () {
    function AppComponent() {
        this.title = 'app';
        this.approvePage = 0;
    }
    AppComponent.prototype.approveBtn = function () {
        if (this.approvePage == 0) {
            this.approvePage = 1;
        }
        else {
            this.approvePage = 0;
        }
    };
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());

//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__service_httpData_service__ = __webpack_require__("../../../../../src/app/service/httpData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_common_http__ = __webpack_require__("../../../common/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__angular_platform_browser_animations__ = __webpack_require__("../../../platform-browser/esm5/animations.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__page_editor_page_editor_component__ = __webpack_require__("../../../../../src/app/page-editor/page-editor.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__form_manage_form_manage_component__ = __webpack_require__("../../../../../src/app/form-manage/form-manage.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9_ngx_ueditor__ = __webpack_require__("../../../../ngx-ueditor/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__angular_router__ = __webpack_require__("../../../router/esm5/router.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_ng2_tree__ = __webpack_require__("../../../../ng2-tree/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_11_ng2_tree___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_11_ng2_tree__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_12__service_insertData_service__ = __webpack_require__("../../../../../src/app/service/insertData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_13__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};















var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["NgModule"])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */],
                __WEBPACK_IMPORTED_MODULE_7__page_editor_page_editor_component__["a" /* PageEditorComponent */],
                __WEBPACK_IMPORTED_MODULE_8__form_manage_form_manage_component__["a" /* FormManageComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser__["BrowserModule"],
                __WEBPACK_IMPORTED_MODULE_10__angular_router__["a" /* RouterModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_platform_browser_animations__["a" /* BrowserAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_5__angular_platform_browser_animations__["b" /* NoopAnimationsModule */],
                __WEBPACK_IMPORTED_MODULE_11_ng2_tree__["TreeModule"],
                __WEBPACK_IMPORTED_MODULE_3__angular_common_http__["a" /* HttpClientModule */],
                __WEBPACK_IMPORTED_MODULE_10__angular_router__["a" /* RouterModule */],
                __WEBPACK_IMPORTED_MODULE_4__angular_http__["c" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_13__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_9_ngx_ueditor__["b" /* UEditorModule */].forRoot({
                    // 指定ueditor.js路径目录
                    path: './assets/ueditor/',
                    // 默认全局配置项
                    options: {
                        themePath: './assets/ueditor/themes/'
                    }
                }),
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_0__service_httpData_service__["a" /* HttpDataService */], __WEBPACK_IMPORTED_MODULE_12__service_insertData_service__["a" /* InsertDataService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_6__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/form-manage/form-manage.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, ".fromPC {\r\n\tdisplay: none;\r\n}\r\n.fromPhone{\r\n\t\tdisplay: none;\r\n}\r\n\r\n/* .tree-container{\r\n\t\tdisplay: none;\r\n} */\r\n.mat-drawer-container {\r\n  height: 100%;\r\n}\r\n.tree-top-title{\r\n\twidth: 100%;\r\n\theight: 30px;\r\n\ttext-align: center;\r\n\tline-height: 30px;\r\n\tcolor: #ffffff;\r\n\tfont-size: 16px;\r\n\tbackground-color: #199ED8;\r\n}\r\n.tree-info {\r\n  -webkit-box-flex: 1;\r\n      -ms-flex: 1 0 100%;\r\n          flex: 1 0 100%;\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n  -webkit-box-align: start;\r\n      -ms-flex-align: start;\r\n          align-items: flex-start;\r\n}\r\n\r\n.tree-controlls {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n}\r\n\r\n.tree-content {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n}\r\n\r\n.tree-container {\r\n  padding:0;\r\n  float: left;\r\n  height: 100vh;\r\n  overflow: auto;\r\n}\r\n\r\n.tree-container--with-controls {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -ms-flex-wrap: wrap;\r\n      flex-wrap: wrap;\r\n}\r\n\r\n.tree-demo-app {\r\n  display: -webkit-box;\r\n  display: -ms-flexbox;\r\n  display: flex;\r\n  -webkit-box-orient: vertical;\r\n  -webkit-box-direction: normal;\r\n      -ms-flex-direction: column;\r\n          flex-direction: column;\r\n}\r\n\r\n.tree-title {\r\n  margin: 0;\r\n  color: #40a070;\r\n  font-size: 2em;\r\n}\r\n\r\n.tree-controlls button {\r\n  margin: 5px;\r\n}\r\n\r\n.formManager {\r\n  width: 100%;\r\n  height: 100vh;\r\n  overflow: hidden;\r\n}\r\n\r\n.ueditor-container {\r\n  overflow: auto;\r\n  padding: 10px 10px 0 10px;\r\n  height: 100vh;\r\n}\r\n.tree-internal .tree .folding{\r\n\twidth: 10px;\r\n}\r\n.mobileTip:before{\r\n  content: \"\\F10A\";\r\n}\r\n.pcTip:before{\r\n  content: \"\\F108\";\r\n}\r\n/*登录*/\r\n#editUserAccount{\r\n  position:fixed;\r\n  width: 100%;\r\n  height: 100%;\r\n  left: 0px;\r\n  top: 0px;\r\n  z-index: 9999;\r\n  background-color: #f5f0f0;\r\n}\r\n#editUserAccountMsg{\r\n  height: 36px;\r\n  line-height: 36px;\r\n  background-color: #86929e;\r\n  color: #FFFFFF;\r\n  padding-left: 10px;\r\n}\r\n#editUserAccountAre{\r\n  position: relative;\r\n  width: 500px;\r\n  height: auto;\r\n  overflow: hidden;\r\n  padding: 15px;\r\n  left: 50%;\r\n  margin-left: -250px;\r\n}\r\n.useraccounterrmsg{\r\n  color: #ff0000;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/form-manage/form-manage.component.html":
/***/ (function(module, exports) {

module.exports = "<div id=\"editUserAccount\" *ngIf=\"isAccount\">\r\n  <div id=\"editUserAccountMsg\">只允许内部账号登录,新员工注册后找编辑器程序员开通</div>\r\n  <div id=\"editUserAccountAre\">\r\n    <form>\r\n      <div class=\"form-group\">\r\n        <label for=\"useraccount\">User Account</label>\r\n        <input type=\"text\" class=\"form-control\" id=\"useraccount\" name=\"useraccount\" [(ngModel)]=\"useraccount\"\r\n          placeholder=\"account\">\r\n      </div>\r\n      <div class=\"form-group\" *ngIf=\"isRegAccount\">\r\n        <label for=\"ChineseName\">Chinese Name</label>\r\n        <input type=\"text\" class=\"form-control\" id=\"ChineseName\" name=\"chinesename\" [(ngModel)]=\"chinesename\"\r\n          placeholder=\"account\">\r\n      </div>\r\n      <div class=\"form-group\">\r\n        <label for=\"userpassword\">Password</label>\r\n        <input type=\"password\" class=\"form-control\" id=\"userpassword\" name=\"userpassword\" [(ngModel)]=\"userpassword\"\r\n          placeholder=\"Password\">\r\n      </div>\r\n      <div class=\"form-group\" *ngIf=\"isRegAccount\">\r\n        <label for=\"userrepassword\">Confirm Password</label>\r\n        <input type=\"password\" class=\"form-control\" id=\"userrepassword\" name=\"userrepassword\" [(ngModel)]=\"userrepassword\"\r\n          placeholder=\"Confirm Password\">\r\n      </div>\r\n      <span class=\"btn btn-default\" (click)=\"doAccount()\" *ngIf=\"!isRegAccount\">登录系统</span><span class=\"btn btn-default\"\r\n        (click)=\"regAccount()\" *ngIf=\"isRegAccount\">注册新账号</span>\r\n      <a href=\"javascript:void();\" (click)=\"setRegAccount(true)\" *ngIf=\"!isRegAccount\">注册新账号</a>\r\n      <a href=\"javascript:void();\" (click)=\"setRegAccount(false)\" *ngIf=\"isRegAccount\">去登录</a>\r\n      <div class=\"form-group\">\r\n        <span class=\"useraccounterrmsg\">{{userAccountErrMsg}}</span>\r\n      </div>\r\n    </form>\r\n  </div>\r\n</div>\r\n<div class=\"formManager\" ng-if=\"!isAccount\">\r\n\r\n\r\n  <div class=\"tree-container\">\r\n    <div class=\"tree-content\">\r\n      <div class=\"tree-top-title\">胜网程序编辑</div>\r\n      <!-- <iframe src=\"https://www.layui.com\" width=\"500\" height=\"500\"></iframe> -->\r\n      <tree #treePages [tree]=\"tree\" (menuItemSelected)=\"onMenuItemSelected($event)\" [settings]=\"settings\" (nodeMoved)=\"handleMoved($event)\"\r\n        (nodeRenamed)=\"handleRenamed($event)\" (nodeRemoved)=\"handleRemoved($event)\" (nodeSelected)=\"handleSelected($event)\"\r\n        (nodeCreated)=\"handleCreated($event)\">\r\n      </tree>\r\n    </div>\r\n  </div>\r\n  <div class=\"ueditor-container\">\r\n    <app-page-editor [nodeType]=\"node_type\" [node_id]=\"node_id\" [nodeName]=\"node_name\" [nodeParentId]=\"node_parentId\"\r\n      [nodeParentId2x]=\"node_parentId2x\" [isPublic]=\"is_public\" [is_approve]=\"is_approve\" [page_classify]=\"\r\n      page_classify\" [module_classify]=\"module_classify\"></app-page-editor>\r\n  </div>\r\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/form-manage/form-manage.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return FormManageComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng2_tree__ = __webpack_require__("../../../../ng2-tree/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng2_tree___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_ng2_tree__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__service_httpData_service__ = __webpack_require__("../../../../../src/app/service/httpData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__service_insertData_service__ = __webpack_require__("../../../../../src/app/service/insertData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__page_editor_page_editor_component__ = __webpack_require__("../../../../../src/app/page-editor/page-editor.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var theTree = {
    value: '您好,看到这里..',
    id: 9999,
    settings: {
        cssClasses: {
            expanded: 'fa fa-caret-down',
            collapsed: 'fa fa-caret-right',
            empty: 'fa fa-caret-right disabled',
            leaf: 'fa'
        },
        templates: {
            /* node: '<i class="fa fa-folder-o pcTip"></i>',*/
            node: '<i class="fa fa-desktop"></i>',
            leaf: '<i class="fa fa-file-o"></i>'
        }
    },
    children: [
        {
            value: '就证明了..', id: 9999, settings: {
                cssClasses: {
                    expanded: 'fa fa-caret-down',
                    collapsed: 'fa fa-caret-right',
                    empty: 'fa fa-caret-right disabled',
                    leaf: 'fa'
                },
                templates: {
                    node: '<i class="fa fa-mobile"></i>',
                    leaf: '<i class="fa fa-file-o"></i>'
                }
            }, children: [
                { value: '你的树节点为空..', id: 9999 }
            ]
        },
        { value: '所以我们显示这个提醒您 :)', id: 9999 }
    ]
};
var FormManageComponent = (function () {
    function FormManageComponent(http, httpData, insertData) {
        this.http = http;
        this.httpData = httpData;
        this.insertData = insertData;
        this.node_level = 1; // 节点的 Level
        this.node_type = 7; //7pc 端 fa-desktop  8手机端 fa-mobile
        this.isAccount = true;
        this.isRegAccount = false;
        this.useraccount = '';
        this.chinesename = '';
        this.userpassword = '';
        this.userrepassword = '';
        this.settings = {
            rootIsVisible: true
        };
        this.userinfo = window.localStorage['user'] ? JSON.parse(window.localStorage['user']) : null;
        this.uaccount = window.sessionStorage['useraccount'] ? window.sessionStorage['useraccount'] : null;
        this.headers = null;
        this.options = null;
        this.nodeMenuItem = [
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '新建PC发布页', cssClass: 'fa fa-cog fa-desktop' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '新建PC浏览页', cssClass: 'fa fa-cog fa-desktop' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '新建手机发布页', cssClass: 'fa fa-cog fa-mobile' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '新建手机浏览页', cssClass: 'fa fa-cog fa-mobile' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '-----------', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '新建PC推广页', cssClass: 'fa fa-cog fa-adn' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '新建手机推广页', cssClass: 'fa fa-cog fa-adn' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '-----------', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '导入页', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '-----------', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '配置节点', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '更新', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '下载站点', cssClass: 'fa fa-cog' },
            /* { action: NodeMenuItemAction.Custom, name: '设为首页', cssClass: 'fa fa-cog' }, */
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '设为PC页', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '设为手机页', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Custom, name: '-----------', cssClass: 'fa fa-cog' },
            { action: __WEBPACK_IMPORTED_MODULE_2_ng2_tree__["NodeMenuItemAction"].Rename, name: '重命名', cssClass: 'rename' }
            /* { action: NodeMenuItemAction.Remove, name: '删除', cssClass: 'remove' } */
            /*{ action: NodeMenuItemAction.Custom, name: '-----------', cssClass: 'fa fa-cog' },
           { action: NodeMenuItemAction.Custom, name: '新建项目', cssClass: 'fa fa-file-o' },
           { action: NodeMenuItemAction.NewTag, name: '新建文件', cssClass: 'fa fa-file-o' },
           { action: NodeMenuItemAction.NewFolder, name: '新建文件夹', cssClass: 'fa fa-folder-o' }*/
        ];
        // 	nodeMenuItem2 = [  // 曾智宏二次修改
        // 	 { [{action: NodeMenuItemAction.Custom, name: '新建PC网页', cssClass: 'fa fa-cog fa-desktop'},
        // 	 { action: NodeMenuItemAction.Custom, name: '发布页', cssClass: 'fa fa-cog fa-desktop' },
        // 	 { action: NodeMenuItemAction.Custom, name: '浏览页', cssClass: 'fa fa-cog fa-mobile' }]}
        //   ];
        this.tree = theTree;
        if (this.userinfo == null || this.userinfo == undefined || this.userinfo.token == '' || this.userinfo.token == undefined) {
            window.localStorage.removeItem('user');
            if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
                window.parent.location.href = '/mobile/tpl/login';
            }
            else {
                window.parent.location.href = '/login2';
            }
        }
        this.headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Headers */]({ 'Content-type': 'application/json; charset=UTF-8', 'Access-Control-Allow-Origin': "*", 'token': this.userinfo.token });
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* RequestOptions */]({ headers: this.headers });
    }
    FormManageComponent.prototype.ngOnInit = function () {
        if (this.userinfo == null || this.userinfo == undefined || this.userinfo.token == '' || this.userinfo.token == undefined) {
            window.localStorage.removeItem('user');
            if (/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
                window.parent.location.href = '/mobile/tpl/login';
            }
            else {
                window.parent.location.href = '/login2';
            }
            return false;
        }
        if (this.uaccount == null) {
            this.isAccount = true;
        }
        else {
            this.isAccount = false;
            this.getTreeNode();
            this.getDatasourceNode();
        }
    };
    FormManageComponent.prototype.ajax = function (method, dataObj) {
        var _this = this;
        /*
         * 统一请求的接口
         *
         */
        var url, data;
        if (method === 'add') {
            url = this.httpData.Manage_HOST + this.control_Url + '/addTreeNode';
            data = [{
                    'value': this.node_name,
                    'node_level': this.node_level,
                    'parent_id': this.node_parentId,
                    'isFolder': this.isFolder,
                    'is_slave_page': 0
                }];
        }
        else if (method === 'addProject') {
            url = this.httpData.Manage_HOST + this.control_Url + '/addTreeNode';
            data = [{
                    'value': this.node_name,
                    'node_level': this.node_level,
                    'parent_id': this.node_parentId,
                    'isFolder': this.isFolder,
                    'node_type': 1,
                    'is_slave_page': 0
                }];
        }
        else if (method === 'addPage') {
            url = this.httpData.Manage_HOST + this.control_Url + '/addTreeNode';
            data = [{ value: this.node_name, node_level: this.node_level, parent_id: this.node_parentId, isFolder: this.isFolder, node_type: this.node_type, createrUid: this.userinfo.id, is_public: this.is_public, is_approve: this.is_approve, is_popularize: this.is_popularize, page_classify: this.page_classify, module_classify: this.module_classify,
                    is_slave_page: 0 }];
        }
        else if (method === 'removed') {
            //url = this.httpData.Manage_HOST + this.control_Url + '/deleteTreeNode';
            url = this.httpData.Editor_96HOST + 'htNodeService/delUserHasNode';
            data = dataObj;
        }
        else if (method === 'rename' || method === 'updataUrl') {
            url = this.httpData.Manage_HOST + this.control_Url + '/updateTreeNode';
            data = dataObj;
        }
        else if (method === 'setSite') {
            //http://1388w.cn:20890/nodeOperatorFacade/herdNodeOperatorFacade/ setSite  herdNodeOperatorFacade/ setSite
            url = this.httpData.Manage_HOST + 'herdNodeOperatorFacade/setSite';
            data = dataObj;
        }
        else if (method === 'changeNodetype') {
            url = this.httpData.Manage_HOST + 'herdNodeOperatorFacade/changeNodetype';
            data = dataObj;
        }
        else {
            url = this.httpData.Manage_HOST + this.control_Url + '/upTreeNode';
            data = {
                'id': this.node_id,
                'parent_id': this.node_parentId,
                'node_sore': this.node_sore,
                'node_sore1': this.newNode_sore
            };
        }
        if (method == 'addPage' || method == 'addProject' || method == 'add') {
            //
            //return false;
        }
        if (method == 'removed') {
            //
            //return false;
        }
        this.http.post(url, JSON.stringify(data), this.options)
            .map(function (res) { return res.json(); })
            .subscribe(function (res) {
            console.log(res);
            if (method === 'rename' || method === 'add' || method === 'addProject' || method === 'addPage') {
                _this.getTreeNode();
            }
            else if (method === 'setSite') {
                //localStorage.setItem("setSiteid",dataObj.node_id);
            }
            else if (method === 'changeNodetype') {
                //localStorage.setItem("setSiteid",dataObj.node_id);
                alert(res.msg);
            }
        });
    };
    FormManageComponent.prototype.getTreeNode = function () {
        /*
         * 获取树形节点
         *
         */
        //let url = 'nodeQueryFacade/getTreeNode';
        //window.localStorage['user']?JSON.parse(window.localStorage['user']):null;
        var _this = this;
        // ???
        var url = 'nodeQueryFacade/getTreeNodeByUid?uId=' + this.userinfo.id;
        this.control_Url = 'nodeOperatorFacade';
        var search = window.location.search;
        if (search !== '' && search.split('?')[1] === 'workbench') {
            this.control_Url = 'herdNodeOperatorFacade';
            url = 'herdNodeQueryFacade/getTreeNode';
            console.log(this.control_Url);
        }
        console.log(this.control_Url);
        this.http.get(this.httpData.Manage_HOST + url)
            .map(function (res) { return res.json(); })
            .subscribe(function (data) {
            var nodes = data['msg'];
            if (nodes.msg !== null) {
                // var nodeshtml='<option value="0:请选择">请选择</option>';
                // nodeshtml+=this.doAllNodes(nodes.children,0);
                // window.localStorage.setItem('datasource_'+this.userinfo.id,nodeshtml);
                // 删除文件夹
                _this.deleteChild(nodes.children);
                // 还有三个Settings在后端设置了, 1. 折叠 2. 样式 3. 图标(节点名称前的图标) fa-television
                // 具体 树形 还有什么设置的，可以参考 ng2-tree-master 源码进行参考..tablet
                nodes.settings.menuItems = _this.nodeMenuItem;
                // nodes.settings.menuItems = this.nodeMenuItem2;
                //nodes.settings.templates={node: '<i class="fa fa-tablet"></i> <i class="fa fa-sitemap"></i>'};
                _this.tree = nodes;
            }
            else {
                alert(nodes.statusMsg); // 报出错误信息
            }
        });
    };
    /**
     * 数据源设置
     */
    FormManageComponent.prototype.getDatasourceNode = function () {
        /*
         * 获取数据节点
         *
         */
        //let url = 'nodeQueryFacade/getTreeNode';
        //window.localStorage['user']?JSON.parse(window.localStorage['user']):null;
        var _this = this;
        var url = 'nodeQueryFacade/getDataSourceByUid?uId=' + this.userinfo.id;
        this.http.get(this.httpData.Manage_HOST + url)
            .map(function (res) { return res.json(); })
            .subscribe(function (data) {
            var nodes = data['msg'];
            if (nodes.msg !== null) {
                var nodeshtml = '';
                //var arr=nodes.msg;
                for (var i = 0; i < nodes.length; i++) {
                    nodeshtml += '<option value=' + nodes[i].id + ':' + nodes[i].value + '>' + nodes[i].value + '</option>';
                }
                window.localStorage.setItem('datasource_' + _this.userinfo.id, nodeshtml);
            }
            else {
                alert(nodes.statusMsg); // 报出错误信息
            }
        });
    };
    FormManageComponent.prototype.doAllNodes = function (arr, level) {
        var html = '';
        var levelstr = '';
        for (var j = 0; j < level; j++) {
            levelstr += '----';
        }
        for (var i = 0; i < arr.length; i++) {
            html += '<option value=' + arr[i].id + ':' + arr[i].value + '>' + levelstr + arr[i].value + '</option>';
            if (arr[i].children.length > 0) {
                html += this.doAllNodes(arr[i].children, level + 1);
            }
        }
        return html;
    };
    FormManageComponent.prototype.deleteChildBak = function (obj) {
        /*
         * 用途：区分文件夹和文件
         * 操作：If 节点没有children 删除该字段
         */
        var length;
        obj.length === undefined ? length = 1 : length = obj.length;
        for (var i = 0; i < length; i++) {
            var objChild = void 0;
            var isFirstFlag = void 0;
            obj[i] === undefined ? objChild = obj.children : objChild = obj[i].children;
            obj[i] === undefined ? isFirstFlag = true : isFirstFlag = false;
            if (objChild.length === 0) {
                isFirstFlag ? delete obj.children : delete obj[i].children;
            }
            else {
                this.deleteChildBak(objChild);
            }
        }
    };
    FormManageComponent.prototype.deleteChild = function (obj) {
        /*
         * 判断传过来的 isFolder 是不是 为true
         * 不是则是 文件夹，删除isFolder
         *
         */
        if (obj !== null) {
            for (var i = 0; i < obj.length; i++) {
                if (!obj[i].isFolder) {
                    delete obj[i].children;
                }
                else {
                    if (obj[i].children.length > 0) {
                        this.deleteChild(obj[i].children);
                    }
                }
            }
        }
    };
    FormManageComponent.prototype.onMenuItemSelected = function (e) {
        /*
         * 配置 Custom 的按钮的操作
         * 根据 name 的不一样，执行不同的操作
         */
        var node = e.node.node;
        switch (e.selectedItem) {
            case '配置节点':
                var url = prompt('请输入您需要配置的Url', 'http://');
                node.url = url;
                this.ajax('updataUrl', node);
                break;
            case '新建项目':
                var projectName = prompt('请输入您的项目名称');
                if (projectName !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = projectName;
                    this.ajax('addProject');
                }
                else {
                    alert('一定要输入项目名称哦~');
                }
                break;
            //       case '新建PC网页':
            //         let pcName = prompt('请输入您的PC页面名');
            //         if (pcName !== null) {
            //           if (e.node.parent === null) {
            //             this.node_level = 0;
            //           } else {
            //             this.findLevel(e.node.parent);
            //           }
            //           this.node_parentId = e.node.id;
            //           this.isFolder = true;
            //           this.node_name = pcName;
            //           this.node_type = 7;
            //           this.ajax('addPage');
            //         } else {
            //           alert('一定要输入页面名哦~');
            //         }
            //         break;
            //       case '新建手机页':
            //
            //         let mName = prompt('请输入您的手机页面名');
            //
            //         if (mName !== null) {
            //           if (e.node.parent === null) {
            //             this.node_level = 0;
            //           } else {
            //             this.findLevel(e.node.parent);
            //           }
            //           this.node_parentId = e.node.id;
            //           this.isFolder = true;
            //           this.node_name = mName;
            //           this.node_type = 8;
            //           this.ajax('addPage');
            //         } else {
            //           alert('一定要输入页面名哦~');
            //         }
            //         break;
            /*曾智宏*/
            case '新建PC发布页':
                var pcName = prompt('请输入您的PC页面名');
                if (pcName !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = pcName;
                    this.node_type = 7;
                    this.is_public = 0; //曾智宏
                    this.is_approve = 0; //曾智宏,未审核
                    this.is_popularize = 1; //0为推广页，1为非推广
                    this.page_classify = 1;
                    this.module_classify = 1;
                    this.ajax('addPage');
                }
                else {
                    alert('一定要输入页面名哦~');
                }
                break;
            case '新建手机发布页':
                var mName = prompt('请输入您的手机页面名');
                if (mName !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = mName;
                    this.node_type = 8;
                    this.is_public = 0; //曾智宏
                    this.is_approve = 0; //曾智宏,未审核
                    this.is_popularize = 1; //0为推广页，1为非推广
                    this.page_classify = 1;
                    this.module_classify = 1;
                    this.ajax('addPage');
                }
                else {
                    alert('一定要输入页面名哦~');
                }
                break;
            case '新建PC浏览页':
                var pcName2 = prompt('请输入您的PC页面名');
                if (pcName !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = pcName2;
                    this.node_type = 7;
                    this.is_public = 1; //曾智宏
                    this.is_approve = 0; //曾智宏,未审核
                    this.is_popularize = 1; //0为推广页，1为非推广
                    this.page_classify = 1;
                    this.module_classify = 1;
                    this.ajax('addPage');
                }
                else {
                    alert('一定要输入页面名哦~');
                }
                break;
            case '新建手机浏览页':
                var mName2 = prompt('请输入您的手机页面名');
                if (mName !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = mName2;
                    this.node_type = 8;
                    this.is_public = 1; //曾智宏
                    this.is_approve = 0; //曾智宏,未审核
                    this.is_popularize = 1; //0为推广页，1为非推广
                    this.page_classify = 1;
                    this.module_classify = 1;
                    this.ajax('addPage');
                }
                else {
                    alert('一定要输入页面名哦~');
                }
                break;
            case '新建PC推广页':
                var pcName3 = prompt('请输入您的PC页面名');
                if (pcName3 !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = pcName3;
                    this.node_type = 7;
                    // this.is_public = 0;//曾智宏
                    this.is_approve = 0; //曾智宏,未审核
                    this.is_popularize = 0; //0为推广页，1为非推广
                    this.page_classify = 1;
                    this.module_classify = 1;
                    this.ajax('addPage');
                }
                else {
                    alert('一定要输入页面名哦~');
                }
                break;
            case '新建手机推广页':
                var mName3 = prompt('请输入您的手机页面名');
                if (mName3 !== null) {
                    if (e.node.parent === null) {
                        this.node_level = 0;
                    }
                    else {
                        this.findLevel(e.node.parent);
                    }
                    this.node_parentId = e.node.id;
                    this.isFolder = 1;
                    this.node_name = mName3;
                    this.node_type = 8;
                    // this.is_public = 0;//曾智宏
                    this.is_approve = 0; //曾智宏,未审核
                    this.is_popularize = 0; //0为推广页，1为非推广
                    this.page_classify = 1;
                    this.module_classify = 1;
                    this.ajax('addPage');
                }
                else {
                    alert('一定要输入页面名哦~');
                }
                break;
            /*曾智宏*/
            case '更新':
                if (node.parent_id == 3) {
                    var url_1 = this.httpData.Manage_HOST + 'nodeOperatorFacade/updateNodeSite?nodeId=' + node.id;
                    this.http.get(url_1)
                        .map(function (res) { return res.json(); })
                        .subscribe(function (data) {
                        if (data.status == 0) {
                            alert("更新完成"); // 报出错误信息
                        }
                        else {
                            alert("目前站点没有内容哦..."); // 报出错误信息
                        }
                    });
                    //window.open(url,"下载站点");
                }
                else {
                    alert('一定要主节点才需要更新哦~');
                }
                break;
            case '下载站点':
                if (node.parent_id == 3) {
                    var url_2 = this.httpData.Manage_HOST + 'nodeOperatorFacade/packSite?nodeId=' + node.id;
                    this.http.get(url_2)
                        .map(function (res) { return res.json(); })
                        .subscribe(function (data) {
                        var nodes = data['msg'];
                        if (nodes !== null) {
                            window.open(nodes, "下载站点");
                        }
                        else {
                            alert("目前站点没有内容哦..."); // 报出错误信息
                        }
                    });
                }
                else {
                    alert('一定要主节点才能下载哦~');
                }
                break;
            case '设为首页':
                var type = node.node_type > 7 ? 0 : 1;
                var domain = "/editor/assets/ueditor/formdesign/preview.html?link=" + node.id;
                var dataObj = { 'node_id': node.id, 'site_id': '6', "is_pc": type, "domain": domain };
                this.ajax('setSite', dataObj);
                break;
            case '设为PC页':
                var dataObjpc = { 'node_id': node.id, "node_type": 7 };
                this.ajax('changeNodetype', dataObjpc);
                break;
            case '设为手机页':
                var dataObjiphone = { 'node_id': node.id, "node_type": 8 };
                this.ajax('changeNodetype', dataObjiphone);
                break;
            default:
                break;
        }
    };
    FormManageComponent.prototype.handleSelected = function ($event) {
        // alert("这里是树形点击选择操作，位于form-manage的类文件")
        /*
         * 树形点击选择操作
         *
         */
        this.node_id = $event.node.node.id;
        this.node_type = $event.node.node.node_type;
        this.node_name = $event.node.node.value;
        this.is_public = $event.node.node.is_public; //曾智宏
        this.is_approve = $event.node.node.is_approve; //曾智宏
        this.page_classify = $event.node.node.page_classify;
        this.module_classify = $event.node.node.module_classify;
        if ($event.node.parent) {
            $event.node.parent.parent !== null ? this.node_parentId2x = $event.node.parent.parent.id : this.node_parentId2x = $event.node.parent.id;
        }
        else {
            this.node_parentId2x = $event.node.id;
        }
        if ($event.node.parent) {
            this.node_parentId = $event.node.parent.node.id;
        }
        this.editor.changeEditor2(this.node_type == 8);
        sessionStorage.setItem('editorcontent', '');
        this.insertData.insertData(this.node_id, this.node_type, this.editor.editor, this.is_public, this.page_classify, this.module_classify);
    };
    FormManageComponent.prototype.handleCreated = function ($event) {
        /*
         * 树形新建文件操作
         *
         */
        console.log($event);
        this.isFolder = $event.node._children !== null ? 1 : 0;
        this.node_parentId = $event.node.parent.node.id;
        this.node_name = $event.node.value;
        this.tree_id = $event.node.node.id;
        this.findLevel($event.node.parent);
        this.ajax('add');
    };
    FormManageComponent.prototype.handleRemoved = function ($event) {
        /*
         * 树形删除操作
         *
         */
        console.log(confirm("确定删除？"));
        if (!confirm("确定删除？"))
            return false;
        var dataObj = { "uId": this.userinfo.id, "nodeId": $event.node.node.id };
        console.log(dataObj);
        this.ajax('removed', dataObj);
        /*const dataObj = $event.node.node;
        delete dataObj.createTime;
        delete dataObj.settings;
        console.log('removed stard');
        if($event.lastIndex!=0)console.log($event);
        console.log('removed end');
        this.ajax('removed', dataObj);*/
    };
    FormManageComponent.prototype.handleRenamed = function ($event) {
        /*
         * 树形重命名操作
         *
         */
        var dataObj = $event.node.node;
        delete dataObj.createTime;
        delete dataObj.settings;
        this.ajax('rename', dataObj);
    };
    FormManageComponent.prototype.handleSetSite = function ($event) {
        /*
         * 树形重命名操作
         *
         */
        var dataObj = $event.node.node;
        delete dataObj.createTime;
        delete dataObj.settings;
        console.log(dataObj);
        this.ajax('setSite', dataObj);
    };
    FormManageComponent.prototype.handleMoved = function ($event) {
        /*
         * 树形移动节点操作
         * BUG. 暂时不能跨级拖动，他跨级拖动的时候会执行 remove 然后再 move，询问github作者没果，暂没解决办法
         */
        console.log("moved stard");
        console.log($event);
        console.log("moved end");
        /*this.node_id = $event.node.node.id;
        this.node_parentId = $event.node.parent.id;
        this.node_sore = $event.node.node.node_sore;
        this.newNode_sore = $event.node.positionInParent;
        this.ajax('moved');*/
        this.node_parentId = $event.node.parent.id;
        this.ajax('upTreeNode');
    };
    FormManageComponent.prototype.findLevel = function (obj) {
        /*
         * 新建文件有用的，查找当前是第几层级。
         *
         */
        if (obj.parent === null) {
            this.node_level = this.node_level;
        }
        else {
            this.node_level++;
            this.findLevel(obj.parent);
        }
    };
    FormManageComponent.prototype.clearAccount = function () {
        this.useraccount = '';
        this.userpassword = '';
        this.chinesename = '';
        this.userrepassword = '';
    };
    FormManageComponent.prototype.doAccount = function () {
        var _this = this;
        if (this.useraccount == '' || this.userpassword == '') {
            this.userAccountErrMsg = this.useraccount;
            return;
        }
        var url, data;
        url = this.httpData.Manage_HOST + "pageDesignQueryFacade/logWebShell";
        data = {
            "username": this.useraccount,
            "password": this.userpassword
        };
        this.clearAccount();
        this.http.post(url, JSON.stringify(data), this.options)
            .map(function (res) { return res.json(); })
            .subscribe(function (res) {
            if (res.status == '200') {
                _this.isAccount = false;
                window.sessionStorage.setItem('useraccount', res.msg.name);
                _this.getTreeNode();
            }
            else {
                _this.userAccountErrMsg = res.statusMsg;
            }
        });
    };
    FormManageComponent.prototype.regAccount = function () {
        var _this = this;
        if (this.useraccount == '' || this.userpassword == '' || this.chinesename == '') {
            this.userAccountErrMsg = "账号、密码、中名名称不能为空";
            return;
        }
        if (this.userrepassword == '' || this.userpassword == '') {
            this.userAccountErrMsg = "二次输入密码不一致";
            return;
        }
        var url, data;
        url = this.httpData.Manage_HOST + "pageDesignQueryFacade/registerWebShell";
        data = {
            "username": this.useraccount,
            "password": this.userpassword,
            "chinesename": this.chinesename
        };
        this.clearAccount();
        this.http.post(url, JSON.stringify(data), this.options)
            .map(function (res) { return res.json(); })
            .subscribe(function (res) {
            if (res.status === '200') {
                alert(res.statusMsg);
            }
            else {
                _this.userAccountErrMsg = res.statusMsg;
            }
        });
    };
    FormManageComponent.prototype.setRegAccount = function (b) {
        this.isRegAccount = b;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])('treePages'),
        __metadata("design:type", Object)
    ], FormManageComponent.prototype, "treePage", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_6__page_editor_page_editor_component__["a" /* PageEditorComponent */]),
        __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_6__page_editor_page_editor_component__["a" /* PageEditorComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_6__page_editor_page_editor_component__["a" /* PageEditorComponent */]) === "function" && _a || Object)
    ], FormManageComponent.prototype, "editor", void 0);
    FormManageComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-form-manage',
            template: __webpack_require__("../../../../../src/app/form-manage/form-manage.component.html"),
            styles: [__webpack_require__("../../../../../src/app/form-manage/form-manage.component.css")]
        }),
        __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_4__service_httpData_service__["a" /* HttpDataService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__service_httpData_service__["a" /* HttpDataService */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_5__service_insertData_service__["a" /* InsertDataService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_5__service_insertData_service__["a" /* InsertDataService */]) === "function" && _d || Object])
    ], FormManageComponent);
    return FormManageComponent;
    var _a, _b, _c, _d;
}());

//# sourceMappingURL=form-manage.component.js.map

/***/ }),

/***/ "../../../../../src/app/page-editor/page-editor.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "/* @import '~/assets/ueditor/formdesign/bootstrap/css/bootstrap-latest.css'; */\r\n\r\n.public{\r\n\tdisplay: none;\r\n}\r\n.noPublic{\r\n\t\tdisplay: none;\r\n\t\r\n}\r\n\r\n\r\n\r\n.well{\r\n    padding: 0 10px 10px 10px;\r\n    padding-top: 0px;\r\n}\r\n.well .btn{\r\n    margin-top: 10px;\r\n}\r\nbutton img{\r\n    width: 15px;\r\n    margin-right: 5px;\r\n    margin-top: -3px;\r\n}\r\n.btn-info {\r\n    background: #1296db;\r\n}\r\n.btn-info:hover {\r\n    background: #27acf1;\r\n    border-color: #27acf1;\r\n}\r\n\r\n\r\n/* 点击手机版编辑 */\r\n.phoneSelectContainer {\r\n    float: left;\r\n}\r\n\r\n#phoneSelect {\r\n    padding: 5px;\r\n}\r\n\r\n.ueditor-textarea.edui-default.phone {\r\n    margin: 0 auto;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.ueditor-textarea.edui-default.phone .edui-editor-bottomContainer {\r\n    display: none;\r\n}\r\n\r\n.ueditor-textarea.edui-default.phone.iphone6p {\r\n    height: 763px;\r\n\twidth: 414px;\t\r\n}\r\n.ueditor-textarea.edui-default.phone.iphone6 {\r\n    height: 667px;\r\n\twidth: 375px;\t\r\n}\r\n.ueditor-textarea.edui-default.phone.iphone5 {\r\n    height: 568px;\r\n\twidth: 320px;\t\r\n}\r\n.ueditor-textarea.edui-default.phone.iphone4 {\r\n    height: 480px;\r\n\twidth: 320px;\t\r\n}\r\n.ueditor-textarea.edui-default.phone.ipad {\r\n    height: 1024px;\r\n\twidth: 768px;\t\r\n}\r\n.ueditor-textarea.edui-default.phone.s5 {\r\n    height: 640px;\r\n\twidth: 360px;\t\r\n}\r\n\r\n\r\n/*样式改版v1*/\r\ndiv,dl,dt,dd{\r\n\tpadding: 0;\r\n\tmargin: 0;\r\n}\r\n.ue-top-swtool{\r\n\twidth: 300px;\r\n    height: 40px;\r\n    line-height: 40px;\r\n    margin-bottom: 10px;\r\n    position: absolute;\r\n    right: 22px;\r\n    top: 2px;\r\n}\r\n.ue-top-tableid,.ue-top-sw,.ue-top-swmobile{\r\n\twidth: 100%;\r\n\theight: 40px;\r\n\tline-height: 40px;\r\n\tbox-sizing: border-box;\r\n\toverflow: hidden;\r\n}\r\n.ue-top-swmobile{\r\n\twidth: 135px;\r\n\tfloat: right;\r\n}\r\n.ue-top-tableid{\r\n  height: auto;\r\n  line-height: 18px;\r\n  overflow: hidden;\r\n}\r\n.ue-top-tableid1{\r\n\theight: 30px;\r\n\tline-height: 18px;\r\n\toverflow: hidden;\r\n}\r\n.ue-top-sw ul{\r\n\theight: 100%;\r\n\tbox-sizing: border-box;\r\n}\r\n.ue-top-sw li{\r\n\twidth: 50%;\r\n\theight: 100%;\r\n\tfloat: left;\r\n\ttext-align: center;\r\n\tlist-style: none;\r\n\tfont-size: 20px;\r\n\tbox-sizing: border-box;\r\n\tcursor: pointer;\r\n}\r\n.ue-top-sw li.act{\r\n\tborder-bottom: 2px solid #199ED8;\r\n}\r\n.swbtn-pc-mobile{\r\n\tdisplay: inline-block;\r\n\twidth: 127px;\r\n\theight: 29px;\r\n\tcolor: #FFFFFE;\r\n\tline-height: 29px;\r\n\tpadding-left: 40px;\r\n\tpadding-right: 10px;\r\n\tbackground: url(" + __webpack_require__("../../../../../src/assets/icon/ueswmobile.png") + ") no-repeat;\r\n\tcursor: pointer;\r\n  \tbottom: 0;\r\n}\r\n.ue-top-swmobile .noAct { \r\n    -webkit-filter: grayscale(100%);\r\n    -moz-filter: grayscale(100%);\r\n    -ms-filter: grayscale(100%);\r\n    -o-filter: grayscale(100%);\r\n    \r\n    filter: grayscale(100%);\r\n\t\r\n\t-webkit-filter: gray;\r\n\t\r\n\t        filter: gray;\r\n\topacity: 0.5;\r\n}\r\n.ue-my-control{\r\n\tmargin-bottom: 10px;\r\n}\r\n.ue-my-ctlblock-title{\r\n\twidth: 80px;\r\n\ttext-align: center;\r\n\tborder-right:2px solid #199ED8;\r\n}\r\n.ue-my-ctlblock-btn{\r\n\tfloat: left;\r\n\theight: auto;\r\n\toverflow: hidden;\r\n\tpadding-left: 3px;\r\n\tbox-sizing: border-box;\r\n}\r\n.ue-my-noctlblock-msg{\r\n\theight: 30px;\r\n\tline-height: 30px;\r\n}\r\n/*.ue-my-control,.ue-my-ctlblock,.ue-my-ctlblock dl{\r\n\twidth: 100%;\r\n\theight: auto;\r\n\toverflow: hidden;\r\n}\r\n.ue-my-ctlblock dl dt{\r\n\tfloat: left;\r\n\twidth: 20%;\r\n\tline-height: 26px;\r\n\ttext-align: center;\r\n\tborder-right:2px solid #199ED8;\r\n}\r\n.ue-my-ctlblock dl dd.ue-my-ctlblock-btn{\r\n\tfloat: left;\r\n\theight: auto;\r\n\toverflow: hidden;\r\n\twidth: 80%;\r\n\tpadding-left: 10px;\r\n\tbox-sizing: border-box;\r\n}\r\n.dd.ue-my-ctlblock-btn{\r\n\theight: 100%;\r\n}*/\r\n.mybtn{\r\n\tdisplay: inline-block;\r\n\tpadding: 0px 12px;\r\n\ttext-align: center;\r\n\tborder: 1px solid #797979;\r\n\tborder-radius: 4px;\r\n\tcursor: pointer;\r\n}\r\n.ue-my-ctlblock-btn .mybtn{\r\n\tmargin: 2px 5px;\r\n}\r\n.ue-my-ctlblock-btn .noBtn{\r\n\tbackground: #ddd;\r\n\r\n}\r\n.first_nav_title{\r\n\tfont-size:20px;\r\n}\r\n\r\n/*表字段标签*/\r\n.plu-label{\r\n\tdisplay:inline-block;\r\n\tpadding: 1px 5px;\r\n}\r\n\r\n/*END 样式改版v1*/\r\n\r\n@media screen and (max-width: 859px) {\r\n    .phoneSelectContainer {\r\n        float: initial;\r\n    }\r\n}\r\ntree-internal .tree .folding {\r\n  width: 15px;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/page-editor/page-editor.component.html":
/***/ (function(module, exports) {

module.exports = "<!--<h5 *ngIf=\"nodeName == null\" >您当前还没有选择表...</h5>\r\n<h5 *ngIf=\"nodeName != null\" >当前所打开的表：{{nodeName}}</h5>\r\n<h5 *ngIf=\"nodeName != null\" >当前所打开的表ID：{{nodeId}}</h5>-->\r\n<input type=\"hidden\" id=\"nodeParentId\" value=\"{{nodeParentId}}\">\r\n<input type=\"hidden\" id=\"nodeParentId2x\" value=\"{{nodeParentId2x}}\">\r\n<form method=\"post\" id=\"saveform\" name=\"saveform\" action=\"\">\r\n\t<input type=\"hidden\" name=\"fields\" id=\"fields\" value=\"0\">\r\n\t<input type=\"hidden\" name=\"node_id\" id=\"node_id\" value=\"{{nodeId}}\">\r\n\t<input type=\"hidden\" name=\"node_name\" id=\"node_name\" value=\"{{nodeName}}\">\r\n\r\n\t<input type=\"hidden\" name=\"shareTo_name\" id=\"shareTo_name\" value=\"{{shareTo_name}}\">\r\n\t<input type=\"hidden\" name=\"shareTo_nodeId\" id=\"shareTo_nodeId\" value=\"0\">\r\n\t<input type=\"hidden\" name=\"is_public\" id=\"is_public\" value=\"{{is_public}}\">\r\n\t<input type=\"hidden\" name=\"is_approve\" id=\"is_approve\" value=\"{{is_approve}}\">\r\n\t<div class=\"ue-top-tableid1\">\r\n\t\t<span *ngIf=\"nodeName == null\">您当前还没有选择表...</span>\r\n\t\t<span *ngIf=\"nodeName != null\">当前所打开表名称：{{nodeName}}&nbsp;&nbsp;ID：{{nodeId}}</span>\r\n\t\t<!--<span *ngIf=\"nodeName != null\">当前所打开表名称：{{nodeName}}&nbsp;&nbsp;&nbsp;ID：{{nodeId}}</span>-->\r\n\t</div>\r\n\t<div class=\"ue-top-swtool\">\r\n\t\t<div class=\"ue-top-swmobile\">\r\n\t\t\t<span (click)=\"changeNEditor('PC')\" class=\"swbtn-pc-mobile\" [ngClass]=\"{'noAct':versionEditor == '手机'}\">电脑版编辑</span>\r\n\t\t</div>\r\n\t\t<div class=\"ue-top-swmobile\">\r\n\t\t\t<span (click)=\"changeNEditor('PHONE')\" class=\"swbtn-pc-mobile\" [ngClass]=\"{'noAct':versionEditor =='电脑'}\">手机版编辑</span>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"ue-my-control\" *ngIf=\"swPluginTool\">\r\n\t\t<!-- <div class=\"ue-top-sw\">\r\n\t\t\t\t<ul>\r\n\t\t\t\t\t<li [ngClass]=\"{'act':swPluginTool}\" (click)=\"setPluginTool(true)\">控件</li>\r\n\t\t\t\t\t<li [ngClass]=\"{'act':!swPluginTool}\" (click)=\"setPluginTool(flase)\">组合</li>\r\n\t\t\t\t</ul>\r\n\t\t\t</div> -->\r\n\t\t<table>\r\n\t\t\t<tr id=\"public1\" class=\"\" style=\"\">\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">编辑</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<span (click)=\"exec('text');\" class=\"mybtn\">文本框</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('textarea');\" class=\"mybtn\">多行文本</span>\r\n\t\t\t\t\t\t<!--<span (click)=\"exec('pinglun');\" class=\"mybtn noBtn\">评论</span>-->\r\n\t\t\t\t\t\t<span (click)=\"exec('addimage');\" class=\"mybtn\">动态上传</span>\r\n\t\t\t\t\t\t<!--<span (click)=\"exec('listctrl');\" class=\"mybtn noBtn\">列表编辑</span>-->\r\n\t\t\t\t\t\t<span (click)=\"exec('select');\" class=\"mybtn\">下拉菜单</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('radios');\" class=\"mybtn\">单选框</span>\r\n\r\n\t\t\t\t\t\t<span (click)=\"exec('checkboxs');\" class=\"mybtn\">复选框</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('macros');\" class=\"mybtn noBtn\">宏控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('searchcontrol');\" class=\"mybtn noBtn\">搜索</span>\r\n\t\t\t\t\t\t<!--<span (click)=\"exec('rechtext_editing');\" class=\"mybtn noBtn\">富文本控件</span>-->\r\n\t\t\t\t\t\t<span (click)=\"exec('secondnav');\" class=\"mybtn noBtn\">二级菜单</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('background');\" class=\"mybtn\">背景</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('login');\" class=\"mybtn\">登录</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('zzhhtest');\" class=\"mybtn\">绑定页面</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('multidatasourcepublic');\" class=\"mybtn\">多数源发布标识</span>\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr id=\"public2\" class=\"\" style=\"\">\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">表单</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('frmSubmit');\" class=\"mybtn\">提交</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('frmReset');\" class=\"mybtn\">重置</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('frmSearch');\" class=\"mybtn\">搜索</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('exchange');\" class=\"mybtn\">兑换</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">展示</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<!--<span (click)=\"exec('classification');\" class=\"mybtn noBtn\">分类控件</span>\r\n                        <span (click)=\"exec('progressbar');\" class=\"mybtn noBtn\">进度条</span>\r\n                        <span (click)=\"exec('qrcode');\" class=\"mybtn noBtn\">二维码</span>-->\r\n\t\t\t\t\t\t<span (click)=\"exec('getuserid');\" class=\"mybtn\">用户Id</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('username');\" class=\"mybtn\">用户名</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('userface');\" class=\"mybtn\">用户头像</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('daydate');\" class=\"mybtn\">日期控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('timedate');\" class=\"mybtn\">时分控件</span>\r\n\t\t\t\t\t\t<!-- <span (click)=\"exec('slidebox');\" class=\"mybtn noBtn\">轮播框</span> -->\r\n\t\t\t\t\t\t<span (click)=\"exec('lunbo');\" class=\"mybtn\">轮播</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('internal');\" class=\"mybtn\">积分兑换记录</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('integral');\" class=\"mybtn\">总积分</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('reportcontrol');\" class=\"mybtn noBtn\">报表控件</span>\r\n\r\n\t\t\t\t\t\t<span (click)=\"exec('dangjiandetail');\" class=\"mybtn noBtn\">党建内容详情页</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('dangjiancourse');\" class=\"mybtn noBtn\">党建列表详情页</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('kepudetail');\" class=\"mybtn noBtn\">科普详情页</span>\r\n\r\n\t\t\t\t\t\t<span (click)=\"exec('wxgrouptag');\" class=\"mybtn noBtn\">微信分组标签</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('score');\" class=\"mybtn noBtn\">评分控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('settimeout');\" class=\"mybtn noBtn\">倒计时控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('classify');\" class=\"mybtn\">分类/级联</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('classifytree3');\" class=\"mybtn\">树形分类控件1</span>\r\n\t\t\t\t\t\t<!-- <span (click)=\"exec('classifytree4');\" class=\"mybtn\">树形分类控件2</span> -->\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('job');\" class=\"mybtn\">机构</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('role');\" class=\"mybtn\">角色</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('roleuser');\" class=\"mybtn\">角色用户</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('jobview');\" class=\"mybtn\">组织架构图</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('officeEntrance');\" class=\"mybtn noBtn\">办公入口</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('rolelabel');\" class=\"mybtn noBtn\">角色标签</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('loginstate');\" class=\"mybtn\">登录状态</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('buylabel');\" class=\"mybtn\">购买标签</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('popup');\" class=\"mybtn\">弹窗控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('recordlabel')\" class=\"mybtn\">记录/统计控件</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('recordinfo')\" class=\"mybtn\">记录报告标签</span>\r\n\r\n\t\t\t\t\t\t<span (click)=\"exec('addnumber');\" class=\"mybtn\">报名</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('shenpi');\" class=\"mybtn\">审批列表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('liannanzugong');\" class=\"mybtn\">连南组工</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('pagekeywords');\" class=\"mybtn\">页面关键字与描述</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('iconrouter');\" class=\"mybtn\">村集体资产明细表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('job-progress');\" class=\"mybtn\">重要工作进度表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('headerandfooter');\" class=\"mybtn noBtn\">头/底部模板控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('sidebarnav');\" class=\"mybtn noBtn\">侧栏导航控件</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('addcategory');\" class=\"mybtn\">添加类别</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('productsupload');\" class=\"mybtn\">餐品上传</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('previewproducts');\" class=\"mybtn\">预览餐品页面</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('orderscentre');\" class=\"mybtn\">订单中心</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('vemorderfood');\" class=\"mybtn\">自助机点餐</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr id=\"noPublic1\" class=\"\" style=\"\">\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\" valign=\"top\">列表模板</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<span (click)=\"exec('group');\" class=\"mybtn noBtn\">科普列表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('dangjianlist');\" class=\"mybtn noBtn\">党建列表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('wifiblock');\" class=\"mybtn noBtn\">列表热区</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('wxlist');\" class=\"mybtn noBtn\">微信通知列表</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('jobrow');\" class=\"mybtn noBtn\">组织列表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('formlist');\" class=\"mybtn\">列表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('scheduling');\" class=\"mybtn\">排课</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('listone');\" class=\"mybtn\">列表模板1</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('meetinglist');\" class=\"mybtn\">会议列表</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('meetinglist');\" class=\"mybtn\">会议记录</span>\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr id=\"noPublic2\" class=\"\" style=\"\">\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">路由</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<!--<span (click)=\"exec('iconrouter');\" class=\"mybtn noBtn\">路由控件</span>\r\n                      <span (click)=\"exec('classification');\" class=\"mybtn noBtn\">动态分类控件</span>\r\n                      <span (click)=\"exec('iframerouter');\" class=\"mybtn\">内嵌路由控件</span>\r\n                      <span (click)=\"exec('sort');\" class=\"mybtn\">分类控件</span>-->\r\n\t\t\t\t\t\t<span (click)=\"exec('button');\" class=\"mybtn\">路由按钮</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('tpl');\" class=\"mybtn\">首页母板</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('singlenav');\" class=\"mybtn\">单个导航</span>\r\n\t\t\t\t\t\t<!--<span (click)=\"exec('mtpl');\" class=\"mybtn\">手机首页母板</span>\r\n                      <span (click)=\"exec('toolbar');\" class=\"mybtn\">入口条</span>-->\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\r\n\r\n\t\t\t<tr id=\"noPublic3\" class=\"\" style=\"\">\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">管理</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<!--<span (click)=\"setGlc();\" class=\"mybtn noBtn\">管理工具</span>\r\n                        <span (click)=\"exec('');\" class=\"mybtn noBtn\">提交</span>\r\n                        <span (click)=\"exec('');\" class=\"mybtn noBtn\">列表</span>\r\n                        <span (click)=\"exec('');\" class=\"mybtn noBtn\">删除</span>\r\n                        <span (click)=\"exec('');\" class=\"mybtn noBtn\">修改</span>\r\n                        <span (click)=\"exec('');\" class=\"mybtn noBtn\">打印</span>\r\n                        <span (click)=\"exec('macros');\" class=\"mybtn\">宏控件</span>-->\r\n\t\t\t\t\t\t<span (click)=\"exec('flowbtn');\" class=\"mybtn noBtn\">流程控件</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('classifymg');\" class=\"mybtn\">分类/级联管理</span>\r\n\t\t\t\t\t\t<span (click)=\"setMyPlugins('newclassifymg');\" class=\"mybtn\">新分类管理</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('export');\" class=\"mybtn\">导出Excel</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">程序</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t<span (click)=\"exec('onlinehard');\" class=\"mybtn noBtn\">网络硬盘</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('workword');\" class=\"mybtn noBtn\">工作文档</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('workform');\" class=\"mybtn noBtn\">工作表单</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('workflow');\" class=\"mybtn noBtn\">工作流程</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('schedule');\" class=\"mybtn noBtn\">日程安排</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('task');\" class=\"mybtn noBtn\">任务安排</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('beike');\" class=\"mybtn noBtn\">备课</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('resource');\" class=\"mybtn noBtn\">资源库</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('teach');\" class=\"mybtn noBtn\">教学计划</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('class');\" class=\"mybtn noBtn\">班级</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('curriculum');\" class=\"mybtn noBtn\">课程表</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('jiangtang');\" class=\"mybtn noBtn\">讲堂</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('zujuan');\" class=\"mybtn noBtn\">智能组卷</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('yuejuan');\" class=\"mybtn noBtn\">智能阅卷</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('chaxun');\" class=\"mybtn noBtn\">数据查询</span>\r\n\t\t\t\t\t\t<span (click)=\"exec('audit');\" class=\"mybtn noBtn\">数据审核</span>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<!--  <tr>\r\n\t\t\t\t<td class=\"ue-my-ctlblock-title\">其它</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t<div class=\"ue-my-ctlblock-btn\">\r\n\t\t\t\t\t\t <span (click)=\"exec('asscontrol');\" class=\"mybtn\">关联控件</span>\r\n\r\n\r\n\t\t\t\t\t   <span (click)=\"exec('routerClassify');\" class=\"mybtn\">路由分类控件</span>\r\n\r\n\t\t\t\t\t</div>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\t\t\t -->\r\n\t\t</table>\r\n\t</div>\r\n\t<div class=\"ue-my-control\" *ngIf=\"!swPluginTool\">\r\n\t\t<table>\r\n\t\t\t<tr>\r\n\t\t\t\t<td class=\"ue-my-noctlblock-msg\">组合控件更新中...</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t</div>\r\n\t<div>\r\n\t\t<!--<div *ngIf=\"!toggleVersion\" class=\"phoneSelectContainer\">\r\n        <p>选择不同的手机屏幕</p>\r\n        <select id=\"phoneSelect\" (change)=\"phoneChange($event)\">\r\n          <option value=\"iphone6p\">iPhone 6 Plus</option>\r\n          <option value=\"iphone6\">iPhone 6</option>\r\n          <option value=\"iphone5\">iPhone 5</option>\r\n          <option value=\"iphone4\">iPhone 4</option>\r\n          <option value=\"ipad\">iPad</option>\r\n          <option value=\"s5\">Galaxy S5</option>\r\n        </select>\r\n      </div>-->\r\n\t\t<ueditor #full [config]=\"custom\" (onPreReady)=\"onPreReady($event)\"></ueditor>\r\n\t</div>\r\n</form>\n"

/***/ }),

/***/ "../../../../../src/app/page-editor/page-editor.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return PageEditorComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__service_httpData_service__ = __webpack_require__("../../../../../src/app/service/httpData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_ngx_ueditor__ = __webpack_require__("../../../../ngx-ueditor/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__service_insertData_service__ = __webpack_require__("../../../../../src/app/service/insertData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_jquery__ = __webpack_require__("../../../../jquery/dist/jquery.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_jquery___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_jquery__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};






var PageEditorComponent = (function () {
    function PageEditorComponent(el, http, httpData, insertData) {
        this.el = el;
        this.http = http;
        this.httpData = httpData;
        this.insertData = insertData;
        this.toggle = true;
        this.toggleValue = '隐藏';
        this.toggleVersion = true;
        this.versionEditor = '电脑';
        this.nowSelect = 'iphone6';
        this.lastSelect = 'iphone6';
        this.swPluginTool = true;
        this.headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Headers */]({ 'Content-Type': 'application/json;charset=UTF-8' });
        this.options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* RequestOptions */]({ headers: this.headers });
        this.custom = {
            // 配置工具栏
            iframeCssUrl: './assets/ueditor/formdesign/self/css/style.css',
            allowDivTransToP: false,
            initialFrameWidth: 'auto',
            initialFrameHeight: 500,
            enableAutoSave: false,
            saveInterval: 0 //自动保存间隔时间， 单位ms
        };
        sessionStorage.setItem('editorStyle', 'pc');
        /*console.log(this.nodeType);*/
        if (this.nodeType == 7) {
            sessionStorage.setItem('editorStyle', 'pc');
        }
        else {
            sessionStorage.setItem('editorStyle', 'phone');
        }
    }
    Object.defineProperty(PageEditorComponent.prototype, "node_id", {
        set: function (nodeId) {
            // alert("nodeId="+nodeId);
            this.nodeId = nodeId;
            // 		alert("this.nodeId="+this.nodeId);
            // 		alert("$('#shareTo_nodeId').val()="+$("#shareTo_nodeId").val());
            __WEBPACK_IMPORTED_MODULE_5_jquery__("#shareTo_nodeId").val(0);
            // alert("$('#shareTo_nodeId').val(0)="+$("#shareTo_nodeId").val());
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(PageEditorComponent.prototype, "isPublic", {
        set: function (is_public) {
            // alert(this.is_approve);
            this.is_public = is_public;
            // alert(this.is_public);
            var oPublic1 = document.getElementById("public1");
            var oPublic2 = document.getElementById("public2");
            var onoPublic1 = document.getElementById("noPublic1");
            var onoPublic2 = document.getElementById("noPublic2");
            var onoPublic3 = document.getElementById("noPublic3");
            if (this.is_public == 0) {
                oPublic1.className = "";
                oPublic2.className = "";
                onoPublic1.className = "noPublic";
                onoPublic2.className = "noPublic";
                onoPublic3.className = "noPublic";
            }
            if (this.is_public == 1) {
                oPublic1.className = "public";
                oPublic2.className = "public";
                onoPublic1.className = "";
                onoPublic2.className = "";
                onoPublic3.className = "";
            }
            if (this.is_public != 0 && this.is_public != 1) {
                oPublic1.className = "";
                oPublic2.className = "";
                onoPublic1.className = "";
                onoPublic2.className = "";
                onoPublic3.className = "";
            }
        },
        enumerable: true,
        configurable: true
    });
    PageEditorComponent.prototype.onPreReady = function (comp) {
        /*
         * 在百度编辑器里面添加小按钮
         *
         */
        // 表单设计器
        UE.registerUI('button_active', function (editor, uiName) {
            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function () {
                    editor.execCommand('activewidget');
                }
            });
            // 创建一个button
            var btn = new UE.ui.Button({
                // 按钮的名字
                name: uiName,
                // 提示
                title: '表单设计器 ',
                // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
                cssRules: 'background-position: -401px -40px;',
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
        UE.registerUI('button_preview', function (editor, uiName) {
            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function () {
                    try {
                        editor.execCommand('preview');
                    }
                    catch (e) {
                        alert('预览异常');
                    }
                }
            });
            // 创建一个button
            var btn = new UE.ui.Button({
                // 按钮的名字
                name: uiName,
                // 提示
                title: '预览',
                // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
                cssRules: 'background-position: -420px -19px;',
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
        UE.registerUI('button_save', function (editor, uiName) {
            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function () {
                    try {
                        editor.execCommand('save');
                    }
                    catch (e) {
                        alert('保存异常');
                    }
                }
            });
            // 创建一个button
            var btn = new UE.ui.Button({
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
        UE.registerUI('button_outlink', function (editor, uiName) {
            // 注册按钮执行时的command命令，使用命令默认就会带有回退操作
            editor.registerCommand(uiName, {
                execCommand: function () {
                    try {
                        editor.execCommand('outlink');
                    }
                    catch (e) {
                        alert('外链接异常');
                    }
                }
            });
            // 创建一个button
            var btn = new UE.ui.Button({
                // 按钮的名字
                name: uiName,
                // 提示
                title: '外链接',
                // 需要添加的额外样式，指定icon图标，这里默认使用一个重复的icon
                cssRules: 'background-position: -500px 0;',
                // 点击时执行的命令
                onclick: function () {
                    // 这里可以不用执行命令,做你自己的操作也可
                    editor.execCommand(uiName);
                }
            });
            // 因为你是添加button,所以需要返回这个button
            return btn;
        });
    };
    PageEditorComponent.prototype.exec = function (data) {
        /*
         * 执行 page-editor 模块的方法，实现点击按钮的操作
         *
         */
        this.editor.Instance.execCommand(data);
    };
    PageEditorComponent.prototype.setHtml = function () {
        var html = "";
        this.editor.Instance.setContent(html);
    };
    PageEditorComponent.prototype.setGlc = function () {
        var html = "<input name=\"leipiNewField\" type=\"text\" title=\"\u7BA1\u7406\u6761\u63A7\u4EF6\" value=\"\u7BA1\u7406 - \u63A7\u4EF6\" leipiplugins=\"glc\" nodeid=\"" + this.nodeId + "\" classname=\"" + this.nodeName + "\" style=\"width: 80px;height: 30px;\">";
        this.editor.Instance.setContent(html, true);
    };
    PageEditorComponent.prototype.setMyPlugins = function (tag) {
        var html = "";
        switch (tag) {
            case "uid":
                html = "<span class=\"pl_userid\">\u7528\u6237ID</span>";
                break;
            case "wxgrouptag":
                html = "<input name=\"leipiNewField\" type=\"text\" title=\"\u5FAE\u4FE1\u5206\u7EC4\u6807\u7B7E\" value=\"\u5FAE\u4FE1\u5206\u7EC4\u6807\u7B7E\" leipiplugins=\"wxgrouptag\" style=\"width: 90px;height: 30px;\">";
                break;
            case "username":
                html = "<span class=\"pl_username\">\u7528\u6237\u540D</span>";
                break;
            case "userface":
                // html=`<img class="pl_userface" src="../assets/ueditor/formdesign/self/icon/userface.png">`;
                html = "<img class=\"pl_userface\" src=\"/editor/assets/ueditor/formdesign/self/icon/userface.png\">";
                break;
            case "classifymg":
                html = "<iframe name=\"frclassifymg\" id=\"frclassifymg\" src=\"/classifymg\" width=\"100%\" height=\"100%\" scrolling=\"no\" frameborder=\"0\" align=\"\"></iframe>";
                break;
            case "newclassifymg":
                html = "<iframe name=\"newclassifymg\" id=\"newclassifymg\" src=\"/newclassifymg\" width=\"100%\" height=\"100%\" scrolling=\"no\" frameborder=\"0\" align=\"\"></iframe>";
                break;
            case "jobview":
                html = "<iframe name=\"frclassifymg\" id=\"frclassifymg\" src=\"/jobview\" width=\"100%\" height=\"100%\" scrolling=\"no\" frameborder=\"0\" align=\"\"></iframe>";
                break;
            case "jobrow":
                html = "<table id=\"plujobrow\"><tr><td>\u7EC4\u7EC7</td><td>\u52A0\u5165\u65F6\u95F4\uFF1A2018-10-18</td></tr></table>";
                break;
            case "job":
                //<input type='hidden' name='swPowerJob' value=''>
                html = "<div class=\"swjoblist\"></div><span id='getPowerJobInfo'>\u70B9\u51FB\u9009\u62E9\u673A\u6784</span>";
                break;
            case "role":
                //<input type='hidden' name='swPowerRole' value=''>
                html = "<div class=\"swrolelist\"></div><span id='getPowerRoleInfo'>\u70B9\u51FB\u9009\u62E9\u89D2\u8272</span>";
                break;
            case "roleuser":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<div class=\"swroleuserlist\"></div><span id='getPowerRoleUserInfo'>\u70B9\u51FB\u9009\u62E9\u89D2\u8272\u7528\u6237</span>";
                break;
            case "richtext":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<div class=\"richtextlist\"></div><span id='richTextUserInfo'>\u5BCC\u6587\u672C\u6846</span>";
                break;
            case "wxlist":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<div id=\"wx_msglist\">\n                    <div class=\"wx_list_block\">\n                      <div class=\"wx_list_conent\">\n                          <div class=\"wx_list_label wx_list_msgflag4\">\u5E74\u7EA7\u901A\u77E5</div>\n                          <div class=\"wx_list_right\">\n                              <h1>\u6D4B\u8BD5</h1>\n                              <div class=\"wx_list_con\">\u4FE1\u606F\u5185\u5BB9</div>\n                              <div class=\"wx_list_user\"><em>\u7BA1\u7406\u5458\u8001\u5E08</em><em>2018-07-03 14:23</em></div>\n                          </div>\n                      </div>\n                    </div>\n                </div>";
                break;
            case "frmSubmit":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<span class=\"frm-submit btn btn-success\">\u63D0\u4EA4</span>";
                break;
            case "frmEdit":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<span class=\"frm-edit btn btn-info\">\u7F16\u8F91</span>";
                break;
            case "frmReset":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<span class=\"frm-rest btn btn-default\">\u91CD\u7F6E</span>";
                break;
            case "frmSearch":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<span class=\"frm-search btn btn-default\">\u641C\u7D22</span>";
                break;
            case "recordinfo":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<div id=\"recordinfo\">\u8BB0\u5F55\u62A5\u544A</div>";
                break;
            case "integral":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<span class=\"totalIntegral\">\u603B\u79EF\u5206</span>";
                break;
            case "meetinglist":
                //<input type='hidden' name='swPowerRoleUser' value=''>
                html = "<div class=\"meetinglist\">\u4F1A\u8BAE\u8BB0\u5F55\u5185\u5BB9</div>";
                break;
        }
        if (html != '')
            this.editor.Instance.execCommand('insertHtml', html);
    };
    PageEditorComponent.prototype.setContent = function (content) {
        /*
         * 执行 page-editor 模块的方法，插入用户模板内容
         *
         */
        this.editor.Instance.setContent(content);
    };
    PageEditorComponent.prototype.toggleShow = function () {
        /*
         * 隐藏/显示 编辑器 - 点击按钮
         *
         */
        this.toggle ? this.editor.Instance.setHide() : this.editor.Instance.setShow();
        this.toggle ? this.toggleValue = '显示' : this.toggleValue = '隐藏';
        this.toggle = !this.toggle;
    };
    PageEditorComponent.prototype.changeEditor = function () {
        /*
         * 手机/电脑版编辑 - 点击按钮
         *
         */
        var saveConfirm = true;
        if (this.editor.Instance.hasContents()) {
            saveConfirm = confirm('请确认是否已经保存数据！');
        }
        if (saveConfirm) {
            this.toggleVersion ? this.versionEditor = '电脑' : this.versionEditor = '手机';
            this.toggleVersion = !this.toggleVersion;
            sessionStorage.setItem('editorcontent', this.editor.Instance.getContent());
        }
        if (!this.toggleVersion) {
            sessionStorage.setItem('editorStyle', 'phone');
            __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').addClass('phone').addClass(this.nowSelect);
        }
        else {
            sessionStorage.setItem('editorStyle', 'pc');
            __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').removeClass('phone').removeClass(this.lastSelect);
        }
        if (this.nodeId !== undefined) {
            // alert("这里是手机/电脑版编辑 - 点击按钮，是吗？");
            alert("是否发布" + this.is_public);
            this.insertData.insertData(this.nodeId, this.nodeId, this.editor, this.is_public, this.page_classify, this.module_classify);
        }
    };
    PageEditorComponent.prototype.changeNEditor = function (type) {
        /*
         * 手机/电脑版编辑 - 点击按钮
         *
         */
        var saveConfirm = true;
        if (this.editor.Instance.hasContents()) {
            saveConfirm = confirm('请确认是否已经保存数据！');
        }
        if (saveConfirm) {
            sessionStorage.setItem('editorcontent', this.editor.Instance.getContent());
            if (type == 'PC') {
                this.versionEditor = '电脑';
                sessionStorage.setItem('editorStyle', 'pc');
                __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').removeClass('phone').removeClass(this.lastSelect);
            }
            else if (type == 'PHONE') {
                this.versionEditor = '手机';
                sessionStorage.setItem('editorStyle', 'phone');
                __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').addClass('phone').addClass(this.nowSelect);
            }
            if (this.nodeId !== undefined) {
                // alert("这里也是手机/电脑版编辑 - 点击按钮，什么情况！！多了的type参数");
                // alert("是否发布"+this.is_public);
                this.insertData.insertData(this.nodeId, this.nodeId, this.editor, this.is_public, this.page_classify, this.module_classify);
            }
        }
    };
    PageEditorComponent.prototype.changeEditor2 = function (type) {
        this.toggleVersion = !type;
        this.toggleVersion ? this.versionEditor = '电脑' : this.versionEditor = '手机';
        if (!this.toggleVersion) {
            sessionStorage.setItem('editorStyle', 'phone');
            __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').addClass('phone').addClass(this.nowSelect);
        }
        else {
            sessionStorage.setItem('editorStyle', 'pc');
            __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').removeClass('phone').removeClass(this.lastSelect);
        }
    };
    PageEditorComponent.prototype.phoneChange = function (e) {
        /*
         * 手机版编辑 - 选择不同的手机屏幕功能
         *
         */
        this.lastSelect = this.nowSelect;
        this.nowSelect = e.target.value;
        __WEBPACK_IMPORTED_MODULE_5_jquery__('.ueditor-textarea.edui-default').addClass(this.nowSelect).removeClass(this.lastSelect);
    };
    PageEditorComponent.prototype.getText = function () {
        console.log(this.editor.Instance.selection.getRange().cloneContents());
    };
    PageEditorComponent.prototype.setPluginTool = function (b) {
        this.swPluginTool = b;
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["ViewChild"])(__WEBPACK_IMPORTED_MODULE_3_ngx_ueditor__["a" /* UEditorComponent */]),
        __metadata("design:type", typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_3_ngx_ueditor__["a" /* UEditorComponent */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3_ngx_ueditor__["a" /* UEditorComponent */]) === "function" && _a || Object)
    ], PageEditorComponent.prototype, "editor", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number)
    ], PageEditorComponent.prototype, "nodeType", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", String)
    ], PageEditorComponent.prototype, "nodeName", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number)
    ], PageEditorComponent.prototype, "nodeParentId", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number)
    ], PageEditorComponent.prototype, "nodeParentId2x", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number),
        __metadata("design:paramtypes", [Number])
    ], PageEditorComponent.prototype, "node_id", null);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number)
    ], PageEditorComponent.prototype, "is_approve", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number)
    ], PageEditorComponent.prototype, "page_classify", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number)
    ], PageEditorComponent.prototype, "module_classify", void 0);
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Input"])(),
        __metadata("design:type", Number),
        __metadata("design:paramtypes", [Number])
    ], PageEditorComponent.prototype, "isPublic", null);
    PageEditorComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Component"])({
            selector: 'app-page-editor',
            template: __webpack_require__("../../../../../src/app/page-editor/page-editor.component.html"),
            styles: [__webpack_require__("../../../../../src/app/page-editor/page-editor.component.css")],
            encapsulation: __WEBPACK_IMPORTED_MODULE_2__angular_core__["ViewEncapsulation"].None
        }),
        __metadata("design:paramtypes", [typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_core__["ElementRef"] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_core__["ElementRef"]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */]) === "function" && _c || Object, typeof (_d = typeof __WEBPACK_IMPORTED_MODULE_0__service_httpData_service__["a" /* HttpDataService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__service_httpData_service__["a" /* HttpDataService */]) === "function" && _d || Object, typeof (_e = typeof __WEBPACK_IMPORTED_MODULE_4__service_insertData_service__["a" /* InsertDataService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_4__service_insertData_service__["a" /* InsertDataService */]) === "function" && _e || Object])
    ], PageEditorComponent);
    return PageEditorComponent;
    var _a, _b, _c, _d, _e;
}());

//# sourceMappingURL=page-editor.component.js.map

/***/ }),

/***/ "../../../../../src/app/service/httpData.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HttpDataService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HttpDataService = (function () {
    function HttpDataService() {
        var localHost = window.location.host;
        // localHost = '47.106.147.174'; //
        //localHost = '120.78.75.246';//六
        // localHost = '47.112.212.35';//三
        // localHost = 'www.1388w.cn';
        // localHost = '192.168.0.213';
        // localHost = '192.168.0.237';
        // localHost = '127.0.0.1';
        this.Manage_HOST = 'http://' + localHost + ':20890/';
        this.Editor_HOST = 'http://' + localHost + ':20890/';
        this.Editor_96HOST = 'http://' + localHost + ':20896/';
        /*
                  this.Manage_HOST = 'http://192.168.0.192:20890/';
                  this.Editor_HOST = 'http://192.168.0.192:20890/';*/
        /*this.Manage_HOST = 'http://1388w.cn:20890/';
                this.Editor_HOST = 'http://1388w.cn:208902/';*/
    }
    HttpDataService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [])
    ], HttpDataService);
    return HttpDataService;
}());

//# sourceMappingURL=httpData.service.js.map

/***/ }),

/***/ "../../../../../src/app/service/insertData.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return InsertDataService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__httpData_service__ = __webpack_require__("../../../../../src/app/service/httpData.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_jquery__ = __webpack_require__("../../../../jquery/dist/jquery.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_jquery___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_jquery__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var InsertDataService = (function () {
    function InsertDataService(http, httpData) {
        this.http = http;
        this.httpData = httpData;
        /*
         * 点击节点后，执行这个操作，解析内容到 百度编辑器 里面。
         *
         */
        this.headers = new __WEBPACK_IMPORTED_MODULE_0__angular_http__["a" /* Headers */]({ 'Content-Type': 'application/json;charset=UTF-8' });
        this.options = new __WEBPACK_IMPORTED_MODULE_0__angular_http__["d" /* RequestOptions */]({ headers: this.headers });
    }
    InsertDataService.prototype.insertData = function (nodeId, nodeType, editor, is_public, page_classify, module_classify) {
        // 		alert("他说点击后会到这里喔~你信不信！！nodeId="+nodeId);
        // 		alert("进来了进来了！！！是否发布"+is_public);
        var url = this.httpData.Manage_HOST + 'pageDesignQueryFacade/getPageContent?id=' + nodeId;
        this.http
            .get(url)
            .map(function (res) { return res.json(); })
            .subscribe(function (res) {
            var localHost = window.location.host;
            if (res['msg'] === 'java.lang.NullPointerException' || res['msg'] === null) {
                editor.Instance.setContent('');
                return false;
            } /* else if(res['status']==='201'){
                        editor.Instance.setContent('您的页面未被审核，请耐心等待~~~');
                        return false;
                    } */
            var parse;
            //if(nodeType==8)sessionStorage.setItem("editorStyle","phone");
            /*if (sessionStorage.getItem('editorStyle') === 'phone') {
                        if (res['msg'].phoneParse === null) {
                            parse = res['msg'].parse;
                        } else {
                            parse = res['msg'].phoneParse;
                        }
                    } else {
                        parse = res['msg'].parse;
                    }*/
            if (sessionStorage.getItem('editorStyle') === 'phone') {
                if (res['msg'].phoneParse === null) {
                    //parse = res['msg'].parse;
                    parse = '';
                }
                else {
                    parse = res['msg'].phoneParse;
                }
                sessionStorage.setItem('editorcontent', res['msg'].parse);
            }
            else {
                parse = res['msg'].parse;
                sessionStorage.setItem('editorcontent', res['msg'].phoneParse);
            }
            if (parse === null) {
                editor.Instance.setContent('');
                return false;
            }
            var datas = res['msg'].data, // 数据详细内容
            fields = [], // 所有的字段
            field; // 当前字段
            if (res['msg'].fields !== 0) {
                __WEBPACK_IMPORTED_MODULE_4_jquery__["each"](datas, function (index, value) {
                    if (value.parse_name) {
                        // chekcbox 解析出来的name是不一样的
                        fields.push(value.parse_name);
                    }
                    else {
                        fields.push(value.name);
                    }
                });
                for (var i = 0; i < fields.length; i++) {
                    var dataType = datas[i].leipiplugins, showData, // 变为预览状态的临时变量
                    data = datas[i]; // 当前数据详细内容
                    //   console.log(dataType)
                    console.log(data);
                    field = fields[i];
                    switch (dataType) {
                        case 'assetdetail':
                            showData = "<input placeholder='\u8D44\u4EA7\u660E\u7EC6\u8868' name='assetdetail' leipiplugins='assetdetail'>";
                            break;
                        case 'multidatasourcepublic':
                            showData = "<input placeholder='\u591A\u6570\u636E\u6E90\u53D1\u5E03\u6807\u8BC6\u63A7\u4EF6' name='" + data.name + "' leipiplugins='" + data.leipiplugins + "'>";
                            break;
                        case 'sidebarnav':
                            showData =
                                "<input placeholder='\u4FA7\u680F\u5BFC\u822A\u63A7\u4EF6' name='" + data.name + "' leipiplugins='" + data.leipiplugins + "' leftnavdefinitions='" + data.leftnavdefinitions + "' bluestyle='" + data.bluestyle + "'>";
                            break;
                        case 'headerandfooter':
                            showData =
                                "<input placeholder='\u5934/\u5E95\u90E8\u6A21\u677F\u63A7\u4EF6' name='" + data.name + "' leipiplugins='" + data.leipiplugins + "'" +
                                    (" templatename='" + data.templatename + "' headerdefinitions='" + data.headerdefinitions + "' footerdefinitions='" + data.footerdefinitions + "'>");
                            break;
                        case 'score':
                            showData = "<input name='" + data.name + "'" + ("leipiplugins='" + data.leipiplugins + "' placeholder='" + data.placeholder + "' >");
                            break;
                        case 'text':
                            var border = void 0; // input的边框
                            var bgColor = void 0; // input的底色
                            var hide = void 0; // input可见性
                            var groupcon = void 0; // 组合控件
                            var disabled = void 0; //禁用控件
                            border = data.orgthide === '0' ? '' : 'none';
                            bgColor = data.orgbghide === '0' ? '' : 'none';
                            hide = data.orghide === '0' ? '' : 'none';
                            disabled = data.orgdisabled === '1' ? 'disabled' : '';
                            showData =
                                "<input name='" + data.name + "' type='" + data.type + "' datasource='" + data.datasource + "' orgbghide='" + data.orgbghide + "'" +
                                    ("title='" + data.title + "' value='" + data.value + "' orgthide='" + data.orgthide + "' display:" + hide + ";") +
                                    ("leipiplugins='" + data.leipiplugins + "' orgalign='" + data.orgalign + "' orghide='" + data.orghide + "'") +
                                    ("orgwidth='" + data.orgwidth + "' fontset='" + data.fontset + "' orgfontsize='" + data.orgfontsize + "' orgheight='" + data.orgheight + "'") +
                                    ("orgtype='" + data.orgtype + "' style=\"line-clamp='" + data.lineClamp + "' text-align:" + data.orgalign + "; height:" + data.orgheight + ";") +
                                    ("width:" + data.orgwidth + "; font-size:" + data.orgfontsize + "px;border:" + border + ";background:" + bgColor + ";" + data.style + "\"") +
                                    ("datasource='" + data.datasource + "' groupcon='" + data.groupcon + "' p_or_m='" + data.p_or_m + "' ") +
                                    ("  orgdisabled='" + data.orgdisabled + "'  " + disabled + "    writenickname='" + data.writenickname + "'>");
                            break;
                        // edit by :ww
                        case 'mingxibiao':
                            showData =
                                "<input name='" + data.name + "'" +
                                    ("leipiplugins='" + data.leipiplugins + "' title=\"\u8D44\u4EA7\u660E\u7EC6\u8868\"") +
                                    ("orgname='" + data.orgname + "' orgwidth='" + data.orgwidth + "'") +
                                    ("orgid='" + data.orgid + "' font-size='" + data.fontsize + "'") +
                                    ("recordid='" + data.recordid + "' orgfontcolor='" + data.orgfontcolor + "' orgurl='" + data.orgurl + "' placeholder='" + data.placeholder + "'") +
                                    "  >";
                            break;
                        case 'jobprogress':
                            showData =
                                "<input name='" + data.name + "'" +
                                    ("leipiplugins='" + data.leipiplugins + "' title='" + data.title + "'") +
                                    ("orgname='" + data.orgname + "' orgwidth='" + data.orgwidth + "'") +
                                    ("villageid='" + data.villageid + "' font-size='" + data.fontsize + "'") +
                                    ("recordid='" + data.recordid + "' orgfontcolor='" + data.orgfontcolor + "' orgurl='" + data.orgurl + "' placeholder='" + data.placeholder + "'") +
                                    "  >";
                            break;
                        // edit by :ww
                        case 'pagekeywords':
                            showData =
                                "<input name='" + data.name + "'" +
                                    ("leipiplugins='" + data.leipiplugins + "' title=\"\u9875\u9762\u5173\u952E\u5B57\u4E0E\u63CF\u8FF0\"") +
                                    ("type='" + data.type + "' value='" + data.value + "'") +
                                    ("pagetitle='" + data.pagetitle + "' keywords='" + data.keywords + "'") +
                                    ("description='" + data.description + "' >");
                            break;
                        case 'classifytree':
                            showData = "<input name='" + data.name + "'" + ("leipiplugins='" + data.leipiplugins + "'") + ("placeholder='" + data.placeholder + "' node_id='" + data.node_id + "' >");
                            break;
                        case 'classifytree02':
                            showData = "<input name='" + data.name + "'" + ("leipiplugins='" + data.leipiplugins + "'") + ("placeholder='" + data.placeholder + "' node_id='" + data.node_id + "' >");
                            break;
                        case 'classifytree03':
                            showData = "<input name='" + data.name + "'" + ("leipiplugins='" + data.leipiplugins + "'") + ("placeholder='" + data.placeholder + "' node_id='" + data.node_id + "' >");
                            break;
                        case 'classifytree04':
                            showData = "<input name='" + data.name + "'" + ("leipiplugins='" + data.leipiplugins + "'") + ("placeholder='" + data.placeholder + "' node_id='" + data.node_id + "' >");
                            break;
                        case 'textarea':
                            disabled = data.orgdisabled === '1' ? 'disabled' : '';
                            showData =
                                "<textarea name='" + data.name + "' title='" + data.title + "'" +
                                    ("leipiplugins='" + data.leipiplugins + "' value='" + data.value + "'  datasource='" + data.datasource + "' orgrich='" + data.orgrich + "'") +
                                    ("orgfontsize='" + data.orgfontsize + "' orgwidth='" + data.orgwidth + "' orgheight='" + data.orgheight + "' listheight=\"" + data.listheight + "\"") +
                                    ("style=\"width:" + data.orgwidth + ";height:" + data.orgheight + ";font-size:" + data.orgfontsize + "px;" + data.style + "\" ") +
                                    ("orgdisabled='" + data.orgdisabled + "'  " + disabled + " >") +
                                    (data.value + "</textarea>");
                            break;
                        case 'select':
                            var dataValue = data.value.split(','); // 控件内容 -- 把字符串分割为数组
                            showData =
                                "{|-<span leipiplugins='" + data.leipiplugins + "'>" +
                                    ("<select name='" + data.name + "' datasource='" + data.datasource + "' datasources='" + data.datasources + "' datatitle='" + data.datatitle + "' title='" + data.title + "' orgwidth='" + data.orgwidth + "' leipiplugins='" + data.leipiplugins + "'") +
                                    ("selected='" + data.selected + "' size='" + data.size + "' isstate='" + data.isstate + "' conhide='" + data.conhide + "' style=\"width:" + data.orgwidth + ";" + data.style + "\">");
                            __WEBPACK_IMPORTED_MODULE_4_jquery__["each"](dataValue, function (key, value) {
                                if (value === data.selected) {
                                    showData += "<option value='" + value + "' selected='" + value + "'>" + value + "</option>";
                                }
                                else {
                                    showData += "<option value='" + value + "'>" + value + "</option>";
                                }
                            });
                            showData += '</select></span>-|}';
                            break;
                        case 'flowbtn':
                            var htype = data.orgvarfontheight === '0' ? 'px' : '%';
                            var wtype = data.orgvarfontwidth === '0' ? 'px' : '%';
                            var bgcolor = data.orgbgcolor === '' ? '' : 'background:' + data.orgbgcolor + ';';
                            var fncolor = data.orgfontcolor === '' ? '' : 'color:' + data.orgfontcolor + ';';
                            var isClick = data.onclick === '' ? '' : 'onclick="' + data.onclick + '"';
                            showData = "<input orgheight=\"" + data.orgheight + "\"  orgformid=\"" + data.orgformid + "\"  orgfontcolor=\"" + data.orgfontcolor + "\" orgbgcolor=\"" + data.orgbgcolor + "\" orgurl=\"" + data.orgurl + "\"\n                                orgname=\"" + data.orgname + "\" orgwidth=\"" + data.orgwidth + "\"  name=leipiNewField leipiplugins=\"" + dataType + "\" orgflow=\"" + data.orgflow + "\" type=\"" + data.type + "\"\n                                title=\"" + data.title + "\" value=\"" + data.value + "\" " + isClick + " orgvarfontheight=\"" + data.orgvarfontheight + "\" orgvarfontwidth=\"" + data.orgvarfontwidth + "\"\n                                style=\"padding:0 !important; height:" + data.orgheight + htype + " ;width:" + data.orgwidth + wtype + " ;" + bgcolor + fncolor + "\" >";
                            break;
                        case 'radios':
                            showData =
                                "{|-<span name=leipiNewField  selected='" + data.selected + "' orderby='" + data.orderby + "' +orgwidth='" + data.orgwidth + "'" +
                                    ("orgheight='" + data.orgheight + "' orgfontsize='" + data.orgfontsize + "'  datasource='" + data.datasource + "' style='display:inline-block;width:" + data.orgwidth) +
                                    ("height:" + data.orgheight + "font-size:" + data.orgfontsize + " '  leipiplugins='" + data.leipiplugins + "' title='" + data.title + "'>");
                            __WEBPACK_IMPORTED_MODULE_4_jquery__["each"](data.options, function (key, value) {
                                if (value.checked !== undefined) {
                                    showData += "<input value='" + value.value + "' name=leipiNewField " + ("type='" + value.type + "' checked>" + value.value + "&nbsp;");
                                }
                                else {
                                    showData += "<input value='" + value.value + "' name='leipiNewField' type='" + value.type + "'>" + value.value + "&nbsp;";
                                }
                            });
                            showData += '</span>-|}';
                            break;
                        case 'checkboxs':
                            showData =
                                "{|-<span leipiplugins='" + data.leipiplugins + "' orderby='" + data.orderby + "' title='" + data.title + "' orgwidth='" + data.orgwidth + "'" +
                                    ("orgheight='" + data.orgheight + "' orgfontsize='" + data.orgfontsize + "' style='display:inline-block;width:" + data.orgwidth + ";height:" + data.orgheight + ";font-size:" + data.orgfontsize + "' ") +
                                    (" name='" + data.name + "'>");
                            __WEBPACK_IMPORTED_MODULE_4_jquery__["each"](data.options, function (key, value) {
                                if (value.checked !== null) {
                                    showData += "<input value='" + value.value + "' name=\"leipiNewField\"" + (" type='" + value.type + "' checked=checked>" + value.value + "&nbsp;");
                                }
                                else {
                                    showData += "<input value='" + value.value + "' name=leipiNewField type='" + value.type + "'>" + value.value + "&nbsp;";
                                }
                            });
                            showData += '</span>-|}';
                            break;
                        case 'macros':
                            showData =
                                "<input name='" + data.name + "' type='" + data.type + "' value='" + data.value + "'" +
                                    ("title='" + data.title + "' orgwidth='" + data.orgwidth + "'") +
                                    ("leipiplugins='" + data.leipiplugins + "' orgtype='" + data.orgtype + "' orghide='" + data.orghide + "'") +
                                    ("orgfontsize='" + data.orgfontsize + "' style=width:" + data.orgwidth + ";font-size:" + data.orgfontsize + "px;" + data.style + ">");
                            break;
                        case 'progressbar':
                            showData =
                                "<img name='" + data.name + "' title='" + data.title + "'" +
                                    ("leipiplugins='progressbar' value='" + data.value + "'") +
                                    ("orgsigntype='" + data.orgsigntype + " src='" + data.src + "' _src='" + data.src + "' />");
                            break;
                        case 'qrcode':
                            showData =
                                "<img name='" + data.name + "' title='" + data.title + "'" +
                                    ("value='" + data.value + "' orgtype='" + data.orgtype + "'") +
                                    ("leipiplugins='" + data.leipiplugins + " src='" + data.src + "' _src='" + data.src + "' orgwidth='" + data.orgwidth + "'") +
                                    ("orgheight='" + data.orgheight + "' style='width:" + data.orgwidth + ";height:" + data.orgheight + ";' >");
                            break;
                        case 'listctrl':
                            showData =
                                "<input name='" + data.name + "' type='" + data.type + "' value='" + data.value + "' title='" + data.title + "'" +
                                    ("leipiplugins='" + data.leipiplugins + "' orgtitle='" + data.orgtitle + "' orgcoltype='" + data.orgcoltype + "'") +
                                    ("orgunit='" + data.orgunit + "' orgsumvalue='" + data.orgsumvalue + "'") +
                                    ("orgrowvalue='" + data.orgrowvalue + "' orgsum='" + data.orgsum + "'") +
                                    ("orgcolvalue='" + data.orgcolvalue + "' orgwidth='" + data.orgwidth + "' style='width:" + data.orgwidth + ";' >");
                            break;
                        case 'addimage':
                            showData =
                                "<input name='" + data.name + "' orgpicheight='" + data.orgpicheight + "' orgpicwidth='" + data.orgpicwidth + "'" +
                                    (" minfilesize='" + data.minfilesize + "' maxfilesize='" + data.maxfilesize + "' orgwithin='" + data.orgwithin + "' orgouter='" + data.orgouter + "'") +
                                    (" sethtype='" + data.sethtype + "' setwtype='" + data.setwtype + "' leipiplugins='" + data.leipiplugins + "'") +
                                    ("title='" + data.title + "' value='" + data.value + "' identity='" + data.identity + "' type=text datasource='" + data.datasource + "'") +
                                    ("allowupload='" + data.allowupload + "'>");
                            break;
                        case 'iframerouter':
                            showData =
                                "<input name='" + data.name + "' leipiplugins='" + data.leipiplugins + "'" +
                                    ("type=text orderby='" + data.orderby + "' orgtitle='" + data.orgtitle + "' orgsrc='" + data.orgsrc + "' ") +
                                    ("orgtarget='" + data.orgtarget + "' orgchecked='" + data.orgchecked + "' ") +
                                    "style='width:100%;border:1px solid #ccc;height:500px;'>";
                            break;
                        case 'asscontrol':
                            showData =
                                "<input style='border:0;width: 30px;height: 30px;background: red;border-radius: 50%;cursor: pointer;box-shadow:5px 2px 6px #000;'" +
                                    ("name=leipiNewField leipiplugins='" + data.leipiplugins + "' eid='" + data.eid + "' ename='" + data.ename + "'") +
                                    ("nonull='" + data.nonull + "' pname='" + data.pname + "'/>");
                            break;
                        case 'wifiblock':
                            showData = "<div orgUrl='" + data.orgurl + "' name=\"" + data.name + "\"\n                                        leipiplugins='" + data.leipiplugins + "'\n                                        style=\"display:block border:" + data.orgborder + " " + data.orgcolor + ";border-radius:\n                                        " + data.orgradius + "px; text-align:" + data.gAlign + ";width:" + data.gWidth + ";height:" + data.gHeight + ";\n                                        font-size:" + data.gFontSize + "px;\"orgthide=\"" + data.gThidden + "\";\n                                        orgbghide=\"" + data.gBghidden + "\";orghide=\"" + data.gHidden + "\">\u200B\u200B&#8203;" + data.parse + "</div>";
                            break;
                        case 'reportcontrol':
                            showData =
                                "<input readonly='" + data.readonly + "' placeholder='\u62A5\u8868\u63A7\u4EF6' name='" + data.name + "' leipiplugins='" + data.leipiplugins + "'" +
                                    ("orderby='" + data.orderby + "' title='" + data.title + "' visualreport='" + data.visualreport + "' ") +
                                    ("node_name='" + data.node_name + "' field='" + data.field + "' pid='" + data.pid + "' ") +
                                    ("style='width: 150px;height: 30px;border:1px solid #ccc;' scoresourceid='" + data.scoresourceid + "' scoresourcename='" + data.scoresourcename + "' tps='" + data.tps + "' statisticstheme='" + data.statisticstheme + "' statisticalmaterials='" + data.statisticalmaterials + "'>");
                            break;
                        case 'group':
                            showData +=
                                "<table class=\"table\">" +
                                    "<tr class=\"search_row\"><td>" +
                                    ("<input  name=\"leipiNewField\" class=\"search-query\" type=\"text\"  title=\"" + data.title + "\" value=\"" + data.value + "\" datasource=\"" + data.datasource + "\" leipiplugins=\"" + data.leipiplugins + "\" orghide=\"" + data.orghide + "\" orgthide=\"" + data.orgthide + "\" orgbghide=\"" + data.orgbghide + "\" orgalign=\"" + data.orgalign + "\" orgwidth=\"150\" orgtype=\"text\" style=\"border: 1px solid ; text-align: left; width: 150px;\"/>") +
                                    "<button type=\"submit\" class=\"search_btn\">\u9AD8\u7EA7\u641C\u7D22</span></td></tr>" +
                                    "<tr><td class=\"navWf\"><a class=\"jinpin\" href=\"/editor/assets/ueditor/formdesign/preview.html?link=1255\">\u7CBE\u54C1</a><a class=\"tuijian\" href=\"/editor/assets/ueditor/formdesign/preview.html?link=1082\">\u63A8\u8350</a><a class=\"yidu\" href=\"/editor/assets/ueditor/formdesign/preview.html?link=1083\">\u5DF2\u8BFB</a><a class=\"shoucang\" href=\"http://" +
                                    localHost +
                                    "/editor/assets/ueditor/formdesign/preview.html?link=1084\">\u6536\u85CF</a></td></tr>" +
                                    "<tr><td>" +
                                    ("<div class=\"wifiblockBox\"><div class=\"wifiblock\" groupcon=\"" + data.groupcon + "\" orgvalue=\"" + data.gValue + "\" orgTitle=\"" + data.gTitle + "\" orgurl=\"/editor/assets/ueditor/formdesign/preview.html?link=" + data.orgfUrl + "\" style=\"display: flex;display: -webkit-flex;color: #333;\">") +
                                    ("<div class=\"wfImg\" ><input groupcon=\"" + data.groupcon + "\" name=\"leipiNewField\"  type=\"text\" title=\"" + data.title + "\" style=\"display: block;width: 100%;height: 100%;\" value=\"" + data.value + "\" datasource=\"" + data.datasource + "\" leipiplugins=\"" + data.leipiplugins + "\"></div>") +
                                    "<div class=\"wfDetail\">" +
                                    ("<div class=\"title\"><input groupcon=\"" + data.groupcon + "\" name=\"leipiNewField\" type=\"text\" title=\"" + data.title + "\" value=\"" + data.title + "\" datasource=\"" + data.datasource + "\" leipiplugins=\"" + data.leipiplugins + "\" orghide=\"" + data.orgthide + "\" orgthide=\"" + data.otgthide + "\" orgbghide=\"" + data.orgbghide + "\" orgalign=\"" + data.orgalign + "\" orgwidth=\"" + data.orgwidth + "\" orgtype=\"" + data.orgtype + "\" style=\"border: 1px solid; text-align: left; width: 150px;\"/></div>") +
                                    ("<div class=\"detail\"><input groupcon=\"" + data.groupcon + "\" title=\"" + data.title + "\" name=\"leipiNewField\" leipiplugins=\"" + data.leipiplugins + "\" value=\"" + data.value + "\" orgrich=\"" + data.orgrich + "\" datasource=\"" + data.datasource + "\" orgfontsize=\"" + data.orgfontsize + "\" orgwidth=\"" + data.orgwidth + "\" orgheight=\"" + data.orgheight + "\" style=\"width:300px;height:80px; \"/></div>") +
                                    ("<div class=\"autor\"><input groupcon=\"" + data.groupcon + "\" class=\"title\" name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\" datasource=\"\" leipiplugins=\"text\" orghide=\"1\" orgthide=\"0\" orgbghide=\"1\" orgalign=\"left\" orgwidth=\"150\" orgtype=\"text\" style=\"border: 1px solid; text-align: left;\"/></div>") +
                                    ("<div class=\"confscource\"><p groupcon=\"" + data.groupcon + "\" class=\"title\" name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\" datasource=\"\" leipiplugins=\"text\" orghide=\"1\" orgthide=\"0\" orgbghide=\"1\" orgalign=\"left\" orgwidth=\"150\" orgtype=\"text\" style=\"border: 1px solid; text-align: left; width: 150px;\"/></div>") +
                                    "</div></div></div></td></tr></table>";
                            break;
                        case 'pinglun':
                            showData = '<ul leipiplugins="pinglun" datasource=""></ul>';
                            break;
                        case 'conterie':
                            showData = "<div class=\"wifiblockBox conterie\">\n                               <div class=\"header\" style=\"width: 100%;display:flex;align-items: center;height: 45px;background:#16bbdf;font-size: 20px;justify-content: center\">\u5708\u5B50</div>\n                               <div class=\"wifiblock bodies\" name=\"leipiNewField\" leipiplugins=\"wifiblock\" orgthide=\"1\" value=\"\" title=\"\u8BF7\u8F93\u5165\u5185\u5BB9\" orgalign=\"left\" orgheight=\"\" orgwidth=\"500\" orgfonts=\"\" orgborder=\"1px solid\" orgcolor=\"#000000\" orgradius=\"1\" style=\"style=\"padding: 13px;  border-bottom: 1px solid #f5f5f5;\"\">\u200B\n                                 <div class=\"b_header\" style=\"display: flex;align-items: center\">\n                                   <input name=\"leipiNewField\"  groupCon=\"pid\" class=\"bh_img\" style=\"width: 68px;height:68px;padding:0;border-radius:34px;background: #00a0e9;\" type=\"text\" title=\"\u56FE\u7247\u4E0A\u4F20\" value=\"\u56FE\u7247\u4E0A\u4F20 - \u63A7\u4EF6\" datasource=\"{&quot;data&quot;:&quot;\u5708\u5B50132&quot;,&quot;field&quot;:&quot;data1&quot;}\" leipiplugins=\"addimage\">\n                                   <div class=\"bh_data\" style=\"margin-left: 10px;\">\n                                   <input name=\"leipiNewField\" groupCon=\"pid\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u59D3\u540D\" datasource=\"{&quot;data&quot;:&quot;\u5708\u5B50132&quot;,&quot;field&quot;:&quot;data2&quot;}\" leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" orgtype=\"text\" style=\"border: none;\">\n                                   <input name=\"leipiNewField\" groupCon=\"pid\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u767B\u9646\u65F6\u95F4\" datasource=\"{&quot;data&quot;:&quot;\u5708\u5B50132&quot;,&quot;field&quot;:&quot;data3&quot;}\" leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" orgtype=\"text\" style=\"border: none;\">\n                                  </div>\n                                  <div style=\"flex: 1;display: flex;justify-content: flex-end\"><div class=\"seebtn\"><i class=\"i_font ic-jiahao\" style=\"color:#a0a0a2\"></i>\u5173\u6CE8</div></div>\n                                 </div>\n                                 <div class=\"b_body\" style=\"display: flex;align-items: center;margin-top: 10px;\">\n                                   <input name=\"leipiNewField\" class=\"bh_img\" groupCon=\"pid\" style=\"width: 90px;height: 65px;\" type=\"text\" title=\"\u56FE\u7247\u4E0A\u4F20\" value=\"\u56FE\u7247\u4E0A\u4F20 - \u63A7\u4EF6\" datasource=\"{&quot;data&quot;:&quot;\u5708\u5B50132&quot;,&quot;field&quot;:&quot;data4&quot;}\" leipiplugins=\"addimage\">\n                                   <input name=\"leipiNewField\" groupCon=\"pid\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u5185\u5BB9\" datasource=\"{&quot;data&quot;:&quot;\u5708\u5B50132&quot;,&quot;field&quot;:&quot;data5&quot;}\" leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" orgtype=\"text\" style=\"border: none;\">\n                                 </div>\n                                 <div class=\"b_foot\" style=\"display: flex;align-items: center;flex-direction:row-reverse;height: 25px;margin-top: 10px;\">\n                                   <div  class=\"i_font ic-zhuanfa zhuanfa\"><i></i>\u8F6C\u53D1</div>\n                                   <div  class=\"i_font ic-dianzan dianzan\"><i></i>\u70B9\u8D5E</div>\n                                   <div  class=\"i_font ic-pinglun pinglun\"><i></i>\u8BC4\u8BBA</div>\n                                 </div>\n                                 <div class=\"pinglunbox\" >\n                                    <ul name=\"leipiNewField\" groupCon=\"pid\"  title=\"\u8BC4\u8BBA\"  datasource=\"\" leipiplugins=\"pinglun\" >\n                                    </ul>\n                                 </div>\n                               </div>\n                               <div class=\"inputKeys\" >\n                                 <div class=\"inputbox\" >\n                                  <input type=\"text\" class=\"txt\" style=\"outline: none;\">\n                                </div>\n                                 <div class=\"inputbtn\" >\n                                   \u56DE\u590D\n                                 </div>\n                               </div>\n                             </div>";
                            break;
                        case 'button':
                            showData =
                                "<input placeholder=\"" + data.orgname + "\" name='" + data.name + "' leipiplugins=button mode='" + data.mode + "' orderby='" + data.orderby + "' " +
                                    ("orgtitle='" + data.orgtitle + "' orgsrc='" + data.orgsrc + "' orgbgcolor='" + data.orgbgcolor + "' orgname='" + data.orgname + "' ") +
                                    ("orgheight='" + data.orgheight + "' orgwidth='" + data.orgwidth + "' orgfontcolor='" + data.orgfontcolor + "' orgurl='" + data.orgurl + "' formnode='" + data.formnode + "' btntype='" + data.btntype + "' tgnode='" + data.tgnode + "' winname='" + data.winname + "' fontsize='" + data.fontsize + "'>");
                            break;
                        case 'getuserid':
                            showData = " <input name=\"" + data.name + "\" leipiplugins=\"getuserid\" style=\"" + data.style + "\" placeholder=\"" + data.placeholder + "\"/>";
                            break;
                        case 'pagedetails':
                            showData = "<div class='wifiblockBoxs' style='border: 1px solid #ddd;'>\n                                <div class='header_top' style='position: relative;'><span onclick='history.go(-1)' style='position: absolute;left: 20px;'>&lt;</span>\u4E66\u7C4D\u8BE6\u60C5</div>\n                                <div class='contains'>\n                                    <div class='contains_img'>\n                                        <input groupCon='' name='leipiNewField'  type='text' identity='\u56FE\u7247\u4E0A\u4F20' title='\u56FE\u7247\u4E0A\u4F20' style='display: block;width: 100%;height: 100%;' value='\u56FE\u7247\u4E0A\u4F20 - \u63A7\u4EF6' datasource='' leipiplugins='addimage'>\n                                    </div>\n                                    <div class='contains_detail'>\n                                        <div class='contains_title'>\n                                            <input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u4E66\u540D\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                        </div>\n                                        <div class='contains_content'>\n                                            \u4F5C\u8005\uFF1A<input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u4F5C\u8005\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                        </div>\n                                        <div class='contains_content'>\n                                            \u51FA\u7248\u793E\uFF1A<input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u51FA\u7248\u793E\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                        </div>\n                                        <div class='contains_content'>\n                                            IBSN\uFF1A<input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"IBSN\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                        </div>\n                                        <div class='contains_content'>\n                                            \u63A8\u8350\u5BF9\u8C61\uFF1A<input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u63A8\u8350\u5BF9\u8C61\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                        </div>\n                                        <div class='contains_content'>\n                                            \u63A8\u8350\u7406\u7531\uFF1A<input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u63A8\u8350\u7406\u7531\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                        </div>\n                                    </div>\n                                </div>\n                                <div class='spacing'>\n                                    <div class='contains_title' style='font-size: 14px;'>\n                                        <input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u7B80\u4ECB\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                    </div>\n                                    <div class='contains_content'>\n                                        <input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u7B80\u4ECB\u5185\u5BB9\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;\"/>\n                                    </div>\n                                </div>\n                                <div class='nav_container'>\n                                    <div id='books' class='nav_btn nav_btnActive'>\u56FE\u4E66</div>\n                                    <div id='audio' class='nav_btn'>\u97F3\u9891</div>\n                                    <div id='video' class='nav_btn'>\u89C6\u9891</div>\n                                    <div id='question' class='nav_btn'>\u9898\u5E93</div>\n                                </div>\n                                <div data-allowjump='false' class='wifiblock books_con' name='leipiNewField' leipiplugins='wifiblock' orgUrlName=\"" + data.orgUrlName + "\" orgUrlId=\"" + data.orgUrlId + "\" orgvalue=\"\" orgTitle=\"\" orgurl=\"/editor/assets/ueditor/formdesign/preview.html?link=" + data.orgfUrl + "\" style='padding: 8px;border-bottom: 1px solid #ddd;'>\n                                    <div class='nav_top nav_books'>\n                                        <input groupCon='' name='leipiNewField' type='text' identity='\u6587\u4EF6\u4E0A\u4F20' title='\u6587\u4EF6\u4E0A\u4F20' style='display: block;width: 100%;height: 100%;' value='\u6587\u4EF6\u4E0A\u4F20 - \u63A7\u4EF6' datasource='' leipiplugins='addimage'>\n                                    </div>\n                                </div>\n                                <div data-allowjump='false' class='wifiblock audio_con' name='leipiNewField' leipiplugins='wifiblock' orgUrlName=\"" + data.orgUrlName + "\" orgUrlId=\"" + data.orgUrlId + "\" orgvalue=\"\" orgTitle=\"\" orgurl=\"/editor/assets/ueditor/formdesign/preview.html?link=" + data.orgfUrl + "\" style='padding: 8px;border-bottom: 1px solid #ddd;'>\n                                    <div class='nav_top nav_audio'>\n                                        <div style='flex: 2;'>\n                                            <input class='audioInput' groupCon='' name='leipiNewField' type='text' identity='\u6587\u4EF6\u4E0A\u4F20' title='\u6587\u4EF6\u4E0A\u4F20' style='display: block;width: 100%;height: 100%;' value='\u6587\u4EF6\u4E0A\u4F20 - \u63A7\u4EF6' datasource='' leipiplugins='addimage'>\n                                        </div>\n                                        <audio src='' controls loop='false' class='audio'></audio>\n                                    </div>\n                                    <div class='nav_bottom'>\n                                        <div class='iconfont icon-bofangsanjiaoxing'><i></i>23384\u6B21\u64AD\u653E</div>\n                                        <div class='iconfont icon-shijian'><i></i>00\u520600\u79D2</div>\n                                    </div>\n                                </div>\n                                <div data-allowjump='false' class='wifiblock video_con' name='leipiNewField' leipiplugins='wifiblock' orgUrlName=\"" + data.orgUrlName + "\" orgUrlId=\"" + data.orgUrlId + "\" orgvalue=\"\" orgTitle=\"\" orgurl=\"/editor/assets/ueditor/formdesign/preview.html?link=" + data.orgfUrl + "\" style='padding: 8px;border-bottom: 1px solid #ddd;'>\n                                    <div class='nav_top nav_video'>\n                                        <input groupCon='' name='leipiNewField'  type='text' identity='\u89C6\u9891\u4E0A\u4F20' title='\u89C6\u9891\u4E0A\u4F20' style='display: block;width: 100%;height: 100%;' value='\u89C6\u9891\u4E0A\u4F20 - \u63A7\u4EF6' datasource='' leipiplugins='addimage'>\n                                        <div class='video' style='margin-left: 100px;'></div>\n                                    </div>\n                                </div>\n                                <div class='question_con'></div>\n                                <div style='padding: 8px;display: flex;'>\n                                    <div style='margin-right: 16px;'><input groupCon='' name=\"leipiNewField\" type=\"text\" title=\"\u6587\u672C\u6846\" value=\"\u8BC4\u8BBA\" datasource='' leipiplugins=\"text\" orghide=\"0\" orgthide=\"1\" orgbghide=\"0\" orgalign=\"left\" orgwidth=\"150\" style=\"border: 1px solid; text-align: left; width: 150px;padding: 4px 6px !important;\"/></div>\n                                    <div class='iconfont icon-fenxiang' style='margin-right: 16px;'><i></i></div>\n                                    <div class='iconfont icon-guanzhu'><i></i></div>\n                                </div>\n                            </div>";
                            break;
                        case 'sort':
                            showData = "<input name='" + data.name + "' leipiplugins='sort' title='sort' nodeid='" + data.nodeid + "'>";
                            break;
                        case 'routerclassify':
                            showData = "<div></div>";
                            break;
                        case 'glc':
                            showData = "<input name=\"" + data.name + "\" type=\"text\" title=\"\u7BA1\u7406\u6761\u63A7\u4EF6\" value=\"\u7BA1\u7406 - \u63A7\u4EF6\" leipiplugins=\"glc\" nodeid=\"" + data.nodeid + "\" style=\"width: 80px;height: 30px;\">";
                            break;
                        case 'tpl':
                            showData = "<input home=\"" + data.home + "\" site=\"" + data.site + "\" work=\"" + data.work + "\" msg=\"" + data.msg + "\" workbench=\"" + data.workbench + "\" personal=\"" + data.personal + "\" choicetpl=\"" + data.choicetpl + "\" tpltype=\"" + data.tpltype + "\" isshow=\"" + data.isshow + "\" name=\"leipiNewField\" type=\"text\" title=\"tpl\" value=\"tpl\" leipiplugins=\"tpl\" style=\"height: 20px;width: 20px;border-radius: 8px;\" />";
                            break;
                        case 'mtpl':
                            showData = "<input home=" + data.home + " site=" + data.site + " work=" + data.work + " msg=" + data.msg + " name=\"leipiNewField\" type=\"text\" title=\"mtpl\" value=\"mtpl\" leipiplugins=\"mtpl\" style=\"height: 20px;width: 20px;border-radius: 8px;\" />";
                            break;
                        case 'daydate':
                            showData = "<input name=\"" + data.name + "\" dateid=\"" + data.dateid + "\" orgwidth=\"" + data.orgwidth + "\" orgheight=\"" + data.orgheight + "\" orgfontsize=\"" + data.orgfontsize + "\" placeholder=\"\u8BF7\u8F93\u5165\u65E5\u671F\" type=\"date\" title=\"" + data.title + "\" class=\"date_input\" leipiplugins=\"daydate\" style=\"width:" + data.orgwidth + ";height:" + data.orgheihgt + ";font-size:" + data.orgfontsize + "\" />";
                            break;
                        case 'timedate':
                            showData = "<input name=\"" + data.name + "\" placeholder=\"" + data.placeholder + "\" dateid=\"" + data.dateid + "\" type=\"" + data.type + "\" title=\"" + data.title + "\" leipiplugins=\"" + data.leipiplugins + "\" orgwidth=\"" + data.orgwidth + "\" orgheight=\"" + data.orgheight + "\" orgfontsize=\"" + data.orgfontsize + "\" style=\"width:" + data.orgwidth + "; height:" + data.orgheight + ";font-size:" + data.orgfontsize + "\" />";
                            break;
                        case 'iconrouter':
                            showData = "<input placeholder=\"" + data.orgtitle + "\" name=\"leipiNewField\" leipiplugins=\"button\" mode=\"" + data.mode + "\" orderby=\"" + data.orderby + "\" orgtitle=\"" + data.orgtitle + "\" orgsrc=\"" + data.orgsrc + "\" orgbgcolor=\"" + data.orgbgcolor + "\" orgname=\"" + data.orgname + "\" orgheight=\"" + data.orgheight + "\" orgwidth=\"" + data.orgwidth + "\" orgfontcolor=\"" + data.orgfontcolor + "\" orgurl=\"" + data.orgurl + "\" formnode=\"" + data.formnode + "\" btntype=\"" + data.btntype + "\" tgnode=\"" + data.tgnode + "\" winname=\"" + data.winname + "\">";
                            break;
                        case 'formlist':
                            showData = "<input personage_info=\"" + data.personage_info + "\" datasource=\"" + data.datasource + "\" datafield=\"" + data.datafield + "\" headshow=\"" + data.headshow + "\" tpl=\"" + data.tpl + "\" pagesize=\"" + data.pagesize + "\" showpage=\"" + data.showpage + "\" frmedit=\"" + data.frmedit + "\" frmdel=\"" + data.frmdel + "\" frmexa=\"" + data.frmexa + "\" style=\"" + data.style + "\" name=\"" + data.name + "\" listpich=\"" + data.listpich + "\" listpicw=\"" + data.listpicw + "\" url=\"" + data.url + "\" searchcon='" + data.searchcon + "'  type=\"text\" title=\"" + data.title + "\" value=\"" + data.title + "\" listfontsize=\"" + data.listfontsize + "\" seardelval=\"" + data.seardelval + "\" listheight=\"" + data.listheight + "\" searchbyidorname=\"" + data.searchbyidorname + "\" center=\"" + data.center + "\" theaderbackground=\"" + data.theaderbackground + "\" leipiplugins=\"formlist\" />";
                            break;
                        case 'meetinglist':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"" + data.leipiplugins + "\" type=\"" + data.type + "\" value=\"" + data.value + "\" title=\"" + data.title + "\" datasource=\"" + data.datasource + "\" datafield=\"" + data.datafield + "\" pagesize=\"" + data.pagesize + "\" headshow=\"" + data.headshow + "\" tpl=\"" + data.tpl + "\" showpage=\"" + data.showpage + "\" listpicw=\"" + data.listpicw + "\" listpich=\"" + data.listpich + "\" roomurl=\"" + data.roomurl + "\" listfontsize=\"" + data.listfontsize + "\" searchcon=\"" + data.searchcon + "\" seardelval=\"" + data.seardelval + "\" mtype=\"" + data.mtype + "\" mtitle=\"" + data.mtitle + "\" style=\"" + data.style + "\"/>";
                            break;
                        case 'scheduling':
                            showData = "<input datasource=\"" + data.datasource + "\" datafield=\"" + data.datafield + "\" headshow=\"" + data.headshow + "\" tpl=\"" + data.tpl + "\" pagesize=\"" + data.pagesize + "\" showpage=\"" + data.showpage + "\" frmedit=\"" + data.frmedit + "\" frmdel=\"" + data.frmdel + "\" style=\"" + data.style + "\" name=\"" + data.name + "\" listpich=\"" + data.listpich + "\" listpicw=\"" + data.listpicw + "\"  type=\"text\" title=\"" + data.title + "\" value=\"" + data.value + "\" leipiplugins=\"scheduling\" />";
                            break;
                        case 'wxlist':
                            showData = "<input name=\"" + data.name + "\" type=\"text\" title=\"\u5FAE\u4FE1\u77ED\u4FE1\u5217\u8868\" value=\"\u5FAE\u4FE1\u77ED\u4FE1\u5217\u8868\" leipiplugins=\"wxlist\" style=\"" + data.style + "\" msgflag=\"" + data.msgflag + "\" wxsendtype=\"" + data.wxsendtype + "\" pagesize=\"" + data.pagesize + "\"/>";
                            break;
                        case 'listone':
                            showData = "<input isnotuser=\"" + data.isnotuser + "\" name=\"" + data.name + "\" leipiplugins=\"listone\" type=\"text\" value=\"" + data.value + "\" title=\"" + data.title + "\" datasource=\"" + data.datasource + "\" datapic=\"" + data.datapic + "\" datatitle=\"" + data.datatitle + "\" datacontent=\"" + data.datacontent + "\" datacontent2=\"" + data.datacontent2 + "\" pagesize=\"" + data.pagesize + "\" listpich=\"" + data.listpich + "\" listpicw=\"" + data.listpicw + "\" url=\"" + data.url + "\" style=\"height: 20px;line-height: 20px;\" bottomline=\"" + data.bottomline + "\" showpage=\"" + data.showpage + "\" orderby=\"" + data.orderby + "\" colnumber=\"" + data.colnumber + "\" tpl=\"" + data.tpl + "\" titlesize=\"" + data.titlesize + "\" consize=\"" + data.consize + "\" titlelabel=\"" + data.titlelabel + "\" conlabel=\"" + data.conlabel + "\" typesevendate=\"" + data.typesevendate + "\" frmedit=\"" + data.frmedit + "\" fontsize=\"" + data.fontsize + "\" frmdel=\"" + data.frmdel + "\" searchcon=\"" + data.searchcon + "\" seardelval=\"" + data.seardelval + "\" picfontsize=\"" + data.picfontsize + "\" listheight=\"" + data.listheight + "\" prefix=\"" + data.prefix + "\" isheader=\"" + data.isheader + "\" headertitle=\"" + data.headertitle + "\" moreurl=\"" + data.moreurl + "\" headercolor=\"" + data.headercolor + "\" titlecolor=\"" + data.titlecolor + "\" iscomment=\"" + data.iscomment + "\" outborder=\"" + data.outborder + "\" prefixcolor=\"" + data.prefixcolor + "\" headstyle=\"" + data.headstyle + "\" headimgsrc=\"" + data.headimgsrc + "\" pagingstyle=\"" + data.pagingstyle + "\" isscore=\"" + data.isscore + "\" onlyshowone=\"" + data.onlyshowone + "\" multisource=\"" + data.multisource + "\" multititles=\"" + data.multititles + "\" multisourcenames=\"" + data.multisourcenames + "\" multinodeids=\"" + data.multinodeids + "\" multidatapics=\"" + data.multidatapics + "\" multidatatitles=\"" + data.multidatatitles + "\" multidatacontents=\"" + data.multidatacontents + "\" multititlesizes=\"" + data.multititlesizes + "\" multiconsizes=\"" + data.multiconsizes + "\" multititlelabels=\"" + data.multititlelabels + "\" multiconlabels=\"" + data.multiconlabels + "\" multifontsizes=\"" + data.multifontsizes + "\" multilistpicws=\"" + data.multilistpicws + "\" multilistpichs=\"" + data.multilistpichs + "\" multilisturls=\"" + data.multilisturls + "\" multisearchcons=\"" + data.multisearchcons + "\" multiseardelvals=\"" + data.multiseardelvals + "\" multipicfontsizes=\"" + data.multipicfontsizes + "\" multilistheights=\"" + data.multilistheights + "\" multirowsourcecount=\"" + data.multirowsourcecount + "\" multisourcepublic=\"" + data.multisourcepublic + "\"   typesevenurl=\"" + data.typesevenurl + "\"   iscolor=\"" + data.iscolor + "\"/>";
                            break;
                        case 'classify':
                            showData = "<input name=\"" + data.name + "\" title=\"" + data.title + "\" value=\"" + data.value + "\" cid=\"" + data.cid + "\" sonid=\"" + data.sonid + "\" nid=\"" + data.nid + "\" type=\"text\" classtype=\"" + data.classtype + "\" leipiplugins=\"classify\" datasource=\"" + data.datasource + "\" datafiled=\"" + data.datafiled + "\" />";
                            break;
                        case 'wxgrouptag':
                            showData = "<input name=\"" + data.name + "\" type=\"text\" title=\"\u5FAE\u4FE1\u5206\u7EC4\u6807\u7B7E\" value=\"\u5FAE\u4FE1\u5206\u7EC4\u6807\u7B7E\" msgflag=\"" + data.msgflag + "\" leipiplugins=\"wxgrouptag\" style=\"width: 90px;height: 30px;\"/>";
                            break;
                        case 'settimeout':
                            showData = "<input orgtime=\"" + data.orgtime + "\" orgwidth=\"" + data.orgwidth + "\" orgheight=\"" + data.orgheight + "\" name=\"leipiNewField\" type=\"text\" color=\"" + data.color + "\" title=\"" + data.title + "\" value=\"" + data.title + "\" orgfontsize=\"" + data.orgfontsize + "\" leipiplugins=\"settimeout\" style=\"" + data.style + "\"/>";
                            break;
                        case 'searchcontrol':
                            showData = "<input name=\"" + data.name + "\" searchName=\"" + data.searchname + "\" searchContent=\"" + data.searchcontent + "\" type=\"text\" leipiplugins=\"" + data.leipiplugins + "\" style=\"height: 20px;width: 20px;border-radius: 8px;\"\n                                searchFieldText=\"" + data.searchfieldtext + "\" searchFieldValue=\"" + data.searchfieldvalue + "\" prdId=\"" + data.prdid + "\" nodeId=\"" + data.nodeid + "\" orgwidth=\"" + data.orgwidth + "\" orgheight=\"" + data.orgheight + "\"\n                               searchKeyDataText=\"" + data.searchkeydatatext + "\" searchKeyDataValue=\"" + data.searchkeydatavalue + "\" orgtitle=\"" + data.orgtitle + "\" orgchecked=\"" + data.orgchecked + "\"/>";
                            break;
                        case 'buylabel':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"buylabel\" mode=\"" + data.mode + "\" orgtitle=\"" + data.orgtitle + "\" orgsrc=\"" + data.orgsrc + "\" value=\"" + data.value + "\" orgheight=\"" + data.orgheight + "\" orgwidth=\"" + data.orgwidth + "\" orgfontsize=\"" + data.orgfontsize + "\" orgbgcolor=\"" + data.orgbgcolor + "\" orgfontcolor=\"" + data.orgfontcolor + "\" orgfurl=\"" + data.orgfurl + "\" orgurl=\"" + data.orgurl + "\"/>";
                            break;
                        case 'popup':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"popup\" mode=\"" + data.mode + "\" orgtitle=\"" + data.orgtitle + "\" orgsrc=\"" + data.orgsrc + "\" value=\"" + data.value + "\" orgheight=\"" + data.orgheight + "\" orgwidth=\"" + data.orgwidth + "\" orgfontsize=\"" + data.orgfontsize + "\" orgbgcolor=\"" + data.orgbgcolor + "\" orgfontcolor=\"" + data.orgfontcolor + "\" orgfurl=\"" + data.orgfurl + "\" orgurl=\"" + data.orgurl + "\"/>";
                            break;
                        case 'lunbo':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"" + data.leipiplugins + "\" type=\"" + data.type + "\" value=\"" + data.value + "\" title=\"" + data.title + "\" datasource=\"" + data.datasource + "\" limtvalue=\"" + data.limtvalue + "\" datapic=\"" + data.datapic + "\" datatitle=\"" + data.datatitle + "\" dataurl=\"" + data.dataurl + "\" orgwidth=\"" + data.orgwidth + "\" orgheight=\"" + data.orgheight + "\" client=\"" + data.client + "\" wtime=\"" + data.wtime + "\" />";
                            break;
                        case 'addnumber':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"" + data.leipiplugins + "\" mode=\"" + data.mode + "\" orgtitle=\"" + data.orgtitle + "\" orgsrc=\"" + data.orgsrc + "\" value=\"" + data.value + "\" addvalue=\"" + data.addvalue + "\" orgheight=\"" + data.orgheight + "\" orgwidth=\"" + data.orgwidth + "\" orgfontsize=\"" + data.orgfontsize + "\" orgbgcolor=\"" + data.orgbgcolor + "\" orgfontcolor=\"" + data.orgfontcolor + "\" datasource=\"" + data.datasource + "\" datafiled=\"" + data.datafiled + "\"/>";
                            break;
                        case 'recordlabel':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"recordlabel\" type=\"text\" value=\"" + data.value + "\" title=\"" + data.title + "\" datasource=\"" + data.datasource + "\" datatitle=\"" + data.datatitle + "\"/>";
                            break;
                        case 'background':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"background\" type=\"text\" value=\"" + data.value + "\" title=\"" + data.title + "\" bagcolor=\"" + data.bagcolor + "\" bagpic=\"" + data.bagpic + "\"/>";
                            break;
                        case 'export':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"export\" type=\"text\" value=\"" + data.value + "\" title=\"" + data.title + "\" datasource=\"" + data.datasource + "\" datafield=\"" + data.datafield + "\" pluwidth=\"" + data.pluwidth + "\" pluheight=\"" + data.pluheight + "\" fontsize=\"" + data.fontsize + "\" bgcolor=\"" + data.bgcolor + "\" fontcolor=\"" + data.fontcolor + "\" style=\"" + data.style + "\"/>";
                            break;
                        case 'shenpi':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"shenpi\" type=\"text\" value=\"" + data.value + "\" title=\"" + data.title + "\" datasource=\"" + data.datasource + "\" datafiled=\"" + data.datafiled + "\" spstate=\"" + data.spstate + "\" pluheight=\"" + data.pluheight + "\" fontsize=\"" + data.fontsize + "\" spdel=\"" + data.spdel + "\" spdbox=\"" + data.spdbox + "\" style=\"width: 80px;\"/>";
                            break;
                        case 'internal':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"internal\"\n                                type=\"" + data.type + "\" value=\"" + data.value + "\"\n                                title=\"" + data.title + "\" pluheight=\"" + data.pluheight + "\"\n                                fontsize=\"" + data.fontsize + "\"\n                                style=\"width:80px;\"/>";
                            break;
                        case 'exchange':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"exchange\" mode=\"" + data.mode + "\" orgtitle=\"" + data.orgtitle + "\" orgsrc=\"" + data.orgsrc + "\" value=\"" + data.value + "\" orgheight=\"" + data.orgheight + "\" orgwidth=\"" + data.orgwidth + "\" orgfontsize=\"" + data.orgfontsize + "\" orgbgcolor=\"" + data.orgbgcolor + "\" orgfontcolor=\"" + data.orgfontcolor + "\" orgfurl=\"" + data.orgfurl + "\" orgurl=\"" + data.orgurl + "\"/>";
                            break;
                        case 'login':
                            showData = "<input name=\"" + data.name + "\" leipiplugins=\"login\"\n                                mode=\"" + data.mode + "\"                orgtitle=\"" + data.orgtitle + "\"\n                                value=\"" + data.value + "\" orgheight=\"" + data.orgheight + "\"\n                                orgwidth=\"" + data.orgwidth + "\" orgfontsize=\"" + data.orgfontsize + "\"\n                                orgbgcolor=\"" + data.orgbgcolor + "\" orgfontcolor=\"" + data.orgfontcolor + "\" toaccount=\"" + data.toaccount + "\"/>";
                            break;
                        case 'onlinehard':
                        case 'workword':
                        case 'workform':
                        case 'workflow':
                        case 'schedule':
                        case 'task':
                        case 'beike':
                        case 'resource':
                        case 'teach':
                        case 'class':
                        case 'curriculum':
                        case 'jiangtang':
                        case 'zujuan':
                        case 'yuejuan':
                        case 'chaxun':
                        case 'audit':
                            showData = "<input width=\"" + data.orgwidth + "\" height=\"" + data.orgheight + "\"  home=" + data.home + "  name=\"leipiNewField\" type=\"text\" title=\"mtpl\" value=\"mtpl\" leipiplugins=\"mtpl\" style=\"height: 20px;width: 20px;border-radius: 8px;\" />";
                            break;
                        default:
                            showData = '您保存的数据错误...(系统显示)';
                            break;
                    }
                    var parsen, // parse临时变量 i 为 0 1 时使用
                    parsec; // 临时变量
                    if (i === 0) {
                        parsen = parseShow(parse, field);
                        editor.Instance.setContent(parsen);
                    }
                    else if (i === 1) {
                        parsec = parseShow(parsen, field);
                        editor.Instance.setContent(parsec);
                    }
                    else {
                        parsec = parseShow(parsec, field);
                        editor.Instance.setContent(parsec);
                    }
                }
            }
            else {
                if (sessionStorage.getItem('editorStyle') === 'phone') {
                    editor.Instance.setContent(res['msg'].phoneParse);
                }
                else {
                    editor.Instance.setContent(res['msg'].parse);
                }
            }
            function parseShow(obj, dataField) {
                return obj.replace("{" + dataField + "}", showData);
            }
        });
    };
    InsertDataService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_0__angular_http__["b" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_0__angular_http__["b" /* Http */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__httpData_service__["a" /* HttpDataService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__httpData_service__["a" /* HttpDataService */]) === "function" && _b || Object])
    ], InsertDataService);
    return InsertDataService;
    var _a, _b;
}());

//# sourceMappingURL=insertData.service.js.map

/***/ }),

/***/ "../../../../../src/assets/icon/ueswmobile.png":
/***/ (function(module, exports) {

module.exports = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAH8AAAAdBAMAAABxr65xAAAAAXNSR0IArs4c6QAAACpQTFRF/5kA/////+3T/Z4M/6op//nu+/Hg8atAt6WL6Z0s/8Vs/9WW/8FiqampdJ7fwQAAAJVJREFUOMtjEF3CQD5gOSrAEMJACWBOYFhAkQEMBQwOlBlgwDB4gACF+hkTKDRAEALId4cghEok3wsQuxkpDUqyDWAWAIcCQyAFPgAbIE2p0wUoNICFbAMCIT5gJNsAaQojgYHiVAAxgFWA0qwgSH7pqAQGgpQmZEoLBeYBKcooLpUPUGbABIZgykKtgUGsmBL9My4AABNLDYQfNl28AAAAAElFTkSuQmCC"

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map