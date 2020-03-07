
/**
 * 显示登录页
 * @returns
 */
function changeLoginStyle(){
	$("#Log").css("display" , "block");
	$("#Reg").css("display" , "none");
}

/**
 * 显示注册页
 * @returns
 */
function changeRegisterStyle(){
	$("#Log").css("display" , "none");
	$("#Reg").css("display" , "block");
}


/**
 * 登陆按钮点击响应事件
 * @returns
 */
function loginClick(){
	var loginInfo = {
			"username" : $('#login_username').val(),
			"pass" : $('#login_password').val()
	};
	$.ajax({
		type : "POST",
		url : "/CloudStorage/login/login.xiong",
		contentType : "application/json ; charset=utf-8",
		data : JSON.stringify(loginInfo),
		dataType : "json",
		success : function(message){
			if(message.result === true){
				//登陆成功,进行跳转
				window.location.href="member.jsp";
			}else{
				alert(message.content)
			}
		},
		error : function(message){
			alert(message + "false");
		}
	})
}

/**
 * 注册点击事件
 * @returns
 */
function registerClick(){
	var userinfo = {
			"username" : $('#register_username').val(),
			"pass" : $('#register_password').val(),
			"birthday" : $('#register_birth_day').val(),
			"sex" : $('#register_sex').val(),
			"contactWay": $('#contact_way').val(),
			"signature" : $('#register_personalized_signature').val()
	};
	$.ajax({
		type : "POST",
		url : "/CloudStorage/login/register.xiong",
		contentType : "application/json ; charset=utf-8",
		data : JSON.stringify(userinfo),
		dataType : "json",
		success : function(message){
//			if(message.result == true){
				//注册成功并刷新页面
				alert(message.content);
				window.location.href = "Login.jsp";
//			}else{
//				//注册失败,对用户进行提示
//				alert(message.content);
//			}
		},
		error : function(message){
			
		}
	});
}

/**
 * 修改标记的内容
 * @returns
 */
function changeVale(hidden_value){
	alert(flag.value);
	var flag = document.getElementById("flag");
	flag.value = hidden_value;
	alert(flag.value);
	
}
