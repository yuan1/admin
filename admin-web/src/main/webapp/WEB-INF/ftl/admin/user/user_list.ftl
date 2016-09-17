<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../../layout/common.ftl">
</head>
<body style="overflow: hidden">
<!-- BEGIN CONTENT -->
<div class="page-content">
    <div class="row">
        <div class="col-md-12">
            <div class="portlet light">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-magnifier font-green"></i>
                        <span class="caption-subject font-green">查询条件</span>
                    </div>
                </div>
                <div class="portlet-body form">
                    <form class="form-horizontal" action="#" id="user-search-form">
                        <input type="hidden" id="js-bootpag-num" name="pageNo" value="1"/>

                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">用户名</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline" id="userName"
                                               name="userName" <#if condition.userName?exists> value="${condition.userName}" </#if> >
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">姓名</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline" id="realName"
                                               name="realName"<#if condition.realName?exists> value="${condition.realName}" </#if>>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">手机号</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline" id="mobile"
                                               name="mobile" <#if condition.mobile?exists> value="${condition.mobile}" </#if>>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">邮箱</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline" id="email"
                                               name="email" <#if condition.email?exists> value="${condition.mobile}" </#if>>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">状态</label>

                                    <div class="col-md-8">
                                        <select class="bs-select select2 form-control input-inline" name="userType"
                                                data-live-search="true">
                                            <option value="">全部</option>
                                            <#list statusList as status>
                                                <option value=">${status.value}">${status.desc}</option>
                                            </#list>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <a class="btn btn-sm btn-circle blue" id="searchBtn"><i class="fa fa-search"></i>查询</a>
                                <a class="btn btn-sm btn-circle grey-cascade" id="resetBtn"><i class="fa fa-times"></i>重置</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- BEGIN PAGE CONTENT-->
    <div class="row">
        <div class="col-md-12">
            <div class="portlet light">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-grid font-green"></i>
                        <span class="caption-subject font-green">用户列表</span>
                    </div>
                    <div class="actions">
                        <a class="btn btn-circle blue" data-toggle="modal" href="#add-modal">
                            <i class="fa fa-plus"></i>新增
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>id</th>
                            <th> 用户名</th>
                            <th> 姓名</th>
                            <th>手机号</th>
                            <th> 邮箱</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list userList as user>
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userName}</td>
                            <td>${user.realName}</td>
                            <td>${user.mobile}</td>
                            <td>${user.email}</td>
                            <td>${user.userStatus}</td>
                            <td>${user.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                            <td>
                                <a class="btn btn-circle btn-primary" data-toggle="modal" href="/admin/user/toEdit.do?id=${user.id}"><i class="icon-edit"></i>修改</a>
                                <a class="btn btn-circle btn-danger"  data-toggle="modal" href="#delete-modal"><i class="icon-remove"></i>删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-12">
        <div class="col-md-6 pull-left">
            <p style="margin-bottom: 0px;line-height: 55px;">总共${pageInfo.total}个记录&nbsp;每页${pageInfo.pageSize}
                &nbsp;当前${pageInfo.pageNum}</p>
        </div>
        <div class="col-md-6 pull-right" id="js-bootpag" style="text-align: right"></div>
    </div>
    <!-- END PAGE CONTENT-->

    <div class="modal fade" id="delete-modal" tabindex="-1" role="basic" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">删除用户</h4>
                </div>
                <div class="modal-body"></div>
                <div class="modal-footer">
                    <button type="button" class="btn dark btn-outline" data-dismiss="modal">取消</button>
                    <button type="button" class="btn red">删除</button>
                </div>
            </div>
        </div>
    </div>

    <div id="add-modal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">新增用户</h4>
                </div>
                <div class="modal-body">
                    <div >
                            <form class="form-horizontal" role="form" action="#">
                                <input type="hidden" id="id" name="id">
                                <div class="form-body">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">用户名</label>

                                        <div class="col-md-9">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                <input type="text" class="form-control input-inline input-medium" autocomplete="off"
                                                       placeholder="用户名" name="userName" id="userName">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">手机号</label>

                                        <div class="col-md-9">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
                                                <input type="mobile" class="form-control input-inline input-medium"
                                                       autocomplete="off"
                                                       placeholder="手机号" name="mobile" id="mobile">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Email</label>

                                        <div class="col-md-9">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                                <input type="email" class="form-control input-inline input-medium"
                                                       autocomplete="off"
                                                       placeholder="Email Address" name="email" id="email">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">姓名</label>

                                        <div class="col-md-9">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                                <input type="text" class="form-control input-inline input-medium" autocomplete="off"
                                                       placeholder="姓名" name="realName" id="realName">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
                    <button type="button" class="btn green" onclick="addUser();">保存</button>
                </div>
            </div>
        </div>
    </div>
</div>
<#include "../../layout/bottom.ftl">
<script>
        $(function(){
            $("#searchBtn").click(function () {
                submitForm();
            });
            $("#resetBtn").click(function () {
                resetForm();
            });

            var totalPage = ${pageInfo.pages};
            var pageNum = ${pageInfo.pageNum};
            $('#js-bootpag').bootpag({
                total: totalPage,
                page: pageNum,
                maxVisible: 7,
                leaps: true,
                firstLastUse: true,
                first: '首页',
                last: '尾页',
                wrapClass: 'pagination',
                activeClass: 'active',
                disabledClass: 'disabled',
                nextClass: 'next',
                prevClass: 'prev',
                lastClass: 'last',
                firstClass: 'first'
            }).on("page", function(event, num){
                $("#js-bootpag-num").val(num);
                submitForm();
                $("#js-bootpag-num").val("1");
            });
        });

        function addUser(){
            alert(111);
        }

        function submitForm(){
            $("#user-search-form").attr('action','/admin/user/list.do');
            $("#user-search-form").submit();
        }
        function resetForm(){
            document.getElementById("user-search-form").reset();
            //$("#user-search-form")[0].reset();
        }

        function deleteUser(id){
            $.ajax({
                type: "post",
                url: '/admin/user/delete.do',
                data: {
                    id: id
                },
                dataType: 'json',
                cache: false,
                success: function (data) {
                    if (data.returncode == 0) {
                        window.location.href = "/admin/user/list.do"
                    }else{
                        alert(data.message);
                    }
                }
            });
        }
</script>
</body>
</html>