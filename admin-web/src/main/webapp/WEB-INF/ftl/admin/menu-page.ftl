<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th style="text-align: center">id</th>
        <th style="text-align: center">菜单名称</th>
        <th style="text-align: center">菜单URL</th>
        <th style="text-align: center">菜单类型</th>
        <th style="text-align: center">排序</th>
        <th style="text-align: center">创建时间</th>
        <th style="text-align: center">操作</th>
    </tr>
    </thead>
    <tbody>
        <#if subMenuList?exists && subMenuList?size&gt;0 >
            <#list subMenuList as menu>
                <tr>
                    <td style="text-align: center">${menu.id}</td>
                    <td style="text-align: center">${menu.menuName}</td>
                    <td style="text-align: center">${menu.menuUrl}</td>
                    <td style="text-align: center">${menu.menuType}</td>
                    <td style="text-align: center">${menu.menuOrder}</td>
                    <td style="text-align: center">${menu.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td style="text-align: center">
                        <a class="btn btn-circle btn-primary" onclick="ModalJS.open('ajax-modal','/admin/menu/getById.do?id='+${menu.id});">
                            <i class="icon-edit"></i>修改</a>
                        <a class="btn btn-circle btn-danger"  onclick="MenuJs.toRemove('${menu.id}')"><i class="icon-remove"></i>删除</a>
                    </td>
                </tr>
            </#list>
        <#else>
            <tr>
                <td colspan="9" style="text-align: center">暂无数据</td>
            </tr>
        </#if>

    </tbody>
</table>
</div>