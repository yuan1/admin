var UserJS = function () {
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
    var pageAjax = function(totalPage, pageNum){
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
        }).on("page", function(event, num){
            $("#js-bootpag-num").val(num);
            submitForm();
            $("#js-bootpag-num").val("1");
        });
    };
    var submitForm = function(){
        $("#user-search-form").ajaxSubmit({
            type: 'post', // 提交方式 get/post
            url: "/admin/user/userPageList.do",
            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                $("#js-page-body").html(data);
                ajaxDalog();
            }
        });
    };
    var updateUser = function () {
        $("#js-edit-item-btn").click(function () {
            $("#js-edit-item-form").ajaxSubmit({
                url:'/admin/config/submitEditItem.do',
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

    var removeUser = function () {
        $("#js-remove-item-btn").click(function () {
            $("#js-remove-item-form").ajaxSubmit({
                url:'/admin/config/submitRemoveItem.do',
                type: 'post', // 提交方式 get/post
                dataType: "json",
                success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                    // 此处可对 data 作相关处理
                    if (data.returncode == 0) {
                        toastr["success"](data.message, "删除配置项");
                        $("#ajax-modal").modal("hide");
                    } else {
                        toastr["error"](data.message, "删除配置项");
                    }
                }
            });
        });
    };
    var init = function (){
        $("#searchBtn").click(function(){
            submitForm();
        });
        submitForm();
    };

    var addUser = function (){
        $("#user-add-form").ajaxSubmit({
            url: '/admin/user/save.do',
            type: 'post', // 提交方式 get/post
            dataType: "json",
            success: function (data) { // data 保存提交后返回的数据，一般为 json 数据
                // 此处可对 data 作相关处理
                if (data.returncode == 0) {
                    toastr["success"](data.message, "新增用户");
                    $("#add-modal").modal("hide");
                    submitForm();
                } else {
                    toastr["error"](data.message, "新增用户");
                }
            }
        });
    }

    return {
        init:function(){
            init();
            ajaxDalog();
        },
        initPage:function(totalPage, pageNum){
            pageAjax(totalPage, pageNum);
        },
        addUser :function (){
            addUser();
        },
        updateUser: function () {
            updateUser();
        },
        removeUser: function () {
            removeUser();
        }
    }
}();