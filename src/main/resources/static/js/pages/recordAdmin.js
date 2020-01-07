var $defaultApprovalControlTable = $('#approval-control-table');
var $addApprovalControlBtton = $('#add-approval-control-btton');
var $addApprovalControlExeBtton = $('#add-approval-control-exe-btton');
var $editApprovalControlBtton = $('#edit-approval-control-btton');
var $delApprovalControlBtton = $('#del-approval-control-btton');
var $exportApprovalControlBtton = $('#export-approval-control-btton');
var $editApprovalControlExeBtton = $('#edit-approval-control-exe-btton');
var selectionsApprovalControl = [];
$table = $("#approval-control-table");
var currid;
$(function () {
    // $("#addprice").oninput(function () {
    //
    // });
    // $("#editprice").oninput(function () {
    //
    // });

});
/**
 * 页面初始化方法
 */
function initApprovalControlPage() {
    initTable();
    initButton();
    initDialog();
    $('#addrecordType').val("销售");
    $('#hiddenaddRecordType').bootstrapSwitch({
        onText: '进货',
        offText: '销售',
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $('#addrecordType').val("进货");
                $("#typeMerchant").show();
                $("#typeConsumer").hide();

            } else {
                $('#addrecordType').val("销售");
                $("#typeConsumer").show();
                $("#typeMerchant").hide();
            }
        }
    });
    $('#editRecordType').val("销售");
    $('#hiddeneditRecordType').bootstrapSwitch({
        onText: '进货',
        offText: '销售',
        onColor: "success",
        offColor: "info",
        size: "small",
        onSwitchChange: function (event, state) {
            if (state == true) {
                $('#editRecordType').val("进货");
                $("#editMerchantType").show();
                $("#editConsumerType").hide();

            } else {
                $('#editRecordType').val("销售");
                $("#editConsumerType").show();
                $("#editMerchantType").hide();
            }
        }
    });
}

/**
 * table数据加载方法
 * @param params
 */
function dataList(params) {
    $defaultApprovalControlTable.bootstrapTable('showLoading');
    console.log(params.data);
    $.ajax({
        url: basePath + '/record/dataList?limit='
        + params.data.limit + '&offset=' + params.data.offset,
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
        $("form[id=search-approval-control-form]  input[name=userName]").val("");
        $("form[id=search-approval-control-form]  select[name=recordType]").val("");
        $("form[id=search-approval-control-form]  input[name=merchant]").val("");
        $("form[id=search-approval-control-form]  input[name=consumer]").val("");
        $("form[id=search-approval-control-form]  input[name=paperType]").val("");
        $("form[id=search-approval-control-form]  input[name=startTime]").val("");
        $("form[id=search-approval-control-form]  input[name=endTime]").val("");
    });
    /**
     * table上方按钮事件（添加）
     */
    $addApprovalControlBtton.click(function () {
        $('#add-approval-control-dialog').on('shown.bs.modal', function () {
            //$('#myInput').focus()
            $("form[id=add-approval-control-form]  input[name=companyName]").val("");
            $("form[id=add-approval-control-form]  input[name=userName]").val("");
            $("#typeConsumer").show();
            $("#typeMerchant").hide();
            $("form[id=add-approval-control-form]  input[name=recordType]").val("销售");
            $("form[id=add-approval-control-form]  input[name=paperType]").val("");
            $("form[id=add-approval-control-form]  input[name=createdDate]").val("");
            $("form[id=add-approval-control-form]  input[name=merchant]").val("");
            $("form[id=add-approval-control-form]  input[name=consumer]").val("");
            $("form[id=add-approval-control-form]  input[name=weight]").val("");
            $("form[id=add-approval-control-form]  input[name=standard]").val("");
            $("form[id=add-approval-control-form]  input[name=num]").val("");
            $("form[id=add-approval-control-form]  input[name=price]").val("");
            $("form[id=add-approval-control-form]  input[name=totalMoney]").val("");
            $("form[id=add-approval-control-form]  input[name=remark]").val("");
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
            url: basePath + "/record/save",
            type: "POST",
            data: $("#add-approval-control-form").serialize(),
            dataType: "json",
            success: function (data, textStatus) {
                alert(data.msg);

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
                $("form[id=edit-approval-control-form]  input[name=id]").val(curOrder.id);
                $("form[id=edit-approval-control-form]  input[name=companyName]").val(curOrder.companyName);
                $("form[id=edit-approval-control-form]  input[name=userName]").val(curOrder.userName);
                $("form[id=edit-approval-control-form]  input[name=recordType]").val(curOrder.recordType);
                $("form[id=edit-approval-control-form]  input[name=createdDate]").val(dateFormatter(curOrder.createdDate));
                $("form[id=edit-approval-control-form]  input[name=paperType]").val(curOrder.paperType);
                $("form[id=edit-approval-control-form]  input[name=merchant]").val(curOrder.merchant);
                $("form[id=edit-approval-control-form]  input[name=consumer]").val(curOrder.consumer);
                $("form[id=edit-approval-control-form]  input[name=weight]").val(curOrder.weight);
                $("form[id=edit-approval-control-form]  input[name=standard]").val(curOrder.standard);
                $("form[id=edit-approval-control-form]  input[name=num]").val(curOrder.num);
                $("form[id=edit-approval-control-form]  input[name=price]").val(curOrder.price);
                $("form[id=edit-approval-control-form]  input[name=totalMoney]").val(curOrder.totalMoney);
                $("form[id=edit-approval-control-form]  input[name=remark]").val(curOrder.remark);
                if ('进货' == curOrder.recordType) {
                    setTimeout(function () {
                        $("#hiddeneditRecordType").bootstrapSwitch('state', true);
                        //    隐藏
                        $("#typeMerchant").show();
                        $("#typeConsumer").hide();

                    }, 100)
                } else {
                    setTimeout(function () {
                        $("#hiddeneditRecordType").bootstrapSwitch('state', false);
                        $("#typeConsumer").show();
                        $("#typeMerchant").hide();
                    }, 100)

                }
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
            url: basePath + "/record/modify",
            type: "POST",
            data: $("#edit-approval-control-form").serialize(),
            dataType: "json",
            success: function (data, textStatus) {
                alert(data.msg);

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
            currid = curOrder.id;
            $("#confirmType").val('del');
            $("#alertDeleteDesc").html('确定要删除此记录？');
            $('#confirmDiv').modal('show');
        }
    });
    $exportApprovalControlBtton.click(function () {
        var getSelections = $table.bootstrapTable('getSelections');
        $("#confirmType").val('export');
        $("#alertDeleteDesc").html('确定要导出报表（一次最多导出3000条数据）？');
        $('#confirmDiv').modal('show');
    });

    $("#doubleConfirm").click(function () {
        var val = $("#confirmType").val();
        if ('del' == val) {
            $.ajax({
                url: basePath + '/record/delete',
                type: "post",
                data: {id: currid},
                dataType: "json",
                success: function (data) {
                    if (data.status) {
                        alert(data.msg);
                        $('#confirmDiv').modal('hide');
                        //刷新表格
                        $table.bootstrapTable('refresh');
                    } else {
                        alert(data.msg);
                    }
                }
            });
        } else {
            //  export
            $('#confirmDiv').modal('hide');
            window.open("/record/export?" + $("#search-approval-control-form").serialize());

            // $.ajax({
            //     url: basePath + '/record/export',
            //     type: "get",
            //     data: $("#search-approval-control-form").serialize(),
            //     dataType: "json",
            //     success: function (data) {
            //         if (data.status) {
            //             alert(data.msg);
            //             $('#confirmDiv').modal('hide');
            //             //刷新表格
            //             $table.bootstrapTable('refresh');
            //         } else {
            //             alert(data.msg);
            //         }
            //     }
            // });
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
function addpriceF() {
    var val = $("#addprice").val();
    var val2 = $("#addnum").val();
    if ( val && val2) {
        var number = parseFloat(val2) * parseFloat(val);
        $("#addtotalMoney").val(number);
    }
}
function editpriceF() {
    var val = $("#editprice").val();
    var val2 = $("#editnum").val();
    if ( val && val2) {
        var number = parseFloat(val2) * parseFloat(val);
        $("#edittotalMoney").val(number);
    }
}
function dateFormatter(value) {
    if (!value) {
        return value;
    }
    var dateVal = new Date(new Date(value).getTime());
    var year = dateVal.getFullYear();
    var month = dateVal.getMonth() + 1;
    var date = dateVal.getDate();
    var hour = dateVal.getHours();
    var minute = dateVal.getMinutes();
    var second = dateVal.getSeconds();

    year = year < 10 ? '0' + year : year;
    month = month < 10 ? '0' + month : month;
    date = date < 10 ? '0' + date : date;
    hour = hour < 10 ? '0' + hour : hour;
    minute = minute < 10 ? '0' + minute : minute;
    second = second < 10 ? '0' + second : second;
    // commonTime = dateVal.toString();
    commonTime = year+"-"+month+"-"+date+" "+hour + ":" + minute + ":" + second;
    return commonTime;
}