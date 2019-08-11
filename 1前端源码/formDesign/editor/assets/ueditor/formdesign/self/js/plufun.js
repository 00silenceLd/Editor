function setDataSource(uid){
    var nodeshtml='';
    $.ajax( {
        url: prevent_HOST + 'nodeQueryFacade/getDataSourceByUid?uId='+uid,
        method: 'GET',
        success: function ( res ) {
            $.each( res.msg, function ( index, value ) {
                nodeshtml+='<option value=' + value.id +':'+value.value+'>' + value.value + '</option>';
            })
            window.localStorage.setItem('datasource_'+uid,nodeshtml);
            $( "#datasource" ).append(nodeshtml);
        },
        error: function ( res ) {
            alert( '抱歉！获取 数据链接 失败！因为您好像还没有选择表哦！' )
        }
    });
}