<div class="modal-header">
    <h4 class="modal-title">分配菜单</h4>
</div>
<div class="modal-body">
    <div>
        <input type="hidden" id="id" name="id" value="${id}">

        <div id="menu-tree">

        </div>
    </div>
</div>
<div class="modal-footer" style="text-align: center">
    <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
    <button type="button" class="btn green" onclick="RoleJS.saveRoleMenus();">保存</button>
</div>
<script type="text/javascript">
    RoleJS.initMenuTree();
</script>