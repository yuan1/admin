<div class="modal-header">
    <button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
    <h4 class="modal-title">修改配置项</h4>
</div>
<div class="modal-body">
    <form method="post" id="js-edit-item-form" class="form-horizontal">
        <input type="hidden" value="${configItem.id}" name="id" id="id"/>
        <input type="hidden" value="${configItem.configId}" name="configId" id="configId" />
        <input type="hidden" value="${configItem.itemId}" name="itemId" id="itemId"/>
        <div class="form-group">
            <label class="col-md-2 control-label" style="width: 100px">
                value <span class="required" aria-required="true"> * </span>
            </label>
            <div class="col-md-10" style="width: 300px">
                <input type="text" value="$!configItem.itemValue" name="itemValue" id="itemValue"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label" style="width: 100px">
                描述 <span class="required" aria-required="true"> * </span>
            </label>
            <div class="col-md-10" style="width: 300px">
                <input type="text" value="$!configItem.itemName" name="itemName" id="itemName"/>
            </div>
        </div>
    </form>
</div>
<div class="modal-footer">
    <button class="btn btn-circle default btn-sm" data-dismiss="modal" type="button">
        <i class="fa fa-remove"></i> 取消
    </button>
    <a id="js-edit-item-btn" class="btn btn-circle green btn-sm">
        <i class="fa fa-check"></i> 确认
    </a>
</div>

<script>
    ConfigJS.updateConfigItem();
</script>