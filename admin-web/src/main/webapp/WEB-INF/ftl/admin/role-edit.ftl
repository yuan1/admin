<div class="modal-header">
    <h4 class="modal-title"><#if (user.id)??>修改用户<#else>新增用户</#if></h4>
</div>
<div class="modal-body">
    <div>
        <form class="form-horizontal" role="form" action="" id="user-form">
            <input type="hidden" id="id" name="id" value="${(user.id)!}">

            <div class="form-body">
                <div class="form-group">
                    <label class="col-md-3 control-label">用户名</label>

                    <div class="col-md-9">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" class="form-control input-inline input-medium"
                                   autocomplete="off"
                                   placeholder="用户名" name="userName" id="userName" value="${(user.userName)!}">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">姓名</label>

                    <div class="col-md-9">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user"></i></span>
                            <input type="text" class="form-control input-inline input-medium"
                                   autocomplete="off"
                                   placeholder="姓名" name="realName" id="realName" value="${(user.realName)!}">
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">手机号</label>

                    <div class="col-md-9">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
                            <input type="mobile" class="form-control input-inline input-medium"
                                   autocomplete="off"
                                   placeholder="手机号" name="mobile" id="mobile" value="${(user.mobile)!}">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-md-3 control-label">Email</label>

                    <div class="col-md-9">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                            <input type="email" class="form-control input-inline input-medium"
                                   autocomplete="off"
                                   placeholder="Email Address" name="email" id="email" value="${(user.email)!}">
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
    <button type="button" class="btn green" onclick="UserJS.submitSave();">保存</button>
</div>