<!DOCTYPE html>
<html lang="zh_CN">
<head>
<#include "layout/common.ftl">
    <link href="assets/plugins/bootstrap-switch/css/bootstrap-switch.min.css" rel="stylesheet" type="text/css"/>
    <!-- BEGIN THEME STYLES -->
    <link href="assets/css/components.css" id="style_components" rel="stylesheet" type="text/css"/>
    <link href="assets/css/plugins.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/layout.css" rel="stylesheet" type="text/css"/>
    <link id="style_color" href="assets/css/themes/darkblue.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/custom.css" rel="stylesheet" type="text/css"/>
    <!-- END THEME STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<body style="overflow: hidden">
<!-- BEGIN CONTENT -->
<div class="page-content" >
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

    <div class="page-bar">
        <ul class="page-breadcrumb">
            <li>
                <i class="fa fa-home"></i>
                <a href="index.html">Home</a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="#">Data Tables</a>
                <i class="fa fa-angle-right"></i>
            </li>
            <li>
                <a href="#">Responsive Datatables</a>
            </li>
        </ul>
    </div>
    <!-- END PAGE HEADER-->
    <!-- BEGIN PAGE CONTENT-->
    <div class="row">
        <div class="col-md-12">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="fa fa-cogs"></i>Responsive Flip Scroll Tables
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse">
                        </a>
                        <a href="#portlet-config" data-toggle="modal" class="config">
                        </a>
                        <a href="javascript:;" class="reload">
                        </a>
                        <a href="javascript:;" class="remove">
                        </a>
                    </div>
                </div>
                <div class="portlet-body flip-scroll">
                    <table class="table table-bordered table-striped table-condensed flip-content">
                        <thead class="flip-content">
                        <tr>
                            <th width="20%">
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
    </div>
    <!-- END PAGE CONTENT-->
</div>
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="assets/plugins/respond.min.js"></script>
<script src="assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="assets/plugins/jquery.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="assets/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<script src="assets/js/metronic.js" type="text/javascript"></script>
<script src="assets/js/layout.js" type="text/javascript"></script>
<script src="assets/js/quick-sidebar.js" type="text/javascript"></script>
<script src="assets/js/demo.js" type="text/javascript"></script>
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