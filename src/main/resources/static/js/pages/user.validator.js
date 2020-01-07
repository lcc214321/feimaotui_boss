var $addApprovalControlForm = $("#add-approval-control-form");
var $editApprovalControlForm = $("#edit-approval-control-form");
function initFormValidator() {
    $addApprovalControlForm.bootstrapValidator({
        message: '表单输入项格式不正确',
        fields: {

            account: {
	                message: '账号格式不正确',
	                validators: {
                        notEmpty: {
                            message: '账号不能为空'
                        }
	                }
	            },
            password: {
	                message: '密码格式不正确',
	                validators: {
                        stringLength: {
                            min:6,
                            message: '密码长度不能小于6位'
                        }
	                }
	            },
            name: {
	                message: '姓名格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: '姓名不能为空'
	                    }
	                }
	            },
            userType: {
	                message: '用户级别格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: '用户级别不能为空'
	                    }
	                }
	            }
	                        
    }});
    
    $editApprovalControlForm.bootstrapValidator({
    message: '表单输入项格式不正确',
    fields: {
        name: {
            message: '姓名格式不正确',
            validators: {
                notEmpty: {
                    message: '姓名不能为空'
                }
            }
        }, userType: {
            message: '用户级别格式不正确',
            validators: {
                notEmpty: {
                    message: '用户级别不能为空'
                }
            }
        }
	                            }});
}