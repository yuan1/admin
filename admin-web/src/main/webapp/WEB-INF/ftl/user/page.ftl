<table class="table table-bordered table-hover">
    <thead>
    <tr>
        <th style="text-align: center">id</th>
        <th style="text-align: center">用户名</th>
        <th style="text-align: center">姓名</th>
        <th style="text-align: center">手机号</th>
        <th style="text-align: center">邮箱</th>
        <th style="text-align: center">状态</th>
        <th style="text-align: center">创建时间</th>
        <th style="text-align: center">操作</th>
    </tr>
    </thead>
    <tbody>
        <#if userList?exists && userList?size&gt;0 >
            <#list userList as user>
                <tr>
                    <td style="text-align: center">${user.id}</td>
                    <td style="text-align: center">${user.userName}</td>
                    <td style="text-align: center">${user.realName}</td>
                    <td style="text-align: center">${user.mobile}</td>
                    <td style="text-align: center">${user.email}</td>
                    <td style="text-align: center">${user.userStatusText}</td>
                    <td style="text-align: center">${user.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                    <td style="text-align: center">
                        <a class="btn btn-circle btn-primary" onclick="ModalJS.open('ajax-modal','/admin/user/getUserById.do?id='+${user.id});">
                            <i class="icon-edit"></i>修改</a>
                        <a class="btn btn-circle btn-danger"  onclick="UserJS.toRemove('${user.id}')"><i class="icon-remove"></i>删除</a>
                    </td>
                </tr>
            </#list>
        <#else>
            <tr>
                <td colspan="8" style="text-align: center">暂无数据</td>
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
        UserJS.initPage('${pageInfo.pages}', '${pageInfo.pageNum}');
    </script>
</div>