<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title></title>
    <#include "head/common.ftl">
    <link rel="stylesheet" href="static/ace/css/font-awesome.css"/>
    <!-- text fonts -->
    <link rel="stylesheet" href="static/ace/css/ace-fonts.css"/>
    <!-- ace styles -->
    <link rel="stylesheet" href="static/ace/css/ace.css" class="ace-main-stylesheet" id="main-ace-style"/>
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-part2.css" class="ace-main-stylesheet"/>
    <![endif]-->
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="static/ace/css/ace-ie.css"/>
    <![endif]-->
    <!-- ace settings handler -->
    <script src="static/ace/js/ace-extra.js"></script>
    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->
    <!--[if lte IE 8]>
    <script src="static/ace/js/html5shiv.js"></script>
    <script src="static/ace/js/respond.js"></script>
    <![endif]-->
</head>
<body class="no-skin">

<#include "head/header.ftl">
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>
    <!-- 左侧菜单 -->
<#include "head/left.ftl">
    <div class="main-content">
        <div class="main-content-inner">
            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <div id="jzts" style="display:none; width:100%; position:fixed; z-index:99999999;">
                    <div class="commitopacity" id="bkbgjz"></div>
                    <div style="padding-left: 70%;padding-top: 1px;">
                        <div style="float: left;margin-top: 3px;"><img src="static/images/loadingi.gif" /> </div>
                        <div style="margin-top: 6px;"><h4 class="lighter block red">&nbsp;加载中 ...</h4></div>
                    </div>
                </div>
                <div class="row">
                    <div>
                        <iframe name="mainFrame" id="mainFrame" frameborder="0" src="/main"
                                style="margin:0 auto;width:100%;height:100%;"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ace scripts -->
<script src="static/ace/js/ace/elements.scroller.js"></script>
<script src="static/ace/js/ace/elements.colorpicker.js"></script>
<script src="static/ace/js/ace/elements.fileinput.js"></script>
<script src="static/ace/js/ace/elements.typeahead.js"></script>
<script src="static/ace/js/ace/elements.wysiwyg.js"></script>
<script src="static/ace/js/ace/elements.spinner.js"></script>
<script src="static/ace/js/ace/elements.treeview.js"></script>
<script src="static/ace/js/ace/elements.wizard.js"></script>
<script src="static/ace/js/ace/elements.aside.js"></script>
<script src="static/ace/js/ace/ace.js"></script>
<script src="static/ace/js/ace/ace.ajax-content.js"></script>
<script src="static/ace/js/ace/ace.touch-drag.js"></script>
<script src="static/ace/js/ace/ace.sidebar.js"></script>
<script src="static/ace/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="static/ace/js/ace/ace.submenu-hover.js"></script>
<script src="static/ace/js/ace/ace.widget-box.js"></script>
<script src="static/ace/js/ace/ace.settings.js"></script>
<script src="static/ace/js/ace/ace.settings-rtl.js"></script>
<script src="static/ace/js/ace/ace.settings-skin.js"></script>
<script src="static/ace/js/ace/ace.widget-on-reload.js"></script>
<script src="static/ace/js/ace/ace.searchbox-autocomplete.js"></script>
<!-- inline scripts related to this page -->

<!-- the following scripts are used in demo only for onpage help and you don't need them -->
<link rel="stylesheet" href="static/ace/css/ace.onpage-help.css"/>

<script type="text/javascript"> ace.vars['base'] = '..'; </script>
<script src="static/ace/js/ace/elements.onpage-help.js"></script>
<script src="static/ace/js/ace/ace.onpage-help.js"></script>


<!--引入弹窗组件start-->
<script type="text/javascript" src="plugins/attention/zDialog/zDrag.js"></script>
<script type="text/javascript" src="plugins/attention/zDialog/zDialog.js"></script>
<!--引入弹窗组件end-->
<!--提示框-->
<script type="text/javascript" src="static/js/jquery.tips.js"></script>

<script type="text/javascript">

    $(function(){
        createMenu();
    });

    function createMenu(){
        $.ajax({
            type: "get",
            url: '/createMenuTree',
            dataType:'json',
            cache: false,
            success: function(data){
                if(data.returncode==0){
                    var mentstr = "";
                    $.each(data.result,function(index,item){
                        if(index==0){
                            mentstr+='<li class="active open" onclick="selectMenu(this);"><a href="'+ item.menuUrl +'"><i class="'+item.menuIcon+'"></i><span class="menu-text">'+item.menuName+'</span></a>';
                        }else{
                            mentstr+='<li onclick="selectMenu(this);"><a href="'+ item.menuUrl +'"><i class="'+item.menuIcon+'"></i><span class="menu-text">'+item.menuName+'</span></a>';
                        }

                        if(item.menuList.length>0){
                            mentstr+='<ul class="submenu">';
                            $.each(item.menuList,function(i,it){
                                mentstr+='<li><a href="'+ it.menuUrl +'" target="mainFrame"><i class="'+it.menuIcon+'"></i><span class="menu-text">'+it.menuName+'</span></a></li>';
                            });
                            mentstr+='</ul>';
                        }
                        mentstr+='</li>';
                    });
                    $("#menu_tree").html(mentstr);
                }
            }
        });
    }

    function selectMenu(menu){
        $(menu).siblings().removeClass();
        $(menu).addClass("active open");
    }

</script>
</body>
</html>
