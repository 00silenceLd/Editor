(function (window, undefined){
	var count = 0,		
		inputCount = 0,
		gdatafiled=null;		
		ynTrees = {},
		classNameCfg = {			
			spread: "spread",			
			shrink: "shrink"
		}	
	function YnTree(ele, options,datafiled){
		gdatafiled=datafiled;
		if(!ele || !ele.nodeName || (ele.nodeType != 1)){
			throw "YnTree 第一个参数必须是一个元素！";
		}
		this.ele = ele;
		var type = YnTree.getType(options);
		
		if(type != "object"){
			throw "YnTree 第二个参数必须是一个对象！";
		}
		this.options = options;
		!this.options.data ? this.options.data = [] :"";		
		if(YnTree.getType(this.options.data) == "object"){ 
			this.options.data = [this.options.data];
		}
		
		this.data = [];		
		this.parallel = [];
		this.id = "yn_tree" + (++count);
		this.tree = YnTree.createDomByString('<ul class="yn-tree" id="' + this.id + '"></ul>');
		this._init();
	}
	YnTree.prototype._init = function (){
		var that = this;
		if(this.options.data.length > 0){			
			this._copyData(this.options.data, this.data);
			this._createDom(this.data);
			this._assemblyDom(this.tree, this.data);
		}
		this.ele.appendChild(this.tree);		
		ynTrees[this.id] = this;
		return this;
	}
	YnTree.prototype.version = "1.0.0";	
	YnTree.prototype._copyData = function (data, parent){
		var that = this;
		data = data || that.options.data;
		YnTree.getType(data) != "array" ? (data = [data]) : "";

		YnTree.forEach(data, function (index, item){
			if(item.children){
				var obj = new CompositeLeaf(item, "composite", that.id);
				parent.push(obj);
				that.parallel.push(obj);
				that._copyData(item.children, obj.children);
			}else{
				var obj = new CompositeLeaf(item, "leaf", that.id);
				parent.push(obj);
				that.parallel.push(obj);
			}			
		});
		
		return this;
	}
	YnTree.prototype._createDom = function (data, parent){
		var that = this;		

		YnTree.forEach(data, function (index, item){
			var html = '',
				id = 'yn_tree_input' + (++inputCount),
				nameVal = item.inputName ? item.inputName : "",
				val = item.value ? item.value : "",
				checked = item.checked ? item.checked : false,
				disabled = item.disabled ? item.disabled : false,
				className = item.className ? item.className : "";
			html += '<li class="yn-tree-li shrink" id="' + id + '_li" ' + (parent ? ('pid="' + parent.id + '"') : "") + '>';
			html += '	<div class="checkbox">';
			if(item.children.length){
				html += '<span class="arrow arrow-right"></span>';
			}else{
				html += '<span class="arrow"></span>';
			}

			html += '		<label onclick="doClassify(\''+gdatafiled+'\',\''+item.id+'\')">';
			html += item.name;
			html += '		</label>';
			html += '	</div>';
			if(item.children.length){
				html += '<ul class="yn-tree"></ul>';
				item.type = "composite";
			}else{
				item.type = "leaf";
			}
			html += '</li>';

			item.id = id;
			item.pid = (parent ? parent.id : null);
			item.dom = YnTree.createDomByString(html);
			if(item.children.length){				
				arrowBindClickEvent(item.dom.querySelector(".arrow-right"), item);
			}
			if(item.children.length){
				that._createDom(item.children, item);
			}
		});

		return this;
	}
	
	YnTree.prototype._assemblyDom = function(parent, data){
		var that = this;
		if(!parent && !data){
			return this;
		}
		YnTree.getType(data) != "array" ? (data = [data]) : data;

		YnTree.forEach(data, function (index, item){
			parent.appendChild(item.dom);

			if(item.children){
				that._assemblyDom(item.dom.querySelector(".yn-tree"), item.children);
			}
		});

		return this;
	}
	
	YnTree.prototype.select = function (condition, flag){
		var that = this,
			dataItem = null;
		YnTree.forEach(that.parallel, function(index, item){
			var curInput = document.getElementById(item.id);
			if(condition === item.id || condition === item.value || condition === curInput){
				dataItem = item;
				return false;
			}
		});
		dataItem.select(flag);
		return this;
	}
	
	YnTree.prototype.disable = function (condition, flag){
		var that = this,
			dataItem = null;
		YnTree.forEach(that.parallel, function(index, item){
			var curInput = document.getElementById(item.id);
			if(condition === item.id || condition === item.value || condition === curInput){
				dataItem = item;
				return false;
			}
		});
		dataItem.disable(flag);
		return this;
	}
	
	YnTree.prototype.getCheckedInputs = function (){
		var that = this,
			checkedInput = [];
		YnTree.forEach(that.parallel, function (index, item){
			if(item.checked){
				checkedInput.push(document.getElementById(item.id));
			}
		});
		return checkedInput;
	}
	
	YnTree.prototype.getValues = function (){
		var that = this,
			checkedVals = [];
		YnTree.forEach(that.getCheckedInputs(), function (index, item){
			checkedVals.push(item.value);
		});
		return checkedVals;
	}
	
	YnTree.prototype.reInit = function (data){
		var that = this;		

		if(data && YnTree.getType(data) == "array"){
			this.options.data = data;
		}

		
		if(this.options.data.length > 0){
			this.ele.removeChild(this.tree);
			this.tree = YnTree.createDomByString('<ul class="yn-tree" id="' + this.id + '"></ul>');
			this.data = [];
			this._copyData(this.options.data, this.data);
			this._createDom(this.data);
			this._assemblyDom(this.tree, this.data);
			this.ele.appendChild(this.tree);
		}
		return this;
	}
	
	YnTree.prototype.destroy = function (){
		this.ele.removeChild(this.tree);
		this.options = null;
		this.parallel = null;
		this.tree = null;
		this.id = null;
		this.data = null;
		this.ele = null;
		console.info("YnTree销毁完毕，建议您将YnTree的实例置为null，如：\r\n var ynTree = new YnTree(...);\r\n ynTree.destroy();\r\n ynTree = null;");
	}
	
	YnTree.prototype.spread = function (condition, flag){
		var that = this,
			dataItem = null;
		YnTree.forEach(that.parallel, function(index, item){
			var curInput = document.getElementById(item.id);
			if(condition === item.id || condition === item.value || condition === curInput){
				dataItem = item;
				return false;
			}
		});
		if(dataItem.type == "leaf"){
				return this;
		}
		dataItem.spread(flag);
		return this;
	}

	
	YnTree.createDomByString = function (htmlStr){
		var ele = document.createElement("div"),
			dom;
		ele.innerHTML = htmlStr;
		dom = ele.children;
		ele = null;
		return dom[0];
	}
	
	YnTree.getType = function (data){
		var type = Object.prototype.toString.call(data);
		return type.replace("[","").replace("]","").split(" ")[1].toLowerCase();
	}
	
	YnTree.forEach = function (arr, fn){
		if(YnTree.getType(arr) != "array"){
			return arr;
		}
		for(var i = 0, len = arr.length; i < len; i++){
			var val = fn.call(arr[i], i, arr[i]);
			if(val === false){
				break;
			}
		}
		return arr;
	}
	
	YnTree.on = function (ele, type, fn){
		if(document.addEventListener){
			ele.addEventListener(type, fn, false);
		}else if(window.attachEvent){			
			if(!ele["_" + type +"_event"]){
				var arr = [fn];
				ele["_" + type +"_event"] = arr;
			}else{
				ele["_" + type +"_event"].push(fn);
			}
			ele.attachEvent("on" + type, function (){
				var e = window.event;				
				e.preventDefault = function (){
					e.returnValue = false;
				}
				e.stopPropagation = function (){
					e.calcleBubble = true;
				}
				e.target = e.srcElement;
				fn.call(ele, e);
			});
		}
		return ele;
	}
	
	YnTree.extend = function (target, obj){
		for(var attr in obj){
			if(obj.hasOwnProperty(attr)){
				target[attr] = obj[attr];
			}
		}
		return target;
	}
	function bindChangeEvent(input, currentData){
		YnTree.on(input, "change", function (e){
			var curInput = e.target;
			currentData.select(curInput.checked);
		});
	}
	
	function arrowBindClickEvent(arrowEle, currentData){
		YnTree.on(arrowEle, "click", function (e){
			currentData.spread();
		});
	};

	
	function CompositeLeaf(options, type, ynTreeId){
		this.type = type || "";
		YnTree.extend(this, options || {});		
		if(this.children){
			this.children = [];	
		}
		this.ynTreeId = ynTreeId;
	}
	CompositeLeaf.prototype = {
		constructor: CompositeLeaf,		
		selectDown: function(flag){
			var that = this;
			flag = !!flag;
			
			if(that.children){
				YnTree.forEach(that.children, function (index, item){
					if(!item.disabled){
						item.checked = flag;
						item.dom.querySelector(".yn-tree-input").checked = flag;
					}
					
					if(item.children){
						YnTree.forEach(item.children, arguments.callee);
					}
				});
			}
			return this;
		},		
		selectUp: function(flag){
			var that = this,
				parent = null;
			flag = !!flag;

			if(!this.pid){ return this; }
			YnTree.forEach(that.getYnTree(that.ynTreeId).parallel, function (index, item){				
				if(item.id === that.pid){
					parent = item;
					return false;
				}
			});
			if(flag){
				parent.checked = flag;
				document.getElementById(parent.id).checked = flag;
			}else{
				var allChildNotChecked = true;
				YnTree.forEach(parent.children, function (index, item){
					if(item.checked){
						allChildNotChecked = false;
						return false;
					}
				});
				if(allChildNotChecked){
					parent.checked = flag;
					document.getElementById(parent.id).checked = flag;
				}
			}
			if(parent.pid){
				parent.selectUp(flag);
			}
			return this;
		},		
		select: function (flag){
			var that = this,
				input = document.getElementById(that.id),
				ynTree = this.getYnTree(this.ynTreeId);
			flag = !!flag;
			if(!that.disabled){
				that.checked = flag;
				input.checked = flag;
			}
			ynTree.options.onchange && (YnTree.getType(ynTree.options.onchange) == "function") && ynTree.options.onchange.call(this, input, ynTree);			
			if(typeof ynTree.options.checkStrictly == "undefined" || ynTree.options.checkStrictly === true){
				if(that.type == "composite"){
					this.selectDown(flag);	
				}
				if(that.pid){
					this.selectUp(flag);
				}
			}
			
			return this;
		},
		disable: function (flag){
			var that = this,
				input = document.getElementById(that.id),
				ynTree = this.getYnTree(this.ynTreeId);
			flag = !!flag;

			that.disabled = flag;
			input.disabled = flag;
			
			return this;
		},	
		getYnTree: function (id){
			var ynTree;
			if(id in ynTrees){
				ynTree = ynTrees[id];
			}
			return ynTree;
		},		
		spread: function (flag){
			var that = this,
				curLi = document.getElementById(that.id + "_li"),
				ynTree = this.getYnTree(this.ynTreeId),
				classNameArr = curLi.className.split(" "),
				hasSpreadClass = false,
				spreadClassIndex = -1,
				hasShrinkClass = false,
				shrinkClassIndex = -1;

			if(that.type == "leaf"){
				return this;
			}

			for(var i = 0,len = classNameArr.length; i < len; i++){
				if(classNameArr[i] === classNameCfg.spread){
					hasSpreadClass = true;
					spreadClassIndex = i;
				}
				if(classNameArr[i] === classNameCfg.shrink){
					hasShrinkClass = true;
					shrinkClassIndex = i;
				}
			}
			if(typeof flag == "undefined"){
				if(hasSpreadClass){
					flag = false;
				}else if(hasShrinkClass){
					flag = true;
				}
			}

			flag = !!flag;


			if(flag){
				if(hasSpreadClass){return this;}				
				if(hasShrinkClass){
					classNameArr.splice(shrinkClassIndex, 1);
				}
				classNameArr.push(classNameCfg.spread);
				curLi.className = classNameArr.join(" ");
			}else{
				if(hasShrinkClass){return this;}				
				if(hasSpreadClass){
					classNameArr.splice(spreadClassIndex, 1);
				}
				classNameArr.push(classNameCfg.shrink);
				curLi.className = classNameArr.join(" ");
			}
			
			return this;
		}
		
	}

	window.YnTree = YnTree;
})(window, undefined);
