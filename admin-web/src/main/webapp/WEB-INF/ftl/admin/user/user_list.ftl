<!DOCTYPE html>
<html lang="zh_CN">
<head>
</head>
<body class="no-class">
<div class="row">
    <form class="form-inline">
        <div class="form-group">
            <label class="sr-only" for="userName">用户名：</label>
            <input type="text" class="form-control" id="userName" placeholder="请输入用户名">
        </div>

        <div class="form-group">
            <label class="sr-only" for="mobile">手机号：</label>
            <input type="text" class="form-control" id="mobile" placeholder="请输入手机号">
        </div>

        <div class="form-group">
            <label class="sr-only" for="email">邮箱：</label>
            <input type="text" class="form-control" id="email" placeholder="请输入邮箱">
        </div>
        <button class="btn btn-success">查询</button>
        <button class="btn">重置</button>
    </form>

    <div class="space-6">
        <table class="table table-striped table-bordered table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>用户名</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>注册时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>fangli</td>
                <td>18610508781</td>
                <td>312383161@qq.com</td>
                <td>
                    <button class="btn btn-default">编辑</button>
                    <button class="btn btn-danger">删除</button>
                </td>
            </tr>
            </tbody>

        </table>
    </div>
</div>
</body>
</html>