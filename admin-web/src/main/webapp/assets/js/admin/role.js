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
        }
    }
}();