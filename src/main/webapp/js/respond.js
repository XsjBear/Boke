$(function() {

	var bokeid = location.search.slice(1);
	bokeid = (bokeid.substring(bokeid.indexOf("=") + 1, bokeid.length));

	$.post("discussion/all", {bokeid : bokeid}, function(data) {
		var content = '';
	
		for ( var key in data) {
			console.log(key);
			console.log(data[key]);
			content += '<table class="responed">' + '<tr class="tr'+ data[key][0].respondid +'"  onclick="addNewLine(' + bokeid + ','+ data[key][0].respondid +',' + data[key][0].respondid +',\'' + data[key][0].respondman +'\')" class="talk">' + '	<td>'
					+ data[key][0].respondman + '评论了：</td>' + '	<td>'
					+ data[key][0].respondcontent + '</td>' + '</tr>';
			for (var i = 1; i < data[key].length; i++) {
				var respond = data[key][i];
				content += '<tr class="tr'+ respond.respondid +'"  onclick="addNewLine(' + bokeid + ','+ data[key][0].respondid + ',' + respond.respondid +',\'' + respond.respondman +'\')" class="talk">' + '	<td></td>' + '	<td>'
						+ respond.respondman + '回复了' + respond.respondedman
						+ '：</td>' + '	<td>' + respond.respondcontent + '</td>'
						+ '</tr>';
			}
			content += '<tr></tr></table>';
		}
		$(".comment-list").html(content);
	}, "json");

	$(".pinglun").on("click", function() {
		var conetnt = "";
		var respondedman = $(".bokeAuthor").val();
		var type = "evaluation";
		var content = $(".mytextarea").val();
		$.post("discussion/add", {bokeid : bokeid ,respondedman : respondedman ,  type:type , content:content}, function(data) {
			if(data == 1){
				//插入成功
				$.post("discussion/all", {bokeid : bokeid}, function(data) {
					var content = '';
					for ( var key in data) {
						console.log(key);
						console.log(data[key]);
						content += '<table class="responed">' + '<tr class="tr'+ data[key][0].respondid +'"  onclick="addNewLine(' + bokeid + ','+ data[key][0].respondid +',' + data[key][0].respondid +',\'' + data[key][0].respondman +'\')" class="talk">' + '	<td>'
								+ data[key][0].respondman + '评论了：</td>' + '	<td>'
								+ data[key][0].respondcontent + '</td>' + '</tr>';
						for (var i = 1; i < data[key].length; i++) {
							var respond = data[key][i];
							content += '<tr class="tr'+ respond.respondid +'"  onclick="addNewLine(' + bokeid + ','+ data[key][0].respondid + ',' + respond.respondid +',\'' + respond.respondman +'\')" class="talk">' + '	<td></td>' + '	<td>'
									+ respond.respondman + '回复了' + respond.respondedman
									+ '：</td>' + '	<td>' + respond.respondcontent + '</td>'
									+ '</tr>';
						}
						content += '<tr></tr></table>';
					}
					$(".comment-list").html(content);
				}, "json");
			}else{
				alert("评论失败!!!");
			}
		},"json")
	});

	readshow(bokeid);
	flush(bokeid);
})


function addNewLine(bokeid ,whichbelong , aboutid , respondedman) {
	$(".responed tbody .tr" + aboutid + "").after("<tr class='temp'><td></td><td><textarea cols='50' rows='1' placeholder='来说几句吧......' class='respondtextarea' id='respondcontent'></textarea><div class='btn btn-info pull-right respondContents' style='margin-right: 550px;' id='respondComment'>回复</div></td><tr/>");
	$(".respondContents").on("click",function(){
		var content = $(".respondtextarea").val();
		var type = "respond";
		$.post("discussion/add",{bokeid : bokeid ,respondedman : respondedman ,  type:type , content:content , aboutid:aboutid , whichbelong:whichbelong}, function(data) {
			if(data == 1){
				//插入成功
				$.post("discussion/all", {bokeid : bokeid}, function(data) {
					var content = '';
					for ( var key in data) {
						console.log(key);
						console.log(data[key]);
						content += '<table class="responed">' + '<tr class="tr'+ data[key][0].respondid +'"  onclick="addNewLine(' + bokeid + ','+ data[key][0].respondid +',' + data[key][0].respondid +',\'' + data[key][0].respondman +'\')" class="talk">' + '	<td>'
								+ data[key][0].respondman + '评论了：</td>' + '	<td>'
								+ data[key][0].respondcontent + '</td>' + '</tr>';
						for (var i = 1; i < data[key].length; i++) {
							var respond = data[key][i];
							content += '<tr class="tr'+ respond.respondid +'"  onclick="addNewLine(' + bokeid + ','+ data[key][0].respondid + ',' + respond.respondid +',\'' + respond.respondman +'\')" class="talk">' + '	<td></td>' + '	<td>'
									+ respond.respondman + '回复了' + respond.respondedman
									+ '：</td>' + '	<td>' + respond.respondcontent + '</td>'
									+ '</tr>';
						}
						content += '<tr></tr></table>';
					}
					$(".comment-list").html(content);
				}, "json");
			}else{
				alert("回复失败!!!");
			}
		},"json")
		/*$(".responed tbody .tr" + aboutid + " .temp").remove();*/
	})
}

function readshow(bokeid) {
	$.post("boke/addread", {
		bokeid : bokeid
	}, function(data) {
		data = parseInt($.trim(data));

	}, "json");
}

function lastpage(bokeid) {
	bokeid = parseInt(bokeid) - 1;
	// flush(bokeid);
	location.href = "details.html?id=" + bokeid;
}

function nextpage(bokeid) {
	bokeid = parseInt(bokeid) + 1;
	// flush(bokeid);
	location.href = "details.html?id=" + bokeid;
}

function flush(bokeid) {
	$.post("boke/finds",{bokeid : bokeid},function(data) {
						console.log(data);
						var str = '';
						str += '<h3 class="news_title">'
								+ data.title
								+ '</h3><input type="hidden" class="bokeAuthor" value="'+ data.username +'" /><div class="bloginfo"><ul><li class="author">作者：<a href="/"> '
								+ data.username
								+ '</a></li><li class="lmname">博客类型:<a href="/">'
								+ data.typename + '</a></li>';
						str += '<li class="timer">时间：'
								+ data.editordate
								+ '</li><li class="view" onchick="readshow()">'
								+ data.readnum
								+ '人已阅读</li></ul></div><div class="tags"><a href="/" target="_blank">'
								+ data.label + '</a> </div>';
						str += '<div class="news_con">' + data.content
								+ '&nbsp; </div>';
						/*
						 * str += '<div class="nextinfo"><p>上一篇：<a
						 * href="javascript:void(0)"
						 * onclick="lastpage('+data.bokeid+')">'+data.title+'</a></p>';
						 * str += '<p>下一篇：<a href="javascript:void(0)"
						 * onclick="nextpage('+data.bokeid+')">'+data.title+'</a></p></div><div
						 * class="news_pl">&nbsp<a href="time.html">返回列表</a>';
						 */
						str += '<div class="news_pl">&nbsp<a href="time.html">返回列表</a>';
						str += '<h2>文章评论量：'
								+ data.evaluate
								+ '</h2><div class="gbko" display:none   style="width:500px ; height: 100px ; border-bottom-width: 2px,sloid,blue;>刘磊<h4><a>文章评论</a></h4> </div></div>';
						str += '';
						$("#newsview").html("").append($(str));
						// console.info(str + "@");
					}, "json");
}