/**
 * Created by chendatao on 2019/4/18.
 */
$(function () {
    initFormValidator();

});
function switchOver($this) {
    $($this).addClass('black');
}
function switchOut($this) {
    $($this).removeClass('black');
}
function foucs($this) {
    $($this).siblings('a').children('div').removeClass('foucs');
    $($this).children('div').addClass('foucs');

}
function logOut() {
    $.ajax({
        url : "/boss/logout",
        type : "POST",
        data : {},
        dataType : "json",
        success : function(data, textStatus) {
            if (data.success) {
                location.href = '/boss/';
                return;
            }
            alert(data.respDesc);

        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        },
        complete : function(XMLHttpRequest, textStatus) {
        }
    });
}
function resetPwd() {
    $('#add-approval-control-dialog').modal('show');
    $('#add-approval-control-dialog').on('shown.bs.modal', function () {
        $("form[id=add-approval-control-form]  input[name=oldPwd]").val("");
        $("form[id=add-approval-control-form]  input[name=newPwd]").val("");
        $("form[id=add-approval-control-form]").bootstrapValidator('resetForm', true);
    });
}
function confirmResetPwd() {
    var data = $("#add-approval-control-form").data('bootstrapValidator');
    if (data) {
        // 修复记忆的组件不验证
        data.validate();
        if (!data.isValid()) {
            return false;
        }
    }
    $.ajax({
        url : "/boss/modifyPwd",
        type : "POST",
        data : $("#add-approval-control-form").serialize(),
        dataType : "json",
        success : function(data, textStatus) {
            if (data.success) {
                alert(data.respDesc);
                location.href = '/boss/';
                return;
            }
            alert(data.respDesc);

        },
        error : function(XMLHttpRequest, textStatus, errorThrown) {
        },
        complete : function(XMLHttpRequest, textStatus) {
        }
    });
}