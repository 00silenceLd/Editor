
    /*
     * 自己编写的方法集合
     *
     */
    var curreditnode = null;
    var currNode = null;
    var currRecord=null;
    var urlMethod=null;
    var isSrcs = "";
    var isSrc=false;
    var selectId=null; // 选择的Id  -- 修改 用
    $(function () {
        jQuery.prototype.serializeObject = function () {
            var obj = new Object();
            $.each(this.serializeArray(), function (index, param) {
                if (!(param.name in obj)) {
                    obj[param.name] = param.value;
                }
            });
            return obj;
        };

        clearInputValue = function (event) {
            var target = event.target,
                can = target.getAttribute('clear');

            if (can === 'true') {
                target.setAttribute('value', '');
                target.setAttribute('clear', 'false');
            }
        }

        var row = 0;
        tdAddRow = function (source, event) {
            row++;
            var target = $('#${source.id} .template'),
                clone = target.clone(true).removeClass('template').addClass('add');
            // clone.find( 'input' ).attr( 'value', '' );
            // console.log( clone.find( 'input' ) )
            clone.find('input').val('');
            clone.find('input').each(function (index, elem) {
                elem.name = 'list${row}${index}';
            })
            clone.find('td').last().html("<a href='javascript:;' onclick='tdDelRow(this)'>删除</a>");
            clone.insertBefore($('.fContainer'));
        }

        tdDelRow = function (that) {
            $(that).parents('tbody').remove();
        }

        changeSum = function (event) {
            var index = event.target.name.split('').pop(), // 总和是第几个列
                input = $('input[name="list' + index + 'total"]'), // 显示总和的那个div
                inputLen = $('.cContainer').length, // 现在有多少行
                totalValue = 0; // 数值总和
            for (var i = 0; i < inputLen; i++) {
                // console.log( index )
                totalValue = totalValue + ($('input[name="list' + i + index + '"].sum').val() == '' ? 0 : parseFloat($(
                    'input[name="list' + i + index + '"].sum').val()));
                // console.log( $( 'input[name="list' + i + index + '"].sum' ).val() )
            }
            input.attr('value', totalValue);
        }
    });

    $(function () {
        /*
         * 这是保存用的，让后台把isLink变为true，nodeId改成当前的nodeId
         * 就可以打包生成相对应的项目文件
         */
        var exportIsLink = false;
        if (exportIsLink === true) {
            var exportNodeId = 2875;
            window.location.hash = '#link=' + exportNodeId;
            $(function () {
                if ($('.iframeRouterContainer').length !== 0) {
                    var $elem = $('.btnContainer');
                    for (var i = 0; i < $elem.length; i++) {
                        //console.log( $elem.eq( i )[ 0 ].dataset.url );
                    }
                }
            })
        }
    })