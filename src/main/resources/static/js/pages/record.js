var $defaultApprovalControlTable = $('#approval-control-table');
var $addApprovalControlBtton = $('#add-approval-control-btton');
var $addApprovalControlExeBtton = $('#add-approval-control-exe-btton');
var selectionsApprovalControl = [];
$table = $("#approval-control-table");
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

}

/**
 * 初始化弹出面板
 */
function initDialog() {
    $('#add-approval-control-dialog').modal({
        keyboard: false
    });

    $('#add-approval-control-dialog').modal('hide');
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