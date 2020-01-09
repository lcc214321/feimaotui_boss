var $defaultApprovalControlTable = $('#approval-control-table');
var $addApprovalControlBtton = $('#add-approval-control-btton');
var $addApprovalControlExeBtton = $('#add-approval-control-exe-btton');
var $editApprovalControlBtton = $('#edit-approval-control-btton');
var $delApprovalControlBtton = $('#del-approval-control-btton');
var $frozeApprovalControlBtton = $('#froze-approval-control-btton');
var $normalApprovalControlBtton = $('#normal-approval-control-btton');
var $resetpwdApprovalControlBtton = $('#resetpwd-approval-control-btton');
var $editApprovalControlExeBtton = $('#edit-approval-control-exe-btton');
var selectionsApprovalControl = [];
$table = $("#approval-control-table");
var currAccount;
$(function () {
    $table.bootstrapTable({singleSelect: true})

    // $(":input[name='btSelectItem']:checkbox").click(function () {
    //     var ss = $(":input[name='btSelectItem']:checkbox");
    //     clickedCheckBox($(":input[name='btSelectAll']:checkbox"), false);
    //
    //     for (var i = 0; i < ss.length; i++) {
    //         clickedCheckBox(ss.eq(i), false);
    //     }
    //     clickedCheckBox(this, true);
    // });
});
/**
 * 页面初始化方法
 */
function initApprovalControlPage() {
    initTable();
    initButton();
    initDialog();
    // $('#addSex').val("女");
    // $('#hiddenaddSex').bootstrapSwitch({
    //     onText: '男',
    //     offText: '女',
    //     onColor: "success",
    //     offColor: "info",
    //     size: "small",
    //     onSwitchChange: function (event, state) {
    //         if (state == true) {
    //             $('#addSex').val("男");
    //         } else {
    //             $('#addSex').val("女");
    //         }
    //     }
    // });
    // $('#editSex').val("女");
    // $('#hiddeneditSex').bootstrapSwitch({
    //     onText: '男',
    //     offText: '女',
    //     onColor: "success",
    //     offColor: "info",
    //     size: "small",
    //     onSwitchChange: function (event, state) {
    //         if (state == true) {
    //             $('#editSex').val("男");
    //         } else {
    //             $('#editSex').val("女");
    //         }
    //     }
    // });
}

/**
 * table数据加载方法
 * @param params
 */
function dataList(params) {
    $defaultApprovalControlTable.bootstrapTable('showLoading');
    console.log(params.data);
    $.ajax({
        url: basePath + '/boss/queryList?end='
        + params.data.limit + '&first=' + params.data.offset,
        type: "post",
        data: $("#search-approval-control-form").serialize(),
        dataType: "json",
        success: function (result, textStatus) {
            params.success(result);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        },
        complete: function (XMLHttpRequest, textStatus) {
            $defaultApprovalControlTable.bootstrapTable('hideLoading');
        }
    });
}

/**
 * table初始化方法
 */
function initTable() {
    $defaultApprovalControlTable.on('check.bs.table uncheck.bs.table ' +
        'check-all.bs.table uncheck-all.bs.table', function () {
        $editApprovalControlBtton.prop('disabled', !($defaultApprovalControlTable.bootstrapTable('getSelections').length == 1));
        $delApprovalControlBtton.prop('disabled', !($defaultApprovalControlTable.bootstrapTable('getSelections').length == 1));
        $frozeApprovalControlBtton.prop('disabled', !($defaultApprovalControlTable.bootstrapTable('getSelections').length == 1));
        $normalApprovalControlBtton.prop('disabled', !($defaultApprovalControlTable.bootstrapTable('getSelections').length == 1));
        $resetpwdApprovalControlBtton.prop('disabled', !($defaultApprovalControlTable.bootstrapTable('getSelections').length == 1));
        // save your data, here just save the current page
        selectionsApprovalControl = getIdSelectionsApprovalControl();
        // push or splice the selections if you want to save all data selections
    });
    $defaultApprovalControlTable.on('all.bs.table', function (e, name, args) {
        console.log(name, args);
    });

    $(window).resize(function () {
        $defaultApprovalControlTable.bootstrapTable('resetView', {
            height: getHeight()
        });
    });
}

/**
 * 按钮初始化方法
 */
function initButton() {

    /**
     * 查询按钮初始化
     */
    $("#search-approval-control-btton").click(function () {
        $defaultApprovalControlTable.bootstrapTable('refresh', null);
    });

    /**
     * 重置按钮初始化
     */
    $("#reset-approval-control-btton").click(function () {
        $("form[id=search-approval-control-form]  input[name=loginName]").val("");
    });
    /**
     * table上方按钮事件（添加）
     */
    $addApprovalControlBtton.click(function () {
        $('#add-approval-control-dialog').on('shown.bs.modal', function () {
            //$('#myInput').focus()
            $("form[id=add-approval-control-form]  input[name=loginName]").val("");
            $("form[id=add-approval-control-form]  input[name=loginPwd]").val("");
            $("form[id=add-approval-control-form]  input[name=level]").val("");
            $("form[id=add-approval-control-form]").bootstrapValidator('resetForm', true);
        });
    });
    /**
     * 按钮执行区域（添加）
     */
    $addApprovalControlExeBtton.click(function () {
        console.log(JSON.stringify($("#add-approval-control-form").serialize()));
        var data = $("#add-approval-control-form").data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
        }
        $.ajax({
            url: basePath + "/boss/createUser",
            type: "POST",
            data: $("#add-approval-control-form").serialize(),
            dataType: "json",
            success: function (data, textStatus) {
                alert(data.respDesc);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            complete: function (XMLHttpRequest, textStatus) {
                // location.href=location.href;
                $('#add-approval-control-dialog').modal('hide');
                $defaultApprovalControlTable.bootstrapTable('refresh', null);
                $defaultApprovalControlTable.bootstrapTable('uncheckAll');
            }
        });
    });

    /**
     * table上方按钮事件（编辑）
     */
    $editApprovalControlBtton.click(function () {
        var id = selectionsApprovalControl[0];
        console.log(id);


        $('#edit-approval-control-dialog').on('shown.bs.modal', function () {
            var getSelections = $table.bootstrapTable('getSelections');
            if (getSelections && getSelections.length == 1) {
                var curOrder = getSelections[0];
                $("form[id=edit-approval-control-form]  input[name=loginName]").val(curOrder.loginName);
                $("form[id=edit-approval-control-form]  input[name=loginPwd]").val(curOrder.loginPwd);
                $("form[id=edit-approval-control-form]  select[name=level]").val(curOrder.level);
                $("form[id=edit-approval-control-form]  input[name=id]").val(curOrder.id);
            }
        });
        $('#edit-approval-control-dialog').modal('show');

    });

    /**
     * 按钮执行区域（编辑）
     */
    $editApprovalControlExeBtton.click(function () {
        console.log(JSON.stringify($("#edit-approval-control-form").serialize()));
        var data = $("#edit-approval-control-form").data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
        }
        $.ajax({
            url: basePath + "/boss/modifyBossUser",
            type: "POST",
            data: $("#edit-approval-control-form").serialize(),
            dataType: "json",
            success: function (data, textStatus) {
                alert(data.respDesc);

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
            },
            complete: function (XMLHttpRequest, textStatus) {
                $('#edit-approval-control-dialog').modal('hide');
                $defaultApprovalControlTable.bootstrapTable('refresh', null);
                $defaultApprovalControlTable.bootstrapTable('uncheckAll');
            }
        });
    });
    $delApprovalControlBtton.click(function () {
        var getSelections = $table.bootstrapTable('getSelections');
        if (getSelections && getSelections.length == 1) {
            var curOrder = getSelections[0];
            currAccount = curOrder.loginName;
            $("#confirmType").val('del');
            $("#alertDeleteDesc").html('确定要删除此员工？');
            $('#confirmDiv').modal('show');
        }
    });
    $frozeApprovalControlBtton.click(function () {
        var getSelections = $table.bootstrapTable('getSelections');
        if (getSelections && getSelections.length == 1) {
            var curOrder = getSelections[0];
            currAccount = curOrder.loginName;
            $("#confirmType").val('froze');
            $("#alertDeleteDesc").html('确定要冻结此员工？');
            $('#confirmDiv').modal('show');
        }
    });
    $normalApprovalControlBtton.click(function () {
        var getSelections = $table.bootstrapTable('getSelections');
        if (getSelections && getSelections.length == 1) {
            var curOrder = getSelections[0];
            currAccount = curOrder.loginName;
            $("#confirmType").val('normal');
            $("#alertDeleteDesc").html('确定要解冻此员工？');
            $('#confirmDiv').modal('show');
        }
    });
    $resetpwdApprovalControlBtton.click(function () {
        var getSelections = $table.bootstrapTable('getSelections');
        if (getSelections && getSelections.length == 1) {
            var curOrder = getSelections[0];
            currAccount = curOrder.loginName;
            $("#confirmType").val('resetPwd');
            $("#alertDeleteDesc").html('确定要重置此员工密码为123456？');
            $('#confirmDiv').modal('show');
        }
    });

    $("#doubleConfirm").click(function () {
        var val = $("#confirmType").val();
        if ('del' == val) {
            $.ajax({
                url: basePath + '/boss/delete',
                type: "post",
                data: {loginName: currAccount},
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        alert(data.respDesc);
                        $('#confirmDiv').modal('hide');
                        //刷新表格
                        $table.bootstrapTable('refresh');
                    } else {
                        alert(data.respDesc);
                    }
                }
            });
        } else if ('froze' == val) {
            $.ajax({
                url: basePath + '/boss/switchStatus',
                type: "post",
                data: {loginName: currAccount, status: 'FREEZE'},
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        alert(data.respDesc);
                        $('#confirmDiv').modal('hide');
                        //刷新表格
                        $table.bootstrapTable('refresh');
                    } else {
                        alert(data.respDesc);
                    }
                }
            });
        } else if ('resetPwd' == val) {
            $.ajax({
                url: basePath + '/boss/resetPwd',
                type: "post",
                data: {loginName: currAccount},
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        alert(data.respDesc);
                        $('#confirmDiv').modal('hide');
                        //刷新表格
                        $table.bootstrapTable('refresh');
                    } else {
                        alert(data.respDesc);
                    }
                }
            });
        } else {
            // normal
            $.ajax({
                url: basePath + '/boss/switchStatus',
                type: "post",
                data: {loginName: currAccount, status: 'EFFECT'},
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        alert(data.respDesc);
                        $('#confirmDiv').modal('hide');
                        //刷新表格
                        $table.bootstrapTable('refresh');
                    } else {
                        alert(data.respDesc);
                    }
                }
            });
        }

    });
}

/**
 * 初始化弹出面板
 */
function initDialog() {
    $('#add-approval-control-dialog').modal({
        keyboard: false
    });
    $('#edit-approval-control-dialog').modal({
        keyboard: false
    });

    $('#add-approval-control-dialog').modal('hide');
    $('#edit-approval-control-dialog').modal('hide');
}

/**
 * 获取选中的table项目UUID
 * @returns {*}
 */
function getIdSelectionsApprovalControl() {
    return $.map($defaultApprovalControlTable.bootstrapTable('getSelections'), function (row) {
        return row.id

    });
}

function getHeight() {

}

// 数据表格展开内容
function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        html.push('<p><b>' + key + ':</b> ' + value + '</p>');
    });
    return html.join('');
}

function clickedCheckBox(_this, flag) {
    if (_this.prop('checked') && !flag) {
        _this.trigger('click');
    }
    if (!_this.prop('checked') && flag) {
        _this.trigger('click');
    }
}