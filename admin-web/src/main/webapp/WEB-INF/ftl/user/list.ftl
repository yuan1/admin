<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../layout/common.ftl">
    <script type="text/javascript" src="${basePath}assets/js/admin/user.js?v=2016082222"></script>
</head>
<body style="overflow: hidden">

<div class="page-content">
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
                                           name="userName" <#if condition.userName?exists>
                                           value="${condition.userName}" </#if>>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">姓名</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" id="realName"
                                           name="realName"<#if condition.realName?exists>
                                           value="${condition.realName}" </#if>>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">手机号</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" id="mobile"
                                           name="mobile" <#if condition.mobile?exists>
                                           value="${condition.mobile}" </#if>>
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
                            <a class="btn btn-circle blue" id="searchBtn"><i class="fa fa-search"></i>查询</a>
                            <button type="reset" class="btn btn-circle grey-cascade" id="typereset">
                                <i class="fa fa-times">重置</i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

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
            <div class="portlet-body" id="js-page-body">
            </div>
        </div>
    </div>
</div>


<form method="post" id="js-item-form" class="form-horizontal">
    <input type="hidden" id="js-item-num" name="pageNo" value="1"/>
</form>

<div class="modal fade" id="ajax-modal" data-width="550"></div>

<div id="delete-modal" class="modal fade" tabindex="-1" role="basic" aria-hidden="true">
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
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">新增用户</h4>
    </div>
    <div class="modal-body">
        <div>
            <form class="form-horizontal" role="form" action="#" id="user-add-form">
                <input type="hidden" id="id" name="id">

                <div class="form-body">
                    <div class="form-group">
                        <label class="col-md-3 control-label">用户名</label>

                        <div class="col-md-9">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" class="form-control input-inline input-medium"
                                       autocomplete="off"
                                       placeholder="用户名" name="userName" id="userName">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-3 control-label">姓名</label>

                        <div class="col-md-9">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                <input type="text" class="form-control input-inline input-medium"
                                       autocomplete="off"
                                       placeholder="姓名" name="realName" id="realName">
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
                </div>
            </form>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
        <button type="button" class="btn green" onclick="UserJS.addUser();">保存</button>
    </div>
</div>

<script>
    UserJS.init();
</script>
</body>
</html>