var ConfigJS = function () {
    toastr.options = {
        "closeButton": true,
        "debug": false,
        "positionClass": "toast-bottom-right",
        "onclick": null,
        "showDuration": "1000",
        "hideDuration": "1000",
        "timeOut": "5000",
        "extendedTimeOut": "1000",
        "showEasing": "swing",
        "hideEasing": "linear",
        "showMethod": "fadeIn",
        "hideMethod": "fadeOut"
    };

    var addConfigItem = function () {
        $("#js-add-item-btn").click(function () {
            $("#js-add-item-form").ajaxSubmit({
                type: 'post', // 提交方式 get/post
                dataType: "json",
                success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                    // 此处可对 data 作相关处理
                    if (data.returncode == 0) {
                        toastr["success"](data.message, "新增配置");
                        $("#ajax-modal").modal("hide");
                        submitItemFrom();
                    } else {
                        toastr["error"](data.message, "新增配置");
                    }
                }
            });
        });
    };

    var updateConfigItem = function () {
        $("#js-edit-item-btn").click(function () {
            $("#js-edit-item-form").ajaxSubmit({
                type: 'post', // 提交方式 get/post
                dataType: "json",
                success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                    // 此处可对 data 作相关处理
                    if (data.returncode == 0) {
                        toastr["success"](data.message, "修改配置项");
                        $("#ajax-modal").modal("hide");
                        submitItemFrom();
                    } else {
                        toastr["error"](data.message, "修改配置项");
                    }
                }
            });
        });
    };

    var removeConfigItem = function () {
        $("#js-remove-item-btn").click(function () {
            $("#js-remove-item-form").ajaxSubmit({
                type: 'post', // 提交方式 get/post
                dataType: "json",
                success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                    // 此处可对 data 作相关处理
                    if (data.returncode == 0) {
                        toastr["success"](data.message, "删除配置项");
                        $("#ajax-modal").modal("hide");
                        submitItemFrom();
                    } else {
                        toastr["error"](data.message, "删除配置项");
                    }
                }
            });
        });
    };
    var init = function (){
        loadTree();
        $('#tree-config').on('select_node.jstree', function (e, data) {
            var selected = $('#' + data.selected);
            configId = selected.attr('id');
            $("#addbtn").show();
            $("#addbtn").attr('data-url', '/config/addItem.do?configId=' + configId);
            loadInput();
            submitItemFrom();
        });
        $("#addbtn").hide();
    };

    return {
        init:function(){
            init();
            ajaxDalog();
        },
        addConfigItem: function () {
            addConfigItem();
        },
        updateConfigItem: function () {
            updateConfigItem();
        },
        removeConfigItem: function () {
            removeConfigItem();
        }
    }
}();
var configId = '';
function loadTree() {
    $.ajax({
        type: "get",
        url: '/config/getConfigList.do',
        dataType: 'json',
        async: false,
        cache: false,
        success: function (data) {
            if (data.returncode == 0) {
                var treearray = new Array;
                $.each(data.result, function (i, item) {
                    if (i == 0) {
                        configId = item.id;
                    }
                    var data = {'id': item.id, 'text': item.configDesc};
                    treearray.push(data);
                });
                var treeItem = {
                    'id': 0, 'text': '配置列表', 'children': treearray,
                    state: {opened: true, disabled: false, selected: true}
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

function loadInput(){
    var args = {
        id: configId
    };
    $.ajax({
        type: "post",
        url: '/config/getConfigById.do',
        dataType: 'json',
        async: false,
        data: args,
        success: function (data) {
            if (data.returncode == 0) {
                $("#id").val(data.result.id);
                $("#configCode").val(data.result.configCode);
                $("#configCode").attr('disabled',true);
                $("#configDesc").val(data.result.configDesc);
            } else {
                toastr["error"](data.message, "新增配置");
            }
        }
    });
}
function submitItemFrom() {
    $("#js-item-form").ajaxSubmit({
        type: 'post', // 提交方式 get/post
        url: '/config/itemList.do?configId=' + configId,
        success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
            // 此处可对 data 作相关处理
            $("#js-item-body").html(data);
            ajaxDalog();
        }
    });
};
function ajaxDalog () {
    $.each($(".js-ajax-dialog"), function () {
        $(this).bind("click", function () {
            $("body").modalmanager();
            var ele = $(this), targetId = ele.attr("data-target");
            var dialogModal = $(targetId);
            dialogModal.load(ele.attr("data-url"), "", function () {
                dialogModal.modal()
            });
        })
    });
};

function saveConfig() {
    var args = {
        id: $("#id").val(),
        configDesc: $("#configDesc").val(),
        configCode: $("#configCode").val()
    };
    $.ajax({
        type: "post",
        url: '/config/saveConfig.do',
        dataType: 'json',
        async: false,
        data: args,
        success: function (data) {
            if (data.returncode == 0) {
                toastr["success"](data.message, "保存配置");
                $("#ajax-modal").modal("hide");
                loadTree();
            } else {
                toastr["error"](data.message, "保存配置");
            }

        }
    });
}

function removeConfig() {
    var args = {
        id: $("#id").val()
    };
    $.ajax({
        type: "post",
        url: '/config/submitRemove.html',
        dataType: 'json',
        async: false,
        data: args,
        success: function (data) {
            if (data.returncode == 0) {
                loadTree();
                submitItemFrom();
            } else {
                toastr["error"](data.message, "删除配置");
            }

        }
    });
}