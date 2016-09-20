<div id="add-modal" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                <h4 class="modal-title">新增用户</h4>
            </div>
            <div class="modal-body">
                <div>
                    <form class="form-horizontal" role="form" action="#" id="user-edit-form">
                        <input type="hidden" id="id" name="id">

                        <div class="form-body">
                            <div class="form-group">
                                <label class="col-md-3 control-label">用户名</label>

                                <div class="col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input type="text" class="form-control input-inline input-medium"
                                               autocomplete="off" value="${user.userName}"
                                               placeholder="用户名" name="userName" id="userName">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">姓名</label>

                                <div class="col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                                        <input type="text" class="form-control input-inline input-medium"
                                               autocomplete="off" value="${user.realName}"
                                               placeholder="姓名" name="realName" id="realName">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label">手机号</label>

                                <div class="col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-mobile"></i></span>
                                        <input type="mobile" class="form-control input-inline input-medium"
                                               autocomplete="off" value="${user.mobile}"
                                               placeholder="手机号" name="mobile" id="mobile">
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-md-3 control-label">Email</label>

                                <div class="col-md-9">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
                                        <input type="email" class="form-control input-inline input-medium"
                                               autocomplete="off" value="${user.email}"
                                               placeholder="Email Address" name="email" id="email">
                                    </div>
                                </div>
                            </div>

                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" data-dismiss="modal" class="btn dark btn-outline">取消</button>
                <button type="button" class="btn green" onclick="UserJS.updateUser();">保存</button>
            </div>
        </div>
    </div>
</div>