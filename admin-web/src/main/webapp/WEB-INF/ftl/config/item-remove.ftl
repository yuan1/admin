<div class="modal-header">
    <button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
    <h4 class="modal-title">删除配置项</h4>
</div>
<div class="modal-body">
    <form method="post" id="js-remove-item-form" class="form-horizontal">
        <input type="hidden" value="$!id" name="id"/>
        <div class="alert alert-info margin-bottom-5">
            <strong>提示!</strong> 您确定要把这个配置项删除吗？
        </div>
    </form>
</div>
<div class="modal-footer">
    <button class="btn btn-circle default btn-sm" data-dismiss="modal" type="button">
        <i class="fa fa-remove"></i> 取消
    </button>
    <a id="js-remove-item-btn" class="btn btn-circle green btn-sm">
        <i class="fa fa-check"></i> 确认删除
    </a>
</div>

<script>
    ConfigJS.removeConfigItem();
</script>