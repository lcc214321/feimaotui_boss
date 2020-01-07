var $addApprovalControlForm = $("#add-approval-control-form");
var $editApprovalControlForm = $("#edit-approval-control-form");
function initFormValidator() {
    $addApprovalControlForm.bootstrapValidator({
        message: '表单输入项格式不正确',
        fields: {

            tag: {
	                message: 'tag格式不正确',
	                validators: {
                        stringLength :{
	                        max:20,
	                        message:'tag 长度不能超过20'
                        }
	                }
	            },
            infoCode: {
	                message: 'info Code格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: 'info Code不能为空'
	                    },
                        stringLength :{
	                        max:32,
	                        message:'info Code 长度不能超过32'
                        }
	                }
	            },

            appCode: {
	                message: '应用编码格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: '应用编码不能为空'
	                    },
                        stringLength :{
                            max:10,
                            message:'应用编码 长度不能超过10'
                        }
	                }
	            },

            simplfiedCnDesc: {
	                message: '简体中文描述格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: '简体中文描述不能为空'
	                    }
                        ,
                        stringLength :{
                            max:200,
                            message:'简体中文 长度不能超过200'
                        }
	                }
	            },

            traditionalCnDesc: {
	                message: '繁体中文描述格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: '繁体中文描述不能为空'
	                    } ,
                        stringLength :{
                            max:200,
                            message:'繁体中文 长度不能超过200'
                        }
	                }
	            },

            enDesc: {
	                message: '英文描述格式不正确',
	                validators: {
	                    notEmpty: {
	                        message: '英文描述不能为空'
	                    } ,
                        stringLength :{
                            max:200,
                            message:'英文描述 长度不能超过200'
                        }
	                }
	            }
	                        
    }});
    
    $editApprovalControlForm.bootstrapValidator({
    message: '表单输入项格式不正确',
    fields: {
        tag: {
            message: 'tag格式不正确',
            validators: {
                stringLength :{
                    max:20,
                    message:'tag 长度不能超过20'
                }
            }
        },
        simplfiedCnDesc: {
            message: '简体中文描述格式不正确',
            validators: {
                notEmpty: {
                    message: '简体中文描述不能为空'
                },
                stringLength :{
                    max:200,
                    message:'简体中文 长度不能超过200'
                }
            }
        },

        traditionalCnDesc: {
            message: '繁体中文描述格式不正确',
            validators: {
                notEmpty: {
                    message: '繁体中文描述不能为空'
                },
                stringLength :{
                    max:200,
                    message:'繁体中文 长度不能超过200'
                }
            }
        },

        enDesc: {
            message: '英文描述格式不正确',
            validators: {
                notEmpty: {
                    message: '英文描述不能为空'
                },
                stringLength :{
                    max:200,
                    message:'英文描述 长度不能超过200'
                }
            }
        }
	                            }});
}