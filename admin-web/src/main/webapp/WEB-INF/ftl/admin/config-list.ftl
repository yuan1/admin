<table class="table table-hover table-bordered margin-bottom-5">
    <thead>
    <tr>
        <th style="text-align: center;"> id</th>
        <th style="text-align: center;"> value</th>
        <th style="text-align: center;"> 描述</th>
        <th style="text-align: center"> 操作</th>
    </tr>
    </thead>
    <tbody>
    <#if (configItemList?size>0) >
        <#list configItemList as item>
        <tr>
            <td style="text-align: center;">${item.itemId}</td>
            <td style="text-align: center;">${item.itemValue}</td>
            <td style="text-align: center;">${item.itemName}</td>
            <td style="text-align: center;">
                <a class="js-ajax-dialog" data-toggle="modal" data-target="#ajax-modal"
                   style="margin-left: 10px"
                   data-url="/admin/config/editItem.do?id=${item.id}"><i class="fa fa-trash"></i> 修改
                </a>
                <a class="js-ajax-dialog" data-toggle="modal" data-target="#ajax-modal"
                   style="margin-left: 10px"
                   data-url="/admin/config/removeItem.do?id=${item.id}"><i class="fa fa-trash"></i> 删除
                </a>
            </td>
        </tr>
        </#list>
    <#else>
        <tr>
            <td colspan="4" style="text-align: center">暂无结果</td>
        </tr>
    </#if>
    </tbody>
</table>