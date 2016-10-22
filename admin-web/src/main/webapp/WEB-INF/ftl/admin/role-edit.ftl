<div class="modal-header">
    <h4 class="modal-title"><#if (role.id)??>修改角色<#else>新增角色</#if></h4>
</div>
<div class="modal-body">
    <div>
        <form class="form-horizontal" role="form" action="" id="role-form">
            <input type="hidden" id="id" name="id" value="${(role.id)!}">

            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-3 control-label">角色名</label>

                    <div class="col-md-9">
                        <input type="text" class="form-control input-inline input-medium" autocomplete="off"
                            placeholder="用户名" name="roleName" id="roleName" value="${(role.roleName)!}">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
    <button type="button" class="btn green" onclick="RoleJS.submitSave();">保存</button>
</div>