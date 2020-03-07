<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>小皮熊</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/base.css" rel="stylesheet">
<script src="js/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="js/comm.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
<script type="text/javascript" src="js/allInfo.js"></script>
<script type="text/javascript">
$(function() {
	$.post("userInfo/findAll", null, function(data) {
		console.log(data);
		if(data != null){
			$("#username").val(data.username);
			$("#realname").val(data.realname);
			$("#birthday").val(data.birthday);
			$("#sex").val(data.sex);
			$("#contackway").val(data.contackway);
			$("#address").val(data.address);
			$("#work").val(data.work);
			$("#email").val(data.email);
		}else{
			alert("您尚未登陆，请先登录!!!!");
			location.herf='login.html';
		}
	}, "json");
})
function update(){
    var username =$.trim($("#username").val());
	var realName =$.trim($("#realname").val());
	var birthday =$.trim($("#birthday").val());
	var sex =$.trim($("#sex").val());
	var contackway =$.trim($("#contackway").val());
	var address =$.trim($("#address").val());
	var work =$.trim($("#work").val());
	var email =$.trim($("#email").val());
	$.post("userInfo/update",{username:username,userpass:userpass,realname:realName,birthday:birthday,sex:sex,contackway:contackway,address:address,work:work,email:email},function(data){
		console.info(data);
		if(data > 0){
			alert("修改成功，请重新登录...");
			location.href = 'login.html';
		}else{
			alert("修改失败...");
		}
	},"json");
}
</script>
<style type="text/css">
.form-group input{
      width: 100%;
      height: 30px;
}
.form-group{
      margin-top: 10px;
}
.newsview button{
      height: 30px;
      margin-top: 10px;
      margin-left: 275px;
}
</style>
</head>
<body>
	<header>
		<div class="profile">
			<div class="avatar fl">
				<img src="images/avatar.jpg">
			</div>
			<div class="guanzhu fl">
				<ul>
					<li><img src="images/nianling.png"><span> <script
								language="javascript">
						function ages(str) {
							var r = str
									.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
							if (r == null)
								return false;
							var d = new Date(r[1], r[3] - 1, r[4]);
							if (d.getFullYear() == r[1]
									&& (d.getMonth() + 1) == r[3]
									&& d.getDate() == r[4]) {
								var Y = new Date().getFullYear();
								return ("年龄   " + (Y - r[1]) + "   周岁");
							}
							return ("日期格式错误！");
						}
						document.write(ages("2015-03-09"));
					</script></span></li>
					<li><img src="images/weizhi.png"><span>中国·北京</span></li>
					<li><img src="images/qq.png"><span>QQ：476847113</span></li>
					<li><img src="images/weixin.png"><span><img
							src="images/wxewm.png"></span></li>
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
		<main class="r_box">
		<div class="newsview">
				<div class="form-group">
				    <label for="exampleInputusername" >用户名:</label>
					<input type="text" class="form-control" name="username"  id="username"  placeholder="用户名" >
				</div>
				<div class="form-group">
				    <label for="exampleInputrealname">真实姓名:</label>
					<input type="text" class="form-control realname" name="realname" id="realname" placeholder="真实姓名">
			    </div>
				<div class="form-group">
				    <label for="exampleInputbirthday">出生日期:</label>
					<input type="text" class="form-control birthday"  name="birthday"  id="birthday" placeholder="出生日期">
				</div>

				<div class="form-group">
				    <label for="exampleInputsex">性别:</label>
					<input type="text" class="form-control sex"  name="sex"  id="sex" placeholder="性别">
				</div>


				<div class="form-group">
				    <label for="exampleInputcontackway">联系方式:</label>
					<input type="text" class="form-control contackway" name="contackway"  id="contackway" placeholder="联系方式">
				</div>

				<div class="form-group">
				    <label for="exampleInputaddress">家庭住址:</label>
					<input type="text" name="address"  id="address" class="address form-control" placeholder="家庭住址">
				</div>
				<div class="form-group">
				    <label for="exampleInputwork">行业:</label>
					<input type="text" class="work form-control"  name="work"  id="work" placeholder="行业">
				</div>
				<div class="form-group">
				    <label for="exampleInputemail">邮箱:</label>
					<input type="text" class="email form-control" name="email"  id="email" placeholder="邮箱">
				</div>
				<button type="submit" class="btn btn-default" onclick="update()" >修改信息</button>
		</div>
		</main>
		<aside class="l_box">
			<div class="search">
				<form action="/e/search/index.php" method="post" name="searchform"
					id="searchform">
					<input name="keyboard" id="keyboard" class="input_text"
						value="请输入关键字词" style="color: rgb(153, 153, 153);"
						onfocus="if(value=='请输入关键字词'){this.style.color='#000';value=''}"
						onblur="if(value==''){this.style.color='#999';value='请输入关键字词'}"
						type="text"> <input name="show" value="title"
						type="hidden"> <input name="tempid" value="1"
						type="hidden"> <input name="tbname" value="news"
						type="hidden"> <input name="Submit" class="input_submit"
						value="搜索" type="submit">
				</form>
			</div>
			<div class="tuijian">
				<h2>最近更新</h2>
				<ul class="recentUpdata">
				</ul>
			</div>

			<div class="tuijian">
				<h2>点击排行</h2>
				<ul class="clickRank">
				</ul>
			</div>
		</aside>
	</article>
	<a href="#" class="cd-top">Top</a>
</body>
</html>
