$(function() {
	// 类别加载请求
	$.post("homePage/getAllType", null, function(data) {
		var type = "";
		for (var i = 0; i < data.length; i++) {
			type += '<li><a href="javascript:void(0)" onclick="gettypeid('
					+ data[i].type + ')" class="typeInfo">' + data[i].typename
					+ '</a></li>';
		}
		$(".type").html(type);
	}, "json")
	

	// 首页加载请求
	$.post("homePage/loading", null, function(data) {
		setContent(data);
	}, "json")
	
})

// 点击按照类别查询
function gettypeid(type) {
	$.post("homePage/loading", {
		type : type
	}, function(data) {
		setContent(data);
	}, "json")
}

// 设置推荐博客内容
function setContent(data) {
	console.log(data);
	var content = "";
	var bokelist = data["bokeList"];
	var attention = data["attention"];
	var collect = data["collect"];
	var collectlist = data["collectList"];
	for (var i = 0; i < bokelist.length; i++) {
		content += '<li><i><a href="details.html?bokeid=' + bokelist[i].bokeid
				+ '"' + 'title="' + bokelist[i].title + '"><img' + '	src="../'
				+ bokelist[i].pics + '"' + '	alt="' + bokelist[i].title
				+ '"></a></i>' + '<h3>' + '	<a href="details.html?bokeid='
				+ bokelist[i].bokeid + '" target="_blank">' + bokelist[i].title
				+ '</a></h3>'
				+ '<p class="feed-date">' + '	<span class="fd01">['
				+ bokelist[i].label + ']</span><span class="fd01"><a'
				+ '		href="javascript:void(0)">' + bokelist[i].editordate
				+ '</a></span><span class="fd01">阅读（' + bokelist[i].readnum
				+ '）</span><span' + '		class="fd01">评论（' + bokelist[i].evaluate
				+ '）</span>';
		
		if (attention.length == 0) {
			content += '<span class="fd01 attention'+ bokelist[i].userid +' focues' + bokelist[i].userid
					+ '" onclick="getUserid(' + bokelist[i].userid
					+ ')">【关注作者】</span>';
		} else {
			for (var j = 0; j < attention.length; j++) {
				if (bokelist[i].userid != attention[j].focususerid) {
					// 表示已经对该作者进行了关注
					content += '<span class="fd01 attention'+ bokelist[i].userid +' focues'
							+ bokelist[i].userid + '" onclick="getUserid('
							+ bokelist[i].userid + ')">【关注作者】</span>';
				} else {
					// 表示未对该作者进行关注
					content += '<span class="fd01 attention'+ bokelist[i].userid +' delfocus'
							+ bokelist[i].userid + '" onclick="getUserid('
							+ bokelist[i].userid + ')">【已关注】</span>';
				}
			}
		}
		//content += '</p></li>';
		var flag = false;
		if (collect.length == 0) {
			
			content += '<span class="fd01 collect focus" onclick="getBokeid(this, '+bokelist[i].bokeid+')">【点击收藏】</span>';
		} else {
			for (var a = 0;  a < collect.length; a++){
				if (bokelist[i].bokeid == collect[a].bokeid) {
					flag = true;
				}
			}
			
			
			if (flag) {
				// 表示已经对该作者进行了收藏
				content += '<span class="fd01 collect delfocus" onclick="getBokeid(this, '+ bokelist[i].bokeid + ')">【取消收藏】</span>';
			} else {
				content += '<span class="fd01 collect focus" onclick="getBokeid(this, '+ bokelist[i].bokeid + ')">【点击收藏】</span>';
				// 表示未对该作者进行收藏
			}
			
		}
	}
	$(".bloglist").html(content);
}

// 关注||取消关注绑定的点击事件
function getUserid(userid) {
	if ($(".attention" + userid).hasClass("focues" + userid) == true) {
		addAttention(userid);
	}
	if ($(".attention" + userid).hasClass("delfocus" + userid) == true) {
		removeSAttention(userid);
	}
}



// 添加关注
function addAttention(userid) {
	$.post("homePage/addAttention", {
		userid : userid
	}, function(data) {
		if (data == 1) {
			// 表示关注成功
			$(".focues" + userid).text("【取消关注】");
			// 移除关注相关类名并添加取消关注相关类名
			$(".attention" + userid).removeClass("focues" + userid);
			$(".attention" + userid).addClass("delfocus" + userid);
		} else {
			// 表示关注失败
			alert("关注失败")
		}
	}, "json")
}

// 移除关注
function removeSAttention(userid) {
	$.post("homePage/delAttention", {
		userid : userid
	}, function(data) {
		if (data == 1) {
			// 表示取消关注成功
			$(".delfocus" + userid).text("【关注作者】");
			// 移除取消关注相关类名并添加关注相关类名
			$(".attention" + userid).removeClass("delfocus" + userid);
			$(".attention" + userid).addClass("focues" + userid);
		} else {
			//表示关注失败
			alert("关注失败")
		}

	}, "json")
}

//点击收藏
function addCollect(bokeid) {
	$.post("homePage/addCollect",{bokeid : bokeid}, function(data){
		if (data == 1){
			//表示收藏成功
			$(".focus1 + bokeid").text("【取消收藏】");
			//移除收藏相关类名并添加取消收藏相关类名
			$(".collect").removeClass("focus1" + bokeid);
			$(".collect").addClass("delfocus1" + bokeid);
		}else {
			//表示收藏失败
			alert("收藏失败")
		}
	},"json")
}

//移除收藏
function removeCollect(bokeid){
	$.post("homePage/removeCollect",{bokeid : bokeid}, function(data){
		if (data == 1){
			//表示取消收藏成功
			$(".delfocus1" + bokeid).text("【点击收藏】");
			//移除取消收藏相关类名并添加关注相关类名
			$(".collect").removeClass("delfocus1" + bokeid);
			$(".collect").addClass("focus1" + bokeid);
		}else {
			//表示失败
			alert("收藏失败")
		}
	},"json")
}

//收藏 ||取消收藏的点击事件
function getBokeid(obj, bokeid){
	if ($(obj).hasClass("focus")) {
		$.post("homePage/addCollect",{bokeid : bokeid}, function(data){
			data = parseInt($.trim(data));
			if (data == 1){
				//表示收藏成功
				$(obj).removeClass("focus");
				$(obj).text("【取消收藏】");
				//移除收藏相关类名并添加取消收藏相关类名
				$(obj).addClass("delfocus");
			}else if(data == -1) {
				//表示失败
				alert("收藏失败")
			}else if(data == -2){
				alert("登录失败，请先登录");
				setTimeout(function(){ 
					location.href = "login.html";
				}, 1000);
			}
		},"json")
	} else if ($(obj).hasClass("delfocus")) {
		$.post("homePage/delCollect",{bokeid : bokeid}, function(data){
			data = parseInt($.trim(data));
			if (data == 1){
				//表示取消收藏成功
				$(obj).removeClass("delfocus");
				$(obj).text("【点击收藏】");
				//移除取消收藏相关类名并添加关注相关类名
				$(obj).addClass("focus");
			}else if(data == -1) {
				
				//表示失败
				alert("取消收藏失败")
			}else if(data == -2){
				alert("登录失败，请先登录");
				setTimeout(function(){ 
					location.href = "login.html";
				}, 1000);
			}
		},"json")
	}
}