<%--
  Created by IntelliJ IDEA.
  User: I076453
  Date: 9/11/2017
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>短信验证登录</title>
    <script src="${ctx}/js/jquery-3.2.1.min.js"></script>
    <script>
        var wait = 10;
        function countSecond() {
            wait--;
            $("#getSmsCodeBtn")[0].innerText = "(" + wait + ")秒后重新发送";
            if(wait === 0){
                $("#getSmsCodeBtn")[0].innerText = "点击发送验证码";
                wait = 10;
                $("#getSmsCodeBtn")[0].disabled = false;
                return;
            }
            setTimeout("countSecond()", 1000);
        }

        $(document).ready(function () {
            $("#loginbtn").click(function () {
                var phone = $("#phone").val();
                var smscode = $("#smscode").val();
                if(!phone || phone === ''){
                    alert("请输入手机号码！")
                }
                if(!smscode || smscode === ''){
                    alert("验证码必输！")
                }

                // ajax
                $.post("/account/smslogin", {phone: phone, smscode: smscode}, function (result, textStatus) {
                    if(textStatus === 'success'){
                        window.location.href = "/main";
                    }else{
                        console.log(result);
                    }
                });

            });

            $("#getSmsCodeBtn").click(function () {
                var phone = $("#phone").val();
                var that = this;

                if(!phone || phone === ''){
                    alert("请输入手机号码！");
                    return;
                }
                this.innerText = "(" + wait + ")秒后重新发送";
                this.disabled = true;

                $.post("/account/sendSMS", {phone: phone}, function (result) {
                    if(result && result.err){
                        that.innerText = "点击发送验证码";
                        that.disabled = false;
                        alert(result.err);
                    }else{
                        countSecond();
                        console.log(result);
                    }
                });


            });
        });

    </script>
</head>
<body>

<form action="smslogin" method="post" onsubmit="return false;">

    手机：<input id="phone" name="phone">
    <br>
    验证：<input id="smscode" name="smscode">&nbsp;&nbsp;<button id="getSmsCodeBtn">点击发送验证码</button>
    <br>
    <input id="loginbtn" type="submit" value="登录">

</form>

</body>
</html>
