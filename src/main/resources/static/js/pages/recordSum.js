var $defaultApprovalControlTable = $('#approval-control-table');
var $exportApprovalControlBtton = $('#export-approval-control-btton');

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
}

/**
 * table数据加载方法
 * @param params
 */
function dataList(params) {
    $defaultApprovalControlTable.bootstrapTable('showLoading');
    console.log(params.data);
    $.ajax({
        url: basePath + '/record/dataListSum?limit='
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
    $exportApprovalControlBtton.click(function () {
        var getSelections = $table.bootstrapTable('getSelections');
        $("#alertDeleteDesc").html('确定要导出报表（一次最多导出3000条数据）？');
        $('#confirmDiv').modal('show');
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
    $("#doubleConfirm").click(function () {
            //  export
            $('#confirmDiv').modal('hide');
            window.open("/record/exportSum?" + $("#search-approval-control-form").serialize());


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
