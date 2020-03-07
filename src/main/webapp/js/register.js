/*//获取元素
var  $username = $("#username");
//输出到控制台
console.log($username);

//用户名验证
//失去焦点事件
$("#username").blur (function(){
	//获取用户输入的用户名
	var username = $("#username").val();
	console.log(username);
	//判断用户名的格式
	if(username == '' ){
		console.log("用户不能为空");
		//给当前对象的下一个标签设值
		$(this).next().html("用户不能为空");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
	//正则表达式
	//创建一个规则
	var reg = /^\w{6,15}$/;
	//判断
	
	var flag = reg.test(nickname);
	console.log(flag);
	
	if( !reg.test(nickname)){
		//给当前对象的下一个标签设值
		$(this).next().html("用户名必须是6-15位的英文或数字");
		//未设值前该标签是隐藏的  此时就必须显示来
		$(this).next().show();
	}
});

//聚焦事件
$("#nickname").focus(function(){
	//隐藏
	$(this).next().hide();
})


//密码验证	
//失焦事件
$("#pwd").blur(function(){
	check_pwd();	
});

//聚焦事件
$("#pwd").focus(function(){
	$(this).next().hide();
});
	
function check_pwd(){
	//获取密码
	var pwd = $("#pwd").val();
	//规则
	var reg = /^[\w@!#$%^&*~]{6,15}$/;
	//判断
	if(!reg.test(pwd)){
		$("#pwd").next().html("密码不符合规范");
		$("#pwd").next().show();
	}
}

//确认密码验证
//失焦事件
$("#cpwd").blur(function(){
	check_cpwd();	
});

//聚焦事件
$("#cpwd").focus(function(){
	$(this).next().hide();
});
	
function check_cpwd(){
	//获取原密码
	var pwd = $("#pwd").val();
	//获取再次输入的密码
	var cpwd = $("#cpwd").val();
	
	//判断
	if(cpwd == ''){
		$("#cpwd").next().html("确认密码不能为空");
		$("#cpwd").next().show();
	}
	if(cpwd != pwd){
		$("#cpwd").next().html("两次输入的密码不一致");
		$("#cpwd").next().show();
	}
}

//手机号码验证
//失焦事件
$("#tel").blur(function(){
	check_tel();	
});

//聚焦事件
$("#tel").focus(function(){
	$("#tel").next().next().hide();
});
	
function check_tel(){
	//获取电话号码
	var tel = $("#tel").val();
	//规则
	var reg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
	
	if( !reg.test(tel)){
		$("#tel").next().next().html("手机号码格式错误");
		$("#tel").next().next().show();
	}
}

$("#email").blur(function(){
	if($.trim($(this).val())==""){
		$("#email").next().text("邮箱不能为空").show();
	}
});

//聚焦事件
$("#email").focus(function(){
	$("#email").next().hide();
});*/

//获取验证码
$("#getCode").click(function(){
	var email = $("#email").val();
	var username = $("#username").val();
	if(email == ""){
		$("#email").blur();
		return;
	}
	if(username == ""){
		$("#username").blur();
		return;
	}
	
	$.post("userInfo/code",{email:email,name:username},function(data){
		console.info(data);
		data = parseInt($.trim(data));
		if(data > 0){
			$("#getCode").attr("disabled","true");
			//倒计时
			var time  = 180;
			var timeTask = setInterval(function(){
				if(time >0 ){
					time --;
					$("#getCode").val( time + "S");
				}else{
					$("#getCode").removeAttr("disabled").val("重新发送");
					clearInterval(timeTask);
				}
			},1000);
		}else{
			$("#getCode").removeAttr("disabled").val("重新获取");
			$("#getCode").next().next().html("验证码发送失败");
		}
	},"text");              
})



/*$("#code").blur(function(){
	var code = $.trim($("#code").val());
	if(code.length != 6){
		$(this).next().next().text("请输入6位的验证码").show();
	}else{
		$(this).next().next().hide();
	}
});
$("#code").focus(function(){
	$("#code").next().next().hide();
})*/

//注册
function reg(){
	var username =$.trim($("#username").val());
	var userpass =$.trim($("#pwd").val());
	var realName =$.trim($("#realName").val());
	var birthday =$.trim($("#birthday").val());
	var sex =$.trim($("#sex").val());
	var contackway =$.trim($("#contackway").val());
	var address =$.trim($("#address").val());
	var work =$.trim($("#work").val());
	var code =$.trim($("#code").val());
	var email =$.trim($("#email").val());
	$.post("userInfo/add",$("#myform").serialize(),function(data){
		console.info(data);
		data = parseInt($.trim(data));
		if(data == -2){
			//$("#yzm").next().next().text("验证码错误").show();
		}else if(data > 0){
			$("#myform")[0].reset();
			alert("注册成功,请登录...");
			location.href='login.html';
		}else{
			alert("注册失败,请稍后重试...");
		}
	},"text");
}

	
	
	