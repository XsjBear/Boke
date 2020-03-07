<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人博客网站</title>
<meta name="keywords" content="个人博客,杨青个人博客,个人博客模板,杨青" />
<meta name="description" content="杨青个人博客，是一个站在web前端设计之路的女程序员个人网站，提供个人博客模板免费资源下载的个人原创网站。" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" href="css/main.css">
<script type="text/javascript" src="js/allInfo.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="js/showpic.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
<script type="text/javascript" src="js/comm.js"></script>
<script type="text/javascript" src="js/basic.js"></script>

<script src="js/piccontent.min.js" type="text/javascript"></script>
<script type="text/javascript">
var tno;
$(function(){
	$.getJSON("type/findAll", null, function(data){
		var str = "";
		$.each(data, function(index, item) {
			str += "<option value='" + item.type + "'>" + item.typename+ "</option>";
		});
		
		$("#typeinfo").append($(str));
	});
	
	tno=$("#my_id").val();
	
});
</script>
</head>
<body>
<header>
  <div class="profile">
    <div class="avatar fl"><img src="images/avatar.jpg"></div>
    <div class="guanzhu fl">
      <ul>
        <li><img src="images/nianling.png"><span> 
          <script language="javascript">
 function   ages(str)   
  {   
        var   r   =   str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
        if(r==null)return   false;     
        var   d=   new   Date(r[1],   r[3]-1,   r[4]);     
        if   (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4])   
        {   
              var   Y   =   new   Date().getFullYear();   
              return("年龄   "+   (Y-r[1])   +"   周岁");   
        }   
        return("日期格式错误！");   
  }   
  document.write(ages("2015-03-09"));   
  
</script></span></li>
        <li><img src="images/weizhi.png"><span>中国·北京</span></li>
        <li><img src="images/qq.png"><span>QQ：476847113</span></li>
        <li><img src="images/weixin.png"><span><img src="images/wxewm.png"></span></li>
      </ul>
    </div>
    <div class="username">Baby的小家</div>
  </div>
  <nav>
    <ul id="starlist">
    </ul>
  </nav>
</header>
<article>
	<div class="box_center">
				<form action="" class="jqtransform" id="addGoodsForm">
					<table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="td_right">博客类型：</td>
							<td>
								<select class="select" name="type" id="typeinfo">
									
								</select>
							</td>
							
							<td class="td_right">作者：</td>
							<td>
								 <input readonly type="text" id="userid" name="userid" value="${loginUser.username}"  class="input-text lh30" size="20">
								 <input type="hidden" id="my_id" value="${loginUser.userid}">
							</td>
						
							
						</tr>
						<tr>
							<td class="td_right">原创：</td>
							<td>
								<select id="original">
									<option value="" selected>是</option>
									<option value="">否</option>
								</select>
							</td>
							
							<td class="td_right">标签：</td>
							<td>
								<input type="text" id="label" name="label" class="input-text lh30" size="40" placeholder="标签"/>
							</td>
						</tr>
						<tr>
							
							<td class="td_right">博客插图图片：</td>
							<td>
								<input type="file" id="pics" name="pic" class="input-text lh30" size="40" multiple="multiple" onchange="setImagePreviews(this,'showPics')">
							</td>
							<td class="td_right">日期：</td>
							<td>
								<input type="date" id="editordate" name="editordate" class="input-text lh30" size="40"  placeholder="编辑日期"/>
							</td>
							
						</tr>
						
						
						<tr>
							<td>&nbsp;</td>
							<td colspan="5" align="center">
								<div id="showPics">
								</div>
							</td>
						</tr>
						<tr>
							<td class="td_right">博客标题：</td>
							<td colspan="5">
								 <textarea name="title" id="title" rows="3" cols="100"></textarea>
							</td>
						</tr>
						<tr>
							<td class="td_right">博客内容：</td>
							<td colspan="5">
								 <textarea name="editor1" id="editor1" rows="10" cols="80"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<input type="button" name="button" class="btn btn82 btn_save2" onclick="addBokeInfo()" value="发表">
								<input type="reset" name="button" class="btn btn82 btn_res" value="保存">
							</td>
						</tr>
					</table>
				</form>
			</div>
  
  <div class="blank"></div>
</article>
<script type="text/javascript">
CKEDITOR.replace( 'editor1' );
function addBokeInfo() {
	var type = $.trim($("#typeinfo").val());
	var title = $.trim($("#title").val());
	var original = $.trim($("#original option:selected").text());
	var label = $.trim($("#label").val());
	var editordate = $.trim($("#editordate").val());
	var userid = $.trim($("#my_id").val());
	var content = $.trim(CKEDITOR.instances.editor1.getData());
	$.ajaxFileUpload({
		url:'boke/addboke',
		secureuri: false,
		fileElementId:"pics",
		dataType:"json",
		data:{userid:userid,editordate:editordate,title:title,label:label,content:content,original:original,type:type},
		success:function(data, status) {
			data = parseInt($.trim(data));
			if (data == 1) {
				$("#addGoodsForm")[0].reset();
				$("#showPics").html("");
				CKEDITOR.instances.editor1.setData("");
				alert("博客发表成功...");
			} else {
				alert("博客发表失败...");
			}
		},
		error:function(data, status, e) {
			alert("博客发表失败，请稍后重试...\n" + e);
		}
	});
	
}
</script>
<a href="#" class="cd-top">Top</a>
</body>
</html>
