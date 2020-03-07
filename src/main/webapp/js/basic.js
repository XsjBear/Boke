function out(){
	$.post("userInfo/exit", null, function(data) {
		data = parseInt($.trim(data));
		if (data > 0) {
			setTimeout(function() {
				location.href='login.html';
			},500);
		}
	}, "json");
}

$(function(){
	$.post("userInfo/check",null,function(data){
		console.info(data);
		var str = "";
		str += ' <li><a href="index.html">首页</a></li>';
		str += ' <li><a href="time.html">我的博客</a></li>';
		str += '<li><a href="list.html">我的关注</a></li>';
		str += '<li><a href="share.html">我的收藏</a></li>';
		str += '<li><a href="infopic.jsp">写博客</a></li>';
		str += '<li><a href="about.jsp">关于我</a></li>';
		if(data.userid){
			str += '<li><a href="#">欢迎您：&nbsp;['+ data.username +']</a></li><li><a href="#" onclick="out()">退出</a></li>';
		}else{
			str += '<li><a href="login.html">登录or注册</a></li>';
		}
		
		$("#starlist").append($(str));
	
		
	},"json");
	
	
})