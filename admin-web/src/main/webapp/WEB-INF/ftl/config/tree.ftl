<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../layout/common.ftl">
    <link type="text/css" rel="stylesheet"
          href="${basePath}assets/plugins/jstree/dist/themes/default/style.min.css"/>
    <script type="text/javascript" src="${basePath}assets/plugins/jstree/dist/jstree.min.js"></script>
    <script type="text/javascript" src="${basePath}assets/js/sys/config.js?v=2016082222"></script>
</head>
<body style="overflow: hidden">

<div class="col-md-12">
    <div class="col-md-2">
        <div id="tree-config">
        </div>
    </div>
    <div class="col-md-10">
        <div class="portlet light">
            <div class="portlet-title" style="min-height: 30px;">
                <div class="caption" style="padding: 0px;">
                    <form method="post" id="js-edit-form" class="form-horizontal">
                        <input type="hidden" name="id" id="id"/>

                        <div class="form-group" style="width: 600px;margin-bottom: 5px;font-size: 14px">
                            <label class="col-md-2 control-label">
                                配置:<span class="required" aria-required="true"> * </span>
                            </label>

                            <div class="col-md-10" style="padding-top:5px;">
                                <input type="text" name="configCode" id="configCode" placeholder="配置编码"
                                       style="float:left;width: 100px;margin-right: 5px;"/>
                                <input type="text" name="configDesc" id="configDesc" placeholder="配置描述"
                                       style="float:left;width: 200px;margin-left: 5px;margin-right: 10px;"/>
                                <a class="btn btn-circle green btn-sm" onclick="saveConfig();"
                                   style="margin-left: 10px;height: 24px;margin-left: 10px;padding: 3px 10px;">
                                    <i class="fa fa-check"></i> 保存
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="actions" style="padding: 0px;">
                    <a class="btn btn-circle red btn-sm js-ajax-dialog" data-toggle="modal"
                       data-url="/config/addItem.html" id="addbtn" data-target="#ajax-modal">
                        <i class="fa fa-plus"></i> 新增配置项
                    </a>
                </div>
            </div>
            <div class="portlet-body" id="js-item-body">
            </div>
        </div>
    </div>
</div>

<form method="post" id="js-item-form" class="form-horizontal" action="/config/itemList.html">
    <input type="hidden" id="js-item-num" name="pageNo" value="1"/>
</form>

<div class="modal fade" id="ajax-modal" data-width="550"></div>

<#include "../layout/bottom.ftl">
<script>
    ConfigJS.init();
</script>
</body>
</html>