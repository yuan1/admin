<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>登录</title>
    <!--公共页-->
    <#include "head/common.ftl">
    <link rel="stylesheet" href="static/css/login.css">
    <link rel="stylesheet" href="static/css/bootstrap-cerulean.min.css"/>
</head>
<body>
<div class="ch-container">
    <div class="row">
        <div class="row">
            <div class="col-md-12 center login-header">
                <h2>擎天柱后台管理系统</h2>
            </div>
            <!--/span-->
        </div>
        <!--/row-->

        <div class="row">
            <div class="well col-md-5 center login-box">
                <div class="alert alert-info">
                    请输入账号和密码登录
                </div>
                <form class="form-horizontal">
                    <fieldset>
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user red"></i></span>
                            <input type="text" class="form-control" placeholder="用户名">
                        </div>
                        <div class="clearfix"></div>
                        <br>

                        <div class="input-group input-group-lg">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock red"></i></span>
                            <input type="password" class="form-control" placeholder="密码">
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend">
                            <label class="remember" for="remember"><input type="checkbox" id="remember">记住我</label>
                        </div>
                        <div class="clearfix"></div>

                        <p class="center col-md-5">
                            <button type="submit" class="btn btn-primary"  onclick="severCheck();return false;">登录</button>
                        </p>
                    </fieldset>
                </form>
            </div>
            <!--/span-->
        </div>
        <!--/row-->
    </div>
    <!--/fluid-row-->
</div>
<!--/.fluid-container-->
<script>
    function severCheck(){
        $.ajax({
            type: "POST",
            url: '/login',
            dataType:'json',
            cache: false,
            success: function(data){
                if(data.returncode==0){
                    window.location.href="/index";
                }
            }
        });
    }
</script>
</body>
</html>
