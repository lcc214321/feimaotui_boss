var $addApprovalControlForm = $("#add-approval-control-form");
var $editApprovalControlForm = $("#edit-approval-control-form");
function initFormValidator() {
    $addApprovalControlForm.bootstrapValidator({
        message: '表单输入项格式不正确',
        fields: {

            loginName: {
                message: '账号格式不正确',
                validators: {
                    notEmpty: {
                        message: '账号不能为空'
                    }
                }
            },
            loginPwd: {
                message: '密码格式不正确',
                validators: {
                    stringLength: {
                        min: 6,
                        message: '密码长度不能小于6位'
                    }
                }
            },
            level: {
                message: '级别格式不正确',
                validators: {
                    notEmpty: {
                        message: '级别不能为空'
                    }
                }
            }

        }
    });

    $editApprovalControlForm.bootstrapValidator({
        message: '表单输入项格式不正确',
        fields: {
            loginPwd: {
                message: '密码格式不正确',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    }
                }
            }, level: {
                message: '级别格式不正确',
                validators: {
                    notEmpty: {
                        message: '级别不能为空'
                    }
                }
            }
        }
    });
}