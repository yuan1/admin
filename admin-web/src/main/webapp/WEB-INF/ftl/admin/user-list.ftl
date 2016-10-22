<#import "../marco/page.ftl" as p>
<@p.content title="用户管理" >
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
                <form class="form-horizontal" action="/admin/user/userPageList.do" id="user-search-form">
                    <input type="hidden" id="js-bootpag-num" name="pageNo" value="1"/>

                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">用户名</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" id="s_user_name"
                                           name="userName">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">姓名</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" id="s_real_name"
                                           name="realName">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">手机号</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" id="s_mobile"
                                           name="mobile">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">邮箱</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" id="s_email"
                                           name="email">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">状态</label>

                                <div class="col-md-8">
                                    <select class="bs-select select2 form-control input-inline" name="userType" id="s_user_type"
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
                            <button type="reset" class="btn btn-circle grey-cascade">
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
                    <a class="btn btn-circle blue" onclick="ModalJS.open('ajax-modal','/admin/user/getById.do');">
                        <i class="fa fa-plus"></i>新增
                    </a>
                </div>
            </div>
            <div class="portlet-body" id="js-page-body">
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="ajax-modal" data-width="550"></div>

<link rel="stylesheet" type="text/css" href="${basePath}/assets/plugins/jquery-multi-select/css/multi-select.css">
<script type="text/javascript" src="${basePath}/assets/plugins/jquery-multi-select/js/jquery.multi-select.js"></script>
<script type="text/javascript" src="${basePath}/assets/js/admin/user.js?v=20160181111"></script>
<script>
    UserJS.init();
</script>
</@p.content>