var RoleJS = function () {
    var pageAjax = function (totalPage, pageNum) {
        PageJS.page('js-bootpag', totalPage, pageNum, function (event, num) {
            $("#js-bootpag-num").val(num);
            submitForm();
            $("#js-bootpag-num").val("1");
        });
    };

    var submitForm = function () {
        $("#role-search-form").ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: "/admin/role/rolePageList.do",
            success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                $("#js-page-body").html(data);
            }
        });
    };

    var toRemove = function (id) {
        AlertJS.confirm('确定要删除这个角色吗?', function () {
            $.ajax({
                type: "post",
                url: '/admin/role/delete.do?id=' + id,
                dataType: 'json',
                async: false,
                success: function (data) {
                    if (data.returncode == 0) {
                        AlertJS.success(data.message);
                        submitForm();
                    } else {
                        AlertJS.error(data.message);
                    }
                },
                error: function () {
                    AlertJS.error('网络超时,请稍后再试试!');
                }
            });
        });
    };

    var submitSave = function () {
        $("#role-form").ajaxSubmit({
            url: '/admin/role/save.do',
            type: 'post', // 提交方式 get/post
            dataType: "json",
            success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                if (data.returncode == 0) {
                    toastr.success(data.message);
                    $("#ajax-modal").modal('hide');
                    submitForm();
                } else {
                    AlertJS.error(data.message);
                }
            },
            error: function () {
                AlertJS.error('网络超时,请稍后再试试!');
            }
        });
    };

    var init = function () {
        $("#searchBtn").click(function () {
            submitForm();
        });
        submitForm();
    };

    var initMenuTree = function () {
        $.ajax({
            type: "get",
            url: '/admin/menu/getMenuList.do',
            dataType: 'json',
            async: false,
            cache: false,
            success: function (data) {
                if (data.returncode == 0) {
                    var menuArray = new Array();
                    $.each(data.result, function (i, item) {
                        var data = {'id': item.id, 'text': item.menuName};
                        if (item.childList != null && item.childList.length > 0) {
                            var childArray = new Array();
                            $.each(item.childList, function (c, ct) {
                                var child = {'id': ct.id, 'text': ct.menuName};
                                childArray.push(child);
                            });
                            data.children = childArray;
                        }
                        menuArray.push(data);
                    });
                    var treeItem = {
                        id: 1, text: '全部', children: menuArray,
                        icon: 'fa fa-home green', state: {opened: true, disabled: false, selected: true}
                    };
                    $('#menu-tree').jstree({
                        "core": {
                            'multiple': false,
                            "data": treeItem
                        },
                        "checkbox": {
                            "keep_selected_style": false,
                        },
                        "plugins": ["checkbox"]
                    });
                    $('#menu-tree').jstree(true).settings.core.data = treeItem;
                    $('#menu-tree').jstree(true).refresh();
                } else {
                    alert(data.message);
                }
            }
        });
    }

    var saveRoleMenus = function () {
        var selectedMenus = $("#menu-tree").jstree().get_checked();
        var param = {
            menuIds: selectedMenus,
            roleId: $("#id").val()
        }
        $.ajax({
            type: "post",
            url: '/admin/role/addRoleMenu.do',
            dataType: 'json',
            data : param,
            async: false,
            cache: false,
            success: function (data) {
                if (data.returncode == 0) {
                    toastr.success(data.message);
                    $("#ajax-modal").modal('hide');
                } else {
                    alert(data.message);
                }
            }
        });
    }

    return {
        init: function () {
            init();
        },
        initPage: function (totalPage, pageNum) {
            pageAjax(totalPage, pageNum);
        },
        toRemove: function (id) {
            toRemove(id);
        },
        submitSave: function () {
            submitSave();
        },
        initMenuTree: function () {
            initMenuTree();
        },
        saveRoleMenus: function () {
            saveRoleMenus();
        }
    }
}();