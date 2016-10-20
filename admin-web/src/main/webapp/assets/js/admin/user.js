var UserJS = function () {
    var pageAjax = function (totalPage, pageNum) {
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
        }).on("page", function (event, num) {
            $("#js-bootpag-num").val(num);
            submitForm();
            $("#js-bootpag-num").val("1");
        });
    };

    var submitForm = function () {
        $("#user-search-form").ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: "/admin/user/userPageList.do",
            success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                $("#js-page-body").html(data);
            }
        });
    };

    var toUpdate = function (id) {
        $.ajax({
            type: "post",
            url: '/admin/user/getUserById.do?id=' + id,
            dataType: 'json',
            async: false,
            success: function (data) {
                if (data.returncode == 0) {
                    $(".modal-title").text('修改用户');
                    $("#add-modal").modal('show');
                    $("#id").val(data.result.id);
                    $("#userName").val(data.result.userName);
                    $("#realName").val(data.result.realName);
                    $("#mobile").val(data.result.mobile);
                    $("#email").val(data.result.email);
                }
            }
        });
    };


    var toRemove = function (id) {
        swal({
                title: "确定要删除这个用户吗?",
                text: "删除之后不可恢复!",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确认",
                closeOnConfirm: true
            },
            function () {
                $.ajax({
                    type: "post",
                    url: '/admin/user/delete.do?id=' + id,
                    dataType: 'json',
                    async: false,
                    success: function (data) {
                        if (data.returncode == 0) {
                            toastr["success"]('删除成功', "删除用户");
                            submitForm();
                        }
                    }
                });
            }
        );
    };

    var submitSave = function () {
        $("#user-form").ajaxSubmit({
            url: '/admin/user/save.do',
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

    var init = function () {
        $("#searchBtn").click(function () {
            submitForm();
        });
        $("#addBtn").click(function () {
            $(".modal-title").text('新增用户');
            $("#add-modal").modal('show');
            $("#user-form")[0].reset();
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
        toUpdate: function (id) {
            toUpdate(id);
        },
        toRemove: function (id) {
            toRemove(id);
        },
        submitSave: function () {
            submitSave();
        }
    }
}();