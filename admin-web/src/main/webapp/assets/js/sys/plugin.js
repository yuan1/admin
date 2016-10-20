var ModalJS = function () {
    return {
        open: function (id, url) {
            var dialogModal = $("#" + id);
            dialogModal.load(url, "", function () {
                dialogModal.modal()
            });
        }
    }
}();


var PageJS = function (){
    return {
        page: function (id,totalPage, pageNum,callback) {
            $('#'+id).bootpag({
                total: totalPage,
                page: pageNum,
                maxVisible: 10,
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
            }).on("page",callback);
        }
    }
}();

var AlertJS = function () {
    return {
        info: function (message) {
            swal(message);
        },
        error: function (title) {
            swal(title, '',"error");
        },
        warn: function (title) {
            swal(title, '', "warning");
        },
        success: function (title) {
            swal(title, '', "success");
        },
        confirm: function (title, text, callback) {
            swal({
                title: title,
                text: text,
                type: "warning",
                showCancelButton: true,
                cancelButtonText: '取消',
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定",
                closeOnConfirm: false
            }, callback);
        }
    }
}();

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