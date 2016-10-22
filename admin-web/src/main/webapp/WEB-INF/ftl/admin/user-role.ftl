<div class="modal-header">
    <h4 class="modal-title">分配角色</h4>
</div>
<div class="modal-body">
    <div>
        <form class="form-horizontal" role="form" action="" id="role-form">
            <input type="hidden" id="id" name="id" value="${id}">

            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-1 control-label"></label>

                    <div class="col-md-11">
                        <select name="roleIds" id="multiRoleIds" class="form-control" multiple="multiple">
                            <#list roleList! as role>
                                <option value="${role.id}" <#if (role.checked) > selected </#if>> ${role.roleName}</option>
                            </#list>
                        </select>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
    <button type="button" class="btn green" onclick="UserJS.saveRoles();">保存</button>
</div>
<script type="text/javascript">
    UserJS.initSelectRole();
</script>