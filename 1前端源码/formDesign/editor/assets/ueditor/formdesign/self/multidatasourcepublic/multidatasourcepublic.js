$('#selectPublicSourceId').change(function() {
  var selectSourceName = $('#selectPublicSourceId').find('option:selected').html();
  var selectSourceId = $('#selectPublicSourceId').find('option:selected').val();

  /* console.log(selectSourceName);
  console.log(selectSourceId); */

  if (selectSourceId != 0) {
    getNodeConent(selectSourceId);
  }

  if ($('#assetDetailTableId')) {
    assetDetailLayuiInit();
  }


});


$(function() {

  var nodeId = $('#selectPublicSourceId').attr('thisnodeid');

  $.ajax({
    url: prevent_HOST + 'nodeQueryFacade/getThisSlavePage?nodeId=' + nodeId,
    async: false,
    /* type: 'GET',
    dataType: 'json',
    contentType: 'application/json; charset=UTF-8',
    data: JSON.stringify(data), */
    success: function(res) {
      if (res.status == "200") {
        var slaveInfos = res.msg;
        console.log(slaveInfos)
        if (slaveInfos.length > 0) {
          var html = '<option value="0">请选择数据源</option>';
          for (var i = 0; i < slaveInfos.length; i++) {
            var slaveInfo = slaveInfos[i];
            html +=
              '<option value="' + slaveInfo.nodeId + '">' + slaveInfo.nodeName.split('nid')[0] + '</option>';

          }
          $('#selectPublicSourceId').html(html);
        }
      }
    }
  })




})
