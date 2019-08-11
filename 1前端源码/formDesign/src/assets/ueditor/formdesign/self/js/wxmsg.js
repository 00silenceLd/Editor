$(function () {
  var gr=GR();
  if(gr.id!=undefined && gr.id!=''){
    $.ajax({
      type: "GET",
      url:DEFAULT_JOBURL+"htWeiXinService/getPushMsgByPushId?pushId="+gr.id,
      success: function(re){
        if(re.status=='200'){
          var html='';
          var mc=JSON.parse(re.msg.content);
          var dtime = frmDateTime(re.msg.addTime);
          $('.wxmsg-top h2').html(re.msg.title);
          switch (gr.flag){
            case '1':
              html=`<dl>
                     <dt>`+mc.data2+`</dt>
                     <dd>教师姓名：<span>`+mc.data3+`</span></dd>
                     <dd>手机号码：<span>`+mc.data4+`</span></dd>
                     <dd>辅导科目：<span>`+mc.data5+`</span></dd>
                     <dd>安排日期：<span>`+dtime+`</span></dd>                     
                   </dl>`;
            /*学校通知
              {data2}
              教师姓名：{data3}
              手机号码：{data4}
              辅导科目：{data5}
              安排日期：{data6}
            {data8}*/
              break;
            case '2':
              html=`<dl>
                     <dt>`+mc.data2+`</dt>
                     <dd>请假人：<span>`+mc.data3+`</span></dd>
                     <dd>请假时间：<span>`+mc.data4+`</span></dd>
                     <dd>请假事由：<span>`+mc.data5+mc.data6+`</span></dd>
                   </dl>`;
              /*<!--
                  请假通知
                  <dl>
                    <dt>由于天气忽冷忽热不幸感冒，需要请假两天休息，望老师批准！你的学生张三</dt>
                    <dd>请假人：张三</dd>
                    <dd>请假时间：2018年10月30日下午</dd>
                    <dd>请假事由：病假</dd>
                  </dl>
                  {data2}
                  请假人：{data3}
                  请假时间：{data4}
                  请假事由：{data5}
                  {data6}-->*/
              break;
            case '3':
              html=`<dl>
                     <dt>`+mc.data2+`</dt>
                     <dd>时间：<span>`+mc.data3+`</span></dd>
                     <dd>科目：<span>`+mc.data4+`</span></dd>
                     <dd>作业简介：<span>`+mc.data5+`</span></dd>
                     <dd>作业详情：<span>`+mc.data6+mc.data7+`</span></dd>                     
                   </dl>`;
              /*
              作业提醒
              <dl>
                <dt>请同学们完成今天布置的作业！</dt>
                <dd>时间：2018-08-30</dd>
                <dd>科目：数学第三章三角函数</dd>
                <dd>作业简介：预习第三章第4小节、课后习题</dd>
                <dd>作业详情：病假</dd>
              </dl>
              {data2}
              时间：{data3}
              科目：{data4}
              作业简介：{data5}
              作业详情：{data6}
              {data7}
              */
              break;
            case 4:
              break;
            case 5:
              break;
          }

          $('.wxmsg-content').html(html);
        }else{
          $('.wxmsg-content').html('没有相关信息');
        }
      }
    });
  }
})
