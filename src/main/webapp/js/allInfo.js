// 所有页面的最近更新，点击排行等模块
$(function(){
	
	// 最近更新博客请求
	$.post("homePage/recentUpdlata", null, function(data) {
		var content = ""
		for (var i = 0; i < data.length; i++) {
			content +='<li><a href="details.html?bokeid='+ data[i].bokeid +'" title="'+ data[i].title +'">'+ data[i].title +'</a></li>';
		}
		$(".recentUpdata").html(content);
	}, "json")
	
	
	//点击排行请求
	$.post("homePage/clicRankList", null, function(data) {
		var content = ""
			for (var i = 0; i < data.length; i++) {
				content +='<li><a href="details.html?bokeid='+ data[i].bokeid +'" title="'+ data[i].title +'">'+ data[i].title +'</a></li>';
			}
		$(".clickRank").html(content);
	}, "json")
	
	
})
