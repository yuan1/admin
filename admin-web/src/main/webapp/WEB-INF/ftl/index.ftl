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
            <iframe name="mainFrame" id="mainFrame" frameborder="0" scrolling="auto" src="/admin/user/list.do"
                    style="margin:0;width:100%;height:100%;" ></iframe>
        </div>
    </div>
    <!-- END CONTENT -->
    <!-- BEGIN QUICK SIDEBAR -->
    <a href="javascript:;" class="page-quick-sidebar-toggler"><i class="icon-close"></i></a>

    <div class="page-quick-sidebar-wrapper">
    <#include "layout/right.ftl">
    </div>
    <!-- END QUICK SIDEBAR -->
</div>
<!-- END CONTAINER -->
<#include "layout/footer.ftl">
<#include "layout/bottom.ftl">

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
                            mentstr += '<li class="start active open" onclick="selectMenu(this);"> <a href="' + item.menuUrl + '"><i class="' + item.menuIcon + '"></i><span class="title">' + item.menuName + '</span></a>';
                        } else {
                            mentstr += '<li onclick="selectMenu(this);"><a href="' + item.menuUrl + '"><i class="' + item.menuIcon + '"></i><span class="title">' + item.menuName + '</span></a>';
                        }
                        if (item.menuList.length > 0) {
                            mentstr += '<ul class="sub-menu">';
                            $.each(item.menuList, function (i, it) {
                                mentstr += '<li><a href="' + it.menuUrl + '" target="mainFrame"><i class="' + it.menuIcon + '"></i><span class="title">' + it.menuName + '</span></a></li>';
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

    function selectMenu(menu) {
        $(menu).siblings().removeClass();
        $(menu).addClass("active open");
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
