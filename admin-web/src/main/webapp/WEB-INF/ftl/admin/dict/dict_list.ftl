<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "../../layout/common.ftl">
</head>
<body style="overflow: hidden">
<!-- BEGIN CONTENT -->
<div class="page-content">
    <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
    <div class="modal fade" id="portlet-config" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">Modal title</h4>
                </div>
                <div class="modal-body">
                    Widget settings form goes here
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn blue">Save changes</button>
                    <button type="button" class="btn default" data-dismiss="modal">Close</button>
                </div>
            </div>
            <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
    <!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
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
                        <input type="hidden"  name="pageNo"  value="${pageInfo.pageNum}" >
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">类型id</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline" id="userName"
                                               name="userName" <#if condition.dictId?exists> value="${condition.dictId}" </#if> >
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">类型名称</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline" id="realName"
                                               name="realName"<#if condition.dictName?exists> value="${condition.dictName}" </#if>>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <a class="btn btn-sm btn-circle blue"><i class="fa fa-search"></i>查询</a>
                                <a class="btn btn-sm btn-circle grey-cascade"><i class="fa fa-times"></i>重置</a>
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
                        <span class="caption-subject font-green">字典类型列表</span>
                    </div>
                    <div class="actions">
                        <a href="/admin/dict/add.do" class="btn btn-circle blue">
                            <i class="fa fa-plus"></i>新增
                        </a>
                        <a href="javascript:;" class="btn btn-circle red">
                            <i class="fa fa-remove"></i>删除
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>
                                id
                            </th>
                            <th>
                                类型id
                            </th>
                            <th>
                                类型名称
                            </th>
                            <th>
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list dictList as dict>
                        <tr>
                            <td>
                            ${dict.id}
                            </td>
                            <td>
                            ${dict.dictId}
                            </td>
                            <td>
                            ${dict.dictName}
                            </td>

                            <td>
                                <a class="btn btn-circle btn-primary" href="#"><i class="icon-edit"></i>修改</a>
                                <a class="btn btn-circle btn-danger" href="#"><i class="icon-remove"></i>删除</a>
                            </td>
                        </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 pull-left">
            <p style="margin-bottom: 0px;line-height: 55px;">总共${pageInfo.total}个记录&nbsp;每页${pageInfo.size}
                &nbsp;当前${pageInfo.pageNum}</p>
        </div>
        <div class="col-md-6 pull-right" id="js-bootpag" style="text-align: right;"></div>
    </div>
    <!-- END PAGE CONTENT-->
</div>
<#include "../../layout/bottom.ftl">
<script>
        $(function(){
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

        function submitForm(){
            $("#user-search-form").attr('action','/admin/dict/list.do');
            $("#user-search-form").submit();
        }
</script>
</body>
<!-- END BODY -->
</html>