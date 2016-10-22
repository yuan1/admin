<#import "../marco/page.ftl" as p>
<@p.content title="角色管理" >
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
                <form class="form-horizontal" action="/admin/role/rolePageList.do" id="role-search-form">
                    <input type="hidden" id="js-bootpag-num" name="pageNo" value="1"/>

                    <div class="row">
                        <div class="col-md-4">
                            <div class="form-group">
                                <label class="col-md-4 control-label">角色名</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control input-inline" name="roleName">
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
                    <span class="caption-subject font-green">角色列表</span>
                </div>
                <div class="actions">
                    <a class="btn btn-circle blue" onclick="ModalJS.open('ajax-modal','/admin/role/getById.do');">
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

<script type="text/javascript" src="${basePath}/assets/js/admin/role.js?v=20160181111"></script>
<script>
    RoleJS.init();
</script>
</@p.content>