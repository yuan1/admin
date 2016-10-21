<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th style="text-align: center">id</th>
        <th style="text-align: center">角色名</th>
        <th style="text-align: center">创建时间</th>
        <th style="text-align: center">修改时间</th>
        <th style="text-align: center">操作</th>
    </tr>
    </thead>
    <tbody>
        <#if roleList?exists && roleList?size&gt;0 >
            <#list roleList as role>
                <tr>
                    <td style="text-align: center">${role.id}</td>
                    <td style="text-align: center">${role.roleName}</td>
                    <td style="text-align: center">${role.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td style="text-align: center">${role.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td style="text-align: center">
                        <a class="btn btn-circle btn-primary" onclick="ModalJS.open('ajax-modal','/admin/role/getById.do?id='+${role.id});">
                            <i class="icon-edit"></i>修改</a>
                        <a class="btn btn-circle btn-danger"  onclick="RoleJS.toRemove('${role.id}')"><i class="icon-remove"></i>删除</a>
                    </td>
                </tr>
            </#list>
        <#else>
            <tr>
                <td colspan="5" style="text-align: center">暂无数据</td>
            </tr>
        </#if>

    </tbody>
</table>

<div class="row">
    <div class="col-md-6 pull-left">
        <p style="margin-bottom: 0px;line-height: 55px;">总共${pageInfo.total}个记录&nbsp;每页${pageInfo.pageSize}
            &nbsp;当前${pageInfo.pageNum}</p>
    </div>
    <div class="col-md-6 pull-right" id="js-bootpag" style="text-align: right"></div>
    <script type="text/javascript">
        RoleJS.initPage('${pageInfo.pages}', '${pageInfo.pageNum}');
    </script>
</div>