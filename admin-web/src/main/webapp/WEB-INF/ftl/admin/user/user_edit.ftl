<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../../layout/common.ftl">
</head>
<body style="overflow: hidden">
<div class="row">
    <div class="col-md-12">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption">新增用户</div>
            </div>
            <div class="portlet-body form">
                <form class="form-horizontal" role="form" action="#">
                    <input type="hidden" id="id" name="id">

                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-3 control-label">用户名</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="fa fa-user"></i>
                                    </span>
                                    <input type="text" class="form-control input-inline input-medium" autocomplete="off"
                                           placeholder="用户名" name="userName" id="userName">
                                    <span class="help-inline">请输入用户名</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">手机号</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                <span class="input-group-addon">
                                        <i class="fa fa-mobile"></i>
                                </span>
                                    <input type="mobile" class="form-control input-inline input-medium"
                                           autocomplete="off"
                                           placeholder="手机号" name="mobile" id="mobile">
                                    <span class="help-inline">请输入手机号</span>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">Email Address</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                    <span class="input-group-addon">
                                        <i class="fa fa-envelope"></i>
                                    </span>
                                    <input type="email" class="form-control input-inline input-medium"
                                           autocomplete="off"
                                           placeholder="Email Address" name="email" id="email">
                                    <span class="help-inline">请输入Email</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">姓名</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                    <span class="input-group-addon">
												<i class="fa fa-user"></i>
                                    </span>
                                    <input type="text" class="form-control input-inline input-medium" autocomplete="off"
                                           placeholder="姓名" name="realName" id="realName">
                                    <span class="help-inline">请输入姓名</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-actions">
                        <div class="row">
                            <div class="col-md-offset-3 col-md-9">
                                <button type="button" class="btn default" onclick="window.history.go(-1);">取消</button>
                                <button type="submit" class="btn green" onclick="submit();">确定</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function submit() {
        var id = $("#id").val();
        var mobile = $("#mobile").val();
        var email = $("#email").val();
        var userName = $("#userName").val();
        var realName = $("#realName").val();
        $.ajax({
            type: "post",
            url: '/admin/user/save.do',
            data: {
                id: id,
                mobile: mobile,
                email: email,
                userName: userName,
                realName: realName
            },
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.returncode == 0) {
                    aler(data.message);
                    window.location.href = "/admin/user/list.do"
                }
            }
        });
    }


</script>

</body>
<#include "../../layout/bottom.ftl">
</html>