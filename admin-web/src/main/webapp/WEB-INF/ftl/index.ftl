<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>欢迎登录</title>
<#include "layout/common.ftl">
</head>
<body class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
<#include "layout/header.ftl">
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
    <!-- BEGIN SIDEBAR -->
    <div class="page-sidebar navbar-collapse collapse">
        <ul class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
        </ul>
    </div>
    <!-- END SIDEBAR -->
    <!-- BEGIN CONTENT -->
    <div class="page-content-wrapper">
        <div class="page-content">
            <div class="page-bar">
                <ul class="page-breadcrumb">
                    <li>
                        <i class="fa fa-home"></i>
                        <a href="/index.do">Home</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#" id="menu-1">Data Tables</a>
                        <i class="fa fa-angle-right"></i>
                    </li>
                    <li>
                        <a href="#" id="menu-2">Responsive Datatables</a>
                    </li>
                </ul>
            </div>
            <iframe name="mainFrame" id="mainFrame" frameborder="0" scrolling="auto" src="/main.do"
                    style="margin:0;width:100%;height:100%;" ></iframe>
        </div>
    </div>
    <!-- END CONTENT -->
    <!-- BEGIN QUICK SIDEBAR -->
    <#--<a href="javascript:;" class="page-quick-sidebar-toggler"><i class="icon-close"></i></a>-->
    <#--<div class="page-quick-sidebar-wrapper">-->
    <#--<#include "layout/right.ftl">-->
    <#--</div>-->
    <!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<#include "layout/footer.ftl">
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
<script src="${basePath}assets/plugins/respond.min.js"></script>
<script src="${basePath}assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${basePath}assets/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<!-- IMPORTANT! Load jquery-ui.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
<script src="${basePath}assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="${basePath}assets/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${basePath}assets/js/sys/metronic.js" type="text/javascript"></script>
<script src="${basePath}assets/js/sys/layout.js" type="text/javascript"></script>
<script src="${basePath}assets/js/sys/quick-sidebar.js" type="text/javascript"></script>


<script type="text/javascript">
    $(function () {
        Metronic.init(); // init metronic core componets
        Layout.init(); // init layout
        QuickSidebar.init(); // init quick sidebar
        initFrame('mainFrame', 560);
        createMenu();
    });

    function createMenu() {
        $.ajax({
            type: "get",
            url: '/createMenuTree.do',
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.returncode == 0) {
                    var mentstr = "";
                    $.each(data.result, function (index, item) {
                        if (index == 0) {
                            mentstr += '<li > <a href="' + item.menuUrl + '"><i class="' + item.menuIcon + '"></i><span class="title">' + item.menuName + '</span></a>';
                        } else {
                            mentstr += '<li ><a href="' + item.menuUrl + '"><i class="' + item.menuIcon + '"></i><span class="title">' + item.menuName + '</span></a>';
                        }
                        if (item.childList!=null && item.childList.length > 0) {
                            mentstr += '<ul class="sub-menu">';
                            $.each(item.childList, function (i, it) {
                                mentstr += '<li><a href="' + it.menuUrl + '" target="mainFrame" onclick="selectMenu(this,'+it.id+');"><i class="' + it.menuIcon + '"></i><span class="title">' + it.menuName + '</span></a></li>';
                            });
                            mentstr += '</ul>';
                        }
                        mentstr += '</li>';
                    });
                    $(".page-sidebar-menu").html(mentstr);
                }
            }
        });
    }
    function selectParent(menu) {
        //$(menu).siblings().removeClass();
        //$(menu).addClass("active open");
    }
    function selectMenu(menu,id) {
        //$(menu).siblings().removeClass();
        //$(menu).addClass("active open");
        $.ajax({
            type: "get",
            url: '/admin/menu/getMenuParentById.do?id='+id,
            dataType: 'json',
            cache: false,
            success: function (data) {
                if (data.returncode == 0) {
                    $("#menu-1").attr('href',data.result.parentMenu.menuUrl);
                    $("#menu-1").html(data.result.parentMenu.menuName);
                    $("#menu-2").attr('href',data.result.menuUrl);
                    $("#menu-2").html(data.result.menuName);
                }
            }
        });
    }

    var browserVersion = window.navigator.userAgent.toUpperCase();
    var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
    var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
    var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
    var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
    var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
    var isIE9More = (!-[1,] == false);
    function reinitIframe(iframeId, minHeight) {
        try {
            var iframe = document.getElementById(iframeId);
            var bHeight = 0;
            if (isChrome == false && isSafari == false)
                bHeight = iframe.contentWindow.document.body.scrollHeight;

            var dHeight = 0;
            if (isFireFox == true)
                dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
            else if (isIE == false && isOpera == false)
                dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
            else if (isIE == true && isIE9More) {//ie9+
                var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
                if (heightDeviation == 0) {
                    bHeight += 3;
                } else if (heightDeviation != 3) {
                    eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                    bHeight += 3;
                }
            }
            else//ie[6-8]、OPERA
                bHeight += 3;

            var height = Math.max(bHeight, dHeight);
            if (height < minHeight) height = minHeight;
            iframe.style.height = height + "px";
        } catch (ex) {
        }
    }
    function initFrame(iframeId, minHeight) {
        eval("window.IE9MoreRealHeight" + iframeId + "=0");
        window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
    }
</script>
</body>
</html>
