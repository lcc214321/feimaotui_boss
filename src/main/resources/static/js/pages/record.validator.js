var $addApprovalControlForm = $("#add-approval-control-form");
function initFormValidator() {
    $addApprovalControlForm.bootstrapValidator({
        message: '表单输入项格式不正确',
        fields: {

            userName: {
                message: '业务员格式不正确',
                validators: {
                    notEmpty: {
                        message: '业务员不能为空'
                    }
                }
            },
            createdDate: {
                trigger: "change",
                message: '创建时间格式不正确',
                validators: {
                    notEmpty: {
                        message: '创建时间不能为空'
                    }
                }
            },
            num: {
                message: '数量格式不正确',
                validators: {
                    notEmpty: {
                        message: '数量不能为空'
                    },
                    numeric: {
                        message: '数量必须为数字'
                    }
                }
            }

        }
    });

}