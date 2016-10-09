<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../layout/common.ftl">
    <link type="text/css" rel="stylesheet"
          href="${basePath}assets/plugins/jstree/dist/themes/default/style.min.css"/>
    <script type="text/javascript" src="${basePath}assets/plugins/jstree/dist/jstree.min.js"></script>
    <script type="text/javascript" src="${basePath}assets/js/admin/menu.js?v=111"></script>
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

<div class="modal fade" id="ajax-modal" data-width="550"></div>
<script>
    MenuJs.init();
</script>
</body>
</html>