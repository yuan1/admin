var MenuJs = function () {
    var init = function () {
        loadTree();
        $('#tree-config').on('select_node.jstree', function (e, data) {
            var selected = $('#' + data.selected);
            var configId = selected.attr('id');
            $.ajax({
                type: 'get',
                async: false,
                url: '/admin/menu/getSubMenuList.do?parentId=' + configId,
                success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                    // 此处可对 data 作相关处理
                    $("#js-page-body").html(data);
                }
            });
        });
    };

    var saveMenu = function () {
        $("#menu-form").ajaxSubmit({
            url: '/admin/menu/save.do',
            type: 'post', // 提交方式 get/post
            dataType: "json",
            success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                if (data.returncode == 0) {
                    toastr["success"](data.message, "保存用户");
                    $("#add-modal").modal('hide');
                    submitForm();
                } else {
                    toastr["error"](data.message, "保存用户");
                }
            }
        });
    };

    return {
        init: function () {
            init();
            $("#addBtn").click(function () {
                $(".modal-title").text('新增菜单');
                $("#add-modal").modal('show');
            });
        },
        saveMenu: function () {
            saveMenu();
        }
    }
}();
function loadTree() {
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
                    if(item.childList != null && item.childList.length>0){
                        var childArray = new Array();
                        $.each(item.childList, function (c, ct) {
                            var child = {'id': ct.id, 'text': ct.menuName};
                            childArray.push(child);
                        });
                        data.children=childArray;
                    }
                    menuArray.push(data);
                });
                var treeItem = {
                    id: 999999999, text: '菜单列表', children: menuArray,
                    icon:'fa fa-home green',state: {opened: true, disabled: false, selected: true}
                };
                $('#tree-config').jstree({
                    "core": {
                        'multiple': false,
                        "data": treeItem
                    },
                    "types": {
                        "default": {
                            "icon": "fa fa-folder icon-state-warning icon-lg"
                        }
                    },
                    "plugins": ["types"]
                });
                $('#tree-config').jstree(true).settings.core.data = treeItem;
                $('#tree-config').jstree(true).refresh();
            } else {
                alert(data.message);
            }
        }
    });
}