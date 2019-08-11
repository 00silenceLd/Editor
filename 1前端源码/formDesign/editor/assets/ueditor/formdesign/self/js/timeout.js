var timerVal = document.getElementById( 'timer' ).getAttribute( 'data-id' );

var maxtime = timerVal * 600; //一个小时，按秒计算，自己调整!
function CountDown() {
    if ( maxtime >= 0 ) {
        minutes = Math.floor( maxtime / 60 );
        seconds = Math.floor( maxtime % 60 );
        msg = "距离结束还有" + minutes + "分" + seconds + "秒";
        document.all[ "timer" ].innerHTML = msg;
        if ( maxtime == 5 * 60 ) alert( "还剩5分钟" );
        --maxtime;
    } else {
        clearInterval( timer );
        alert( "时间到，结束!" );
    }
}
document.getElementById("startTimer").onclick=function(){
   timer = setInterval( "CountDown()", 1000 );
}

