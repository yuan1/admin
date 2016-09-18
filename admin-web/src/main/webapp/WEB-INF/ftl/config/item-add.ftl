<div class="modal-header">
    <button aria-hidden="true" data-dismiss="modal" class="close" type="button"></button>
    <h4 class="modal-title">新增 <label style="color: red">${config.configDesc} </label> 的配置项</h4>
</div>
<div class="modal-body">
    <form method="post" id="js-add-item-form" class="form-horizontal">
        <input type="hidden" value="$!config.id" name="configId" id="configId"/>
        <div class="form-group">
            <label class="col-md-2 control-label" style="width: 100px">
                id <span class="required" aria-required="true"> * </span>
            </label>
            <div class="col-md-10" style="width: 300px">
                <input type="text" value="" name="itemId" id="itemId"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label" style="width: 100px">
                value <span class="required" aria-required="true"> * </span>
            </label>
            <div class="col-md-10" style="width: 300px">
                <input type="text" value="" name="itemValue" id="itemValue"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-md-2 control-label" style="width: 100px">
                描述 <span class="required" aria-required="true"> * </span>
            </label>
            <div class="col-md-10" style="width: 300px">
                <input type="text" value="" name="itemName" id="itemName"/>
            </div>
        </div>

    </form>
</div>
<div class="modal-footer">
    <button class="btn btn-circle default btn-sm" data-dismiss="modal" type="button">
        <i class="fa fa-remove"></i> 取消
    </button>
    <a id="js-add-item-btn" class="btn btn-circle green btn-sm">
        <i class="fa fa-check"></i> 确认添加
    </a>
</div>

<script>
    ConfigJS.addConfigItem();
</script>