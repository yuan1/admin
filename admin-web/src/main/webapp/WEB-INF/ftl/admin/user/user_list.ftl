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
    <div class="row col-md-12" >
            <div class="portlet light">
                <div class="portlet-light">
                    <div class="caption">
                        <i class="icon-magnifier font-green"></i>
                        <span class="caption-subject font-green">查询条件</span>
                    </div>
                </div>
                <div class="portlet-body form">
                    <form class="form-horizontal">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">姓名</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline input-sm" id="user_name" name="user_name">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">电话</label>

                                    <div class="col-md-8">
                                        <input type="text" class="form-control input-inline input-sm" id="mobile" name="mobile">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">角色</label>

                                    <div class="col-md-8">
                                        <select class="bs-select form-control input-inline input-sm "  name="userType"
                                                data-live-search="true">
                                            <option value=''>全部</option>
                                            <option value="1">销售顾问</option>
                                            <option value="2">销售经理</option>
                                            <option value="3">总经理</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label class="col-md-4 control-label">角色</label>

                                    <div class="col-md-8">
                                        <select class="bs-select form-control input-inline input-sm" name="userType"
                                                data-live-search="true">
                                            <option value=''>全部</option>
                                            <option value="1">销售顾问</option>
                                            <option value="2">销售经理</option>
                                            <option value="3">总经理</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <a class="btn btn-circle blue"><i class="fa fa-search"></i>查询</a>
                                <a class="btn btn-circle grey-cascade"><i class="fa fa-times"></i>重置</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </div>


    <!-- BEGIN PAGE CONTENT-->
    <div class="row">
            <div class="portlet light">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-grid font-green"></i>
                        <span class="caption-subject font-green">用户列表</span>
                    </div>
                    <div class="actions">
                        <a href="javascript:;" class="btn btn-circle blue">
                            <i class="fa fa-plus"></i>新增
                        </a>
                        <a href="javascript:;" class="btn btn-circle red">
                            <i class="fa fa-remove"></i>删除
                        </a>
                    </div>
                </div>
                <div class="portlet-body">
                    <table class="table table-bordered table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                Code
                            </th>
                            <th>
                                Company
                            </th>
                            <th class="numeric">
                                Price
                            </th>
                            <th class="numeric">
                                Change
                            </th>
                            <th class="numeric">
                                Change %
                            </th>
                            <th class="numeric">
                                Open
                            </th>
                            <th class="numeric">
                                High
                            </th>
                            <th class="numeric">
                                Low
                            </th>
                            <th class="numeric">
                                Volume
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                AAC
                            </td>
                            <td>
                                AUSTRALIAN AGRICULTURAL COMPANY LIMITED.
                            </td>
                            <td class="numeric">
                                &nbsp;
                            </td>
                            <td class="numeric">
                                -0.01
                            </td>
                            <td class="numeric">
                                -0.36%
                            </td>
                            <td class="numeric">
                                $1.39
                            </td>
                            <td class="numeric">
                                $1.39
                            </td>
                            <td class="numeric">
                                &nbsp;
                            </td>
                            <td class="numeric">
                                9,395
                            </td>
                        </tr>
                        <tr>
                            <td>
                                AAD
                            </td>
                            <td>
                                ARDENT LEISURE GROUP
                            </td>
                            <td class="numeric">
                                $1.15
                            </td>
                            <td class="numeric">
                                +0.02
                            </td>
                            <td class="numeric">
                                1.32%
                            </td>
                            <td class="numeric">
                                $1.14
                            </td>
                            <td class="numeric">
                                $1.15
                            </td>
                            <td class="numeric">
                                $1.13
                            </td>
                            <td class="numeric">
                                56,431
                            </td>
                        </tr>
                        <tr>
                            <td>
                                AAX
                            </td>
                            <td>
                                AUSENCO LIMITED
                            </td>
                            <td class="numeric">
                                $4.00
                            </td>
                            <td class="numeric">
                                -0.04
                            </td>
                            <td class="numeric">
                                -0.99%
                            </td>
                            <td class="numeric">
                                $4.01
                            </td>
                            <td class="numeric">
                                $4.05
                            </td>
                            <td class="numeric">
                                $4.00
                            </td>
                            <td class="numeric">
                                90,641
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ABC
                            </td>
                            <td>
                                ADELAIDE BRIGHTON LIMITED
                            </td>
                            <td class="numeric">
                                $3.00
                            </td>
                            <td class="numeric">
                                +0.06
                            </td>
                            <td class="numeric">
                                2.04%
                            </td>
                            <td class="numeric">
                                $2.98
                            </td>
                            <td class="numeric">
                                $3.00
                            </td>
                            <td class="numeric">
                                $2.96
                            </td>
                            <td class="numeric">
                                862,518
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ABP
                            </td>
                            <td>
                                ABACUS PROPERTY GROUP
                            </td>
                            <td class="numeric">
                                $1.91
                            </td>
                            <td class="numeric">
                                0.00
                            </td>
                            <td class="numeric">
                                0.00%
                            </td>
                            <td class="numeric">
                                $1.92
                            </td>
                            <td class="numeric">
                                $1.93
                            </td>
                            <td class="numeric">
                                $1.90
                            </td>
                            <td class="numeric">
                                595,701
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ABY
                            </td>
                            <td>
                                ADITYA BIRLA MINERALS LIMITED
                            </td>
                            <td class="numeric">
                                $0.77
                            </td>
                            <td class="numeric">
                                +0.02
                            </td>
                            <td class="numeric">
                                2.00%
                            </td>
                            <td class="numeric">
                                $0.76
                            </td>
                            <td class="numeric">
                                $0.77
                            </td>
                            <td class="numeric">
                                $0.76
                            </td>
                            <td class="numeric">
                                54,567
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ACR
                            </td>
                            <td>
                                ACRUX LIMITED
                            </td>
                            <td class="numeric">
                                $3.71
                            </td>
                            <td class="numeric">
                                +0.01
                            </td>
                            <td class="numeric">
                                0.14%
                            </td>
                            <td class="numeric">
                                $3.70
                            </td>
                            <td class="numeric">
                                $3.72
                            </td>
                            <td class="numeric">
                                $3.68
                            </td>
                            <td class="numeric">
                                191,373
                            </td>
                        </tr>
                        <tr>
                            <td>
                                ADU
                            </td>
                            <td>
                                ADAMUS RESOURCES LIMITED
                            </td>
                            <td class="numeric">
                                $0.72
                            </td>
                            <td class="numeric">
                                0.00
                            </td>
                            <td class="numeric">
                                0.00%
                            </td>
                            <td class="numeric">
                                $0.73
                            </td>
                            <td class="numeric">
                                $0.74
                            </td>
                            <td class="numeric">
                                $0.72
                            </td>
                            <td class="numeric">
                                8,602,291
                            </td>
                        </tr>
                        <tr>
                            <td>
                                AGG
                            </td>
                            <td>
                                ANGLOGOLD ASHANTI LIMITED
                            </td>
                            <td class="numeric">
                                $7.81
                            </td>
                            <td class="numeric">
                                -0.22
                            </td>
                            <td class="numeric">
                                -2.74%
                            </td>
                            <td class="numeric">
                                $7.82
                            </td>
                            <td class="numeric">
                                $7.82
                            </td>
                            <td class="numeric">
                                $7.81
                            </td>
                            <td class="numeric">
                                148
                            </td>
                        </tr>
                        <tr>
                            <td>
                                AGK
                            </td>
                            <td>
                                AGL ENERGY LIMITED
                            </td>
                            <td class="numeric">
                                $13.82
                            </td>
                            <td class="numeric">
                                +0.02
                            </td>
                            <td class="numeric">
                                0.14%
                            </td>
                            <td class="numeric">
                                $13.83
                            </td>
                            <td class="numeric">
                                $13.83
                            </td>
                            <td class="numeric">
                                $13.67
                            </td>
                            <td class="numeric">
                                846,403
                            </td>
                        </tr>
                        <tr>
                            <td>
                                AGO
                            </td>
                            <td>
                                ATLAS IRON LIMITED
                            </td>
                            <td class="numeric">
                                $3.17
                            </td>
                            <td class="numeric">
                                -0.02
                            </td>
                            <td class="numeric">
                                -0.47%
                            </td>
                            <td class="numeric">
                                $3.11
                            </td>
                            <td class="numeric">
                                $3.22
                            </td>
                            <td class="numeric">
                                $3.10
                            </td>
                            <td class="numeric">
                                5,416,303
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
        </div>
    </div>
    <!-- END PAGE CONTENT-->
</div>
<#include "../../layout/bottom.ftl">
<script>
    jQuery(document).ready(function () {
        // initiate layout and plugins
        Metronic.init(); // init metronic core components
        Layout.init(); // init current layout
    });
</script>
</body>
<!-- END BODY -->
</html>