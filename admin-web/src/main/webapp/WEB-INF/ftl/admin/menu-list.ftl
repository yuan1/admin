<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../layout/common.ftl">
    <link type="text/css" rel="stylesheet"
          href="${basePath}assets/plugins/jstree/dist/themes/default/style.min.css"/>
    <script type="text/javascript" src="${basePath}assets/plugins/jstree/dist/jstree.min.js"></script>
    <script type="text/javascript" src="${basePath}assets/js/admin/menu.js?v=112"></script>
</head>
<body style="overflow: hidden">

<div class="col-md-12">
    <div class="col-md-2">
        <div id="tree-config">
        </div>
    </div>
    <div class="col-md-10">
        <div class="portlet light">
            <div class="portlet-title">
                <div class="caption">
                    <i class="icon-grid font-green"></i>
                    <span class="caption-subject font-green">菜单列表</span>
                </div>
                <div class="actions">
                    <a class="btn btn-circle blue" id="addBtn">
                        <i class="fa fa-plus"></i>新增
                    </a>
                </div>
            </div>
            <div class="portlet-body" id="js-page-body">
            </div>
        </div>
    </div>
</div>

<div id="add-modal" class="modal fade" tabindex="-1">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
            <h4 class="modal-title"></h4>
        </div>
        <div class="modal-body">
            <div>
                <form class="form-horizontal" role="form" action="#" id="menu-form">
                    <input type="hidden" id="id" name="id">

                    <div class="form-body">
                        <div class="form-group">
                            <label class="col-md-3 control-label">父菜单</label>
                            <div class="col-md-9">
                                    <select id="parentId" class="form-control select2" placeholder="父菜单">
                                        <option value="">11</option>
                                    </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-3 control-label">菜单名称</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-inline input-medium"
                                           autocomplete="off" name="menuName" id="menuName">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">菜单URL</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                    <input type="text" class="form-control input-inline input-medium"
                                           autocomplete="off" name="menuUrl" id="menuUrl">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-md-3 control-label">排序</label>

                            <div class="col-md-9">
                                <div class="input-group">
                                    <input type="mobile" class="form-control input-inline input-medium"
                                           autocomplete="off" name="menuOrder" id="menuOrder">
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-md-2 control-label">图标</label>

                            <div class="col-md-10">
                                <ul id='grid-icon'></ul>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
            <button type="button" class="btn green" onclick="MenuJs.saveMenu();">保存</button>
        </div>
    </div>
</div>
<script>
    MenuJs.init();
</script>
</body>
</html>