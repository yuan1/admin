<div class="modal-header">
    <h4 class="modal-title"><#if (menu.id)??>修改菜单<#else>新增菜单</#if></h4>
</div>
<div class="modal-body">
    <div>
        <form class="form-horizontal" role="form" action="" id="menu-form">
            <input type="hidden" id="id" name="id" value="${(menu.id)!}">

            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-3 control-label">菜单名</label>

                    <div class="col-md-9">
                        <input type="text" class="form-control input-inline input-medium"
                               autocomplete="off"
                               placeholder="菜单名称" name="menuName" id="menuName" value="${(menu.menuName)!}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">菜单链接</label>

                    <div class="col-md-9">
                        <input type="text" class="form-control input-inline input-medium"
                               autocomplete="off"
                               placeholder="URL" name="menuUrl" id="menuUrl" value="${(menu.menuUrl)!}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">排序</label>

                    <div class="col-md-9">
                        <input type="text" class="form-control input-inline input-medium"
                               autocomplete="off"
                               placeholder="排序" name="menuOrder" id="menuOrder" value="${(menu.menuOrder)!}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">父菜单</label>

                    <div class="col-md-9">
                        <select name="parentId"  id="parentId" >
                            <#list menuList! as pamenu>
                                <option value="${pamenu.id}" <#if (pamenu.id) == (parentMenu.id) > selected </#if>> ${pamenu.menuName}</option>
                            </#list>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">菜单图标</label>

                    <div class="col-md-9">
                        <input type="text" class="form-control input-inline input-medium"
                               autocomplete="off" name="menuIcon" id="menuIcon" value="${(menu.menuIcon)!}">
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
    <button type="button" class="btn green" onclick="MenuJs.saveMenu();">保存</button>
</div>